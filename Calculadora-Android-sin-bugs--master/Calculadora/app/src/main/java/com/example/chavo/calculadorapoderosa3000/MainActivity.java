package com.example.chavo.calculadorapoderosa3000;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlertDialog alert;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Rubio Haro Rodrigo Rodolfo");
        builder.setTitle("Bienvenido a tu calcu ;)");
        builder.setCancelable(false);
        builder.setNeutralButton("Calcular :3", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        alert = builder.create();
        alert.show();
    }

    Double numero1, numero2, resultado;
    String operador="";


    public void onClickButtonUno(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.Visualizador) ;
        SetTitleOfNumber(1,tv);
    }
    public void onClickButtonDos(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.Visualizador) ;
        SetTitleOfNumber(2,tv);
    }
    public void onClickButtonTres(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.Visualizador) ;
        SetTitleOfNumber(3,tv);
    }
    public void onClickButtonCuatro(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.Visualizador) ;
        SetTitleOfNumber(4,tv);
    }
    public void onClickButtonCinco(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.Visualizador) ;
        SetTitleOfNumber(5,tv);
    }
    public void onClickButtonSeis(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.Visualizador) ;
        SetTitleOfNumber(6,tv);
    }
    public void onClickButtonSiete(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.Visualizador) ;
        SetTitleOfNumber(7,tv);
    }
    public void onClickButtonOcho(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.Visualizador) ;
        SetTitleOfNumber(8,tv);
    }
    public void onClickButtonNueve(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.Visualizador) ;
        SetTitleOfNumber(9,tv);
    }
    public void onClickButtonCero(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.Visualizador) ;
        SetTitleOfNumber(0,tv);
    }

    public void onClickButtonPunto(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.Visualizador) ;
        tv.setText(tv.getText() + ".");
    }

    public void SetTitleOfNumber(int numerito, TextView tv){
        String i=numerito + "";
            if(tv.getText().toString() != null && operador == null){
                tv.setText(i);
                operador="";
            }else{
                tv.setText(tv.getText() + i);
            }
    }



    public void onClickOperacionCapturaNumero1(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.Visualizador) ;
        try{
            numero1 = Double.parseDouble(tv.getText().toString());
        }catch (Exception e){
            MessageError("Ingresa un numero Valido ");
            numero1=0.0;
        }
        tv.setText("");
    }

    public void onClickBorrarUnDigito(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.Visualizador) ;
        String Texto = tv.getText().toString();
        if(Texto.length()>0){
            String NuevoTexto = Texto.substring(0,Texto.length()-1);
            tv.setText(NuevoTexto);
        }
    }

    public void onClickSuma(View miView)
    {
        operador="+";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickResta(View miView)
    {
        operador="-";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickMultiplicacion(View miView)
    {
        operador="*";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickDivision(View miView)
    {
        operador="/";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickCubo(View miView)
    {
        operador="X^3";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickCuadrado(View miView)
    {
        operador="X^2";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickRaiz(View miView)
    {
        operador="RCascara";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickSeno(View miView)
    {
        operador="Sen";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickCoseno(View miView)
    {
        operador="Cos";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickTangent(View miView)
    {
        operador="Tan";
        onClickOperacionCapturaNumero1(miView);
    }



    public void onClickIgual(View miView){
        resultado = 0.0;
        TextView tv = (TextView) findViewById(R.id.Visualizador) ;
        if(numero1!=null){
            try {
                        double ang = numero1 *Math.PI / 180.0;
                        switch (operador) {
                            case "X^3":
                                resultado = numero1 * numero1 * numero1;
                                break;
                            case "X^2":
                                resultado = numero1 * numero1;
                                break;
                            case "RCascara":
                                resultado = Math.sqrt(numero1);
                                break;
                            case "Sen":
                                resultado = Math.sin(ang);
                                break;
                            case "Cos":
                                resultado = Math.cos(ang);
                                break;
                            case "Tan":
                                resultado = Math.tan(ang);
                                break;
                            case "+":
                                numero2 = Double.parseDouble(tv.getText().toString());
                                resultado = numero1 + numero2;
                                break;
                            case "-":
                                numero2 = Double.parseDouble(tv.getText().toString());
                                resultado = numero1 - numero2;
                                break;
                            case "*":
                                numero2 = Double.parseDouble(tv.getText().toString());
                                resultado = numero1 * numero2;
                                break;
                            case "/":
                                numero2 = Double.parseDouble(tv.getText().toString());
                                resultado = numero1 / numero2;
                                break;
                            default:
                                resultado = 0.0;
                                break;
                        }

                tv.setText(resultado + "");
                operador=null;
            }catch (Exception e){
                operador=null;
                tv.setText("");
            }

        }else{
            operador="";
        }
        numero1=null;
        numero2=null;
    }

    public void onClickLimpia(View miView)
    {
        numero1=0.0;
        numero2=0.0;
        TextView tv = (TextView) findViewById(R.id.Visualizador) ;
        tv.setText("");
    }

    public void MessageError(String Mensaje){
        AlertDialog alert;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(Mensaje);
        builder.setTitle("Error");
        builder.setCancelable(false);
        builder.setNeutralButton("Entendido", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {dialog.cancel();
            }
        });
        alert = builder.create();
        alert.show();
        numero1=0.0;
    }
}
