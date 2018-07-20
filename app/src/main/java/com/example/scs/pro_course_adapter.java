package com.example.scs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

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
        pro_course pro_course = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView pngImage=(ImageView) view.findViewById(R.id.png_image);
        TextView proCourse=(TextView) view.findViewById(R.id.pro_course);
        pngImage.setImageResource(pro_course.getImageId());
        proCourse.setText(pro_course.getCourse_name());
        return view;
    }
}
