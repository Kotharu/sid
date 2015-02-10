package com.example.sid;

import java.util.Locale;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.speech.tts.TextToSpeech;

public class MainActivity extends ActionBarActivity implements TextToSpeech.OnInitListener{

	private TextToSpeech tts;
    private Button btnSpeak;
    private EditText txtText;
    
    String guidelines;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
 
		setContentView(R.layout.activity_main);
		
		tts = new TextToSpeech(this, this);
		 
        /*btnSpeak = (Button) findViewById(R.id.button2);
        
     // button on click event
        btnSpeak.setOnClickListener(new View.OnClickListener() {
 
            @Override
            public void onClick(View arg0) {
                speakOut();
            } });*/
	}
	
	@Override
    public void onDestroy() {
        // Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
	
	public void onInit(int status) {
		 
        if (status == TextToSpeech.SUCCESS) {
 
            int result = tts.setLanguage(Locale.ENGLISH);
 
//        	int result = tts.setLanguage(new Locale("en", "UK"));
        	
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
//                btnSpeak.setEnabled(true);
                speakOut();
            }
 
        } else {
            Log.e("TTS", "Initilization Failed!");
        }
 
    }
 
    private void speakOut() {
 
        String text = "Let's play a little game. Shall we? ";
    	        
        tts.setSpeechRate((float) 0.75);
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
    private void speakOut(String c) {
    	 
        String text = c;
    	        
        tts.setSpeechRate((float) 0.5);
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	/** Called when the user touches the button */
	public void enterFirstScreen(View view){
		
		Intent intent_capitals = new Intent(MainActivity.this, UpperCase.class);
		guidelines = "hit on the pictures with Capital letters to enter your answer. click the arrow button at the bottom to start";
		speakOut(guidelines);
	    startActivity(intent_capitals);	    
	}
	
	public void enterSecondScreen(View view){
		Intent intent_smalls = new Intent(MainActivity.this, LowerCase.class);
		guidelines = "hit on the pictures with small letters to enter your answer. click the arrow button at the bottom to start";
		speakOut(guidelines);
		startActivity(intent_smalls);	 
	}
	
	public void enterThirdScreen(View view){
		Intent intent_digits = new Intent(MainActivity.this, Numbers.class);
		guidelines = "hit on the pictures with numbers to enter your answer. click the arrow button at the bottom to start";
		speakOut(guidelines);
		startActivity(intent_digits);	 
	}
	
	}
	

