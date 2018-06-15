<%-- 
    Document   : formprescription
    Created on : 7 juin 2018, 14:59:03
    Author     : thibaut
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function verifprescripteur(){
                if(document.getElementById("responsable").value===""){
                document.getElementById("resplabel").innerHTML="<font color='red'>Le nom du prescripteur : </font>";
                return false
            }
            else{return true}}
        </script>
    </head>
    <body>
        <h1>Création d'une prescription</h1>
        <form action="creerform" onsubmit="return verifprescripteur()" method='GET'>
            <label id="resplabel" for="responsable">Le nom du prescripteur : </label><br>
                    <input name="responsable" id="responsable" value=""> <br>
            <label for="sexe">age du patient : </label><br>
                    <input name="age" id="age"> <br>
            <label for="sexe">Le sexe du patient : </label><br>
                    <input name="sexe" id="sexe"> <br>                    
            <label for="poids">Le poids du patient : </label><br>
                    <input name="poids" id="poids"> <br>
            <label for="taille">la taille du patient : </label><br>
                    <input name="taille" id="taille"> <br>
            <label for="numerovenue">le numéros de venue : </label><br>
                    <input name="numerovenue" id="numerovenue"> <br>
            <label for="allergies">Les allergies ou intolérances du patient : </label><br>
            <textarea rows='4' cols='50' name='allergies'id='allergies'></textarea> <br>
                                                            <br>
            <label for="nomchef">Le nom du Chef de service: </label><br>
                    <input name="nomchef" id="nomchef"> <br>
            <label for="titre">Le titre du Chef de service : </label><br>
                    <input name="titre" id="titre"> <br>
            <label for="rpps">Le numéro RPPS : </label><br>
                    <input name="rpps" id="rpps"> <br>
            <label for="heberg">L'UF hébergement : </label><br>
                    <input name="heberg" id="heberg"> <br>
            <label for="medic">L'UF médical : </label><br>
            <input name="medic" id="medic"> <br><br><br>
            <label for="presc">La prescription : </label><br>
            <textarea rows='10' cols='100' name='presc' id='presc'></textarea> <br><br>
            <input type="hidden" name="nom" id="nom" value=<%=request.getParameter("Nom")%>>
            <input type="hidden" name="prenom" id="prenom" value=<%=request.getParameter("Prenom")%>>
            <input type="hidden" name="lien" id="lien" value=<%=request.getParameter("lien")%>>
            <input type="hidden" name="datedebut" id="datedebut" value=<%=request.getParameter("datedebut")%>>
            <input type=submit value='Créer la prescription'>
            </form>
        
    </body>
</html>
