package bwe.com.bawei.jdcom.indent.indent_model;

import java.util.HashMap;
import java.util.Map;

import bwe.com.bawei.jdcom.indent.indent_bean.Indent_Bean;
import bwe.com.bawei.jdcom.utils.RetrofitHelper;
import bwe.com.bawei.jdcom.utils.ServiceAPI;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 猥琐的熊猫 on 2018/1/5.
 */

public class Indent_Model {
    public void getindent(final getindentdata data, String uid, String token){
        ServiceAPI api = RetrofitHelper.getAPI();
        Map<String, String> map=new HashMap<>();
     map.put("uid",uid);
        map.put("token",token);
        Observable<Indent_Bean> observable = api.indentlist(map);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Indent_Bean>() {
                    @Override
                    public void accept(Indent_Bean indent_bean) throws Exception {
                             data.getdata(indent_bean);
                    }
                });
    }
    public interface getindentdata{
        void getdata(Indent_Bean indent_bean);
    }
}
