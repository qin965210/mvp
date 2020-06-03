package com.example.wangluorera;



import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

public interface GetRequest_Interface {
    //键值对
    @FormUrlEncoded
    @POST("/txapi/baiketiku/index")
    //key=8ec324bf03d34f7706fb4c35a4355d7e
    Observable<Receptionbean> getcall(@Field("key") String key);
}
