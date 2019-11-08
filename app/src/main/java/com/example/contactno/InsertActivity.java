package com.example.contactno;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class InsertActivity extends AppCompatActivity {
    private EditText mEditText1;
    private EditText mEditText2;
    private Button mCreateBtn;
    private ArrayList<String> names , phones;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.insert_item);
        names = new ArrayList<>();
        phones = new ArrayList<>();

        mEditText1 = findViewById(R.id.editText1);
        mEditText2 = findViewById(R.id.editText2);
        mCreateBtn = findViewById(R.id.createBtn);


        intent = new Intent(InsertActivity.this,MainActivity.class);

        mCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertItem();
                Intent intent = new Intent(InsertActivity.this, MainActivity.class);
                intent.putExtra("names", names);
                intent.putExtra("phones", phones);
                startActivity(intent);
                finish();
            }
            public void insertItem(){
                String name = mEditText1.getText().toString();
                String phone = mEditText2.getText().toString();

                if (!name.isEmpty() && !phone.isEmpty()) {
                    names.add(name);
                    phones.add(phone);

                    mEditText1.setText("");
                    mEditText2.setText("");
                }
            }
        });

    }

    }
