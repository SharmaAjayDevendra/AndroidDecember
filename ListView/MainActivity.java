package in.autodice.myapplication;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String[] city={"Mumbai", "Pune", "Haryana", "Delhi"};
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.mylist);
        adapter=new ArrayAdapter(getBaseContext(), R.layout.mylistitem, city);
        listView.setAdapter(adapter);
    }
}
