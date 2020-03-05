package in.autodice.fragmentexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import in.autodice.fragmentexample.fragments.BlueFragment;
import in.autodice.fragmentexample.fragments.GreenFragment;
import in.autodice.fragmentexample.fragments.RedFragment;

public class MainActivity extends AppCompatActivity {
    Button red, blue, green;
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        red=findViewById(R.id.red);
        blue=findViewById(R.id.blue);
        green=findViewById(R.id.green);
        manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.mainframe, new RedFragment());
        transaction.commit();

        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction=manager.beginTransaction();
                transaction.replace(R.id.mainframe, new RedFragment());
                transaction.commit();
            }
        });

        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction=manager.beginTransaction();
                transaction.replace(R.id.mainframe, new GreenFragment());
                transaction.commit();
            }
        });

        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction=manager.beginTransaction();
                transaction.replace(R.id.mainframe, new BlueFragment());
                transaction.commit();
            }
        });

    }
}
