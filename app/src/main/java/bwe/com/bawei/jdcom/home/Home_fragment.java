package bwe.com.bawei.jdcom.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import bwe.com.bawei.jdcom.R;
import bwe.com.bawei.jdcom.home.adapter.Home_Rlvadapter;
import bwe.com.bawei.jdcom.home.bean.Home_Bean;
import bwe.com.bawei.jdcom.home.presenter.Home_presenter;
import bwe.com.bawei.jdcom.home.view.Home_view;

/**
 * Created by 猥琐的熊猫 on 2017/12/25.
 */

public class Home_fragment extends Fragment implements Home_view{
    @BindView(R.id.hom_rlv)
    RecyclerView homRlv;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.home_fragment, null);
        unbinder = ButterKnife.bind(this, view);
        homRlv.setLayoutManager(new GridLayoutManager(getActivity(),2));
        Home_presenter home_presenter=new Home_presenter(this);
        home_presenter.presen();
        return view;
    }
    @Override
    public void gethomeData(Home_Bean home_bean) {
      homRlv.setAdapter(new Home_Rlvadapter(home_bean,getActivity()));
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
