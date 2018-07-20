package com.example.scs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.scs.database.Student;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

import java.util.List;

/**
 * Created by 123 on 2018/7/20.
 */

public class IdentityEditor extends AppCompatActivity implements View.OnClickListener {
    private boolean flag = false;
    private EditText E_name ;
    private EditText E_age ;
    private EditText E_identify;
    private EditText E_class ;
    private EditText E_college;
    private EditText E_text;
    private Student student;
    private  SharedPreferences SP;
    private SharedPreferences user;
    private  SharedPreferences.Editor editor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_set);
        Button cancel = (Button) findViewById(R.id.title_cancel);
        Button restore = (Button) findViewById(R.id.title_finish);
        E_name = (EditText) findViewById(R.id.E_name);
        E_age = (EditText) findViewById(R.id.E_age);
        E_identify = (EditText) findViewById(R.id.E_identify);
        E_class = (EditText) findViewById(R.id.E_class);
        E_college = (EditText) findViewById(R.id.E_college);
        E_text = (EditText) findViewById(R.id.infor_text);
        user = getSharedPreferences("user",MODE_PRIVATE);
        SP = getSharedPreferences(user.getString("id",""),MODE_PRIVATE);
        editor = SP.edit();

        cancel.setOnClickListener(this);
        restore.setOnClickListener(this);
        E_name.setText(SP.getString("name",""));
        E_age.setText(SP.getString("age",""));
        E_class.setText(SP.getString("class",""));
        E_college.setText(SP.getString("college",""));
        E_identify.setText(SP.getString("identify",""));
        E_text.setText(SP.getString("motto",""));
//        Toast.makeText(IdentityEditor.this,SP.getString("name",""),Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.title_cancel:
                finish();
                break;
            case R.id.title_finish:
                editor.putString("name",E_name.getText().toString());
                editor.putString("age",(E_age.getText().toString()));
                editor.putString("class",E_class.getText().toString());
                editor.putString("college",E_college.getText().toString());
                editor.putString("identify",E_identify.getText().toString());
                editor.putString("motto",E_text.getText().toString());
                editor.commit();
//                Toast.makeText(IdentityEditor.this,Integer.parseInt(E_age.getText().toString())+"成功了",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(IdentityEditor.this,MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
