package raif.com.javahack_android.data.preference;

public interface PreferencesHelper {

    Long getCurrentUserId();

    void setCurrentUserId(Long userId);

    String getCurrentUserName();

    void setCurrentUserName(String userName);
}
