package b.com.weichunhao20190506.net;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface HttpService {

      @GET
      Observable<ResponseBody> get(@Url String  url, @HeaderMap Map<String,String> headMap);


//        @GET
//        Call<ResponseBody> get(@Url String url, @QueryMap Map<String,String>map);

}
