package bwe.com.bawei.jdcom.login.login_model;

import bwe.com.bawei.jdcom.login.login_bean.Login_Bean;
import bwe.com.bawei.jdcom.utils.RetrofitHelper;
import bwe.com.bawei.jdcom.utils.ServiceAPI;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 猥琐的熊猫 on 2018/1/3.
 */

public class Login_Model {
    public void getlogin(final getlogin1 data, String name, String pass){
        ServiceAPI api = RetrofitHelper.getAPI();
        Observable<Login_Bean> observable = api.login(name, pass);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Login_Bean>() {
                    @Override
                    public void accept(Login_Bean login_bean) throws Exception {
                          data.getdata(login_bean);
                    }
                });
    }
    public interface getlogin1{
        void getdata(Login_Bean login_bean);
    }
}
