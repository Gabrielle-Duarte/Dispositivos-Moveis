package com.example.app;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.app.R;

public class MainActivity extends AppCompatActivity {

    LocationManager locationManager;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.textView);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        //Verificar se a permissão foi concedida
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            //Pedir a permissão uma vez, isso cria um problema se o usuario não permitir.
            //Se o usuário consegue a permissão acontece isso:
            //Definir proviner
            Location l = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            textView.setText(l.getLatitude()+ "," +l.getLongitude());
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, location ->
                    textView.setText(location.getLatitude() + "," + location.getLongitude()));

        }else{
            //Solicitar permissão em tempo de execução
            requestPermissions(new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
            }, 1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int [] grantResults){
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED);
                }
            }
        }
    }


