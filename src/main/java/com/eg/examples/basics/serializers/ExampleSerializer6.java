package com.eg.examples.basics.serializers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ExampleSerializer6
 *
 * @author toran
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExampleSerializer6 implements Serializable {
    private static final long serialVersionUID = 2456944780480887327L;
    transient private String firstName;

    public void resolve(){
        System.out.println("\tname: " + this.firstName);
    }
}
