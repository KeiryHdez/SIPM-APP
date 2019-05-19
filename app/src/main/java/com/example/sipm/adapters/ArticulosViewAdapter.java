package com.example.sipm.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sipm.R;
import com.example.sipm.entities.Articulos;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

class ArticulosViewHolder extends RecyclerView.ViewHolder{

    public TextView anom;
    public TextView apre;
    public TextView amar;
    public TextView ades;
    public ImageView afot;

    public ArticulosViewHolder(View itemItem, final ArticulosViewAdapter.OnItemClickListener listener){
        super(itemItem);

        afot = (ImageView) itemItem.findViewById(R.id.Bfo);
        anom = (TextView) itemItem.findViewById(R.id.Bno);
        apre = (TextView) itemItem.findViewById(R.id.Bpr);
        amar = (TextView) itemItem.findViewById(R.id.Bma);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        listener.onItemClick(position);
                    }
                }
            }
        });

    }
}

public class ArticulosViewAdapter extends RecyclerView.Adapter<ArticulosViewHolder> {
    private ArrayList<Articulos> articulos;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public ArticulosViewAdapter(ArrayList<Articulos> articulos) {
        this.articulos = articulos;
    }

    @NonNull
    @Override
    public ArticulosViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = layoutInflater.inflate(R.layout.des, viewGroup, false);
        return new ArticulosViewHolder(itemView, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticulosViewHolder ArticulosViewHolder, int i) {
        //customerViewHolder.iv.setImageResource( naturalPersons.get(i).getId());
        ArticulosViewHolder.anom.setText(articulos.get(i).getNombre());
        ArticulosViewHolder.apre.setText( "$" +articulos.get(i).getPrecio());
        ArticulosViewHolder.amar.setText(articulos.get(i).getMarca());

        if(articulos.get(i).getImg() != null && !articulos.get(i).getImg().isEmpty()){
            Picasso.get().load(articulos.get(i).getImg())

                    .fit()
                    // To prevent fade animation
                    .noFade()
                    .into(ArticulosViewHolder.afot);
        }else{
            //customerViewHolder.iv.setImageDrawable(ContextCompat.getDrawable(F.context,R.drawable.default_placeholder));
        }




        //customerViewHolder.iv.set
    }

    @Override
    public int getItemCount() {
        return this.articulos.size();
    }

}
