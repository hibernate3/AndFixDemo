package com.example.andfixdemo;

import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toast();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Process.killProcess(Process.myPid());
    }

    //打包1.apk后，修改toast内容，打包2.apk
    private void toast() {
        Toast.makeText(this, "new", Toast.LENGTH_SHORT).show();
    }
}
