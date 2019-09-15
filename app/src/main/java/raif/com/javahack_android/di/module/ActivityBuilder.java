package raif.com.javahack_android.di.module;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import raif.com.javahack_android.ui.main.MainActivity;
import raif.com.javahack_android.ui.SplashActivity;
import raif.com.javahack_android.ui.login.LoginActivity;

@Module
public abstract class ActivityBuilder {


    @ContributesAndroidInjector
    abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector
    abstract SplashActivity bindSplashActivity();
}
