package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*public void onClickButton(View view){
        ToggleButton toggleButton = (ToggleButton)findViewById(R.id.toggle_button);
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkbox1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkbox2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkbox3);

        String result = "";

        boolean checkBox1Checked = checkBox1.isChecked();
        boolean checkBox2Checked = checkBox2.isChecked();
        boolean checkBox3Checked = checkBox3.isChecked();

        result += toggleButton.getText();

        if (checkBox1Checked)
            result += ", " + checkBox1.getText().toString();
        if (checkBox2Checked)
            result += ", " + checkBox2.getText().toString();
        if (checkBox3Checked)
            result += ", " + checkBox3.getText().toString();

        TextView textView = (TextView)findViewById(R.id.result);

        result = "Your final selection for your tea: " + result;
        textView.setText(result);

    }*/

    public void onClickEnviar(View view){

        EditText titulo = (EditText)findViewById(R.id.editText_titulo);
        String tituloString = titulo.getText().toString();

        EditText autor = (EditText)findViewById(R.id.editText_autor);
        String autorString = autor.getText().toString();

        EditText ano = (EditText)findViewById(R.id.editText_ano);
        String anoString = ano.getText().toString();

        Spinner spinner = (Spinner)findViewById(R.id.spinner_genero);
        String option_selected = String.valueOf(spinner.getSelectedItem());

        boolean checked;
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox_noticias);
        checked = checkBox.isChecked();



        Intent intentDatos = new Intent(this, AgregarLibro.class);
        intentDatos.putExtra("titulo",tituloString);
        intentDatos.putExtra("autor", autorString);
        intentDatos.putExtra("ano", anoString);
        intentDatos.putExtra("genero", option_selected);
        intentDatos.putExtra("noticias", checked);
        startActivity(intentDatos);
    }
}
