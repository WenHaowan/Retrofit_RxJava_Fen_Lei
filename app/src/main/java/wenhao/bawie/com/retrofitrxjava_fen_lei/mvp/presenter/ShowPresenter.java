package wenhao.bawie.com.retrofitrxjava_fen_lei.mvp.presenter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import wenhao.bawie.com.retrofitrxjava_fen_lei.bean.ShowBean;
import wenhao.bawie.com.retrofitrxjava_fen_lei.mvp.model.HttpUtils;
import wenhao.bawie.com.retrofitrxjava_fen_lei.mvp.view.ShowListView;
import wenhao.bawie.com.retrofitrxjava_fen_lei.mvp.view.ShowView;

/**
 * Created by HP on 2018/11/10.
 */

public class ShowPresenter implements IPresenter{

    private ShowListView showListView;

    public ShowPresenter(ShowListView showListView) {
        this.showListView = showListView;
    }

    public void getShowList(String pscid){
        Observable<ShowBean> show = HttpUtils.getUtilsInstance().api.getShow(pscid);
        show.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ShowBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ShowBean showBean) {
                        showListView.ShowSuccess(showBean.getData());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onDestroy() {
        if (showListView!=null){
            showListView=null;
        }
    }
}
