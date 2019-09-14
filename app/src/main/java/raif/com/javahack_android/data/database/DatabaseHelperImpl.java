package raif.com.javahack_android.data.database;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DatabaseHelperImpl implements DatabaseHelper {
    private final Database database;

    @Inject
    public DatabaseHelperImpl(Database database) {

        this.database = database;
    }
}
