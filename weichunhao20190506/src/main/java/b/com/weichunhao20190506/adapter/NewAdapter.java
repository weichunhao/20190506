package b.com.weichunhao20190506.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import b.com.weichunhao20190506.R;
import b.com.weichunhao20190506.bean.NewBean;

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.NewViewHolder> {

    private Context context;

        private List<NewBean.ResultBean>list = new ArrayList<>();
        public NewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public NewAdapter.NewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = View.inflate(context, R.layout.show,null);
              NewViewHolder newViewHolder = new NewViewHolder(view);

        return newViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewAdapter.NewViewHolder newViewHolder, int i) {
                    newViewHolder.simpleDraweeView.setImageURI(list.get(i).getPic());
                    newViewHolder.textView_title.setText(list.get(i).getCommodityName());
                    newViewHolder.textView_price.setText(list.get(i).getPrice()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<NewBean.ResultBean> list) {
         this.list=list;
         notifyDataSetChanged();
    }

    public class NewViewHolder extends RecyclerView.ViewHolder {

              SimpleDraweeView simpleDraweeView;
              TextView textView_title;
              TextView textView_price;

        public NewViewHolder(@NonNull View itemView) {
            super(itemView);

             simpleDraweeView=(SimpleDraweeView)itemView.findViewById(R.id.simple);
            textView_title=(TextView)itemView.findViewById(R.id.tv_title);
            textView_price=(TextView)itemView.findViewById(R.id.tv_price);
        }
    }
}
