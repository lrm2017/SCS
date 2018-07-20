package com.example.scs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.scs.Adapter.ViewerAdapter;
import com.example.scs.fragment.ProfessionCourses;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {
    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;
    private ViewerAdapter viewerAdapter;
    private MenuItem prevMeuItem;
    public SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private SharedPreferences user;
    private SharedPreferences.Editor userEditor;
    public int count = 0;
    private View view;
    private EditText name;
    private EditText age;
    private EditText identify;
    private EditText college;
    private EditText className;
    private EditText motto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //标题栏去掉
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        view = navigationView.getHeaderView(0);
        Button edit = (Button) view.findViewById(R.id.change_information);
        edit.setOnClickListener(this);
        initInformation();
        initBottomNavigationView();
        initViewPager();
    }

    private void initInformation() {
        user = getSharedPreferences("user",MODE_PRIVATE);
        sp = getSharedPreferences(user.getString("id",""),MODE_PRIVATE);

        name = (EditText) view.findViewById(R.id.name);
        age = (EditText) view.findViewById(R.id.age);
        identify = (EditText) view.findViewById(R.id.identify);
        college = (EditText) view.findViewById(R.id.college);
        className = (EditText) view.findViewById(R.id.className);
        motto = (EditText) view.findViewById(R.id.motto);

        name.setText(sp.getString("name",""));
        age.setText(sp.getString("age",""));
        identify.setText(sp.getString("identify",""));
        college.setText(sp.getString("college",""));
        className.setText(sp.getString("class",""));
        motto.setText(sp.getString("motto",""));
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
        BottomNavigationViewHepler.disableShiftMode(bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId())
                        {
                            case R.id.navigation_mycourse:
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.navigation_profession:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.navigation_common:
                                viewPager.setCurrentItem(2);
                                break;
                            case R.id.navigation_required:
                                viewPager.setCurrentItem(3);
                                break;
                        }
                        return false;
                    }
                }
        );
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public static void actionStart(Context context, String data1, String data2) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("param1", data1);
        intent.putExtra("param2", data2);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.change_information:
//                Toast.makeText(MainActivity.this,"success",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,IdentityEditor.class);
                startActivity(intent);
                break;
        }
    }
}
