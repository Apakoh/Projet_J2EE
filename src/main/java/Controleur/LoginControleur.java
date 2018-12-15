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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Spard
 */
@WebServlet(name = "LoginControleur", urlPatterns = {"/LoginControleur"})
public class LoginControleur extends HttpServlet {
    
    
    private boolean connecte = false;

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
        throws ServletException, IOException, DAOException {
 
            String pagejsp;
            // Créér le ExtendedDAO avec sa source de données
            DAO dao = new DAO(DataSourceFactory.getDataSource());
            // Trouver la valeur du paramètre HTTP selectedState
            request.setCharacterEncoding("UTF-8");
            HttpSession session = request.getSession();

            if(actionIs(request,"login"))
            {
                this.connecte = true;
                String identifiant = request.getParameter("identifiant");
                String motDePasse = request.getParameter("motDePasse");
                String action = request.getParameter("action");
                pagejsp = "login";
                
                if(action!=null)
                {
                    if(action.equals("login") & identifiant!=null & motDePasse!=null)
                    {               
                        try{
                            List<ClientEntity> clients = dao.customerLoginList();
                            for (ClientEntity c : clients)
                            {
                                if(c.getEmail().equals(identifiant) & c.getIdClient()==Integer.parseInt(motDePasse))
                                {
                                    pagejsp = "choixClient";
                                    session.setAttribute("id", motDePasse);
                                }
                            }
                        } catch (DAOException ex) {
                            Logger.getLogger("servlet").log(Level.SEVERE, "Erreur de traitement", ex);      
                        }
                    }
                }

                // On continue vers la page JSP sélectionnée
                request.getRequestDispatcher("Vue/"+pagejsp+".jsp").forward(request, response);
            } else if(actionIs(request,"Accéder à mes infos personnelles") || actionIs(request,"Accéder à mes bons de commandes"))
            {
              String choix = request.getParameter("action");
              pagejsp = "choixClient";

              if(choix!=null)
              {
                  //ClientEntity client = dao.customer(1);
                  if("Accéder à mes infos personnelles".equals(choix))
                  {
                      pagejsp="editionInfos";
                      //request.setAttribute("client", client);
                  }
                  else
                      pagejsp="editionCommandes";
              }

              // On continue vers la page JSP sélectionnée
              request.getRequestDispatcher("Vue/"+pagejsp+".jsp").forward(request, response);
            } else {if(this.connecte==false)
                request.getRequestDispatcher("Vue/login.jsp").forward(request, response);
            }
    }

    private boolean actionIs(HttpServletRequest request, String action) {
	return action.equals(request.getParameter("action"));
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
        } catch (DAOException ex) {
            Logger.getLogger(LoginControleur.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (DAOException ex) {
            Logger.getLogger(LoginControleur.class.getName()).log(Level.SEVERE, null, ex);
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
    }

}
