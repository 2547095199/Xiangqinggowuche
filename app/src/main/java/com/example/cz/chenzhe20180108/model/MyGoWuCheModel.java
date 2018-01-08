package com.example.cz.chenzhe20180108.model;

import com.example.cz.chenzhe20180108.app.MyApp;
import com.example.cz.chenzhe20180108.bean.GoWuCheBean;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by CZ on 2018/1/8.
 */

public class MyGoWuCheModel implements GoWuCheModel {
    @Override
    public void get(String uid, String source, final MyGoWuCheCallBack callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("uid", uid);
        map.put("source", source);
        MyApp.inters.getGWC(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GoWuCheBean>() {
                    @Override
                    public void accept(GoWuCheBean bean) throws Exception {
                        callBack.success(bean);
                    }
                });
    }
}
