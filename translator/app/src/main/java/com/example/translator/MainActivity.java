package com.example.translator;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.ml.common.modeldownload.FirebaseModelDownloadConditions;
import com.google.firebase.ml.naturallanguage.FirebaseNaturalLanguage;
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslateLanguage;
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslator;
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslatorOptions;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Spinner fromspinner, tospinner;
    TextInputEditText srcText;
    ImageView micIv;
    MaterialButton translatebtn;
    TextView translatedTv;

    //languages stored into array

    //    for from spinner it stored into fromlanguage
    String[] fromLanguage = {"From", "English", "Afrikaans", "Arabic", "Belarusian", "Bengali", "Catalan", "Czech", "Welsh",
            "Hindi", "Urdu"};


    //   for to spinner it stored into tolanguage
    String[] toLanguage = {"TO", "English", "Afrikaans", "Arabic", "Belarusian", "Bengali", "Catalan", "Czech", "Welsh",
            "Hindi", "Urdu"};


    final int REQUEST_PERMISSION_CODE = 1;
    int languagecode = 0;
    int fromlanguagecode = 0;
    int tolanguagecode = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fromspinner = (Spinner) findViewById(R.id.idfromspinner);
        tospinner = (Spinner) findViewById(R.id.idtospinner);
        srcText = (TextInputEditText) findViewById(R.id.ideditsource);
        micIv = findViewById(R.id.idMicIv);
        translatebtn = findViewById(R.id.idbtntranslate);
        translatedTv = findViewById(R.id.idtranslatedtv);

//set iteam into fromlanguage
        fromspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                fromlanguagecode = getLanguagecode(fromLanguage[i]);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //attch this adpter into spinner_item file
        ArrayAdapter fromAdapter = new ArrayAdapter(this, R.layout.spinner_item, fromLanguage);
        //set dropdown menu

        fromAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //set this adpter into fromadpter ->fromspinner
        fromspinner.setAdapter(fromAdapter);


        //for tospinner

        tospinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                tolanguagecode = getLanguagecode(toLanguage[i]);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //attch this adpter into spinner_item file
        ArrayAdapter toAdapter = new ArrayAdapter(this, R.layout.spinner_item, toLanguage);
        //set dropdown menu

        toAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //set this adpter into toadpter ->tospinner
        tospinner.setAdapter(toAdapter);

        micIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=  new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"say something to tanslate");
                try{
                    startActivity(intent);
                }
                catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        translatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                translatedTv.setText("");
                if (srcText.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "please enter the text", Toast.LENGTH_LONG).show();
                }
                else if(fromlanguagecode == 0){
                    Toast.makeText(getApplicationContext(), "please select language(source)", Toast.LENGTH_SHORT).show();

                }

                else if(tolanguagecode == 0){
                    Toast.makeText(getApplicationContext(), "please select language want you translate to it", Toast.LENGTH_SHORT).show();
                }
                else{
                    translatetext(fromlanguagecode,tolanguagecode,srcText.getText().toString());
                }
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_PERMISSION_CODE){
            ArrayList<String> result=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            srcText.setText(result.get(0));

        }
    }
    private int getLanguagecode(String language) {

//        String[]  fromLanguage={"From","English","Afrikaans","Arabic","Belarusian","Bengali","Catalan","Czech","Welsh",
//                "Hindi","Urdu"};
        int languagecode = 0;
        switch (language) {
            case "English":
                languagecode = FirebaseTranslateLanguage.EN;
                break;

            case "Afrikaans":
                languagecode = FirebaseTranslateLanguage.AF;
                break;

            case "Arabic":
                languagecode = FirebaseTranslateLanguage.AR;
                break;



            case "Belarusian":
                languagecode = FirebaseTranslateLanguage.BE;
                break;



            case "Bengali":
                languagecode = FirebaseTranslateLanguage.BG;
                break;


            case "Catalan":
                languagecode = FirebaseTranslateLanguage.CA;
                break;


            case "Czech":
                languagecode = FirebaseTranslateLanguage.CS;
                break;


            case "Welsh":
                languagecode = FirebaseTranslateLanguage.CY;
                break;

            case "Hindi":
                languagecode = FirebaseTranslateLanguage.HI;
                break;

            case "Urdu":
                languagecode = FirebaseTranslateLanguage.UR;
                break;

            default:
                languagecode=0;

        }

        return languagecode;
    }


    public void translatetext(int fromlanguagecode, int tolanguagecode, String src) {


        //using firebase ML kit
        translatedTv.setText("Downloading");
        FirebaseTranslatorOptions options = new FirebaseTranslatorOptions.Builder()
                .setSourceLanguage(fromlanguagecode)
                .setTargetLanguage(tolanguagecode)
                .build();


        FirebaseTranslator translator = FirebaseNaturalLanguage.getInstance().getTranslator(options);
        FirebaseModelDownloadConditions conditions = new FirebaseModelDownloadConditions.Builder().build();

        translator.downloadModelIfNeeded(conditions).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                translatedTv.setText("transalting");
                translator.translate(src).addOnSuccessListener(new OnSuccessListener<String>() {
                    @Override
                    public void onSuccess(String s) {
                        translatedTv.setText(s);

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "can not translate " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }


        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, "can not download " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }



    }
