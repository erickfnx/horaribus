package mx.unam.horaribus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MapaSuburbanoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapa_suburbano);
    }

    public void inicio (View view) {
        Intent objI = new Intent (MapaSuburbanoActivity.this,MainActivity.class);
        startActivity(objI);
    }
}
