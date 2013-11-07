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
    <img src="images/univ.jpg" alt="imprimerie"> 
    <hr color = "#009CE4">
    
<!--
<hgroup>
<h1></h1>
	  <h2></h2>
	</hgroup>
	-->
    <!-- start menu -->
   <!--  -->
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
		-->
		
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
			<p><a href="connexionClient" align ="right">Espace Client</a></p>
			<p><a href="connexionOp" align ="right">Espace Opérateur</a></p>
			<p><a href="connexionAd" align ="right">Espace Admin</a></p>
		
			
 
</section>

<sectione>
			<h1 align ="center">Espace Administrateur</h1>
			<br>
		  <div align ="center">  Création d'un compte Administrateur</div>
		  <p>
		  
			<form action="EnregCompteEpargne" method="post" class="niceform">
         
                <fieldset>
                 	<center><label><font color="#900">${erreur}</font></label></center>
                    <center><label><font color="#090">${succes}</font></label></center>
                    <dl>
                        <dt><label for="nom">Nom <font color="red">*</font></label></dt>
                        <dd><input type="text" name="nom" id="" size="25" /></dd>
                    </dl>
                    <dl>
                        <dt><label for="nom">login <font color="red">*</font></label></dt>
                        <dd><input type="text" name="nom" id="" size="25" /></dd>
                    </dl>
                    
                    <br/><br/><br/><br/>
                    
                     <dl>
                     <dt><a href="AfficheCompteCli">${voir}</a></dt>
                     <dd><input type="submit" name="submit" id="submit" value="Valider" /></dd>
                     </dl>
                    
                </fieldset>
                
         </form>			
			<a href="Deconnexion.jsp">Deconnexion</a>  | <a href="index.jsp">Retour</a> 		  
		  </p>
</sectione>

   
     

		</div>

        <!-- end content -->

        

        <!-- start footer -->

         <div style="clear: both;">
         
         <footer>
         <hr color = "#639CBF">
         <br>
        Your Site Name	@ 2013 | Design by <a href="http://www.google.com" target="_blank">Taponjou</a> | 
        Valid  | <a href="connexionAd" align ="right">Admin</a>
</footer>
         
         </div>
         
<!-- end footer -->



</div>
  
  <!-- end page -->


<br>
</body>


        </html>