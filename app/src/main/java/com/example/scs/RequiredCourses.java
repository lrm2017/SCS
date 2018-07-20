package com.example.scs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 123 on 2018/7/16.
 */

public class RequiredCourses extends Fragment{
    private View view;
    Button button;
    private List<Required_Course> required_courseList=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null)
            view = inflater.inflate(R.layout.test4,container,false);
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null)
            parent.removeView(view);

        required_courseList=LitePal.findAll(Required_Course.class);
        RequiredAdapter adapter=new RequiredAdapter(getActivity(),R.layout.test4_look,required_courseList);
        ListView listView =(ListView) view.findViewById(R.id.test4_listView);
        listView.setAdapter(adapter);

        return view;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
