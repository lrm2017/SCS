package com.example.scs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

//输入手机号界面
public class NewCounter extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_information);
//        Button back = (Button) findViewById(R.id.back);
//        back.setOnClickListener(this);
//        Button nextStep = (Button)findViewById(R.id.next_step);
//        nextStep.setOnClickListener(this);
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
//            case R.id.back:
//                break;
//            case R.id.next_step:
//                //启动短信认证的界面
//                //AuthenticationCode.actionStart(NewCounter.this,"data1", "data2");
//                break;
        }
    }
}
