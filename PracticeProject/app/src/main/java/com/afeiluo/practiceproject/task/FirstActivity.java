package com.afeiluo.practiceproject.task;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.afeiluo.practiceproject.R;

import org.w3c.dom.Text;

/**
 * Created by Administrator on 2015/9/29.
 */
public class FirstActivity extends Activity {
    private TextView activityInfoTxt;
    private TextView taskInfoTxt;
    private Button jumpBtn;
    private Button tsiBtn;
    private Button tnBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backstack);
        activityInfoTxt = (TextView) findViewById(R.id.activity_info);
        activityInfoTxt.setText("activity info:" + this.toString());
        taskInfoTxt = (TextView) findViewById(R.id.task_info);
        taskInfoTxt.setText("task info:" + this.getTaskId());
        jumpBtn = (Button) findViewById(R.id.jump_btn);
        jumpBtn.setText("jump to self singleTask mode");
        jumpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, FirstActivity.class);
                intent.putExtra("have_extra", true);
                startActivity(intent);
            }
        });
        tsiBtn = (Button) findViewById(R.id.to_singleinstance_btn);
        tsiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SingleInstanceActivity.class);
                intent.putExtra("have_extra", true);
                startActivity(intent);
            }
        });
        tnBtn = (Button) findViewById(R.id.to_normal_btn);
        tnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, NormalActivity.class);
                intent.putExtra("have_extra", true);
                startActivity(intent);
            }
        });
    }
}
