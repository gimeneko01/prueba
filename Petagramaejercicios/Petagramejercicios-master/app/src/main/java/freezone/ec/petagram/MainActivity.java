package freezone.ec.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import adapter.MascotaAdaptador;
import adapter.PageAdapter;
import fragment.PerfilFragment;
import fragment.RecyclerviewFragment;

public class MainActivity extends AppCompatActivity {



    //declarar los elementos añadidos para el fragment
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //para los fragments
        tabLayout = (TabLayout) findViewById(R.id. tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        //llamamos al metodo viewpager
        setUpViewPager();

        //llamamos al metodo toolbar
        metodoToolbar();
        //metodo para cambiar el icono izquierda por defecto de toolbar y  cambiar el color
        cambiarIcono(R.drawable.icons8_huella_de_perro_64,R.color.colorTextoIconos);


    }

    //metodo para los fragmenst
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerviewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    //metodo para el page Adapter
    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        //agregamos los iconos al tab
        tabLayout.getTabAt(0).setIcon(R.drawable.icons8_cucha_52);
        tabLayout.getTabAt(1).setIcon(R.drawable.icons8_perro_sentado_64);
    }




    //metodo toolbar
    private void metodoToolbar(){
        //es necesario declarar el actionbar para que funcione en todas las pantallas
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionbar);
        setSupportActionBar(miActionBar);
        //creamos el icono Huella
        iconoHuella();
    }
    //creamos el icono izquierda por la huella
    private void  iconoHuella(){
        //acción distinto de null para evitar problemas icono por defecto de flecha editamos por la estrella
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }
    //metodo para cambiar el icono izquierda por la huella y color
    private void cambiarIcono(int drawable,int color){
        if(getSupportActionBar()!=null){
            final Drawable icon = getResources().getDrawable(drawable);
            icon.setColorFilter(getResources().getColor(color),PorterDuff.Mode.SRC_ATOP);
            getSupportActionBar().setHomeAsUpIndicator(icon);
        }

    }
    //manejamos el menu del toolbar
    //sobreescribimos el metodo para poder manejar el menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

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

    //metodo para dar el evento de un icono de estrella y para todos los menus a partir del ID
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.icon_estrella:
                Intent i = new Intent(this,Main2Activity.class);
                startActivity(i);
                break;

            // menu de los 3 puntos
            case R.id.mContacto:
                Intent intent2 = new Intent(this,Contacto.class);
                startActivity(intent2);
                break;

            case R.id.mAcercaDe:
                Intent intent3 = new Intent(this,AcercaDe.class);
                startActivity(intent3);
        }

        return super.onOptionsItemSelected(item);

    }

}