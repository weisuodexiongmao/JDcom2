package bwe.com.bawei.jdcom.productlist.productlist_presenter;

import bwe.com.bawei.jdcom.productlist.productlist_bean.Productlist_Bean;
import bwe.com.bawei.jdcom.productlist.productlist_mod.Productlist_modle;
import bwe.com.bawei.jdcom.productlist.productlist_view.Productlist_View;

/**
 * Created by 猥琐的熊猫 on 2017/12/29.
 */

public class Productlist_Presenter {
    private Productlist_View productlist_view;
    private Productlist_modle modle;
    public Productlist_Presenter(Productlist_View productlist_view) {
        this.productlist_view = productlist_view;
        this.modle=new Productlist_modle();
    }
    public void presen(){
        modle.getproductlist(new Productlist_modle.getProductlistData() {
            @Override
            public void productlistData(Productlist_Bean productlist_bean) {
                productlist_view.getProductlist(productlist_bean);
            }
        },productlist_view.pscid());
    }
}
