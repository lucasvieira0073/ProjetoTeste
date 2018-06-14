package br.com.vieira.lucas.projetoteste;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnFocusChangeListener {
    TextView edt;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt = (TextView) findViewById(R.id.edtTeste);
        btn = (Button) findViewById(R.id.botao);

        //edt.setText("10,00000");
        //edt.setOnFocusChangeListener(this);

        InputFilter[] filter = new InputFilter[1];
        //inicializa a primeira posicao com
        //o filter criado
       // filter[0] = new FiltroDecimais(10,5, edt);
        //adiciona ao seu EditText o filtro
        //que sera executado antes do evento TextWatcher
        //edt.setFilters(filter);

        //edt.setText(Double.toString(10.5));

        edt.setText("TEXTO MUITO LONGO MESMO");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    edt.setText("CONFIRMANDO O TEXTO MUITO LONGO MESMO");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("alerta");
        progressDialog.setMessage("carregando");
        progressDialog.setCancelable(false);

        progressDialog.show();

    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if(v.getId() == R.id.edtTeste && hasFocus) {
            edt.setText("");
        }else if(v.getId() == R.id.edtTeste && !hasFocus){
            //edt DecimaisUtil.format....
        }
    }

    void validaCampos(EditText editText) {
        if(editText.getText().toString().contains(",")) {

        }
    }
}
