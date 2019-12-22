package in.autodice.myapplication;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button loginbutton;
    EditText username, password;
    String output="";
    CheckBox tandc;
    RadioButton radioButton;
    RadioGroup relation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginbutton=findViewById(R.id.mybutton);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        tandc=findViewById(R.id.tandc);
        relation=findViewById(R.id.relation);
        relation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton=findViewById(checkedId);
                Toast.makeText(getBaseContext(), radioButton.getText().toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}
