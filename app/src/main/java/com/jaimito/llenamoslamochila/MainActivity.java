package com.jaimito.llenamoslamochila;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvPeso;
    CheckBox cbGorras, cbBanadores, cbCamisetas, cbZapatos, cbPantalones, cbLibros;
    Button btnVaciarMochila;

    int pesoTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tvPeso = findViewById(R.id.tvPeso);

        cbGorras = findViewById(R.id.cbGorras);
        cbBanadores = findViewById(R.id.cbBanadores);
        cbCamisetas = findViewById(R.id.cbCamisetas);
        cbZapatos = findViewById(R.id.cbZapatos);
        cbPantalones = findViewById(R.id.cbPantalones);
        cbLibros = findViewById(R.id.cbLibros);
        btnVaciarMochila = findViewById(R.id.btnVaciarMochila);

        cbGorras.setOnCheckedChangeListener((compoundButton, isChecked) -> calcularMochila(isChecked ? 1 : -1));
        cbBanadores.setOnCheckedChangeListener((compoundButton, isChecked) -> calcularMochila(isChecked ? 5 : -5));
        cbCamisetas.setOnCheckedChangeListener((compoundButton, isChecked) -> calcularMochila(isChecked ? 7 : -7));
        cbZapatos.setOnCheckedChangeListener((compoundButton, isChecked) -> calcularMochila(isChecked ? 3 : -3));
        cbPantalones.setOnCheckedChangeListener((compoundButton, isChecked) -> calcularMochila(isChecked ? 8 : -8));
        cbLibros.setOnCheckedChangeListener((compoundButton, isChecked) -> calcularMochila(isChecked ? 10 : -10));

        btnVaciarMochila.setOnClickListener(view -> vaciarMochila());
    }

    private void calcularMochila(int peso) {
        pesoTotal += peso;
        tvPeso.setText("Peso " + pesoTotal + " kg");

        final int PESO_MAXIMO = 20;

        if (pesoTotal > PESO_MAXIMO) {
            tvPeso.setTextColor(Color.RED);
        } else {
            tvPeso.setTextColor(Color.GREEN);
        }


    }

    private void vaciarMochila() {
        cbGorras.setChecked(false);
        cbBanadores.setChecked(false);
        cbCamisetas.setChecked(false);
        cbZapatos.setChecked(false);
        cbPantalones.setChecked(false);
        cbLibros.setChecked(false);
        pesoTotal = 0;
        tvPeso.setText("Peso 0 kg");
    }
}