package in.autodice.demoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

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
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 108767);
        }
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }
    }

    @Override
    public void onClick(View v) {
        String fname=String.valueOf(filename.getText());
        String fdata=String.valueOf(filedata.getText());
        if(v.getId()==R.id.readbtn){
            try {
                File file=new File("sdcard/"+fname);
                FileInputStream inputStream=new FileInputStream(file);
                InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
                BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                String line;
                String op="Nothing ";
                while ((line=bufferedReader.readLine())!=null){
                        op+=line;
                }
                output.setText(op);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(v.getId()==R.id.savebtn){
            try {
                File file=new File("sdcard/"+fname);
                file.createNewFile();
                FileOutputStream fileOutputStream=new FileOutputStream(file);
                OutputStreamWriter writer=new OutputStreamWriter(fileOutputStream);
                writer.write(fdata);
                writer.flush();
                Toast.makeText(MainActivity.this, fname+" is saved successfully", Toast.LENGTH_LONG).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
