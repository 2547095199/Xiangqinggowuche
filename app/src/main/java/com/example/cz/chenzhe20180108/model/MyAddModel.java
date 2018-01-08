package com.example.cz.chenzhe20180108.model;

import com.example.cz.chenzhe20180108.app.MyApp;
import com.example.cz.chenzhe20180108.bean.AddBean;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by CZ on 2018/1/8.
 */

public class MyAddModel implements AddModel {

    @Override
    public void get(String uid, String pid, String source, final MyAddCallBack callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("uid", uid);
        map.put("pid", pid);
        map.put("source", source);
        MyApp.inters.getAdd(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<AddBean>() {
                    @Override
                    public void accept(AddBean bean) throws Exception {
                        callBack.success(bean);
                    }
                });
    }
}
