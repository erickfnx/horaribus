package mx.unam.horaribus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MapaIntercampusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapa_intercampus);
    }

    public void inicio (View view) {
        Intent objI = new Intent (MapaIntercampusActivity.this,MainActivity.class);
        startActivity(objI);
    }
}
