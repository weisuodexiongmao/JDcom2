package bwe.com.bawei.jdcom.classify.presenter;

import bwe.com.bawei.jdcom.classify.classifybean.ClassifyBean2;
import bwe.com.bawei.jdcom.classify.classifybean.Classify_Bean;
import bwe.com.bawei.jdcom.classify.model.Classify_Model;
import bwe.com.bawei.jdcom.classify.model.Classify_Model2;
import bwe.com.bawei.jdcom.classify.view.Classify_view;

/**
 * Created by 猥琐的熊猫 on 2017/12/27.
 */

public class Classify_Presenter {
    private Classify_view view;
private Classify_Model model;
    private Classify_Model2 model2;
    public Classify_Presenter(Classify_view view) {
        this.view = view;
        this.model=new Classify_Model();
        this.model2=new Classify_Model2();
    }
    public void presen(){
        model.getClassifydata(new Classify_Model.Classifydata() {
            @Override
            public void classifyData1(Classify_Bean classify_bean) {
                view.getClassify(classify_bean);
            }
        });
    }
    public void presen2(){
model2.getClassifyData2(new Classify_Model2.ClassifyData2() {
    @Override
    public void classData2(ClassifyBean2 classifyBean2) {
        view.getClassify2(classifyBean2);
    }
},view.cid());
    }
}
