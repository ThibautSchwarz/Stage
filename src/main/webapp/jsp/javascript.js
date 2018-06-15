function changercookiearp(j){
	a = new Date();
	b = a.getTime();
	t= false;
	d = new Date();
	d.setTime(a.getTime() +86400000000);
	horoh=a.getHours().toString();
	horomin=a.getMinutes().toString();
	donne='';
	if (document.cookie!=""){
	 donnesanssuprinter = document.cookie.split('=//');//probici car peut etre egale a 1 si un autre cookie existe
	 if(donnesanssuprinter.length!=1){
	 donnesanssupr = donnesanssuprinter[1].split(";")[0];
	 donnesanssuprli = donnesanssupr.split('/,/');
	for (var i=0 ;i<donnesanssuprli.length;i++){
	if(donnesanssuprli[i].split("/_/",1)[0]!='arp'){
	donne+=donnesanssuprli[i]+'/,/';
	}}}}
	titre=lien.substring(6,15);
	a=document.getElementById('arp').value;
	document.cookie=titre+'=//'+donne+'arp/_/0/_/f/_/'+horoh+":"+horomin+"   "+a+';expires='+d.toUTCString()+";path=/";
	}
	function changercookie(j){
	a = new Date();
	b = a.getTime();
	t= false;
	jcor=j-1;
	d = new Date();
	d.setTime(a.getTime() +86400000000);
	horoh=a.getHours().toString();
	horomin=a.getMinutes().toString();
	donne='';
	if (document.cookie!=""){
	donnesanssuprinter = document.cookie.split('=/*');//probici car peut etre egale a 1 si un autre cookie existe
	if(donnesanssuprinter.length!=1){
	donnesanssupr = donnesanssuprinter[1].split(";")[0];
	donnesanssuprli = donnesanssupr.split('/,/');
	for (var i=0 ;i<donnesanssuprli.length;i++){
	if(donnesanssuprli[i].split("/_/",2)[0]!=(jcor)){
	donne+=donnesanssuprli[i]+'/,/';
	}}}}
	titre=lien.substring(6,15)+datelong+heurestring;
	a=document.getElementById(jcor).value
	if(document.getElementById('box'+id).checked){
		t='t';}
	else{
		t='f';}
	document.cookie=titre+'=/*'+donne+jcor+'/_/'+t+'/_/'+horoh+":"+horomin+"   "+a+';expires='+d.toUTCString()+";path=/";
	}
	function changercookiejour(j){
	a = new Date();
	b = a.getTime();
	t= false;
	d = new Date();
	d.setTime(a.getTime() +86400000000);
	 jcor=j-1;
	 id= datelong+(j-1);
	 horoh=a.getHours().toString();
	 horomin=a.getMinutes().toString();
	 donne='';
	 if (document.cookie!=""){
	 donnesanssuprinter = document.cookie.split('=//');//probici car peut etre egale a 1 si un autre cookie existe
	if(donnesanssuprinter.length!=1){
	donnesanssupr = donnesanssuprinter[1].split(";")[0];	
	donnesanssuprli = donnesanssupr.split('/,/');//attention filtrage mal fait
	for (var i=0 ;i<donnesanssuprli.length;i++){
	if(donnesanssuprli[i].split("/_/",2)[0]+donnesanssuprli[i].split("/_/",2)[1]!=(datelong+jcor)){
	donne+=donnesanssuprli[i]+'/,/';
	}}}}
	titre=lien.substring(6,15);
	a=document.getElementById(id).value
	if(document.getElementById('box'+id).checked){
		t='t';}
	else{
		t='f';}
	document.cookie=titre+'=//'+donne+datelong+'/_/'+jcor+'/_/'+t+'/_/'+horoh+":"+horomin+"   "+a+';expires='+d.toUTCString()+";path=/";
	}
	function Remplace(expr,a,b) {
  var i=0
  while (i!=-1) {
    i=expr.indexOf(a,i);
    if (i>=0) {
      expr=expr.substring(0,i)+b+expr.substring(i+a.length);
      i+=b.length;
    }
  }
  return expr;}
	function  affichercookie(){
	var i;
	if(document.cookie.length == 0)
	{return " ";}
     var cookies = document.cookie.split("; ");
     for(var j = 0; j < cookies.length; j++){
       if(cookies[j].substring(0,9)==lien.substring(6,15)){
	   var infos = cookies[j].split("=/");
       if(infos[0] ==lien.substring(6,15)){
         //relatif patient ie jour+arp
		infosboites =cookies[j].split("=//",2)[1].split("/,/");//arp_f_0_com 7-5-2018_0_t(ou f)_9h32->com....
		for (var i=0; i<infosboites.length;i++){
		datelongcookie=infosboites[i].split("/_/",4)[0];
		num=infosboites[i].split("/_/",4)[1];
		box=infosboites[i].split("/_/",4)[2];
		com=infosboites[i].split("/_/",4)[3];
		if(datelongcookie=="arp"){		
		document.getElementById("arp").innerHTML=Remplace(com,"_","\n ");
		}
		else{if(datelongcookie==datelong){
		if (box=="t"){
		document.getElementById('box'+datelongcookie+num).parentElement.innerHTML=Remplace(document.getElementById('box'+datelongcookie+num).parentElement.innerHTML,'value="t"','checked value="t"');
		}
		document.getElementById(datelongcookie+num).value=com;}}
	}
		}else{
		if(infos[0] ==lien.substring(6,15)+datelong+heurestring){
		//relatif infos pancarte 1_t_com
		infosboites =cookies[j].split("=/*",2)[1].split("/,/");
		id=infosboites[0].split("/_/",3)[0];//probiciacreuser
		box=infosboites[0].split("/_/",3)[1];
		com=infosboites[0].split("/_/",3)[2];
		if (box=="t"){
		document.getElementById('box'+id).parentElement.innerHTML=Remplace(document.getElementById('box'+id).parentElement.innerHTML,'value="t"','checked value="t"');
		}
		document.getElementById(id).value=com;
	   }}}
	 }}
    window.onload = function () {
	load();
//js ajouté début
if (heure<4){
var time="00";
}else{
	if (heure<8){
		var time="04";
	}else{if (heure<12){
		var time="08";
		}else{if (heure<16){
			var time="12";
			}else{if (heure<20){
				var time="16";
				}else{
					var time="20";
}}}}}
tranches=document.getElementsByClassName("tranche");
var datetranche=" "
var long=tranches.length;
var i=0;

while (i<long){
	let remove=false ;
	datetranche=tranches[i].firstChild;
	datetranchemem=datetranche.firstChild;
	datetranche=datetranchemem.firstChild;//06/05/2018 - Dans la journée ou 06/05/2018 00:00 - 03:59
	let jour=datetranche.substringData(0,2);
	let temps=datetranche.substringData(11,2);
	jourpreced=jour
	if (date!=jour){
		remove = true
	}
	if (!(temps==time || temps=="- ")){
		remove=true
	}
	if (temps=="- "){
	var a=datetranchemem.innerHTML
	datetranchemem.innerHTML="<font color='red'>"+a+"</font>"	
	}
	if (remove==true){
		tr=document.getElementById("footer").firstChild;
		tr.removeChild(tranches[i]);
		i=i-1;
		long=long-1}
i=i+1;
}
if (long==0){
	document.getElementById('footer').innerHTML = "<div><br/><br/><br/><br/><br/><br/><br/><br/><br/><p align='center'><b><font color='#ff0000'>ATTENTION CE JOUR N'EST PAS PRESENT SUR LA PANCARTE, IL FAUT AJOUTER LES PANCARTES NECESSAIRES</font></b></p></div>";
}

//js ajouté fin
var liste=document.getElementsByClassName("col");
var l=(liste).length;
var i;
var k=0;
var j=0;
var m=0;
var jour;
for ( i=0;i<l;i++){
	var todo=liste[i].firstChild;
	jour="";
	if(liste[i].parentElement.parentElement.firstChild.firstChild.firstChild!=null){
		id=datelong+j;
		j=j+1;
		jour="jour";
		m=j;
	}else{
		id=k;
		k=k+1;
		m=k;
	}
	
	form="<form onsubmit=changercookie"+jour+"("+m+")><input type=submit value='ok'><input name='nom' type=hidden value="+nom+"><input name='date' type=hidden value="+datelong+"><input name='prenom' type=hidden value="+prenom+"><input name='datedebut' type=hidden value="+datedebut+"><input name='heure' type=hidden value="+heurestring+"><input name='lien' type=hidden value="+lien+"><input type=checkbox id='box"+id+"' name='infosbox' value=t><input id="+id+" name='infos' value=''></form>"
	todo.innerHTML+=form;
}

var a=document.getElementById("footer");
var b=a.innerHTML;
a.firstChild.innerHTML= "<center><form onsubmit=changercookiearp('arp')><input name='nom' type=hidden value="+nom+"><input name='date' type=hidden value="+datelong+"><input name='prenom' type=hidden value="+prenom+"><input name='datedebut' type=hidden value="+datedebut+"><input name='heure' type=hidden value="+heurestring+"><input name='lien' type=hidden value="+lien+"><textarea name='infos' id='arp'rows=5 cols=100></textarea><br/><input type=submit value='rajout des actes en role propre'></form><form action='Redirectionpagepatient' method='GET'><input type=submit value='retour à la page patient'><input name='nom' type=hidden value="+nom+"><input name='date' type=hidden value="+datelong+"><input name='prenom' type=hidden value="+prenom+"><input name='datedebut' type=hidden value="+datedebut+"><input name='heure' type=hidden value="+heurestring+"><input name='lien' type=hidden value="+lien+"></form><form action='Redirectionindex' method='GET'><input type=submit value='retour à l accueil'></form></center>"+b	;affichercookie();
affichercookie();
	    }