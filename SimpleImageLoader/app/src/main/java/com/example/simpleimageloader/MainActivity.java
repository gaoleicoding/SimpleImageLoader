package com.example.simpleimageloader;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.dfqin.grantor.PermissionListener;
import com.github.dfqin.grantor.PermissionsUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

public class MainActivity extends AppCompatActivity {

    ImageView imageView, imageView2;
    Button bt_load;
    String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1554480443283&di=dc9ee03537527a782212054f065d322b&imgtype=0&src=http%3A%2F%2Fp2.ifengimg.com%2Fcmpp%2F2017%2F03%2F02%2F13%2Fb841cf0e-65b3-47c5-a395-0a32c73b9823_size78_w500_h405.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        bt_load = findViewById(R.id.bt_load);

        ImgLoaderConfig config = new ImgLoaderConfig.Builder(this)
                .setThreadCount(4)
                .setMemoryCacheSize(2 * 1024 * 1024)
                .build();
        ImgLoader imgLoader = ImgLoader.getInstance();
        imgLoader.init(config).displayImage(url, imageView);
        bt_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImgLoader.getInstance().displayImage(url, imageView2);
            }
        });
        requestPermission();
        ImageLoader.getInstance().displayImage(url, imageView2);
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        /* callback - no nothing */
    }

    private void requestPermission() {

        PermissionsUtil.requestPermission(this, new PermissionListener() {
            @Override
            public void permissionGranted(@NonNull String[] permissions) {
            }

            @Override
            public void permissionDenied(@NonNull String[] permissions) {
                Toast.makeText(MainActivity.this, "请打开访问存储权限", Toast.LENGTH_LONG).show();
            }
        }, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, false, null);
    }

    @Override
    protected void onPause() {
        super.onPause();
        ImgLoader.getInstance().fluchCache();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 退出程序时结束所有的下载任务
        ImgLoader.getInstance().cancelAllTasks();
    }
}
