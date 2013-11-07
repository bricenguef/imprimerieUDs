package com.example.bizzgo;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;
import android.database.Cursor;
import android.view.Menu;
import android.view.MotionEvent;

public class dialog extends Activity{
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compte);
        
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
            	if(lo.equals("admin") && pa.equals("admin")){
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
            	else{
            		Intent login = new Intent(getApplicationContext(),
                            dialog.class);
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
            	finish();
          } });
       
       
        adb.show();
        
    }
	 
}
