package com.example.recycleview;

import static com.example.recycleview.database.Constants.DETAILS_DESC_1;
import static com.example.recycleview.database.Constants.DETAILS_DESC_2;
import static com.example.recycleview.database.Constants.DETAILS_ID;
import static com.example.recycleview.database.Constants.DETAILS_PLANET_IMAGE;
import static com.example.recycleview.database.Constants.DETAILS_PLANET_LENGTH;
import static com.example.recycleview.database.Constants.DETAILS_PLANET_NAME;
import static com.example.recycleview.database.Constants.DETAILS_PLANET_RADIUS;
import static com.example.recycleview.database.Constants.DETAILS_PLANET_TYPE;
import static com.example.recycleview.database.Constants.LENGTH;
import static com.example.recycleview.database.Constants.RADIUS;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recycleview.databinding.ActivityPlanetDetailsBinding;

import java.util.ArrayList;
import java.util.Objects;

public class PlanetDetails extends AppCompatActivity {
    private ActivityPlanetDetailsBinding binding;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlanetDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        int id = Objects.requireNonNull(intent.getExtras()).getInt(DETAILS_ID);
        String Title = Objects.requireNonNull(intent.getExtras()).getString(DETAILS_PLANET_NAME);
        setTitle(Title + " Details");
        colorsSelection(id);
        String Description = intent.getExtras().getString(DETAILS_DESC_2);
        String desc2 = intent.getExtras().getString(DETAILS_DESC_1);
        int Image = intent.getExtras().getInt(DETAILS_PLANET_IMAGE);
        int radius = intent.getExtras().getInt(DETAILS_PLANET_RADIUS);
        int length = intent.getExtras().getInt(DETAILS_PLANET_LENGTH);
        String type = intent.getExtras().getString(DETAILS_PLANET_TYPE);

        binding.imageViewId.setImageResource(Image);
        binding.planetTitle.setText(Title);
        binding.planetDetails.setText(Description + desc2);
        binding.planetTypeDetails.setText(type);
        binding.planetRadiusDetails.setText(RADIUS(radius));
        binding.planetLengthDetails.setText(LENGTH(length));

        binding.imageBack.setOnClickListener(view -> finish());
    }

    private void colorsSelection(int id) {
        ArrayList<TextView> IDs = new ArrayList<>();
        IDs.add(binding.planetTitle);
        IDs.add(binding.tvType);
        IDs.add(binding.tvRadius);
        IDs.add(binding.tvLength);
        int i = 0;
        switch (id) {
            case 1: {
                while (i < IDs.size()) {
                    IDs.get(i).setTextColor(getResources().getColor(R.color.mercury));
                    i++;
                }
            }
            break;
            case 2: {
                while (i < IDs.size()) {
                    IDs.get(i).setTextColor(getResources().getColor(R.color.venus));
                    i++;
                }
            }
            break;
            case 3: {
                while (i < IDs.size()) {
                    IDs.get(i).setTextColor(getResources().getColor(R.color.earth));
                    i++;
                }
            }
            break;
            case 4: {
                while (i < IDs.size()) {
                    IDs.get(i).setTextColor(getResources().getColor(R.color.mars));
                    i++;
                }
            }
            break;
            case 5: {
                while (i < IDs.size()) {
                    IDs.get(i).setTextColor(getResources().getColor(R.color.jupiter));
                    i++;
                }
            }
            break;
            case 6: {
                while (i < IDs.size()) {
                    IDs.get(i).setTextColor(getResources().getColor(R.color.saturn));
                    i++;
                }
            }
            break;
            case 7: {
                while (i < IDs.size()) {
                    IDs.get(i).setTextColor(getResources().getColor(R.color.uranus));
                    i++;
                }
            }
            break;
            case 8: {
                while (i < IDs.size()) {
                    IDs.get(i).setTextColor(getResources().getColor(R.color.neptune));
                    i++;
                }
            }
            break;
            default: {
                while (i < IDs.size()) {
                    IDs.get(i).setTextColor(getResources().getColor(R.color.title_font));
                    i++;
                }
            }
        }
    }
}