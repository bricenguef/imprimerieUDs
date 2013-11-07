package com.example.bizzgo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class Accueil extends Activity {
ImageButton quitter = null;
ImageButton suivant = null;

	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.accueil);
	        //on fait pointer nos boutons sur les boutons du fichier xml
	        suivant = (ImageButton)findViewById(R.id.suivant);
	        quitter = (ImageButton)findViewById(R.id.quitter);
	        //ajout des ecouteurs aux boutons
	        suivant.setOnClickListener(suivantListener);
	        quitter.setOnClickListener(quitterListener);

}
	 public OnClickListener  suivantListener = new OnClickListener() {
	    	@Override
	    	public void onClick(View v){
	    			Intent bizzgo = new Intent(getApplicationContext(),
	                        BizzGo.class);
	        startActivity(bizzgo);
}		};

public OnClickListener  quitterListener = new OnClickListener() {
	@Override
	public void onClick(View v){
		finish();
		
	}
};
}
	    	