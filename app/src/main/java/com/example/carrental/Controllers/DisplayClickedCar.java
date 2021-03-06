package com.example.carrental.Controllers;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.carrental.Fragments.Bookings;
import com.example.carrental.R;
import com.squareup.picasso.Picasso;

public class DisplayClickedCar extends AppCompatActivity {

    ImageView imageDisplay;
    TextView nameDisplay,manDisplay,ACDisplay,seatsDisplay,mileageDisplay,priceDisplay;
    Button btnBook;
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_clicked_car);

        actionBar=getSupportActionBar();
        actionBar.setTitle("Car Rentals");
        actionBar.setSubtitle("Car Details");

        imageDisplay=findViewById(R.id.displayCarImage);
        nameDisplay=findViewById(R.id.displayCarName);
        manDisplay=findViewById(R.id.displayCarMan);
        ACDisplay=findViewById(R.id.displayCarAC);
        seatsDisplay=findViewById(R.id.displayCarSeats);
        mileageDisplay=findViewById(R.id.displayCarMileage);
        priceDisplay=findViewById(R.id.displayCarPrice);
        btnBook=findViewById(R.id.bookCar);

        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToBookings=new Intent(DisplayClickedCar.this, Bookings.class);
                startActivity(goToBookings);
            }
        });

        Bundle bundle=getIntent().getExtras();

        if (bundle!=null)
        {
            nameDisplay.setText(bundle.getString("carName"));
            manDisplay.setText(bundle.getString("carMan"));
            ACDisplay.setText(bundle.getString("carAC"));
            seatsDisplay.setText(bundle.getString("carSeats"));
            mileageDisplay.setText(bundle.getString("carMileage"));
            priceDisplay.setText(bundle.getString("carPrice"));

            String image=bundle.getString("carImageName");
            Picasso.with(this).load(image).into(imageDisplay);
        }

    }
}
