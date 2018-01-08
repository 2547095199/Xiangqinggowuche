package com.example.cz.chenzhe20180108;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cz.chenzhe20180108.bean.AddBean;
import com.example.cz.chenzhe20180108.bean.XiangQingBean;
import com.example.cz.chenzhe20180108.persenter.AddPersenter;
import com.example.cz.chenzhe20180108.persenter.XiangQingPersenter;
import com.example.cz.chenzhe20180108.view.AddView;
import com.example.cz.chenzhe20180108.view.XiangQingView;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements XiangQingView, AddView {

    XiangQingPersenter persenter = new XiangQingPersenter(this);
    AddPersenter addpersenter = new AddPersenter(this);
    @BindView(R.id.simple)
    SimpleDraweeView simple;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.sub)
    TextView sub;
    @BindView(R.id.youhui)
    TextView youhui;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.gowuche)
    Button gowuche;
    @BindView(R.id.addgowuche)
    Button addgowuche;

    List<XiangQingBean.DataBean> list = new ArrayList<XiangQingBean.DataBean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        persenter.getData("71", "android");
    }

    @Override
    public void success(XiangQingBean bean) {
        list.add(bean.getData());
        Toast.makeText(MainActivity.this, bean.getData().getTitle() + "", Toast.LENGTH_SHORT).show();
        String[] split = bean.getData().getImages().split("\\|");
        simple.setImageURI(Uri.parse(split[0]));
        title.setText(bean.getData().getTitle());
        sub.setText(bean.getData().getSubhead());
        youhui.setText("￥:" + bean.getData().getBargainPrice());
        price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        price.setText("￥:" + bean.getData().getPrice());
    }

    @Override
    public void success(AddBean bean) {
        Toast.makeText(MainActivity.this, bean.getMsg()+"", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failuer(String e) {
        Toast.makeText(MainActivity.this, "错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        persenter.sdsd();
    }

    @OnClick({R.id.gowuche, R.id.addgowuche})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.gowuche:
                Intent intent = new Intent(MainActivity.this, GoWuCheActivity.class);
                startActivity(intent);
                break;
            case R.id.addgowuche:
                addpersenter.getData("101", list.get(0).getPid() + "", "android");
                break;
        }
    }
}
