package com.example.scs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

//打开软件的主界面
public class LoginMainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
        //将标题栏隐藏
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.hide();
        }
        Button login = (Button) findViewById(R.id.login);
        Button newCounter = (Button) findViewById(R.id.new_counter);
        login.setOnClickListener(this);
        newCounter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                LoginActivity.LoginStart(LoginMainActivity.this,"data1", "data2");
                break;
            case R.id.new_counter:
                NewCounter.NewCounterStart(LoginMainActivity.this, "data1", "data2");

                break;
            default:
                break;
        }
    }

    public static void actionStart(Context context, String data1, String data2) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra("param1", data1);
        intent.putExtra("param2", data2);
        context.startActivity(intent);
    }

}
