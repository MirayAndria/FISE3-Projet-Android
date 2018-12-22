package com.tse.miray.fise3_projetandroid;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonValidate;
    EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        init();
    }

    private void init()
    {
        buttonValidate = findViewById(R.id.activity_form_button_save);
        editTextName = findViewById(R.id.activity_form_editText_name);
        buttonValidate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.activity_form_button_save:
                saveData();
                break;
        }
    }

    private void saveData()
    {
        String name = editTextName.getText().toString();
        if(!name.isEmpty())
        {
            DataManager.getInstance().addItem(name);
        }
        else
        {
            Toast.makeText(this,"Veuillez saisir votre nom",Toast.LENGTH_SHORT).show();
        }
        finish();
    }
}
