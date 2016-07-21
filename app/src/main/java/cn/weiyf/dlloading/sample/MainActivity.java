package cn.weiyf.dlloading.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.weiyf.dlloading.DLLoadingView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DLLoadingView dlLoadingView = new DLLoadingView();
        dlLoadingView.show(getSupportFragmentManager(), "");
    }
}
