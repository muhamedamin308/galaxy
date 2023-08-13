package com.example.recycleview;

import static com.example.recycleview.database.Constants.DESC1_IN_RECORD;
import static com.example.recycleview.database.Constants.DESC2_IN_RECORD;
import static com.example.recycleview.database.Constants.EXTRA_DESC_1;
import static com.example.recycleview.database.Constants.EXTRA_DESC_2;
import static com.example.recycleview.database.Constants.EXTRA_ID;
import static com.example.recycleview.database.Constants.EXTRA_PLANET_IMAGE;
import static com.example.recycleview.database.Constants.EXTRA_PLANET_LENGTH;
import static com.example.recycleview.database.Constants.EXTRA_PLANET_NAME;
import static com.example.recycleview.database.Constants.EXTRA_PLANET_RADIUS;
import static com.example.recycleview.database.Constants.EXTRA_PLANET_TYPE;
import static com.example.recycleview.database.Constants.TITLE_IN_RECORD;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.recycleview.database.AddPlanetViewModel;
import com.example.recycleview.database.Planet;
import com.example.recycleview.databinding.ActivityAddPlanetBinding;

import java.util.ArrayList;
import java.util.Objects;

public class AddPlanet extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private final int selectPhoto = 4;
    private AddPlanetViewModel mViewModel;
    private int mID;
    private String planetTypeSelected;
    private boolean editMode;
    private ActivityAddPlanetBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddPlanetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Objects.requireNonNull(getSupportActionBar()).setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        Intent i = getIntent();

        if (i.hasExtra(EXTRA_ID)) {

            setTitle(R.string.update_planet);
            binding.change.setVisibility(View.INVISIBLE);
            binding.fixedType.setVisibility(View.VISIBLE);
            binding.planetType.setVisibility(View.INVISIBLE);
            editMode = true;

            mID = i.getIntExtra(EXTRA_ID, -1);
            binding.planetName.setText(i.getStringExtra(EXTRA_PLANET_NAME));
            binding.planetDesc1.setText(i.getStringExtra(EXTRA_DESC_1));
            binding.planetDesc2.setText(i.getStringExtra(EXTRA_DESC_2));
            binding.planetRadius.setText(String.valueOf(i.getIntExtra(EXTRA_PLANET_RADIUS, -1)));
            binding.planetLengthYearAddPlanet.setText(String.valueOf(i.getIntExtra(EXTRA_PLANET_LENGTH, -1)));
            planetTypeSelected = i.getStringExtra(EXTRA_PLANET_TYPE);
            binding.fixedType.setText(planetTypeSelected);

            int image = Objects.requireNonNull(i.getExtras()).getInt(EXTRA_PLANET_IMAGE);
            binding.planetImageResource.setImageResource(image);
            prepareMic();
        } else {
            setTitle(R.string.add_planet);
            editMode = false;
            prepareMic();
            binding.change.setOnClickListener(view -> {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, selectPhoto);
            });
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planet_type, R.layout.spinner_item);
            adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            binding.planetType.setAdapter(adapter);
            binding.planetType.setOnItemSelectedListener(this);
        }
        mViewModel = ViewModelProviders.of(this).get(AddPlanetViewModel.class);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        planetTypeSelected = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater m = getMenuInflater();
        m.inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.saveItem) {
            savePlanet();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {

        if (requestCode == TITLE_IN_RECORD && resultCode == RESULT_OK) {
            assert intent != null;
            ArrayList<String> matches = intent.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            assert matches != null;
            binding.planetName.setText(matches.get(0));
        } else if (requestCode == DESC1_IN_RECORD && resultCode == RESULT_OK) {
            assert intent != null;
            ArrayList<String> matches = intent.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            assert matches != null;
            binding.planetDesc1.setText(matches.get(0));
        } else if (requestCode == DESC2_IN_RECORD && resultCode == RESULT_OK) {
            assert intent != null;
            ArrayList<String> matches = intent.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            assert matches != null;
            binding.planetDesc2.setText(matches.get(0));
        } else if (requestCode == selectPhoto && resultCode == RESULT_OK && intent != null && intent.getData() != null) {
            binding.planetImageResource.setImageURI(intent.getData());
        }
        super.onActivityResult(requestCode, resultCode, intent);
    }

    public void savePlanet() {
        String planetName = binding.planetName.getText().toString();
        String planetDesc1 = binding.planetDesc1.getText().toString();
        String planetDesc2 = binding.planetDesc2.getText().toString();
        String planetRadius = binding.planetRadius.getText().toString();
        int radius = Integer.parseInt(planetRadius);
        String planetLength = binding.planetLengthYearAddPlanet.getText().toString();
        int length = Integer.parseInt(planetLength);

        if (planetName.isEmpty() || planetDesc1.isEmpty() || planetDesc2.isEmpty() || planetRadius.isEmpty() || planetLength.isEmpty() || planetTypeSelected.isEmpty()) {
            Toast.makeText(AddPlanet.this, "Please Fill All Fields!!", Toast.LENGTH_LONG).show();
        }
        if (editMode) {
            Intent intent = getIntent();
            int Image = Objects.requireNonNull(intent.getExtras()).getInt(EXTRA_PLANET_IMAGE);
            binding.planetImageResource.setImageResource(Image);
            Planet planet = new Planet(Image, planetName, planetDesc1, planetDesc2, radius, planetTypeSelected, length);
            planet.setNumber(mID);
            mViewModel.updateAV(planet);
        } else {
            mViewModel.insertAV(new Planet(R.drawable.unknown, planetName, planetDesc1, planetDesc2, radius, planetTypeSelected, length));
        }
        finish();
    }

    private void prepareMic() {
        binding.mic.setOnClickListener(view -> {
            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Add the planet name !!");
            startActivityForResult(intent, TITLE_IN_RECORD);
        });
        binding.micDesc.setOnClickListener(view -> {
            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Add the planet description 1 !!");
            startActivityForResult(intent, DESC1_IN_RECORD);
        });
        binding.micDesc2.setOnClickListener(view -> {
            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Add the planet description 2 !!");
            startActivityForResult(intent, DESC2_IN_RECORD);
        });
    }
}