package com.example.recycleview;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.adapter.AdapterManager;
import com.example.recycleview.database.viewmodel.GalaxyViewModel;
import com.example.recycleview.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private GalaxyViewModel mGalaxyViewModel;
    private AdapterManager adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle(R.string.app_name);

        Toast.makeText(MainActivity.this, "Click on any item to more details.", Toast.LENGTH_SHORT).show();
        binding.recyclerview.setHasFixedSize(false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new AdapterManager(MainActivity.this);
        binding.recyclerview.setLayoutManager(layoutManager);
        binding.recyclerview.setAdapter(adapter);

        mGalaxyViewModel = ViewModelProviders.of(this).get(GalaxyViewModel.class);
        mGalaxyViewModel.getmAllData().observe(this, galaxyClasses -> adapter.setGalaxyList(galaxyClasses));

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int pos = viewHolder.getAdapterPosition();
                mGalaxyViewModel.deleteV(adapter.getPlanetAt(pos));
            }
        }).attachToRecyclerView(binding.recyclerview);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater m = getMenuInflater();
        m.inflate(R.menu.menu2, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.addItem) {
            Intent intent = new Intent(MainActivity.this, AddPlanet.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}