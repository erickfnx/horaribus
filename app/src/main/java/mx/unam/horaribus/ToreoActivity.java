package mx.unam.horaribus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ToreoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toreo);
    }

    public void mapatoreo (View view) {
        Intent objI = new Intent (ToreoActivity.this,MapaToreoActivity.class);
        startActivity(objI);
    }
    public void inicio (View view) {
        Intent objI = new Intent (ToreoActivity.this,MainActivity.class);
        startActivity(objI);
    }
}
