package com.example.loginregistersqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db= new DatabaseHelper(this);
        e1= (EditText)findViewById(R.id.emaillogin);
        e2= (EditText)findViewById(R.id.passlogin);
        b1= (Button)findViewById(R.id.btn_login);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email =e1.getText().toString();
                String password =e2.getText().toString();
                Boolean Chkemailpass = db.emailpassword(email,password);
                if (Chkemailpass==true) {
                    Toast.makeText(getApplicationContext(), "Berhasil Login", Toast.LENGTH_SHORT).show();
                    Intent log = new Intent(Login.this, Hlaman1Activity.class);
                    startActivity(log);
                    e1.setText("");
                    e2.setText("");

                }else
                Toast.makeText(getApplicationContext(),"Email atau PAssword salah",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
