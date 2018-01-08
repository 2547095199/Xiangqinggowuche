package com.example.cz.chenzhe20180108.model;

import com.example.cz.chenzhe20180108.bean.XiangQingBean;

/**
 * Created by CZ on 2018/1/8.
 */

public interface MyXiangQingCallBack {
    public void success(XiangQingBean bean);

    public void failuer(String e);
}
