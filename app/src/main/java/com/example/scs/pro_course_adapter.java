package com.example.scs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
        final pro_course pro_course=getItem(position);//获取当前实例对象
        View view;
        if (convertView==null){
            view=LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        }
        else {
            view=convertView;
        }
        Button button=(Button) view.findViewById(R.id.test2_add_Button) ;
        ImageView imageView1=(ImageView)view.findViewById(R.id.test2_image);
        TextView textView1=(TextView)view.findViewById(R.id.test2_text1);
        TextView textView2=(TextView)view.findViewById(R.id.test2_text2);
        TextView textView3=(TextView)view.findViewById(R.id.test2_text3);
        textView1.setText(pro_course.getCourseId());
        imageView1.setImageResource(pro_course.getImageId());
        textView2.setText(pro_course.getCourse_name());
        textView3.setText(pro_course.getCourse_coad());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* int[] imageArray=new int[]{R.drawable.p1213134,R.drawable.p5318,R.drawable.p12480,R.drawable.p34108,R.drawable.p507329,R.drawable.p543562,
                        R.drawable.p543580,R.drawable.p549100,R.drawable.p549105};
                Random random = new Random();
                int randomImage = random.nextInt(imageArray.length);*/
                Student_Course Student_Course=new Student_Course();
                Student_Course.setCourse_coad(pro_course.getCourse_coad());
                Student_Course.setCourse_name(pro_course.getCourse_name());
                Student_Course.setCourseId(pro_course.getCourseId());
                Student_Course.setTeacher(pro_course.getTeacher());
                Student_Course.setImageId(pro_course.getImageId());
                Student_Course.setTime(pro_course.getTime());
                Student_Course.save();
            }
        });
        return view;
    }
}
