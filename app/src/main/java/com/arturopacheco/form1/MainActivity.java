package com.arturopacheco.form1;


import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText name;
    private TextInputEditText email;
    private TextInputEditText phone;
    private TextInputEditText birthdate;

    private String personName;
    private String personEmail;
    private String personPhone;
    private String personBirthdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null) {
            personName = bundle.getString("name");
            personEmail = bundle.getString("email");
            personPhone = bundle.getString("phone");
            personBirthdate = bundle.getString("birthdate");
            name = (TextInputEditText) findViewById(R.id.name);
            phone = (TextInputEditText) findViewById(R.id.phone);
            email = (TextInputEditText) findViewById(R.id.email);
            birthdate = (TextInputEditText) findViewById(R.id.birthdate);

            name.setText(personName);
            phone.setText(personPhone);
            email.setText(personEmail);
            birthdate.setText(personBirthdate);

        }
    }


    public void showDatePickerDialog(View v) {
        android.support.v4.app.DialogFragment  newFragment = new DatePickerForm();

        //Creación de bundle y parametros

        Bundle bundle = new Bundle();
        bundle.putInt("viewId",R.id.birthdate);

        if(personBirthdate != null) {
            String[] dateEdit = personBirthdate.split("-");

            bundle.putInt("day", Integer.parseInt(dateEdit[0]));
            bundle.putInt("month",Integer.parseInt(dateEdit[1])-1);
            bundle.putInt("year",Integer.parseInt(dateEdit[2]));


        }

        newFragment.setArguments(bundle);

        newFragment.show(getSupportFragmentManager(), "datePicker");

    }

    public void SendData(View v)
    {
        name = (TextInputEditText) findViewById(R.id.name);
        phone = (TextInputEditText) findViewById(R.id.phone);
        email = (TextInputEditText) findViewById(R.id.email);
        birthdate = (TextInputEditText) findViewById(R.id.birthdate);

        Intent intent = new Intent(this, Edit.class);

        intent.putExtra("name",name.getText().toString());
        intent.putExtra("phone",phone.getText().toString());
        intent.putExtra("email",email.getText().toString());
        intent.putExtra("birthdate",birthdate.getText().toString());

        startActivity(intent);

    }
}
