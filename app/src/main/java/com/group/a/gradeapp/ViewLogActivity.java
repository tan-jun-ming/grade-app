package com.group.a.gradeapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.util.List;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.group.a.gradeapp.DB.AppDatabase;
import com.group.a.gradeapp.DB.LogRecord;
import com.group.a.gradeapp.DB.User;


public class ViewLogActivity  extends AppCompatActivity {

    private ViewLogAdapter adapter;

    private List<User> users;
    private List<LogRecord> records;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("ViewLogActivity", "onCreate called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_log);




        Button return_button = findViewById(R.id.return_button);
        return_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ViewLogActivity", "onClick return called");
                finish();
            }
        });


        // retrieve all log grades from database
        //records = AppDatabase.getAppDatabase(this).gradeDAO().getAllLogRecords();
        records = AppDatabase.getAppDatabase(this).userDAO().getAllLogRecords();


        RecyclerView rv = findViewById(R.id.recycler_view);
        rv.setLayoutManager( new LinearLayoutManager(this));
        adapter = new ViewLogAdapter();
        rv.setAdapter(adapter);

        if (adapter.getItemCount() == 0){
            AlertDialog.Builder builder = new AlertDialog.Builder(ViewLogActivity.this);
            builder.setTitle("No log activity found");
            builder.setPositiveButton("Continue to Home Page", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();


        }



    }

    private class ViewLogAdapter  extends RecyclerView.Adapter<ItemHolder> {
        @Override
        public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType){
            LayoutInflater layoutInflater = LayoutInflater.from(ViewLogActivity.this);
            return new ItemHolder(layoutInflater, parent);
        }
        @Override
        public void onBindViewHolder(ItemHolder holder, int position){
            holder.bind(records.get(position));
        }
        @Override
        public int getItemCount() { return records.size(); }
    }
    private class ItemHolder extends RecyclerView.ViewHolder {
        public ItemHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item, parent, false));
        }
        public void bind(LogRecord rec ) {
            TextView item = itemView.findViewById(R.id.item_id);
            item.setText(rec.toString());
        }





    }





}
