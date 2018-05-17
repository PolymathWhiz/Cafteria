package com.maplerad.cafteriaorderingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Polygod on 5/17/18.
 */
public class IntroActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.activity_intro);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run()
            {
                Intent intent =  new  Intent (IntroActivity.this,SignupActivity.class);
                startActivity(intent);
                finish();
            }

        }, 3000);


    }
}
