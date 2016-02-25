package com.example.aokly.myapplication;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends ListActivity {

    String arr[] = {"First","second","First","second","First","second"};
    ArrayList<String> lst;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lst = new ArrayList<String>(Arrays.asList(arr));
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,lst);
        setListAdapter(adapter);
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position,long id){
        final String text = (String)getListAdapter().getItem(position);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        final EditText edit = new EditText(this);
        builder.setView(edit);
        builder.setTitle("Заголовок");
        builder.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("Ок", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();

            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
