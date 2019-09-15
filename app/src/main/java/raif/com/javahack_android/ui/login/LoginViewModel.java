package raif.com.javahack_android.ui.login;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import raif.com.javahack_android.data.DataManager;
import raif.com.javahack_android.ui.base.BaseViewModel;


public class LoginViewModel extends BaseViewModel<LoginNavigator> {

    public LoginViewModel(DataManager dataManager) {
        super(dataManager);
    }


    public void createBusiness(String inn) {
        setIsLoading(true);
        getCompositeDisposable().add(
                getDataManager()
                        .doCreateBusiness(inn)
                        .doOnSuccess(response -> {
                            getDataManager().setCurrentUserName(response.getFirstName());
                            getDataManager().setCurrentUserId(response.getId());
                        })
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(response -> {
                            setIsLoading(false);
                            getNavigator().openNextActivity();
                        }, throwable -> {
                            setIsLoading(false);
                            getNavigator().handleError(throwable);
                        }));
    }

    public void createAcc(){
        getNavigator().createBusiness();
    }

}
