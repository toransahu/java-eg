package com.eg.examples.basics.serializers;

import com.google.gson.*;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Type;
import java.time.Instant;
import java.util.Map;

/**
 * ExampleSerializer9
 *
 * @author toran
 */

public class Ex9 {

    public interface Msg {
        Object getWhen();
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ExampleSerializer9 implements Serializable , Msg{
        public static long serialVersionUID = 2456944780480887327L;
        @SerializedName(value = "When")
        Object when;


        public void resolve() {
            when = Instant.parse((String) when).getEpochSecond();
            // when = 1552378869L;
        }
    }


    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface GsonDeserializationExclude {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface GsonSerializationExclude {
    }

    public class GsonSerializationExclusionStrategy implements ExclusionStrategy{
        @Override
        public boolean shouldSkipField(FieldAttributes field) {
            return field.getAnnotation(GsonSerializationExclude.class) != null;
        }

        @Override
        public boolean shouldSkipClass(Class<?> aClass) {
            return false;
        }
    }

    public void ex9() {

        //Ex9: Observe automatic casting of Long to Double
        System.out.println("Ex9: Use same variable in 2 data type while serialization & deserialization");
        String jsonMsg = "{'When': '2019-03-12T08:21:09.244Z'}";
        Gson gson;
        gson = new GsonBuilder()
                // .addSerializationExclusionStrategy(new GsonSerializationExclusionStrategy())
                .registerTypeAdapter(Double.class, new JsonSerializer<Double>() {
                    @Override
                    public JsonElement serialize(Double src, Type typeOfSrc, JsonSerializationContext context) {
                        if (src == src.longValue())
                            return new JsonPrimitive(src.longValue());
                        return new JsonPrimitive(src);
                    }
                }).create();
        // gson = new Gson();
        ExampleSerializer9 eg9 = gson.fromJson(jsonMsg, ExampleSerializer9.class);
        eg9.resolve();
        System.out.println("\tDeserialized: " + eg9.getWhen().getClass());
        System.out.println("\tDeserialized: " + eg9);
        Map<String, Object> omap = gson.fromJson(gson.toJson(eg9), new TypeToken<Map<String, Object>>() {
        }.getType());
        System.out.println("\tMap " + omap);
        System.out.println("\tMap " + omap.get("When").getClass());
        String json = gson.toJson(omap);
        System.out.println("\tJson " + json);
        System.out.println("\tDeserialized: " + gson.toJson(eg9));

    }

    public static void main(String[] args) {
        Ex9 ex = new Ex9();
        ex.ex9();
        Object l = 1000;
        l = 1000 * 10;
        System.out.println(l);
    }
}