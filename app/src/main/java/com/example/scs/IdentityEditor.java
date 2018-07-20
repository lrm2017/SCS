package com.example.scs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.scs.database.Student;

/**
 * Created by 123 on 2018/7/20.
 */

public class IdentityEditor extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_set);
        Button cancel = (Button) findViewById(R.id.title_cancel);
        Button restore = (Button) findViewById(R.id.title_finish);

        cancel.setOnClickListener(this);
        restore.setOnClickListener(this);
        Student student = new Student();
        DataSave(student);
    }

    private void DataSave(Student student) {
        EditText E_name = (EditText)findViewById(R.id.E_name);
        EditText E_age = (EditText) findViewById(R.id.E_age);
        EditText E_identify = (EditText) findViewById(R.id.E_identify);
        EditText E_class = (EditText) findViewById(R.id.E_class);
        EditText E_college =(EditText) findViewById(R.id.E_college);
        EditText E_text = (EditText) findViewById(R.id.infor_text);
        student.setName(E_name.getText().toString());

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.title_cancel:

                break;
            case R.id.title_finish:

                break;
        }
    }
}
