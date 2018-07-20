package com.example.scs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 123 on 2018/7/16.
 */

public class CommonCourses extends Fragment {
    private View view;
    private List<Commen_Course> commen_coursesList=new ArrayList<>();
    private List<Student_Course>student_courseList=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null)
            view = inflater.inflate(R.layout.test3, container, false);
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null)
            parent.removeView(view);

        //initComment_Cources();
       commen_coursesList= LitePal.findAll(Commen_Course.class);
        CommenAdapter adapter=new CommenAdapter(getActivity(),R.layout.test3_look,commen_coursesList);
        ListView listView =(ListView) view.findViewById(R.id.test3_listView);
        listView.setAdapter(adapter);


        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int position, long id) {
                Button button=(Button) view.findViewById(R.id.test3_add_Button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Commen_Course commen_course=commen_coursesList.get(position);
                        Student_Course student_course=new Student_Course(commen_course.getCourse_name(),commen_course.getTeacher(),
                                "0",commen_course.getCourse_coad(),commen_course.getTime());
                        student_courseList.add(student_course);

                        ///////////////////////////这里有student显示列表没有写
                    }
                });
            }
        });*/

        return view;
    }

    @Override
    public void onActivityCreated (@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
    }
}
