package com.example.juancarlos.starbuzz;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class DrinkActivity extends Activity {

    public static final String EXTRA_DRINKID = "drinkId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);


        //Obtener la bebida seleccionada del intentt

        int drinkId = (Integer)getIntent().getExtras().get(EXTRA_DRINKID);

        Drink drink = Drink.drinks[drinkId];

        TextView name = (TextView) findViewById(R.id.name_detail);
        name.setText(drink.getName());

        TextView description = (TextView) findViewById(R.id.description_detail);
        description.setText(drink.getDescription());

        ImageView photo = (ImageView)findViewById(R.id.photo_detail);
        photo.setImageResource(drink.getImageResourceId());

    }
}
