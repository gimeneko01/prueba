package fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import adapter.MascotaAdaptador;
import freezone.ec.petagram.Mascota;
import freezone.ec.petagram.R;
import presentador.IRecyclerViewFragmentPresenter;
import presentador.RecyclerViewFragmentPresenter;

//implementar la interfaz
public class RecyclerviewFragment extends Fragment implements IRecylclerViewFragmentView {

    ArrayList<Mascota> mascotas;
    // declaramos nuestro Recycle View
    private RecyclerView listaMascotas;



    //declaro al modelopresentador
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container,false);

        //Recycler View
        listaMascotas = (RecyclerView)v.findViewById(R.id.rvMascotas);

        //llamando al modelopresentador
        presenter = new RecyclerViewFragmentPresenter(this,getContext());

        return v;

    }
    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm  = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {

        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}
