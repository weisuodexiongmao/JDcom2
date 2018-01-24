package bwe.com.bawei.jdcom.indent.indent_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import bwe.com.bawei.jdcom.R;
import bwe.com.bawei.jdcom.indent.indent_bean.Indent_Bean;

/**
 * Created by 猥琐的熊猫 on 2018/1/5.
 */

public class Indent_Rlvadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
  private Context context;
    private Indent_Bean bean;

    public Indent_Rlvadapter(Context context, Indent_Bean bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VHitem(LayoutInflater.from(context).inflate(R.layout.indent_item,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
           VHitem vHitem= (VHitem) holder;
        vHitem.textView.setText("共一件商品 需付款：¥"+bean.getData().get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return bean.getData().size();
    }
    class VHitem extends RecyclerView.ViewHolder{
         TextView textView,textView2;

        public VHitem(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.indent_textView9);
            textView2= (TextView) itemView.findViewById(R.id.indent_textView10);
        }
    }
}
