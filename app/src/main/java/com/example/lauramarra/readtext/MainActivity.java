package com.example.lauramarra.readtext;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MainActivity extends ActionBarActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.view);
        getFields();
    }

    public void getFields() {

        BufferedReader bufferedReader = null;
        String codigo, nome, periodo, creditos, preRequisito_1, preRequisito_2, preRequisito_3, diaSemana;
        //long e;
        try {
            String sCurrentLine = null;
            bufferedReader = new BufferedReader(new InputStreamReader(getAssets().open("123.txt")));

            while ((sCurrentLine = bufferedReader.readLine()) != null) {

                //if (sCurrentLine != null);
                String[] message = sCurrentLine.split(",");

                codigo = message[0];
                nome = message[1];
                periodo = message[2];
                creditos = message[3];
                preRequisito_1 = message[4];
                preRequisito_2 = message[5];
                preRequisito_3 = message[6];
                diaSemana = message[7];

                textView.setText("Código: " + codigo + "\n" +
                        "nome: " + nome + "\n" +
                        "periodo: " + periodo + "\n" +
                        "credito: : " + creditos + "\n" +
                        "Pré requisito 1: " + preRequisito_1 + "\n" +
                        "Pré requisito 2: " + preRequisito_2 + "\n" +
                        "Pré requisito 3: " + preRequisito_3 + "\n" +
                        "Dia da semana: " + diaSemana);

                //e = db2.insertRecord(faculty1, deparment1, name1, officeNumber1, phone1, email1, email1);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) bufferedReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}



