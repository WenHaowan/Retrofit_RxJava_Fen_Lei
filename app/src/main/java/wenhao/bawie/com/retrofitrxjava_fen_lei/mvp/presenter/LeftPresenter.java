package wenhao.bawie.com.retrofitrxjava_fen_lei.mvp.presenter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import wenhao.bawie.com.retrofitrxjava_fen_lei.bean.LeftBean;
import wenhao.bawie.com.retrofitrxjava_fen_lei.mvp.model.HttpUtils;
import wenhao.bawie.com.retrofitrxjava_fen_lei.mvp.view.ShowView;

/**
 * Created by HP on 2018/11/10.
 */

public class LeftPresenter implements IPresenter{
    private ShowView showView;

    public LeftPresenter(ShowView showView) {
        this.showView = showView;
    }

    public void getLeft(){
        Observable<LeftBean> left = HttpUtils.getUtilsInstance().api.getLeft();
        left.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<LeftBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull LeftBean leftBean) {
                        showView.success(leftBean.getData());
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
        if (showView!=null){
            showView=null;
        }
    }
}
