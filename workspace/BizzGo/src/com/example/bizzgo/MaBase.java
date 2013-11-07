package com.example.bizzgo;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
public class MaBase extends SQLiteOpenHelper{
	private static final String TABLE_CLIENTS = "table_clients";
	private static final String COL_ID = "ID";
	private static final String COL_NOM = "NOM";
	private static final String COL_LOGIN = "LOGIN";
	private static final String COL_PASS = "PASS";
	private static final String COL_PAYS = "PAYS";
	private static final String COL_VILLE = "VILLE";
	private static final String COL_QUARTIER = "QUARTIER";
	private static final String COL_ADRESSE = "ADRESSE";
 
	private static final String CREATE_BDD = "CREATE TABLE " + TABLE_CLIENTS + " ("
	+ COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NOM + " TEXT NOT NULL, " + COL_LOGIN + " TEXT NOT NULL, "
	+ COL_PASS + " TEXT NOT NULL, " + COL_PAYS + " TEXT NOT NULL," + COL_VILLE + " TEXT NOT NULL," + COL_QUARTIER+ " TEXT NOT NULL," + COL_ADRESSE + " TEXT NOT NULL);";
 
	public MaBase(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}
 
	@Override
	public void onCreate(SQLiteDatabase db) {
		//on crée la table à partir de la requête écrite dans la variable CREATE_BDD
		db.execSQL(CREATE_BDD);
	}
 
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//On peut faire ce qu'on veut ici moi j'ai décidé de supprimer la table et de la recréer
		//comme ça lorsque je change la version les id repartent de 0
		db.execSQL("DROP TABLE " + TABLE_CLIENTS + ";");
		onCreate(db);
	}

}
