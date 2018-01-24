package bwe.com.bawei.jdcom.classify.model;

import bwe.com.bawei.jdcom.classify.classifybean.Classify_Bean;
import bwe.com.bawei.jdcom.utils.RetrofitHelper;
import bwe.com.bawei.jdcom.utils.ServiceAPI;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 猥琐的熊猫 on 2017/12/27.
 */

public class Classify_Model {
    public void getClassifydata(final Classifydata classifydata){
        ServiceAPI api = RetrofitHelper.getAPI();
        Observable<Classify_Bean> observable = api.classify();
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Classify_Bean>() {
                    @Override
                    public void accept(Classify_Bean classify_bean) throws Exception {
                        classifydata.classifyData1(classify_bean);
                    }
                });
    }
    public interface Classifydata{
        void classifyData1(Classify_Bean classify_bean);
    }
}
