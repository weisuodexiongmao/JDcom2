package bwe.com.bawei.jdcom.register.register_presenter;

import bwe.com.bawei.jdcom.register.register_bean.Register_Bean;
import bwe.com.bawei.jdcom.register.register_model.Register_Model;
import bwe.com.bawei.jdcom.register.register_view.Register_view;

/**
 * Created by 猥琐的熊猫 on 2018/1/4.
 */

public class Register_Presenter {
    private Register_view view;
    private Register_Model model;
    public Register_Presenter(Register_view view) {
        this.view = view;
        this.model=new Register_Model();
    }
    public void presen(){
        model.getregister(new Register_Model.getregData() {
            @Override
            public void getdata(Register_Bean register_bean) {
                view.getregister(register_bean);
            }
        },view.regname(),view.regpass());
    }
}
