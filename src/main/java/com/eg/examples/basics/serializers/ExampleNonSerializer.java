package com.eg.examples.basics.serializers;


/**
 * ExampleNonSerializer
 *
 * @author toran
 */
public class ExampleNonSerializer {
    // not setting value/alternate using @SerializedName;
    private transient String name;   // should fetch "name"


    public void resolve(){
        System.out.println("\tname: " + name);
    }
}
