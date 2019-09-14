package raif.com.javahack_android.di.module;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import raif.com.javahack_android.ui.LoginActivity;
import raif.com.javahack_android.ui.MainActivity;
import raif.com.javahack_android.ui.SplashActivity;

@Module
public abstract class ActivityBuilder {


    @ContributesAndroidInjector
    abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector
    abstract SplashActivity bindSplashActivity();
}
