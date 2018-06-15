/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import beans.pancartes;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thibaut
 */
@WebServlet(name = "redirectionsurhtml", urlPatterns = {"/redirectionsurhtml"})
public class redirectionsurhtml extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
        
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
        String lien=request.getParameter("lien");
        String date=request.getParameter("date");
        String heure=request.getParameter("heure");
        String nom=request.getParameter("nom");
        String prenom=request.getParameter("prenom");
        String datedebut=request.getParameter("datedebut");
        int heureint = Integer.parseInt(heure);
        pancartes Lien =new pancartes();
        Lien.setLien(lien);
        //RequestDispatcher sauvegarde=request.getRequestDispatcher("/jsp/"+date+heure+lien+"fichierhtmlmodifie.html");
        if(Lien.testerpresencejsp(heureint,date,nom,prenom)){
        response.sendRedirect("Afficherjs?lien="+lien+"&date="+date+"&heure="+heure+"&nom="+nom+"&prenom="+prenom+"&datedebut="+datedebut);
        }
        else{
            request.getRequestDispatcher("/Chargement").forward(request,response);       
        }
        
        //sauvegarde.forward(request,response);
        
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
    }// </editor-fold>

}
