package wenhao.bawie.com.retrofitrxjava_fen_lei;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import wenhao.bawie.com.retrofitrxjava_fen_lei.adapter.LeftAdapter;
import wenhao.bawie.com.retrofitrxjava_fen_lei.adapter.RightAdapter;
import wenhao.bawie.com.retrofitrxjava_fen_lei.bean.LeftBean;
import wenhao.bawie.com.retrofitrxjava_fen_lei.bean.RightBean;
import wenhao.bawie.com.retrofitrxjava_fen_lei.mvp.presenter.LeftPresenter;
import wenhao.bawie.com.retrofitrxjava_fen_lei.mvp.presenter.RightPresenter;
import wenhao.bawie.com.retrofitrxjava_fen_lei.mvp.view.ShowView;

public class MainActivity extends AppCompatActivity implements ShowView {

    private RecyclerView left_recy_view;
    private RecyclerView right_recy_view;
    private RightPresenter rightPresenter;
    private LeftAdapter leftAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        left_recy_view = (RecyclerView) findViewById(R.id.left_recy_view);
        right_recy_view = (RecyclerView) findViewById(R.id.right_recy_view);
        //右侧布局
        right_recy_view.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
        rightPresenter = new RightPresenter(this);
        rightPresenter.getRight("1");
        //左侧布局
        left_recy_view.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
        LeftPresenter leftPresenter = new LeftPresenter(this);
        leftPresenter.getLeft();
    }
    //左侧列表展示
    @Override
    public void success(List<LeftBean.DataBean> data) {
        leftAdapter = new LeftAdapter(MainActivity.this,data);
        left_recy_view.setAdapter(leftAdapter);
        //获取传过来的值
        leftAdapter.SuccessListener(new LeftAdapter.ShowListener() {
            @Override
            public void ShowCid(String cid) {
                rightPresenter.getRight(cid);
            }
        });
    }
    //右侧列表展示
    @Override
    public void rightsuccess(List<RightBean.DataBean> data) {
        RightAdapter rightAdapter = new RightAdapter(MainActivity.this, data);
        right_recy_view.setAdapter(rightAdapter);
    }
}
