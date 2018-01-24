package bwe.com.bawei.jdcom.classify.classifyadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import bwe.com.bawei.jdcom.R;
import bwe.com.bawei.jdcom.classify.classifybean.Classify_Bean;

/**
 * Created by 猥琐的熊猫 on 2017/12/27.
 */

public class Rlv1Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
   private Classify_Bean bean;
    private Context context;

    public Rlv1Adapter(Classify_Bean bean, Context context) {
        this.bean = bean;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.classify_rlv1item, parent, false);
        return new VHitem(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
      VHitem vHitem= (VHitem) holder;
        final Classify_Bean.DataBean bean = this.bean.getData().get(position);
        vHitem.textView.setText(this.bean.getData().get(position).getName());
        vHitem.simpleDraweeView.setImageURI(this.bean.getData().get(position).getIcon());
        vHitem.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onitemclicklisenter.onitemclick(bean);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bean.getData().size();
    }
class VHitem extends RecyclerView.ViewHolder {
     TextView textView;
    SimpleDraweeView simpleDraweeView;
    public VHitem(View itemView) {
        super(itemView);
        textView= (TextView) itemView.findViewById(R.id.classify_Rlv1text);
        simpleDraweeView= (SimpleDraweeView) itemView.findViewById(R.id.classify_Rlvsdv);
    }
}
public interface Onitemclicklisenter{
    void onitemclick(Classify_Bean.DataBean bean);
}
private Onitemclicklisenter onitemclicklisenter;
    public void setOnitemclicklisenter(Onitemclicklisenter onitemclicklisenter){
        this.onitemclicklisenter=onitemclicklisenter;
    }
}
