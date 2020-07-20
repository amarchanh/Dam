package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AgregarLibro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_libro);

        Bundle extras = getIntent().getExtras();

        String titulo = extras.getString("titulo");
        String autor = extras.getString("autor");
        String ano = extras.getString("ano");
        String genero = extras.getString("genero");
        boolean noticias = extras.getBoolean("noticias");

        String mensaje="";

        if (noticias){
            mensaje = "Le enviaremos noticias en el futuro.";
        }
        else{
            mensaje = "No le enviaremos noticias.";
        }

        mensaje = "Título: " + titulo + "\n\nAutor: " + autor + "\n\nAño: " + ano + "\n\nGénero: " + genero + "\n\n" + mensaje;

        TextView textView = (TextView)findViewById(R.id.textVactivity2);
        textView.setText(mensaje);

    }
}
