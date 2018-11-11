package wenhao.bawie.com.retrofitrxjava_fen_lei.mvp.view;

import java.util.List;

import wenhao.bawie.com.retrofitrxjava_fen_lei.bean.LeftBean;
import wenhao.bawie.com.retrofitrxjava_fen_lei.bean.RightBean;
import wenhao.bawie.com.retrofitrxjava_fen_lei.bean.ShowBean;

/**
 * Created by HP on 2018/11/10.
 */

public interface ShowView {
    void success(List<LeftBean.DataBean> data);

    void rightsuccess(List<RightBean.DataBean> data);

}
