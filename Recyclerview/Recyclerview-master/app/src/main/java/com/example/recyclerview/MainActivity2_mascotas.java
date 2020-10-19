package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.recyclerview.adaptador.Adaptadorperros;
import com.example.recyclerview.classVO.perrosVO;

import java.util.ArrayList;

public class MainActivity2_mascotas extends AppCompatActivity {

    private RecyclerView rv_favoritos;

    private ArrayList<perrosVO> listafavoritos = new ArrayList<>();



    private perrosVO registrar;


    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_mascotas);

        Toolbar mitoolbar = findViewById(R.id.miactionbar2);
        setSupportActionBar(mitoolbar);

        assert getSupportActionBar() != null;

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rv_favoritos = (RecyclerView) findViewById(R.id.rv_favoritos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv_favoritos.setLayoutManager(llm);

        llenarlista();


        Adaptadorperros adaptador = new Adaptadorperros(listafavoritos, this);
        rv_favoritos.setAdapter(adaptador);



    }

    public void llenarlista (){
        //   listafavoritos.add(new perrosVO(R.drawable.perro_1, "Catty", 3));
        listafavoritos.add(new perrosVO(R.drawable.perro_2, "Ronny", 2));
        listafavoritos.add(new perrosVO(R.drawable.perro_3, "Pelusa", 5));
     //   listafavoritos.add(new perrosVO(R.drawable.perro_4, "GuauGuau", 7));
        listafavoritos.add(new perrosVO(R.drawable.perro_5, "Coqui", 4));

    }
}