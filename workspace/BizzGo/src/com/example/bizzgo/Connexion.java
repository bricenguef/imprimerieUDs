package com.example.bizzgo;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import android.database.Cursor;
import android.view.Menu;
import android.view.MotionEvent;

public class Connexion extends Activity{
	TextView result = null;
	ClientBD clientBd = new ClientBD(this);
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bizz_go);
        
        //On instancie notre layout en tant que View
        LayoutInflater factory = LayoutInflater.from(this);
        final View alertDialogView = factory.inflate(R.layout.compte, null);
 
        //Création de l'AlertDialog
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
 
        //On affecte la vue personnalisé que l'on a crée à notre AlertDialog
        adb.setView(alertDialogView);
 
        //On donne un titre à l'AlertDialog
        adb.setTitle("Parametres de connexion");
 
        //On modifie l'icône de l'AlertDialog pour le fun ;)
        adb.setIcon(android.R.drawable.ic_dialog_alert);
 
        //On affecte un bouton "OK" à notre AlertDialog et on lui affecte un évènement
        adb.setPositiveButton("CONNEXION", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
 
            	//Lorsque l'on cliquera sur le bouton "OK", on récupère l'EditText correspondant à notre vue personnalisée (cad à alertDialogView)
            	EditText logi = (EditText)alertDialogView.findViewById(R.id.login);
            	EditText pas = (EditText)alertDialogView.findViewById(R.id.pass);
            	String lo = logi.getText().toString();
            	String pa = pas.getText().toString();
            	clientBd.open();
            	Client client=clientBd.getProduitWithPass(pa);
            	if(client != null){
            		
            		Bundle objetbunble = new Bundle();
            		objetbunble.putString("log", client.getNom());
                     
                 	//On affiche les infos du produit dans un Toast
            		Intent login = new Intent(getApplicationContext(),
                            Enregistrer.class);
            		login.putExtras(objetbunble);
            		 
            startActivity(login);
                 /*	Toast.makeText(Connexion.this, client.toString(), Toast.LENGTH_LONG).show();
                 	//test de recupération de la liste
                 	result =  (TextView)findViewById(R.id.result);
                 	result.setText("Bienvenue"+client.getNom());*/
            setResult(50);
 			finish();
                 }
            	if(lo.equals("bizzgo") && pa.equals("admin")){
            		 setResult(50);
         			finish();
            		Intent login = new Intent(getApplicationContext(),
                            Enregistrer.class);
            startActivity(login);
            		/*setContentView(R.layout.enregistrer);
        			result =  (TextView)findViewById(R.id.result);
        			soumettre = (Button)findViewById(R.id.soumettre);
        			retour = (Button)findViewById(R.id.retour);
        			retour.setOnClickListener(retourListener);
        			soumettre.setOnClickListener(soumettreListener);*/
            	}
            	
            	else if(client==null){
            		 setResult(50);
            			finish();
            		Intent login = new Intent(getApplicationContext(),
                            Connexion.class);
            startActivity(login);
            		 
            		
            	        //On instancie notre layout en tant que View
            	        
        			
            	}
 
            	//On affiche dans un Toast le texte contenu dans l'EditText de notre AlertDialog
            	//Toast.makeText(dialog.this, et.getText(), Toast.LENGTH_SHORT).show();
          } });
 
        //On crée un bouton "Annuler" à notre AlertDialog et on lui affecte un évènement
        adb.setNegativeButton("RETOUR", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            	//Lorsque l'on cliquera sur annuler on quittera l'application
            	/*Intent login = new Intent(getApplicationContext(),
                        BizzGo.class);
        startActivity(login);*/
        setResult(50);
		finish();
          } });
       
       
        adb.show();
        
    }
	 
}
