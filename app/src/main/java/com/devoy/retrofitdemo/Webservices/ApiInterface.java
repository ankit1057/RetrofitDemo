package com.devoy.retrofitdemo.Webservices;



import com.devoy.retrofitdemo.models.EmployeeItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("employees")
    Call<List<EmployeeItem>> getEmployees();

}
