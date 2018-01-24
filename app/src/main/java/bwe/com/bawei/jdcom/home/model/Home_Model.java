package bwe.com.bawei.jdcom.home.model;

import bwe.com.bawei.jdcom.home.bean.Home_Bean;
import bwe.com.bawei.jdcom.utils.RetrofitHelper;
import bwe.com.bawei.jdcom.utils.ServiceAPI;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 猥琐的熊猫 on 2017/12/25.
 */

public class Home_Model {
public void gethome(final getHomedata gethomedata){
    ServiceAPI api = RetrofitHelper.getAPI();
    Observable<Home_Bean> home = api.home();
    home.subscribeOn(Schedulers.io()).
            observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Consumer<Home_Bean>() {
                @Override
                public void accept(Home_Bean home_bean) throws Exception {
                                gethomedata.homeData(home_bean);
                }
            });
}
public interface getHomedata{
    void homeData(Home_Bean home_bean);
}
}
