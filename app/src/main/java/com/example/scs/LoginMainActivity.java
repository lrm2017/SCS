package com.example.scs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

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
                Intent intent = new Intent(LoginMainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.new_counter:
                NewCounter.NewCounterStart(LoginMainActivity.this, "data1", "data2");
                finish();
                break;
            default:
                break;
        }
    }


}
