package com.shakil.ni_khoj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import com.shakil.ni_khoj.drawerextra.DrawerAdapter;
import com.shakil.ni_khoj.drawerextra.DrawerItem;
import com.shakil.ni_khoj.drawerextra.SimpleItem;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private SlidingRootNav slidingRootNav ;
    private DrawerAdapter adapter;
    private String[] screenTitles;
    private Drawable[] screenIcons;
    private RecyclerView list;
    private static final int POS_HOME = 0;
    private static final int POS_PROFILE = 1;
    private static final int POS_FOUND = 2;
    private static final int POS_SETTINGS = 3;
    private static final int POS_ABOUT = 4;
    private static final int POS_LOGOUT = 5;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init(savedInstanceState);
        bindUIWithComponents();
    }

    private void init(Bundle savedInstanceState) {
        toolbar = findViewById(R.id.tool_bar);
        slidingRootNav  = new SlidingRootNavBuilder(this)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(true)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.menu)
                .inject();

        screenIcons = loadScreenIcons();
        screenTitles = loadScreenTitles();
    }

    private void setAdapter() {
        list = findViewById(R.id.nav_list_item);
        adapter = new DrawerAdapter(Arrays.asList(
                createItemFor(POS_HOME).setChecked(true),
                createItemFor(POS_PROFILE),
                createItemFor(POS_FOUND),
                createItemFor(POS_SETTINGS),
                createItemFor(POS_ABOUT),
                createItemFor(POS_LOGOUT)));
        list.setNestedScrollingEnabled(false);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);
        adapter.setSelected(POS_PROFILE);
    }

    private void showFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.fadein,R.anim.fadeout);
        fragmentTransaction.replace(R.id.container, fragment)
                .commit();
    }

    private DrawerItem createItemFor(int position) {
        return new SimpleItem(screenIcons[position], screenTitles[position])
                .withTextTint(getResources().getColor(R.color.md_blue_grey_700))
                .withSelectedTextTint(getResources().getColor(R.color.md_grey_900));
    }

    private void bindUIWithComponents() {
        setAdapter();
        adapter.setListener(new DrawerAdapter.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int position) {
                final int pos = position;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                    }
                },5);

                slidingRootNav.closeMenu();

            }
        });
    }

    private String[] loadScreenTitles() {
        return getResources().getStringArray(R.array.ld_activityScreenTitles);
    }

    private Drawable[] loadScreenIcons() {
        TypedArray ta = getResources().obtainTypedArray(R.array.ld_activityScreenIcons);
        Drawable[] icons = new Drawable[ta.length()];
        for (int i = 0; i < ta.length(); i++) {
            int id = ta.getResourceId(i, 0);
            if (id != 0) {
                icons[i] = ContextCompat.getDrawable(this, id);
            }
        }
        ta.recycle();
        return icons;
    }

}
