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

///登录界面
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private PopupWindow mPopWindow;
    private Context context;
    private View mView;
    private Window mWindow;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.pop_up,null);
        Button forgetPassword = (Button) findViewById(R.id.login_forget_password);
        forgetPassword.setOnClickListener(this);
        Button logUp = (Button) findViewById(R.id.log_up);
        logUp.setOnClickListener(this);
        Button Login = (Button) findViewById(R.id.login) ;
        Login.setOnClickListener(this);
    }

    private void showPopupWindow() {
        if (mPopWindow != null && mPopWindow.isShowing()) return;
        //设置contentView
        View contentView = LayoutInflater.from(LoginActivity.this).inflate(R.layout.pop_up, null);
        mPopWindow = new PopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        mPopWindow.setContentView(contentView);
        mPopWindow.setBackgroundDrawable(new ColorDrawable(0xb0000000));
        mPopWindow.setOutsideTouchable(true);
        mPopWindow.setFocusable(true);
        mPopWindow.setTouchable(true);
        mPopWindow.setAnimationStyle(R.style.Animation);
        mPopWindow.setClippingEnabled(true);
        mPopWindow.showAtLocation(findViewById(android.R.id.content), Gravity.BOTTOM, 0, 0);

        mPopWindow.showAsDropDown(mView);
        //设置各个控件的点击响应
        Button findPassword = (Button) contentView.findViewById(R.id.find_password);
        Button ByMessageLogin = (Button) contentView.findViewById(R.id.by_message_login);
        Button cancel = (Button)contentView.findViewById(R.id.cancel);
        findPassword.setOnClickListener(this);
        ByMessageLogin.setOnClickListener(this);
        cancel.setOnClickListener(this);
        //显示PopupWindow
        View rootview = LayoutInflater.from(LoginActivity.this).inflate(R.layout.activity_login_main, null);
        mPopWindow.showAtLocation(rootview, Gravity.BOTTOM, 0, 0);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.log_up:
                NewCounter.NewCounterStart(LoginActivity.this, "data1", "data2");
                finish();
                break;
            case R.id.login_forget_password:
                showPopupWindow();//弹出
                break;
            case R.id.find_password:
            break;
            case R.id.by_message_login:
                Toast.makeText(LoginActivity.this,"jfkdfjhdj",Toast.LENGTH_SHORT).show();
            break;
            case R.id.cancel:
                mPopWindow.dismiss();
            break;
            case R.id.login:
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    void setBackGroundLevel(float level) {
        mWindow = ((Activity) context).getWindow();
        WindowManager.LayoutParams params = mWindow.getAttributes();
        params.alpha = level;
        mWindow.setAttributes(params);
    }

    public static void LoginStart(Context context, String data1, String data2) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra("param1", data1);
        intent.putExtra("param2", data2);
        context.startActivity(intent);
    }
}
