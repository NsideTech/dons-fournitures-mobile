package com.example.myapplication.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment {

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        private GoogleMap mMap;

        @Override
        public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap;
            LatLng point1 = new LatLng(46.810514210460035, -71.21560626631192);
            LatLng point2 = new LatLng(46.819041120803234, -71.23376069408356);
            LatLng point3 = new LatLng(46.78122290411698, -71.2670317985081);
            LatLng point4 = new LatLng(46.8313379883388, -71.29935064400215);
            LatLng point5 = new LatLng(46.890695660673074, -71.1630922470966);

            mMap.addMarker(new MarkerOptions().position(point1).title("Marker in point1"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(point1));

            mMap.addMarker(new MarkerOptions().position(point2).title("Marker in point2"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(point2));

            mMap.addMarker(new MarkerOptions().position(point3).title("Marker in point3"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(point3));

            mMap.addMarker(new MarkerOptions().position(point4).title("Marker in point4"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(point4));

            mMap.addMarker(new MarkerOptions().position(point5).title("Marker in point5"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(point5));
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}