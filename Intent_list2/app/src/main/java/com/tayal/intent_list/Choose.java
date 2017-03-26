package com.tayal.intent_list;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;

        import android.view.View;
        import android.widget.Button;


/*
 * A placeholder main activity for this Android App
 * After splash screen is displayed this main acitivity
 * will be shown.
 */
public class Choose extends Activity {
  Button btn1,btn2;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose);
      btn1 = (Button)findViewById(R.id.button2);
        btn2=(Button)findViewById(R.id.button3);



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Choose.this,MainActivity.class);
                startActivity(intent);
            }

        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choose.this,Femalelist.class);
                startActivity(intent);
            }
        });


    }


}

