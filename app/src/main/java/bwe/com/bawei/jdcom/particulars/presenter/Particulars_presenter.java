package bwe.com.bawei.jdcom.particulars.presenter;

import bwe.com.bawei.jdcom.particulars.bean.AddCart_Bean;
import bwe.com.bawei.jdcom.particulars.bean.Particulars_Bean;
import bwe.com.bawei.jdcom.particulars.model.Particulars_Model;
import bwe.com.bawei.jdcom.particulars.model.addCart_Model;
import bwe.com.bawei.jdcom.particulars.view.Particulars_view;

/**
 * Created by 猥琐的熊猫 on 2018/1/2.
 */

public class Particulars_presenter {
    private Particulars_view view;
    private Particulars_Model model;
    private addCart_Model addCart_model;
    public Particulars_presenter(Particulars_view view) {
        this.view = view;
        this.model=new Particulars_Model();
    }
    public void presen(){
        model.getParticulars_Data(new Particulars_Model.getData() {
            @Override
            public void particularsData(Particulars_Bean particulars_bean) {
                view.getParticularsData(particulars_bean);
            }
        },view.pid());
    }
    public void presenadd(){
        addCart_model.addcart(new addCart_Model.getaddData() {
            @Override
            public void getaddcatt(AddCart_Bean addCart_bean) {
                view.getaddcart(addCart_bean);
            }
        },view.adduid(),view.addpid(),view.addtoken());
    }
}
