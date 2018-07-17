package com.example.scs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * Created by 123 on 2018/7/15.
 */

public class BottomActivity extends AppCompatActivity
     {

    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;
    private ViewerAdapter viewerAdapter;
    MenuItem prevMeuItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navi_main);

        initBottomNavigationView();
        initViewPager();
    }

    private void initViewPager() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.addOnPageChangeListener(
                new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {
                        if (prevMeuItem != null)
                            prevMeuItem.setChecked(false);
                        else
                            bottomNavigationView.getMenu().getItem(0).setChecked(false);
                        bottomNavigationView.getMenu().getItem(position).setChecked(true);
                        prevMeuItem = bottomNavigationView.getMenu().getItem(position);
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                }
        );
        setupViewPager(viewPager);

    }

     private void setupViewPager(ViewPager viewPager) {
         viewerAdapter = new ViewerAdapter(getSupportFragmentManager());
         viewerAdapter.addFragment(new MyCourses());
         viewerAdapter.addFragment(new ProfessionCourses());
         viewerAdapter.addFragment(new CommonCourses());
         viewerAdapter.addFragment(new RequiredCourses());
         viewPager.setAdapter(viewerAdapter);
     }

     private void initBottomNavigationView() {
        bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId())
                        {
                            case R.id.navigation_common:
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.navigation_mycourse:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.navigation_required:
                                viewPager.setCurrentItem(2);
                                break;
                            case R.id.navigation_profession:
                                viewPager.setCurrentItem(3);
                                break;
                        }
                        return false;
                    }
                }
        );
    }


}
