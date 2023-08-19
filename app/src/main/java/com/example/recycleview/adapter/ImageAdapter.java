package com.example.recycleview.adapter;

import static com.example.recycleview.database.classes.Constants.Select.*;

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
import com.example.recycleview.database.classes.Images;
import com.example.recycleview.databinding.ListImagesBinding;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageHolder> {
    public Context context;
    private ArrayList<Images> images = new ArrayList<>();

    public ImageAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListImagesBinding binding = ListImagesBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new ImageHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageHolder holder, int position) {
        Images images1 = images.get(position);
        holder.imageName.setText(images1.getName());
        holder.imageResource.setImageResource(images1.getImage());
        holder.image.setOnClickListener(view -> {
            Intent in = new Intent(context, AddPlanet.class);
            in.putExtra(SELECT_IMAGE_ID, images1.getImage());
            in.putExtra(SELECT_IMAGE_COLOR, images1.getColor());
            in.putExtra(IMAGE_ID, images1.getId());
            context.startActivity(in);
        });

    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public void setList(ArrayList<Images> list) {
        this.images = list;
    }

    public Images getImageAt(int pos) {
        return images.get(pos);
    }

    public static class ImageHolder extends RecyclerView.ViewHolder {
        public TextView imageName;
        public ImageView imageResource;
        public ConstraintLayout image;

        public ImageHolder(ListImagesBinding binding) {
            super(binding.getRoot());
            imageName = binding.imageName;
            imageResource = binding.imageId;
            image = binding.imageCardView;
        }
    }
}
