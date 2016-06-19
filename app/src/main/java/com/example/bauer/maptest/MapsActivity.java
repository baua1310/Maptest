package com.example.bauer.maptest;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);




    }

    @Override
    public void onMapReady(GoogleMap map) {
        // Add a marker in Sydney, Australia, and move the camera.

        map.setMapType(GoogleMap.MAP_TYPE_NONE);
        LatLngBounds SCHAERDING = new LatLngBounds(
                new LatLng(48.452018, 13.423420), new LatLng(48.460707, 13.436554));  //southwest, northeast

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(SCHAERDING.getCenter(), 17));
        LatLng schaerding = new LatLng(48.455939, 13.434578);
        map.addMarker(new MarkerOptions().position(schaerding).title("Schärding"));
        map.moveCamera(CameraUpdateFactory.newLatLng(schaerding));

        GroundOverlayOptions newarkMap = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.schaerding))
                .anchor(0, 0)
                .position(new LatLng(48.460707, 13.423420), 962f, 962f);

        GroundOverlay imageOverlay = map.addGroundOverlay(newarkMap);
    }
}

