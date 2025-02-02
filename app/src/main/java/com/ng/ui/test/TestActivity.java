package com.ng.ui.test;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ng.nguilib.utils.DensityUtil;
import com.ng.nguilib.utils.MLog;
import com.ng.nguilib.view.BoundlessSeekBar2;
import com.ng.ui.R;

/**
 * 描述:
 *
 * @author Jzn
 * @date 2020-01-08
 */
public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        DensityUtil.INSTANCE.setCustomDensity(this, getApplication());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        init();
    }

    BoundlessSeekBar2 mBr;
    SeekBar sk_bar;
    TextView tv_show;

    private void init() {
        mBr = findViewById(R.id.test_bar_a);
        tv_show = findViewById(R.id.tv_show);

        mBr.setLastPriceInit(0.01f, 0);
        sk_bar = findViewById(R.id.sk_bar);

        sk_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                MLog.INSTANCE.d("pro: " + progress);
                float temp = ((float) progress) / 100f;
                mBr.setLastPriceInit(temp, 0);

                tv_show.setText(mBr.getNowPrice()+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }


}
