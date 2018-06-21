package com.example.den.lesson2.Fragments;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.den.lesson2.Holders.ViewHolderCar;
import com.example.den.lesson2.Items.Car;
import com.example.den.lesson2.R;

import java.util.ArrayList;

public class FragmentGallery extends Fragment {


    View mainView;

    public FragmentGallery() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainView = inflater.inflate(R.layout.fragment_fragment_gallery, container, false);
        setupGallery(mainView);
        return mainView;
    }

    private void setupGallery(View contentView) {
        Resources res = getResources();
        final String[] carsNameArray = res.getStringArray(R.array.car_types);

        final ArrayList<Car> carsList = new ArrayList<Car>();

        for (int i = 0; i < carsNameArray.length; i++) {
            String carName = carsNameArray[i];
            int resourceId =  this.getResources().getIdentifier(carName.toLowerCase(), "drawable", getContext().getPackageName());
            Drawable carImage = getResources().getDrawable(resourceId);
            Car newCar = new Car(carName, carImage);
            carsList.add(newCar);
        }

        ArrayAdapter<Car> carsAdapter =
                new ArrayAdapter<Car>(getContext(), 0, carsList) {
                    @Override
                    public View getView(int position,
                                        View convertView,
                                        ViewGroup parent) {
                        Car currentCar = carsList.get(position);
                        // Inflate only once
                        if (convertView == null) {
                            convertView = getLayoutInflater()
                                    .inflate(R.layout.item_car, null, false);
                        }

                        ViewHolderCar viewHolder = new ViewHolderCar();
                        viewHolder.carNameTextView =
                                (TextView) convertView.findViewById(R.id.name);
                        viewHolder.carImageView =
                                (ImageView) convertView.findViewById(R.id.imageView);

                        convertView.setTag(viewHolder);

                        TextView carName=
                                ((ViewHolderCar) convertView.getTag()).carNameTextView;
                        ImageView carImageView=
                                ((ViewHolderCar) convertView.getTag()).carImageView;


                        carName.setText(currentCar.name);
                        carImageView.setImageDrawable(currentCar.carImageDrawable);

                        return convertView;

                    }
                };

        GridView cheeseGrid = contentView.findViewById(R.id.gridView);
        cheeseGrid.setNumColumns(2);
        cheeseGrid.setColumnWidth(40);
        cheeseGrid.setVerticalSpacing(20);
        cheeseGrid.setHorizontalSpacing(20);
        cheeseGrid.setAdapter(carsAdapter);

        cheeseGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int position, long rowId) {

                // Generate a message based on the position
                String message = "You clicked on " + carsList.get(position).name;

                Toast toast = Toast.makeText(getContext(), message, Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
