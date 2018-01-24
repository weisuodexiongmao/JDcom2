package bwe.com.bawei.jdcom.indent;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import bwe.com.bawei.jdcom.R;
import bwe.com.bawei.jdcom.indent.indent_adapter.Indent_Rlvadapter;
import bwe.com.bawei.jdcom.indent.indent_bean.Indent_Bean;
import bwe.com.bawei.jdcom.indent.indent_presenter.Indent_Presenter;
import bwe.com.bawei.jdcom.indent.indent_view.Indent_view;

public class Indent_activity extends AppCompatActivity implements Indent_view {

    @BindView(R.id.indent_Rlv)
    RecyclerView indentRlv;
    private String uid;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.indent_activity);
        ButterKnife.bind(this);
        indentRlv.setLayoutManager(new LinearLayoutManager(this));
        SharedPreferences user = getSharedPreferences("user", MODE_PRIVATE);
        uid = user.getString("uid", null);
        token = user.getString("token", null);
        Indent_Presenter presenter=new Indent_Presenter(this);
        presenter.presen();

    }

    @Override
    public void getindent(Indent_Bean indent_bean) {
         indentRlv.setAdapter(new Indent_Rlvadapter(this,indent_bean));
    }

    @Override
    public String indentuid() {
        return uid;
    }

    @Override
    public String indenttoken() {
        return token;
    }
}
