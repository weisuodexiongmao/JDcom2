package bwe.com.bawei.jdcom.classify.classifyadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import bwe.com.bawei.jdcom.R;
import bwe.com.bawei.jdcom.classify.classifybean.ClassifyBean2;

/**
 * Created by 猥琐的熊猫 on 2017/12/27.
 */

public class ClassifyRlv3Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
   private Context context;
    private List<ClassifyBean2.DataBean.ListBean> list;

    public ClassifyRlv3Adapter(Context context, List<ClassifyBean2.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VHitem(LayoutInflater.from(context).inflate(R.layout.classify_rlv3item,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
      VHitem vHitem= (VHitem) holder;
        final ClassifyBean2.DataBean.ListBean listBean = list.get(position);
        vHitem.textView.setText(list.get(position).getName());
        vHitem.simpleDraweeView.setImageURI(list.get(position).getIcon());
        vHitem.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onitemclincklisenter.onitemclick(listBean);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class VHitem extends RecyclerView.ViewHolder{
        SimpleDraweeView simpleDraweeView;
        TextView textView;
        public VHitem(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.class_Rlv3text);
             simpleDraweeView= (SimpleDraweeView) itemView.findViewById(R.id.classify_Rlv3Sdv);
        }
    }
    public interface Onitemclincklisenter{
        void onitemclick(ClassifyBean2.DataBean.ListBean listBean);
    }
    private Onitemclincklisenter onitemclincklisenter;
    public void setOnitemclincklisenter(Onitemclincklisenter onitemclincklisenter){
        this.onitemclincklisenter=onitemclincklisenter;
    }
}
