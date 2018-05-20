package mx.unam.horaribus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SuburbanoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.suburbano);
    }
    public void mapasubur (View view) {
        Intent objI = new Intent (SuburbanoActivity.this,MapaSuburbanoActivity.class);
        startActivity(objI);
    }
    public void inicio (View view) {
        Intent objI = new Intent (SuburbanoActivity.this,MainActivity.class);
        startActivity(objI);
    }
}
