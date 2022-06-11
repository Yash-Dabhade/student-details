package com.example.studentdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText rollno,name,branch,marks,percentage,search;
    Button insertBtn,searchBtn;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //targeting ui components
        rollno=findViewById(R.id.rollno);
        name=findViewById(R.id.name);
        branch=findViewById(R.id.branch);
        marks=findViewById(R.id.marks);
        percentage=findViewById(R.id.percentage);
        search=findViewById(R.id.search);

        insertBtn=findViewById(R.id.insertButton);
        searchBtn=findViewById(R.id.searchButton);

        result=findViewById(R.id.result);

        //database object
        dbHelper db=new dbHelper(getApplicationContext());

        //insert data

        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rollNoVal=rollno.getText().toString();
                String nameVal=name.getText().toString();
                String branchVal=branch.getText().toString();
                String marksVal=marks.getText().toString();
                String percentageVal=percentage.getText().toString();

                //student object
                student s=new student(rollNoVal,nameVal,branchVal,marksVal,percentageVal);



                //insert
                if(db.insertData(s)) {
                    Toast.makeText(getApplicationContext(), "Data Inserted Successfully", Toast.LENGTH_LONG).show();
                }
            }
        });

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rollno=search.getText().toString();

                //search
                student res=db.getStudent(rollno);
                result.setText(res.getRollno()+" "+res.getName()+" : "+res.getPercentage());
            }
        });

    }


}