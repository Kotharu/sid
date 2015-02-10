package com.example.sid;

import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
public class UpperCase extends ActionBarActivity implements TextToSpeech.OnInitListener {
	
	long startTime, elapsedTime;
	
	int count = 0,imagecount = 0,speakcount = 1,temp= 0,hit = 0, right =0,score = 0;
	
	String announce;
	
	boolean [] answered = new boolean [27];
	
	final Calendar c = Calendar.getInstance();
	
	DataStore ds = new DataStore();
	
	private TextToSpeech tts;
	
	Random r = new Random();
	
	Button btnClosePopup;
	Button btnCreatePopup;
	
	private PopupWindow pwindo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_uppercase);
		
		ds.setValues();
		
		tts = new TextToSpeech(this, this);
		speakOut(count);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.upper_case, menu);
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
	
	public void onInit(int status) {
		 
        if (status == TextToSpeech.SUCCESS) {
 
            int result = tts.setLanguage(Locale.ENGLISH);
 
//        	int result = tts.setLanguage(new Locale("en", "UK"));
        	
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                speakOut(count);
            }
 
        } else {
            Log.e("TTS", "Initilization Failed!");
        }
 
    }
	
	private void speakOut(int c) {
		 
       String text = ds.original.get(c);
    	     
        tts.setSpeechRate((float) 0.75);
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
	private void speakOut(String c) {		 
	       String text = c;    	     
	        tts.setSpeechRate((float) 0.75);
	        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
	    }
	
	public void displayALPHABETS(View view){				// Display the alphabets on screen
		
		if(imagecount>=26){
			if (imagecount == 26){
				initiatePopupWindow();
				imagecount++;
			}
			else {
				Intent intent = new Intent(UpperCase.this, MainActivity.class);
				startActivity(intent);
			}
		}
		else{	
		speakOut(speakcount);
		ImageButton v1 = new ImageButton(this);
		ImageButton v2 = new ImageButton(this);
		ImageView v3 = new ImageView(this);
		ImageView v4 = new ImageView(this);
		ImageView v5 = new ImageView(this);
		
		v1 = (ImageButton) findViewById(R.id.imageButton2);
		v2 = (ImageButton) findViewById(R.id.imageButton3);
		v3 = (ImageView) findViewById(R.id.imageView1);
		v4 = (ImageView) findViewById(R.id.imageView2);
		v5 = (ImageView) findViewById(R.id.imageView3);
		
		int resID0 = getResources().getIdentifier(ds.labels[imagecount][0],
				"drawable", getPackageName());
		int resID1 = getResources().getIdentifier(ds.labels[imagecount][1],
				"drawable", getPackageName());

		temp = r.nextBoolean() ? 0 : 1;

		if (temp == 0) {
			v1.setImageDrawable(getResources().getDrawable(resID0));
			v2.setImageDrawable(getResources().getDrawable(resID1));
		} else {
			v1.setImageDrawable(getResources().getDrawable(resID1));
			v2.setImageDrawable(getResources().getDrawable(resID0));
		}

		v3.setImageResource(R.drawable.blank1);
		v4.setImageResource(R.drawable.blank2);
		v5.setImageResource(R.drawable.blank2);
		
		ImageButton backbutton = new ImageButton(this);
		backbutton = (ImageButton) findViewById(R.id.imageButton4);
		
		imagecount++;
		speakcount++;
		
		if(imagecount>0)
			backbutton.setImageResource(R.drawable.backward_arrow);
		else
			backbutton.setEnabled(false);
		hit = 0;
		
		System.out.println("The score is"+ (right* 100)/26 +"%");
		}
	}
	
	public void goBack(View view){				// Go to previous screen
		
		ImageButton backbutton = new ImageButton(this);
		backbutton = (ImageButton) findViewById(R.id.imageButton4);
		
		imagecount--; // first decrement to counter the increased value at the end of displayALPHABETS block
		imagecount--; // second decrement to go back
		speakcount--; // Similar to imagecount
		speakcount--;
		if(imagecount<0){
			Intent intent = new Intent(UpperCase.this, MainActivity.class);
		    startActivity(intent);			
		}
		else{
		speakOut(speakcount);		
		
		/*if(imagecount<1){
			backbutton.setImageResource(R.drawable.blank3);
			backbutton.setEnabled(false);
		}*/
		
		ImageButton v1 = new ImageButton(this);
		ImageButton v2 = new ImageButton(this);
		ImageView v3 = new ImageView(this);
		ImageView v4 = new ImageView(this);
		ImageView v5 = new ImageView(this);
		
		v1 = (ImageButton) findViewById(R.id.imageButton2);
		v2 = (ImageButton) findViewById(R.id.imageButton3);
		v3 = (ImageView) findViewById(R.id.imageView1);
		v4 = (ImageView) findViewById(R.id.imageView2);
		v5 = (ImageView) findViewById(R.id.imageView3);
		
		int resID0 = getResources().getIdentifier(ds.labels[imagecount][0],
				"drawable", getPackageName());
		int resID1 = getResources().getIdentifier(ds.labels[imagecount][1],
				"drawable", getPackageName());

		temp = r.nextBoolean() ? 0 : 1;

		if (temp == 0) {
			v1.setImageDrawable(getResources().getDrawable(resID0));
			v2.setImageDrawable(getResources().getDrawable(resID1));
		} else {
			v1.setImageDrawable(getResources().getDrawable(resID1));
			v2.setImageDrawable(getResources().getDrawable(resID0));
		}

		v3.setImageResource(R.drawable.blank1);
		v4.setImageResource(R.drawable.blank2);
		v5.setImageResource(R.drawable.blank2);
		imagecount++;  //Resetting to regular value after going back
		speakcount++;
		}

	}
	
	public void validationforFirstbutton(View v){				// Check if correct option is chosen
		
		System.out.print(imagecount);
		if(answered[imagecount] == false)
			answered[imagecount] = true;
		else
			hit++;
		
		System.out.println(" fine here");

		ImageView v3 = new ImageView(this);
		ImageView v4 = new ImageView(this);
		ImageView v5 = new ImageView(this);
		
		v3 = (ImageView) findViewById(R.id.imageView1);
		v4 = (ImageView) findViewById(R.id.imageView2);
		v5 = (ImageView) findViewById(R.id.imageView3);
		
		if (temp == 0) {
			if (imagecount == 15 || imagecount == 24) {
				v3.setImageResource(R.drawable.correct);
				v4.setImageResource(R.drawable.blank2);
				v5.setImageResource(R.drawable.welldone);
				if (hit == 0) {
					hit++;				// hit is to identify which of the two alphabets is already hit at a given time
					right++;
				}
			} else {
				v3.setImageResource(R.drawable.correct);
				v4.setImageResource(R.drawable.blank2);
				v5.setImageResource(R.drawable.welldone);
				if (hit == 0) {
					hit++;				
					right++;
				}
			}
		} else {
			if (imagecount == 15 || imagecount == 24) {
				v3.setImageResource(R.drawable.correct);
				v4.setImageResource(R.drawable.blank2);
				v5.setImageResource(R.drawable.welldone);
				if (hit == 0) {
					hit++;				
					right++;
				}
			} else {
				v3.setImageResource(R.drawable.wrong);
				v4.setImageResource(R.drawable.blank2);
				v5.setImageResource(R.drawable.notbad);
				if (hit == 0)
					hit++;
			}
		}
		
		score = (right* 100)/26;
		if(imagecount == 26){
				initiatePopupWindow();
		}
	
	}
	
public void validationforSecondbutton(View v){				// Check if correct option is chosen
		
	if(answered[imagecount] == false)
		answered[imagecount] = true;
	else
		hit++;	
	
		ImageView v3 = new ImageView(this);
		ImageView v4 = new ImageView(this);
		ImageView v5 = new ImageView(this);
		
		v3 = (ImageView) findViewById(R.id.imageView1);
		v4 = (ImageView) findViewById(R.id.imageView2);
		v5 = (ImageView) findViewById(R.id.imageView3);
		
		if (temp == 1) {
			if (imagecount == 15 || imagecount == 24) {
				v3.setImageResource(R.drawable.blank1);
				v4.setImageResource(R.drawable.correct);
				v5.setImageResource(R.drawable.welldone);
				if (hit == 0) {
					hit++;				
					right++;
				}
			} else {
				v3.setImageResource(R.drawable.blank1);
				v4.setImageResource(R.drawable.correct);
				v5.setImageResource(R.drawable.welldone);
				if (hit == 0) {
					hit++;
					right++;
				}
			}
		} else {
			if (imagecount == 15 || imagecount == 24) {
				v3.setImageResource(R.drawable.blank1);
				v4.setImageResource(R.drawable.correct);
				v5.setImageResource(R.drawable.welldone);
				if (hit == 0) {
					hit++;				
					right++;
				}
			} else {
				v3.setImageResource(R.drawable.blank1);
				v4.setImageResource(R.drawable.wrong);
				v5.setImageResource(R.drawable.notbad);
				if (hit == 0)
					hit++;
			}
		}
		
		score = (right* 100)/26;
		if(imagecount == 26){
				initiatePopupWindow();
		}
		
	}

/** Pop up window manager **/

	private void initiatePopupWindow() {
		try {
			// need to get the instance of the LayoutInflater
			LayoutInflater inflater = (LayoutInflater) UpperCase.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View layout = inflater.inflate(R.layout.popup_score,(ViewGroup) findViewById(R.id.popup_element));
			pwindo = new PopupWindow(layout, 600, 670, true);
			
			TextView t1 = new TextView(this);
			t1 = (TextView)pwindo.getContentView().findViewById(R.id.popup_text);
			String sc = String.valueOf(score);
			sc = sc+"%" ;
			t1.setText(sc);
			
			if(score == 100)
				announce = "Congratulations you've scored 100%";
			else
				announce = "you scored "+sc;
			speakOut(announce);
			
			pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);

			btnClosePopup = (Button) layout.findViewById(R.id.popup_close);
			btnClosePopup.setOnClickListener(close_popup_window);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private OnClickListener close_popup_window = new OnClickListener() {
		public void onClick(View v) {
			pwindo.dismiss();

		}
	};
	
	/** Called when the user touches the home button */
	public void callHome(View view){
		
		Intent intent = new Intent(UpperCase.this, MainActivity.class);
	    startActivity(intent);
	    
	}

/** closing tts **/

	public void onDestroy() {
        // Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
	
}
