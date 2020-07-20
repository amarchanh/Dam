package com.example.juancarlos.informaticavirrey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DamActivity extends AppCompatActivity
                            implements SubjectDamListFragment.Listener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dam);

    }

    @Override
    public void itemClicked(long id){

        Intent intent = new Intent(this, DamDetailActivity.class);
        intent.putExtra(DamDetailActivity.EXTRA_SUBJECT_DAM_ID, (int)id);
        startActivity(intent);

    }
}
