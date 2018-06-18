<%-- 
    Document   : detailpatient
    Created on : 15 mai 2018, 15:08:50
    Author     : thibaut
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="beans.pancartes"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <% String nom = request.getParameter("nom") ;
           String prenom = request.getParameter("prenom");%>
        <title>Patient : <%= nom %></title>
    </head>
    <body>
        <h1>Patient : <%= nom %> <%= prenom %>
        </h1>
        <p>
        <jsp:useBean id="jour" class="beans.date" scope="request" />
        <jsp:useBean id="jour1" class="beans.date" scope="request" />
        <jsp:useBean id="jour2" class="beans.date" scope="request" />
        <jsp:setProperty name="jour" property="datedebut" property="datedebut" />
        <jsp:setProperty name="jour1" property="datedebut" property="datedebut" />
        <jsp:setProperty name="jour2" property="datedebut" property="datedebut" />
        <%jour1.demain();
        jour2.demain();
        jour2.demain();%>
          
        <%= jour.afficherDatephrase()%>
        <%
        String lien= request.getParameter("lien");
        String[] separation=lien.split("\\\\");
        lien=separation[separation.length-1];
        String liencomplet="pancartes/"+lien;
        int heure=jour.donnerheure();
        pancartes pancarte=new pancartes();
        pancarte.setLien(lien);
        String datedebut=request.getParameter("datedebut");
         %>
        
        <br/>
        <%String h =jour.DebutPancartes();
        String d=jour.afficher_propre();
        String param="redirectionsurhtml?date="+d+"&heure="+h+"&nom="+nom+"&prenom="+prenom+"&datedebut="+datedebut+"&lien=";
                    %> 
                    <%if(jour.testeraujourdhui()){
                            out.println("<a href="+param+lien+" >tranche en cours</a>"); 
                            if(pancarte.testerpresencejsp( Integer.parseInt(h) ,d, nom, prenom )){out.println("déjà téléchargé");}}%>
        <br/>
        <br/>
        <form action="Changerdate" method="GET">
        <label for="datedebut">Nouvelle date : </label>
                    <input name="datedebut" placeholder="jj-mm-aaaa">
                    <input type=hidden name="nom" value="<%=nom%>">
                    <input type=hidden name="prenom" value="<%=prenom%>">
                    <input type=hidden name="lien" value="<%=lien%>">
                    <input type="submit"><br>    
        </form>
        <br/>
        <%String g=jour.aujourdhuipropre();  %>
        <form action="Changerdate" method="GET">
                    <input type=hidden name="datedebut" value="<%=g%>">
                    <input type=hidden name="nom" value="<%=nom%>">
                    <input type=hidden name="prenom" value="<%=prenom%>">
                    <input type=hidden name="lien" value="<%=lien%>">
        <input type=
               <%if(jour.testeraujourdhui()){
                    out.println("hidden");}
               else{out.println("submit");}%>
            value="retour à aujourd'hui"><br>    
        </form>
        <br/>
        <table width="80%">
            <tr><td>
                    <h2>tranches horaires :</h2>
                </td>
                <td>
                    <h2>prescriptions :</h2>
                </td>
            </tr>
            <tr>
                <td>
        <p><%=jour.afficherDatejuste()%> <a href=<%="enregistrer.jsp?date="+d %>>enregistrer</a><br/>
        <a href =<% param="redirectionsurhtml?date="+d+"&heure=0&nom="+nom+"&prenom="+prenom+"&datedebut="+datedebut+"&lien=";
                    out.println(param+lien);
                    %>>
        0h    </a><% if(pancarte.testerpresencejsp( 0 ,d, nom, prenom )){out.println("déjà téléchargé");}%>
        <a href =<% param="redirectionsurhtml?date="+d+"&heure=4&nom="+nom+"&prenom="+prenom+"&datedebut="+datedebut+"&lien=";
                    out.println(param+lien);
                    %>>
        4h     </a><% if(pancarte.testerpresencejsp( 4 ,d, nom, prenom )){out.println("déjà téléchargé");}%>
        <a href =<% param="redirectionsurhtml?date="+d+"&heure=8&nom="+nom+"&prenom="+prenom+"&datedebut="+datedebut+"&lien=";
                    out.println(param+lien);
                    %>> 
        8h     </a><% if(pancarte.testerpresencejsp( 8 ,d, nom, prenom )){out.println("déjà téléchargé");}%>
        <a href =<% param="redirectionsurhtml?date="+d+"&heure=12&nom="+nom+"&prenom="+prenom+"&datedebut="+datedebut+"&lien=";
                    out.println(param+lien);
                    %>>
        12h     </a><% if(pancarte.testerpresencejsp( 12 ,d, nom, prenom )){out.println("déjà téléchargé");}%>
        <a href =<% param="redirectionsurhtml?date="+d+"&heure=16&nom="+nom+"&prenom="+prenom+"&datedebut="+datedebut+"&lien=";
                    out.println(param+lien);
                    %>>
        16h     </a><% if(pancarte.testerpresencejsp( 16 ,d, nom, prenom )){out.println("déjà téléchargé");}%>
        <a href =<% param="redirectionsurhtml?date="+d+"&heure=20&nom="+nom+"&prenom="+prenom+"&datedebut="+datedebut+"&lien=";
                    out.println(param+lien);
                    %>>
        20h     </a><% if(pancarte.testerpresencejsp( 20 ,d, nom, prenom )){out.println("déjà téléchargé");}%>
        <br/>
<% d =jour1.afficher_propre();%>        
        <%=jour1.afficherDatejuste()%> <a href=<%="enregistrer.jsp?date="+d %>>enregistrer</a><br/>
        <a href =<% param="redirectionsurhtml?date="+d+"&heure=0&nom="+nom+"&prenom="+prenom+"&datedebut="+datedebut+"&lien=";
                    out.println(param+lien);
                    %>>
        0h     </a><% if(pancarte.testerpresencejsp( 0 ,d, nom, prenom )){out.println("déjà téléchargé");}%>
        <a href =<% param="redirectionsurhtml?date="+d+"&heure=4&nom="+nom+"&prenom="+prenom+"&datedebut="+datedebut+"&lien=";
                    out.println(param+lien);
                    %>>
        4h     </a><% if(pancarte.testerpresencejsp( 4 ,d, nom, prenom )){out.println("déjà téléchargé");}%>
        <a href =<% param="redirectionsurhtml?date="+d+"&heure=8&nom="+nom+"&prenom="+prenom+"&datedebut="+datedebut+"&lien=";
                    out.println(param+lien);
                    %>>
        8h     </a><% if(pancarte.testerpresencejsp( 8 ,d, nom, prenom )){out.println("déjà téléchargé");}%>
        <a href =<% param="redirectionsurhtml?date="+d+"&heure=12&nom="+nom+"&prenom="+prenom+"&datedebut="+datedebut+"&lien=";
                    out.println(param+lien);
                    %>>
        12h     </a><% if(pancarte.testerpresencejsp( 12 ,d, nom, prenom )){out.println("déjà téléchargé");}%>
        <a href =<% param="redirectionsurhtml?date="+d+"&heure=16&nom="+nom+"&prenom="+prenom+"&datedebut="+datedebut+"&lien=";
                    out.println(param+lien);
                    %>>
        16h     </a><% if(pancarte.testerpresencejsp( 16 ,d, nom, prenom )){out.println("déjà téléchargé");}%>
        <a href =<% param="redirectionsurhtml?date="+d+"&heure=20&nom="+nom+"&prenom="+prenom+"&datedebut="+datedebut+"&lien=";
                    out.println(param+lien);
                    %>>
        20h     </a><% if(pancarte.testerpresencejsp( 20 ,d, nom, prenom )){out.println("déjà téléchargé");}%>
        <br/>
        <% d =jour1.afficher_propre();%>
        <%=jour2.afficherDatejuste()%> <a href=<%="enregistrer.jsp?date="+d %>>enregistrer</a> <br/>
        <a href =<% param="redirectionsurhtml?date="+d+"&heure=0&nom="+nom+"&prenom="+prenom+"&datedebut="+datedebut+"&lien=";
                    out.println(param+lien);
                    %>>
        0h     </a><% if(pancarte.testerpresencejsp( 0 ,d, nom, prenom )){out.println("déjà téléchargé");}%>
        <a href =<% param="redirectionsurhtml?date="+d+"&heure=4&nom="+nom+"&prenom="+prenom+"&datedebut="+datedebut+"&lien=";
                    out.println(param+lien);
                    %>>
        4h     </a><% if(pancarte.testerpresencejsp( 4 ,d, nom, prenom )){out.println("déjà téléchargé");}%>
        <a href =<% param="redirectionsurhtml?date="+d+"&heure=8&nom="+nom+"&prenom="+prenom+"&datedebut="+datedebut+"&lien=";
                    out.println(param+lien);
                    %>>
        8h     </a><% if(pancarte.testerpresencejsp( 8 ,d, nom, prenom )){out.println("déjà téléchargé");}%>
        <a href =<% param="redirectionsurhtml?date="+d+"&heure=12&nom="+nom+"&prenom="+prenom+"&datedebut="+datedebut+"&lien=";
                    out.println(param+lien);
                    %>>
        12h     </a><% if(pancarte.testerpresencejsp( 12 ,d, nom, prenom )){out.println("déjà téléchargé");}%>
        <a href =<% param="redirectionsurhtml?date="+d+"&heure=16&nom="+nom+"&prenom="+prenom+"&datedebut="+datedebut+"&lien=";
                    out.println(param+lien);
                    %>>
        16h     </a><% if(pancarte.testerpresencejsp( 16 ,d, nom, prenom )){out.println("déjà téléchargé");}%>
        <a href =<% param="redirectionsurhtml?date="+d+"&heure=20&nom="+nom+"&prenom="+prenom+"&datedebut="+datedebut+"&lien=";
                    out.println(param+lien);
                    %>>
        20h     </a><% if(pancarte.testerpresencejsp( 20 ,d, nom, prenom )){out.println("déjà téléchargé");}%>
        </p>
                </td>
                <jsp:useBean id="dossier" class="beans.pancartes" scope="request" />
            <jsp:setProperty name="dossier" property="lien" value="c:/proceduresdegradeest/src/main/webapp/prescriptions/" />
                <td><%ArrayList<String> urlliste=dossier.chercherprescriptions(lien);
                String Newligne=System.getProperty("line.separator");    
                for (int i=0;i<urlliste.size();i++) { 
                out.println("<p>");
                out.println("<a href=");
                out.println("afficherpresc?lien="+urlliste.get(i));
                out.println(">");
                out.println("prescription ");
                out.println(i+1);
                out.println("</a>");}
                out.println("</p>");%>
                 <a href=<%="formprescription.jsp?Nom="+nom+"&Prenom="+prenom+"&lien="+lien+"&datedebut="+datedebut%>>faire une prescription pour ce patient</a>
                </td></tr>
    </table>
        <br/>
        <h3><a href =<% 
                    out.println(liencomplet);
                    %>>
            pancarte complète    
            </a>  -  <a href = 
                    <%out.println("creerpancartejour?lien="+liencomplet+"&date="+jour.aujourdhuipropre());%>>
            pancarte complètée du jour 1    
            </a>  -  <a href =<% param="creerpancartejour?date="+d+"&nom="+nom+"&prenom="+prenom+"&datedebut="+datedebut+"&lien=";
                    out.println(param+lien);
                    %>>
            pancarte complètée du jour 2    
            </a>  -  <a href =<% 
                    out.println(liencomplet);
                    %>>
            pancarte complètée du jour 3    
            </a>
        </h3>
        <a href ="index.jsp">page d'accueil</a><br/>
        <a href ="">pancarte easily</a>
    </body>
</html>
