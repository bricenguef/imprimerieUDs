
<!DOCTYPE html>
<html>

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
		
    
<!--
<hgroup>
<h1></h1>
	  <h2></h2>
	</hgroup>
	-->
   
 
 
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
			<p><a href="connexionAdmin.jsp" align ="right">Espace Personnel</a></p>
			<p><a href="ConnexionAdmin.jsp" align ="right">Espace Admin</a></p>
 
</section>

<sectione>
			<h1 align ="center">Espace Administrateur</h1>
			<br>
		  <p align ="center">  
		  
		  <%@ page import="java.util.*" %>
		  
		  
		  <table>
		      <caption> Liste des Vagues</caption>
		  
		  <tbody>
			<tr>
				<th>Intitule</th>
				<th>DateDebut</th>
				<th>DateFin</th>
				<th>Etat</th>
				
				
				
			</tr>
		  
			<c:forEach items="${sessionScope.ListeVague}" var="Vague" >
 			<tr>
			   <td> <c:out value="${Vague.Intitule}"/></td>
			   <td> <c:out value="${Vague.DateDebut}"/></td>
			  <td> <c:out value="${Vague.dateFin}"/></td>
			   <td> <c:out value="${Vague.Etat}"/></td>
			  
			</tr>
			</c:forEach>
			</tbody>
         </table>
		<a href="Deconnexion.jsp">Deconnexion</a>  |  <a href="index.jsp">Retour</a> 
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
        Valid | <a href="connexionAd" align ="right">Admin</a>
</footer>
         
         </div>
         
<!-- end footer -->



</div>
  
  <!-- end page -->


<br>
</body>


        </html>