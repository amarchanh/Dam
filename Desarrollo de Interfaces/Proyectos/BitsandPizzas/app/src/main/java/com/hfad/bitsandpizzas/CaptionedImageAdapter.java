package com.hfad.bitsandpizzas;

import android.graphics.drawable.Drawable;
import android.net.sip.SipSession;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class CaptionedImageAdapter extends RecyclerView.Adapter<CaptionedImageAdapter.ViewHolder> {

    // Tenemos que implementar los métodos heredados

    // Tipos de datos

    // Nombres de cada una de las fotos
    private String[] captions;

    private int[] imageIds;

    private Listener listener;

    interface Listener {
        void onClick(int position);
    }

    public CaptionedImageAdapter(String[] captions, int[] imageIds) {
        this.captions = captions;
        this.imageIds = imageIds;
    }

    public void onBindViewHolder(ViewHolder holder, final int position) {
        // Puede tratar la carta de manera arreglada
        CardView cardView = holder.cardView;
        //
        ImageView imageView = (ImageView) cardView.findViewById(R.id.info_image);
        Drawable drawable = ContextCompat.getDrawable((cardView.getContext(), imageIds[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(captions[position]);

        // Asignamos el texto
        TextView textView = (TextView) cardView.findById(R.id.info_text);
        textView.setText(captions[position]);

        cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                if(listener != null) {
                    listener.onClick(position);
                }
            }
        })



    }

    // Sobreescribimos el metodo getItemCount que nos devuelve el numero de elementos que mostrar (numero de cartas)


    @Override
    public int getItemCount() {
        return captions.length;
    }

    purblic void setListener(Listener listener) {
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Tenemos que definir la clase completa
        // Adaptador necesita tres cosas:
        //      Tipos de datos con los que va a trabajar,
        //      Tipo de vista donde el adaptador va a mostrar los datos con los que conecte
        //      Hacer la conexion

        private CardView cardView;

        public ViewHolder (CardView v) {
            super(v);
            cardView = v;
        }
    }

    public CaptionedImageAdapter.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_captioned_image, parent, false);

        return new ViewHolder(cv);
    }



}
