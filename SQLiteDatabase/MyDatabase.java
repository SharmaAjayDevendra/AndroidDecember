package in.autodice.databasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    public MyDatabase(@Nullable Context context) {
        super(context, "students", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table student(ID integer PRIMARY KEY AUTOINCREMENT, ROLL varchar(3), NAME varchar(50), YEAR varchar(3))";
        db.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query="drop table if exists student";
        db.execSQL(query);
        onCreate(db);
    }
    public void addStudent(Student s){
                SQLiteDatabase db=getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put("ROLL", s.rollNo);
                values.put("NAME", s.name);
                values.put("YEAR", s.year);
                db.insert("student", null, values);
    }

    public List<Student> getStudents(){
        List<Student> students=new ArrayList<Student>();
        SQLiteDatabase db=getWritableDatabase();
        Cursor cursor=db.rawQuery("select *from student", null);
        if(cursor.moveToFirst()){
           do{
               students.add(new Student(cursor.getString(1),
                       cursor.getString(2), cursor.getString(3)));
           }while(cursor.moveToNext());
        }
        return students;
    }
}
