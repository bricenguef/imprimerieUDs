package com.example.bizzgo;

public class Produit {
	private int id;
	private String nom;
	private int prix;
	private String categorie;
	private String lieu;
	
	public Produit(String nom,int prix, String categorie,String lieu){
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
		this.lieu=lieu;
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

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public Produit() {
		// TODO Auto-generated constructor stub
	}
	public String toString(){
		return "\n ID : "+id+"\nNom : "+nom+"\nid : "+prix+"\nfaculte : "+categorie+"\n filiere : "+lieu;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
