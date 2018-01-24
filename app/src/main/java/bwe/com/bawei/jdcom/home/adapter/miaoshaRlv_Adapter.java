package bwe.com.bawei.jdcom.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import bwe.com.bawei.jdcom.R;
import bwe.com.bawei.jdcom.home.bean.Home_Bean;

/**
 * Created by 猥琐的熊猫 on 2017/12/26.
 */

public class miaoshaRlv_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
   private Context context;
    private List<Home_Bean.MiaoshaBean.ListBeanX> list;

    public miaoshaRlv_Adapter(Context context, List<Home_Bean.MiaoshaBean.ListBeanX> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VHitem(LayoutInflater.from(context).inflate(R.layout.home_rlv2item,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
      VHitem vHitem= (VHitem) holder;
        String images = list.get(position).getImages();
        String[] split = images.split("\\|");
        String s = split[0];
        vHitem.simpleDraweeView.setImageURI(s);
        vHitem.textView.setText("¥："+list.get(position).getPrice()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class VHitem extends RecyclerView.ViewHolder {
        SimpleDraweeView simpleDraweeView;
        TextView textView;
        public VHitem(View itemView) {
            super(itemView);
            simpleDraweeView= (SimpleDraweeView) itemView.findViewById(R.id.miaoRlv2_sdv);
            textView= (TextView) itemView.findViewById(R.id.miaotext);
        }
    }
}
