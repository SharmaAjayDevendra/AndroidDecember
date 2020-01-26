package in.autodice.missingpart;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<Student> data;
    public  CustomAdapter(Context context, ArrayList<Student> arrayList){
        this.context=context;
        this.data=arrayList;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Student student=data.get(position);
        if(convertView==null){
            LayoutInflater layoutInflater=LayoutInflater.from(context);
            convertView=layoutInflater.inflate(R.layout.eksinglerow, null);
            TextView name=convertView.findViewById(R.id.studentname);
            ImageView image=convertView.findViewById(R.id.studentpic);
            name.setText(student.name);
            Picasso.with(context).load(student.pic).into(image);
        }
        return convertView;
    }
}
