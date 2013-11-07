package imprimerieDAO;
import java.util.List;
import java.util.Hashtable;
import java.util.Vector;
import javax.ejb.Remote;

import jpa.Affecter;
import jpa.Compte;
import jpa.Personnel;
import jpa.Tache;
import jpa.Temporaire;
import jpa.Vague;
@Remote
public interface GestionContactRemote {
	//methodes de personnel
	   public void ajouterPersonnel(Personnel personnel);
	   public Personnel rechercherPersonnel(String id);
	   public List<Personnel> listerGroupe();
	   public int listindx();
	   public boolean modifiaffecter();
	   public boolean ajouteraffecter(Affecter affect);
	   public void ajouterTemporaire(Temporaire temporaire);
	//methodes de taches   
	   public void ajouterTache(Tache tache);
	   public List<Tache> listertache();
	 //methodes de comptes  
	   
	   public void ajouterCompte(Compte compte);
	   
	   //methodes de vague
	   public void ajouterVague(Vague vague);
	   
	   
	}