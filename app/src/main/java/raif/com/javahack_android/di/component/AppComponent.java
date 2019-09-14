package raif.com.javahack_android.di.component;

import android.app.Application;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import raif.com.javahack_android.JavaHackApp;
import raif.com.javahack_android.di.module.ActivityBuilder;
import raif.com.javahack_android.di.module.AppModule;


@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {

    void inject(JavaHackApp app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
