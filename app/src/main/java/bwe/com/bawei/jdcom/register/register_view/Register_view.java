package bwe.com.bawei.jdcom.register.register_view;

import bwe.com.bawei.jdcom.register.register_bean.Register_Bean;

/**
 * Created by 猥琐的熊猫 on 2018/1/4.
 */

public interface Register_view {
    void getregister(Register_Bean register_bean);
    String regname();
    String regpass();
}
