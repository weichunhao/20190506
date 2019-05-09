package b.com.weichunhao20190506.mvp.model;

import java.util.Map;

public interface MainModel {

         interface CallBackListener{

                void  success(String data);

                void fail(String error);
         }

        void  doData(String url, Map<String,String> headMap,CallBackListener listener);
}
