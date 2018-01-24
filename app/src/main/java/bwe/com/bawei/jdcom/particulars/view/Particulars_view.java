package bwe.com.bawei.jdcom.particulars.view;

import bwe.com.bawei.jdcom.particulars.bean.AddCart_Bean;
import bwe.com.bawei.jdcom.particulars.bean.Particulars_Bean;

/**
 * Created by 猥琐的熊猫 on 2018/1/2.
 */

public interface Particulars_view {
    void getParticularsData(Particulars_Bean particulars_bean);
    String pid();
    //添加购物车uid pid token
    String adduid();
    String addpid();
    String addtoken();
    void getaddcart(AddCart_Bean addCart_bean);
}
