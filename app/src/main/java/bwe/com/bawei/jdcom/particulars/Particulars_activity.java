package bwe.com.bawei.jdcom.particulars;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import bwe.com.bawei.jdcom.R;
import bwe.com.bawei.jdcom.particulars.bean.AddCart_Bean;
import bwe.com.bawei.jdcom.particulars.bean.Particulars_Bean;
import bwe.com.bawei.jdcom.particulars.presenter.Particulars_presenter;
import bwe.com.bawei.jdcom.particulars.view.Particulars_view;
import bwe.com.bawei.jdcom.productlist.productlist_bean.User;

public class Particulars_activity extends AppCompatActivity implements Particulars_view {

    @BindView(R.id.particulars_banner)
    Banner particularsBanner;
    @BindView(R.id.particulars_textView)
    TextView particularsTextView;
    @BindView(R.id.particulars_textView2)
    TextView particularsTextView2;
    @BindView(R.id.particulars_textView3)
    TextView particularsTextView3;
    @BindView(R.id.particulars_textView4)
    TextView particularsTextView4;
    private String pid;
    private String token;
    private String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.particulars_activity);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        SharedPreferences user = getSharedPreferences("user", MODE_PRIVATE);
        uid = user.getString("uid", null);
        token = user.getString("token", null);
        Particulars_presenter particulars_presenter = new Particulars_presenter(this);
        particulars_presenter.presen();
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getpid(User user) {
        pid = user.getPscid();
        Log.d("TTT", pid);
    }

    @Override
    public void getParticularsData(Particulars_Bean particulars_bean) {
        String name = particulars_bean.getSeller().getName();
        Log.d("TAGG2", name);
        List<String>list=new ArrayList<>();
        String images = particulars_bean.getData().getImages();
        String[] split = images.split("\\|");
        for (String str:split){
            list.add(str);
        }
        particularsBanner.setImages(list);
        particularsBanner.setImageLoader(new GlideImageLaoder());
        particularsBanner.setDelayTime(1000);
        particularsBanner.start();
        particularsTextView.setText(particulars_bean.getData().getTitle());
        particularsTextView2.setText(particulars_bean.getData().getSubhead());
        particularsTextView3.setText(particulars_bean.getData().getPrice()+"");
    }

    @Override
    public String pid() {
        return pid;
    }

    @Override
    public String adduid() {
        return uid;
    }

    @Override
    public String addpid() {
        return pid;
    }

    @Override
    public String addtoken() {
        return token;
    }

    @Override
    public void getaddcart(AddCart_Bean addCart_bean) {
        Toast.makeText(Particulars_activity.this,"添加购物车成功",Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.particulars_textView4)
    public void onViewClicked() {
        Particulars_presenter particulars_presenter = new Particulars_presenter(this);
        particulars_presenter.presenadd();

    }
    class GlideImageLaoder extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }
}
