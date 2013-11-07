
	import imprimerieDAO.GestionContactRemote;
import imprimerieDAO.ImprimerieStateless;

import java.util.List;
import java.util.Properties;

	import javax.naming.Context;
	import javax.naming.InitialContext;
import javax.naming.NamingException;

import jpa.Tache;

public class ClientJava {
	

	   public static void main(String[] args) {
		   Properties ppt = null;
			Context ctx = null;
			ImprimerieStateless ref = null;
			GestionContactRemote home = null;
			
	      try {
	    	  ppt = new Properties();
				ppt.put(Context.INITIAL_CONTEXT_FACTORY,
						"org.jnp.interfaces.NamingContextFactory");
				ppt.put(Context.PROVIDER_URL, "localhost:1099");
				ctx = new InitialContext(ppt);
				home = (GestionContactRemote) ctx.lookup("ImprimerieStateless/remote-Client");
				

	         // Ne pas faire l'ajout plusieurs fois, commenter ces lignes après la première exécution.
	         Tache t= new Tache();
	         t.setLibele("Roll Nguegang ");
	         t.setEtat("actif");
	         home.ajouterTache(t);

	         

	      } catch (NamingException e) {
	         e.printStackTrace();
	      }
	   }
	}