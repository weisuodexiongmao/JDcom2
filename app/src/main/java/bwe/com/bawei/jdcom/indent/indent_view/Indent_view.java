package bwe.com.bawei.jdcom.indent.indent_view;

import bwe.com.bawei.jdcom.indent.indent_bean.Indent_Bean;

/**
 * Created by 猥琐的熊猫 on 2018/1/4.
 */

public interface Indent_view {
    void getindent(Indent_Bean indent_bean);
    String indentuid();
    String indenttoken();
}
