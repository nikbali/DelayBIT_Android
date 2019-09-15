package raif.com.javahack_android.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import javax.inject.Inject;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.lifecycle.ViewModelProviders;
import raif.com.javahack_android.BR;
import raif.com.javahack_android.R;
import raif.com.javahack_android.databinding.ActivityMainBinding;
import raif.com.javahack_android.ui.ViewModelProviderFactory;
import raif.com.javahack_android.ui.base.BaseActivity;


public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements MainNavigation {

    @Inject
    ViewModelProviderFactory factory;

    private MainViewModel mainViewModel;

    private ActivityMainBinding activityMainBinding;

    public static Intent newIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainViewModel getViewModel() {
        mainViewModel = ViewModelProviders.of(this,factory).get(MainViewModel.class);
        return mainViewModel;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = getViewDataBinding();
        mainViewModel.setNavigator(this);

        setUp();
    }


    protected void setUp() {
        setSupportActionBar(activityMainBinding.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
        initNavigationMenu();
    }

    private void initNavigationMenu() {

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                activityMainBinding.activityMain,
                activityMainBinding.toolbar,
               R.string.navigation_drawer_open,
               R.string.navigation_drawer_close) {
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        activityMainBinding.activityMain.addDrawerListener(toggle);
        toggle.syncState();
        View headerLayout = activityMainBinding.navView.getHeaderView(0);


        activityMainBinding.navView.setNavigationItemSelectedListener(item -> {

            activityMainBinding.activityMain.closeDrawer(GravityCompat.START);
            switch (item.getItemId()) {

                case R.id.nav_my_profile:
                    Toast.makeText(this, "Профиль", Toast.LENGTH_SHORT).show();
                    return true;

                case R.id.nav_exit:
                    Toast.makeText(this, "Выход", Toast.LENGTH_SHORT).show();
                    return true;

                default:
                    return false;
            }
        });
    }
}
