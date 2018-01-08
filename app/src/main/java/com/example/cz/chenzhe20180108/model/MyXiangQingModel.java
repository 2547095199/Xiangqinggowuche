package com.example.cz.chenzhe20180108.model;

import com.example.cz.chenzhe20180108.app.MyApp;
import com.example.cz.chenzhe20180108.bean.XiangQingBean;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by CZ on 2018/1/8.
 */

public class MyXiangQingModel implements XiangQingModel {
    @Override
    public void get(String pid, String source, final MyXiangQingCallBack callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("pid", pid);
        map.put("source", source);
        MyApp.inters.get(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<XiangQingBean>() {
                    @Override
                    public void accept(XiangQingBean bean) throws Exception {
                        callBack.success(bean);
                    }
                });
    }
}
