package com.example.scs;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 夏目斑熊 on 2018/7/20.
 */

public class CommenAdapter extends ArrayAdapter<Commen_Course> {
    private int resourceId;
    public CommenAdapter(Context context, int textViewResourceId,
                         List<Commen_Course>objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Commen_Course commen_course=getItem(position);//获取当前实例对象
        View view;
        if (convertView==null){
            view=LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        }
        else {
            view=convertView;
        }
        ImageView imageView1=(ImageView)view.findViewById(R.id.test3_image);
        TextView textView1=(TextView)view.findViewById(R.id.test3_text1);
        TextView textView2=(TextView)view.findViewById(R.id.test3_text2);
        TextView textView3=(TextView)view.findViewById(R.id.test3_text3);
        textView1.setText(commen_course.getCourseId());
        imageView1.setImageResource(commen_course.getImageId());
        textView2.setText(commen_course.getCourse_name());
        textView3.setText(commen_course.getCourse_coad());
        return view;
    }
}
