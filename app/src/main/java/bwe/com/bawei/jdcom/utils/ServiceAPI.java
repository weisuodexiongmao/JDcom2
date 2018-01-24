package bwe.com.bawei.jdcom.utils;

import java.util.Map;

import bwe.com.bawei.jdcom.classify.classifybean.ClassifyBean2;
import bwe.com.bawei.jdcom.classify.classifybean.Classify_Bean;
import bwe.com.bawei.jdcom.home.bean.Home_Bean;
import bwe.com.bawei.jdcom.indent.indent_bean.Indent_Bean;
import bwe.com.bawei.jdcom.login.login_bean.Login_Bean;
import bwe.com.bawei.jdcom.particulars.bean.AddCart_Bean;
import bwe.com.bawei.jdcom.particulars.bean.Particulars_Bean;
import bwe.com.bawei.jdcom.productlist.productlist_bean.Productlist_Bean;
import bwe.com.bawei.jdcom.register.register_bean.Register_Bean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by 猥琐的熊猫 on 2017/12/25.
 */

public interface ServiceAPI {
    //首页
    @GET(Api.HOME)
    Observable<Home_Bean> home();
//分类
    @GET(Api.CLASSIFY)
    Observable<Classify_Bean>classify();
    //分类子列表
    @GET(Api.CLASSIFY2)
    Observable<ClassifyBean2>classify2(@Query("cid")String cid);
    @GET(Api.PRODUCTLIST)
    Observable<Productlist_Bean>productlist(@Query("pscid")String pscid);
    //详情
    @GET(Api.PARTICULARS)
    Observable<Particulars_Bean>particulars(@Query("pid")String pid,@Query("suorce")String suorce);
    //添加购物车
    @GET(Api.ADDCART)
    Observable<AddCart_Bean>addcart(@QueryMap Map<String,String>map);
    //登录
    @GET(Api.LOGIN)
    Observable<Login_Bean>login(@Query("mobile")String name,@Query("password")String pass);
   //注册
    @GET(Api.REGISTER)
    Observable<Register_Bean>register(@Query("mobile")String name,@Query("password")String pass);
   //订单列表
    @GET(Api.ORDERSLIST)
    Observable<Indent_Bean>indentlist(@QueryMap Map<String,String>map);
}
