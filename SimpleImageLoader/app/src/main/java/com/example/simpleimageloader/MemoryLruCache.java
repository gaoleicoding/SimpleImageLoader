package com.example.simpleimageloader;

import android.graphics.Bitmap;
import android.util.LruCache;

public class MemoryLruCache implements ImageCache {
    private LruCache<String, Bitmap> mMemoryLruCache;

    public MemoryLruCache() {
    }

    public void init(int cacheSize) {
        mMemoryLruCache = new LruCache<>(cacheSize);
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
