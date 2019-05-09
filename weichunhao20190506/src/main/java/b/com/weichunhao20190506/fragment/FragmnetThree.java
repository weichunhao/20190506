package b.com.weichunhao20190506.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import b.com.weichunhao20190506.R;
import b.com.weichunhao20190506.adapter.NewAdapter;
import b.com.weichunhao20190506.bean.NewBean;
import b.com.weichunhao20190506.mvp.model.MainModelmI;
import b.com.weichunhao20190506.mvp.presenter.MainPresenterImI;
import b.com.weichunhao20190506.mvp.view.MainView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FragmnetThree extends Fragment {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmnetthree, container, false);
        return view;
    }


}
