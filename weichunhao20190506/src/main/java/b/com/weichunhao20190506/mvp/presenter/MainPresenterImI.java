package b.com.weichunhao20190506.mvp.presenter;

import java.util.Map;

import b.com.weichunhao20190506.mvp.model.MainModel;
import b.com.weichunhao20190506.mvp.view.MainView;

public class MainPresenterImI implements MainPresenter, MainModel.CallBackListener {

      private MainModel mainModel;
      private MainView mainView;

    public MainPresenterImI(MainModel mainModel, MainView mainView) {
        this.mainModel = mainModel;
        this.mainView = mainView;
    }

    @Override
    public void doData(String url, Map<String,String> headMap) {
        mainModel.doData(url,headMap,this);
    }

    @Override
    public void success(String data) {
           mainView.success(data);
    }

    @Override
    public void fail(String error) {
            mainView.fail(error);
    }

    public void destory(){

           if (mainModel!=null){
               mainModel=null;
           }if (mainModel!=null){
               mainModel=null;
        }
        System.gc();
    }
}
