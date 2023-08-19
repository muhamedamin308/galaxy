package com.example.recycleview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.adapter.ImageAdapter;
import com.example.recycleview.database.classes.Images;
import com.example.recycleview.databinding.ActivitySelectImageBinding;

import java.util.ArrayList;

public class SelectImageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySelectImageBinding binding = ActivitySelectImageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle(R.string.app_image);
        binding.recyclerview.setHasFixedSize(false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        ImageAdapter adapter = new ImageAdapter(SelectImageActivity.this);
        adapter.setList(initializeImages());
        binding.recyclerview.setLayoutManager(layoutManager);
        binding.recyclerview.setAdapter(adapter);
    }

    @NonNull
    private ArrayList<Images> initializeImages() {
        ArrayList<Images> images = new ArrayList<>();
        images.add(new Images("Unknown", R.drawable.unknown, R.color.unKnown, 0));
        images.add(new Images("Asteroid", R.drawable.asteroid, R.color.asteroid, 1));
        images.add(new Images("Jupiter Moon", R.drawable.full_moon, R.color.fullMoon, 2));
        images.add(new Images("Earth Moon", R.drawable.moon, R.color.moon, 3));
        images.add(new Images("Ice Moon", R.drawable.planet, R.color.planet, 4));
        images.add(new Images("Purple Planet", R.drawable.planet_2, R.color.planet2, 5));
        images.add(new Images("Rounded Planet", R.drawable.planet_3, R.color.planet3, 6));
        images.add(new Images("Damaged planet", R.drawable.red_planet, R.color.redPlanet, 7));

        images.add(new Images("Uranus", R.drawable.uranus2, R.color.uranus, 8));
        images.add(new Images("Earth", R.drawable.earth2, R.color.earth, 9));
        images.add(new Images("Mercury", R.drawable.mercury2, R.color.mercury, 10));
        images.add(new Images("Venus", R.drawable.venus2, R.color.venus, 11));
        images.add(new Images("Mars", R.drawable.mars2, R.color.mars, 12));
        images.add(new Images("Jupiter", R.drawable.jupiter2, R.color.jupiter, 13));
        images.add(new Images("Neptune", R.drawable.neptune2, R.color.neptune, 14));
        images.add(new Images("Saturn", R.drawable.saturn2, R.color.saturn, 15));
        return images;
    }
}