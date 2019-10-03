package com.eg.examples.basics.data;

import java.nio.charset.StandardCharsets;

public class All {

    public static void main(String[] args) {
        tryLongDouble();

    }

    public static void tryLongDouble() {
        // double d = 1552995239000;
        double d = 1552995239000.0;
        long l = 1552999212000L;
        d = l;
        System.out.println("Long: " + l);
        System.out.println("Double: " + d);
        long  epochInMilliL = System.currentTimeMillis();
        double epochInMilliD = epochInMilliL;
        System.out.println("epochInMilliL: " + epochInMilliL);
        System.out.println("epochInMilliD: " + epochInMilliD);
        System.out.println("epochInMilliD > Double: " + (epochInMilliD > d));
        System.out.println("epochInMilliL > Double: " + (epochInMilliL > d));

        System.out.println(l < 1552999394000L);
        System.out.println(1552999212000L < 1552999394000L);
        l = 1552999212000L;
        d = 1.852999212E12;
        System.out.println(l < d);



        l = 0L;
        d = l;
        System.out.println(l + " " + d);
        System.out.println("epochInMilliD > Double(0L): " + (epochInMilliD > d));

        d = 1.552995239E13;
        // if(d instanceof double){
        //
        // }
        System.out.println(Double.class.isInstance(d));
        // System.out.println(d.getClass() == Double.class);
        System.out.println(Double.valueOf(d).longValue());

    }

    public static void tryBytesChars() {
        // TODO: java uses Unicode UTF-16 by default
        // Char & Bytes
        char cNewLine = '\n';
        String sNewLine = "\n";
        byte[] bNewLine = sNewLine.getBytes(StandardCharsets.UTF_8);  // TODO: why can't do cNewLine.getBytes()?
        System.out.println("Bytes: " + bNewLine);
        System.out.println("Length: " + bNewLine.length);
        System.out.println("Size: " + bNewLine.length);  // size of a char = length of its bytes
        System.out.println("At 0th Index: " + bNewLine[0]);  // what is 10
        int asciiNewLine = (int) cNewLine;  // TODO: why can't do sNewLine.getBytes() is string is of length 1?
//        int asciiNewLine = cNewLine;  // this also works without casting, but casting is more readable
//        System.out.println("ASCII: " + asciiNewLine);

        // ASCII to char
//        char retrieved = asciiNewLine;  // compilation error this way
        char retrieved = (char) asciiNewLine;  // does not work this way
        System.out.println("ASCII to Char:" + retrieved);


        Boolean test = true;
        try {
            if (test = null) {
                System.out.println("NULL");
            }
        } catch (Exception e) {
            System.out.println(e);
        }


    }

}
