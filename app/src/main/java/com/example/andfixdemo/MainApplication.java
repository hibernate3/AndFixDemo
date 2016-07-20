package com.example.andfixdemo;

import android.app.Application;
import android.os.Environment;
import android.util.Log;

import com.alipay.euler.andfix.patch.PatchManager;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/7/15.
 */
public class MainApplication extends Application {
    private static final String TAG = "euler";

    private static final String APATCH_PATH = "/out.apatch";
    private static final String DIR = "apatch";//补丁文件夹

    private PatchManager mPatchManager;

    @Override
    public void onCreate() {
        super.onCreate();

        mPatchManager = new PatchManager(this);
        mPatchManager.init("1.0");
        Log.d(TAG, "inited.");

        mPatchManager.loadPatch();

        try {
            String patchFileString = Environment.getExternalStorageDirectory().getAbsolutePath()
                    + APATCH_PATH;

            mPatchManager.addPatch(patchFileString);
            Log.d(TAG, "apatch: " + patchFileString + " added.");

            File f = new File(getFilesDir(), DIR + APATCH_PATH);
            if (f.exists()) {
                boolean result = new File(patchFileString).delete();
                if (!result) {
                    Log.e(TAG, patchFileString + " delete fail");
                } else {
                    Log.e(TAG, patchFileString + " delete success");
                }
            }
        } catch (IOException e) {
            Log.e(TAG, "IOException: " + e.toString());
        }
    }
}
