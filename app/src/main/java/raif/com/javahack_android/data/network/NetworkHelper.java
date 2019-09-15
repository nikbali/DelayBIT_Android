package raif.com.javahack_android.data.network;


import io.reactivex.Single;
import raif.com.javahack_android.data.model.UserResponseDTO;

public interface NetworkHelper {

    Single<UserResponseDTO> doCreateBusiness(String inn);

}
