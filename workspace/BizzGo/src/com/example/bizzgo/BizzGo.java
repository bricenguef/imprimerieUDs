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
import android.widget.ImageButton;
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


public class BizzGo extends Activity {
	
	ImageButton valider = null;
	ImageButton Radio1 = null;
	ImageButton Radio2 = null;
    ImageButton Radio3 = null;
	ImageButton quitter = null; 
	ImageButton Radio0 = null; 
	ImageButton aide = null; 
    String log;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bizz_go);
        valider = (ImageButton)findViewById(R.id.valider);
        quitter = (ImageButton)findViewById(R.id.quitter);
        Radio0 = (ImageButton)findViewById(R.id.Radio0);
        Radio1 = (ImageButton)findViewById(R.id.Radio1);
        Radio2= (ImageButton)findViewById(R.id.Radio2);
        Radio3 = (ImageButton)findViewById(R.id.Radio3);
        aide = (ImageButton)findViewById(R.id.aide);
    	valider.setOnClickListener(validerListener);
    	Radio0.setOnClickListener(Radio0Listener);
    	Radio1.setOnClickListener(Radio1Listener);
    	Radio2.setOnClickListener(Radio2Listener);
    	Radio3.setOnClickListener(Radio3Listener);
    	aide.setOnClickListener(aideListener);
    	quitter.setOnClickListener(quitterListener);
    	
    	
    }
    public OnClickListener  validerListener = new OnClickListener() {
    	@Override
    	public void onClick(View v){
    		Radio1.setVisibility(0);
    		Radio2.setVisibility(0);
    		Radio3.setVisibility(0);
    		//quitter.setVisibility(0);

    	}
    	};
    	
    	
    	 public OnClickListener  quitterListener = new OnClickListener() {
    	    	@Override
    	    	public void onClick(View v){
    	    		setResult(50);
            		finish();
            		
    	    	}
    	 };
    	 public OnClickListener  Radio0Listener = new OnClickListener() {
  	    	@Override
  	    	public void onClick(View v){
  	    		Intent login = new Intent(getApplicationContext(),
                         Utilisateur.class);
         startActivity(login);
          		
  	    	}
  	 };
    	 public OnClickListener  Radio1Listener = new OnClickListener() {
 	    	@Override
 	    	public void onClick(View v){
 	    		Intent login = new Intent(getApplicationContext(),
                        Connexion.class);
        startActivity(login);
         		
 	    	}
 	 };
 	public OnClickListener  Radio2Listener = new OnClickListener() {
    	@Override
    	public void onClick(View v){
    		
    		Intent login = new Intent(getApplicationContext(),
                    ConsulterProduit.class);
    startActivity(login);
    		
    	}
 };
 public OnClickListener  Radio3Listener = new OnClickListener() {
 	@Override
 	public void onClick(View v){
 		Intent login = new Intent(getApplicationContext(),
                Rechercher.class);
startActivity(login);
 		
 	}
};
public OnClickListener  aideListener = new OnClickListener() {
 	@Override
 	public void onClick(View v){
 		Intent login = new Intent(getApplicationContext(),
                Aide.class);
startActivity(login);
 		
 	}
};
        	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_bizz_go, menu);
        return true;
    }
}