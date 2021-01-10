package com.example.userapp.ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;


import android.app.Notification;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.userapp.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;



public class HomeFragment extends Fragment {

    private SliderLayout sliderLayout;
    private ImageView map;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        sliderLayout = view.findViewById(R.id.slider);

        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(1);

        setSliderViews();

        map= view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });


        return view;
    }

    private void openMap() {

        Uri uri = Uri.parse("geo:0, 0?q=1205, 64/4 Lake Circus Rd, Dhaka 1205");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }


    private void setSliderViews() {

        for (int i = 0; i< 5; i++){
            DefaultSliderView sliderView = new DefaultSliderView(getContext());
            switch (i){
                case 0:
                    sliderView.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQv3g6RHbF2CkiOzvlb2hySTAkvDAEYEgivVQ&usqp=CAU");
                    break;
                case 1:
                    sliderView.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRsNmJf1isC9W2bfyK9EVsQnZdCLtQQXVrtAw&usqp=CAU");
                    break;
                case 2:
                    sliderView.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ8--4oS4z_uWMGjGE_P5KCqHdR4FTX9ZM6ag&usqp=CAU");
                    break;
                case 3:
                    sliderView.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSaWyoKgLJ5XLmuBNArPhWsBO-382JNuSLZOA&usqp=CAU");
                    break;
                case 4:
                    sliderView.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQAiX2RLBIkGlLVBBvxkG5V_7kPwbBq8JhdCg&usqp=CAU");
                    break;
    }
            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);

            sliderLayout.addSliderView(sliderView);
     }
    }
}