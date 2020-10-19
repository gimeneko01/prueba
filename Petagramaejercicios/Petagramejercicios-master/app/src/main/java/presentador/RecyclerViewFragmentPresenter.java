package presentador;

import android.content.Context;

import java.util.ArrayList;

import adapter.MascotaAdaptador;
import db.ConstructorMascotas;
import fragment.IRecylclerViewFragmentView;
import freezone.ec.petagram.Mascota;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {


    private IRecylclerViewFragmentView iRecylclerViewFragmentView;
    private Context context;

    //base de datos
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecylclerViewFragmentView iRecylclerViewFragmentView, Context context) {
        this.iRecylclerViewFragmentView = iRecylclerViewFragmentView;
        this.context = context;


        obtenerMascotasBaseDatos();

    }
    // para la clase modelo base de datos
    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();

        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iRecylclerViewFragmentView.inicializarAdaptadorRV(iRecylclerViewFragmentView.crearAdaptador(mascotas));
        iRecylclerViewFragmentView.generarLinearLayoutVertical();
    }
}
