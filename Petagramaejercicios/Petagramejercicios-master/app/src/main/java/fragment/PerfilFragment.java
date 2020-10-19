package fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import adapter.MascotaAdaptador;
import adapter.PerfilAdaptador;
import freezone.ec.petagram.Mascota;
import freezone.ec.petagram.R;


public class PerfilFragment extends Fragment {


    ArrayList<Mascota> mascotas;
    // declaramos nuestro Recycle View
    private RecyclerView listaMascotas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        //Recycler View
        listaMascotas = (RecyclerView)v.findViewById(R.id.rvPerfilMascotas);

        //Rv en forma de Grid

        GridLayoutManager glm =new GridLayoutManager(getActivity(),3);

        listaMascotas.setLayoutManager(glm);
        //llamamos al metodo
        inicializarListaMacotas();
        //inicializamos el adaptador
        inicializarAdaptador();


        return v;

    }

    //metodo para llenar la lista
    public void inicializarListaMacotas(){

      /*   mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.noe1,5));
        mascotas.add(new Mascota( R.drawable.noe2,3));
        mascotas.add(new Mascota(R.drawable.noe3,2));
        mascotas.add(new Mascota(R.drawable.noe4,4));
        mascotas.add(new Mascota( R.drawable.noe5,1));
        mascotas.add(new Mascota( R.drawable.noe6,3));*/

        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.noe1));
        mascotas.add(new Mascota( R.drawable.noe2));
        mascotas.add(new Mascota(R.drawable.noe3));
        mascotas.add(new Mascota(R.drawable.noe4));
        mascotas.add(new Mascota( R.drawable.noe5));
        mascotas.add(new Mascota( R.drawable.noe6));

    }

    public void inicializarAdaptador(){
        PerfilAdaptador adaptador = new PerfilAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }
}
