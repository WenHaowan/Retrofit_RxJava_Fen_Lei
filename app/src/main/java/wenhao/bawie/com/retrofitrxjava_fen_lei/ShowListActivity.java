package wenhao.bawie.com.retrofitrxjava_fen_lei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import wenhao.bawie.com.retrofitrxjava_fen_lei.adapter.ShowListAdapter;
import wenhao.bawie.com.retrofitrxjava_fen_lei.bean.ShowBean;
import wenhao.bawie.com.retrofitrxjava_fen_lei.mvp.presenter.ShowPresenter;
import wenhao.bawie.com.retrofitrxjava_fen_lei.mvp.view.ShowListView;

public class ShowListActivity extends AppCompatActivity implements ShowListView{

    private RecyclerView shou_recy_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);
        shou_recy_view = (RecyclerView) findViewById(R.id.shou_recy_view);
        //设置布局
        shou_recy_view.setLayoutManager(new LinearLayoutManager(ShowListActivity.this,LinearLayoutManager.VERTICAL,false));
        //获取传过来的值
        Intent intent = getIntent();
        String pscid = intent.getStringExtra("pscid");
        //获取p层
        ShowPresenter showPresenter = new ShowPresenter(this);
        showPresenter.getShowList(pscid);
    }

    @Override
    public void ShowSuccess(List<ShowBean.DataBean> data) {
        ShowListAdapter showListAdapter = new ShowListAdapter(ShowListActivity.this, data);
        shou_recy_view.setAdapter(showListAdapter);
    }
}
