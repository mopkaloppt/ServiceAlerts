package com.transit;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.security.MessageDigest;
import java.util.List;
import java.util.Map;

public class Main {

    public static ServiceAlerts serviceAlerts;

    static byte[] resultToHash = new byte[0];
    static byte[] hashedContent = new byte[0];
    static MessageDigest md = null;


    public static void main(String[] args) {
        String content;
        String createAt;
        String plannedStartAt;
        String plannedEndAt;

        try {
            JsonReader reader = new JsonReader(new FileReader("/Users/maprangsuwanbubpa/Downloads/transit/ServiceAlerts_input.json"));
            Map<String, Object> rootJson = new Gson().fromJson(reader, Map.class);

            // Route 1
            /*System.out.println(((Map)((List)((Map)(rootJson.get("service_alerts"))).get("1")).get(0)).get("content"));
            content = ((Map)((List)((Map)(rootJson.get("service_alerts"))).get("1")).get(0)).get("content").toString();
            System.out.println(((Map)((List)((Map)(rootJson.get("service_alerts"))).get("1")).get(0)).get("create_at"));
            createAt = ((Map)((List)((Map)(rootJson.get("service_alerts"))).get("1")).get(0)).get("create_at").toString();
            System.out.println(((Map)((List)((Map)(rootJson.get("service_alerts"))).get("1")).get(0)).get("planned_start_at"));
            plannedStartAt = ((Map)((List)((Map)(rootJson.get("service_alerts"))).get("1")).get(0)).get("planned_start_at").toString();
            System.out.println(((Map)((List)((Map)(rootJson.get("service_alerts"))).get("1")).get(0)).get("planned_end_at"));
            plannedEndAt = ((Map)((List)((Map)(rootJson.get("service_alerts"))).get("1")).get(0)).get("planned_end_at").toString();
            */

            //resultToHash = serviceAlerts.addToByteBuffer(content,createAt,plannedStartAt,plannedEndAt);
            resultToHash = ((Map)((List)((Map)(rootJson.get("service_alerts"))).get("1")).get(0)).get("content").toString().getBytes("UTF-8");

            md = MessageDigest.getInstance("MD5");
            hashedContent = md.digest(resultToHash);

            System.out.println("MD5 hash content: " + hashedContent);


            // Route 2
            /*while (reader.hasNext()) {
                //System.out.println(((Map)((List)((Map)(rootJson.get("service_alerts"))).get("2")).get(0)).get("content"));
                content = ((Map)((List)((Map)(rootJson.get("service_alerts"))).get("2")).get(0)).get("content").toString();
                //System.out.println(((Map)((List)((Map)(rootJson.get("service_alerts"))).get("2")).get(0)).get("create_at"));
                createAt = ((Map)((List)((Map)(rootJson.get("service_alerts"))).get("2")).get(0)).get("create_at").toString();
                //System.out.println(((Map)((List)((Map)(rootJson.get("service_alerts"))).get("2")).get(0)).get("planned_start_at"));
                plannedStartAt = ((Map)((List)((Map)(rootJson.get("service_alerts"))).get("2")).get(0)).get("planned_start_at").toString();
                //System.out.println(((Map)((List)((Map)(rootJson.get("service_alerts"))).get("2")).get(0)).get("planned_end_at"));
                plannedEndAt = ((Map)((List)((Map)(rootJson.get("service_alerts"))).get("2")).get(0)).get("planned_end_at").toString();

                resultToHash = serviceAlerts.addToByteBuffer(content,createAt,plannedStartAt,plannedEndAt);

                md = MessageDigest.getInstance("MD5");
                hashedContent = md.digest(resultToHash);

                System.out.println("MD5 hash content: " + hashedContent);
            }*/

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
