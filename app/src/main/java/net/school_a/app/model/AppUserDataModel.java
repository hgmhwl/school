package net.school_a.app.model;

import net.school_a.app.http.RetrofitHttp;

import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Callback;

/**
 * Created by mac on 2017/3/26.
 * 用户相关
 */

public class AppUserDataModel {
    // 登录
    public static void userLogin(Callback<ResponseBody> callback, Map<String, String> data) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        RetrofitHttp.getRetrofit(builder.build()).userLogin("login", data)
                .enqueue(callback);
    }
}
