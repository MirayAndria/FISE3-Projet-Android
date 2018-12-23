package com.tse.miray.fise3_projetandroid;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/*
    Form to add a name in the list.
    The button Save add the name entered, if any, in the list
    The button Cancel returns to the main activity
 */
public class FormActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonValidate;
    Button buttonCancel;
    EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        initViews();
    }

    private void initViews()
    {
        buttonValidate = findViewById(R.id.activity_form_button_save);
        buttonCancel = findViewById(R.id.activity_form_button_cancel);
        editTextName = findViewById(R.id.activity_form_editText_name);
        buttonValidate.setOnClickListener(this);
        buttonCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.activity_form_button_save:
                saveData();
                break;
            case R.id.activity_form_button_cancel:
                finish();
                break;
        }
    }

    private void saveData()
    {
        String name = editTextName.getText().toString();
        if(!name.isEmpty())
        {
            DataManager.getInstance().addItem(name);
            finish();
        }
        else
        {
            Toast.makeText(this,"Please enter your name",Toast.LENGTH_SHORT).show();
        }
    }
}
