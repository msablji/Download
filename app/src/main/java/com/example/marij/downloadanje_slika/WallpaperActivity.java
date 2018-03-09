package com.example.marij.downloadanje_slika;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.ArrayList;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class WallpaperActivity extends AppCompatActivity {
    ArrayList<Bitmap> bitmaps = new ArrayList<Bitmap>();

    public int i;
    public int current = 1;

    final static String[] URL = {

            "https://files.vladstudio.com/joy/tardigrade/wall/vladstudio_tardigrade_480x320.jpg",

            "https://files.vladstudio.com/joy/eternity/wall/vladstudio_eternity_480x320.jpg",

            "https://files.vladstudio.com/joy/sonya_flies_to_paris/wall/vladstudio_sonya_flies_to_paris_480x320.jpg",

            "https://files.vladstudio.com/joy/christmas_shooting_star/wall/vladstudio_christmas_shooting_star_480x320.jpg",

            "https://files.vladstudio.com/joy/full_moon/wall/vladstudio_full_moon_480x320.jpg",

            "https://files.vladstudio.com/joy/witch/wall/vladstudio_witch_480x320.jpg",

            "https://files.vladstudio.com/joy/home/wall/vladstudio_home_480x320.jpg",

            "https://files.vladstudio.com/joy/drums/wall/vladstudio_drums_480x320.jpg",

            "https://files.vladstudio.com/joy/selfie/wall/vladstudio_selfie_480x320.jpg",

            "https://files.vladstudio.com/joy/14_owls/wall/vladstudio_14_owls_480x320.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper);

        for(i = 0;i < 10;++i) new DownloadImageTask().execute(URL[i]);

    }

    private InputStream OpenHttpConnection(String urlString)
            throws IOException
    {
        InputStream in = null;
        int response = -1;

        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();

        if (!(conn instanceof HttpURLConnection))
            throw new IOException("Not an HTTP connection");
        try{
            HttpURLConnection httpConn = (HttpURLConnection) conn;
            httpConn.setAllowUserInteraction(false);
            httpConn.setInstanceFollowRedirects(true);
            httpConn.setRequestMethod("GET");
            httpConn.connect();
            response = httpConn.getResponseCode();
            if (response == HttpURLConnection.HTTP_OK) {
                in = httpConn.getInputStream();
            }
        }
        catch (Exception ex)
        {
            Log.d("Networking", ex.getLocalizedMessage());
            throw new IOException("Error connecting");
        }
        return in;
    }

    private Bitmap DownloadImage(String URL)
    {
        Bitmap bitmap = null;
        InputStream in = null;
        try {
            in = OpenHttpConnection(URL);
            bitmap = BitmapFactory.decodeStream(in);
            in.close();
        } catch (IOException e1) {
            Log.d("NetworkingActivity", e1.getLocalizedMessage());
        }
        return bitmap;
    }


    private class DownloadImageTask extends AsyncTask<String, Void,
                Bitmap> {
        protected Bitmap doInBackground(String... urls) {
            return DownloadImage(urls[0]);
        }

        protected void onPostExecute(Bitmap result) {
            ImageView img;

            switch (current){
                case 0:
                    img = (ImageView) findViewById(R.id.img1);
                    img.setImageBitmap(result);
                    break;
                case 1:
                    img = (ImageView) findViewById(R.id.img2);
                    img.setImageBitmap(result);
                    break;
                case 2:
                    img = (ImageView) findViewById(R.id.img3);
                    img.setImageBitmap(result);
                    break;
                case 3:
                    img = (ImageView) findViewById(R.id.img4);
                    img.setImageBitmap(result);
                    break;
                case 4:
                    img = (ImageView) findViewById(R.id.img5);
                    img.setImageBitmap(result);
                    break;
                case 5:
                    img = (ImageView) findViewById(R.id.img6);
                    img.setImageBitmap(result);
                    break;
                case 6:
                    img = (ImageView) findViewById(R.id.img7);
                    img.setImageBitmap(result);
                    break;
                case 7:
                    img = (ImageView) findViewById(R.id.img8);
                    img.setImageBitmap(result);
                    break;
                case 8:
                    img = (ImageView) findViewById(R.id.img9);
                    img.setImageBitmap(result);
                    break;
                case 9:
                    img = (ImageView) findViewById(R.id.img10);
                    img.setImageBitmap(result);
                    break;
            }

            current++;

        }
    }
}
