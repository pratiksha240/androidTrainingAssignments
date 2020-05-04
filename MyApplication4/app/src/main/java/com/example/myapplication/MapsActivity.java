package com.example.myapplication;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng aundh = new LatLng(18.560465, 73.803004);
        mMap.addMarker(new MarkerOptions().position(aundh).title("Ram Desai"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(aundh, 10F));

        LatLng baner = new LatLng(18.564243, 73.777321);
        mMap.addMarker(new MarkerOptions().position(baner).title("Rakesh Kumar"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(baner, 10F));

        LatLng chinchwad = new LatLng(18.640682, 73.798322);
        mMap.addMarker(new MarkerOptions().position(chinchwad).title("Gopal Patil"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(chinchwad, 10F));

        LatLng bhosari = new LatLng(18.629946, 73.847417);
        mMap.addMarker(new MarkerOptions().position(bhosari).title("Kishor Vani"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bhosari, 10F));

        LatLng kothrud = new LatLng(18.507707, 73.808093);
        mMap.addMarker(new MarkerOptions().position(kothrud).title("Ravindra Gorde"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(kothrud, 10F));

        LatLng wakad = new LatLng(18.593243, 73.757460);
        mMap.addMarker(new MarkerOptions().position(wakad).title("Manoj Tiwari"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(wakad, 10F));

        LatLng mulshi = new LatLng(18.500732, 73.514897);
        mMap.addMarker(new MarkerOptions().position(mulshi).title("Atul Gosavi"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mulshi, 10F));

        LatLng hadapsar = new LatLng(18.506817, 73.928647);
        mMap.addMarker(new MarkerOptions().position(hadapsar).title("Vinayak Shethe"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hadapsar, 10F));
    }
}
