package com.example.recycleview;

import static com.example.recycleview.database.classes.Constants.Details.*;
import static com.example.recycleview.database.classes.Constants.LENGTH;
import static com.example.recycleview.database.classes.Constants.RADIUS;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recycleview.databinding.ActivityPlanetDetailsBinding;

import java.util.Objects;

public class PlanetDetails extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.example.recycleview.databinding.ActivityPlanetDetailsBinding binding = ActivityPlanetDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        String Title = Objects.requireNonNull(intent.getExtras()).getString(DETAILS_PLANET_NAME);
        setTitle(Title + " Details");
        String Description = intent.getExtras().getString(DETAILS_DESC_2);
        String desc2 = intent.getExtras().getString(DETAILS_DESC_1);
        int Image = intent.getExtras().getInt(DETAILS_PLANET_IMAGE);
        int radius = intent.getExtras().getInt(DETAILS_PLANET_RADIUS);
        int length = intent.getExtras().getInt(DETAILS_PLANET_LENGTH);
        String type = intent.getExtras().getString(DETAILS_PLANET_TYPE);
        int color = intent.getExtras().getInt(DETAILS_PLANET_COLOR);

        binding.imageViewId.setImageResource(Image);
        binding.planetTitle.setText(Title);
        binding.planetDetails.setText(Description + desc2);
        binding.planetTypeDetails.setText(type);
        binding.planetRadiusDetails.setText(RADIUS(radius));
        binding.planetLengthDetails.setText(LENGTH(length));

        binding.planetTitle.setTextColor(getResources().getColor(color));
        binding.tvType.setTextColor(getResources().getColor(color));
        binding.tvRadius.setTextColor(getResources().getColor(color));
        binding.tvLength.setTextColor(getResources().getColor(color));

        binding.imageBack.setOnClickListener(view -> finish());
    }
}