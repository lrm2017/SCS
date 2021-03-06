package com.example.scs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.scs.database.Required_Course;
import com.example.scs.database.Student_Course;

import java.util.List;

/**
 * Created by 夏目斑熊 on 2018/7/20.
 */

public class RequiredAdapter extends ArrayAdapter<Required_Course> {
    private int resourceId;
    public RequiredAdapter(Context context, int textViewResourceId,
                           List<Required_Course>objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final Required_Course required_course=getItem(position);//获取当前实例对象
        View view;
        if (convertView==null){
            view=LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        }
        else {
            view=convertView;
        }

        Button button=(Button) view.findViewById(R.id.test4_add_Button) ;
        ImageView imageView1=(ImageView)view.findViewById(R.id.test4_image);
        TextView textView1=(TextView)view.findViewById(R.id.test4_text1);
        TextView textView2=(TextView)view.findViewById(R.id.test4_text2);
        TextView textView3=(TextView)view.findViewById(R.id.test4_text3);
        textView1.setText(required_course.getCourseId());
        imageView1.setImageResource(required_course.getImageId());
        textView2.setText(required_course.getCourse_name());
        textView3.setText(required_course.getCourse_coad());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* int[] imageArray=new int[]{R.drawable.p1213134,R.drawable.p5318,R.drawable.p12480,R.drawable.p34108,R.drawable.p507329,R.drawable.p543562,
                        R.drawable.p543580,R.drawable.p549100,R.drawable.p549105};
                Random random = new Random();
                int randomImage = random.nextInt(imageArray.length);*/
               Student_Course Student_Course=new Student_Course();
                Student_Course.setCourse_coad(required_course.getCourse_coad());
                Student_Course.setCourse_name(required_course.getCourse_name());
                Student_Course.setCourseId(required_course.getCourseId());
                Student_Course.setTeacher(required_course.getTeacher());
                Student_Course.setImageId(required_course.getImageId());
                Student_Course.setTime(required_course.getTime());
                Student_Course.save();
            }
        });

        return view;
    }
}
