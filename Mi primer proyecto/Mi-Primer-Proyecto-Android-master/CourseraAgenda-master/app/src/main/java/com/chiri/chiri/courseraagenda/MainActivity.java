package com.chiri.chiri.courseraagenda;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends ActionBarActivity {

    public static TextView SelectedDateView;
    private Contacto formInfo;

    private TextView fieldName;
    private TextView fieldEmail;

    private TextView fieldNacimiento;
    private TextView fieldTelefono;
    private TextView fieldDescripcion;

    private String strName;
    private String strEmail;
    private String strNacimiento;
    private String strTelefono;
    private String strDescripcion;

    public String getFieldName() {
        fieldName = (TextView) findViewById(R.id.inN);
        strName = fieldName.getText().toString();

        return strName;
    }

    public String getFieldEmail() {
        fieldEmail = (TextView) findViewById(R.id.inE);
        strEmail = fieldEmail.getText().toString();

        return strEmail;
    }

    public String getFieldNacimiento() {
        fieldNacimiento = (TextView) findViewById(R.id.showBornDate);
        strNacimiento = fieldNacimiento.getText().toString();

        return strNacimiento;
    }

    public String getFieldTelefono() {
        fieldTelefono = (TextView) findViewById(R.id.inP);
        strTelefono = fieldTelefono.getText().toString();

        return strTelefono;
    }

    public String getFieldDescripcion() {
        fieldDescripcion = (TextView) findViewById(R.id.inD);
        strDescripcion = fieldDescripcion.getText().toString();

        return strDescripcion;
    }

    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

        // Context context = getApplicationContext();
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {

            Context context = super.getActivity().getApplicationContext();
            CharSequence text = day + "-" + month + "-" + year;
            int duration = Toast.LENGTH_SHORT;

            // Toast toast = Toast.makeText(context, text, duration);
            // toast.show();

            setDate(text);
        }

        public void setDate(CharSequence charDate) {
            TextView dateVT = (TextView) super.getActivity().findViewById(R.id.showBornDate);
            dateVT.setText(charDate);
        }
    }

    protected ArrayList getFieldsValues() {
        final ArrayList<String> arr = new ArrayList<String>();

        EditText txtName = (EditText) findViewById(R.id.inN); //inN
        EditText txtBorn = (EditText) findViewById(R.id.showBornDate);
        EditText txtPhone = (EditText) findViewById(R.id.inP);
        EditText txtEmail = (EditText) findViewById(R.id.inE);
        EditText txtDescr = (EditText) findViewById(R.id.inD);

        String txtCleanName = txtName.getText().toString();
        String txtCleanBorn = txtBorn.getText().toString();
        String txtCleanPhone = txtPhone.getText().toString();
        String txtCleanEmail = txtEmail.getText().toString();
        String txtCleanDescr = txtDescr.getText().toString();

        arr.add(txtCleanName);
        arr.add(txtCleanBorn);
        arr.add(txtCleanPhone);
        arr.add(txtCleanEmail);
        arr.add(txtCleanDescr);

        return arr;
    }

    protected ArrayList setFieldsValues(ArrayList strValues) {
        final ArrayList<EditText> arr = new ArrayList<>();

        EditText txtName = (EditText) findViewById(R.id.inN); //inN
        EditText txtBorn = (EditText) findViewById(R.id.showBornDate);
        EditText txtPhone = (EditText) findViewById(R.id.inP);
        EditText txtEmail = (EditText) findViewById(R.id.inE);
        EditText txtDescr = (EditText) findViewById(R.id.inD);

        arr.add(txtName);
        arr.add(txtBorn);
        arr.add(txtPhone);
        arr.add(txtEmail);
        arr.add(txtDescr);

        for (int wZ = 0; wZ < arr.size(); wZ++) {
            arr.get(wZ).setText((String) strValues.get(wZ));
        }
        return arr;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SelectedDateView = (TextView) findViewById(R.id.selected_date);

        final AppCompatButton button = (AppCompatButton) findViewById(R.id.btnReg);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MainDetActivity.class);
                final ArrayList<String> arrayFields = getFieldsValues();
                intent.putExtra("valuesStr", arrayFields);
                startActivity(intent);
                finish();
                // Toast toast = Toast.makeText(getApplicationContext(), "Inted Click", Toast.LENGTH_SHORT);
                // toast.show();
            }
        });
        /**
         * End Event Listener to Button
         */

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            final ArrayList<String> arrayStringList = extras.getStringArrayList("strsReturn");
            setFieldsValues(arrayStringList);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/
        return super.onOptionsItemSelected(item);
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(), "datePicker");
    }
}
