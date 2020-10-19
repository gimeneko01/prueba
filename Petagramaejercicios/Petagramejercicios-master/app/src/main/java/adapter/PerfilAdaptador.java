package adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import freezone.ec.petagram.Mascota;
import freezone.ec.petagram.R;;

public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilAdaptadorViewHolder> {
    ArrayList<Mascota> mascotas;


    //metodo para contruir las mascotas
    public PerfilAdaptador (ArrayList<Mascota> mascotas){
        this.mascotas = mascotas;
    }

    @NonNull
    @Override
    public PerfilAdaptadorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil_mascota,parent,false);
        return new PerfilAdaptadorViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull PerfilAdaptadorViewHolder PerfilAdaptadorViewHolder, int position) {
        Mascota mascota = mascotas.get(position);
        PerfilAdaptadorViewHolder.imgFotoCVP.setImageResource(mascota.getFoto());
        //PerfilAdaptadorViewHolder.imgIcono2CVP.setImageResource(mascota.getIcono2());
        PerfilAdaptadorViewHolder.tvNumeroCVP.setText(String.valueOf(mascota.getNumero()));
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }


    public static  class PerfilAdaptadorViewHolder extends RecyclerView.ViewHolder{

       private ImageView imgFotoCVP;
       private ImageView imgIcono2CVP;
       private TextView tvNumeroCVP;

       public PerfilAdaptadorViewHolder(@NonNull View itemView) {
           super(itemView);
           imgFotoCVP   = (ImageView) itemView.findViewById(R.id.imgFotoCVP);
           imgIcono2CVP  = (ImageView) itemView.findViewById(R.id.imgIcono2CVP);
           tvNumeroCVP  = (TextView) itemView.findViewById(R.id.tvNumeroCVP);
       }
   }


}