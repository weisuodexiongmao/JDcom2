package bwe.com.bawei.jdcom.home.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import bwe.com.bawei.jdcom.R;
import bwe.com.bawei.jdcom.home.bean.Home_Bean;

/**
 * Created by 猥琐的熊猫 on 2017/12/25.
 */

public class Home_Rlvadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
private Home_Bean bean;
    private Context context;

    public Home_Rlvadapter(Home_Bean bean, Context context) {
        this.bean = bean;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==0){
            return new VHitem1(LayoutInflater.from(context).inflate(R.layout.home_item1,parent,false));
        }else if (viewType==1){
            return new VHitem2(LayoutInflater.from(context).inflate(R.layout.home_item2,parent,false));
        }else {
            return new VHitem3(LayoutInflater.from(context).inflate(R.layout.home_item3,parent,false));
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position==0){
            VHitem1 vHitem1= (VHitem1) holder;
            List<String>list=new ArrayList<>();
            List<Home_Bean.DataBean> data = bean.getData();
            for (Home_Bean.DataBean beanlist:data){
                String icon = beanlist.getIcon();
                list.add(icon);
            }
            vHitem1.banner.setImages(list);
            vHitem1.banner.setImageLoader(new GlideImageLoader());
            vHitem1.banner.setDelayTime(1000);
            vHitem1.banner.start();
        }else if (position == 1) {
            VHitem2 vHitem2 = (VHitem2) holder;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            vHitem2.recyclerView.setLayoutManager(linearLayoutManager);
            List<Home_Bean.MiaoshaBean.ListBeanX> list = bean.getMiaosha().getList();
            vHitem2.recyclerView.setAdapter(new miaoshaRlv_Adapter(context,list));
        } else {
            VHitem3 vHitem3= (VHitem3) holder;
            String images = bean.getTuijian().getList().get(position).getImages();
            String[] split = images.split("\\|");
            String s = split[0];
            vHitem3.simpleDraweeView.setImageURI(s);
            vHitem3.textView.setText(bean.getTuijian().getList().get(position).getTitle());
            vHitem3.textView2.setText("¥："+bean.getTuijian().getList().get(position).getPrice()+"");
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return 0;
        }else if (position==1){
            return 1;
        }else {
            return 2;
        }

    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager){
            GridLayoutManager gridLayoutManager= (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    int type = getItemViewType(position);
                    switch (type){
                        case 0:
                            return 2;
                        case 1:
                            return 2;
                        case 2:
                            return 1;
                    }
                    return 0;
                }
            });
        }
    }
    @Override
    public int getItemCount() {
        return bean.getTuijian().getList().size();
    }
    class VHitem1 extends RecyclerView.ViewHolder{
        Banner banner;
        public VHitem1(View itemView) {
            super(itemView);
       banner= (Banner) itemView.findViewById(R.id.banner);
        }
    }
    class VHitem2 extends RecyclerView.ViewHolder{
         RecyclerView recyclerView;
        public VHitem2(View itemView) {
            super(itemView);
            recyclerView= (RecyclerView) itemView.findViewById(R.id.home_Rlv2);
        }
    }
    class VHitem3 extends RecyclerView.ViewHolder {
        SimpleDraweeView simpleDraweeView;
        TextView textView,textView2;
        public VHitem3(View itemView) {
            super(itemView);
            simpleDraweeView= (SimpleDraweeView) itemView.findViewById(R.id.home_item3sdv);
            textView= (TextView) itemView.findViewById(R.id.home_item3text);
            textView2= (TextView) itemView.findViewById(R.id.home_item3text2);
        }
    }

    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }


    }
}
