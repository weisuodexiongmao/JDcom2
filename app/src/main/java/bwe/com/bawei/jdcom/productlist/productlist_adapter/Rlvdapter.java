package bwe.com.bawei.jdcom.productlist.productlist_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import bwe.com.bawei.jdcom.R;
import bwe.com.bawei.jdcom.productlist.productlist_bean.Productlist_Bean;

/**
 * Created by 猥琐的熊猫 on 2018/1/2.
 */

public class Rlvdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
private Context context;
    private Productlist_Bean bean;

    public Rlvdapter(Context context, Productlist_Bean bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VHitem(LayoutInflater.from(context).inflate(R.layout.productlist_rlvitem,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
      VHitem vHitem= (VHitem) holder;
        final Productlist_Bean.DataBean dataBean = bean.getData().get(position);
        String images = bean.getData().get(position).getImages();
        String[] split = images.split("\\|");
        String s = split[0];
        vHitem.simpleDraweeView.setImageURI(s);
        vHitem.textView.setText(bean.getData().get(position).getTitle());
        vHitem.textView2.setText(bean.getData().get(position).getSubhead());
        vHitem.textView3.setText(bean.getData().get(position).getPrice()+"");
    vHitem.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onitemclicklisenter.onclick(dataBean);
        }
    });
    }

    @Override
    public int getItemCount() {
        return bean.getData().size();
    }
    class VHitem extends RecyclerView.ViewHolder{
         SimpleDraweeView simpleDraweeView;
        TextView textView,textView2,textView3;
        public VHitem(View itemView) {
            super(itemView);
            simpleDraweeView= (SimpleDraweeView) itemView.findViewById(R.id.productlist_sdv);
            textView= (TextView) itemView.findViewById(R.id.productlist_bt);
            textView2= (TextView) itemView.findViewById(R.id.productlist_price);
            textView3= (TextView) itemView.findViewById(R.id.productlist_sp);
        }

    }
    public interface Onitemclicklisenter{
    void onclick(Productlist_Bean.DataBean dataBean);
    }
    private Onitemclicklisenter onitemclicklisenter;
    public void setOnitemclicklisenter(Onitemclicklisenter onitemclicklisenter){
        this.onitemclicklisenter=onitemclicklisenter;
    }
}
