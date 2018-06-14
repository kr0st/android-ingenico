package com.example.den.lesson3;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.layout_streets);
//
//        Spinner spinner = (Spinner) findViewById(R.id.car_types);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.car_types, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//
//        spinner.setOnItemSelectedListener(this);
//
//
//        ListView listView = (ListView) findViewById(R.id.listView);
//
//        Resources res = getResources();
//        final String[] streets = res.getStringArray(R.array.streets_array);
//
//        ArrayAdapter<String> cheeseAdapter =
//                new ArrayAdapter<String>(this,
//                        R.layout.item,
//                        R.id.cheese_name,
//                        streets
//                );
////        LIST VIEW
//        listView.setAdapter(cheeseAdapter);
//
//    }


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        Spinner spinner = (Spinner) findViewById(R.id.planets_spinner);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.planets_array, android.R.layout.simple_spinner_item);
//
//        spinner.setAdapter(adapter);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        spinner.setOnItemSelectedListener(this);
//
//    };

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        Resources res = getResources();
        String[] items = res.getStringArray(R.array.planets_array);

        Toast toast = Toast.makeText(this, items[pos], Toast.LENGTH_SHORT);
        toast.show();
    }
//
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
////        Resources res = getResources();
////        final String[] cheeses = res.getStringArray(R.array.car_types);
//
//
//        final String[] cheeses = {
//                "Parmesan",
//                "Ricotta",
//                "Fontina",
//                "Mozzarella",
//                "Cheddar"
//        };
//
//        ArrayAdapter<String> cheeseAdapter =
//                new ArrayAdapter<String>(this,
//                        R.layout.item,
//                        R.id.cheese_name,
//                        cheeses
//                );
//
////      LIST VIEW
////        ListView cheeseList = new ListView(this);
////        setContentView(cheeseList);
////        cheeseList.setAdapter(cheeseAdapter);
//
//
////      GRID VIEW
//        GridView cheeseGrid = new GridView(this);
//        setContentView(cheeseGrid);
//
//        cheeseGrid.setNumColumns(3);
//        cheeseGrid.setColumnWidth(60);
//        cheeseGrid.setVerticalSpacing(20);
//        cheeseGrid.setHorizontalSpacing(20);
//
//        cheeseGrid.setAdapter(cheeseAdapter);
////
//
//        cheeseGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView,
//                                    View view, int position, long rowId) {
//
//                // Generate a message based on the position
//                String message = "You clicked on " + cheeses[position];
//
//                Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
//                toast.show();
//            }
//        });
//
//    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        final Cheese[] cheesesAdvanced = {
//                new Cheese("Parmesan", "Hard, granular cheese"),
//                new Cheese("Ricotta", "Italian whey cheese"),
//                new Cheese("Fontina", "Italian cow's milk cheese"),
//                new Cheese("Mozzarella", "Southern Italian buffalo milk cheese"),
//                new Cheese("Cheddar", "Firm, cow's milk cheese")
//        };
//
//        ArrayAdapter<Cheese> cheeseAdapterAdvanced =
//                new ArrayAdapter<Cheese>(this, 0, cheesesAdvanced) {
//                    @Override
//                    public View getView(int position,
//                                        View convertView,
//                                        ViewGroup parent) {
//                        Cheese currentCheese = cheesesAdvanced[position];
//                        // Inflate only once
//                        if (convertView == null) {
//                            convertView = getLayoutInflater()
//                                    .inflate(R.layout.custom_item, null, false);
//                        }
//
//                        if(convertView.getTag() == null) {
//                            ViewHolder viewHolder = new ViewHolder();
//                            viewHolder.cheeseName = convertView.findViewById(R.id.cheese_name);
//                            viewHolder.cheeseDescription = convertView.findViewById(R.id.cheese_description);
//                            convertView.setTag(viewHolder);
//                        }
//
//                        TextView cheeseName =
//                                ((ViewHolder) convertView.getTag()).cheeseName;
//                        TextView cheeseDescription =
//                                ((ViewHolder) convertView.getTag()).cheeseDescription;
//
//                        cheeseName.setText(currentCheese.name);
//                        cheeseDescription.setText(currentCheese.description);
//
//                        return convertView;
//
//                    }
//                };
//
//        GridView cheeseGrid = new GridView(this);
//        setContentView(cheeseGrid);
//        cheeseGrid.setNumColumns(2);
//        cheeseGrid.setColumnWidth(60);
//        cheeseGrid.setVerticalSpacing(20);
//        cheeseGrid.setHorizontalSpacing(20);
//        cheeseGrid.setAdapter(cheeseAdapterAdvanced);
//
//        cheeseGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView,
//                                    View view, int position, long rowId) {
//
//                // Generate a message based on the position
//                String message = "You clicked on " + cheesesAdvanced[position].name;
//
//                Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
//                toast.show();
//            }
//        });
//
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Resources res = getResources();
        final String[] carsNameArray = res.getStringArray(R.array.car_types);

        final ArrayList<Car> carsList = new ArrayList<Car>();

        for (int i = 0; i < carsNameArray.length; i++) {
            String carName = carsNameArray[i];
            int resourceId =  this.getResources().getIdentifier(carName.toLowerCase(), "drawable", getPackageName());
            Drawable carImage = getResources().getDrawable(resourceId);
            Car newCar = new Car(carName, carImage);
            carsList.add(newCar);
        }


        ArrayAdapter<Car> carsAdapter =
                new ArrayAdapter<Car>(this, 0, carsList) {
                    @Override
                    public View getView(int position,
                                        View convertView,
                                        ViewGroup parent) {
                        Car currentCar = carsList.get(position);
                        // Inflate only once
                        if (convertView == null) {
                            convertView = getLayoutInflater()
                                    .inflate(R.layout.custom_item_img, null, false);
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

        GridView cheeseGrid = new GridView(this);
        setContentView(cheeseGrid);
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

                Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }
}
