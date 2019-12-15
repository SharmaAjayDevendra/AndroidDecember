package in.autodice.myapplication;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button loginbutton;
    EditText username, password;
    String output="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginbutton=findViewById(R.id.mybutton);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                output="Your username is: "+username.getText().toString();
                output+=" Your password is: "+password.getText().toString();
                Toast.makeText(getBaseContext(), output, Toast.LENGTH_LONG).show();
            }
        });
    }
}
