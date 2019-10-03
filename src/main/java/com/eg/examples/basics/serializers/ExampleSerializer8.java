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
 * ExampleSerializer8
 *
 * @author toran
 */

class Ex8 {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class ExampleSerializer8 implements Serializable {
        private static final long serialVersionUID = 2456944780480887327L;
        @GsonSerializationExclude
        @SerializedName(value = "When")
        private String whenS;
        @GsonDeserializationExclude
        private Long when;

        public void resolve() {
            when = Instant.parse((String) whenS).getEpochSecond();
            whenS = null;
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

    public void ex8() {

        //Ex8: Observe automatic casting of Long to Double
        System.out.println("Ex8: Use same variable in 2 data type while serialization & deserialization");
        String jsonMsg = "{'When': '2019-03-12T08:21:09.244Z'}";
        Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new GsonSerializationExclusionStrategy())
                .registerTypeAdapter(Double.class, new JsonSerializer<Double>() {
                    @Override
                    public JsonElement serialize(Double src, Type typeOfSrc, JsonSerializationContext context) {
                        if (src == src.longValue())
                            return new JsonPrimitive(src.longValue());
                        return new JsonPrimitive(src);
                    }
                }).create();
        ExampleSerializer8 eg8 = gson.fromJson(jsonMsg, ExampleSerializer8.class);
        eg8.resolve();
        System.out.println("\tDeserialized: " + eg8.getWhen());
        System.out.println("\tDeserialized: " + eg8);
        Map<String, Object> omap = gson.fromJson(gson.toJson(eg8), new TypeToken<Map<String, Object>>() {
        }.getType());
        System.out.println("Map " + omap);
        String json = gson.toJson(omap);
        System.out.println("Json " + json);
        System.out.println("\tDeserialized: " + gson.toJson(eg8));

    }

    public static void main(String[] args) {
        Ex8 ex = new Ex8();
        ex.ex8();
    }
}
