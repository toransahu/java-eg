package com.eg.examples.basics.datetime;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class Timestamps {
    public static void main(String[] args) {
//        String t = "2019-02-01 04:28:31.855447707 +0000 UTC";
          String t = "2019-02-01 13:23:43.7331309 +0000 UTC";
        Long epoch = null;
        // DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd' 'HH:mm:ss.SSSSSSSSS Z z");
        // // SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss.SSSSSSSSS Z z");
        // epoch = OffsetDateTime.parse(t, df).toInstant().toEpochMilli();
        // System.out.println(epoch);
        // System.out.println(new Timestamp(epoch));

        epoch = 1553662176L * 1000;  // without *1000 it gives 1970
        SimpleDateFormat indexFormat = new SimpleDateFormat("yyyyMM");
        System.out.println(indexFormat.format(epoch));
        Timestamp ts = new Timestamp(epoch);
        System.out.println(ts);
    }
}
