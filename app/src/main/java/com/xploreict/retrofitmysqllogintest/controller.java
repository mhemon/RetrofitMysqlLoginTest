package com.xploreict.retrofitmysqllogintest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class controller {
    private static final String url="https://android.gadgetlab.store/";
    private static controller clienobject;
    private static Retrofit retrofit;

    controller()
    {
        retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized controller getInstance()
    {
        if(clienobject==null)
            clienobject=new controller();
        return  clienobject;
    }

    apiset getapi()
    {
        return retrofit.create(apiset.class);
    }
}
