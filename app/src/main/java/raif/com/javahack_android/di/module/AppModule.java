package raif.com.javahack_android.di.module;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import androidx.room.Room;
import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import raif.com.javahack_android.ApplicationConstants;
import raif.com.javahack_android.BuildConfig;
import raif.com.javahack_android.data.DataManager;
import raif.com.javahack_android.data.DataManagerImpl;
import raif.com.javahack_android.data.database.Database;
import raif.com.javahack_android.data.database.DatabaseHelper;
import raif.com.javahack_android.data.database.DatabaseHelperImpl;
import raif.com.javahack_android.data.network.NetworkHelper;
import raif.com.javahack_android.data.network.NetworkHelperImpl;
import raif.com.javahack_android.data.preference.PreferencesHelper;
import raif.com.javahack_android.data.preference.PreferencesHelperImpl;
import raif.com.javahack_android.di.DatabaseInfo;
import raif.com.javahack_android.di.PreferenceInfo;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class AppModule {

    @Provides
    @Singleton
    NetworkHelper provideNetworkHelper(NetworkHelperImpl networkHelper) {
        return networkHelper;
    }


    @Provides
    @Singleton
    Database provideDatabase(@DatabaseInfo String dbName, Context context) {
        return Room.databaseBuilder(context, Database.class, dbName).fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(DataManagerImpl dataManager) {
        return dataManager;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return ApplicationConstants.DB_NAME;
    }

    @Provides
    @Singleton
    DatabaseHelper provideDbHelper(DatabaseHelperImpl databaseHelper) {
        return databaseHelper;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return ApplicationConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(PreferencesHelperImpl preferencesHelper) {
        return preferencesHelper;
    }


    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Cache cache) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().cache(cache).build();
        return okHttpClient;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BuildConfig.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    Cache provideOkHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        return new Cache(application.getCacheDir(), cacheSize);
    }
}
