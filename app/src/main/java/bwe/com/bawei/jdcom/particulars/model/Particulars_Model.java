package bwe.com.bawei.jdcom.particulars.model;

import bwe.com.bawei.jdcom.particulars.bean.Particulars_Bean;
import bwe.com.bawei.jdcom.utils.RetrofitHelper;
import bwe.com.bawei.jdcom.utils.ServiceAPI;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 猥琐的熊猫 on 2018/1/2.
 */

public class Particulars_Model {
    public void getParticulars_Data(final getData data, String pid){
        ServiceAPI api = RetrofitHelper.getAPI();
        Observable<Particulars_Bean> observable = api.particulars(pid,"android");
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Particulars_Bean>() {
                    @Override
                    public void accept(Particulars_Bean particulars_bean) throws Exception {
                        data.particularsData(particulars_bean);
                    }
                });
    }
    public interface getData{
        void particularsData(Particulars_Bean particulars_bean);
    }
}
