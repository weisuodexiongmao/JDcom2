package bwe.com.bawei.jdcom.mine;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import bwe.com.bawei.jdcom.R;
import bwe.com.bawei.jdcom.indent.Indent_activity;
import bwe.com.bawei.jdcom.login.Login_activity;
import bwe.com.bawei.jdcom.login.exit;

/**
 * Created by 猥琐的熊猫 on 2018/1/3.
 */

public class Mine_fragment extends Fragment {
    @BindView(R.id.login_image)
    ImageView loginImage;
    @BindView(R.id.dd)
    RadioButton dd;
    @BindView(R.id.shouhuodizhi)
    RadioButton shouhuodizhi;
    Unbinder unbinder;
    @BindView(R.id.tv_name_back)
    TextView tvNameBack;
    private SharedPreferences sp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.mine_fragment, null);
        unbinder = ButterKnife.bind(this, view);
        sp = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
        String name = sp.getString("name", null);
        boolean login = sp.getBoolean("login", false);
        if (login==true){
            tvNameBack.setText(name);
        }
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.login_image, R.id.dd, R.id.shouhuodizhi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_image:
                boolean login = sp.getBoolean("login", false);
                if (login==true){
                    getActivity().startActivity(new Intent(getActivity(), exit.class));
                }else {
                    getActivity().startActivity(new Intent(getActivity(), Login_activity.class));
                }
                break;
            case R.id.dd:
            getActivity().startActivity(new Intent(getActivity(), Indent_activity.class));
                break;
            case R.id.shouhuodizhi:
                break;
        }
    }
}
