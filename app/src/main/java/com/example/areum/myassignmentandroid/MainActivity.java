package com.example.areum.myassignmentandroid;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    private ArrayList<Employee> arrEmployee = null;
    private Employee currentEmployee = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        arrEmployee = new ArrayList<Employee>();


        EditText textAge = (EditText) findViewById(R.id.txtAge);
        EditText textSalary = (EditText) findViewById(R.id.txtSalary);
        EditText textBonus = (EditText) findViewById(R.id.txtBonus);
        EditText textHours = (EditText) findViewById(R.id.txtHours);
        EditText textRate = (EditText) findViewById(R.id.txtRate);
        EditText textSchoolName = (EditText) findViewById(R.id.txtSchoolName);

        // Enable EditText before selecting employee type.
        textAge.setEnabled(false);
        textSalary.setEnabled(false);
        textBonus.setEnabled(false);
        textHours.setEnabled(false);
        textRate.setEnabled(false);
        textSchoolName.setEnabled(false);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Sorry, We don't have mail address", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        // country _ use spinner
        Spinner spinner = (Spinner) findViewById(R.id.txtCountry);
        ArrayAdapter<CharSequence> countryAdapter = ArrayAdapter.createFromResource(this, R.array.country_list, android.R.layout.simple_spinner_item);
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(countryAdapter);

    }


    // Select your employee button
    public void DialogSelectOption(View view){
        final String items [] = {"Full Time", "Part Time", "Intern"};
        AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
        ab.setTitle("Select Your Employee Type");

        ab.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int whichButton) {
                // When select each list..
                EditText textSalary = (EditText) findViewById(R.id.txtSalary);
                EditText textBonus = (EditText) findViewById(R.id.txtBonus);
                EditText textHours = (EditText) findViewById(R.id.txtHours);
                EditText textRate = (EditText) findViewById(R.id.txtRate);
                EditText textSchoolName = (EditText) findViewById(R.id.txtSchoolName);

                switch (whichButton){
                    case 0: // full time
                        textSalary.setEnabled(true);
                        textBonus.setEnabled(true);
                        textHours.setEnabled(false);
                        textRate.setEnabled(false);
                        textSchoolName.setEnabled(false);
                        break;
                    case 1:  // part time
                        textSalary.setEnabled(false);
                        textBonus.setEnabled(false);
                        textHours.setEnabled(true);
                        textRate.setEnabled(true);
                        textSchoolName.setEnabled(false);
                        break;
                    case 2:  // intern
                        textSalary.setEnabled(false);
                        textBonus.setEnabled(false);
                        textHours.setEnabled(false);
                        textRate.setEnabled(false);
                        textSchoolName.setEnabled(true);
                        break;
                    default:
                        textSalary.setEnabled(true);
                        textBonus.setEnabled(true);
                        textHours.setEnabled(false);
                        textRate.setEnabled(false);
                        textSchoolName.setEnabled(false);
                        break;
                }

            }
        }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int whichButton) {

            }
        });

        ab.show();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    // employee add button
    public void btnAddControl(View view) {

        EditText textName = (EditText) findViewById(R.id.txtName);
        EditText textAge = (EditText) findViewById(R.id.txtAge);
        Spinner textCountry = (Spinner) findViewById(R.id.txtCountry);
        EditText textSalary = (EditText) findViewById(R.id.txtSalary);
        EditText textBonus = (EditText) findViewById(R.id.txtBonus);
        EditText textHours = (EditText) findViewById(R.id.txtHours);
        EditText textRate = (EditText) findViewById(R.id.txtRate);
        EditText textSchoolName = (EditText) findViewById(R.id.txtSchoolName);
        EditText textMake = (EditText) findViewById(R.id.txtMake);
        EditText textPlate = (EditText) findViewById(R.id.txtPlate);


        String searchByName = textName.getText().toString();
        boolean employExist = false;

        // Check if the name is exist or not
        for (int i = 0; i<arrEmployee.size(); i++) {
            if (arrEmployee.get(i).getName().equals(searchByName)) {
                employExist = true;
            }
        }

        if (employExist != false) {
            // if there is same name
            Toast.makeText(this, searchByName + "is already existed!", Toast.LENGTH_SHORT).show();
            employExist = false;

        } else {

            if((textSalary.getText().toString().isEmpty()) && (textBonus.getText().toString().isEmpty()) && (textHours.getText().toString().isEmpty()) && (textRate.getText().toString().isEmpty()) && ((textSchoolName.getText().toString().isEmpty()))){
                Toast.makeText(this, "Please, Select your employee type!", Toast.LENGTH_SHORT).show();
            } else if (!(textSalary.getText().toString().isEmpty()) && (!(textBonus.getText().toString().isEmpty()))) {
                // FullTime
                FullTime ft = new FullTime();
                ft.setName(textName.getText().toString());
                ft.setAge(textAge.getText().toString());
                ft.setContry(textCountry.getSelectedItem().toString());
                ft.setSalary(Integer.parseInt(textSalary.getText().toString()));
                ft.setBonus(Integer.parseInt(textBonus.getText().toString()));

                if (!(textMake.getText().toString().isEmpty()) && (!(textPlate.getText().toString().isEmpty()))){
                    ft.v.make = textMake.getText().toString();
                    ft.v.plate = textPlate.getText().toString();
                }

                arrEmployee.add(ft);
                currentEmployee = ft;

                Toast.makeText(this, "Full Time Employee added!", Toast.LENGTH_SHORT).show();
                FieldClear();

            } else if (!(textRate.getText().toString().isEmpty()) && (!(textHours.getText().toString().isEmpty()))) {
                // PartTime
                PartTime pt = new PartTime();
                pt.setName(textName.getText().toString());
                pt.setAge(textAge.getText().toString());
                pt.setContry(textCountry.getSelectedItem().toString());
                pt.setRate(Integer.parseInt(textRate.getText().toString()));
                pt.setHoursWorked(Integer.parseInt(textHours.getText().toString()));

                if (!(textMake.getText().toString().isEmpty()) && (!(textPlate.getText().toString().isEmpty()))){
                    pt.v.make = textMake.getText().toString();
                    pt.v.plate = textPlate.getText().toString();
                }

                arrEmployee.add(pt);
                currentEmployee = pt;

                Toast.makeText(this, "Part Time Employee added!", Toast.LENGTH_SHORT).show();
                FieldClear();

            } else if (!(textSchoolName.toString().isEmpty())) {
                // Intern
                Intern it = new Intern();
                it.setName(textName.getText().toString());
                it.setAge(textAge.getText().toString());
                it.setContry(textCountry.getSelectedItem().toString());
                it.setSchoolName(textSchoolName.getText().toString());

                if (!(textMake.getText().toString().isEmpty()) && (!(textPlate.getText().toString().isEmpty()))){
                    it.v.make = textMake.getText().toString();
                    it.v.plate = textPlate.getText().toString();
                }

                arrEmployee.add(it);
                currentEmployee = it;

                Toast.makeText(this, "Intern added!", Toast.LENGTH_SHORT).show();
                FieldClear();
            }

        }

    }


    // choose birthday button
    public void btnChooseBirth(View view){

        Calendar c = Calendar.getInstance();
        int cyear = c.get(Calendar.YEAR);
        int cmonth = c.get(Calendar.MONTH);
        int cday = c.get(Calendar.DAY_OF_WEEK_IN_MONTH);

        DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                String date_selected = String.valueOf(monthOfYear+1) + " /" + String.valueOf(dayOfMonth) + " /" +String.valueOf(year);

                EditText textAge = (EditText) findViewById(R.id.txtAge);

                textAge.setEnabled(true);
                textAge.setText(date_selected);

            }
        };
        DatePickerDialog datePicker = new DatePickerDialog(this, mDateSetListener, cyear, cmonth, cday);
        datePicker.show();


    }


    // Search button
    public void btnSearchControl (View view) {

        EditText textName = (EditText) findViewById(R.id.txtName);
        String searchByName = textName.getText().toString();
        boolean employExist = false;

        for (int i = 0; i<arrEmployee.size(); i++) {
            if (arrEmployee.get(i).getName().equals(searchByName) ) {
                currentEmployee = arrEmployee.get(i);
                display(currentEmployee);
                employExist = true;
            }
        }

        if (employExist != true) {
            Toast.makeText(this, "Not found!", Toast.LENGTH_LONG).show();
        } else {
            //  employExist = false;
        }

    }

    // When push the Detail button, Search the name and then show that detail
    public void btnSearchSelectName (String selectName) {

        for (int i = 0; i<arrEmployee.size(); i++) {
            if (arrEmployee.get(i).getName().equals(selectName) ) {
                currentEmployee = arrEmployee.get(i);
                display(currentEmployee);
            }
        }


    }


    // Clear button
    public void btnClearControl (View view) {

       FieldClear();

    }


    // update button
    public void btnUpdateControl (View view){

        EditText textName = (EditText) findViewById(R.id.txtName);
        EditText textAge = (EditText) findViewById(R.id.txtAge);
        Spinner textCountry = (Spinner) findViewById(R.id.txtCountry);
        EditText textSalary = (EditText) findViewById(R.id.txtSalary);
        EditText textBonus = (EditText) findViewById(R.id.txtBonus);
        EditText textHours = (EditText) findViewById(R.id.txtHours);
        EditText textRate = (EditText) findViewById(R.id.txtRate);
        EditText textSchoolName = (EditText) findViewById(R.id.txtSchoolName);
        EditText textMake = (EditText) findViewById(R.id.txtMake);
        EditText textPlate = (EditText) findViewById(R.id.txtPlate);


        if (currentEmployee instanceof FullTime){
            FullTime ft = (FullTime) currentEmployee;

            ft.setName(textName.getText().toString());
            ft.setAge(textAge.getText().toString());
            ft.setContry(textCountry.getSelectedItem().toString());
            ft.setSalary(Integer.parseInt(textSalary.getText().toString()));
            ft.setBonus(Integer.parseInt(textBonus.getText().toString()));
            ft.v.make = textMake.getText().toString();
            ft.v.plate = textPlate.getText().toString();

            Toast.makeText(this, ft.getName() + " UPDATED!", Toast.LENGTH_LONG).show();
            FieldClear();
        }

        if (currentEmployee instanceof PartTime) {
            PartTime pt = (PartTime) currentEmployee;
            pt.setName(textName.getText().toString());
            pt.setAge(textAge.getText().toString());
            pt.setContry(textCountry.getSelectedItem().toString());
            pt.setRate(Integer.parseInt(textRate.getText().toString()));
            pt.setHoursWorked(Integer.parseInt(textHours.getText().toString()));
            pt.v.make = textMake.getText().toString();
            pt.v.plate = textPlate.getText().toString();

            Toast.makeText(this, pt.getName() + " UPDATED!", Toast.LENGTH_LONG).show();
            FieldClear();
        }

        if (currentEmployee instanceof Intern) {
            Intern it = (Intern) currentEmployee;
            it.setName(textName.getText().toString());
            it.setAge(textAge.getText().toString());
            it.setContry(textCountry.getSelectedItem().toString());
            it.setSchoolName(textSchoolName.getText().toString());
            it.v.make = textMake.getText().toString();
            it.v.plate = textPlate.getText().toString();

            Toast.makeText(this, it.getName() + " UPDATED!", Toast.LENGTH_LONG).show();
            FieldClear();
        }


    }

    // button calculate
    public void btnCalculate (View view){

        EditText textName = (EditText) findViewById(R.id.txtName);
        String empoyeeCalName = textName.getText().toString();

        TextView tv = (TextView) findViewById(R.id.tvMainView);

        for (int i = 0; i<arrEmployee.size(); i++) {
            if (arrEmployee.get(i).getName().equals(empoyeeCalName) ) {
                currentEmployee = arrEmployee.get(i);
            }
        }

        if (currentEmployee instanceof FullTime) {
            FullTime ft = (FullTime) currentEmployee;
            tv.setText(Integer.toString(ft.calcEarnings()));
        }

        if (currentEmployee instanceof PartTime) {
            PartTime ft = (PartTime) currentEmployee;
            tv.setText(Integer.toString(ft.calcEarnings()));

        }

        if (currentEmployee instanceof Intern) {
            tv.setText("Intern doesn't have result.");

        }


    }

    // Age calculate
    public void btnAgeCalculate (View view) {

        EditText textName = (EditText) findViewById(R.id.txtName);
        String empoyeeCalName = textName.getText().toString();

        TextView tv = (TextView) findViewById(R.id.tvMainView);

        String ageData = "";

        for (int i = 0; i<arrEmployee.size(); i++) {
            if (arrEmployee.get(i).getName().equals(empoyeeCalName) ) {
                currentEmployee = arrEmployee.get(i);
                ageData = arrEmployee.get(i).getAge().toString();
            }
        }

        // string[0] = month, [1] = day, [2] = year
        String[] ageDataArr = ageData.split("/");

        Employee ft = currentEmployee;
        tv.setText(Integer.toString(ft.calcBirthYear(Integer.parseInt(ageDataArr[2]))) + " Years old");

    }


    // Show the list, when push the button
    public void btnShowListControl (View view) {

        FieldClear();

        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        EmployeeDataProvider.arrEmployee = arrEmployee;
        startActivityForResult(intent, 1);

    }

    // for activity 2 -> activity 1, pass the value
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == 2) {
                String empName = data.getStringExtra("EmployeeName");
                btnSearchSelectName(empName);
            }
        }

    }

    // Field Clear
    public void FieldClear(){

        EditText textName = (EditText) findViewById(R.id.txtName);
        EditText textAge = (EditText) findViewById(R.id.txtAge);
        EditText textSalary = (EditText) findViewById(R.id.txtSalary);
        EditText textBonus = (EditText) findViewById(R.id.txtBonus);
        EditText textHours = (EditText) findViewById(R.id.txtHours);
        EditText textRate = (EditText) findViewById(R.id.txtRate);
        EditText textSchoolName = (EditText) findViewById(R.id.txtSchoolName);
        EditText textMake = (EditText) findViewById(R.id.txtMake);
        EditText textPlate = (EditText) findViewById(R.id.txtPlate);
        TextView tv = (TextView) findViewById((R.id.tvMainView));

        textName.setText("");
        textAge.setText("");
        textSalary.setText("");
        textBonus.setText("");
        textHours.setText("");
        textRate.setText("");
        textSchoolName.setText("");
        textMake.setText("");
        textPlate.setText("");
        tv.setText("");

        textAge.setEnabled(false);
        textSalary.setEnabled(false);
        textBonus.setEnabled(false);
        textHours.setEnabled(false);
        textRate.setEnabled(false);
        textSchoolName.setEnabled(false);

        Spinner sp = (Spinner) findViewById(R.id.txtCountry);
        sp.setSelection(0);
    }


    // when we push search button, show the detail
    public void display(Employee currentEmployee) {

        if (currentEmployee instanceof FullTime) {
            FullTime ft = (FullTime) currentEmployee;

            EditText textName = (EditText) findViewById(R.id.txtName);
            EditText textAge = (EditText) findViewById(R.id.txtAge);
            Spinner textCountry = (Spinner) findViewById(R.id.txtCountry);
            EditText textSalary = (EditText) findViewById(R.id.txtSalary);
            EditText textBonus = (EditText) findViewById(R.id.txtBonus);
            EditText textMake = (EditText) findViewById(R.id.txtMake);
            EditText textPlate = (EditText) findViewById(R.id.txtPlate);

            textSalary.setEnabled(true);
            textBonus.setEnabled(true);

            textName.setText(ft.getName());
            textAge.setText(ft.getAge());
            textCountry.setSelection(spinnerShow(ft.getContry()));
            textSalary.setText(Integer.toString(ft.getSalary()));
            textBonus.setText(Integer.toString(ft.getBonus()));
            textMake.setText(currentEmployee.v.make);
            textPlate.setText(currentEmployee.v.plate);

        }

        if (currentEmployee instanceof PartTime) {
            PartTime ft = (PartTime) currentEmployee;

            EditText textName = (EditText) findViewById(R.id.txtName);
            EditText textAge = (EditText) findViewById(R.id.txtAge);
            Spinner textCountry = (Spinner) findViewById(R.id.txtCountry);
            EditText textHours = (EditText) findViewById(R.id.txtHours);
            EditText textRate = (EditText) findViewById(R.id.txtRate);
            EditText textMake = (EditText) findViewById(R.id.txtMake);
            EditText textPlate = (EditText) findViewById(R.id.txtPlate);

            textHours.setEnabled(true);
            textRate.setEnabled(true);

            textName.setText(ft.getName());
            textAge.setText(ft.getAge());
            textCountry.setSelection(spinnerShow(ft.getContry()));
            textHours.setText(Integer.toString(ft.getHoursWorked()));
            textRate.setText(Integer.toString(ft.getRate()));
            textMake.setText(currentEmployee.v.make);
            textPlate.setText(currentEmployee.v.plate);

        }

        if (currentEmployee instanceof Intern) {

            Intern ft = (Intern) currentEmployee;

            EditText textName = (EditText) findViewById(R.id.txtName);
            EditText textAge = (EditText) findViewById(R.id.txtAge);
            Spinner textCountry = (Spinner) findViewById(R.id.txtCountry);
            EditText textSchoolName = (EditText) findViewById(R.id.txtSchoolName);
            EditText textMake = (EditText) findViewById(R.id.txtMake);
            EditText textPlate = (EditText) findViewById(R.id.txtPlate);

            textSchoolName.setEnabled(true);

            textName.setText(ft.getName());
            textAge.setText(ft.getAge());
            textCountry.setSelection(spinnerShow(ft.getContry()));
            textSchoolName.setText(ft.getSchoolName());
            textMake.setText(currentEmployee.v.make);
            textPlate.setText(currentEmployee.v.plate);

        }


    }

    // Spinner control
    public int spinnerShow(String countryNameValue) {

        String[] countryCount = getResources().getStringArray(R.array.country_list);
        int conuntryNumber = 0;

        for (int i = 0; i < countryCount.length; i++) {
            if (countryCount[i].equals(countryNameValue)) {
                conuntryNumber = i;
            }
        }

        return conuntryNumber;

    }




}
