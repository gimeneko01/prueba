package fragment;

import java.util.ArrayList;

import adapter.MascotaAdaptador;
import freezone.ec.petagram.Mascota;

public interface IRecylclerViewFragmentView {

        public void  generarLinearLayoutVertical();

        public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

        public void inicializarAdaptadorRV(MascotaAdaptador adaptador);

    }


