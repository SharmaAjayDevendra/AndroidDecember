package in.autodice.missingpart;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SagarKiVashiWali extends AppCompatActivity {
    TextView textView;
    Button button;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sagar_ki_vashi_wali);
        textView=findViewById(R.id.student);
        preferences= PreferenceManager.getDefaultSharedPreferences(this);
        button=findViewById(R.id.mybtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    preferences.edit().putString("student", "nouser").commit();
                    Intent intent=new Intent(SagarKiVashiWali.this, MainActivity.class);
                    startActivity(intent);
            }
        });
        if(!preferences.getString("student", "nouser").equals("nouser")){
            textView.setText(preferences.getString("student", "nouser"));
        }
    }
}
