package raif.com.javahack_android.ui.profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import javax.inject.Inject;

import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import raif.com.javahack_android.BR;
import raif.com.javahack_android.R;
import raif.com.javahack_android.databinding.ActivityMyProfileBinding;
import raif.com.javahack_android.ui.ViewModelProviderFactory;
import raif.com.javahack_android.ui.base.BaseActivity;
import raif.com.javahack_android.ui.main.MainActivity;


public class ProfileActivity extends BaseActivity<ActivityMyProfileBinding, ProfileViewModel> implements ProfileNavigation {

    @Inject
    ViewModelProviderFactory factory;

    private ProfileViewModel mainViewModel;

    private ActivityMyProfileBinding activityMyProfileBinding;

    public static Intent newIntent(Context context) {
        return new Intent(context, ProfileActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_profile;
    }

    @Override
    public ProfileViewModel getViewModel() {
        mainViewModel = ViewModelProviders.of(this,factory).get(ProfileViewModel.class);
        return mainViewModel;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMyProfileBinding = getViewDataBinding();
        mainViewModel.setNavigator(this);

        initToolbar();
    }

    private void initToolbar() {
        Toolbar toolbar = activityMyProfileBinding.toolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            backToLogin();
        } else {
            Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }



    public void backToLogin() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
