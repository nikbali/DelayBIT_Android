package raif.com.javahack_android.data.database;


import androidx.room.RoomDatabase;
import raif.com.javahack_android.data.model.entities.User;

@androidx.room.Database(entities = {User.class}, version = 1)
public abstract class Database extends RoomDatabase {

    //todo сюда добавляем дао
    //public abstract UserDao userDao();

}
