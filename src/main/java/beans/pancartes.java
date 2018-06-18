/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thibaut
 */
public class pancartes {
    private String lien;

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }
    
    public String extract(){
        String Nom="A";
        try {
        File f=new File(lien);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        try {String line= br.readLine();
            int i = 0;
            while(i!=3){
                i=i+1;
                line=br.readLine();   
            }
            Nom=line.substring(22,line.length()-14);
            br.close();
            fr.close();
        }catch (IOException exception){
            System.out.println("erreur lecture :"+lien);
        }
    }catch (FileNotFoundException exception){
        System.out.println("pas de fichier a "+lien);
    }   
        return Nom;
    }
    public ArrayList<String[]> chercherpatient(){    
        File f = new File(lien);
        ArrayList<String[]> urlpatient = new ArrayList<>();
        File[] paths = f.listFiles();
        for(File path:paths) {
            String lienpancarte =(path.toString());
            pancartes html = new pancartes();
            html.setLien(lienpancarte);
            String NomPrenom = html.extract();
            String Nom=(NomPrenom.split(" "))[0];
            String Prenom=(NomPrenom.split(" "))[1];
            String link = "<a href=";
            Date date = new Date();
            link=link+("detailpatient.jsp"+"?prenom="+Prenom+"&nom="+Nom+"&lien="+lienpancarte+"&datedebut="+date.getTime()+">"+NomPrenom+"</a>");
            String[] contenu = new String[] { link,Nom,Prenom,lienpancarte };
            urlpatient.add(contenu); 
        }
    return urlpatient;
    }
public ArrayList<String> chercherprescriptions(String lienpancarte){    
        File f = new File(lien);
        ArrayList<String> urlpresc = new ArrayList<>();
        String IP=lienpancarte.substring(6,15);
        File[] paths = f.listFiles();
        for(File path:paths) {
            String lienprescription =(path.toString());
            String[] lienprescsplit=lienprescription.split("\\\\");
            String IPpresc=lienprescsplit[lienprescsplit.length-1].substring(6,15);
            if(IP.equals(IPpresc)){
            urlpresc.add(lienprescsplit[lienprescsplit.length-1]); 
        }}
    return urlpresc;
    
    }
    public boolean testerpresencejsp(int heure,String date,String nom,String prenom){
        File f = new File("c:/proceduresdegradeest/src/main/webapp/jsp/");
        File[] paths = f.listFiles();
        boolean trouve=false;
        if(paths==null){
        //le fichier est vide on laisse trouve a false
        }
        else{
        if (heure!=-1){
        for(File path:paths) {
            String lienpancarte =(path.toString());
            trouve=trouve||(lienpancarte.equals("c:\\proceduresdegradeest\\src\\main\\webapp\\jsp\\le"+date+"a"+heure+"h"+nom+"_"+prenom+"_"+lien.substring(6)));
        }}
        else{
        for(File path:paths) {
            String lienpancarte2 =(path.toString());
            trouve=trouve||(lienpancarte2.equals("c:\\proceduresdegradeest\\src\\main\\webapp\\jsp\\le"+date+lien.substring(6)));
        }
        }}
    return trouve;
    }
    
    public void ajouterjsjour(String date,String datedebut,String nom,String prenom)throws InterruptedException {         
            pancartes cible=new pancartes();
            cible.setLien("c:/proceduresdegradeest/src/main/webapp/jsp/le"+date+lien.substring(6));
            try {
                Files.write(Paths.get(cible.getLien()), "".getBytes(), StandardOpenOption.CREATE);
                }catch (IOException e) {
e.printStackTrace();
                }
            pancartes jsp =new pancartes();
            jsp.setLien("c:/proceduresdegradeest/src/main/webapp/jsp/javascriptjourcomplet.js");
            pancartes html =new pancartes();
            html.setLien("c:/proceduresdegradeest/src/main/webapp/pancartes/"+lien);
            html.copier(cible,0,1149);
            String newline=System.getProperty("line.separator"); 
            String jour = (date.split("-"))[0];
            try {
                SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
                Files.write(Paths.get(cible.getLien()), ("var date="+jour+";"+newline).getBytes(), StandardOpenOption.APPEND);
                Files.write(Paths.get(cible.getLien()), ("var nom='"+nom+"';"+newline).getBytes(), StandardOpenOption.APPEND);
                Files.write(Paths.get(cible.getLien()), ("var prenom='"+prenom+"';"+newline).getBytes(), StandardOpenOption.APPEND);
                Files.write(Paths.get(cible.getLien()), ("var datelong='"+date+"';"+newline).getBytes(), StandardOpenOption.APPEND);
                Files.write(Paths.get(cible.getLien()), ("var lien='"+lien+"';"+newline).getBytes(), StandardOpenOption.APPEND);
                Files.write(Paths.get(cible.getLien()), ("var datedebut='"+datedebut+"';"+newline).getBytes(), StandardOpenOption.APPEND);

            }catch (IOException e) {
                } 
            jsp.copier(cible,0,300);
            html.copier(cible,1153,100000);
            html.ajouterok();
            
        }


    public void copier(pancartes target,int lignedebut,int lignefin) {
        try {
        File f=new File(lien);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line="";
            int i = 0;
            String newline=System.getProperty("line.separator"); 
            while (i<lignedebut){
            i=i+1;
            line=br.readLine();
            }
            line=br.readLine();
            while(i!=lignefin &&(line != null)){
                i=i+1;
                try {
                Files.write(Paths.get(target.getLien()), (line+newline).getBytes(), StandardOpenOption.APPEND);
                }catch (IOException e) {
  //exception handling left as an exercise for the reader
                }
                line=br.readLine();
            }
            br.close();
            fr.close();
        }catch (IOException except){
            System.out.println("erreur lllecture :"+except.getMessage());
        }
    }

    
    
    
    
    public void ajouterjsp(String date,String datedebut ,int heure,String nom,String prenom) throws InterruptedException {
            pancartes cible=new pancartes();
            cible.setLien("c:/proceduresdegradeest/src/main/webapp/jsp/le"+date+"a"+heure+"h"+nom+"_"+prenom+"_"+lien.substring(6));
            try {
                Files.write(Paths.get(cible.getLien()), "".getBytes(), StandardOpenOption.CREATE);
                }catch (IOException e) {
e.printStackTrace();
                }
            pancartes jsp =new pancartes();
            jsp.setLien("c:/proceduresdegradeest/src/main/webapp/jsp/javascript.js");
            pancartes html =new pancartes();
            html.setLien("c:/proceduresdegradeest/src/main/webapp/pancartes/"+lien);
            html.copier(cible,0,1149);
            String newline=System.getProperty("line.separator"); 
            String jour = (date.split("-"))[0];
            try {
                SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
                Files.write(Paths.get(cible.getLien()), ("var date="+jour+";"+newline).getBytes(), StandardOpenOption.APPEND);
                Files.write(Paths.get(cible.getLien()), ("var heure="+heure+";"+newline).getBytes(), StandardOpenOption.APPEND);
                Files.write(Paths.get(cible.getLien()), ("var heurestring='"+Integer.toString(heure)+"';"+newline).getBytes(), StandardOpenOption.APPEND);
                Files.write(Paths.get(cible.getLien()), ("var nom='"+nom+"';"+newline).getBytes(), StandardOpenOption.APPEND);
                Files.write(Paths.get(cible.getLien()), ("var prenom='"+prenom+"';"+newline).getBytes(), StandardOpenOption.APPEND);
                Files.write(Paths.get(cible.getLien()), ("var datelong='"+date+"';"+newline).getBytes(), StandardOpenOption.APPEND);
                Files.write(Paths.get(cible.getLien()), ("var lien='"+lien+"';"+newline).getBytes(), StandardOpenOption.APPEND);
                Files.write(Paths.get(cible.getLien()), ("var datedebut='"+datedebut+"';"+newline).getBytes(), StandardOpenOption.APPEND);

            }catch (IOException e) {
                } 
            jsp.copier(cible,0,300);
            html.copier(cible,1153,100000);
            html.ajouterok();
            
        }
        public void creerprescr(String nom,String prenom,String sexe,String poids,String taille,String id,String numerovenue,String allergies,String nomchef,String titre,String rpps,String heberg,String medic,String presc,String resp,String age){
            pancartes cible=new pancartes();
            Date a =new Date();
            long b=a.getTime();
            String time=Long.toString(b);
            cible.setLien("c:/proceduresdegradeest/src/main/webapp/prescriptions/prescr"+id+time+".html");
            try {
                Files.write(Paths.get(cible.getLien()), "".getBytes(), StandardOpenOption.CREATE);
                }catch (IOException e) {
e.printStackTrace();
                }
            pancartes prescription =new pancartes();
            prescription.setLien("c:/proceduresdegradeest/src/main/webapp/prescriptions/prescription.html");
            prescription.copier(cible,0,6);
            String newline=System.getProperty("line.separator"); 
            try {
                Files.write(Paths.get(cible.getLien()), ("var nom=\""+nom+"\";"+newline).getBytes(), StandardOpenOption.APPEND);
                Files.write(Paths.get(cible.getLien()), ("var prenom=\""+prenom+"\";"+newline).getBytes(), StandardOpenOption.APPEND);
                Files.write(Paths.get(cible.getLien()), ("var sexe=\""+sexe+"\";"+newline).getBytes(), StandardOpenOption.APPEND);
                Files.write(Paths.get(cible.getLien()), ("var poids=\""+poids+"\";"+newline).getBytes(), StandardOpenOption.APPEND);
                Files.write(Paths.get(cible.getLien()), ("var taille=\""+taille+"\";"+newline).getBytes(), StandardOpenOption.APPEND);
                Files.write(Paths.get(cible.getLien()), ("var id=\""+id+"\";"+newline).getBytes(), StandardOpenOption.APPEND);
                Files.write(Paths.get(cible.getLien()), ("var numvenue=\""+numerovenue+"\";"+newline).getBytes(), StandardOpenOption.APPEND);
                Files.write(Paths.get(cible.getLien()), ("var allergies=\""+allergies+"\";"+newline).getBytes(), StandardOpenOption.APPEND);
                Files.write(Paths.get(cible.getLien()), ("var nomchef=\""+nomchef+"\";"+newline).getBytes(), StandardOpenOption.APPEND);
                Files.write(Paths.get(cible.getLien()), ("var titre=\""+titre+"\";"+newline).getBytes(), StandardOpenOption.APPEND);
                Files.write(Paths.get(cible.getLien()), ("var rpps=\""+rpps+"\";"+newline).getBytes(), StandardOpenOption.APPEND);
                Files.write(Paths.get(cible.getLien()), ("var heberg=\""+heberg+"\";"+newline).getBytes(), StandardOpenOption.APPEND);
                Files.write(Paths.get(cible.getLien()), ("var medic=\""+medic+"\";"+newline).getBytes(), StandardOpenOption.APPEND);
                Files.write(Paths.get(cible.getLien()), ("var presc=\""+presc+"\";"+newline).getBytes(), StandardOpenOption.APPEND);
                Files.write(Paths.get(cible.getLien()), ("var responsable=\""+resp+"\";"+newline).getBytes(), StandardOpenOption.APPEND);
                Files.write(Paths.get(cible.getLien()), ("var age=\""+age+"\";"+newline).getBytes(), StandardOpenOption.APPEND);
            }catch (IOException e) {
                } 
            prescription.copier(cible,6,150);
            prescription.ajouterok();
            
        }
        
        public void ajouterok(){
            pancartes ok =new pancartes();
            ok.setLien("c:/proceduresdegradeest/src/main/webapp/jsp/ok.txt");
            if (testerok()){
                try {
                    Files.delete(Paths.get(ok.getLien()));
                } catch (IOException ex) {
                    Logger.getLogger(pancartes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            try {
                Files.write(Paths.get(ok.getLien()), "Ceci est un document de test servant à valider la transmission des pancartes".getBytes(), StandardOpenOption.CREATE);
                }catch (IOException e) {
  //exception handling left as an exercise for the reader
                }    
        }
        public boolean testerok(){
        File f = new File("c:/proceduresdegradeest/src/main/webapp/jsp/");
        File[] paths = f.listFiles();
        boolean trouve=false;
        if(paths==null){
        //le fichier est vide on laisse trouve a false
        }
        else{
        for(File path:paths) {
            String lienfichier =(path.toString());
            trouve=trouve||(lienfichier.equals("c:\\proceduresdegradeest\\src\\main\\webapp\\jsp\\ok.txt"));       }
        }
        return trouve;        
        }
        public void ajouterjsmasse(String date,int heure) throws InterruptedException{
        //parcourir le dossier
        File f = new File(lien);
        File[] paths = f.listFiles();
        for(File path:paths) {
            String lienpancarte =(path.toString());
            pancartes html = new pancartes();
            html.setLien(lienpancarte);
            //extraire nom et prenom
            String NomPrenom = html.extract();
            String Nom=(NomPrenom.split(" "))[0];
            String Prenom=(NomPrenom.split(" "))[1];
            pancartes cible = new pancartes();
            String[] separation=lienpancarte.split("\\\\");
            String liencomplet=separation[separation.length-1];
            cible.setLien(liencomplet);
            Date a=new Date();
            long datedebutinter=a.getTime();
            String datedebut=Long.toString(datedebutinter);
            if(!cible.testerpresencejsp(heure,date, Nom, Prenom)){
                cible.ajouterjsp(date,datedebut, heure, Nom, Prenom);
                }
        }
        //recuperer le nom et le prenom
        //tester la présence
        //si absent on l ajoute
        }

    
    
    
    }
    
        
