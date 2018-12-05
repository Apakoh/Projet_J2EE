/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import SimpleJDBC.DAOException;
import SimpleJDBC.DataSourceFactory;
import SimpleJDBC.DAO;
import SimpleJDBC.ClientEntity;

/**
 *
 * @author Spard
 */
@WebServlet(name = "ControleurTauxRemise", urlPatterns = {"/ControleurTauxRemise"})
public class LoginControleur extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
 
        try {
            // Créér le ExtendedDAO avec sa source de données
            DAO dao = new DAO(DataSourceFactory.getDataSource());
            // Trouver la valeur du paramètre HTTP selectedState
            String identifiant = request.getParameter("identifiant");
            String motDePasse = request.getParameter("motDePasse");
            boolean connexion = false;
            
            if(identifiant!=null & motDePasse!=null){
               
            }
                List<ClientEntity> clients = dao.customerLoginList();
                for (ClientEntity c : clients)
                {
                    if(c.getEmail()==identifiant & c.getIdClient()==Integer.parseInt(motDePasse))
                    {
                        connexion = true;
                    }
                }
                request.setAttribute("connexionValide", connexion);
                // On continue vers la page JSP sélectionnée
                request.getRequestDispatcher("Vue/login.jsp").forward(request, response);
            } catch (DAOException ex) {
                Logger.getLogger("servlet").log(Level.SEVERE, "Erreur de traitement", ex);      
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
        processRequest(request, response);
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
        processRequest(request, response);
    }
 
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
