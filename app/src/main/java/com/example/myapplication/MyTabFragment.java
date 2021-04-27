package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.widge.Flower;

public class MyTabFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_item,container,false);
        ImageView imageView = view.findViewById(R.id.tab_item_iv);
        TextView textView = view.findViewById(R.id.tab_item_tv);
        if (getArguments() != null) {
            Flower flower = getArguments().getParcelable("flower");
            imageView.setImageResource(flower.getImageId());
            textView.setText(flower.getName());
        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
