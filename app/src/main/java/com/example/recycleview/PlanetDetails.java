package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class PlanetDetails extends AppCompatActivity {
    TextView planetName, planetDesc, planetRadius, planetLength, planetType;
    TextView tvType, tvRadius, tvLength;
    ImageView planetImage, back;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_details);
        planetImage = findViewById(R.id.imageviewid);
        planetName = findViewById(R.id.planetTitle);
        planetDesc = findViewById(R.id.planetDetails);
        back = findViewById(R.id.imageBack);
        planetType = findViewById(R.id.planetTypeDetails);
        planetLength = findViewById(R.id.planetLengthDetails);
        planetRadius = findViewById(R.id.planetRadiusDetails);
        tvType = findViewById(R.id.tvType);
        tvRadius = findViewById(R.id.tvRadius);
        tvLength = findViewById(R.id.tvLength);

        Intent intent = getIntent();
        int id = Objects.requireNonNull(intent.getExtras()).getInt("id");
        String Title = Objects.requireNonNull(intent.getExtras()).getString("title");
        setTitle(Title + " Details");
        colorsSelection(id);
        String Description = intent.getExtras().getString("Description");
        String desc2 = intent.getExtras().getString("desc");
        int Image = intent.getExtras().getInt("image");
        int radius = intent.getExtras().getInt("radius");
        int length = intent.getExtras().getInt("length");
        String type = intent.getExtras().getString("type");

        planetImage.setImageResource(Image);
        planetName.setText(Title);
        planetDesc.setText(Description + desc2);
        planetType.setText(type);
        planetRadius.setText("" + radius + " in KM");
        planetLength.setText("" + length + " Earth days");

        back.setOnClickListener(view -> finish());
    }

    private void colorsSelection(int id){
        switch (id) {
            case 1: {
                planetName.setTextColor(getResources().getColor(R.color.mercury));
                tvType.setTextColor(getResources().getColor(R.color.mercury));
                tvRadius.setTextColor(getResources().getColor(R.color.mercury));
                tvLength.setTextColor(getResources().getColor(R.color.mercury));
            }
            break;
            case 2: {
                planetName.setTextColor(getResources().getColor(R.color.venus));
                tvType.setTextColor(getResources().getColor(R.color.venus));
                tvRadius.setTextColor(getResources().getColor(R.color.venus));
                tvLength.setTextColor(getResources().getColor(R.color.venus));
            }
            break;
            case 3: {
                planetName.setTextColor(getResources().getColor(R.color.earth));
                tvType.setTextColor(getResources().getColor(R.color.earth));
                tvRadius.setTextColor(getResources().getColor(R.color.earth));
                tvLength.setTextColor(getResources().getColor(R.color.earth));
            }
            break;
            case 4: {
                planetName.setTextColor(getResources().getColor(R.color.mars));
                tvType.setTextColor(getResources().getColor(R.color.mars));
                tvRadius.setTextColor(getResources().getColor(R.color.mars));
                tvLength.setTextColor(getResources().getColor(R.color.mars));
            }
            break;
            case 5: {
                planetName.setTextColor(getResources().getColor(R.color.jupiter));
                tvType.setTextColor(getResources().getColor(R.color.jupiter));
                tvRadius.setTextColor(getResources().getColor(R.color.jupiter));
                tvLength.setTextColor(getResources().getColor(R.color.jupiter));
            }
            break;
            case 6: {
                planetName.setTextColor(getResources().getColor(R.color.saturn));
                tvType.setTextColor(getResources().getColor(R.color.saturn));
                tvRadius.setTextColor(getResources().getColor(R.color.saturn));
                tvLength.setTextColor(getResources().getColor(R.color.saturn));
            }
            break;
            case 7: {
                planetName.setTextColor(getResources().getColor(R.color.uranus));
                tvType.setTextColor(getResources().getColor(R.color.uranus));
                tvRadius.setTextColor(getResources().getColor(R.color.uranus));
                tvLength.setTextColor(getResources().getColor(R.color.uranus));
            }
            break;
            case 8: {
                planetName.setTextColor(getResources().getColor(R.color.neptune));
                tvType.setTextColor(getResources().getColor(R.color.neptune));
                tvRadius.setTextColor(getResources().getColor(R.color.neptune));
                tvLength.setTextColor(getResources().getColor(R.color.neptune));
            }
            break;
            default: {
                planetName.setTextColor(getResources().getColor(R.color.title_font));
                tvType.setTextColor(getResources().getColor(R.color.title_font));
                tvRadius.setTextColor(getResources().getColor(R.color.title_font));
                tvLength.setTextColor(getResources().getColor(R.color.title_font));
            }
        }
    }
}