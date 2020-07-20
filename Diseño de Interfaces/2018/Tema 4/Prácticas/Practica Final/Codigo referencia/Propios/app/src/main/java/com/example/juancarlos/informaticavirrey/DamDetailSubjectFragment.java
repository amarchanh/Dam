package com.example.juancarlos.informaticavirrey;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DamDetailSubjectFragment extends Fragment {

    private long subjectDamId;


    public DamDetailSubjectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dam_detail_subject, container, false);
    }

    public void onStart(){
        super.onStart();
        View view = getView();
        if(view!=null){
            SubjectDam subjectDam = SubjectDam.subjectsdam[(int)subjectDamId];
            TextView cursoDam = (TextView)view.findViewById(R.id.courseDam);
            TextView nombreDam = (TextView)view.findViewById(R.id.subjectDamTitle);
            TextView horarioDam = (TextView)view.findViewById(R.id.scheduleDam);
            TextView profesorDam = (TextView)view.findViewById(R.id.teacherDam);
            TextView descripionDam= (TextView)view.findViewById(R.id.descriptionDam);

            cursoDam.setText(subjectDam.getCurso());
            nombreDam.setText(subjectDam.getNombre_dam());
            horarioDam.setText(subjectDam.getHorario_dam());
            profesorDam.setText(subjectDam.getProfesor_dam());
            descripionDam.setText(subjectDam.getDescripcion_dam());


        }

    }

    public void setSubjectDamId(long id){
        this.subjectDamId=id;
    }

}
