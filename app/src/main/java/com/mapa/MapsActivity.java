package com.mapa;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

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
        LatLng aguacate = new LatLng(40.3695264,-3.7439179);
        LatLng uni = new LatLng(40.3325364,-3.7675058);
        LatLng leganesCentral = new LatLng(40.3310202,-3.7688045);
        LatLng intercambiadorAluche = new LatLng(40.3851691,-3.7627837);

        mMap.addMarker(new MarkerOptions().position(aguacate).title("Me ves desde aqui :)"));
        mMap.addMarker(new MarkerOptions().position(uni).title("UC3M"));
        mMap.addMarker(new MarkerOptions().position(leganesCentral).title("Leganes Central"));
        mMap.addMarker(new MarkerOptions().position(intercambiadorAluche).title("Intercambiador aluche"));

        // enlazamos los puntos
        PolylineOptions recorrido = new PolylineOptions()
                .add(uni) // P1
                .add(leganesCentral) // P2
                .add(intercambiadorAluche) // P3
                .add(aguacate) // P4
                .color(Color.parseColor("#f44336"));

        mMap.addPolyline(recorrido);

        // ajustamos camara y zoom
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(aguacate,12.0f));

    }
}
