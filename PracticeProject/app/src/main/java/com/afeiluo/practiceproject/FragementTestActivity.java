package com.afeiluo.practiceproject;

import android.app.*;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by qiaolinfei on 2015/8/29.
 */
public class FragementTestActivity extends android.app.Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
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
     *
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
