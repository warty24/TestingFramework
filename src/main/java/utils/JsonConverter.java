package utils;

import com.google.gson.Gson;

public class JsonConverter {

    public static  <T> T fromJson(String content, Class<T> type) {
        Gson gson = new Gson();
        return gson.fromJson(content, type);
    }

    public static String toJson(Object model) {
        Gson gson = new Gson();
        return gson.toJson(model);
    }
}
