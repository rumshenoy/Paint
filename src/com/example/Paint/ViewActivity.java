package com.example.Paint;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Base64;
import android.widget.ImageView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;

/**
 * Created by ramyashenoy on 12/10/14.
 */
public class ViewActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        if(getIntent().getExtras() != null){
            String imageToLoad = getIntent().getExtras().getString("fileToLoad");
            ImageView imageView = (ImageView) findViewById(R.id.imageView);
            try {
                Bitmap bitmapToSet = receiveFile("10.0.2.2", 6066, imageToLoad);
                imageView.setImageBitmap(bitmapToSet);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Bitmap receiveFile(String serverIp, int serverPort, String fileName) throws IOException {
        Socket sock = new Socket(serverIp, serverPort);
        DataOutputStream dataOutputStream = new DataOutputStream(sock.getOutputStream());
        dataOutputStream.write(new String("retrieve:" + fileName + ":").getBytes());
        sock.shutdownOutput();


        DataInputStream dataInputStream = new DataInputStream(sock.getInputStream());
        int count = sock.getReceiveBufferSize();
        byte[] buffer = new byte[count];
        dataInputStream.read(buffer);

        Bitmap bitmap = BitmapFactory.decodeByteArray(buffer, 0, buffer.length);

        System.out.println(Arrays.toString(buffer));
        sock.close();
        return bitmap;
    }
}