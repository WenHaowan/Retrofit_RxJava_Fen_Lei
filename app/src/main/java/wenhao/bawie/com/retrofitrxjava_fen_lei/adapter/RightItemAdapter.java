package wenhao.bawie.com.retrofitrxjava_fen_lei.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import wenhao.bawie.com.retrofitrxjava_fen_lei.R;
import wenhao.bawie.com.retrofitrxjava_fen_lei.ShowListActivity;
import wenhao.bawie.com.retrofitrxjava_fen_lei.bean.RightBean;

/**
 * Created by HP on 2018/11/10.
 */

public class RightItemAdapter extends RecyclerView.Adapter<RightItemAdapter.ItemViewHolder>{
    private Context context;
    private List<RightBean.DataBean.ListBean> list;

    public RightItemAdapter(Context context, List<RightBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RightItemAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.right_item_adapter_layout, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(inflate);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(RightItemAdapter.ItemViewHolder holder, final int position) {
        holder.right_title.setText(list.get(position).getName());
        Glide.with(context).load(list.get(position).getIcon()).into(holder.right_image);
        holder.right_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShowListActivity.class);
                intent.putExtra("pscid",list.get(position).getPscid()+"");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView right_title;
        private ImageView right_image;

        public ItemViewHolder(View itemView) {
            super(itemView);
            right_image = (ImageView) itemView.findViewById(R.id.right_image);
            right_title = (TextView) itemView.findViewById(R.id.right_title);
        }
    }
}
