package bwe.com.bawei.jdcom.productlist.productlist_view;

import bwe.com.bawei.jdcom.productlist.productlist_bean.Productlist_Bean;

/**
 * Created by 猥琐的熊猫 on 2017/12/29.
 */

public interface Productlist_View {
    void getProductlist(Productlist_Bean productlist_bean);
    String pscid();
}
