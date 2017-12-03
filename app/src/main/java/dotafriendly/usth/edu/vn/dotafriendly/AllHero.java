package dotafriendly.usth.edu.vn.dotafriendly;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;



public class AllHero extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_hero);


        ImageButton ib1, ib2, ib3, ib4, ib5;

        ib1 = (ImageButton) findViewById(R.id.AbaddonButton);


        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllHero.this, AbaddonInfo.class);
                startActivity(intent);

            }
        });


    }
}
