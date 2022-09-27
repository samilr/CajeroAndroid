package com.example.tarea3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText txtNumero;
    TextView txtResult;
    FrameLayout layoutInicio;
    Button btnNegro, btnBlanco, btnGris, btnDarkGris;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Inicial();
    }

    public void Inicial() {
        txtNumero = findViewById(R.id.txtNumero);
        txtResult = findViewById(R.id.txtResult);
        layoutInicio = findViewById(R.id.layoutInicio);
        btnNegro = findViewById(R.id.btnNegro);
        btnBlanco = findViewById(R.id.btnBlanco);
        btnGris = findViewById(R.id.btnGris);
        btnDarkGris = findViewById(R.id.btnDarkGris);
    }

    public boolean dispatchKeyEvent (KeyEvent event){
        int action, keyCode;
        action = event.getAction();
        keyCode = event.getKeyCode();

        if (txtNumero.getText().length() < 1){
            txtResult.setText("Por favor ingrese un numero");
        }else {

            switch (keyCode){
                case KeyEvent.KEYCODE_VOLUME_UP:{
                    if (KeyEvent.ACTION_UP==action){
                        int billetesCien, billetesCincuenta, billetesVente, monedasDiez, monedasCinco, residuoCien, residuoCiencuenta, residuoVente, residuoDiez;
                        int numeroIntroducido = Integer.parseInt(txtNumero.getText().toString());
                        residuoCien = numeroIntroducido % 100;
                        residuoCiencuenta = residuoCien % 50;
                        residuoVente = residuoCiencuenta % 20;
                        residuoDiez = residuoVente % 10;
                        monedasCinco = residuoDiez / 5;
                        monedasDiez = residuoVente / 10;
                        billetesVente = residuoCiencuenta / 20;
                        billetesCincuenta = residuoCien / 50;
                        billetesCien = numeroIntroducido / 100;

                        for (int i = 1; i == 1; i++) {
                            if (numeroIntroducido / 100 >= 1) {
                                if (residuoCien / 50 >= 1){
                                    if (residuoCien / 50 >= 1 && residuoCien % 50 <= 9 && residuoCien % 50 != 0) {
                                        txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCien) + " Papeletas de 100 \n" + String.valueOf(billetesCincuenta) + " Papeletas de 50 \n" + String.valueOf(monedasCinco) + " monedas de 5\n");
                                        break;
                                    }
                                    if (residuoDiez >= 5 && residuoVente < 10) {
                                        txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCien) + " Papeletas de 100 \n" + String.valueOf(billetesCincuenta) + " Papeletas de 50 \n" + String.valueOf(billetesVente)
                                                + " Papeletas de 20\n" + String.valueOf(monedasCinco) + " monedas de 5\n");
                                        break;
                                    }
                                    if (residuoCien / 50 >= 1 && residuoCien % 50 >= 10 && residuoCiencuenta < 20) {
                                        if (residuoDiez / 5 >= 1) {
                                            txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCien) + " Papeletas de 100 \n" + String.valueOf(billetesCincuenta) + " Papeletas de 50 \n" + String.valueOf(monedasDiez) + " monedas de 10\n" + String.valueOf(monedasCinco) + " monedas de 5\n");
                                            break;
                                        }
                                        txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCien) + " Papeletas de 100 \n" + String.valueOf(billetesCincuenta) + " Papeletas de 50 \n" + String.valueOf(monedasDiez) + " monedas de 10\n");
                                        break;
                                    }
                                }
                                if (numeroIntroducido % 100 >= 50) {
                                    if (residuoCien % 50 >= 20) {
                                        if (residuoCiencuenta % 20 >= 10) {
                                            if (residuoVente % 10 >= 5) {
                                                txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCien) + " Papeletas de 100\n" + String.valueOf(billetesCincuenta) + " Papeleta de 50 \n" + String.valueOf(billetesVente) + " Papeletas de 20\n" + String.valueOf(monedasDiez) + " Moneda de 10\n" + String.valueOf(monedasCinco) + " Moneda de 5");
                                                break;
                                            }
                                            txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCien) + " Papeletas de 100\n" + String.valueOf(billetesCincuenta) + " Papeletas de 50\n" + String.valueOf(billetesVente) + " Papeletas de 20\n" + String.valueOf(monedasDiez) + " Moneda de 10");
                                            break;
                                        }
                                        txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCien) + " Papeletas de 100\n" + String.valueOf(billetesCincuenta) + " Papeletas de 50\n" + String.valueOf(billetesVente) + " Papeletas de 20");
                                        break;
                                    }
                                    txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCien) + " Papeletas de 100\n" + String.valueOf(billetesCincuenta) + " Papeletas de 50");
                                    break;
                                }
                                if (residuoCien / 50 < 1 && residuoCiencuenta >= 20) {

                                    if (residuoCiencuenta / 20 >= 1 && residuoCiencuenta % 20 >= 5 && residuoCiencuenta % 20 < 10) {

                                        txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCien) + " Papeletas de 100 \n" + String.valueOf(billetesVente) + " Papeletas de 20 \n" + String.valueOf(monedasCinco) + " monedas de 5\n");
                                        break;
                                    }

                                    if (residuoCiencuenta % 20 >= 10) {

                                        if (residuoVente % 10 >= 5) {

                                            txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCien) + " Papeletas de 100 \n" + String.valueOf(billetesVente) + " Papeletas de 20 \n" + String.valueOf(monedasDiez) + " monedas de 10\n" + String.valueOf(monedasCinco) + " Monedas de 5");
                                            break;
                                        }
                                        txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCien) + " Papeletas de 100 \n" + String.valueOf(billetesVente) + " Papeletas de 20 \n" + String.valueOf(monedasDiez) + " monedas de 10\n");
                                        break;
                                    }
                                    txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCien) + " Papeletas de 100\n" + String.valueOf(billetesVente) + " Papeletas de 20 \n");
                                    break;
                                }

                                if (residuoCiencuenta / 20 < 1 && residuoVente >= 10) {

                                    if (residuoVente % 10 >= 5) {

                                        txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCien) + " papeletas de 100 \n" + String.valueOf(monedasDiez) + " monedas de 10 \n" + String.valueOf(monedasCinco) + " monedas de 5");
                                        break;
                                    }
                                    txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCien) + " papeletas de 100 \n" + String.valueOf(monedasDiez) + " monedas de 10 \n");
                                    break;
                                }

                                if (residuoVente / 10 < 1 && residuoDiez >= 5) {
                                    txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCien) + " papeletas de 100\n" + String.valueOf(monedasCinco) + " monedas de 5");
                                    break;
                                }

                                txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCien) + " Papeletas de 100");
                            }
                            else if (numeroIntroducido / 100 < 1 && numeroIntroducido >= 50) {
                                if (residuoCien / 50 >= 1 && residuoCien % 50 <= 9 && residuoCien % 50 != 0) {
                                    txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCincuenta) + " Papeletas de 50 \n" + String.valueOf(monedasCinco) + " monedas de 5\n");
                                    break;
                                }
                                if (residuoCien / 50 >= 1 && residuoCiencuenta / 20 >= 1) {
                                    if (residuoVente >= 10) {
                                        if (residuoDiez >= 5 && residuoDiez < 10) {
                                            txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCincuenta) + " Papeletas de 50 \n" + String.valueOf(billetesVente)
                                                    + " Papeletas de 20\n" + String.valueOf(monedasDiez) + " monedas de 10\n" + String.valueOf(monedasCinco) + " monedas de 5\n");
                                            break;
                                        }
                                        txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCincuenta) + " Papeletas de 50 \n" + String.valueOf(billetesVente) + " Papeletas de 20\n" + String.valueOf(monedasDiez) + " monedas de 10\n");
                                        break;
                                    }
                                    if (residuoDiez >= 5 && residuoDiez < 10) {
                                        txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCincuenta) + " Papeletas de 50 \n" + String.valueOf(billetesVente)
                                                + " Papeletas de 20\n" + String.valueOf(monedasCinco) + " monedas de 5\n");
                                        break;
                                    }

                                    txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCincuenta) + " Papeletas de 50 \n" + String.valueOf(billetesVente) + " Papeletas de 20\n");
                                    break;
                                }

                                if (residuoCien / 50 >= 1 && residuoCien % 50 >= 10) {
                                    if (residuoDiez / 5 >= 1) {
                                        txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCincuenta) + " Papeletas de 50 \n" + String.valueOf(monedasDiez) + " monedas de 10\n" + String.valueOf(monedasCinco) + " monedas de 5\n");
                                        break;
                                    }

                                    txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCincuenta) + " Papeletas de 50 \n" + String.valueOf(monedasDiez) + " monedas de 10\n");
                                    break;
                                }

                                if (residuoCien % 50 >= 20) {
                                    if (residuoCiencuenta % 20 >= 10) {
                                        if (residuoVente % 10 >= 5) {
                                            txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCincuenta) + " Papeletas de 50 \n" + String.valueOf(billetesVente) + " Papeletas de 20\n" + String.valueOf(monedasDiez) + " Monedas de 10\n" + String.valueOf(monedasCinco) + " Monedas de 5");
                                            break;
                                        }
                                        txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCincuenta) + " Papeletas de 50 \n" + String.valueOf(billetesVente) + " Papeletas de 20\n" + String.valueOf(monedasDiez) + " Monedas de monedasDiez");
                                        break;
                                    }
                                    txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCincuenta) + " Papeletas de 50 \n" + String.valueOf(billetesVente) + " Papeletas de 20");
                                    break;
                                }
                                txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCincuenta) + " Papeletas de 50");
                                break;
                            }
                            else if (numeroIntroducido / 50 < 1 && numeroIntroducido >= 20) {
                                if (residuoCiencuenta / 20 >= 1 && residuoCiencuenta % 20 >= 5 && residuoCiencuenta % 20 < 10) {
                                    txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesVente) + " Papeletas de 20 \n" + String.valueOf(monedasCinco) + " monedas de 5\n");
                                    break;
                                }
                                if (residuoCiencuenta % 20 >= 10) {
                                    if (residuoVente % 10 >= 5) {
                                        txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesVente) + " Papeletas de 20 \n" + String.valueOf(monedasDiez) + " monedas de 10\n" + String.valueOf(monedasCinco) + " Monedas de 5");
                                        break;
                                    }
                                    txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesVente) + " Papeletas de 20 \n" + String.valueOf(monedasDiez) + " monedas de 10\n");
                                    break;
                                }
                                txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesVente) + " Papeletas de 20");
                                break;
                            }
                            else if (numeroIntroducido / 20 < 1 && numeroIntroducido >= 10) {
                                if (residuoVente % 10 >= 5) {
                                    txtResult.setText("Usted tiene: \n\n" + String.valueOf(monedasDiez) + " monedas de 10 \n" + String.valueOf(monedasCinco) + " monedas de 5");
                                    break;
                                }
                                txtResult.setText("Usted tiene: \n\n" + String.valueOf(monedasDiez) + " Monedas de 10");
                                break;
                            }
                            else if (numeroIntroducido / 10 < 1 && numeroIntroducido >= 5) {
                                txtResult.setText("Usted tiene: \n\n" + String.valueOf(monedasCinco) + " monedas de 5");
                                break;
                            }
                            else {
                                txtResult.setText("ERROR_DE_CAMBIO   'El monto minimo es 5'");
                            }
                        }
                    }
                }
            }
            return super.dispatchKeyEvent(event);
        }
        return super.dispatchKeyEvent(event);
    }
    public void colorBlanco(View view) {
            // set the color to relative layout
            layoutInicio.setBackgroundResource(R.color.white);
            txtNumero.setTextColor(getResources().getColor(R.color.black));
            txtResult.setTextColor(getResources().getColor(R.color.black));
            txtNumero.setBackgroundColor(getResources().getColor(R.color.black));
    }
    public void colorGris(View view) {
        layoutInicio.setBackgroundResource(R.color.gray);
        txtNumero.setTextColor(getResources().getColor(R.color.black));
        txtResult.setTextColor(getResources().getColor(R.color.black));
        txtNumero.setBackgroundColor(getResources().getColor(R.color.black));
    }
    public void colorDarkGris(View view) {
        layoutInicio.setBackgroundResource(R.color.darkGray);
        txtNumero.setTextColor(getResources().getColor(R.color.white));
        txtResult.setTextColor(getResources().getColor(R.color.white));
    }
    public void colorNegro(View view) {
        layoutInicio.setBackgroundResource(R.color.black);
        txtNumero.setTextColor(getResources().getColor(R.color.white));
        txtResult.setTextColor(getResources().getColor(R.color.white));
    }
    public void defaultApp(View view) {
        layoutInicio.setBackgroundResource(R.color.colorDefault);
        txtNumero.setTextColor(getResources().getColor(R.color.white));
        txtResult.setTextColor(getResources().getColor(R.color.white));
        txtNumero.setBackgroundColor(getResources().getColor(R.color.transparent));
    }


}
/*
    public void calcularCambio(View view) {
        int billetesCien, billetesCincuenta, billetesVente, monedasDiez, monedasCinco, residuoCien, residuoCiencuenta, residuoVente, residuoDiez;
        int numeroIntroducido = Integer.parseInt(txtNumero.getText().toString());
        residuoCien = numeroIntroducido % 100;
        residuoCiencuenta = residuoCien % 50;
        residuoVente = residuoCiencuenta % 20;
        residuoDiez = residuoVente % 10;
        monedasCinco = residuoDiez / 5;
        monedasDiez = residuoVente / 10;
        billetesVente = residuoCiencuenta / 20;
        billetesCincuenta = residuoCien / 50;
        billetesCien = numeroIntroducido / 100;

        for (int i = 1; i == 1; i++) {
            if (numeroIntroducido / 100 >= 1) {
                if (residuoCien / 50 >= 1){
                    if (residuoCien / 50 >= 1 && residuoCien % 50 <= 9 && residuoCien % 50 != 0) {
                        txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCien) + " Papeletas de 100 \n" + String.valueOf(billetesCincuenta) + " Papeletas de 50 \n" + String.valueOf(monedasCinco) + " monedas de 5\n");
                        break;
                    }
                    if (residuoDiez >= 5 && residuoVente < 10) {
                        txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCien) + " Papeletas de 100 \n" + String.valueOf(billetesCincuenta) + " Papeletas de 50 \n" + String.valueOf(billetesVente)
                                + " Papeletas de 20\n" + String.valueOf(monedasCinco) + " monedas de 5\n");
                        break;
                    }
                    if (residuoCien / 50 >= 1 && residuoCien % 50 >= 10 && residuoCiencuenta < 20) {
                        if (residuoDiez / 5 >= 1) {
                            txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCien) + " Papeletas de 100 \n" + String.valueOf(billetesCincuenta) + " Papeletas de 50 \n" + String.valueOf(monedasDiez) + " monedas de 10\n" + String.valueOf(monedasCinco) + " monedas de 5\n");
                            break;
                        }
                        txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCien) + " Papeletas de 100 \n" + String.valueOf(billetesCincuenta) + " Papeletas de 50 \n" + String.valueOf(monedasDiez) + " monedas de 10\n");
                        break;
                    }
                }
                if (numeroIntroducido % 100 >= 50) {
                    if (residuoCien % 50 >= 20) {
                        if (residuoCiencuenta % 20 >= 10) {
                            if (residuoVente % 10 >= 5) {
                                txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCien) + " Papeletas de 100\n" + String.valueOf(billetesCincuenta) + " Papeleta de 50 \n" + String.valueOf(billetesVente) + " Papeletas de 20\n" + String.valueOf(monedasDiez) + " Moneda de 10\n" + String.valueOf(monedasCinco) + " Moneda de 5");
                                break;
                            }
                            txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCien) + " Papeletas de 100\n" + String.valueOf(billetesCincuenta) + " Papeletas de 50\n" + String.valueOf(billetesVente) + " Papeletas de 20\n" + String.valueOf(monedasDiez) + " Moneda de 10");
                            break;
                        }
                        txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCien) + " Papeletas de 100\n" + String.valueOf(billetesCincuenta) + " Papeletas de 50\n" + String.valueOf(billetesVente) + " Papeletas de 20");
                        break;
                    }
                    txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCien) + " Papeletas de 100\n" + String.valueOf(billetesCincuenta) + " Papeletas de 50");
                    break;
                }
                if (residuoCien / 50 < 1 && residuoCiencuenta >= 20) {

                    if (residuoCiencuenta / 20 >= 1 && residuoCiencuenta % 20 >= 5 && residuoCiencuenta % 20 < 10) {

                        txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCien) + " Papeletas de 100 \n" + String.valueOf(billetesVente) + " Papeletas de 20 \n" + String.valueOf(monedasCinco) + " monedas de 5\n");
                        break;
                    }

                    if (residuoCiencuenta % 20 >= 10) {

                        if (residuoVente % 10 >= 5) {

                            txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCien) + " Papeletas de 100 \n" + String.valueOf(billetesVente) + " Papeletas de 20 \n" + String.valueOf(monedasDiez) + " monedas de 10\n" + String.valueOf(monedasCinco) + " Monedas de 5");
                            break;
                        }
                        txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCien) + " Papeletas de 100 \n" + String.valueOf(billetesVente) + " Papeletas de 20 \n" + String.valueOf(monedasDiez) + " monedas de 10\n");
                        break;
                    }
                    txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCien) + " Papeletas de 100\n" + String.valueOf(billetesVente) + " Papeletas de 20 \n");
                    break;
                }

                if (residuoCiencuenta / 20 < 1 && residuoVente >= 10) {

                    if (residuoVente % 10 >= 5) {

                        txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCien) + " papeletas de 100 \n" + String.valueOf(monedasDiez) + " monedas de 10 \n" + String.valueOf(monedasCinco) + " monedas de 5");
                        break;
                    }
                    txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCien) + " papeletas de 100 \n" + String.valueOf(monedasDiez) + " monedas de 10 \n");
                    break;
                }

                if (residuoVente / 10 < 1 && residuoDiez >= 5) {
                    txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCien) + " papeletas de 100\n" + String.valueOf(monedasCinco) + " monedas de 5");
                    break;
                }

                txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCien) + " Papeletas de 100");
            }
            else if (numeroIntroducido / 100 < 1 && numeroIntroducido >= 50) {
                if (residuoCien / 50 >= 1 && residuoCien % 50 <= 9 && residuoCien % 50 != 0) {
                    txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCincuenta) + " Papeletas de 50 \n" + String.valueOf(monedasCinco) + " monedas de 5\n");
                    break;
                }
                if (residuoCien / 50 >= 1 && residuoCiencuenta / 20 >= 1) {
                    if (residuoVente >= 10) {
                        if (residuoDiez >= 5 && residuoDiez < 10) {
                            txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCincuenta) + " Papeletas de 50 \n" + String.valueOf(billetesVente)
                                    + " Papeletas de 20\n" + String.valueOf(monedasDiez) + " monedas de 10\n" + String.valueOf(monedasCinco) + " monedas de 5\n");
                            break;
                        }
                        txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCincuenta) + " Papeletas de 50 \n" + String.valueOf(billetesVente) + " Papeletas de 20\n" + String.valueOf(monedasDiez) + " monedas de 10\n");
                        break;
                    }
                    if (residuoDiez >= 5 && residuoDiez < 10) {
                        txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCincuenta) + " Papeletas de 50 \n" + String.valueOf(billetesVente)
                                + " Papeletas de 20\n" + String.valueOf(monedasCinco) + " monedas de 5\n");
                        break;
                    }

                    txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCincuenta) + " Papeletas de 50 \n" + String.valueOf(billetesVente) + " Papeletas de 20\n");
                    break;
                }

                if (residuoCien / 50 >= 1 && residuoCien % 50 >= 10) {
                    if (residuoDiez / 5 >= 1) {
                        txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCincuenta) + " Papeletas de 50 \n" + String.valueOf(monedasDiez) + " monedas de 10\n" + String.valueOf(monedasCinco) + " monedas de 5\n");
                        break;
                    }

                    txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCincuenta) + " Papeletas de 50 \n" + String.valueOf(monedasDiez) + " monedas de 10\n");
                    break;
                }

                if (residuoCien % 50 >= 20) {
                    if (residuoCiencuenta % 20 >= 10) {
                        if (residuoVente % 10 >= 5) {
                            txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCincuenta) + " Papeletas de 50 \n" + String.valueOf(billetesVente) + " Papeletas de 20\n" + String.valueOf(monedasDiez) + " Monedas de 10\n" + String.valueOf(monedasCinco) + " Monedas de 5");
                            break;
                        }
                        txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCincuenta) + " Papeletas de 50 \n" + String.valueOf(billetesVente) + " Papeletas de 20\n" + String.valueOf(monedasDiez) + " Monedas de monedasDiez");
                        break;
                    }
                    txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCincuenta) + " Papeletas de 50 \n" + String.valueOf(billetesVente) + " Papeletas de 20");
                    break;
                }
                txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesCincuenta) + " Papeletas de 50");
                break;
            }
            else if (numeroIntroducido / 50 < 1 && numeroIntroducido >= 20) {
                if (residuoCiencuenta / 20 >= 1 && residuoCiencuenta % 20 >= 5 && residuoCiencuenta % 20 < 10) {
                    txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesVente) + " Papeletas de 20 \n" + String.valueOf(monedasCinco) + " monedas de 5\n");
                    break;
                }
                if (residuoCiencuenta % 20 >= 10) {
                    if (residuoVente % 10 >= 5) {
                        txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesVente) + " Papeletas de 20 \n" + String.valueOf(monedasDiez) + " monedas de 10\n" + String.valueOf(monedasCinco) + " Monedas de 5");
                        break;
                    }
                    txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesVente) + " Papeletas de 20 \n" + String.valueOf(monedasDiez) + " monedas de 10\n");
                    break;
                }
                txtResult.setText("Usted tiene: \n\n" + String.valueOf(billetesVente) + " Papeletas de 20");
                break;
            }
            else if (numeroIntroducido / 20 < 1 && numeroIntroducido >= 10) {
                if (residuoVente % 10 >= 5) {
                    txtResult.setText("Usted tiene: \n\n" + String.valueOf(monedasDiez) + " monedas de 10 \n" + String.valueOf(monedasCinco) + " monedas de 5");
                    break;
                }
                txtResult.setText("Usted tiene: \n\n" + String.valueOf(monedasDiez) + " Monedas de 10");
                break;
            }
            else if (numeroIntroducido / 10 < 1 && numeroIntroducido >= 5) {
                txtResult.setText("Usted tiene: \n\n" + String.valueOf(monedasCinco) + " monedas de 5");
                break;
            }
            else {
                txtResult.setText("ERROR_DE_CAMBIO   'El monto minimo es 5'");
            }
        }
    }*/




















































    /*                if (residuoCiencuenta < 50 && residuoCiencuenta >= 21){
                    vente = residuoCiencuenta / 20;

                    if (residuoVente <= 10){
                        diez = residuoVente / 10;

                        if(residuoDiez <= 5){
                            cinco = residuoDiez / 5;
                            txtResult.setText("Usted tiene: \n\n" + String.valueOf(cien) + " Papeletas de 100\n" + String.valueOf(vente)
                                    + " Papeleta de 20 \n" + String.valueOf(diez) + " Monedas de 10 \n" + String.valueOf(cinco) + " Monedas de 5 \n");
                            break;
                        }
                        txtResult.setText("Usted tiene: \n\n" + String.valueOf(cien) + " Papeletas de 100\n" + String.valueOf(vente)
                                + " Papeleta de 20 \n" + String.valueOf(diez) + " Monedas de 10 \n");
                        break;
                    }
                    txtResult.setText("Usted tiene: \n\n" + String.valueOf(cien) + " Papeletas de 100\n" + String.valueOf(vente) + " Papeleta de 20 \n");
                    break;
                }*/



