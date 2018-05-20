package mx.unam.horaribus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuRutasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_rutas);
    }

    public void toreo (View view) {
        Intent objI = new Intent (MenuRutasActivity.this,ToreoActivity.class);
        startActivity(objI);
    }
    public void subur (View view) {
        Intent objI = new Intent (MenuRutasActivity.this,SuburbanoActivity.class);
        startActivity(objI);
    }
    public void poli (View view) {
        Intent objI = new Intent (MenuRutasActivity.this,PolitecnicoActivity.class);
        startActivity(objI);
    }
    public void intercampus (View view) {
        Intent objI = new Intent (MenuRutasActivity.this,IntercampusActivity.class);
        startActivity(objI);
    }

}
