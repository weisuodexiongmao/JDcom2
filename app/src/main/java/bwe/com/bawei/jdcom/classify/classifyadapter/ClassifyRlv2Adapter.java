package bwe.com.bawei.jdcom.classify.classifyadapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import bwe.com.bawei.jdcom.R;
import bwe.com.bawei.jdcom.classify.classifybean.ClassifyBean2;
import bwe.com.bawei.jdcom.productlist.Productlist_Activity;
import bwe.com.bawei.jdcom.productlist.productlist_bean.User;

/**
 * Created by 猥琐的熊猫 on 2017/12/27.
 */

public class ClassifyRlv2Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
   private Context context;
    private ClassifyBean2 bean2;

    public ClassifyRlv2Adapter(Context context, ClassifyBean2 bean2) {
        this.context = context;
        this.bean2 = bean2;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VHItem2(LayoutInflater.from(context).inflate(R.layout.classify_rlv2item,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
          VHItem2 vhItem2= (VHItem2) holder;
        List<ClassifyBean2.DataBean.ListBean> list = bean2.getData().get(position).getList();
        vhItem2.textView.setText(bean2.getData().get(position).getName());
        vhItem2.recyclerView.setLayoutManager(new GridLayoutManager(context,3));
        ClassifyRlv3Adapter classifyRlv3Adapter = new ClassifyRlv3Adapter(context, list);
        vhItem2.recyclerView.setAdapter(classifyRlv3Adapter);
        classifyRlv3Adapter.setOnitemclincklisenter(new ClassifyRlv3Adapter.Onitemclincklisenter() {
            @Override
            public void onitemclick(ClassifyBean2.DataBean.ListBean listBean) {
                int pscid = listBean.getPscid();
                EventBus.getDefault().postSticky(new User(pscid+""));
                context.startActivity(new Intent(context, Productlist_Activity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return bean2.getData().size();
    }
    class VHItem2 extends RecyclerView.ViewHolder{
     TextView textView;
        RecyclerView recyclerView;
        public VHItem2(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.classify_Rlv2text);
            recyclerView= (RecyclerView) itemView.findViewById(R.id.classify_Rlv3);
        }
    }
}
