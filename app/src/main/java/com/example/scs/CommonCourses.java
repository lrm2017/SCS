package com.example.scs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.scs.Adapter.CommenAdapter;
import com.example.scs.R;
import com.example.scs.database.Student_Course;
import com.example.scs.database.Commen_Course;

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
        CommenAdapter adapter=new CommenAdapter(getActivity(),R.layout.test3_look,commen_coursesList);
        ListView listView =(ListView) view.findViewById(R.id.test3_listView);
        listView.setAdapter(adapter);
        return view;
    }



    @Override
    public void onActivityCreated (@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
    }
}
