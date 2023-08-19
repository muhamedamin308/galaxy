package com.example.recycleview.adapter;

import static com.example.recycleview.database.classes.Constants.Details.*;
import static com.example.recycleview.database.classes.Constants.Extras.*;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.AddPlanet;
import com.example.recycleview.PlanetDetails;
import com.example.recycleview.database.classes.Planet;
import com.example.recycleview.databinding.ListPlanetBinding;

import java.util.ArrayList;
import java.util.List;

public class AdapterManager extends RecyclerView.Adapter<AdapterManager.ItemsHolder> {
    Context context;
    private List<Planet> gGalaxyList = new ArrayList<>();

    public AdapterManager(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ItemsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListPlanetBinding binding = ListPlanetBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ItemsHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsHolder holder, int position) {
        Planet planet = gGalaxyList.get(position);
        holder.imageView.setImageResource(planet.getImageResource());
        holder.textView1.setText(planet.getText1());
        holder.textView2.setText(planet.getText2());
        holder.content.setOnClickListener(view -> {
            Intent intent = new Intent(context, PlanetDetails.class);
            intent.putExtra(DETAILS_PLANET_IMAGE, planet.getImageResource());
            intent.putExtra(DETAILS_ID, planet.getNumber());
            intent.putExtra(DETAILS_PLANET_NAME, planet.getText1());
            intent.putExtra(DETAILS_DESC_1, planet.getText2());
            intent.putExtra(DETAILS_DESC_2, planet.getDescription());
            intent.putExtra(DETAILS_PLANET_RADIUS, planet.getRadius());
            intent.putExtra(DETAILS_PLANET_LENGTH, planet.getYearLength());
            intent.putExtra(DETAILS_PLANET_TYPE, planet.getType());
            intent.putExtra(DETAILS_PLANET_COLOR, planet.getPlanetColor());
            context.startActivity(intent);
        });
        holder.updateImage.setOnClickListener(view -> {
            Intent intent = new Intent(context, AddPlanet.class);
            intent.putExtra(EXTRA_ID, planet.getNumber());
            intent.putExtra(EXTRA_PLANET_NAME, planet.getText1());
            intent.putExtra(EXTRA_DESC_1, planet.getText2());
            intent.putExtra(EXTRA_DESC_2, planet.getDescription());
            intent.putExtra(EXTRA_PLANET_IMAGE, planet.getImageResource());
            intent.putExtra(EXTRA_PLANET_RADIUS, planet.getRadius());
            intent.putExtra(EXTRA_PLANET_TYPE, planet.getType());
            intent.putExtra(EXTRA_PLANET_LENGTH, planet.getYearLength());
            intent.putExtra(EXTRA_PLANET_COLOR, planet.getPlanetColor());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return gGalaxyList.size();
    }

    public void setGalaxyList(List<Planet> mPlanets) {
        gGalaxyList = mPlanets;
        notifyDataSetChanged();
    }

    public Planet getPlanetAt(int pos) {
        return gGalaxyList.get(pos);
    }

    public static class ItemsHolder extends RecyclerView.ViewHolder {
        public ImageView imageView, updateImage;
        public TextView textView1;
        public TextView textView2;
        public ConstraintLayout content;

        public ItemsHolder(ListPlanetBinding binding) {
            super(binding.getRoot());
            imageView = binding.imageViewId;
            textView1 = binding.planetTitleList;
            textView2 = binding.planetDetails;
            updateImage = binding.editPlanet;
            content = binding.linearCardView;
        }
    }
}