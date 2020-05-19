package com.example.droidapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.net.URI;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity {
    private String mOrderMessage;
    public static final String ExtraOrderKey = "MyKey for the order";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(ExtraOrderKey, mOrderMessage);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
        switch (item.getItemId()) {
            case R.id.action_order:
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(ExtraOrderKey, mOrderMessage);
                startActivity(intent);
                return true;
            case R.id.action_call:
                Uri uri = Uri.parse("tel:+254702635515");
                Intent myintent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(myintent);
                return true;

            case R.id.action_Location:
//                Uri navigationIntentUri = Uri.parse("google.navigation:q=" + 12f +"," + 2f);//creating intent with latlng
                Intent mapIntent = new Intent(Intent.ACTION_VIEW);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
                return true;
            case R.id.action_about:
                String url = "https://www.strathmore.edu/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                return true;
            case R.id.action_status:
                String status= "status has been clicked";
               DisplayToast(status);
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    public void DisplayToast(String message) {


        Toast.makeText(this, message, LENGTH_LONG).show();
    }

    public void loadFroyo(View view) {
        mOrderMessage = getString(R.string.Order_Froyo);
        DisplayToast(mOrderMessage);
    }

    public void loadIcecream(View view) {
        mOrderMessage = getString(R.string.Order_Icecream);
        DisplayToast(mOrderMessage);
    }

    public void loadDonut(View view) {
        mOrderMessage = getString(R.string.Order_Donut);
        DisplayToast(mOrderMessage);
    }
}
