package raif.com.javahack_android.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Toast;

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProviders;
import raif.com.javahack_android.BR;
import raif.com.javahack_android.R;
import raif.com.javahack_android.databinding.ActivityLoginBinding;
import raif.com.javahack_android.ui.ViewModelProviderFactory;
import raif.com.javahack_android.ui.base.BaseActivity;


public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> implements LoginNavigator {

    @Inject
    ViewModelProviderFactory factory;

    private LoginViewModel mLoginViewModel;

    private ActivityLoginBinding mActivityLoginBinding;

    public static Intent newIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public LoginViewModel getViewModel() {
        mLoginViewModel = ViewModelProviders.of(this,factory).get(LoginViewModel.class);
        return mLoginViewModel;
    }

    @Override
    public void handleError(Throwable throwable) {

        Toast.makeText(this, String.format("Серверная ошибка: %s", throwable.getMessage()), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void createBusiness() {
        Editable innEditable = mActivityLoginBinding.inn.getText();
        if(innEditable == null){
            Toast.makeText(this, "Не заполнен ИНН", Toast.LENGTH_SHORT).show();
            return;
        }
        String inn = innEditable.toString();


        if (inn.isEmpty()) {
            Toast.makeText(this, "Не заполнен ИНН", Toast.LENGTH_SHORT).show();
            return;

        } else {
            mLoginViewModel.createBusiness(inn);
        }

    }

    @Override
    public void openNextActivity() {
        Intent intent = new Intent(LoginActivity.this, VerificationCodeActivity.class);
        startActivity(intent);
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityLoginBinding = getViewDataBinding();
        mLoginViewModel.setNavigator(this);
    }


}
