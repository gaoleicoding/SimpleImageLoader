package com.example.simpleimageloader;

import android.graphics.Bitmap;
import android.util.LruCache;

public class MemoryCache implements ImageCache {
    private LruCache<String, Bitmap> mMemoryLruCache;

    public MemoryCache() {
//        final int maxMemory = (int) (Runtime.getRuntime().maxMemory()) / 1024;
//        final int cacheSize = maxMemory / 4;

    }

    public void init(int cacheSize) {
        mMemoryLruCache = new LruCache<String, Bitmap>(cacheSize);
    }

    @Override
    public Bitmap get(String url) {
        return mMemoryLruCache.get(url);
    }

    @Override
    public void put(String url, Bitmap bmp) {
        if (get(url) == null)
            mMemoryLruCache.put(url, bmp);
    }
}
