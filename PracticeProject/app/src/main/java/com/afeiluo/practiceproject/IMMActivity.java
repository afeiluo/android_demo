package com.afeiluo.practiceproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

/**
 * Created by qiaolinfei on 2015/8/25.
 */
public class IMMActivity extends Activity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imm_activity);
        editText = (EditText) findViewById(R.id.et_test);
    }
}
