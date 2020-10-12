package com.inacap.felipe_gonsa_rodri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HarryActivity extends AppCompatActivity {
    private EditText txt2;
    private EditText txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interfaz);
        txt = findViewById(R.id.txt_usuario);
        txt2 = findViewById(R.id.txt_password);
    }

    public void acercade(View view) {
        Intent intent = new Intent(this,CreadoresActivity.class);
        startActivity(intent);
    }
    public void entrar(View view) {
        if (txt.getText().toString().isEmpty() && (txt2.getText().toString().isEmpty())) {
            Toast.makeText(this, "Ingrese Todos los Campos", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}



