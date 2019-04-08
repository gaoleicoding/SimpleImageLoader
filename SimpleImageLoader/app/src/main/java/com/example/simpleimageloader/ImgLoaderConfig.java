package com.example.simpleimageloader;

import android.content.Context;

public class ImgLoaderConfig {
    int memoryCacheSize, diskCacheSize;
    int threadCount;
    int load_error_resId;
    String cachePath;
    Context context;

    public static ImgLoaderConfig createDefault(Context context) {
        return new ImgLoaderConfig.Builder(context).build();
    }

    public String getCachePath() {
        return cachePath;
    }

    public int getMemoryCacheSize() {
        return memoryCacheSize;
    }

    public int getDiskCacheSize() {
        return diskCacheSize;
    }

    public int getThreadCount() {
        return threadCount;
    }

    public int getLoad_error_resId() {
        return load_error_resId;
    }

    public static class Builder {

        Context context;
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory()) / 1024;
        int memoryCacheSize = maxMemory / 4;
        int diskCacheSize = 10 * 1024 * 1024;
        int threadCount = 3;
        int load_error_resId = R.mipmap.default_img;
        String cachePath;

        public Builder(Context context) {
            this.context = context.getApplicationContext();
            cachePath = context.getExternalCacheDir().getPath() + "/imageloader";
        }

        public Builder setCachePath(String cachePath) {
            this.cachePath = cachePath;
            return this;
        }

        public Builder setMemoryCacheSize(int memoryCacheSize) {
            this.memoryCacheSize = memoryCacheSize;
            return this;
        }

        public Builder setDiskCacheSize(int diskCacheSize) {
            this.diskCacheSize = diskCacheSize;
            return this;
        }

        public Builder setThreadCount(int threadCount) {
            this.threadCount = threadCount;
            return this;
        }

        public Builder setLoad_error_resId(int load_error_resId) {
            this.load_error_resId = load_error_resId;
            return this;
        }


        void applyConfig(ImgLoaderConfig config) {
            config.memoryCacheSize = memoryCacheSize;
            config.diskCacheSize = diskCacheSize;
            config.threadCount = threadCount;
            config.load_error_resId = load_error_resId;
            config.cachePath = cachePath;
            config.context = context;
        }

        public ImgLoaderConfig build() {
            ImgLoaderConfig config = new ImgLoaderConfig();
            applyConfig(config);
            return config;
        }
    }


}
