package com.example.juancarlos.informaticavirrey;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubjectDamListFragment extends ListFragment {


    public SubjectDamListFragment() {
        // Required empty public constructor
    }

    static interface Listener{
        void itemClicked(long id);
    }

    private Listener listener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String modulos[]=new String[SubjectDam.subjectsdam.length];
        for(int i=0;i<modulos.length;i++){
            modulos[i]=SubjectDam.subjectsdam[i].getNombre_dam();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                inflater.getContext(), android.R.layout.simple_list_item_1,
                modulos);

        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        this.listener=(Listener)context;
    }

    public void onListItemClick(ListView listView, View itemView, int position, long id){
        if(listener!=null){
            listener.itemClicked(id);
        }
    }

}
