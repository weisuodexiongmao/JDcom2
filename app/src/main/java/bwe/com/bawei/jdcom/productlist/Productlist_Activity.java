package bwe.com.bawei.jdcom.productlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import bwe.com.bawei.jdcom.R;
import bwe.com.bawei.jdcom.particulars.Particulars_activity;
import bwe.com.bawei.jdcom.productlist.productlist_adapter.Rlvdapter;
import bwe.com.bawei.jdcom.productlist.productlist_bean.Productlist_Bean;
import bwe.com.bawei.jdcom.productlist.productlist_bean.User;
import bwe.com.bawei.jdcom.productlist.productlist_presenter.Productlist_Presenter;
import bwe.com.bawei.jdcom.productlist.productlist_view.Productlist_View;

public class Productlist_Activity extends AppCompatActivity implements Productlist_View {

    @BindView(R.id.productlist_Rlv)
    RecyclerView productlistRlv;
    private String pscid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productlist_);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        productlistRlv.setLayoutManager(new LinearLayoutManager(this));
        Productlist_Presenter productlist_presenter=new Productlist_Presenter(this);
        productlist_presenter.presen();
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getpscid(User user) {
        pscid = user.getPscid();

    }

    @Override
    public void getProductlist(Productlist_Bean productlist_bean) {
        Rlvdapter rlvdapter = new Rlvdapter(this, productlist_bean);
        productlistRlv.setAdapter(rlvdapter);
        rlvdapter.setOnitemclicklisenter(new Rlvdapter.Onitemclicklisenter() {
            @Override
            public void onclick(Productlist_Bean.DataBean dataBean) {
                int pid = dataBean.getPid();
                Log.d("TAGG",pid+"");
                EventBus.getDefault().postSticky(new User(pid+""));
                startActivity(new Intent(Productlist_Activity.this, Particulars_activity.class));
            }
        });
    }

    @Override
    public String pscid() {
        return pscid;
    }
}
