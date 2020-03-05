package in.autodice.databasedemo;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText name, rollno, year;
    Button save, view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        rollno=findViewById(R.id.roll);
        year=findViewById(R.id.year);
        save=findViewById(R.id.save);
        view=findViewById(R.id.view);
        save.setOnClickListener(this);
        view.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.save){
            String n=name.getText().toString();
            String r=rollno.getText().toString();
            String y=year.getText().toString();
            Student s=new Student(r, n, y);
            MyDatabase database=new MyDatabase(MainActivity.this);
            database.addStudent(s);
            Toast.makeText(MainActivity.this, "Student Added Successfully",
                    Toast.LENGTH_LONG).show();
        }else if(v.getId()==R.id.view){
            Intent intent=new Intent(MainActivity.this, ViewStudents.class);
            startActivity(intent);
        }
    }
}
