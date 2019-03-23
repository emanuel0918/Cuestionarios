package com.controler;

import com.modelo.dao.EvaluacionDAO;
import com.modelo.dao.PreguntasDAO;
import com.modelo.entidades.Evaluacion;
import com.modelo.entidades.Preguntas;
import com.modelo.entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class controladorEvaluacion extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            int idCuestionario = Integer.parseInt(request.getParameter("Cuestionarioid"));
            
            List<String> Respuestas = new ArrayList();
            for(int i=1; i<=2; i++){
                String Respuesta = request.getParameter("Respuesta"+i);
                Respuestas.add(Respuesta);
            }
           
            PreguntasDAO pdao = new PreguntasDAO();
            List<Preguntas> listaPreguntas = pdao.SeleccionaPreguntas(idCuestionario);
            int aciertos = 0;
            int count = 0;
            for(Preguntas pregunta: listaPreguntas){             
                if(pregunta.getRespuesta().equals(Respuestas.get(count))){
                    aciertos = aciertos + 1;
                }
                count = count + 1;
            }
            
            Evaluacion evaluacion = new Evaluacion();
            evaluacion.setCalificacionEvaluacion(aciertos);
            evaluacion.setNombreEvaluacion(listaPreguntas.get(0).getIdCuestionario().getNombreCuestionario());
            HttpSession sesion = request.getSession();
            Usuario usuario = (Usuario) sesion.getAttribute("User");
            evaluacion.setIdUsuario(usuario);
            
            EvaluacionDAO edao = new EvaluacionDAO();
            edao.RegistraEvaluacion(evaluacion);
            
            List<Evaluacion> listaEvaluaciones = new ArrayList();
            listaEvaluaciones =  edao.LeeEvaluaciones(usuario.getIdUsuario());
            
            out.println(evaluacion.getCalificacionEvaluacion());
            out.println(evaluacion.getNombreEvaluacion());
            out.println(evaluacion.getIdUsuario().getIdPersona().getNombre());
           
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(controladorEvaluacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(controladorEvaluacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(controladorEvaluacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(controladorEvaluacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
