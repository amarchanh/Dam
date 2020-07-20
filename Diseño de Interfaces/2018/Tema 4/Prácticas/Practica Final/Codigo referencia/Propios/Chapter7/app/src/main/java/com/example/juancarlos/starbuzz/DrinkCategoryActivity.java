package com.example.juancarlos.starbuzz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DrinkCategoryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_category);

        //Lineas de creación del adapter para leer el array de elementos
        //1º paso: creacón del adaptador
        ArrayAdapter<Drink> listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Drink.drinks);

        //2º Paso Asginación del adaptador al view que va a mostrar los datos

        ListView listDrinks = (ListView) findViewById(R.id.list_drinks);
        listDrinks.setAdapter(listAdapter);


        //Creación del elemento listener

        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> listDrinks, View itemView, int position, long id) {

                        Intent intent = new Intent(DrinkCategoryActivity.this, DrinkActivity.class);

                        intent.putExtra(DrinkActivity.EXTRA_DRINKID, (int) id);
                        startActivity(intent);

                    }
                };
        //Asignación del elemento listener a la vista
        listDrinks.setOnItemClickListener(itemClickListener);



    }
}
