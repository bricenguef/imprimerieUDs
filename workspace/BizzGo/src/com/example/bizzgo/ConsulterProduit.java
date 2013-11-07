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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.view.MotionEvent;
import android.view.View.OnClickListener;

public class ConsulterProduit extends Activity{
	Spinner spinner=null;
	//EditText cat= null;
	TextView result = null;
	Button afficher = null;
	Button retour = null;
	ProduitsBD produitBd = new ProduitsBD(this);
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste);
	result =  (TextView)findViewById(R.id.result);
	afficher = (Button)findViewById(R.id.afficher);
	retour = (Button)findViewById(R.id.retour);
	 spinner= (Spinner)findViewById(R.id.spinner);
	    ArrayAdapter adapter = ArrayAdapter.createFromResource(
	            this, R.array.planets, android.R.layout.simple_spinner_item);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner.setAdapter(adapter);
	retour.setOnClickListener(retourListener);
	afficher.setOnClickListener(afficherListener);
	AlertDialog.Builder adb = new AlertDialog.Builder(this);
		adb.setTitle("Veuillez entrer une categorie de produit deja existante pour effectuer la recherche");
		adb.setPositiveButton("Ok", null);

	};
	@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
		switch(requestCode){
    	case 1:
		AlertDialog.Builder adb = new AlertDialog.Builder(this);
		adb.setTitle("Veuillez entrer une categorie de produit deja existante pour effectuer la recherche");
		adb.setPositiveButton("Ok", null);
		}
	}

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
	
	public OnClickListener  afficherListener = new OnClickListener() {
    	@Override
    	public void onClick(View v){
    		 

    		//cat =  (EditText)findViewById(R.id.categorie);
    		String item = spinner.getSelectedItem().toString();
        	//lieu =  (EditText)findViewById(R.id.lieu);
        	//String c = cat.getText().toString();
        	//String l = lieu.getText().toString();
        	 produitBd.open();
        	Cursor cc=produitBd.getProduitWithCategorie(item);
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
