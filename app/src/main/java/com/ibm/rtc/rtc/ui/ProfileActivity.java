package com.ibm.rtc.rtc.ui;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.ibm.rtc.rtc.R;

/**
 * Created by v-wajie on 2015/12/8.
 */
public class ProfileActivity extends AppCompatActivity {

    private ImageView mAvatar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mAvatar = (ImageView) findViewById(R.id.imgToolbar);

        mAvatar.setImageResource(R.mipmap.ic_launcher);
    }

}
