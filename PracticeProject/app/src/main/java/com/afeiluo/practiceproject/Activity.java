package com.afeiluo.practiceproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by qiaolinfei on 2015/8/29.
 */
public class Activity extends android.app.Activity {
    private Button startBtn;
    private Integer REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            String name = savedInstanceState.getString("name");
            Toast.makeText(this, "onRestoreInstanceState name:" + name, Toast.LENGTH_SHORT).show();
        }
        hey wozai ceshi
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        startBtn = (Button) findViewById(R.id.start_btn);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity.this, AnotherActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
        Toast.makeText(this, "Activity onCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Activity onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Activity onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Activity onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Activity onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Activity onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "Activity onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, "Activity onActivityResult", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable("name", "qiaolinfei");
        super.onSaveInstanceState(outState);
        Toast.makeText(this, "Activity onSaveInstanceState", Toast.LENGTH_SHORT).show();
    }

    /**
     * 不一定会被调用
     * @param savedInstanceState
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(this, "Activity onRestoreInstanceState", Toast.LENGTH_SHORT).show();
        if (savedInstanceState != null) {
            String name = savedInstanceState.getString("name");
            Toast.makeText(this, "onRestoreInstanceState name:" + name, Toast.LENGTH_SHORT).show();
        }
    }
}
