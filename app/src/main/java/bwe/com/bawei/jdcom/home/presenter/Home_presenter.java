package bwe.com.bawei.jdcom.home.presenter;

import bwe.com.bawei.jdcom.home.bean.Home_Bean;
import bwe.com.bawei.jdcom.home.model.Home_Model;
import bwe.com.bawei.jdcom.home.view.Home_view;

/**
 * Created by 猥琐的熊猫 on 2017/12/25.
 */

public class Home_presenter {
    private Home_view home_view;
    private Home_Model model;
    public Home_presenter(Home_view home_view) {
        this.home_view = home_view;
        this.model=new Home_Model();
    }
    public void presen(){
        model.gethome(new Home_Model.getHomedata() {
            @Override
            public void homeData(Home_Bean home_bean) {
                home_view.gethomeData(home_bean);
            }
        });
    }
}
