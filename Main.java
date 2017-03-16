package com.transit;

import com.google.gson.*;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.security.MessageDigest;
import java.util.List;
import java.util.Map;

public class Main {
    @SerializedName("content")
    static String content;
    @SerializedName("created_at")
    static String createdAt;
    @SerializedName("planned_start_at")
    static String plannedStartAt;
    @SerializedName("planned_end_at")
    static String plannedEndAt;

    public static ServiceAlerts serviceAlerts;
    static byte[] resultToHash = new byte[0];
    static byte[] hashedContent = new byte[0];
    static MessageDigest md = null;


    public static void main(String[] args) {
        try {
            JsonReader reader = new JsonReader(new FileReader("/Users/maprangsuwanbubpa/Downloads/transit/ServiceAlerts_input.json"));
            Map<String, Object> rootJson = new Gson().fromJson(reader, Map.class);

            // Route 1
            //System.out.println(((Map)((List)((Map)(rootJson.get("service_alerts"))).get("1")).get(0)).get("content"));
            content = ((Map)((List)((Map)(rootJson.get("service_alerts"))).get("1")).get(0)).get("content").toString();
            //System.out.println(((Map)((List)((Map)(rootJson.get("service_alerts"))).get("1")).get(0)).get("created_at"));
            createdAt = ((Map)((List)((Map)(rootJson.get("service_alerts"))).get("1")).get(0)).get("created_at").toString();
//            System.out.println(((Map)((List)((Map)(rootJson.get("service_alerts"))).get("1")).get(0)).get("planned_start_at"));
//            plannedStartAt = ((Map)((List)((Map)(rootJson.get("service_alerts"))).get("1")).get(0)).get("planned_start_at").toString();
//            System.out.println(((Map)((List)((Map)(rootJson.get("service_alerts"))).get("1")).get(0)).get("planned_end_at"));
//            plannedEndAt = ((Map)((List)((Map)(rootJson.get("service_alerts"))).get("1")).get(0)).get("planned_end_at").toString();

            resultToHash = serviceAlerts.addToByteBuffer(content,createdAt);

            md = MessageDigest.getInstance("MD5");
            hashedContent = md.digest(resultToHash);

            System.out.println("MD5 hash content Route 1: " + hashedContent);


            // Route 2
            while (reader.hasNext()) {

                //System.out.println(((Map)((List)((Map)(rootJson.get("service_alerts"))).get("2")).get(0)).get("content"));
                content = ((Map)((List)((Map)(rootJson.get("service_alerts"))).get("2")).get(0)).get("content").toString();
                //System.out.println(((Map)((List)((Map)(rootJson.get("service_alerts"))).get("2")).get(0)).get("create_at"));
                createdAt = ((Map)((List)((Map)(rootJson.get("service_alerts"))).get("2")).get(0)).get("created_at").toString();
                //System.out.println(((Map)((List)((Map)(rootJson.get("service_alerts"))).get("2")).get(0)).get("planned_start_at"));
                //plannedStartAt = ((Map)((List)((Map)(rootJson.get("service_alerts"))).get("2")).get(0)).get("planned_start_at").toString();
                //System.out.println(((Map)((List)((Map)(rootJson.get("service_alerts"))).get("2")).get(0)).get("planned_end_at"));
                //plannedEndAt = ((Map)((List)((Map)(rootJson.get("service_alerts"))).get("2")).get(0)).get("planned_end_at").toString();

                resultToHash = serviceAlerts.addToByteBuffer(content,createdAt);

                md = MessageDigest.getInstance("MD5");
                hashedContent = md.digest(resultToHash);

                System.out.println("MD5 hash content Route 2: " + hashedContent);
            }
            reader.endObject();
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
