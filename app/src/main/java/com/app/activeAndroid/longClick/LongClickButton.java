package com.app.activeAndroid.longClick;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2017/11/17.
 */

public class LongClickButton extends Button {


    private LongClickRepeatListener longClickRepeatListener;
    private MyHandler myHandler;
    private int intervalTime;

    public LongClickButton(Context context) {
        super(context);
        init();
    }

    public LongClickButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LongClickButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        myHandler = new MyHandler(this);
        setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                new Thread(new LongClickThread()).start();
                return false;
            }
        });
    }


    class LongClickThread implements Runnable {
        private int num;

        @Override
        public void run() {
            while (LongClickButton.this.isPressed()) {
                num++;
                if (num % 5 == 0) {
                    myHandler.sendEmptyMessage(1);
                }
                SystemClock.sleep(intervalTime / 5);
            }

        }
    }


    private class MyHandler extends Handler {

        private WeakReference<LongClickButton> ref;

        public MyHandler(LongClickButton button) {
            ref = new WeakReference<>(button);
        }


        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            LongClickButton button = ref.get();
            if (button != null && button.longClickRepeatListener != null) {
                button.longClickRepeatListener.repeatAction();
            }
        }
    }


    public interface LongClickRepeatListener {
        void repeatAction();
    }

    public void setLongClickRepeatListener(LongClickRepeatListener longClickRepeatListener) {
        setLongClickRepeatListener(longClickRepeatListener, 100);
    }

    public void setLongClickRepeatListener(LongClickRepeatListener longClickRepeatListener, int intervalTime) {
        this.longClickRepeatListener = longClickRepeatListener;
        this.intervalTime = intervalTime;

    }


}
