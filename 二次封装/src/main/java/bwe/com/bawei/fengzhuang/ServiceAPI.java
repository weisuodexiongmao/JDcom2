package bwe.com.bawei.fengzhuang;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by 猥琐的熊猫 on 2017/12/25.
 */

public interface ServiceAPI {
    @GET(Api.HOME)
    Observable<Home_Bean> home();

}
