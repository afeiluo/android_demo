package com.afeiluo.practiceproject;

import android.app.*;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

import com.afeiluo.practiceproject.view.SwipeBackActivity;
import com.afeiluo.practiceproject.view.SwipeBackLayout;

/**
 * Created by Administrator on 2015/9/24.
 */
public class GestureActivity extends SwipeBackActivity {
    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture);
        setDragEdge(SwipeBackLayout.DragEdge.TOP);
    }
//        mGestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
//            @Override
//            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//                // if (Math.abs(e1.getRawX() - e2.getRawX()) > 250) {
//                // // System.out.println("水平方向移动距离过大");
//                // return true;
//                // }
//                if (Math.abs(velocityY) < 100) {
//                    // System.out.println("手指移动的太慢了");
//                    return true;
//                }
//
//                // 手势向下 down
//                if ((e2.getRawY() - e1.getRawY()) > 200) {
//                    overridePendingTransition(R.anim.slide_up_in, R.anim.slide_up_out);
//                    finish();//在此处控制关闭
//                    return true;
//                }
//                // 手势向上 up
//                if ((e1.getRawY() - e2.getRawY()) > 200) {
//                    return true;
//                }
//                return super.onFling(e1, e2, velocityX, velocityY);
//            }
//        });
//
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        mGestureDetector.onTouchEvent(event);
//        return super.onTouchEvent(event);
//    }
}
