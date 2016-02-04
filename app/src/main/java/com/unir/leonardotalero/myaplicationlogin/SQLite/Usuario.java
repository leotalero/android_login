package com.unir.leonardotalero.myaplicationlogin.SQLite;

import android.provider.BaseColumns;

/**
 * Created by leonardotalero on 12/13/15.
 */
public class Usuario {

    private int id;
    private String usuario;
    private String Password;
    private String fechacrea;
    private String estado;




        public Usuario() {}

        /* Inner class that defines the table contents */
        public static abstract class UsuarioEntrada implements BaseColumns {
            public static final String TABLE_NAME = "Usuario";
            public static final String COLUMN_NAME_id = "id";
            public static final String COLUMN_NAME_Usuario ="nombre_usuario";
            public static final String COLUMN_NAME_Password = "password";
            public static final String COLUMN_NAME_fechacrea= "fechacrea";
            public static final String COLUMN_NAME_estado= "estado";

        }





    public Usuario(int id, String usuario, String password, String fechacrea, String estado) {
        this.id = id;
        this.usuario = usuario;
        Password = password;
        this.fechacrea = fechacrea;
        this.estado = estado;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getFechacrea() {
        return fechacrea;
    }

    public void setFechacrea(String fechacrea) {
        this.fechacrea = fechacrea;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
