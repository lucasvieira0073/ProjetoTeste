package br.com.vieira.lucas.projetoteste;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;

public class MediaSound {
    //criar diretorio em res raw colocar o audio para la


    public static void executar(Context context) {
        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.bip);
        mediaPlayer.start();


    }
}
