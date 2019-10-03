package com.eg.examples.basics.serializers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ExampleSerializer7
 *
 * @author toran
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExampleSerializer7 implements Serializable {
    private static final long serialVersionUID = 2456944780480887327L;
    private Long epoch;

    public void resolve(){
        System.out.println("\tepoch: " + this.epoch);
    }
}
