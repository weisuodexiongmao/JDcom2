package bwe.com.bawei.jdcom.classify.model;

import bwe.com.bawei.jdcom.classify.classifybean.ClassifyBean2;
import bwe.com.bawei.jdcom.utils.RetrofitHelper;
import bwe.com.bawei.jdcom.utils.ServiceAPI;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 猥琐的熊猫 on 2017/12/27.
 */

public class Classify_Model2 {
    public void getClassifyData2(final ClassifyData2 data2, String cid){
        ServiceAPI api = RetrofitHelper.getAPI();
        Observable<ClassifyBean2> observable = api.classify2(cid);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ClassifyBean2>() {
                    @Override
                    public void accept(ClassifyBean2 classifyBean2) throws Exception {
                        data2.classData2(classifyBean2);
                    }
                });
    }
    public interface ClassifyData2{
        void classData2(ClassifyBean2 classifyBean2);
    }
}
