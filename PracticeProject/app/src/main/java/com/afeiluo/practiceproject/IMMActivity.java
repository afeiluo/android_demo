package com.afeiluo.practiceproject;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.afeiluo.practiceproject.view.MyButton;

/**
 * Created by qiaolinfei on 2015/8/25.
 */
public class IMMActivity extends Activity {
    private final static String TAG = "IMMActivity";
    private EditText editText;
    private MyButton myBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imm_activity);
        editText = (EditText) findViewById(R.id.et_test);
        editText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        myBtn = (MyButton) findViewById(R.id.my_btn);
        myBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i(TAG, "onTouch");
                return false;
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (this.getCurrentFocus() != null) {
                if (this.getCurrentFocus().getWindowToken() != null) {
                    imm.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);
                } else {
                    Log.i(TAG, "current window token is null");
                }
            } else {
                Log.i(TAG, "current focus is null");
            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean ret = super.dispatchTouchEvent(ev);
        return ret;
    }
}
