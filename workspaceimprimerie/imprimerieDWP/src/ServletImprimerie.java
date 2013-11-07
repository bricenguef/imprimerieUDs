

import imprimerieDAO.GestionContactRemote;
import imprimerieDAO.ImprimerieStateless;

import java.io.IOException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jpa.Tache;

@WebServlet("/conect")
public class ServletImprimerie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String pageRetour = "/WEB-INF/index.jsp";
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Properties ppt = null;
		Context ctx = null;
		ImprimerieStateless ref = null;
		GestionContactRemote home = null;
		
      try {
//    	  ppt = new Properties();
//			ppt.put(Context.INITIAL_CONTEXT_FACTORY,
//					"org.jnp.interfaces.NamingContextFactory");
//			ppt.put(Context.PROVIDER_URL, "localhost:1099");
//			ctx = new InitialContext(ppt);
//			home = (GestionContactRemote) ctx.lookup("ImprimerieStateless/remote-Client");
//			
//
//         // Ne pas faire l'ajout plusieurs fois, commenter ces lignes après la première exécution.
//         Tache t= new Tache();
//         t.setIdtache(1);
//         t.setLibele("Reparrer les machine");
//         t.setEtat("actif");
//         home.ajouterTache(t);

         this.getServletContext().getRequestDispatcher(pageRetour)
			.forward(request, response);

      } catch (Exception e) {
         e.printStackTrace();
      }
   }
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
