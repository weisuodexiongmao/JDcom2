package bwe.com.bawei.jdcom.login.login_presenter;

import bwe.com.bawei.jdcom.login.login_bean.Login_Bean;
import bwe.com.bawei.jdcom.login.login_model.Login_Model;
import bwe.com.bawei.jdcom.login.login_view.Login_view;

/**
 * Created by 猥琐的熊猫 on 2018/1/3.
 */

public class Login_Presenter {
    private Login_view view;
   private Login_Model model;
    public Login_Presenter(Login_view view) {
        this.view = view;
        this.model=new Login_Model();
    }
    public void prsen(){
        model.getlogin(new Login_Model.getlogin1() {
            @Override
            public void getdata(Login_Bean login_bean) {
                view.getlogin(login_bean);
            }
        },view.login_name(),view.login_pass());
    }
}
