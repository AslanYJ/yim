package com.yjlan.im.common.utils;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Http 工具
 * @author yjlan
 */
public final class HttpClient {

    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json");

    public static Response call(OkHttpClient okHttpClient, String params, String url) throws IOException {
        RequestBody requestBody = RequestBody.create(MEDIA_TYPE, params);

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        Response response = okHttpClient.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        }

        return response;
    }
}
