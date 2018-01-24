package bwe.com.bawei.jdcom.classify;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import bwe.com.bawei.jdcom.R;
import bwe.com.bawei.jdcom.classify.classifyadapter.ClassifyRlv2Adapter;
import bwe.com.bawei.jdcom.classify.classifyadapter.Rlv1Adapter;
import bwe.com.bawei.jdcom.classify.classifybean.ClassifyBean2;
import bwe.com.bawei.jdcom.classify.classifybean.Classify_Bean;
import bwe.com.bawei.jdcom.classify.presenter.Classify_Presenter;
import bwe.com.bawei.jdcom.classify.view.Classify_view;

/**
 * Created by 猥琐的熊猫 on 2017/12/27.
 */

public class Fragment_Classify extends Fragment implements Classify_view{
    @BindView(R.id.classify_Rlv1)
    RecyclerView classifyRlv1;
    @BindView(R.id.classify_Rlv2)
    RecyclerView classifyRlv2;
    Unbinder unbinder;
    private int cid;
    private Classify_Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.classify_fragment, null);
        unbinder = ButterKnife.bind(this, view);
        classifyRlv1.setLayoutManager(new LinearLayoutManager(getActivity()));
        classifyRlv2.setLayoutManager(new LinearLayoutManager(getActivity()));
        presenter = new Classify_Presenter(this);
        presenter.presen();
        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void getClassify(Classify_Bean classify_bean) {
        Rlv1Adapter rlv1Adapter = new Rlv1Adapter(classify_bean, getActivity());
        rlv1Adapter.setOnitemclicklisenter(new Rlv1Adapter.Onitemclicklisenter() {
            @Override
            public void onitemclick(Classify_Bean.DataBean bean) {
                cid = bean.getCid();
                presenter.presen2();
            }
        });
        classifyRlv1.setAdapter(rlv1Adapter);
    }

    @Override
    public void getClassify2(ClassifyBean2 classifyBean2) {
        classifyRlv2.setAdapter(new ClassifyRlv2Adapter(getActivity(),classifyBean2));

    }

    @Override
    public String cid() {
        return cid+"";
    }
}
