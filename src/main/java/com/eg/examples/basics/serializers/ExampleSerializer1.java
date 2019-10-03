package com.eg.examples.basics.serializers;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * ExampleSerializer1
 *
 * @author toran
 */
public class ExampleSerializer1 implements Serializable {
    private static final long serialVersionUID = -1940569903675694578L;

    @SerializedName(value = "first_name", alternate= {"first", "name"})
    private String firstName;

    @SerializedName(value = "last_name", alternate = {"last"})
    private transient String lastName;

    public void resolve(){
        System.out.println("\tthis.first_name: " + this.firstName);
        System.out.println("\tthis.last_name: " + this.lastName);
    }
}
