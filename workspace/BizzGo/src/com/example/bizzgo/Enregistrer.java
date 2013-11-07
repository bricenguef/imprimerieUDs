package com.example.bizzgo;

import android.os.Bundle;
import java.sql.*;



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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.view.MotionEvent;
import android.view.View.OnClickListener;

	
public class Enregistrer extends Activity{
	private String log;
	Spinner spinner=null;
	//Button quitter = null; 
	RadioGroup group = null;
	Button soumettre = null;
	Button retour = null;
	EditText nom= null;
	EditText prix= null;
	//EditText cat= null;
	EditText lieu= null;
	TextView result = null;
	TextView message = null;
	ProduitsBD produitBd = new ProduitsBD(this);
	 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enregistrer);
        result =  (TextView)findViewById(R.id.result);
		soumettre = (Button)findViewById(R.id.soumettre);
		retour = (Button)findViewById(R.id.retour);
		 spinner= (Spinner)findViewById(R.id.categorie);
		    ArrayAdapter adapter = ArrayAdapter.createFromResource(
		            this, R.array.planets, android.R.layout.simple_spinner_item);
		    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		    spinner.setAdapter(adapter);
		retour.setOnClickListener(retourListener);
		soumettre.setOnClickListener(soumettreListener);
		message =  (TextView)findViewById(R.id.message);
		 Bundle objetbunble  = this.getIntent().getExtras();

		if (objetbunble != null && objetbunble.containsKey("log")) {
        	log = this.getIntent().getStringExtra("log");
        	message.setText("     Bienvenue   Me/Mr :"+log);  
        }else {
        	//Erreur
        	log = "Error";
        	
        }

     	
		
    
};

public OnClickListener  retourListener = new OnClickListener() {
	@Override
	public void onClick(View v){
		setResult(50);
		finish();
		Bundle objetbunble = new Bundle();
		objetbunble.putString("login", log);
		Intent logi = new Intent(getApplicationContext(),
         BizzGo.class);
		startActivity(logi);
		logi.putExtras(objetbunble);
		

		
	}
};
 public OnClickListener  quitterListener = new OnClickListener() {
    	@Override
    	public void onClick(View v){
    		setResult(50);
    		finish();
    		
    	}
 };
public OnClickListener  soumettreListener = new OnClickListener() {
	@Override
	public void onClick(View v){
		nom =  (EditText)findViewById(R.id.nom);
    	prix = (EditText)findViewById(R.id.prix);
    	//cat =  (EditText)findViewById(R.id.categorie);
    	lieu = (EditText)findViewById(R.id.lieu);
		String n = nom.getText().toString();
    
    	String pp = prix.getText().toString();
    	//String c = prix.getText().toString();
    	String cate = spinner.getSelectedItem().toString();
    	String l = lieu.getText().toString();
    	Integer p=Integer.valueOf(pp);
        
        //string à afficher dans le TextView
         Produit pr =null;
         Produit produit= new Produit(n,p,cate,l);
         produitBd.open();
         //On insère le produit que l'on vient de créer
         produitBd.insertProduit(produit);
       //Pour vérifier que l'on a bien créé notre livre dans la BDD
         //on extrait le produit de la BDD grâce a la categorie que l'on a créé précédemment
         Produit produitFromBd = produitBd.getProduitWithNom(produit.getNom());
         if(produitFromBd != null){
         	//On affiche les infos du produit dans un Toast
         	
         	Toast.makeText(Enregistrer.this, produitFromBd.toString(), Toast.LENGTH_LONG).show();
         	//test de recupération de la liste
         }
		
		result.setText("\t SUCESSFULL INSERTION OF PRODUIT \n"+produitFromBd.toString()+" \n \t IN BDD !!!");
	}
};
}
