package com.afeiluo.practiceproject.task;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.afeiluo.practiceproject.R;

/**
 * Created by Administrator on 2015/9/29.
 */
public class NormalActivity extends Activity {
    private TextView activityInfoTxt;
    private TextView taskInfoTxt;
    private Button tfBtn;
    private Button siBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        activityInfoTxt = (TextView) findViewById(R.id.activity_info);
        taskInfoTxt = (TextView) findViewById(R.id.task_info);
        activityInfoTxt.setText("activity info:" + this.toString());
        taskInfoTxt.setText("task info:" + this.getTaskId());
        tfBtn = (Button) findViewById(R.id.to_first_btn);
        tfBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NormalActivity.this, FirstActivity.class);
                intent.putExtra("have_extra", true);
                startActivity(intent);
            }
        });
        siBtn = (Button) findViewById(R.id.to_singleinstance_btn);
        siBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NormalActivity.this, SingleInstanceActivity.class);
                intent.putExtra("have_extra", true);
                startActivity(intent);
            }
        });
    }
}
