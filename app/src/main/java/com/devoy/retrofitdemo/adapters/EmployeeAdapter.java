package com.devoy.retrofitdemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devoy.retrofitdemo.R;
import com.devoy.retrofitdemo.models.EmployeeItem;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {
    private List<EmployeeItem> employeeItemList;
    private Context context;

    public EmployeeAdapter(List<EmployeeItem> employeeItemList, Context context) {
        this.employeeItemList = employeeItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.employee_item, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        EmployeeItem employeeItem = employeeItemList.get(position);
        holder.employeeName.setText(employeeItem.getEmployeeName());

    }

    @Override
    public int getItemCount() {
        return employeeItemList.size();
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder {
        TextView employeeName;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            employeeName = itemView.findViewById(R.id.employee_name);
        }
    }
}
