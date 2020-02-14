package in.autodice.demoapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;
public class StorageClass extends SQLiteOpenHelper {
    static  String name="temporarystorage";
    Context context;
    public StorageClass(@Nullable Context context) {
        super(context, name, null, 1);
        this.context=context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String tablecreation="create table student(ID INTEGER PRIMARY KEY, NAME VARCHAR(50), EMAIL VARCHAR(255))";
        db.execSQL(tablecreation);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String tabledestroy="drop table if exists student";
        db.execSQL(tabledestroy);
        onCreate(db);
    }

    void addStudent(int id, String name, String email){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("ID", id);
        values.put("NAME", name);
        values.put("EMAIL", email);
        db.insert("student", null, values);
        db.close();
        Toast.makeText(context, "Student Created Successfully", Toast.LENGTH_LONG).show();
    }
}
