package com.example.bizzgo;

import android.app.Activity;
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
import android.widget.TextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.view.MotionEvent;
import android.view.View.OnClickListener;

public class Rechercher extends Activity{
	EditText nom= null;
	TextView result = null;
	Button chercher = null;
	Button retour = null;
	ProduitsBD produitBd = new ProduitsBD(this);
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recherche);
        nom =  (EditText)findViewById(R.id.nom);
	result =  (TextView)findViewById(R.id.result);
	chercher = (Button)findViewById(R.id.chercher);
	retour = (Button)findViewById(R.id.retour);
	retour.setOnClickListener(retourListener);
	chercher.setOnClickListener(chercherListener);
	};
	
	public OnClickListener  retourListener = new OnClickListener() {
    	@Override
    	public void onClick(View v){
    		/*Intent login = new Intent(getApplicationContext(),
                    BizzGo.class);
    			startActivity(login);*/
    		setResult(50);
    		finish();
    	}
	};
	
	public OnClickListener  chercherListener = new OnClickListener() {
    	@Override
    	public void onClick(View v){
    		 

    		nom =  (EditText)findViewById(R.id.nom);
        	//lieu =  (EditText)findViewById(R.id.lieu);
        	String n = nom.getText().toString();
        	//String l = lieu.getText().toString();
        	 produitBd.open();
        	Cursor cc=produitBd.getProdWithNom(n);
        	//Cursor cs=produitBd.afficheProduit(l, c);
        	//cc.moveToFirst();
        	 String T="";
        
        	while (cc.moveToNext()) {
        		Produit produitFromBd = produitBd.cursorProduit(cc);
        		/*Integer index = cc.getColumnIndex("COL_ID");
        		Integer id = cc.getInt(index);
        		result.setText("\n"+id);*/
        		T=""+T+"\n"+produitFromBd.toString();
        		 //result.setText("\n"+produitFromBd.toString()+" \n");
        	}
        	result.setText("\n"+T+" \n");
        	produitBd.close();
    	}
	};
	
    	
}
