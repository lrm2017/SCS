package com.example.scs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//输入手机号界面
public class NewCounter extends AppCompatActivity implements View.OnClickListener {
    private SharedPreferences SP;
    private SharedPreferences user;
    private SharedPreferences.Editor editor;
    private SharedPreferences.Editor userEditor;
    private EditText userName;
    private EditText userId;
    private EditText userPassword ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_information);
        Button button = (Button) findViewById(R.id.be_new_member);
        button.setOnClickListener(this);

        userName = findViewById(R.id.set_user_name);
        userId = findViewById(R.id.input_identify);
        userPassword = findViewById(R.id.input_password);

        user = getSharedPreferences("user",MODE_PRIVATE);
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
                userEditor = user.edit();
                userEditor.putString("id",userId.getText().toString());
                userEditor.putString("password",userPassword.getText().toString());
                userEditor.commit();
                SP = getSharedPreferences(user.getString("user",""),MODE_PRIVATE);
                editor = SP.edit();
                editor.putString("name",userName.getText().toString());
                editor.putString("identify",userId.getText().toString());
                editor.putString("password",userPassword.getText().toString());
                editor.commit();
                SuccessLogupActivity.actionStart(NewCounter.this,"param1","param2");
                finish();
                break;
        }
    }
}