package mx.unam.horaribus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class IntercampusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intercampus);
    }
    public void mapainter (View view) {
        Intent objI = new Intent (IntercampusActivity.this,MapaIntercampusActivity.class);
        startActivity(objI);
    }
    public void inicio (View view) {
        Intent objI = new Intent (IntercampusActivity.this,MainActivity.class);
        startActivity(objI);
    }
}
