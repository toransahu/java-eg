package com.eg.examples.basics.serializers;

import java.io.Serializable;

/**
 * ExampleSerializer4
 *
 * @author toran
 */
public class ExampleSerializer4 implements Serializable {
    private static final long serialVersionUID = 1231929967199345483L;

    // not setting value/alternate using @SerializedName;
    transient private String name;   // should fetch "name"


    public void resolve(){
        System.out.println("\tname: " + name);
    }
}
