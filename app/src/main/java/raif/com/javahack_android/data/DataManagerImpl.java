package raif.com.javahack_android.data;

import android.content.Context;

import com.google.gson.Gson;

import javax.inject.Inject;

import io.reactivex.Single;
import raif.com.javahack_android.data.database.DatabaseHelper;
import raif.com.javahack_android.data.model.UserResponseDTO;
import raif.com.javahack_android.data.network.NetworkHelper;
import raif.com.javahack_android.data.preference.PreferencesHelper;

public class DataManagerImpl implements DataManager {

    private  NetworkHelper networkHelper;

    private final Context mContext;

    private final DatabaseHelper mDbHelper;

    private final Gson mGson;

    private final PreferencesHelper mPreferencesHelper;

    @Inject
    public DataManagerImpl(Context context,
                           DatabaseHelper databaseHelper,
                           PreferencesHelper preferencesHelper,
                           NetworkHelper networkHelper,
                           Gson gson) {
        this.mContext = context;
        this.mDbHelper = databaseHelper;
        this.mPreferencesHelper = preferencesHelper;
        this.mGson = gson;
        this.networkHelper = networkHelper;
    }

    @Override
    public Long getCurrentUserId() {
        return null;
    }

    @Override
    public void setCurrentUserId(Long userId) {

    }

    @Override
    public String getCurrentUserName() {
        return null;
    }

    @Override
    public void setCurrentUserName(String userName) {

    }

    @Override
    public Single<UserResponseDTO> doCreateBusiness(String inn) {
        return networkHelper.doCreateBusiness(inn);
    }
}
