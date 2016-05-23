package com.example.bijesh.mycollege10;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.android.effectivenavigation.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    Switch switchbtn;
    LatLng nobel = new LatLng(27.690455, 85.332060);
    LatLng uniglobe = new LatLng(27.689823, 85.339808);
    LatLng morgan = new LatLng( 27.739230, 85.327573);
    LatLng Liverpool = new LatLng(27.687638, 85.334100);
    LatLng madan = new LatLng(27.689068, 85.327953);
    LatLng Ambition = new LatLng(27.689068, 85.327953);
    LatLng Baneshwor = new LatLng(27.689053, 85.347579);
    LatLng Himalayan = new LatLng(27.695786, 85.335489);
    LatLng sagarmatha = new LatLng(27.703794, 85.329331);
    LatLng trinity = new LatLng(27.703842, 85.325056);
    LatLng global = new LatLng(27.703871, 85.340202);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_maps);
        setUpMapIfNeeded();
        switchbtn=(Switch)findViewById(R.id.switch1);
        switchbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(switchbtn.isChecked()){
                    mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

                }else
                {
                    mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                }
            }
        });

        if (mMap!=null) {
            //to enable own location
            mMap.setMyLocationEnabled(true);
            //to change view
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

            //to chnge the setting..
            UiSettings mapSettings;
            mapSettings=mMap.getUiSettings();
            mapSettings.setZoomControlsEnabled(true);
            mapSettings.setRotateGesturesEnabled(true);
//            direction=new LatLng(27.7150087,85.3122711);
//            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(direction,10));

//            Marker marker=mMap.addMarker(new MarkerOptions()
//            .position(direction)
//                    .title("NIIT")
//                    .snippet("44600, Jamal" +
//                            "Kantipath, Kathmandu")
//            );


        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.mapsmall);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(nobel, 15));

       // mMap.animateCamera(nobel,10);

        mMap.addMarker(new MarkerOptions().position(nobel).title("Nobel Academy").icon(icon));
        mMap.addMarker(new MarkerOptions().position(uniglobe).title("Uniglobe College").icon(icon));
        mMap.addMarker(new MarkerOptions().position(morgan).title("Morgan International").icon(icon));
        mMap.addMarker(new MarkerOptions().position(Liverpool).title("Liverpool College").icon(icon));
        mMap.addMarker(new MarkerOptions().position(madan).title("Madan Bhandari Memorial College").icon(icon));
        mMap.addMarker(new MarkerOptions().position(Ambition).title("Ambition College").icon(icon));
        mMap.addMarker(new MarkerOptions().position(Baneshwor).title("Baneshowr Multiple Campus").icon(icon));
        mMap.addMarker(new MarkerOptions().position(Himalayan).title("Himalayan Whitehouse College").icon(icon));
        mMap.addMarker(new MarkerOptions().position(sagarmatha).title("Sagarmatha College").icon(icon));
        mMap.addMarker(new MarkerOptions().position(trinity).title("Trinity College").icon(icon));
        mMap.addMarker(new MarkerOptions().position(global).title("Global College").icon(icon));


    }
}
