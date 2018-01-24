package bwe.com.bawei.jdcom.productlist.productlist_mod;

import bwe.com.bawei.jdcom.productlist.productlist_bean.Productlist_Bean;
import bwe.com.bawei.jdcom.utils.RetrofitHelper;
import bwe.com.bawei.jdcom.utils.ServiceAPI;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 猥琐的熊猫 on 2017/12/29.
 */

public class Productlist_modle {
    public void getproductlist(final getProductlistData data, String pscid){
        ServiceAPI api = RetrofitHelper.getAPI();
        Observable<Productlist_Bean> observable = api.productlist(pscid);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Productlist_Bean>() {
                    @Override
                    public void accept(Productlist_Bean productlist_bean) throws Exception {
                        data.productlistData(productlist_bean);
                    }
                });
    }
    public interface getProductlistData{
        void productlistData(Productlist_Bean productlist_bean);
    }
}
