package com.lark.woodturning;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SwipeAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.input_diameter);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override public void afterTextChanged(Editable editable) {
                try {
                    double diameter = Double.valueOf(editable.toString());
                    adapter.setDerivedValues(diameter, diameter * 0.293, diameter * 0.414, diameter * 0.196, diameter * 0.1075);
                    adapter.notifyDataSetChanged();
                    recyclerView.setVisibility(View.VISIBLE);
                } catch (Exception e) {

                }

            }
        });

        recyclerView = findViewById(R.id.swiper);

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new SwipeAdapter();
        recyclerView.setAdapter(adapter);
        new PagerSnapHelper().attachToRecyclerView(recyclerView);
    }
}
