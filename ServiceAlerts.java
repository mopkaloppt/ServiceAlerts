package com.transit;

import com.google.gson.annotations.SerializedName;

import java.io.*;
import java.security.*;
//import javax.json.stream.JsonParser;


/**
 * Created by maprangsuwanbubpa on 17-03-16.
 */
public class ServiceAlerts  {
//    @SerializedName("content")
//    String content;
//    @SerializedName("created_at")
//    String createdAt;
//    @SerializedName("planned_start_at")
//    String plannedStartAt;
//    @SerializedName("planned_end_at")
//    String plannedEndAt;

    private String content;
    private String created_at;
    private String planned_start_at;
    private String planned_end_at;

// It is about setting the start date of the MTA ServiceAlerts using the ServiceChanges that we manually define.
// So that Weekender alert stop beeing always "in the future"

    public  String getContent() {
        return this.content;
    }

    public String getCreatedAt() {
        return this.created_at;
    }

    public String getPlannedStartAt(){
        return this.planned_start_at;
    }

    public void setPlannedStartAt(String startValue) {
        this.planned_start_at = startValue;
    }

    public String getPlannedEndAt() {
        return this.planned_end_at;
    }

    public void setPlannedEndAt(String endValue) {
        this.planned_end_at = endValue;
    }

    public static byte[] addToByteBuffer(String content, String createdAt) {
        byte[] bytesOfMessage = new byte[0];

        try {
            byte[] contentBytes = content.getBytes("UTF-8");
            byte[] createAtBytes = createdAt.getBytes("UTF-8");
            //byte[] plannedStartAtBytes = plannedStartAt.getBytes("UTF-8");
            //byte[] plannedEndAtBytes = plannedEndAt.getBytes("UTF-8");

            bytesOfMessage = new byte[contentBytes.length + createAtBytes.length];
            /*
              Copy each byte[] into one byte[] to be used for security hash
              Method signature: System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
            */
            System.arraycopy(contentBytes, 0, bytesOfMessage, 0, contentBytes.length);
            System.arraycopy(createAtBytes, 0,bytesOfMessage, contentBytes.length, createAtBytes.length);
            //System.arraycopy(plannedStartAtBytes, 0, bytesOfMessage, createAtBytes.length, plannedStartAtBytes.length);
            //System.arraycopy(plannedEndAtBytes, 0, bytesOfMessage, plannedStartAtBytes.length, plannedEndAtBytes.length);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return bytesOfMessage;
    }

    public static byte[] hashContent(byte[] bytesOfMessage) {

        byte[] hashedContent = new byte[0];
        try {
            final MessageDigest md = MessageDigest.getInstance("MD5");
            hashedContent = md.digest(bytesOfMessage);

            System.out.println("MD5 hash content: " + hashedContent);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashedContent;
    }

}
