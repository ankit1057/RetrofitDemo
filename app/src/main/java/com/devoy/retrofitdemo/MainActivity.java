package com.devoy.retrofitdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.devoy.retrofitdemo.Webservices.ApiInterface;
import com.devoy.retrofitdemo.Webservices.ServiceGenerator;
import com.devoy.retrofitdemo.adapters.EmployeeAdapter;
import com.devoy.retrofitdemo.models.EmployeeItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    EmployeeAdapter employeeAdapter;
    List<EmployeeItem> employeeItemList;
    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        employeeItemList = new ArrayList<>();
        employeeAdapter = new EmployeeAdapter(employeeItemList, MainActivity.this);
        recyclerView.setAdapter(employeeAdapter);

        loadEmployeeData();
    }

    private void loadEmployeeData() {
        ApiInterface apiInterface = ServiceGenerator.createService(ApiInterface.class);
        Call<List<EmployeeItem>> call = apiInterface.getEmployees();

        call.enqueue(new Callback<List<EmployeeItem>>() {
            @Override
            public void onResponse(Call<List<EmployeeItem>> call, Response<List<EmployeeItem>> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + response.toString());
                    assert response.body() != null;
                    employeeItemList.addAll(response.body());
                    employeeAdapter.notifyDataSetChanged();
                }
                else{
                    Log.d(TAG, "onResponse: "+response.message());
                }
            }

            @Override
            public void onFailure(Call<List<EmployeeItem>> call, Throwable t) {

            }
        });
    }
}
