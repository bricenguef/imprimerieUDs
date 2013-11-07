package com.example.bizzgo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ProduitsBD {

	
	private static final int VERSION_BDD = 1;
	private static final String NOM_BDD = "produit.db";
 
	private static final String TABLE_PRODUITS = "table_produits";
	private static final String COL_ID = "ID";
	private static final int NUM_COL_ID = 0;
	private static final String COL_NOM = "NOM";
	private static final int NUM_COL_NOM = 1;
	private static final String COL_PRIX = "PRIX";
	private static final int NUM_COL_PRIX= 2;
	private static final String COL_CATEGORIE = "CATEGORIE";
	private static final int NUM_COL_CATEGORIE = 3;
	private static final String COL_LIEU = "LIEU";
	private static final int NUM_COL_LIEU = 4;
 
	private SQLiteDatabase bdd;
 
	private MaBaseSQLite maBaseSQLite;
	public ProduitsBD(){
		//On crée la BDD et sa table
		maBaseSQLite = new MaBaseSQLite(null, NOM_BDD, null, VERSION_BDD);
	}
 
	public ProduitsBD(Context context){
		//On crée la BDD et sa table
		maBaseSQLite = new MaBaseSQLite(context, NOM_BDD, null, VERSION_BDD);
	}
 
	public void open(){
		//on ouvre la BDD en écriture
		bdd = maBaseSQLite.getWritableDatabase();
	}
 
	public void close(){
		//on ferme l'accès à la BDD
		bdd.close();
	}
 
	public SQLiteDatabase getBDD(){
		return bdd;
	}
 
	public long insertProduit(Produit produit){
		//Création d'un ContentValues (fonctionne comme une HashMap)
		ContentValues values = new ContentValues();
		//on lui ajoute une valeur associée à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
		values.put(COL_NOM, produit.getNom());
		values.put(COL_PRIX, produit.getPrix());
		values.put(COL_CATEGORIE, produit.getCategorie());
		values.put(COL_LIEU, produit.getLieu());
		//on insère l'objet dans la BDD via le ContentValues
		return bdd.insert(TABLE_PRODUITS, null, values);
	}
	 public Cursor afficheProduit(String lieu,String cat){
		 String mySQL = " select * from TABLE_PRODUITS"
				      + " where COL_CATEGORIE = '" +cat + "'"
				      + "   and COL_LIEU = '" + lieu + "'";
		 Cursor c = bdd.rawQuery(mySQL, null);
		 return c;
	 }
 
	public int updateProduit(int id, Produit produit){
		//La mise à jour d'un livre dans la BDD fonctionne plus ou moins comme une insertion
		//il faut simplement préciser quel livre on doit mettre à jour grâce à l'ID
		ContentValues values = new ContentValues();
		values.put(COL_NOM, produit.getNom());
		values.put(COL_PRIX, produit.getPrix());
		values.put(COL_CATEGORIE, produit.getCategorie());
		values.put(COL_LIEU, produit.getLieu());
		return bdd.update(TABLE_PRODUITS, values, COL_ID + " = " +id, null);
	}
 
	public int removeProduitWithID(int id){
		//Suppression d'un livre de la BDD grâce à l'ID
		return bdd.delete(TABLE_PRODUITS, COL_ID + " = " +id, null);
	}
 
	public Produit getProduitWithNom(String nom){
		//Récupère dans un Cursor les valeurs correspondant à un livre contenu dans la BDD (ici on sélectionne le livre grâce à son titre)
		Cursor c = bdd.query(TABLE_PRODUITS, new String[] {COL_ID, COL_NOM, COL_PRIX,COL_CATEGORIE,COL_LIEU}, COL_NOM + " LIKE \"" + nom +"\"", null, null, null, null);
		return cursorToProduit(c);
	}
	public Cursor getProdWithNom(String nom){
		//Récupère dans un Cursor les valeurs correspondant à un livre contenu dans la BDD (ici on sélectionne le livre grâce à son titre)
		Cursor c = bdd.query(TABLE_PRODUITS, new String[] {COL_ID, COL_NOM, COL_PRIX,COL_CATEGORIE,COL_LIEU}, COL_NOM + " LIKE \"" + nom +"\"", null, null, null, null);
		return c;
	}
	/*public Produit getProduitWithCategorie(String categorie){
		//Récupère dans un Cursor les valeurs correspondant à un livre contenu dans la BDD (ici on sélectionne le livre grâce à son titre)
		Cursor c = bdd.query(TABLE_PRODUITS, new String[] {COL_ID, COL_NOM, COL_PRIX,COL_CATEGORIE,COL_LIEU}, COL_CATEGORIE + " LIKE \"" + categorie +"\"", null, null, null, null);
		return cursorToProduit(c);
	}*/
	public Cursor getProduitWithCategorie(String categorie){
		//Récupère dans un Cursor les valeurs correspondant à un livre contenu dans la BDD (ici on sélectionne le livre grâce à son titre)
		Cursor c = bdd.query(TABLE_PRODUITS, new String[] {COL_ID, COL_NOM, COL_PRIX,COL_CATEGORIE,COL_LIEU}, COL_CATEGORIE + " LIKE \"" + categorie +"\"", null, null, null, null);
		return c;
	}
 
	//Cette méthode permet de convertir un cursor en un livre
	private Produit cursorToProduit(Cursor c){
		//si aucun élément n'a été retourné dans la requête, on renvoie null
		if (c.getCount() == 0)
			return null;
 
		//Sinon on se place sur le premier élément
		//c.moveToFirst();
		c.moveToNext();
		//On créé un livre
		Produit produit = new Produit();
		//on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
		produit.setId(c.getInt(NUM_COL_ID));
		produit.setNom(c.getString(NUM_COL_NOM));
		produit.setPrix(c.getInt(NUM_COL_PRIX));
		produit.setCategorie(c.getString(NUM_COL_CATEGORIE));
		produit.setLieu(c.getString(NUM_COL_LIEU));
		//On ferme le cursor
		c.close();
 
		//On retourne le livre
		return produit;
	}
	
	public Produit cursorProduit(Cursor c){
		//si aucun élément n'a été retourné dans la requête, on renvoie null
		if (c.getCount() == 0)
			return null;
 
		//Sinon on se place sur le premier élément
		//c.moveToFirst();
		//On créé un livre
		Produit produit = new Produit();
		//on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
		produit.setId(c.getInt(NUM_COL_ID));
		produit.setNom(c.getString(NUM_COL_NOM));
		produit.setPrix(c.getInt(NUM_COL_PRIX));
		produit.setCategorie(c.getString(NUM_COL_CATEGORIE));
		produit.setLieu(c.getString(NUM_COL_LIEU));
		//On ferme le cursor
		
 
		//On retourne le livre
		return produit;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
