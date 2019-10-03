package com.eg.examples.basics.serializers;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class Example {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Toran");
        map.put("last", "Sahu");

        // Ex1: transient with @SerializedName
        System.out.println("Ex1: transient with @SerializedName");
        String jsonMsg = gson.toJson(map, new TypeToken<Map<String, Object>>(){}.getType());
        ExampleSerializer1 eg1 = gson.fromJson(jsonMsg, new TypeToken<ExampleSerializer1>(){}.getType());
        eg1.resolve();
        System.out.println("\tDeserialized: " + gson.toJson(eg1));

        // Ex2: transient without @SerializedName
        System.out.println("Ex2: transient without @SerializedName");
        ExampleSerializer2 eg2 = new ExampleSerializer2("Toran", "Sahu");
        System.out.println("\tDeserialized: " + gson.toJson(eg2));

        // Ex3: Fetch nested JSON using dot operator in @SerializedName
        System.out.println("Ex3: Fetch nested JSON using dot operator in @SerializedName");
        jsonMsg = "{'name':'Toran', 'details':{'age':27}}";
        // ExampleSerializer3.class is same as new TypeToken<ExampleSerializer3>(){}.getType()
        ExampleSerializer3 eg3 = gson.fromJson(jsonMsg, ExampleSerializer3.class);
        eg3.resolve();
        System.out.println("\tDeserialized: " + gson.toJson(eg3));

        // Ex4: transient without @SerializedName and input type JSON
        System.out.println("Ex4: transient without @SerializedName and input type JSON");
        jsonMsg = "{'name':'Toran'}";
        ExampleSerializer4 eg4 = gson.fromJson(jsonMsg, ExampleSerializer4.class);
        eg4.resolve();
        System.out.println("\tDeserialized: " + gson.toJson(eg4));

        // Ex5: NonSerializer class + transient without @SerializedName and input type JSON
        System.out.println("Ex5: NonSerializer class + transient without @SerializedName and input type JSON");
        jsonMsg = "{'name':'Toran'}";
        ExampleNonSerializer eg5 = gson.fromJson(jsonMsg, ExampleNonSerializer.class);
        eg5.resolve();
        System.out.println("\tDeserialized: " + gson.toJson(eg5));

        // Ex6: Lombok + transient without @SerializedName and input type JSON
        System.out.println("Ex6: Lombok + transient without @SerializedName and input type JSON");
        jsonMsg = "{'firstName':'Toran'}";
        ExampleSerializer6 eg6 = gson.fromJson(jsonMsg, ExampleSerializer6.class);
        eg6.resolve();
        System.out.println("\tDeserialized: " + gson.toJson(eg6));

        //Ex7: Observe automatic casting of Long to Double
        System.out.println("Ex7: Observe automatic casting of Long to Double");
        jsonMsg = "{'epoch': 1548091795000}";
        ExampleSerializer7 eg7 = gson.fromJson(jsonMsg, ExampleSerializer7.class);
        eg7.resolve();
        System.out.println("\tDeserialized: " + gson.toJson(eg7));
        Map<String, Object> output = gson.fromJson(gson.toJson(eg7), new TypeToken<Map<String, Object>>(){}.getType());
        System.out.println("\tDouble: " + output.get("epoch"));
        JsonObject obj = gson.fromJson(gson.toJson(eg7), JsonObject.class);
        System.out.println("\tRaw String: " + obj.get("epoch"));
        //System.out.println("\tLong: " + (Long)obj.get("epoch"));
        Long epoch2 = 1548091795000L;
        obj.addProperty("epoch2", epoch2);
        System.out.println("\tObj: " + obj);
//        System.out.println("\tObj: " + obj.get("other").getAsString());

    }
}
