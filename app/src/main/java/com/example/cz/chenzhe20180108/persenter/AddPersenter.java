package com.example.cz.chenzhe20180108.persenter;

import com.example.cz.chenzhe20180108.bean.AddBean;
import com.example.cz.chenzhe20180108.model.MyAddCallBack;
import com.example.cz.chenzhe20180108.model.MyAddModel;
import com.example.cz.chenzhe20180108.view.AddView;

/**
 * Created by CZ on 2018/1/8.
 */

public class AddPersenter {
    AddView view;
    private final MyAddModel model;

    public AddPersenter(AddView view) {
        this.view = view;
        model = new MyAddModel();
    }

    public void getData(String uid, String pid, String source) {
        model.get(uid, pid, source, new MyAddCallBack() {
            @Override
            public void success(AddBean bean) {
                if (view != null) {
                    view.success(bean);
                }
            }

            @Override
            public void failuer(String e) {
                if (view != null) {
                    view.failuer(e);
                }
            }
        });
    }

    public void sddsds() {
        this.view = null;
    }
}
