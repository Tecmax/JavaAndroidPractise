package com.stacktips.speechtotext;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class TextToSpeechActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    private EditText mEditText;
    private Button mBtnSpeak;

    private TextToSpeech mTts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_speech);
        mEditText = (EditText) findViewById(R.id.wordToSpeak);
        mBtnSpeak = (Button) findViewById(R.id.btnSpeak);

        mTts = new TextToSpeech(this, this);

        mBtnSpeak.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String textToSpeak = mEditText.getText().toString();
                speak(textToSpeak);
            }
        });
    }

    private void speak(String textToSpeak) {
        mTts.speak(textToSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    public void onInit(int status) {

        // status can be either TextToSpeech.SUCCESS or TextToSpeech.ERROR
        if (status == TextToSpeech.SUCCESS) {
            // Set preferred language to US english.
            // Note that a language may not be available, and the result will indicate this.
            int result = mTts.setLanguage(Locale.CANADA_FRENCH);

            if (result == TextToSpeech.LANG_MISSING_DATA ||
                    result == TextToSpeech.LANG_NOT_SUPPORTED) {
                // Lanuage data is missing or the language is not supported.
                Log.e("404", "Language is not available.");
            }
        } else {
            // Initialization failed.
            // May be its not installed so we prompt it to be installed
            Intent installIntent = new Intent();
            installIntent.setAction(
                    TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
            startActivity(installIntent);
        }

    }

    @Override
    public void onDestroy() {
        if (mTts != null) {
            mTts.stop();
            mTts.shutdown();
        }
        super.onDestroy();
    }

    public void goToNext(View view) {
        startActivity(new Intent(TextToSpeechActivity.this, MainActivity.class));
    }
}
