package b.com.weichunhao20190506.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

import b.com.weichunhao20190506.R;
import b.com.weichunhao20190506.adapter.NewAdapter;
import b.com.weichunhao20190506.bean.NewBean;
import b.com.weichunhao20190506.mvp.model.MainModelmI;
import b.com.weichunhao20190506.mvp.presenter.MainPresenterImI;
import b.com.weichunhao20190506.mvp.view.MainView;

public class FragmnetOne extends Fragment implements MainView {
private RecyclerView recyclerView;
private NewAdapter newAdapter;
private MainPresenterImI mainPresenterImI;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmnetone, container, false);
          recyclerView=(RecyclerView)view.findViewById(R.id.recycler1);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

             newAdapter = new NewAdapter(getActivity());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
         linearLayoutManager.setOrientation(LinearLayout.VERTICAL);
          recyclerView.setLayoutManager(linearLayoutManager);
          recyclerView.setAdapter(newAdapter);
           mainPresenterImI = new MainPresenterImI(new MainModelmI(),this);
         Map<String,String>headMap=new HashMap<>();
          headMap.put("userid","298");
         headMap.put("sessionid","1557126908616298");
          mainPresenterImI.doData("/small/order/verify/v1/findOrderListByStatus?stryus=0&page1&count=5",headMap);
    }

    @Override
    public void success(String data) {
        NewBean bean = new Gson().fromJson(data, NewBean.class);

          newAdapter.setList(bean.getResult());

    }

    @Override
    public void fail(String error) {
            mainPresenterImI.fail(error);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

         mainPresenterImI.destory();
    }
}
