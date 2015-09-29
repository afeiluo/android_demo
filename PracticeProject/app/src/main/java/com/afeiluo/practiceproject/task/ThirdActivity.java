package com.afeiluo.practiceproject.task;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.afeiluo.practiceproject.R;

/**
 * Created by Administrator on 2015/9/29.
 */
public class ThirdActivity extends Activity {
    private TextView activityInfoTxt;
    private TextView taskInfoTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backstack);
        activityInfoTxt = (TextView) findViewById(R.id.activity_info);
        taskInfoTxt = (TextView) findViewById(R.id.task_info);
    }
}
