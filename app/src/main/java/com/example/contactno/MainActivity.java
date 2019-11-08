package com.example.contactno;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<contacts_item> mContactsList;
//    private ArrayList<String> names;
//    private ArrayList<String> phones;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private com.google.android.material.floatingactionbutton.FloatingActionButton createbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        ArrayList<String> names = getIntent().getStringArrayListExtra("names");
        ArrayList<String> phones = getIntent().getStringArrayListExtra("phones");

        mContactsList = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            contacts_item kontak = new contacts_item();
            kontak.setmNama(names.get(i));
            kontak.setmNomor(phones.get(i));
            mContactsList.add(new contacts_item(kontak.getNama(), kontak.getNomor()));
        }

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new contact_adapter(mContactsList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        createbutton = findViewById(R.id.fab);
        createbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(MainActivity.this, InsertActivity.class);
                startActivity(home);
            }
        });
    }
}