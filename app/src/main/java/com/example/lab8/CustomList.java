package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }
    /**
     * this gets size of the list
     * @return the size of the list
     */

    public int getCount(){

        return cities.size();

    }

    /**
     * This adds a city to the list if th ecity does not already exist
     * @param city This is a city to add to the list
     */
    public void add(City city){
        if (cities.contains(city)){
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return Return the sorted list
     */
    public List getCities(){
        List list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * When given a city, return whether or not it belongs in the list
     * @param city given to check whether it is on the list
     * @return
     */
    public boolean hasCity(City city){
        if (cities.contains(city)){
            return true;
        }
        return false;
    }

    /**
     * Check if a city is present in the list. If it does then remove it from the list, if not then throw an exception
     * @param city This is the city to be deleted
     */
    public void delete(City city){
        if (cities.contains(city)){
            cities.remove(city);
        } else{
            throw new IllegalArgumentException();
        }
    }

    /**
     * Return how many cities are in the list
     * @return Return cities size
     */
    public  int countCities(){
        return cities.size();
    }


}
