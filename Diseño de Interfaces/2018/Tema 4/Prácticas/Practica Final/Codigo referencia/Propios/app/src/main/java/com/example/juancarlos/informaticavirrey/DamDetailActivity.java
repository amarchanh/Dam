package com.example.juancarlos.informaticavirrey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DamDetailActivity extends AppCompatActivity {

    public static final String EXTRA_SUBJECT_DAM_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dam_detail);

        DamDetailSubjectFragment frag = (DamDetailSubjectFragment)
                getSupportFragmentManager().findFragmentById(R.id.detail_subject_dam_frag);
                int subjectDamId = (int)getIntent().getExtras().get(EXTRA_SUBJECT_DAM_ID);
                frag.setSubjectDamId(subjectDamId);
    }
}
