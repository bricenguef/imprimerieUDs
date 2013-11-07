<!DOCTYPE html>


<head>
<meta charset="utf-8" />


<title>Imprimerie</title>


<meta name="description" content="L'Application en HTML5/JAVAEE de l'imprimerie" />

<meta name="keywords" content="" />


<link href="style.css" rel="stylesheet" type="text/css" media="screen" />


</head>

<body>
<br>
<!-- start page -->
<div id="page">

<!-- start header -->

	<header>
    <img src="images/univ.jpg" alt="Imprimerie"> 
    <hr color = "#009CE4">
 
    <!-- start menu -->
    
	<nav id="menu">

			<ul>
                    <li><a href="#">Home</a></li>
                    <li><a href="#">About</a></li>
                    <li><a href="#">Services</a></li>
                    
                    <li><a href="#">Media</a></li>
                    <li><a href="#">Links</a></li>
                    <li><a href="#">Blog</a></li>
                    <li><a href="#">Forum</a></li>
                    
                    <li><a href="#">Contact</a></li>
                   
        
		  </ul>

		</nav>
		
		
        <!-- end menu -->
     
    </header>
 <!-- end menu -->
 
 
 <!-- load  banner image -->
<div id="image">

</div>

<!-- end banner image -->

<!-- start content -->
<div id="content">
  
<section>
			<h1>Menu</h1>
			<br>
			<p><a href="index.jsp" align ="right">Accueil</a></p>
			<p><a href="connexion.jsp" align ="right">Espace Personnel</a></p>
			
			<p><a href="connexion.jsp" align ="right">Espace Admin</a></p>
		
			
 
</section>

<sectione>
			<h1 align ="center">Espace Administrateur</h1>
			<br/><br/>
		   <div align="center"> Entrer les informations sur le Personnel</div>
		   
		  <p>		  
			<form action="personnel" method="post" class="niceform">
         
                <fieldset>
                       <center><label><font color="#900">${erreur}</font></label></center>
                       <center><label><font color="#090">${succes}</font></label></center>
                    <dl>
                        <dt><label for="nom">Nom <font color="red">*</font></label></dt>
                        <dt><input type="text" name="nom" id="" size="25" /></dt>
                    </dl>
                    
                    <dl>
                        <dt><label for="prenon">Prenon <font color="red">*</font></label></dt>
                        <dt><input type="text" name="prenon" id="" size="25" /></dt>
                    </dl>
                      <dl>
                        <dt><label for="email">Email </label></dt>
                        <dt><input type="text" name="email" id="" size="25" /></dt>
                    </dl>


                    
                    <dl>
                        <dt><label for="day">DateNaissance <font color="red">*</font></label></dt>

    			<dd>

			      <select name="day" id="">
				<option value="0" selected>Jour</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
				<option value="13">13</option>
				<option value="14">14</option>
				<option value="15">15</option>
				<option value="16">16</option>
				<option value="17">17</option>
				<option value="18">18</option>
				<option value="19">19</option>
				<option value="20">20</option>
				<option value="21">21</option>
				<option value="22">22</option>
				<option value="23">23</option>
				<option value="24">24</option>
				<option value="25">25</option>
				<option value="26">26</option>
				<option value="27">27</option>
				<option value="28">28</option>
				<option value="29">29</option>
				<option value="30">30</option>
				<option value="31">31</option>
			      </select>   
			      
			      <select name="month" id="month">
				<option value="0" selected>Mois</option>
				<option value="1">January</option>
				<option value="2">February</option>
				<option value="3">March</option>
				<option value="4">April</option>
				<option value="5">May</option>
				<option value="6">June</option>
				<option value="7">July</option>
				<option value="8">August</option>
				<option value="9">September</option>
				<option value="10">October</option>
				<option value="11">November</option>
				<option value="12">December</option>
			      </select>			   

			      <input name="year" maxlength="4" id="" style="width: 60px;" type="text">   

			</dd>
		 </dl>
	         <dl>
                        <dt><label for="sexe">Sexe </label></dt>

    			<dt>
				<input id="" name="sexe" value="" type="radio" checked>
				<label for="_GenderM">HOMME</label>
			     	<input id="Sexef" name="sexe" value="" type="radio">
				<label for="Sexef">FEMME</label>
			</dt>
		</dl>


		<dl>
                        <dt><label for="Grade">Grade </label></dt>

    			<dt>
			     <select name="grade" id="">
			 	<option value="1">CHEF TECHNIQUE</option>
				<option value="2">RECEPTIONISTE</option>
				<option value="3">MAINTENANCIER</option>
			    </select>
			</dt>
		</dl>

		<dl>
                        <dt><label for="statut">Statut </label></dt>

    			<dt>
			     <select name="statut" id="">
			   	<option value="1">Actif</option>
				<option value="2">Inactif</option>
			     </select>
			   
			</dt>
		</dl>

		<dl>
             <dt><label for="departement">Departement</label></dt>

    			<dt>
			     <select name="departement" id="">
	
				 <option value="1">RECEPTION</option>
				 <option value="2">IMPRIMERIE</option>
			      </select>
			</dt>
		</dl>

		<br/><br/><br/><br/>
                   
                    
         <dl >
                <dt><a href="AffichePersonnel.jsp">voir</a></dt>
                <dd><input type="submit" name="submit" id="" value="Valider" /></dd>
                     
         </dl>
       
                    
                </fieldset>
           
                
    </form>		
      </p>	
			<a href="Deconnexion.jsp">Deconnexion</a>  |  <a href="index.jsp">Retour</a>		  
		 
</sectione>

   
     

		</div>

        <!-- end content -->

        

        <!-- start footer -->

         <div style="clear: both;">
         
         <footer>
         <hr color = "#639CBF">
         <br>
        Your Site Name	@ 2013 | Design by <a href="http://www.google.com" target="_blank">Taponjou</a> | 
        Valid | <a href="connexionAd" align="right">Admin</a>
</footer>
         
         </div>
         
<!-- end footer -->



</div>
  
  <!-- end page -->


<br>
</body>

        </html>
