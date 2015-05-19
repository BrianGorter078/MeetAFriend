package com.meetafriend.meetafriend;

import android.content.Intent;
import android.os.AsyncTask;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;

/**
 * Created by briang on 19-5-2015.
 */
public class DatabaseConnection extends AsyncTask{

    static String a;
    static String b;

    @Override
    protected Object doInBackground(Object[] params) {
        ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
        postParameters.add(new BasicNameValuePair("name", a));
        postParameters.add(new BasicNameValuePair("password", b));

//String valid = "1";
        String response = null;
        try {
            response = CustomHttpClient.executeHttpPost("http://boermedia.com/maf/connect.php", postParameters);  //Enetr Your remote PHP,ASP, Servlet file link
            System.out.println("2...");
            String res = response.toString();
            System.out.println("3...");
// res = res.trim();
            res = res.replaceAll("\\s+", "");
//error.setText(res);
            System.out.println("4...");
            if (res.equals("1")) {

                Signin sn = new Signin();
                sn.logins(true);
            }
            else{
                Signin sn = new Signin();
                sn.logins(false);
            }
        } catch (Exception e) {
            System.out.println("TEST...");
            System.out.println(e.toString());
            e.printStackTrace();

        }
        return null;
    }

    public void SetStrings(String c, String d)
    {
        a = c;
        b = d;
    }
}
