package bwe.com.bawei.jdcom.particulars.model;

import java.util.HashMap;
import java.util.Map;

import bwe.com.bawei.jdcom.particulars.bean.AddCart_Bean;
import bwe.com.bawei.jdcom.utils.RetrofitHelper;
import bwe.com.bawei.jdcom.utils.ServiceAPI;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 猥琐的熊猫 on 2018/1/3.
 */

public class addCart_Model {
    public void addcart(final getaddData data, String uid, String pid, String token){
        ServiceAPI api = RetrofitHelper.getAPI();
        Map<String, String> map=new HashMap<>();
        map.put("uid",uid);
        map.put("pid",pid);
        map.put("token",token);
        map.put("suorce","android");
        Observable<AddCart_Bean> observable = api.addcart(map);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<AddCart_Bean>() {
                    @Override
                    public void accept(AddCart_Bean addCart_bean) throws Exception {
                        data.getaddcatt(addCart_bean);
                    }
                });

    }
    public interface getaddData{
        void getaddcatt(AddCart_Bean addCart_bean);
    }
}
