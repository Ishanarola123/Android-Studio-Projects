package com.example.language_translator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.ml.naturallanguage.FirebaseNaturalLanguage;

public class MainActivity extends AppCompatActivity {

Spinner fromspinner,tospinner;
TextInputEditText  srcText;
ImageView micIv;
MaterialButton translatebtn;
TextView translatedTv;


//languages stored into array

//    for from spinner it stored into fromlanguage
    String[]  fromLanguage={"From","English","Afrikaans","Arabic","Belarusian","Bengali","Catalan","Czech","Welsh",
                            "Hindi","Urdu"};


    //   for to spinner it stored into tolanguage
    String[]  toLanguage={"TO","English","Afrikaans","Arabic","Belarusian","Bengali","Catalan","Czech","Welsh",
            "Hindi","Urdu"};

    private static final int REQUEST_PERMISSION_CODE=1;
    int languagecode,fromlanguagecode,tolanguagecode=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fromspinner=(Spinner) findViewById(R.id.idfromspinner);
        tospinner=(Spinner) findViewById(R.id.idtospinner);
        srcText=(TextInputEditText) findViewById(R.id.ideditsource);
        micIv=findViewById(R.id.idMicIv);
        translatebtn=findViewById(R.id.idbtntranslate);
        translatedTv=findViewById(R.id.idtranslatedtv);


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
        ArrayAdapter fromAdapter=new ArrayAdapter(this,R.layout.spinner_item,fromLanguage);
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
        ArrayAdapter toAdapter=new ArrayAdapter(this,R.layout.spinner_item,toLanguage);
        //set dropdown menu

        toAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //set this adpter into toadpter ->tospinner
        tospinner.setAdapter(toAdapter);




    }

    private int getLanguagecode(String language) {

//        String[]  fromLanguage={"From","English","Afrikaans","Arabic","Belarusian","Bengali","Catalan","Czech","Welsh",
//                "Hindi","Urdu"};
        int languagecode=0;
        switch (language){
            case "English":
             languagecode=


        }

        return languagecode;
    }
}