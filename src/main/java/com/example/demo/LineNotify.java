package com.example.demo;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Objects;
import java.util.stream.Collectors;

public class LineNotify {
    public void line(String itemname,Integer itemnum,Integer itemstock){
    	LineNotify lineNotify = new LineNotify("dMpxcXS26JPCFLR2JyfnTQv6ttj7PWakMDnhQN22Ku9"); // LINE Notifyのアクセストークン(適宜変更)
    	lineNotify.notify(itemname+"が"+itemnum+"点注文されました。在庫は残り"+itemstock+"点です");
        System.out.println("javaからlineへ通知しました。");
    }

    private  String token;
    public LineNotify(String token) {
        this.token = token;
    }

    
    
    public void notify(String message) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL("https://notify-api.line.me/api/notify");
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.addRequestProperty("Authorization", "Bearer " + token);
            try (OutputStream os = connection.getOutputStream();
                 PrintWriter writer = new PrintWriter(os)) {
                writer.append("message=").append(URLEncoder.encode(message, "UTF-8")).flush();
                try (InputStream is = connection.getInputStream();
                     BufferedReader r = new BufferedReader(new InputStreamReader(is))) {
                    String res = r.lines().collect(Collectors.joining());
                    if (!res.contains("\"message\":\"ok\"")) {
                        System.out.println(res);
                    }
                }
            }
        } catch (Exception ignore) {
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}