package raif.com.javahack_android.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import javax.inject.Inject;

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
    }
}
