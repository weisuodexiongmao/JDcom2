package bwe.com.bawei.jdcom.indent.indent_bean;

import java.util.List;

/**
 * Created by 猥琐的熊猫 on 2018/1/4.
 */

public class Indent_Bean {

    /**
     * msg : 请求成功
     * code : 0
     * data : [{"createtime":"2017-11-17T19:56:14","orderid":2065,"price":222,"status":0,"title":null,"uid":1758},{"createtime":"2017-11-17T20:14:15","orderid":2087,"price":234,"status":0,"title":null,"uid":1758},{"createtime":"2017-11-17T20:19:30","orderid":2089,"price":222,"status":0,"title":null,"uid":1758},{"createtime":"2017-11-17T21:03:20","orderid":2122,"price":222,"status":0,"title":null,"uid":1758},{"createtime":"2017-11-17T21:05:37","orderid":2125,"price":88,"status":0,"title":null,"uid":1758},{"createtime":"2017-11-19T18:26:53","orderid":2415,"price":456,"status":0,"title":null,"uid":1758},{"createtime":"2017-11-27T19:13:03","orderid":3278,"price":288,"status":0,"title":null,"uid":1758},{"createtime":"2017-11-27T19:22:08","orderid":3279,"price":234,"status":0,"title":null,"uid":1758},{"createtime":"2017-12-13T15:10:42","orderid":3365,"price":111,"status":0,"title":null,"uid":1758}]
     * page : 1
     */

    private String msg;
    private String code;
    private String page;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * createtime : 2017-11-17T19:56:14
         * orderid : 2065
         * price : 222.0
         * status : 0
         * title : null
         * uid : 1758
         */

        private String createtime;
        private int orderid;
        private double price;
        private int status;
        private Object title;
        private int uid;

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public int getOrderid() {
            return orderid;
        }

        public void setOrderid(int orderid) {
            this.orderid = orderid;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public Object getTitle() {
            return title;
        }

        public void setTitle(Object title) {
            this.title = title;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }
    }
}
