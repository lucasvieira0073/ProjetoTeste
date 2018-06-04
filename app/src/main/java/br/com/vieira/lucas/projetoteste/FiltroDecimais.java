package br.com.vieira.lucas.projetoteste;

import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FiltroDecimais implements InputFilter {

    private Pattern pattern;
    private int inteiros;
    private int decimais;
    private int totalDigitos;
    private EditText editText;

    public FiltroDecimais(int inteiros, int decimais, EditText editText) {
        this.inteiros = inteiros;
        this.decimais = decimais - 1;
        this.totalDigitos = inteiros + decimais;
        this.editText = editText;
        //this.pattern=Pattern.compile("[0-9]{0,15}[,]{0,1}[0-9]{0,4}");
        this.pattern=Pattern.compile("[0-9]{0," + inteiros +"}[,]{0,1}[0-9]{0," + this.decimais + "}");
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {

        if(source.equals(",") && dest.toString().equals("")) {
            return "";
        }

        if(source.equals(",") && dest.toString().contains(",")) {
            return "";
        }

        if(!source.equals("") && !Character.isDigit(source.charAt(0)) && !source.equals(",")) {
            return "";
        }

        if(dstart >= inteiros && !dest.toString().contains(",") && !source.equals(",")) {
            return "";
        }

        Matcher matcher=pattern.matcher(dest);
        if(!matcher.matches()) {

            return "";
        }

        return null;

    }

}
