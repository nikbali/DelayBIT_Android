package raif.com.javahack_android.data;

import raif.com.javahack_android.data.database.DatabaseHelper;
import raif.com.javahack_android.data.network.NetworkHelper;
import raif.com.javahack_android.data.preference.PreferencesHelper;


public interface DataManager extends DatabaseHelper, PreferencesHelper, NetworkHelper {


}
