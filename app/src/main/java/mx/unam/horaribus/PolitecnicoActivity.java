package mx.unam.horaribus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PolitecnicoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.politecnico);
    }
    public void mapapoli (View view) {
        Intent objI = new Intent (PolitecnicoActivity.this,MapaPoliActivity.class);
        startActivity(objI);
    }
    public void inicio (View view) {
        Intent objI = new Intent (PolitecnicoActivity.this,MainActivity.class);
        startActivity(objI);
    }
}
