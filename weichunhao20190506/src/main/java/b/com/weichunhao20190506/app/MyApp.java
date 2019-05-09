package b.com.weichunhao20190506.app;

import android.app.Application;
import android.os.Environment;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

import java.io.File;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this, ImagePipelineConfig.newBuilder(MyApp.this)
                .setMainDiskCacheConfig(
                        DiskCacheConfig.newBuilder(this)
                                .setBaseDirectoryPath(new File(Environment.getExternalStorageDirectory().getAbsolutePath()))
                                .setMaxCacheSize(10*1024)
                                .build()
                )
                .build());
    }
}
