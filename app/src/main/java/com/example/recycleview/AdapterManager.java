package com.example.recycleview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import static com.example.recycleview.database.Constants.*;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.database.Planet;

import java.util.ArrayList;
import java.util.List;

public class AdapterManager extends RecyclerView.Adapter<AdapterManager.ItemsHolder> {
    private List<Planet> gGalaxyList=new ArrayList<>();
    Context context;

    public AdapterManager (Context context){
        this.context = context;
    }
    public static class ItemsHolder extends RecyclerView.ViewHolder{
        public ImageView imageView, updateImage;
        public TextView textView1;
        public TextView textView2;
        public ConstraintLayout content;
        public ItemsHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageviewid);
            textView1 = itemView.findViewById(R.id.planetTitleList);
            textView2 = itemView.findViewById(R.id.planetDetails);
            updateImage = itemView.findViewById(R.id.editPlanet);
            content = itemView.findViewById(R.id.linearCardView);
        }
    }
    @NonNull
    @Override
    public ItemsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_planet , parent, false);
        return new ItemsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsHolder holder, int position) {
        Planet planet = gGalaxyList.get(position);
        holder.imageView.setImageResource(planet.getImageResource());
        holder.textView1.setText(planet.getText1());
        holder.textView2.setText(planet.getText2());
        holder.content.setOnClickListener(view -> {
            Intent intent = new Intent(context, PlanetDetails.class);
            intent.putExtra("image", planet.getImageResource());
            intent.putExtra("id", planet.getNumber());
            intent.putExtra("title", planet.getText1());
            intent.putExtra("Description", planet.getText2());
            intent.putExtra("number" , planet.getNumber());
            intent.putExtra("desc",planet.getDescription());
            intent.putExtra("radius", planet.getRadius());
            intent.putExtra("length", planet.getYearLength());
            intent.putExtra("type", planet.getType());
            context.startActivity(intent);
        });
        holder.updateImage.setOnClickListener(view -> {
            Intent intent = new Intent(context , AddPlanet.class);
            intent.putExtra(EXTRA_ID, planet.getNumber());
            intent.putExtra(EXTRA_PLANET_NAME, planet.getText1());
            intent.putExtra(EXTRA_DESC_1, planet.getText2());
            intent.putExtra(EXTRA_DESC_2, planet.getDescription());
            intent.putExtra(EXTRA_PLANET_IMAGE, planet.getImageResource());
            intent.putExtra(EXTRA_PLANET_RADIUS, planet.getRadius());
            intent.putExtra(EXTRA_PLANET_TYPE, planet.getType());
            intent.putExtra(EXTRA_PLANET_LENGTH, planet.getYearLength());
            context.startActivity(intent);
        });
    }
    @Override
    public int getItemCount() {
        return gGalaxyList.size();
    }
    public void setGalaxyList(List<Planet> mPlanets){
        gGalaxyList = mPlanets;
        notifyDataSetChanged();
    }
    public Planet getPlanetAt (int pos){
        return gGalaxyList.get(pos);
    }
}