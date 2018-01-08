package com.example.cz.chenzhe20180108.model;

import com.example.cz.chenzhe20180108.bean.AddBean;

/**
 * Created by CZ on 2018/1/8.
 */

public interface MyAddCallBack {
    public void success(AddBean bean);

    public void failuer(String e);
}
