package com.example.internetconnectionpoc;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView SSIDTV = findViewById(R.id.SSIDTV);
        TextView frequencyTV = findViewById(R.id.frequencyTV);
        TextView securityTV = findViewById(R.id.securityTV);

        SSIDTV.setText("");
        frequencyTV.setText("");
        securityTV.setText("");

        Button mainBTN = findViewById(R.id.mainBTN);
        mainBTN.setOnClickListener(view ->
        {
            if (isConnected())
            {
                Toast.makeText(getApplicationContext(), "Connected to internet", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Not connected to internet", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @SuppressLint("NewApi")
    public boolean isConnected()
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if(networkInfo != null)
        {
            if(networkInfo.isConnected())
            {
                getCurrentSsid(this);
                return true;
            }
            else { return false; }
        }
        else { return false; }
    }

    @SuppressLint("NewApi")
    @RequiresApi(api = Build.VERSION_CODES.Q)
    public void getCurrentSsid(Context context)
    {
        TextView SSIDTV = findViewById(R.id.SSIDTV);
        TextView frequencyTV = findViewById(R.id.frequencyTV);
        TextView securityTV = findViewById(R.id.securityTV);

        ConnectivityManager connManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        if (networkInfo.isConnected())
        {
            WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();

            if (connectionInfo != null && !TextUtils.isEmpty(connectionInfo.getSSID()))
            {
                SSIDTV.setText(connectionInfo.getSSID());
                frequencyTV.setText(String.valueOf(connectionInfo.getFrequency()) + " Hz");
                securityTV.setText(String.valueOf(connectionInfo.getIpAddress()));
            }
        }
    }
}