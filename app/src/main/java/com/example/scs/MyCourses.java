package com.example.scs;

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

import com.example.scs.database.Commen_Course;
import com.example.scs.database.Required_Course;
import com.example.scs.database.pro_course;

import org.litepal.LitePal;

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
                pro_course pro_course=new pro_course();
                pro_course.setCourseId("001");
                pro_course.setCourse_name("自动控制基础");
                pro_course.setCourse_coad("4");
                pro_course.setTeacher("刘冀伟");
                pro_course.setImageId(R.drawable.p1171558);
                pro_course.save();

                Commen_Course commen_course=new Commen_Course();
                commen_course.setCourse_coad("3");
                commen_course.setCourse_name("美语语调");
                commen_course.setCourseId("0123");
                commen_course.setTeacher("尚元元");
                commen_course.setImageId(R.drawable.p1188482);
                commen_course.setTime("星期三");
                commen_course.save();

                Required_Course required_course=new Required_Course();
                required_course.setCourse_coad("3");
                required_course.setCourse_name("美语语调");
                required_course.setCourseId("0123");
                required_course.setTeacher("尚元元");
                required_course.setImageId(R.drawable.p1188482);
                required_course.setTime("星期三");
                required_course.save();
                //pro_course_adapter.


               /* pro_course mayuan=new pro_course();
                mayuan.setCourseId("0111");
                mayuan.setCourse_name("马克思主义原理");
                mayuan.setCourse_coad("3");
                mayuan.setTeacher("刘冀伟");
                mayuan.setImageId(R.drawable.p1115685);
                mayuan.save();

                pro_course gaosu=new pro_course();
                gaosu.setCourseId("0126");
                gaosu.setCourse_name("高等数学");
                gaosu.setCourse_coad("6");
                gaosu.setTeacher("王辉");
                gaosu.setImageId(R.drawable.p1171558);
                gaosu.save();*/
            }
        });

        Button queryButton2 =(Button) view.findViewById(R.id.query2_data);
        queryButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                LitePal.deleteAll(Commen_Course.class);
                LitePal.deleteAll(pro_course.class);
            }
        });

        return view;
    }


    /*private void initComment_Cources(){
        Commen_Course kouyu=new Commen_Course("0123","美语语调","2","尚元元",R.drawable.p1188482,"星期三");
        Commen_Course tanbie=new Commen_Course("0124","探寻巴别塔","2","未知",R.drawable.p1213134,"星期一");
        Commen_Course hanzi=new Commen_Course("0126","汉字书法书写","2","韩梅",R.drawable.p1207009,"星期四");
    }*/

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
