package com.tse.miray.fise3_projetandroid;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.NameList;

/*
    Main activity : shows a list of names
    Click on the Edit button to edit the list i.e. to add a name in the list
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonEdition;
    RecyclerView recyclerView;
    NameListAdapter nameListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initList();
    }


    private void initViews()
    {
        buttonEdition = findViewById(R.id.activity_main_button_edit);
        recyclerView = findViewById(R.id.activity_main_recyclerView);

        buttonEdition.setOnClickListener(this);
    }

    private void initList()
    {
        nameListAdapter = new NameListAdapter();
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(nameListAdapter);
    }


    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.activity_main_button_edit:
                Intent intentGoToFormActivity = new Intent(this, FormActivity.class);
                startActivity(intentGoToFormActivity);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        nameListAdapter.updateList(DataManager.getInstance().getNameList());
    }

    public void deleteRow(View view)
    {
        Button buttonRemove = (Button)view;
        CardView parentCardView =(CardView) buttonRemove.getParent();
        TextView textViewName = (TextView) parentCardView.getChildAt(0);
        String name = textViewName.getText().toString();

        nameListAdapter.removeItem(DataManager.getInstance().getNameList(),name);

        Toast.makeText(this,name + " removed",Toast.LENGTH_SHORT).show();
    }
}

