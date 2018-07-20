package com.example.scs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//输入手机号界面
public class NewCounter extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_information);
        Button button = (Button) findViewById(R.id.be_new_member);
        button.setOnClickListener(this);
        EditText userName = findViewById(R.id.set_user_name);
        EditText userId = findViewById(R.id.input_identify);
        EditText userPassword = findViewById(R.id.input_password);
    }

    public static void NewCounterStart(Context context, String data1, String data2) {
        Intent intent = new Intent(context, NewCounter.class);
        intent.putExtra("param1", data1);
        intent.putExtra("param2", data2);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.be_new_member:
                SuccessLogupActivity.actionStart(NewCounter.this,"param1","param2");
                finish();
                break;
        }
    }
}