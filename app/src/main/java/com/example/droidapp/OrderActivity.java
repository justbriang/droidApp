package com.example.droidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent intent = getIntent();
        String getOrder = intent.getStringExtra(MainActivity.ExtraOrderKey);
        TextView orderDisplay = findViewById(R.id.Display_order);
        orderDisplay.setText(getOrder);
    }

    public void DisplayToast(String message) {


        Toast.makeText(this, message, LENGTH_LONG).show();
    }

    public void onRadioButtonClicked(View view) {
        boolean checked=((RadioButton)view).isChecked();
        switch(view.getId()) {
            case R.id.Delivery_SameDay:

                if(checked){
                    DisplayToast(getString(R.string.same_day_messenger_service));
                }
            break;
            case R.id.Delivery_NextDay:
                if(checked){
                    DisplayToast(getString(R.string.next_day_ground_service));
                }
                break;
            case R.id.Delivery_Pickup:
                if(checked){
                    DisplayToast(getString(R.string.pick_up));
                }
                break;

        }
    }
}
