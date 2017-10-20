package com.example.a10062376.gridviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private List<MyBean> list = new ArrayList<>();
    private GridView myGridView;
    private RecyclerView recyclerView;
    private ListAdapter listAdapter;
    private Button btnAdd, btnRemove;
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.tvList);
        btnAdd = (Button) findViewById(R.id.addItem);
        btnRemove = (Button) findViewById(R.id.removeItem);
        btnAdd.setOnClickListener(this);
        btnRemove.setOnClickListener(this);

        gridLayoutManager = new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        listAdapter = new ListAdapter(this, list);
        recyclerView.setAdapter(listAdapter);

        for (int i = 0; i < 3; i++) {
            MyBean b=new MyBean();
            b.setOnline(i%2==0);
            list.add(b);
        }
        setData();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addItem:
                if (list.size()<6){
                    MyBean bean=new MyBean();
                    list.add(bean);
                    setData();
                }else {
                    Toast.makeText(this, "不能再加了", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.removeItem:
                if (list.size()>2){
                    list.remove(0);
                    setData();
                }else {
                    Toast.makeText(this, "不能再减了", Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }
    private void setData() {

        if (list.size()<=4){
            gridLayoutManager.setSpanCount(2);
        }else {
            gridLayoutManager.setSpanCount(3);
        }
        listAdapter.notifyDataSetChanged();
    }
}
