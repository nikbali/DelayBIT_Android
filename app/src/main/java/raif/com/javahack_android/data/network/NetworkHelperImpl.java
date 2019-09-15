package raif.com.javahack_android.data.network;

import com.rx2androidnetworking.Rx2AndroidNetworking;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import raif.com.javahack_android.data.model.UserResponseDTO;

@Singleton
public class NetworkHelperImpl implements NetworkHelper {

    @Inject
    public NetworkHelperImpl(){}



    @Override
    public Single<UserResponseDTO> doCreateBusiness(String inn) {

            return Rx2AndroidNetworking.get("http://www.mocky.io/v2/5d7e22182f00008b69fedffb")
                    .addPathParameter("inn", inn)
                    .build()
                    .getObjectSingle(UserResponseDTO.class);
    }
}
