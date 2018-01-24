package bwe.com.bawei.jdcom;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import bwe.com.bawei.jdcom.classify.Fragment_Classify;
import bwe.com.bawei.jdcom.home.Home_fragment;
import bwe.com.bawei.jdcom.mine.Mine_fragment;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fra)
    FrameLayout fra;
    @BindView(R.id.shouyeimage)
    ImageView shouyeimage;
    @BindView(R.id.lin1)
    LinearLayout lin1;
    @BindView(R.id.fenleiimage)
    ImageView fenleiimage;
    @BindView(R.id.lin2)
    LinearLayout lin2;
    @BindView(R.id.faxianimage)
    ImageView faxianimage;
    @BindView(R.id.lin3)
    LinearLayout lin3;
    @BindView(R.id.gouwucheimage)
    ImageView gouwucheimage;
    @BindView(R.id.lin4)
    LinearLayout lin4;
    @BindView(R.id.wodeimage)
    ImageView wodeimage;
    @BindView(R.id.lin5)
    LinearLayout lin5;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        replace(new Home_fragment());
    }

    @OnClick({R.id.shouyeimage, R.id.fenleiimage, R.id.faxianimage, R.id.gouwucheimage, R.id.wodeimage})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shouyeimage:
                replace(new Home_fragment());
                break;
            case R.id.fenleiimage:
                replace(new Fragment_Classify());
                break;
            case R.id.faxianimage:
                break;
            case R.id.gouwucheimage:
                break;
            case R.id.wodeimage:
                replace(new Mine_fragment());
                break;
        }
    }
    public void replace(Fragment f){
         getSupportFragmentManager().beginTransaction().replace(R.id.fra,f).commit();
    }
}
