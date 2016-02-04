package com.unir.leonardotalero.myapplicationlogin;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by leonardotalero on 12/13/15.
 */
public class DialogoAlerta extends DialogFragment {

    public static  String TITULO="";
    public static  String MENSAJE="";
    public DialogoAlerta(String titulo,String mensaje) {
        TITULO=titulo;
        MENSAJE=mensaje;


    }

    @Override
    public Dialog onCreateDialog(Bundle saveInstaceState){
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setMessage(MENSAJE)
        .setTitle(TITULO)
                .setPositiveButton("OK",new DialogInterface.OnClickListener(){
                  @Override
                public void onClick(DialogInterface dialog,int which){
                      dialog.cancel();

                      Log.i("Dialogos", "Usuario acepta titulo:"+TITULO+" mensaje:"+MENSAJE);
                  }

                });
return builder.create();
    };
}
