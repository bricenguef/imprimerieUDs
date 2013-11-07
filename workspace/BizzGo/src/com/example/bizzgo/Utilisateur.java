package com.example.bizzgo;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.view.MotionEvent;
import android.view.View.OnClickListener;

public class Utilisateur extends Activity {
	
	RadioGroup group = null;
	Button ajouter = null;
	Button retour = null;
	EditText nom= null;
	EditText login= null;
	EditText pass= null;
	EditText pays= null;
	EditText ville= null;
	EditText quartier= null;
	EditText adresse= null;
	TextView result = null;
	ClientBD clientBd = new ClientBD(this);
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.utilisateur);
        result =  (TextView)findViewById(R.id.result);
		ajouter = (Button)findViewById(R.id.ajouter);
		retour = (Button)findViewById(R.id.retour);
		retour.setOnClickListener(retourListener);
		ajouter.setOnClickListener(ajouterListener);
	};
	public OnClickListener  retourListener = new OnClickListener() {
		@Override
		public void onClick(View v){
			
			finish();
		}
	};
	
	public OnClickListener  ajouterListener = new OnClickListener() {
		@Override
		public void onClick(View v){
			nom =  (EditText)findViewById(R.id.nom);
	    	login = (EditText)findViewById(R.id.login);
	    	pass =  (EditText)findViewById(R.id.pass);
	    	pays = (EditText)findViewById(R.id.pays);
	    	ville = (EditText)findViewById(R.id.ville);
	    	quartier = (EditText)findViewById(R.id.quartier);
	    	adresse = (EditText)findViewById(R.id.adresse);
			String n = nom.getText().toString();
	    
	    	String lo = login.getText().toString();
	    	String pas = pass.getText().toString();
	    	String pa = pays.getText().toString();
	    	String vi = ville.getText().toString();
	    	String q = quartier.getText().toString();
	    	String ad = adresse.getText().toString();
	    	
	        
	        //string à afficher dans le TextView
	         Client cl =null;
	         Client client= new Client(n,lo,pas,pa,vi,q,ad);
	         clientBd.open();
	         //On insère le produit que l'on vient de créer
	         try{
	         clientBd.insertClient(client);
	         } catch (Exception e){
	        	 Toast.makeText(Utilisateur.this, e.toString(), Toast.LENGTH_LONG).show();
	         }
	       //Pour vérifier que l'on a bien créé notre livre dans la BDD
	         //on extrait le produit de la BDD grâce a la categorie que l'on a créé précédemment
	         Client clientFromBd = clientBd.getProduitWithPass(client.getPass());
	         if(clientFromBd != null){
	         	//On affiche les infos du produit dans un Toast
	         	
	         	Toast.makeText(Utilisateur.this, clientFromBd.toString(), Toast.LENGTH_LONG).show();
	         	//test de recupération de la liste
	         }
			
			result.setText("\t SUCESSFULL INSERTION OF THIS USER \n"+clientFromBd.toString()+" \n \t IN BDD !!!");
		}
	};
}
