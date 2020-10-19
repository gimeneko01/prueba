package adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import db.ConstructorMascotas;
import freezone.ec.petagram.AcercaDe;
import freezone.ec.petagram.Main2Activity;
import freezone.ec.petagram.MainActivity;
import freezone.ec.petagram.Mascota;
import freezone.ec.petagram.R;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MacotaViewHolder>{

    ArrayList<Mascota> mascotas;
    //like
    Activity activity;


    //metodo para contruir las mascotas
    public MascotaAdaptador(ArrayList<Mascota> mascotas,Activity activity){
        this.mascotas = mascotas;
        //like
        this.activity = activity;
    }

    @NonNull

    //inflar el layout y lo pasara al view holder para que obtenga los views
    @Override
    public MacotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MacotaViewHolder(v);

    }

    //asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull final MacotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFotoCV.setImageResource(mascota.getFoto());
     //mascotaViewHolder.imgIcono1CV.setImageResource(mascota.getIcono1CV());
        //mascotaViewHolder.imgIcono2CV.setImageResource(mascota.getIcono2());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        //seteamos los likes en un numero entero
        mascotaViewHolder.tvNumeroCV.setText(String.valueOf(mascota.getNumero()));


        //likes
        mascotaViewHolder.imgIcono1CV.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Toast
               Toast.makeText(activity,"Diste Like a "+ mascota.getNombre(),Toast.LENGTH_SHORT).show();


                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);
                //refrescar el numerom
               mascotaViewHolder.tvNumeroCV.setText(String.valueOf(constructorMascotas.obtenerLikesMascota1(mascota)));



            }
        });
    }


    @Override
    public int getItemCount() { //cantidad de elementos que contiene mi lista
        return mascotas.size();
    }

    public static class MacotaViewHolder extends RecyclerView.ViewHolder{

        private TextView tvNombreCV;
        private ImageView imgFotoCV;
       private ImageButton imgIcono1CV;
       // private ImageView imgIcono2CV;

        private TextView tvNumeroCV;



        public MacotaViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNombreCV  = (TextView) itemView.findViewById(R.id.tvNombreCV);
            imgFotoCV   = (ImageView) itemView.findViewById(R.id.imgFotoCV);
            imgIcono1CV  = (ImageButton) itemView.findViewById(R.id.imgIcono1CV);
            //imgIcono2CV  = (ImageView) itemView.findViewById(R.id.imgIcono2CV);

            tvNumeroCV  = (TextView) itemView.findViewById(R.id.tvNumeroCV);

        }
    }
}
