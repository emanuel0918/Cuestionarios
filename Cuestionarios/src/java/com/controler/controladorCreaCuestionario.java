package com.controler;

import com.modelo.dao.OpcionesDAO;
import com.modelo.dao.PreguntasDAO;
import com.modelo.entidades.Opciones;
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

public class controladorCreaCuestionario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

                int idCuestionario = Integer.parseInt(request.getParameter("id"));

                PreguntasDAO pdao = new PreguntasDAO();
                List<Preguntas> listaPreguntas = pdao.SeleccionaPreguntas(idCuestionario);

                OpcionesDAO odao = new OpcionesDAO();
                List<Opciones> listaOpciones = new ArrayList();
                for (Preguntas pregunta : listaPreguntas) {
                    Opciones opcion = odao.SelecionaOpcion(pregunta.getIdPreguntas());
                    opcion.setIdPreguntas(pregunta);
                    listaOpciones.add(opcion);
                }

                request.setAttribute("listaOpciones", listaOpciones);
                request.setAttribute("NombreCuestionario", listaOpciones.get(0).getIdPreguntas().getIdCuestionario().getNombreCuestionario());
                request.setAttribute("idCuestionario", listaOpciones.get(0).getIdPreguntas().getIdCuestionario().getIdCuestionario());
                request.getRequestDispatcher("Cuestionario.jsp").forward(request, response);
                
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
            Logger.getLogger(controladorCreaCuestionario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(controladorCreaCuestionario.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(controladorCreaCuestionario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(controladorCreaCuestionario.class.getName()).log(Level.SEVERE, null, ex);
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
