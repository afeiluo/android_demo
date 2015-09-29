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
public class SingleInstanceActivity extends Activity {
    private TextView activityInfo;
    private TextView taskInfo;
    private Button tfBtn;
    private Button tnBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_instance);
        activityInfo = (TextView) findViewById(R.id.activity_info);
        taskInfo = (TextView) findViewById(R.id.task_info);
        activityInfo.setText("activity info:" + this.toString());
        taskInfo.setText("task info:" + this.getTaskId());
        tfBtn = (Button) findViewById(R.id.to_first_btn);
        tfBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingleInstanceActivity.this, FirstActivity.class);
                intent.putExtra("have_extra", true);
                startActivity(intent);
            }
        });
        tnBtn = (Button) findViewById(R.id.to_normal_btn);
        tnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingleInstanceActivity.this, NormalActivity.class);
                intent.putExtra("have_extra", true);
                startActivity(intent);
            }
        });
    }
}
