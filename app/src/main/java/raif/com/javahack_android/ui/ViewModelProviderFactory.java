package raif.com.javahack_android.ui;


import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import raif.com.javahack_android.data.DataManager;
import raif.com.javahack_android.ui.login.LoginViewModel;
import raif.com.javahack_android.ui.main.MainViewModel;
import raif.com.javahack_android.ui.profile.ProfileViewModel;


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

        } else if (modelClass.isAssignableFrom(MainViewModel.class)) {

            //noinspection unchecked
            return (T) new MainViewModel(dataManager);

        } else if (modelClass.isAssignableFrom(ProfileViewModel.class)) {

            //noinspection unchecked
            return (T) new ProfileViewModel(dataManager);
        }


        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }


}