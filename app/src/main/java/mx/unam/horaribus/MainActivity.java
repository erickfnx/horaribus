package mx.unam.horaribus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void menuruta(View view) {
        Intent objI = new Intent (MainActivity.this,MenuRutasActivity.class);
        startActivity(objI);
    }

    public void reporte(View view) {
        Intent objI = new Intent (MainActivity.this,ReporteActivity.class);
        startActivity(objI);
    }

    public void acerca(View view) {
        Intent objI = new Intent (MainActivity.this,AcercadeActivity.class);
        startActivity(objI);
    }

}
