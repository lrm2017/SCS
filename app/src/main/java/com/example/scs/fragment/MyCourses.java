package com.example.scs.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.scs.R;
import com.example.scs.database.Commen_Course;
import com.example.scs.database.pro_course;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by 123 on 2018/7/16.
 */

public class MyCourses extends Fragment {
    private View view;
    Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null)
            view = inflater.inflate(R.layout.test1,container,false);
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null)
            parent.removeView(view);
        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"成功了",Toast.LENGTH_SHORT).show();
            }
        });

        //用来查看数据库，完美
        Button queryButton =(Button) view.findViewById(R.id.query_data);
        queryButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                List<Commen_Course> procourses= DataSupport.findAll(Commen_Course.class);
                for(Commen_Course commen_course:procourses){
                    Log.d("CommonCourses","course name is"+commen_course.getCourse_name());
                    Log.d("CommonCourses","course teacher is"+commen_course.getTeacher());
                    Log.d("CommonCourses","course time is"+commen_course.getTime());
                    Log.d("CommonCourses","course coad is"+commen_course.getCourse_coad());
                    Log.d("CommonCourses","course id is"+commen_course.getId());
                }
               LitePal.deleteAll(Commen_Course.class);
                LitePal.deleteAll(pro_course.class);
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getUserVisibleHint()){
            showdata();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        // 每次切换fragment时调用的方法
        if (isVisibleToUser) {
            showdata();
        }
    }

    public static boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == event.KEYCODE_BACK) {
            Log.d("GameFragmet事件", "OK");
        }
        return true;
    }

    private void showdata() {
        //Toast.makeText(getActivity(), "Game", Toast.LENGTH_SHORT).show();
    }
}
