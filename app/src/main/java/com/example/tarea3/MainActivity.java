package com.example.tarea3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText txtNumero;
    TextView txtResult;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Inicial();
    }

    public void Inicial(){
        txtNumero = findViewById(R.id.txtNumero);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtResult = findViewById(R.id.txtResult);
    }

    public void calcularCambio(View view) {
        int cien, cincuenta, vente = 0, cinco = 0, diez = 0, residuoCien = 0, residuoCiencuenta = 0, residuoVente = 0, residuoDiez = 0;
        int numeroIntroducido = Integer.parseInt(txtNumero.getText().toString());
        residuoCien = numeroIntroducido % 100;
        residuoCiencuenta = residuoCien % 50;
        residuoVente = residuoCiencuenta % 20;
        residuoDiez = residuoVente % 10;

        for (int i = 1; i == 10 ; i++) {

            if (numeroIntroducido / 100 >= 1) {
                cien = numeroIntroducido / 100;

                if (numeroIntroducido % 100 >= 50) {
                    cincuenta = residuoCien / 50;

                    if (residuoCien % 50 >= 20) {
                        vente = residuoCiencuenta / 20;

                        if (residuoCiencuenta % 20 >= 10) {
                            diez = residuoVente / 10;

                            if (residuoVente % 10 >= 5) {
                                cinco = residuoDiez / 5;
                                txtResult.setText("Usted tiene: \n\n" + String.valueOf(cien) + " Papeletas de 100\n" + String.valueOf(cincuenta) + " Papeleta de 50 \n" + String.valueOf(vente) + " Papeletas de 20\n" + String.valueOf(diez) + " Moneda de 10\n" + String.valueOf(cinco) + " Moneda de 5");
                                break;
                            }
                            txtResult.setText("Usted tiene: \n\n" + String.valueOf(cien) + " Papeletas de 100\n" + String.valueOf(cincuenta) + " Papeletas de 50\n" + String.valueOf(vente) + " Papeletas de 20\n" + String.valueOf(diez) + " Moneda de 10");
                            break;
                        }
                        txtResult.setText("Usted tiene: \n\n" + String.valueOf(cien) + " Papeletas de 100\n" + String.valueOf(cincuenta) + " Papeletas de 50\n" + String.valueOf(vente) + " Papeletas de 20");
                        break;
                    }
                    txtResult.setText("Usted tiene: \n\n" + String.valueOf(cien) + " Papeletas de 100\n" + String.valueOf(cincuenta) + " Papeletas de 50");
                    break;
                }
                txtResult.setText("Usted tiene: \n\n" + String.valueOf(cien) + " Papeletas de 100");


            }

            else if (numeroIntroducido / 100 < 1 && numeroIntroducido >= 50) {

                cincuenta = residuoCien / 50;

                if(residuoCien / 50 >= 1 && residuoCien % 50 <= 9 && residuoCien % 50 != 0){
                    cinco = residuoDiez / 5;

                    txtResult.setText("Usted tiene: \n\n" + String.valueOf(cincuenta) + " Papeletas de 50 \n" + String.valueOf(cinco) + " monedas de 5\n");
                    break;
                }
                if(residuoCien / 50 >= 1 && residuoCiencuenta / 20 >= 1){
                    cinco = residuoDiez / 5;
                    diez = residuoVente / 10;
                    vente = residuoCiencuenta / 20;

                        if (residuoVente >= 10)  {

                            if (residuoDiez >=5 && residuoDiez < 10){
                                txtResult.setText("Usted tiene: \n\n" + String.valueOf(cincuenta) + " Papeletas de 50 \n" + String.valueOf(vente)
                                        + " Papeletas de 20\n" + String.valueOf(diez) + " monedas de 10\n" + String.valueOf(cinco) + " monedas de 5\n");
                                break;
                            }
                            txtResult.setText("Usted tiene: \n\n" + String.valueOf(cincuenta) + " Papeletas de 50 \n" + String.valueOf(vente) + " Papeletas de 20\n" + String.valueOf(diez) + " monedas de 10\n");
                            break;
                        }

                    if (residuoDiez >=5 && residuoDiez < 10)  {
                            txtResult.setText("Usted tiene: \n\n" + String.valueOf(cincuenta) + " Papeletas de 50 \n" + String.valueOf(vente)
                                    + " Papeletas de 20\n" + String.valueOf(cinco) + " monedas de 5\n");
                            break;
                    }

                    txtResult.setText("Usted tiene: \n\n" + String.valueOf(cincuenta) + " Papeletas de 50 \n" + String.valueOf(vente) + " Papeletas de 20\n");
                    break;
                }

                if(residuoCien / 50 >= 1 && residuoCien % 50 >= 10){
                    cinco = residuoDiez / 5;
                    diez = residuoVente / 10;

                    if(residuoDiez / 5 >= 1){
                        txtResult.setText("Usted tiene: \n\n" + String.valueOf(cincuenta) + " Papeletas de 50 \n" + String.valueOf(diez) + " monedas de 10\n" + String.valueOf(cinco) + " monedas de 5\n");
                        break;
                    }

                    txtResult.setText("Usted tiene: \n\n" + String.valueOf(cincuenta) + " Papeletas de 50 \n" + String.valueOf(diez) + " monedas de 10\n");
                    break;
                }

                if (residuoCien % 50 >= 20) {
                    residuoCiencuenta = residuoCien % 50;
                    vente = residuoCiencuenta / 20;

                    if (residuoCiencuenta % 20 >= 10) {
                        residuoVente = residuoCiencuenta % 20;
                        diez = residuoVente / 10;

                        if (residuoVente % 10 >= 5) {
                            residuoDiez = residuoVente % 10;
                            cinco = residuoDiez / 5;
                            txtResult.setText("Usted tiene: \n\n" + String.valueOf(cincuenta) + " Papeletas de 50 \n" + String.valueOf(vente) + " Papeletas de 20\n" + String.valueOf(diez) + " Monedas de 10\n" + String.valueOf(cinco) + " Monedas de 5");
                            break;
                        }
                        txtResult.setText("Usted tiene: \n\n" + String.valueOf(cincuenta) + " Papeletas de 50 \n" + String.valueOf(vente) + " Papeletas de 20\n" + String.valueOf(diez) + " Monedas de diez");
                        break;
                    }
                    txtResult.setText("Usted tiene: \n\n" + String.valueOf(cincuenta) + " Papeletas de 50 \n" + String.valueOf(vente) + " Papeletas de 20");
                    break;
                }
                txtResult.setText("Usted tiene: \n\n" + String.valueOf(cincuenta) + " Papeletas de 50");
                break;

            }

            else if (numeroIntroducido / 50 < 1 && numeroIntroducido >= 20) {

                vente = residuoCiencuenta / 20;

                if(residuoCiencuenta / 20 >= 1 && residuoCiencuenta % 20 >=5 && residuoCiencuenta % 20 < 10 ){
                    cinco = residuoDiez / 5;

                    txtResult.setText("Usted tiene: \n\n" + String.valueOf(vente) + " Papeletas de 20 \n" + String.valueOf(cinco) + " monedas de 5\n");
                    break;
                }

                if (residuoCiencuenta % 20 >= 10) {
                    diez = residuoVente / 10;

                    if (residuoVente % 10 >= 5) {
                        cinco = residuoDiez / 5;
                        txtResult.setText("Usted tiene: \n\n" + String.valueOf(vente) + " Papeletas de 20 \n" + String.valueOf(diez) + " monedas de 10\n" + String.valueOf(cinco) + " Monedas de 5");
                        break;
                    }
                    txtResult.setText("Usted tiene: \n\n" + String.valueOf(vente) + " Papeletas de 20 \n" + String.valueOf(diez) + " monedas de 10\n");
                    break;
                }
                txtResult.setText("Usted tiene: \n\n" + String.valueOf(vente) + " Papeletas de 20");
                break;
            }

            else if (numeroIntroducido / 20 < 1 && numeroIntroducido >= 10) {

             residuoVente = residuoCiencuenta % 20;
             diez = residuoVente / 10;

                if (residuoVente % 10 >= 5) {
                    residuoDiez = residuoVente % 10;
                    cinco = residuoDiez / 5;
                    txtResult.setText("Usted tiene: \n\n" + String.valueOf(diez) + " monedas de 10 \n" + String.valueOf(cinco) + " monedas de 5");
                    break;
                }
                txtResult.setText("Usted tiene: \n\n" + String.valueOf(diez) + " Monedas de 10");
                break;
            }

            else if (numeroIntroducido / 10 < 1 && numeroIntroducido >= 5) {
                    residuoDiez = residuoVente % 10;
                    cinco = residuoDiez / 5;
                    txtResult.setText("Usted tiene: \n\n" + String.valueOf(cinco) + " monedas de 5");
                    break;
                }

            }
        }

    }
















































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



