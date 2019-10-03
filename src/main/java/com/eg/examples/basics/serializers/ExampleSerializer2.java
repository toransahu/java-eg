package com.eg.examples.basics.serializers;

import java.io.Serializable;

/**
 * ExampleSerializer2
 *
 * @author toran
 */
public class ExampleSerializer2 implements Serializable {
    private static final long serialVersionUID = 2456944780480887327L;
    private String firstName;
    private transient String lastName;

    public ExampleSerializer2(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("\tthis.first_name: " + this.firstName);
        System.out.println("\tthis.last_name: " + this.lastName);
    }
}
