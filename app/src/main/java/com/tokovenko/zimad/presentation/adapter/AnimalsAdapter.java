package com.tokovenko.zimad.presentation.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.tokovenko.zimad.R;
import com.tokovenko.zimad.domain.model.Animal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AnimalsAdapter extends RecyclerView.Adapter<AnimalsAdapter.AnimalViewHolder> {

    private List<Animal> animalList = new ArrayList<>();
    private OnAnimalClickListener listener;

    @NonNull
    @Override
    public AnimalsAdapter.AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item_animal, parent, false);
        return new AnimalViewHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalsAdapter.AnimalViewHolder holder, int position) {
        holder.bind(animalList.get(position),position);
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    public void setItems(Collection<Animal> animals) {
        animalList.addAll(animals);
        notifyDataSetChanged();
    }

    public void clearItems() {
        animalList.clear();
        notifyDataSetChanged();
    }

    public void setCliclListener(OnAnimalClickListener listener){
        this.listener = listener;
    }

    static class  AnimalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final OnAnimalClickListener listener;

        @BindView(R.id.item)
        ConstraintLayout layout;

        @BindView(R.id.icon)
        ImageView icon;

        @BindView(R.id.position)
        TextView tvPosition;

        @BindView(R.id.text)
        TextView tvText;

        private Animal animal;

        public AnimalViewHolder(@NonNull View itemView, OnAnimalClickListener listener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.listener = listener;
            layout.setOnClickListener(this);
        }

        public void bind(Animal animal, int position){
            this.animal = animal;

            Picasso.get()
                    .load(animal.getUrl())
                    .into(icon);

            tvPosition.setText(Integer.toString(position+1));
            tvText.setText(animal.getTitle());
        }

        @Override
        public void onClick(View v) {
            if (listener != null){
                listener.onAnimalClick(animal);
            }
        }
    }




    public interface OnAnimalClickListener{
        void onAnimalClick(Animal animal);
    }

}
