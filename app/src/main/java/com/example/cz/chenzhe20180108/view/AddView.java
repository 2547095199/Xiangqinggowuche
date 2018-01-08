package com.example.cz.chenzhe20180108.view;

import com.example.cz.chenzhe20180108.bean.AddBean;

/**
 * Created by CZ on 2018/1/8.
 */

public interface AddView {
    public void success(AddBean bean);

    public void failuer(String e);
}
