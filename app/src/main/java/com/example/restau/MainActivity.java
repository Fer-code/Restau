package com.example.restau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.restau.MESSAGE";
    public final static String EXTRA_MESSAGE_VALOR = "com.example.restau.VALUE";
    public final static String EXTRA_MESSAGE_NOME = "com.example.restau.MENSAGEM";
    public final static String EXTRA_MESSAGE_PAGAMENTO = "com.example.restau.PAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ok(View v){

        EditText nome = findViewById(R.id.idNome);
        CheckBox idCoc = findViewById(R.id.idCoc);
        CheckBox idGua = findViewById(R.id.idGua);
        RadioButton cartao = findViewById(R.id.idCartao);
        RadioButton din = findViewById(R.id.idDinheiro);

        String pagamento = "";
       String gostos = "";
        double valor = 0;
        if(idCoc.isChecked()) {
            gostos = "Coca - Cola\n";
            valor += 10;
        }
        if (idGua.isChecked()){
            gostos += "Guaraná\n";
            valor += 5;
        }
        if(cartao.isChecked()){
            pagamento = "Cartão";
        }
        if(din.isChecked()){
            pagamento = "Dinheiro";
            valor = valor - (valor * 1/10);
        }


        String total = String.valueOf(valor);
        String nome1 = nome.getText().toString();
        Intent intent = new Intent(this, ResultadoActivity.class);
        intent.putExtra(EXTRA_MESSAGE_NOME, nome1);
        intent.putExtra(EXTRA_MESSAGE, gostos);
       intent.putExtra(EXTRA_MESSAGE_VALOR, total);
        intent.putExtra(EXTRA_MESSAGE_PAGAMENTO, pagamento);
        startActivity(intent);
    }





}