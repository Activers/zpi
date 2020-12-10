package com.example.zpi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private static final String TAG = "RecyclerView";

    private Context mContext;
    private ArrayList<AnimalModel> animalModelList;
    private OnItemClickedListener mListener;

    public interface OnItemClickedListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickedListener listener) {
        mListener = listener;
    }

    public RecyclerAdapter(Context mContext, ArrayList<AnimalModel> animalModelList) {
        this.mContext = mContext;
        this.animalModelList = animalModelList;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item_animal_profile,parent,false);

        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textViewPetName.setText(animalModelList.get(position).getAnimalName());
        holder.textViewPetType.setText(animalModelList.get(position).getAnimalType());
    }

    @Override
    public int getItemCount() {
        return animalModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView textViewPetName;
        TextView textViewPetType;
        ImageView imageViewPetAvatar;

        public ViewHolder(@NonNull View itemView, final OnItemClickedListener listener) {
            super(itemView);

            textViewPetName = itemView.findViewById(R.id.textViewPetName);
            textViewPetType = itemView.findViewById(R.id.textViewPetType);
            imageViewPetAvatar = itemView.findViewById(R.id.imageViewPetAvatar);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });


        }
    }
}
