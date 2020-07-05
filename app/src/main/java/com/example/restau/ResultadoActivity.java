package com.example.restau;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Bundle extras = getIntent().getExtras();
        String msg = null;
        TextView result = findViewById(R.id.idResult);
        TextView pedidos = findViewById(R.id.idPedido);
        TextView name = findViewById(R.id.txtNome);
        TextView fp = findViewById(R.id.idPage);

        if (extras != null) {
            msg = extras.getString(MainActivity.EXTRA_MESSAGE);
            String total = extras.getString(MainActivity.EXTRA_MESSAGE_VALOR);
            String nome = extras.getString(MainActivity.EXTRA_MESSAGE_NOME);
            String page = extras.getString(MainActivity.EXTRA_MESSAGE_PAGAMENTO);

            String txtNome = String.format("Bem vindo(a) sr(a) %s \n", nome);
            String txt = String.format("Pedido: \n %s ",msg);
            String txt1 = String.format("Total:  %s",total);


            name.setText(txtNome);
            pedidos.setText(txt );
            result.setText(txt1);
            fp.setText("Forma de pagamento: " + page);
        }

    }
}