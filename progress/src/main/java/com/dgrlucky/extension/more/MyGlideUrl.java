package com.dgrlucky.extension.more;

import com.bumptech.glide.load.model.GlideUrl;

public class MyGlideUrl extends GlideUrl {

    private String mUrl;

    public MyGlideUrl(String url) {
        super(url);
    }

    @Override
    public String getCacheKey() {
        //将token部分参数替换为空字符串后返回作为缓存Key
        return mUrl.replace(findTokenParam(), "");
    }

    /**
     * 查找token部分参数的方法
     * @return token部分参数String
     */
    private String findTokenParam() {
        String tokenParam = "";
        int tokenKeyIndex = mUrl.indexOf("?token=") >= 0 ? mUrl.indexOf("?token=") : mUrl.indexOf("&token=");
        if (tokenKeyIndex != -1) {
            int nextAndIndex = mUrl.indexOf("&", tokenKeyIndex + 1);
            if (nextAndIndex != -1) {
                tokenParam = mUrl.substring(tokenKeyIndex + 1, nextAndIndex + 1);
            } else {
                tokenParam = mUrl.substring(tokenKeyIndex);
            }
        }
        return tokenParam;
    }
}