package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {
    private String context;
    private IOMessageOnClick listener;
    public MyFragment() { }

    public MyFragment(String result) {
        context = result;
    }

    public interface IOMessageOnClick{
        public void onClick(String context);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (IOMessageOnClick)context;
    }

    public static MyFragment newInstance(String context) {
        Bundle args = new Bundle();
        args.putString("content",context);
        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my,container,false);
        TextView textView = view.findViewById(R.id.fg_tv);
        Button fg_btn = view.findViewById(R.id.button_rg);
        //        textView.setText(context);

        if(getArguments() != null){
            textView.setText(getArguments().getString("content"));
        }
        fg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(getArguments().getString("content"));
            }
        });
        return view;
    }
}
