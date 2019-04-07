package com.example.simpleimageloader;

import com.nostra13.universalimageloader.core.assist.ImageScaleType;

public class ImgLoaderConfig {
    int imageWidth_default, imageHeight_defaul;
    int memoryCacheSize_defaul, diskCacheSize_defaul;
    int threadCount_defaul;
    int load_error_resId_defaul;
    ImageScaleType imageScaleType;

    public static class Builder {
        int imageWidth, imageHeight;
        int memoryCacheSize, diskCacheSize;
        int threadCount;
        int load_error_resId;
        ImageScaleType imageScaleType;

        public Builder setImageWidth(int imageWidth) {
            this.imageWidth = imageWidth;
            return this;
        }

        public Builder setImageHeight(int imageHeight) {
            this.imageHeight = imageHeight;
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

        public Builder setImageScaleType(ImageScaleType imageScaleType) {
            this.imageScaleType = imageScaleType;
            return this;
        }

        void applyConfig(ImgLoaderConfig config) {
            config.imageHeight_defaul = imageWidth;
            config.imageHeight_defaul = imageHeight;
            config.memoryCacheSize_defaul = memoryCacheSize;
            config.diskCacheSize_defaul = diskCacheSize;
            config.threadCount_defaul = threadCount;
            config.load_error_resId_defaul = load_error_resId;
        }

        public ImgLoaderConfig create() {

            ImgLoaderConfig config = new ImgLoaderConfig();
            applyConfig(config);
            return config;
        }
    }


}
