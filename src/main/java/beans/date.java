/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author thibaut
 */
public class date {
    private Date date;
    private String datedebut;

    public void setDatedebut(String datedebut) {
        this.datedebut = datedebut;
        if (datedebut==null){
        datedebut=Long.toString(date.getTime());
        }
        this.date = new Date(Long.parseLong(datedebut));
    }

    public String getDatedebut() {
        return datedebut;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(long datedebut) {
        this.date=new Date(datedebut);
    }
    
    public void demain(){
    Date demain = new Date(date.getTime()+86400000);
    date=demain;
    }
    public String afficherDatephrase(){
        SimpleDateFormat forme = null;
        forme=new SimpleDateFormat("'pancarte du' dd MMMM");
        return(forme.format(date));
    }
    public String afficherDatejour(){
        SimpleDateFormat forme = null;
        forme=new SimpleDateFormat("dd");
        return(forme.format(date));
    }
    public String afficherDateheure(){
        SimpleDateFormat forme = null;
        forme=new SimpleDateFormat("HH");
        return(forme.format(date));
    }
    public int donnerheure(){
        return(Integer.parseInt(afficherDateheure()));
    }
    public String afficherDatejuste(){
        SimpleDateFormat forme = null;
        forme=new SimpleDateFormat("'le' dd MMMM");
        return(forme.format(date));
    }
    public String afficherDatemois(){
        SimpleDateFormat forme = null;
        forme=new SimpleDateFormat("MM");
        return(forme.format(date));
    }
    public String afficherDatean(){
        SimpleDateFormat forme = null;
        forme=new SimpleDateFormat("yyyy");
        return(forme.format(date));
    }
    public String DebutPancartes(){
        int heure =donnerheure();
        String h;
        if (heure<4){
                h="0";
                }else{
                if (heure<8){
                    h="4";
                }else{if (heure<12){
                    h="8";
		}else{if (heure<16){
                    h="12";
		}else{if (heure<20){
                    h="16";
                }else{
       		    h="20";
}}}}}
        return h;
    }
    public String afficher_(){
    SimpleDateFormat forme = null;
    forme=new SimpleDateFormat("dd+'-'+MM+'-'+yyyy");
    return(forme.format(date));}
    
    public String afficher_propre(){
    return (Integer.toString(Integer.parseInt(afficherDatejour()))+"-"+Integer.toString(Integer.parseInt(afficherDatemois()))+"-"+Integer.toString(Integer.parseInt(afficherDatean())));    
    }
    public String aujourdhuipropre(){
    Date aujourdhui=new Date();
    SimpleDateFormat formejour = null;
    formejour=new SimpleDateFormat("dd");
    SimpleDateFormat formemois = null;
    formemois=new SimpleDateFormat("MM");
    SimpleDateFormat formean = null;
    formean=new SimpleDateFormat("yyyy");
    return(Integer.toString(Integer.parseInt(formejour.format(aujourdhui)))+"-"+Integer.toString(Integer.parseInt(formemois.format(aujourdhui)))+"-"+Integer.toString(Integer.parseInt(formean.format(aujourdhui))));
    }
    public boolean testeraujourdhui(){
    String actuel=afficher_propre();
    String aujourdhui = aujourdhuipropre();
    return (actuel.equals(aujourdhui)); 
    }
    
}
