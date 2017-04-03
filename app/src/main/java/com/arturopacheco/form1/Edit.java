package com.arturopacheco.form1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Edit extends AppCompatActivity {

    private TextView name;
    private TextView email;
    private TextView phone;
    private TextView birthdate;

    private String personName;
    private String personEmail;
    private String personPhone;
    private String personBirthdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Bundle bundle = getIntent().getExtras();

        personName = bundle.getString("name");
        personEmail = bundle.getString("email");
        personPhone = bundle.getString("phone");
        personBirthdate = bundle.getString("birthdate");


        name = (TextView) findViewById(R.id.personName);
        phone = (TextView) findViewById(R.id.personPhone);
        email = (TextView) findViewById(R.id.personEmail);
        birthdate = (TextView) findViewById(R.id.personBirthdate);

        name.setText(personName);
        phone.setText(personPhone);
        email.setText(personEmail);
        birthdate.setText(personBirthdate);


    }


    public void EditData(View v){
        Intent intent = new Intent(this, MainActivity.class);


        intent.putExtra("name",personName);
        intent.putExtra("phone",personPhone);
        intent.putExtra("email",personEmail);
        intent.putExtra("birthdate",personBirthdate);

        startActivity(intent);

    }
}
