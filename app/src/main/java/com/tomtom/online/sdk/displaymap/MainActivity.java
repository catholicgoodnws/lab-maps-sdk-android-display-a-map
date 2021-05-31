package com.tomtom.online.sdk.displaymap;

// Add here the TomtomMap import
import com.tomtom.online.sdk.map.MapView;

// Add here the OnMapReadyCallback import
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
// Add here the NonNull import
import javax.annotation.Nonnull;


public class MainActivity extends AppCompatActivity implements OnMapReadyCallback
// Implement here the MainActivity with OnMapReadyCallback
{
  // Add here the TomtomMap member
  private TomtomMap map;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    
    //added
    MapFragment mapFragment = (MapFragment) getSupportFragmentManager().findFragmentById(R.id.mapFragment);
    if(mapFragment != null) {
    mapFragment.getAsyncMap(this);
}
  }

  // Add here the onMapReady callback
  @Override
  public void onMapReady(@NonNull TomtomMap tomtomMap) {
    this.map = tomtomMap;
    LatLng amsterdam = new LatLng(52.37, 4.90);
    SimpleMarkerBalloon balloon = new SimpleMarkerBalloon("Amsterdam");
    tomtomMap.addMarker(new MarkerBuilder(amsterdam).markerBalloon(balloon));
    tomtomMap.centerOn(CameraPosition.builder().focusPosition(amsterdam).zoom(7.0).build());
}
}
