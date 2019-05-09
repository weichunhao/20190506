package b.com.weichunhao20190506.net;

import android.os.Environment;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class HttpUtils {

       private String baseUrl="http://172.17.8.100";

       public  HttpUtils get(String url, Map<String,String> headMap){
           File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
           Cache cache = new Cache(file,10*1024);

           OkHttpClient okHttpClient = new OkHttpClient.Builder()
                   .addInterceptor(new Interceptor() {
                       @Override
                       public Response intercept(Chain chain) throws IOException {
                           Request request = chain.request();
                           return chain.proceed(request);
                       }
                   })
                   .cache(cache)
                   .build();

           Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                   .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                   .client(okHttpClient)
                   .build();

            HttpService service = retrofit.create(HttpService.class);
             service.get(url,headMap)
                  .subscribeOn(Schedulers.io())
                  .observeOn(AndroidSchedulers.mainThread())
                  .subscribe(new Observer<ResponseBody>() {
                      @Override
                      public void onSubscribe(Disposable d) {

                      }

                      @Override
                      public void onNext(ResponseBody responseBody) {
                          try {
                              listener.success(responseBody.string());
                          } catch (IOException e) {
                              e.printStackTrace();
                          }
                      }

                      @Override
                      public void onError(Throwable e) {
                       listener.fail(e.getMessage());
                      }

                      @Override
                      public void onComplete() {

                      }
                  }) ;
           return this;
       }

       private HttpListener listener;

       public void result(HttpListener listener){
           this.listener=listener;
       }
}
