package in.autodice.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class ViewStudents extends AppCompatActivity {
    Button button;
    MyDatabase database;
    List<Student> students;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_students);
        database=new MyDatabase(this);
        button=findViewById(R.id.output);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                students=database.getStudents();
                Log.i("AjaySharma", students.get(0).name);
            }
        });
    }
}
