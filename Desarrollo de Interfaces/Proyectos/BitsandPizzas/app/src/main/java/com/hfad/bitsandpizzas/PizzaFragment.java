package com.hfad.bitsandpizzas;


import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.support.v7.widget.GridLayoutManager;


/**
 * A simple {@link Fragment} subclass.
 */
public class PizzaFragment extends Fragment {


    public PizzaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // container = elemento
        RecyclerView pizzaRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_pizza, container, false);

        String[] pizzaName =  new String(Pizza.pizzas.length);
        for(int i = 0; i<pizzaName.length; i++) {

            pizzaName[i] = Pizza.pizzas[i].getName();
        }

        int[] pizzaImages = new int(Pizza.pizzas.length);

        for (int i = 0; i < pizzaImages.length; i++) {
            pizzaImages[i] = Pizza.pizzas[i].getImageResourceId();
        }


        CaptionedImageAdapter adapter = new CaptionedImageAdapter(pizzaName, pizzaImages);
        pizzaRecycler.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        pizzaRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImageAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent  = new Intent(getActivity(), PizzaDetailActivity.class);
                intent.putExtra(PizzaDetailActivity.EXTRA_PIZZA_ID, position);
                getActivity().startActivity(intent);

            }
        });

        return pizzaRecycler;

    }

}
