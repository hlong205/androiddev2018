package dotafriendly.usth.edu.vn.dotafriendly;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

//    private FeatureCoverFlow coverFlow;
//    private CoverFlowAdapter adapter;
//    private ArrayList<News> news;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        if(getSupportActionBar() != null){
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        }

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        PagerAdapter adapter = new HomeFragmentPagerAdapter(getSupportFragmentManager());

        ViewPager pager = (ViewPager)findViewById(R.id.pager);
        pager.setOffscreenPageLimit(getResources().getInteger(R.integer.offscreenpagelimit));
        pager.setAdapter(adapter);

        tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(pager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

       /* coverFlow = (FeatureCoverFlow) findViewById(R.id.coverflow);

        settingDummyData();
        adapter = new CoverFlowAdapter(this,news);
        coverFlow.setAdapter(adapter);
        coverFlow.setOnScrollPositionListener(onScrollListener());
    } */

    /* private FeatureCoverFlow.OnScrollPositionListener onScrollListener() {
        return new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                Log.v("MainActiivty", "position: " + position);
            }

            @Override
            public void onScrolling() {
                Log.i("MainActivity", "scrolling");
            }
        };
    }*/



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
        getMenuInflater().inflate(R.menu.options_menu, menu);

//        MenuInflater inflaterSearch = getMenuInflater();
//        inflaterSearch.inflate(R.menu.options_menu, menu);
//
//        MenuInflater inflaterSetting = getMenuInflater();
//        inflaterSetting.inflate(R.menu.main, menu);
//
       // Associate searchable configuration with the SearchView
//        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
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
        int id = item.getItemId();

        if (id == R.id.nav_heroes) {
//            Intent intent = new Intent(this, HeroesActivity.class);
//            startActivity(intent);
            tabLayout.getTabAt(1).select();

        } else if (id == R.id.nav_items) {
//            Intent intent = new Intent(this, ItemsActivity.class);
//            startActivity(intent);
            tabLayout.getTabAt(2).select();

        } else if (id == R.id.nav_players) {
//            Intent intent = new Intent(this, PlayersActivity.class);
//            startActivity(intent);
            tabLayout.getTabAt(3).select();

        } else if (id == R.id.nav_matches) {
//            Intent intent = new Intent(this, MatchesActivity.class);
//            startActivity(intent);
            tabLayout.getTabAt(4).select();

        } else if (id == R.id.nav_news) {
//            Intent intent = new Intent(this, NewsActivity.class);
//            startActivity(intent);
            tabLayout.getTabAt(0).select();

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {
        private final int PAGE_COUNT = getResources().getInteger(R.integer.pagecount);
        private String titles[] = {getResources().getString(R.string.news), getResources().getString(R.string.heroes), getResources().getString(R.string.items), getResources().getString(R.string.players), getResources().getString(R.string.matches)};

        public HomeFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public Fragment getItem(int page) {
            //return an instance of Fragment corresponding to the specified page
            switch (page) {
               case 0: return new NewsFragment();
//                case 1: return new WeatherFragment();
//                case 2: return new ScienceFragment();
//                case 3: return new SportFragment();
//                case 4: return new TechnologyFragment();
            }
            return new Fragment(); //failcase
        }

        @Override
        public CharSequence getPageTitle(int page) {
            //return a tab title corresponding to the specified page
            return titles[page];
        }
    }


}
