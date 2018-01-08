package com.example.cz.chenzhe20180108.model;

import com.example.cz.chenzhe20180108.bean.GoWuCheBean;

/**
 * Created by CZ on 2018/1/8.
 */

public interface MyGoWuCheCallBack {
    public void success(GoWuCheBean bean);

    public void failuer(String e);
}
