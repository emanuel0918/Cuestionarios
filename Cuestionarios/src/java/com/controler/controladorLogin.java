package com.controler;

import com.modelo.dao.UsuarioDAO;
import com.modelo.entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class controladorLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String Usuario = request.getParameter("inputUser");
            String Password = request.getParameter("inputPassword");

            UsuarioDAO udao = new UsuarioDAO();
            Usuario usuario = udao.LeeUsuario(Usuario);

            if (usuario != null) {
                if (usuario.getPasswordUsuario().equals(Password)) {
                    
                    HttpSession sesion = request.getSession();
                    sesion.setAttribute("User", usuario);
                    request.setAttribute("Usuario", usuario);

                    if (usuario.getCategoriaUsuario().toUpperCase().equals("ALUMNO")) {
                        request.getRequestDispatcher("homeAlumno.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("homeProfesor.jsp").forward(request, response);
                    }

                } else {
                    out.println("<h1> Constraseña incorrecta</h1>");
                }
            } else {
                out.println("<h1> usuario incorrecta</h1>");
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(controladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(controladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(controladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(controladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
