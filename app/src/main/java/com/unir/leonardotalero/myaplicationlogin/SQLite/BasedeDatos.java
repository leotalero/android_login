package com.unir.leonardotalero.myaplicationlogin.SQLite;



/**
 * Created by leonardotalero on 12/13/15.
 */

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.util.Log;

import com.unir.leonardotalero.myaplicationlogin.SQLite.Usuario;

public class  BasedeDatos extends SQLiteOpenHelper {


    public static final String  DATABASE_NAME="basededatos.db";
    private static final  int DATABASE_VERSION =1;
    private static final String QUERY_CREATE=" CREATE TABLE "+Usuario.UsuarioEntrada.TABLE_NAME+
            " ( "+ Usuario.UsuarioEntrada.COLUMN_NAME_id
            +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            Usuario.UsuarioEntrada.COLUMN_NAME_Usuario+" TEXT , "+
            Usuario.UsuarioEntrada.COLUMN_NAME_Password+" TEXT , "+
            Usuario.UsuarioEntrada.COLUMN_NAME_fechacrea+" TEXT , "+
            Usuario.UsuarioEntrada.COLUMN_NAME_estado+" TEXT "
            +" ) "
            ;
    private static final String QUERY_DROP=" DROP TABLE IF EXISTS "+Usuario.UsuarioEntrada.TABLE_NAME;


    public BasedeDatos(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("Database operaciones", "Database creada");
    }
    public void onCreate(SQLiteDatabase sdb) {
        sdb.execSQL(QUERY_CREATE);
        Log.d("Database operaciones","tabla creada");
    }
    public void onUpgrade(SQLiteDatabase sdb, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        sdb.execSQL(QUERY_DROP);
        onCreate(sdb);
        Log.d("Database operaciones", "tabla eliminada");
    }
    public void onDowngrade(SQLiteDatabase sdb, int oldVersion, int newVersion) {
        onUpgrade(sdb, oldVersion, newVersion);
    }


    public Boolean InsertarInformacion(String usuario,String password,String fechacrea,String estado){

        SQLiteDatabase db=getWritableDatabase();
            if(db!=null){
                ContentValues valores=new ContentValues();

                valores.put(Usuario.UsuarioEntrada.COLUMN_NAME_Usuario,usuario);
                valores.put(Usuario.UsuarioEntrada.COLUMN_NAME_Password,password);
                valores.put(Usuario.UsuarioEntrada.COLUMN_NAME_fechacrea,fechacrea);
                valores.put(Usuario.UsuarioEntrada.COLUMN_NAME_estado, estado);
                db.insert(Usuario.UsuarioEntrada.TABLE_NAME, null, valores);
                db.close();
                Log.d("Database operaciones", "registro insertado");


            }
        return true;
    }


    public Usuario LeerInformacion(int id){

        SQLiteDatabase db=getReadableDatabase();

        String[] valores={Usuario.UsuarioEntrada.COLUMN_NAME_id,Usuario.UsuarioEntrada.COLUMN_NAME_Usuario
        ,Usuario.UsuarioEntrada.COLUMN_NAME_Password,Usuario.UsuarioEntrada.COLUMN_NAME_fechacrea,Usuario.UsuarioEntrada.COLUMN_NAME_estado};


       Cursor cursor=db.query(Usuario.UsuarioEntrada.TABLE_NAME,valores,Usuario.UsuarioEntrada.COLUMN_NAME_id+"="+id,null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();

        }
        //cursor.getInt(2),cursor.getInt(3),cursor.getInt(4)
        Usuario usuario=new Usuario(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));

        db.close();
        cursor.close();
        return usuario;

    }


    public Usuario LeerInformacionbyUsuario(String usuario){

        SQLiteDatabase db=getReadableDatabase();

        String[] valores={Usuario.UsuarioEntrada.COLUMN_NAME_id,Usuario.UsuarioEntrada.COLUMN_NAME_Usuario
                ,Usuario.UsuarioEntrada.COLUMN_NAME_Password,Usuario.UsuarioEntrada.COLUMN_NAME_fechacrea,Usuario.UsuarioEntrada.COLUMN_NAME_estado};


        Cursor cursor=db.query(Usuario.UsuarioEntrada.TABLE_NAME,valores,Usuario.UsuarioEntrada.COLUMN_NAME_Usuario+"='"+usuario+"'",null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();

        }
        //cursor.getInt(2),cursor.getInt(3),cursor.getInt(4)
        Usuario usuarioEncontrado=null;
        if(cursor.getCount()>0){
             usuarioEncontrado=new Usuario(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));

        }

        db.close();
        cursor.close();
        return usuarioEncontrado;

    }

}
