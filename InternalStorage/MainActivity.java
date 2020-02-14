package in.autodice.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button savebtn, readbtn;
    EditText filename, filedata;
    TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        savebtn=findViewById(R.id.savebtn);
        readbtn=findViewById(R.id.readbtn);
        filename=findViewById(R.id.filename);
        filedata=findViewById(R.id.filedata);
        output=findViewById(R.id.output);
        savebtn.setOnClickListener(this);
        readbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String fname=String.valueOf(filename.getText());
        String fdata=String.valueOf(filedata.getText());
        if(v.getId()==R.id.readbtn){
            //Read button related code
        }else if(v.getId()==R.id.savebtn){
            try {
                FileOutputStream fileOutputStream=openFileOutput(fname, Context.MODE_PRIVATE);
                fileOutputStream.write(fdata.getBytes());
                Toast.makeText(MainActivity.this, fname+" is saved successfully", Toast.LENGTH_LONG).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
