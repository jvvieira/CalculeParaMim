package com.jvvieira.sosomemaths;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            LinearLayout lComb = (LinearLayout) findViewById(R.id.layoutCombustivel);
            LinearLayout lPG = (LinearLayout) findViewById(R.id.layoutPG);
            ScrollView lFardo = findViewById(R.id.layoutFardo);

            lComb.setVisibility(View.INVISIBLE);
            lPG.setVisibility(View.INVISIBLE);
            lFardo.setVisibility(View.INVISIBLE);
            switch (item.getItemId()) {
                case R.id.navigation_combustivel:
                    lComb.setVisibility(View.VISIBLE);
                    return true;
                case R.id.navigation_fardo:
                    lFardo.setVisibility(View.VISIBLE);
                    return true;
                case R.id.navigation_pack:
                    lPG.setVisibility(View.VISIBLE);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout lComb = (LinearLayout) findViewById(R.id.layoutCombustivel);
        LinearLayout lPG = (LinearLayout) findViewById(R.id.layoutPG);
        ScrollView lFardo = findViewById(R.id.layoutFardo);

        lComb.setVisibility(View.VISIBLE);
        lPG.setVisibility(View.INVISIBLE);
        lFardo.setVisibility(View.INVISIBLE);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void calcCombustivel(View view) {
        EditText kma = findViewById(R.id.txtCombKMA);
        EditText kmb = findViewById(R.id.txtCombKMB);
        EditText vlra = findViewById(R.id.txtCombPrecoA);
        EditText vlrb = findViewById(R.id.txtCombPrecoB);

        Float fkma = Float.parseFloat(kma.getText().toString());
        Float fkmb = Float.parseFloat(kmb.getText().toString());
        Float fvlra = Float.parseFloat(vlra.getText().toString());
        Float fvlrb = Float.parseFloat(vlrb.getText().toString());

        Float compa = fkma / fvlra;
        Float compb = fkmb / fvlrb;

        String msg = "";
        if (compa.equals(compb)) {
            msg = "Tanto faz, são iguais.";
        } else if (compa < compb) {
            msg = "B compensa mais em " + ((compb / compa) - 1) * 100 + "%.";
        } else if (compa > compb) {
            msg = "A compensa mais em " + ((compa / compb) - 1) * 100 + "%.";
        }

        TextView txt = findViewById(R.id.msgCombResult);
        txt.setText(msg);
    }


    public void calcPG(View view) {
        EditText kma = findViewById(R.id.txtPGTamanhoA);
        EditText kmb = findViewById(R.id.txtPGTamanhoB);
        EditText vlra = findViewById(R.id.txtPGPrecoA);
        EditText vlrb = findViewById(R.id.txtPGPrecoB);

        Float fkma = Float.parseFloat(kma.getText().toString());
        Float fkmb = Float.parseFloat(kmb.getText().toString());
        Float fvlra = Float.parseFloat(vlra.getText().toString());
        Float fvlrb = Float.parseFloat(vlrb.getText().toString());

        Float compa = fkma / fvlra;
        Float compb = fkmb / fvlrb;

        String msg = "";
        if (compa.equals(compb)) {
            msg = "Tanto faz, são iguais.";
        } else if (compa < compb) {
            msg = "B compensa mais em " + ((compb / compa) - 1) * 100 + "%.";
        } else if (compa > compb) {
            msg = "A compensa mais em " + ((compa / compb) - 1) * 100 + "%.";
        }

        TextView txt = findViewById(R.id.msgPGResult);
        txt.setText(msg);
    }

    public void calcFardo(View view) {
        EditText sizeA = findViewById(R.id.txtFardoTamanhoA);
        EditText qtdA = findViewById(R.id.txtFardoQTDA);
        EditText vldA = findViewById(R.id.txtFardoPrecoA);
        EditText sizeB = findViewById(R.id.txtFardoTamanhoB);
        EditText qtdB = findViewById(R.id.txtFardoQTDB);
        EditText vldB = findViewById(R.id.txtFardoPrecoB);


        Float fsizeA = Float.parseFloat(sizeA.getText().toString());
        Float fsizeB = Float.parseFloat(sizeB.getText().toString());
        Float fqtdA = Float.parseFloat(qtdA.getText().toString());
        Float fqtdB = Float.parseFloat(qtdB.getText().toString());
        Float fvlrA = Float.parseFloat(vldA.getText().toString());
        Float fvlrB = Float.parseFloat(vldB.getText().toString());

        Float compa = (fsizeA * fqtdA) / fvlrA;
        Float compb = (fsizeB * fqtdB) / fvlrB;

        String msg = "";
        if (compa.equals(compb)) {
            msg = "Tanto faz, são iguais.";
        } else if (compa < compb) {
            msg = "B compensa mais em " + ((compb / compa) - 1) * 100 + "%.";
        } else if (compa > compb) {
            msg = "A compensa mais em " + ((compa / compb) - 1) * 100 + "%.";
        }

        TextView txt = findViewById(R.id.msgFardoResult);
        txt.setText(msg);
    }
}
