package mx.leonet.maps;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MainActivity extends ActionBarActivity {

    private GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            // Cargar mapa
            initilizeMap();

            // Cambiar el tipo de mapa
            // googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            // googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            // googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
            // googleMap.setMapType(GoogleMap.MAP_TYPE_NONE);

            // Mostrar / ocultar tu ubicación
            googleMap.setMyLocationEnabled(true);

            // Mostrar / ocultar los controles del zoom
            googleMap.getUiSettings().setZoomControlsEnabled(true);

            // Mostrar / ocultar boton de localización
            googleMap.getUiSettings().setMyLocationButtonEnabled(true);

            // Mostrar / ocultar icon de compas
            googleMap.getUiSettings().setCompassEnabled(true);

            // Mostrar / ocultar evento de rotar
            googleMap.getUiSettings().setRotateGesturesEnabled(true);

            // Mostrar / ocultar funcionalidad del zoom
            googleMap.getUiSettings().setZoomGesturesEnabled(true);

            /*
            // ROSE color icon
            marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));

            // GREEN color icon
            marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
            */

            double latitude = 18.370955;
            double longitude = -100.679940;

            // crear marker
            MarkerOptions marker = new MarkerOptions().position(new LatLng(latitude, longitude)).title("Instituto Tecnologico de Cd. Altamirano");
            // cambiar color marcardor
            marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
            // agregar marker
            googleMap.addMarker(marker);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        initilizeMap();
    }

    /**
     * funcion para cargar el mapa si el mapa no se ha creado
     *
     * */
    private void initilizeMap() {
        if (googleMap == null) {
            googleMap = ((MapFragment) getFragmentManager().findFragmentById(
                    R.id.map)).getMap();

            // revisa si el mapa se ha creado o no
            if (googleMap == null) {
                Toast.makeText(getApplicationContext(),
                        "Lo siento! No se puede cargar el mapa", Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
