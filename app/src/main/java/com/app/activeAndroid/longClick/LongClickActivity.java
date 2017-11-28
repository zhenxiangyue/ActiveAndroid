package com.app.activeAndroid.longClick;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.app.activeAndroid.R;

public class LongClickActivity extends AppCompatActivity {

    private TextView show_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_long_click);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        show_tv = (TextView) findViewById(R.id.show_tv);
        LongClickButton jiaBtn = (LongClickButton) findViewById(R.id.btn_jia);
        LongClickButton jianBtn = (LongClickButton) findViewById(R.id.btn_jian);
        jiaBtn.setLongClickRepeatListener(new LongClickButton.LongClickRepeatListener() {
            @Override
            public void repeatAction() {
                setJia();
            }
        });

        jiaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setJia();
            }
        });
        jianBtn.setLongClickRepeatListener(new LongClickButton.LongClickRepeatListener() {
            @Override
            public void repeatAction() {
                setJian();
            }
        });
        jianBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setJian();
            }
        });
    }

    public void setJia() {
        String show = show_tv.getText().toString();
        double value = parseDouble(show) + 1;
        show_tv.setText(value + "");
    }

    public void setJian() {
        String show = show_tv.getText().toString();
        double value = parseDouble(show) - 1;
        show_tv.setText(value + "");
    }

    public double parseDouble(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return Double.parseDouble(str);
    }


}
