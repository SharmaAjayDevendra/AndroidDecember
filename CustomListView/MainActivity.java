package in.autodice.missingpart;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Student> arrayList;
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.mylist);
        arrayList=new ArrayList<Student>();
        arrayList.add(new Student("Ajay", "FY"));
        arrayList.add(new Student("Vijay", "SY"));
        arrayList.add(new Student("Sanjay", "TY"));
        arrayList.add(new Student("Dhananjay", "BE"));
        adapter=new CustomAdapter(this, arrayList);
        listView.setAdapter(adapter);
    }
}
