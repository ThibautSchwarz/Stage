/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import beans.pancartes;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thibaut
 */
@WebServlet(name = "finchargementmassetranchesuiv", urlPatterns = {"/finchargementmassetranchesuiv"})
public class finchargementmassetranchesuiv extends HttpServlet {

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
            throws ServletException, IOException, InterruptedException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Chargement terminé</title>");            
            out.println("</head>");
            out.println("<body>");
            pancartes dossier=new pancartes();
            dossier.setLien("c:/users/thibaut/Documents/NetBeansProjects/proceduresdegradees/src/main/webapp/pancartes/");
            SimpleDateFormat formejour = null;
            SimpleDateFormat formemois = null;
            SimpleDateFormat formean = null;
            SimpleDateFormat formeheure = null;
            formeheure = new SimpleDateFormat("HH");
            formejour = new SimpleDateFormat("dd");
            formemois = new SimpleDateFormat("MM");
            formean = new SimpleDateFormat("yyyy");
            Date aujourdhui=new Date();
            int h=0;
            int heure=Integer.parseInt(formeheure.format(aujourdhui));
            if (heure<4){
                h=4;
                }else{
                if (heure<8){
                    h=8;
                }else{if (heure<12){
                    h=12;
		}else{if (heure<16){
                    h=16;
		}else{if (heure<20){
                    h=20;
                }else{
       		    aujourdhui=new Date(aujourdhui.getTime()+86400000);
                }}}}}
            String d =Integer.toString(Integer.parseInt(formejour.format(aujourdhui)))+"-"+Integer.toString(Integer.parseInt(formemois.format(aujourdhui)))+"-"+Integer.toString(Integer.parseInt(formean.format(aujourdhui)));
            dossier.ajouterjsmasse(d, h);
            out.println("<h1>le téléchargement est fini</h1>");
            out.println("<a href=index.jsp>retour à l'accueil</a>");
            out.println("</body>");
            out.println("</html>");
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
        } catch (InterruptedException ex) {
            Logger.getLogger(finchargementmasse.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (InterruptedException ex) {
            Logger.getLogger(finchargementmasse.class.getName()).log(Level.SEVERE, null, ex);
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