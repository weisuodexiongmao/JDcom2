package bwe.com.bawei.jdcom.utils;

/**
 * Created by 猥琐的熊猫 on 2017/12/25.
 */

public class Api {
    //  首页 https://www.zhaoapi.cn/ad/getAd
    public static final String URl="https://www.zhaoapi.cn/";
    public static final String HOME="ad/getAd";
    //分类1 https://www.zhaoapi.cn/product/getCatagory
    public static final String CLASSIFY="product/getCatagory";
    //分类2 https://www.zhaoapi.cn/product/getProductCatagory
    public static final String CLASSIFY2="product/getProductCatagory";
    //商品列表 https://www.zhaoapi.cn/product/getProducts?pscid=39
    public static final String PRODUCTLIST="product/getProducts";
    //https://www.zhaoapi.cn/product/getProductDetail?pid=40
    public static final String PARTICULARS="product/getProductDetail";
    // 添加购物车https://www.zhaoapi.cn/product/addCart?uid=1758&pid=49&token=72C032EA59A11A107C81D57047F2FF6E&source=android
    public static final String ADDCART="product/addCart";
    //登录 https://www.zhaoapi.cn/user/login?mobile=18637973081&password=123456
    public static final String LOGIN="user/login";
    ///注册https://www.zhaoapi.cn/user/reg?mobile=18637973081&password=123456
    public static final String REGISTER="user/reg";
    //订单列表https://www.zhaoapi.cn/product/getOrders?uid=1758&token=72C032EA59A11A107C81D57047F2FF6E
    public static final String ORDERSLIST="product/getOrders";

}
