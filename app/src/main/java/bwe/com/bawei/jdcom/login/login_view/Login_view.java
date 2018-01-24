package bwe.com.bawei.jdcom.login.login_view;

import bwe.com.bawei.jdcom.login.login_bean.Login_Bean;

/**
 * Created by 猥琐的熊猫 on 2018/1/3.
 */

public interface Login_view {
    void getlogin(Login_Bean login_bean);
    String login_name();
    String login_pass();
}
