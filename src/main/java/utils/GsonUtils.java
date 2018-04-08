package utils;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class GsonUtils  {

    public static <T> List<T> toList(String json, Class<T[]> clazz) {
        T[] arr = new Gson().fromJson(json, clazz);
        return Arrays.asList(arr);
    }
}
