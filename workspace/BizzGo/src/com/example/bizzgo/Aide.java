package com.example.bizzgo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
public class Aide extends Activity{
	ImageButton retour = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aide);
        retour = (ImageButton)findViewById(R.id.retour);
		retour.setOnClickListener(retourListener);
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
	
}
