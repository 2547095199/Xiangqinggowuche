package com.example.cz.chenzhe20180108.persenter;

import com.example.cz.chenzhe20180108.bean.XiangQingBean;
import com.example.cz.chenzhe20180108.model.MyXiangQingCallBack;
import com.example.cz.chenzhe20180108.model.MyXiangQingModel;
import com.example.cz.chenzhe20180108.view.XiangQingView;

/**
 * Created by CZ on 2018/1/8.
 */

public class XiangQingPersenter {
    XiangQingView view;
    private final MyXiangQingModel model;

    public XiangQingPersenter(XiangQingView view) {
        this.view = view;
        model = new MyXiangQingModel();
    }

    public void getData(String pid, String source) {
        model.get(pid, source, new MyXiangQingCallBack() {
            @Override
            public void success(XiangQingBean bean) {
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

    public void sdsd() {
        this.view = null;
    }
}
