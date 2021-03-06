package com.example.dell.fifthclassassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity  {

    int p1,p2;
    String text="";
    String text2="";
Button register,details;
EditText name,email,phone,password;
String[] countryArr={
        "India",
        "Japan",
        "Canada"
};
String[] IndiaArr={
        "Assam",
        "Bihar",
        "Goa",
        "Delhi"};
String[] JapanArr={
        "Tokyo",
        "Kyoto",
        "Osaka",
        "Nara"};
String[] CanadaArr={
        "Ontario",
        "Alberta",
        "Quebec",
        "Manitoba"};

Spinner stateSpinner,countrySpinner;

ArrayAdapter<String> countryAdapter,Adapter1,Adapter2,Adapter3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register=(Button)findViewById(R.id.registerBtn);
        details=(Button)findViewById(R.id.detailsBtn);
        name=(EditText)findViewById(R.id.nameET);
        email=(EditText) findViewById(R.id.emailET);
        phone=(EditText)findViewById(R.id.phoneET);
        password=(EditText) findViewById(R.id.passET);

        countrySpinner=(Spinner)findViewById(R.id.CountrySpinner);
        stateSpinner=(Spinner)findViewById(R.id.StateSpinner);
        countryAdapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,countryArr);
        countrySpinner.setAdapter(countryAdapter);


        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0){

                    Adapter1=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,IndiaArr);
                    stateSpinner.setAdapter(Adapter1);

                }

                else
                if(position == 1){
                    Adapter2=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,JapanArr);
                    stateSpinner.setAdapter(Adapter2);

                }
                else
                if(position == 2){
                    Adapter3=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,CanadaArr);
                    stateSpinner.setAdapter(Adapter3);

                }
                stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> p, View v, int po, long i) {
                        p2 = stateSpinner.getSelectedItemPosition();
                        text2=stateSpinner.getItemAtPosition(p2).toString();

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }


                });

                 p1 = countrySpinner.getSelectedItemPosition();
                 text=countrySpinner.getItemAtPosition(p1).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterationDetails.class);
                String mail=email.getText().toString();
                String pass=password.getText().toString();
                String phoneNo=phone.getText().toString();
                String username=name.getText().toString();

                intent.putExtra("name",username);
                intent.putExtra("phone",phoneNo);
                intent.putExtra("email",mail);
                intent.putExtra("password",pass);
                intent.putExtra("country",text);
              intent.putExtra("state",text2);
                intent.putExtra("cid",p1);
                intent.putExtra("sid",p2);

                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);

                startActivity(intent);
            }
        });

//int pos=countryAdapter.getPosition("country2");
        name.setText(getIntent().getStringExtra("name2"));
        email.setText(getIntent().getStringExtra("mail2"));
        phone.setText(getIntent().getStringExtra("phone2"));

        countrySpinner.setSelection(getIntent().getIntExtra("country2",0));

        stateSpinner.setSelection(getIntent().getIntExtra("state2",0));

    }

}
