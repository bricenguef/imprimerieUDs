package com.example.bizzgo;

public class Client {
	private int id;
	private String nom;
	private String login;
	private String pass;
	private String pays;
	private String ville;
	private String quartier;
	private String adresse;
	
	public Client(String nom,String login, String pass,String pays,String ville,String quartier,String adresse){
		this.nom = nom;
		this.login = login;
		this.pass = pass;
		this.pays = pays;
		this.ville = ville;
		this.quartier=quartier;
		this.adresse=adresse;
	}
	
	public String toString(){
		return "\n ID : "+id+"\nNom : "+nom+"\nLogin : "+login+"\nPass : "+pass+"\n tâche : "+pays+"\n Ville : "+ville+"\n faculte : "+quartier+"\n filiere :"+adresse;
	}

	public Client() {
		//super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getQuartier() {
		return quartier;
	}

	public void setQuartier(String quartier) {
		this.quartier = quartier;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
