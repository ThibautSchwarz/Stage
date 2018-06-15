<%-- 
    Document   : index
    Created on : 15 mai 2018, 12:36:43
    Author     : thibaut
--%>

<%@page import="java.util.Date"%>
<%@page import="beans.date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.pancartes"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Page d'accueil</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h2>Procédures dégradées</h2>
        <h1>Bienvenue</h1>
        </br>
        <form action="chargementajoutenmasse" method="GET">
                    <input type="submit" value="télécharger la tranche horaire en cours"><br>    
        </form>
        <form action="chargementajoutenmassetranchesuiv" method="GET">
                    <input type="submit" value="télécharger la tranche horaire suivante"><br>  
        </form>
        <pre>
            <jsp:useBean id="dossier" class="beans.pancartes" scope="request" />
            <jsp:setProperty name="dossier" property="lien" value="c:/proceduresdegradeest/src/main/webapp/pancartes/" />
            <%ArrayList<String[]> urlliste=dossier.chercherpatient();
            String Newligne=System.getProperty("line.separator");   
            date jour = new date();
            long l=(new Date()).getTime();
            jour.setDatedebut(Long.toString(l));
            String d=jour.afficher_propre();
            String h=jour.DebutPancartes();
            pancartes pancarte=new pancartes();
            String nom;
            String prenom;
            String lien;
            for (int i=0;i<urlliste.size();i++) { 
                out.println(Newligne);    
                out.println((urlliste.get(i))[0]);
                nom=(urlliste.get(i))[1];
                prenom=(urlliste.get(i))[2];
                lien= (urlliste.get(i))[3];
                String[] separation=lien.split("\\\\");
                lien=separation[separation.length-1];
                pancarte.setLien(lien);
                //ici mettre la tranche correspondante en cours si elle est telecharge 
                if(pancarte.testerpresencejsp( Integer.parseInt(h) ,d, nom, prenom )){
                    int heure=jour.donnerheure();
                    String datedebut=request.getParameter("datedebut");
                    String param="redirectionsurhtml?date="+d+"&heure="+h+"&nom="+nom+"&prenom="+prenom+"&datedebut="+datedebut+"&lien=";
                    out.println("<a href="+param+lien+" >tranche en cours</a>");
                }}
%>
            
        </pre>
            
    </body>
</html>
