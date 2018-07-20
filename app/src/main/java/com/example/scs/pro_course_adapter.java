package com.example.scs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

/**
 * Created by 夏目斑熊 on 2018/7/19.
 */

public class pro_course_adapter extends ArrayAdapter<pro_course> {
    private int resourceId;
    public pro_course_adapter(Context context, int textViewResourceId,
                              List<pro_course> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        pro_course pro_course=getItem(position);//获取当前实例对象
        View view;
        if (convertView==null){
            view=LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        }
        else {
            view=convertView;
        }
        ImageView imageView1=(ImageView)view.findViewById(R.id.test2_image);
        TextView textView1=(TextView)view.findViewById(R.id.test2_text1);
        TextView textView2=(TextView)view.findViewById(R.id.test2_text2);
        TextView textView3=(TextView)view.findViewById(R.id.test2_text3);
        textView1.setText(pro_course.getCourseId());
        imageView1.setImageResource(pro_course.getImageId());
        textView2.setText(pro_course.getCourse_name());
        textView3.setText(pro_course.getCourse_coad());
        return view;
    }
}
