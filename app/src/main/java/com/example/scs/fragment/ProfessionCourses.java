package com.example.scs.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.scs.Adapter.pro_course_adapter;
import com.example.scs.R;
import com.example.scs.database.pro_course;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 123 on 2018/7/16.
 */

public class ProfessionCourses extends Fragment {
    private View view;
    private List<pro_course> pro_courseList =new ArrayList<>();
    Button button;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null)
            view = inflater.inflate(R.layout.test2,container,false);
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null)
            parent.removeView(view);
       /* button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"成功了",Toast.LENGTH_SHORT).show();
            }
        });*/

        //initpro_course();
        pro_course_adapter adapter=new pro_course_adapter(getActivity(),
                R.layout.pro_course_item, pro_courseList);
        ListView listView = (ListView) view.findViewById(R.id.list_view);
        listView.setAdapter(adapter);


        return view;
    }

   // private String[] data={"自动控制基础","高等数学2","基础外语4","应用力学","电路1","马克思主义原理","离散数学"};

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    /*private void initpro_course(){

        pro_course zikong=new pro_course();
        zikong.setId(0001);
        zikong.setCourse_name("自动控制基础");
        zikong.setCourse_coad(4);
        zikong.setTeacher("刘冀伟");
        zikong.setImageId(R.drawable.p_549101);
        zikong.save();

        pro_course mayuan=new pro_course();
        mayuan.setId(0111);
        mayuan.setCourse_name("马克思主义原理");
        mayuan.setCourse_coad(3);
        mayuan.setTeacher("刘冀伟");
        mayuan.setImageId(R.drawable.p_549101);
        mayuan.save();

        pro_course gaosu=new pro_course();
        gaosu.setId(0001);
        gaosu.setCourse_name("高等数学");
        gaosu.setCourse_coad(6);
        gaosu.setTeacher("刘冀伟");
        gaosu.setImageId(R.drawable.p_549101);
        gaosu.save();
    }*/

}
