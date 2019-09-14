package raif.com.javahack_android.ui;


import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import raif.com.javahack_android.data.DataManager;
import raif.com.javahack_android.ui.login.LoginViewModel;


@Singleton
public class ViewModelProviderFactory extends ViewModelProvider.NewInstanceFactory {

    private final DataManager dataManager;

    @Inject
    public ViewModelProviderFactory(DataManager dataManager) {
        this.dataManager = dataManager;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {

        if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            //noinspection unchecked
            return (T) new LoginViewModel(dataManager);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }


}