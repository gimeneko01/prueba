
package freezone.ec.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

import java.util.ArrayList;

import adapter.MascotaAdaptador;


public class Main2Activity extends AppCompatActivity {

  ArrayList<Mascota> mascotas;
  // declaramos nuestro Recycle View
  private RecyclerView listaMascotas;




  @Override
  protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main2);


      //llamamos al metodo toolbar
      metodoToolbar();


              listaMascotas = (RecyclerView)findViewById(R.id.rvMascotas);

      LinearLayoutManager llm  = new LinearLayoutManager(this);
      llm.setOrientation(LinearLayoutManager.VERTICAL);

      listaMascotas.setLayoutManager(llm);
      //llamamos al metodo
      inicializarListaMacotas();
      //inicializamos el adaptador
      inicializarAdaptador();


      //habilitar el icono izquierdo de regreso en el activity
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);

  }

  public void inicializarAdaptador(){
      MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
      listaMascotas.setAdapter(adaptador);
  }

  //metodo para llenar la lista


  public void inicializarListaMacotas(){
      //datos dummy
      mascotas = new ArrayList<Mascota>();
      mascotas.add(new Mascota("Chiripa", R.drawable.dalmata,5));
      mascotas.add(new Mascota("Negro", R.drawable.criollo,6));
      mascotas.add(new Mascota("Pedro", R.drawable.golden,8));
      mascotas.add(new Mascota("Veky", R.drawable.may,7));
      mascotas.add(new Mascota("Bolillo", R.drawable.salchicha,6));

  }


  //metodo toolbar
  private void metodoToolbar(){
      //es necesario declarar el actionbar para que funcione en todas las pantallas
      Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionbar);
      setSupportActionBar(miActionBar);
      //creamos el icono Huella

  }


  //manejamos el menu del toolbar
  //sobreescribimos el metodo

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
      MenuInflater inflater = getMenuInflater();
      inflater.inflate(R.menu.menu2, menu);

      //cambiar el color del icono izquierda a blanco
      menuIconColor(menu, R.color.colorTextoIconos);

      return super.onCreateOptionsMenu(menu);
  }

  //metodo para cambiar de color al icono que proviene del menu
  public void  menuIconColor(Menu menu,int color){
      for(int i=0; i<menu.size(); i++){
          Drawable drawable = menu.getItem(i).getIcon();
          if(drawable != null){
              drawable.mutate();
              drawable.setColorFilter(getResources().getColor(color), PorterDuff.Mode.SRC_ATOP);
          }
      }
  }


}
