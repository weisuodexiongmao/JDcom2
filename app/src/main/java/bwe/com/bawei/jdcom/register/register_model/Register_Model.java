package bwe.com.bawei.jdcom.register.register_model;

import bwe.com.bawei.jdcom.register.register_bean.Register_Bean;
import bwe.com.bawei.jdcom.utils.RetrofitHelper;
import bwe.com.bawei.jdcom.utils.ServiceAPI;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 猥琐的熊猫 on 2018/1/4.
 */

public class Register_Model {
    public void getregister(final getregData data, String name, String pass){
        ServiceAPI api = RetrofitHelper.getAPI();
        Observable<Register_Bean> observable = api.register(name, pass);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Register_Bean>() {
                    @Override
                    public void accept(Register_Bean register_bean) throws Exception {
                         data.getdata(register_bean);
                    }
                });
    }
    public interface getregData{
        void getdata(Register_Bean register_bean);
    }
}
