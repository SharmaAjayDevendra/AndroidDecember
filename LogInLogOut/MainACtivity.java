package in.autodice.missingpart;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView listView;
    ArrayList<Student> arrayList;
    CustomAdapter adapter;
    String studentname;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.mylist);
        arrayList=new ArrayList<Student>();
        arrayList.add(new Student("Ajay", "https://dummyimage.com/300/09f.png"));
        arrayList.add(new Student("Vijay", "https://dummyimage.com/300/09f.png"));
        arrayList.add(new Student("Sanjay", "https://dummyimage.com/300/09f.png"));
        arrayList.add(new Student("Dhananjay", "https://dummyimage.com/300/09f.png"));
        adapter=new CustomAdapter(this, arrayList);
        listView.setAdapter(adapter);

        preferences= PreferenceManager.getDefaultSharedPreferences(this);
        studentname=preferences.getString("student", "nouser");
        if(!preferences.getString("student", "nouser").equals("nouser")){
            Intent intent=new Intent(MainActivity.this, SagarKiVashiWali.class);
            startActivity(intent);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    studentname=arrayList.get(position).name;
                    if(preferences.getString("student", "nouser").equals("nouser")){
                        preferences.edit().putString("student", studentname).commit();
                        Intent intent=new Intent(MainActivity.this, SagarKiVashiWali.class);
                        startActivity(intent);
                    }
            }
        });
    }
}
