package com.example.areum.myassignmentandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by areum on 2016-12-10.
 */

public class EmployeeListAdapter extends ArrayAdapter<Employee> {

    private List<Employee> employeeslist;
    Context context;

    public EmployeeListAdapter(Context context, int resource, ArrayList<Employee> employees){
        super(context, resource, employees);
        this.employeeslist = employees;
        this.context = context;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        // Show employee_list_detail
        if (convertView == null ) {
            convertView = LayoutInflater.from (getContext()).inflate (R.layout.employee_list_detail, parent, false);
        }

        // Show Employee data in Employee list
        final Employee employee = getItem(position);

        TextView nameText = (TextView) convertView.findViewById(R.id.txtNameList);
        nameText.setText(employee.getName());

        TextView ageText = (TextView) convertView.findViewById(R.id.txtAgeList);
        ageText.setText(employee.getAge());

        TextView countryText = (TextView) convertView.findViewById(R.id.txtCountryList);
        countryText.setText(employee.getContry());


        // Show detail information that I choose
        Button BtnDetailConnect= (Button)  convertView  .findViewById(R.id.btnShowDetail);

        BtnDetailConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Main2Activity) getContext()).godetail(employee.getName());

            }
        });

        return convertView;
    }



}
