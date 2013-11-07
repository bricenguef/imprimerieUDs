package com.example.bizzgo;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ClientBD {

	private static final int VERSION_BDD = 1;
	private static final String NOM_BDD = "client.db";
 
	private static final String TABLE_CLIENTS = "table_clients";
	private static final String COL_ID = "ID";
	private static final int NUM_COL_ID = 0;
	private static final String COL_NOM = "NOM";
	private static final int NUM_COL_NOM = 1;
	private static final String COL_LOGIN = "LOGIN";
	private static final int NUM_COL_LOGIN = 2;
	private static final String COL_PASS = "PASS";
	private static final int NUM_COL_PASS = 3;
	private static final String COL_PAYS = "PAYS";
	private static final int NUM_COL_PAYS = 4;
	private static final String COL_VILLE = "VILLE";
	private static final int NUM_COL_VILLE = 5;
	private static final String COL_QUARTIER = "QUARTIER";
	private static final int NUM_COL_QUARTIER = 6;
	private static final String COL_ADRESSE = "ADRESSE";
	private static final int NUM_COL_ADRESSE = 7;
 
	private SQLiteDatabase bdd;
 
	private MaBase maBaseSQLite;
	public ClientBD(){
		//On crée la BDD et sa table
		maBaseSQLite = new MaBase(null, NOM_BDD, null, VERSION_BDD);
	}
 
	public ClientBD(Context context){
		//On crée la BDD et sa table
		maBaseSQLite = new MaBase(context, NOM_BDD, null, VERSION_BDD);
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
 
	public long insertClient(Client client){
		//Création d'un ContentValues (fonctionne comme une HashMap)
		ContentValues values = new ContentValues();
		//on lui ajoute une valeur associée à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
		values.put(COL_NOM, client.getNom());
		values.put(COL_LOGIN, client.getLogin());
		values.put(COL_PASS, client.getPass());
		values.put(COL_PAYS, client.getPays());
		values.put(COL_VILLE, client.getVille());
		values.put(COL_QUARTIER, client.getQuartier());
		values.put(COL_ADRESSE, client.getAdresse());
		//on insère l'objet dans la BDD via le ContentValues
		return bdd.insert(TABLE_CLIENTS, null, values);
	}
	 
	
	public int removeClientWithID(int id){
		//Suppression d'un livre de la BDD grâce à l'ID
		return bdd.delete(TABLE_CLIENTS, COL_ID + " = " +id, null);
	}
 
	public Client getProduitWithPass(String pass){
		//Récupère dans un Cursor les valeurs correspondant à un livre contenu dans la BDD (ici on sélectionne le livre grâce à son titre)
		Cursor c = bdd.query(TABLE_CLIENTS, new String[] {COL_ID, COL_NOM, COL_LOGIN,COL_PASS,COL_PAYS,COL_VILLE,COL_QUARTIER,COL_ADRESSE}, COL_PASS + " LIKE \"" + pass +"\"", null, null, null, null);
		return cursorToClient(c);
	}
	/*public Produit getProduitWithCategorie(String categorie){
		//Récupère dans un Cursor les valeurs correspondant à un livre contenu dans la BDD (ici on sélectionne le livre grâce à son titre)
		Cursor c = bdd.query(TABLE_PRODUITS, new String[] {COL_ID, COL_NOM, COL_PRIX,COL_CATEGORIE,COL_LIEU}, COL_CATEGORIE + " LIKE \"" + categorie +"\"", null, null, null, null);
		return cursorToProduit(c);
	}*/
	
	//Cette méthode permet de convertir un cursor en un livre
	private Client cursorToClient(Cursor c){
		//si aucun élément n'a été retourné dans la requête, on renvoie null
		if (c.getCount() == 0)
			return null;
 
		//Sinon on se place sur le premier élément
		c.moveToFirst();
		//c.moveToNext();
		//On créé un livre
		Client client = new Client();
		//on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
		client.setId(c.getInt(NUM_COL_ID));
		client.setNom(c.getString(NUM_COL_NOM));
		client.setLogin(c.getString(NUM_COL_LOGIN));
		client.setPass(c.getString(NUM_COL_PASS));
		client.setPays(c.getString(NUM_COL_PAYS));
		client.setVille(c.getString(NUM_COL_VILLE));
		client.setQuartier(c.getString(NUM_COL_QUARTIER));
		client.setAdresse(c.getString(NUM_COL_ADRESSE));
		//On ferme le cursor
		c.close();
 
		//On retourne le livre
		return client;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
