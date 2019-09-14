package raif.com.javahack_android.ui.login;

import raif.com.javahack_android.data.DataManager;
import raif.com.javahack_android.ui.base.BaseViewModel;


public class LoginViewModel extends BaseViewModel<LoginNavigator> {

    public LoginViewModel(DataManager dataManager) {
        super(dataManager);
    }


    public void login(String inn) {

    }


    public void onServerLoginClick() {
        getNavigator().login();
    }
}
