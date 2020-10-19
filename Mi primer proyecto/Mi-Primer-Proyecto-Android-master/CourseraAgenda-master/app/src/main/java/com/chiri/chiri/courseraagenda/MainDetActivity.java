package com.chiri.chiri.courseraagenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainDetActivity extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvEmail;
    private TextView tvNacimiento;
    private TextView tvTelefono;
    private TextView tvDescripcion;

    ArrayList<String> strList = new ArrayList<String>();

    //ArrayList<Contacto> contactos;

    protected ArrayList getFields(){

        ArrayList<TextView> displayList = new ArrayList<>();
        TextView txtName  = (TextView) findViewById(R.id.inN); //inN
        TextView txtEmail = (TextView) findViewById(R.id.inE);
        TextView txtBirth = (TextView) findViewById(R.id.inB);
        TextView txtPhone = (TextView) findViewById(R.id.inP);
        TextView txtDesct = (TextView) findViewById(R.id.inD);

        displayList.add(txtName);
        displayList.add(txtEmail);
        displayList.add(txtBirth);
        displayList.add(txtPhone);
        displayList.add(txtDesct);

        return displayList;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_det);

        ArrayList<EditText> receivedItemsList = new ArrayList<>();
        Bundle extras = getIntent().getExtras();

        if (extras != null) {

            final ArrayList<String> arr = extras.getStringArrayList("valuesStr");

           // Toast toastW = Toast.makeText(getApplicationContext(), someVariable, Toast.LENGTH_SHORT);
            //Toast toastW = Toast.makeText(getApplicationContext(), "Geting Values", Toast.LENGTH_SHORT);
            //toastW.show();

            ArrayList<TextView> displayList = new ArrayList<>();
                                displayList = this.getFields();

            for(int wX = 0; wX < arr.size(); wX++){
                    displayList.get(wX).setText(arr.get(wX));
            }

            final AppCompatButton buttonEdit = (AppCompatButton) findViewById(R.id.btnEdit);
            buttonEdit.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(MainDetActivity.this, MainActivity.class);
                    ArrayList<TextView> dspList = new ArrayList<TextView>();

                    dspList = getFields();

                    for(int wV = 0 ; wV < arr.size(); wV++){
                        strList.add((String) dspList.get(wV).getText());
                    }

                    intent.putExtra("strsReturn",strList);
                    startActivity(intent);
                    finish();
                }
            });

        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event){

        if(keyCode == KeyEvent.KEYCODE_BACK){

            Intent intent = new Intent(MainDetActivity.this, MainActivity.class);
            ArrayList<TextView> dspList = new ArrayList<TextView>();
                                dspList = getFields();

            for(int wV = 0 ; wV < dspList.size(); wV++){
                strList.add((String) dspList.get(wV).getText());
            }

            intent.putExtra("strsReturn",strList);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

}
