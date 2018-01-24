package bwe.com.bawei.jdcom.indent.indent_presenter;

import bwe.com.bawei.jdcom.indent.indent_bean.Indent_Bean;
import bwe.com.bawei.jdcom.indent.indent_model.Indent_Model;
import bwe.com.bawei.jdcom.indent.indent_view.Indent_view;

/**
 * Created by 猥琐的熊猫 on 2018/1/5.
 */

public class Indent_Presenter {
    private Indent_view view;
    private Indent_Model model;
    public Indent_Presenter(Indent_view view) {
        this.view = view;
        this.model=new Indent_Model();
    }
    public void presen(){
        model.getindent(new Indent_Model.getindentdata() {

            @Override
            public void getdata(Indent_Bean indent_bean) {
                view.getindent(indent_bean);
            }
        },view.indentuid(),view.indenttoken());
    }
}
