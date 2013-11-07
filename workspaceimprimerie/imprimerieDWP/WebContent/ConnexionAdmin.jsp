
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name ="Description" Content="L'Application en HTML5/JAVAEE de l'Imprimerie"/>
<meta name =""keywords" content="" />
<title>Imprimerie</title>

<link href="style.css" rel="stylesheet" type="text/css" media="screen" />

</head>

<body>

<!-- start page -->
<div id="page">

<!-- start header -->

	<header>
    <img src="images/univ.jpg" alt=""> 
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
			<p><a href="ConnexionAdmin.jsp" align ="right">Espace Personnel</a></p>
			<p><a href="ConnexionAdmin.jsp" align ="right">Espace Admin</a></p>
 
</section>

<sectione>
			<h2 align ="center">Connexion Administrateur</h2>
		  <p><form action="EspaceAdmin" method="post" class="niceform">
         
                <fieldset>
                    
                    <dl>
                        <dt><label for="nom">Login<font color="red"> *</font></label></dt>
                        <dd><input type="text" name="login" id="" size="25" /></dd>
                    </dl>
                    <dl>
                        <dt><label for="password">Mot de passe <font color="red">*</font></label></dt>
                        <dd><input type="password" name="passe" id="" size="25" /></dd>
                    </dl>
                    
                    <br/><br/><br/><br/>
                  
                     <dl class="submit">
                    <input type="submit" name="submit" id="submit" value="  Ok  " />
                     </dl>
                    
                </fieldset>
                
         </form>
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
        Valid  <a href="connexionAdm.jsp" align ="right">Admin</a>
</footer>
         
         </div>
         
<!-- end footer -->



</div>
  
  <!-- end page -->


</body>
</html>