package com.example.cz.chenzhe20180108.inters;

import com.example.cz.chenzhe20180108.bean.AddBean;
import com.example.cz.chenzhe20180108.bean.GoWuCheBean;
import com.example.cz.chenzhe20180108.bean.XiangQingBean;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by CZ on 2018/1/8.
 */

public interface Inters {
    //https://www.zhaoapi.cn/product/getProductDetail
    @GET("/product/getProductDetail")
    Observable<XiangQingBean> get(@QueryMap HashMap<String, String> map);

    //https://www.zhaoapi.cn/product/addCart
    @GET("/product/addCart")
    Observable<AddBean> getAdd(@QueryMap HashMap<String, String> map);

    //https://www.zhaoapi.cn/product/getCarts
    @GET("/product/getCarts")
    Observable<GoWuCheBean> getGWC(@QueryMap HashMap<String, String> map);
}
