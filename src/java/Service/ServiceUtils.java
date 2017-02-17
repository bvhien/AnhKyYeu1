/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.*;

/**
 *
 * @author BVHIEN
 */
public class ServiceUtils {

    public static String callService(String strUrl, String strMethod, String data) throws JSONException {
        JSONObject jsonReturn = new JSONObject();
        String strReturn = "";
        System.out.println(strUrl);
        try {
            URL url = new URL(strUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            if (strMethod == null) {
                strMethod = "GET";
            }
            conn.setRequestMethod(strMethod);
            if (strMethod.equals("POST") || strMethod.equals("PUT")) {
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setRequestProperty("Accept", "application/json");
                conn.setRequestMethod(strMethod);
            }
            if (strMethod.equals("GET") || strMethod.equals("DELETE")) {
                System.out.println(conn.getResponseCode() != 401);
                if (conn.getResponseCode() != 200 && conn.getResponseCode() != 401) {
                    System.out.println("============");
                    throw new RuntimeException("Failed : HTTP error code : "
                            + conn.getResponseCode());
                }
            } else if (strMethod.equals("POST") || strMethod.equals("PUT")) {
                OutputStream os = conn.getOutputStream();
                os.write(data.toString().getBytes());
                os.flush();

                if (conn.getResponseCode() != 200) {
                    throw new RuntimeException("Failed : HTTP error code : "
                            + conn.getResponseCode());
                }
            }
            InputStream ips = (200 <= conn.getResponseCode() && conn.getResponseCode() <= 299) ? conn.getInputStream() : conn.getErrorStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (ips)));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                strReturn += output;
            }
            System.out.println("---------" + strReturn);
//            jsonReturn = new JSONObject(strReturn);
            conn.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strReturn;
    }

    public static String Decoder(String data) {
        String str = "";
        try {
            str = URLDecoder.decode(data, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ServiceUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return str;
    }

    public static String Encoder(String data) {
        String str = "";
        try {
            str = URLEncoder.encode(data, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ServiceUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return str;
    }

    public static void main(String[] args) {
        String a = "%7B%22TenThamSo%22%3A%22TR%E1%BA%A0NG%20TH%C3%81I%20K%C3%8DCH%20HO%E1%BA%A0T%22%2C%22MaThamSo%22%3A%22TR%E1%BA%A0NG%20TH%C3%81I%20K%C3%8DCH%20HO%E1%BA%A0T%22%2C%22DienGiai%22%3A%22TR%E1%BA%A0NG%20TH%C3%81I%20K%C3%8DCH%20HO%E1%BA%A0T%22%2C%22TrangThai%22%3A%221%22%7D";
        String n = Decoder(a);
        System.out.println("a:" + n);
    }
}
