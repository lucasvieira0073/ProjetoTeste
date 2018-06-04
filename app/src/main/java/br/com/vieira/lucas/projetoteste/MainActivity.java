package br.com.vieira.lucas.projetoteste;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnFocusChangeListener {
    EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt = (EditText) findViewById(R.id.edtTeste);

        edt.setText("10,00000");
        edt.setOnFocusChangeListener(this);

        InputFilter[] filter = new InputFilter[1];
        //inicializa a primeira posicao com
        //o filter criado
        filter[0] = new FiltroDecimais(10,5, edt);
        //adiciona ao seu EditText o filtro
        //que sera executado antes do evento TextWatcher
        edt.setFilters(filter);

        //edt.setText(Double.toString(10.5));




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