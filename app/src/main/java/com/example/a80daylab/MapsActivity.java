package com.example.a80daylab;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.a80daylab.databinding.ActivityMapsBinding;

import java.util.Objects;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
        LatLng sydney = new LatLng(-34, 151);
        LatLng moscow = new LatLng(55.755814, 37.617635);
        LatLng paris = new LatLng(48.856651, 2.351691);
        LatLng rio = new LatLng(-22.801122, -43.336894);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Sydney"));
        mMap.addMarker(new MarkerOptions().position(rio).title("Rio"));
        mMap.addMarker(new MarkerOptions().position(moscow).title("Moscow"));
        mMap.addMarker(new MarkerOptions().position(paris).title("Paris"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(@NonNull Marker markerName) {
                String question, city;
                LatLng positionCity = markerName.getPosition();


                mMap.addMarker(new MarkerOptions().position(positionCity).icon(BitmapDescriptorFactory.
                        defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).title("This"));
                Intent intent = new Intent(MapsActivity.this, QuizActivity.class);
                city = markerName.getTitle();
                if (Objects.equals(city, "Moscow")) {
                    question = "В Москве много старинных монастырей. А какой из них самый древний?";
                    intent.putExtra("filenameCity", city);
                    intent.putExtra("filenameQuestions", question);
                    intent.putExtra("filenameAnswer", "Данилов монастырь");
                    intent.putExtra("filenameAnswerButton", "A");
                    startActivity(intent);
                }

                else if (Objects.equals(city, "Sydney")) {
                        question = "Важная достопримечательностей Австралии, расположенная в Сиднее?";
                        intent.putExtra("filenameCity", city);
                        intent.putExtra("filenameQuestions", question);
                        intent.putExtra("filenameAnswer", "Сиднейский оперный театр");
                        intent.putExtra("filenameAnswerButton", "B");
                        startActivity(intent);
                }

                else if (Objects.equals(city, "Rio")) {
                    question = "Какое животное изображено на гербе города?";
                    intent.putExtra("filenameCity", city);
                    intent.putExtra("filenameQuestions", question);
                    intent.putExtra("filenameAnswer", "Белый дельфин");
                    intent.putExtra("filenameAnswerButton", "C");
                    startActivity(intent);
                }

                else if (Objects.equals(city, "Paris")) {
                    question = "Кто похоронен на кладбище Пер - Лашез?";
                    intent.putExtra("filenameCity", city);
                    intent.putExtra("filenameQuestions", question);
                    intent.putExtra("filenameAnswer", "Джим Моррисон");
                    intent.putExtra("filenameAnswerButton", "D");
                    startActivity(intent);
                }
                return true;
            }
        });
    }
}