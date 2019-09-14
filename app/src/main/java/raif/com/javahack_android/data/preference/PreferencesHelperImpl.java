package raif.com.javahack_android.data.preference;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

import raif.com.javahack_android.di.PreferenceInfo;

public class PreferencesHelperImpl implements PreferencesHelper {

    private final SharedPreferences mPrefs;

    @Inject
    public PreferencesHelperImpl(Context context, @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
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
}
