package com.example.pruebas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("TAG DEBU", "Estado onCreate");

        //Se recupera el elemento texto del Layout a partir de su ID
        texto = findViewById(R.id.eventoPagina);

        // Se establece un Listener para el elemento texto
        texto.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if(id == R.id.eventoPagina) {
            // Primer parametro -> Contexto desde el que se está lanzando el activity (activity actual)
            // Segundo parametro -> Texto a mostrar
            // Tercer parametro -> Numero de segundo que va a permanecer el mensaje en pantalla
            Toast.makeText(this, "Has hecho click en el texto", Toast.LENGTH_SHORT).show();

            // Creación de Intent explicito para navegar a otro Activity
            Intent intent = new Intent(this, SecundarioActivity.class);
            // Pasamos datos al nuevo activity
            intent.putExtra("numero", 5);
            startActivity(intent);
        }
        else {
            Log.i("Error", "No hay más elementos onClick");
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("TAG DEBUG", "Estado onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TAG DEBUG", "Estado onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("TAG DEBUG", "Estado onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("TAG DEBUG", "Estado onStop()");
    }


    public void crearAlarma(View view) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "Ir al trabajo")
                .putExtra(AlarmClock.EXTRA_HOUR, 13)
                .putExtra(AlarmClock.EXTRA_MINUTES, 00);
        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void hacerLlamada(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:112"));
        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);

        }
    }
}
