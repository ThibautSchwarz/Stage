/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import beans.pancartes;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thibaut
 */
@WebServlet(name = "creerform", urlPatterns = {"/creerform"})
public class creerform extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Création prescription</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Prescription  </h1>");
            String nom= request.getParameter("nom");
            String prenom= request.getParameter("prenom");
            String lien= request.getParameter("lien");
            String sexe= request.getParameter("sexe");
            String poids= request.getParameter("poids");
            String taille= request.getParameter("taille");
            String numerovenue= request.getParameter("numerovenue");
            String allergies= request.getParameter("allergies");
            String nomchef= request.getParameter("nomchef");
            String titre= request.getParameter("titre");
            String rpps= request.getParameter("rpps");
            String heberg= request.getParameter("heberg");
            String medic= request.getParameter("medic");
            String pres= request.getParameter("presc");
            String datedebut=request.getParameter("datedebut");
            String resp= request.getParameter("responsable");      
            String age=request.getParameter("age");
            pancartes Lien =new pancartes();
            Lien.setLien("yp");
            String id=lien.substring(6,15);
            String[] a=pres.split("\r\n");
            pres="";
            for (int i=0;i<a.length;i++){pres=pres+"<br>"+a[i];}
            String[] b=allergies.split("\r\n");
            allergies="";
            for (int i=0;i<b.length;i++){allergies=allergies+"<br>"+b[i];}
            Lien.creerprescr(nom,prenom,sexe,poids,taille,id,numerovenue,allergies,nomchef,titre,rpps,heberg,medic,pres,resp,age);
            out.println("<p>La prescription a été crée avec succès</p>");
            out.println("<a href='detailpatient.jsp?prenom="+prenom+"&nom="+nom+"&lien="+lien+"&datedebut="+datedebut+"'>retour fiche patient</a>");
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
   /*         String nom= request.getParameter("nom");
            String prenom= request.getParameter("prenom");
            String lien= request.getParameter("lien");
            String sexe= request.getParameter("sexe");
            String poids= request.getParameter("poids");
            String taille= request.getParameter("taille");
            String numerovenue= request.getParameter("numerovenue");
            String allergies= request.getParameter("allergies");
            String nomchef= request.getParameter("nomchef");
            String titre= request.getParameter("titre");
            String rpps= request.getParameter("rpps");
            String heberg= request.getParameter("heberg");
            String medic= request.getParameter("medic");
            String pres= request.getParameter("presc");
            pancartes Lien =new pancartes();
            Lien.setLien("");
            String id=lien.substring(6,15);
            Lien.creerprescr(nom,prenom,sexe,poids,taille,id,numerovenue,allergies,nomchef,titre,rpps,heberg,medic,pres);
 */           processRequest(request, response);
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
