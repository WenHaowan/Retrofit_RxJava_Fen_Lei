package wenhao.bawie.com.retrofitrxjava_fen_lei.mvp.model;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import wenhao.bawie.com.retrofitrxjava_fen_lei.bean.LeftBean;
import wenhao.bawie.com.retrofitrxjava_fen_lei.bean.RightBean;
import wenhao.bawie.com.retrofitrxjava_fen_lei.bean.ShowBean;

/**
 * Created by HP on 2018/11/10.
 */

public interface Api {
    @GET("product/getCatagory")//左侧接口
    Observable<LeftBean> getLeft();
    @GET("product/getProductCatagory")//右侧接口
    Observable<RightBean> getRight(@Query("cid") String cid);
    @GET("product/getProducts")//右侧接口下的商品展示列表
    Observable<ShowBean> getShow(@Query("pscid") String pscid);
}
