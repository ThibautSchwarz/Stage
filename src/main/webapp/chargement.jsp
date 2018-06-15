<%-- 
    Document   : chargement
    Created on : 22 mai 2018, 15:20:23
    Author     : thibaut
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chargement</title>
    </head>
    <body>
        <h1>Ce document va être construit, le temps d'attente peut être important</h1>
        <a href='Ajouterjs?date=<%= request.getParameter("date")%>&heure=<%=request.getParameter("heure")%>&lien=<%=request.getParameter("lien")%>&nom=<%=request.getParameter("nom")%>&prenom=<%=request.getParameter("prenom")%>&datedebut=<%=request.getParameter("datedebut")%>'>Cliquez ici si vous avez compris</a>        
        </h1>
    </body>
</html>
