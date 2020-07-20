package com.example.juancarlos.collage;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClicked (View view){

        TextView textView = (TextView)findViewById(R.id.text_view);
        EditText editText = (EditText)findViewById(R.id.edit_text);
        String message = editText.getText().toString();
        textView.setText(message);

    }
    public void onToggledButtonClicked(View view){

        TextView textView = (TextView)findViewById(R.id.text_view2);
        boolean on = ((ToggleButton)view).isChecked();

        if (on){

            textView.setText("El boton esta ON");

        }
        else{
            textView.setText("El boton esta OFF");
        }
    }

    public void onSwitchClicked(View view){
        TextView textView = (TextView)findViewById(R.id.text_view3);
        boolean on = ((Switch)view).isChecked();

        if (on){

            textView.setText("El switch esta ON");
        }
        else{
            textView.setText("El switch esta OFF");
        }
    }
}
