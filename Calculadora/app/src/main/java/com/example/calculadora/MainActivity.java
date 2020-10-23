package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    float anteriorNumero;
    String operacion;
    String angUnits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.operacion = null;
        this.angUnits = "rad";
    }
    //Botones Opciones
    public void onPorcentajeClick(View v)
    {
        TextView texto = (TextView)findViewById(R.id.txtRes);
        String txtNum = getNumero();
        Log.d("INFO", txtNum);
        Log.d("INFO", "Aplico porcentaje: " + txtNum + "%");
        float numero = Float.parseFloat(txtNum) / 100;
        cambiarNumeroRes(Float.toString(numero));
        this.operacion = "porcentaje";
    }
    public void onAngUnitsClick(View v)
    {
        Button temp = (Button)findViewById(R.id.btnCambioUnidades);
        String texto = temp.getText().toString();
        if(texto.equals("rad"))
        {
            this.angUnits = "deg";
            temp.setText(angUnits);
        }
        else if (texto.equals("deg"))
        {
            this.angUnits = "rad";
            temp.setText(angUnits);
        }
        texto = temp.getText().toString();
        Log.d("INFO BUTTON", "Unidades: " + texto);
    }
    public void onSignClick(View v)
    {
        Button temp = (Button)findViewById(R.id.btnCambioSigno);
        String sign = null;
        if(!temp.isActivated())
        {
            temp.setActivated(true);
            sign = "-";
            TextView texto = (TextView)findViewById(R.id.txtRes);
            String resultado = texto.getText().toString();
            texto.setText("-"+resultado);
        }
        else if (temp.isActivated())
        {
            temp.setActivated(false);
            sign = "+";
            TextView texto = (TextView)findViewById(R.id.txtRes);
            String resultado = texto.getText().toString().split("-")[1];
            texto.setText(resultado);
        }
        Log.d("INFO BUTTON", "Signo: " + sign);
    }
    //Botones Operaciones
    public void onSumaRestaMultiDivClick(View v)
    {
        TextView texto = (TextView)findViewById(R.id.txtRes);
        this.anteriorNumero = Float.parseFloat(getNumero());
        Button operacionSeleccionada = (Button) v;
        this.operacion = operacionSeleccionada.getText().toString();
        añadirElementoAHist(this.operacion);
        borrarLineaRes();
    }
    public void onSinClick(View v)
    {
        añadirElementoARes("sin ");
        añadirElementoAHist("sin(");
        this.operacion = "sin";
    }
    public void onCosClick(View v)
    {
        añadirElementoARes("cos ");
        añadirElementoAHist("cos(");
        this.operacion = "cos";
    }
    public void onTanClick(View v)
    {
        añadirElementoARes("tan ");
        añadirElementoAHist("tan(");
        this.operacion = "tan";
    }
    //Botones finales
    public void onBorrarClick(View v)
    {
        borrarLineaRes();
        borrarLineaHist();
        this.anteriorNumero = 0;
        Log.d("INFO BUTTON", "Línea, operacion e historial borrados");
        this.operacion = null;
    }
    public void onEqualClick(View v)
    {
        if(this.operacion == "tan" || this.operacion == "sin" || this.operacion == "cos")
        {
            String divisor = " ";
            String[] introducido = getNumero().split(divisor);
            Float numero = Float.parseFloat(introducido[1]);
            float res = comprobarOperacion(numero);
            borrarLineaRes();
            añadirElementoARes(Float.toString(res));
            añadirElementoAHist(")");
        }
        else
        {
            float introducido = Float.parseFloat(getNumero());
            borrarLineaRes();
            String resultado = Float.toString(comprobarOperacion(introducido));
            añadirElementoARes(resultado);
            Log.d("RES", "Resultado de " + this.anteriorNumero + " " + this.operacion + " " + introducido + " es " + resultado);
        }
        this.operacion = null;
    }
    //Numeros
    public void onNumberClick(View v)
    {
        Button pulsado = (Button) v;
        String numero = pulsado.getText().toString();
        Log.d("INFO BUTTON", "Numero pulsado: " + numero);
        if(this.operacion == "porcentaje")
        {
            float res = Float.parseFloat(getNumero()) * Float.parseFloat(numero);
            cambiarNumeroRes(null);
            añadirElementoARes(Float.toString(res));
            añadirElementoAHist(Float.toString(res));
            this.operacion = null;
        }
        else
        {
            añadirElementoARes(numero);
            añadirElementoAHist(numero);
        }
    }
    public void onComaClick(View v)
    {
        String numero = getNumero();
        String[] trozos = numero.split(".");
        if (trozos.length == 0)
        {
            añadirElementoARes(".");
            añadirElementoAHist(".");
        }
        else
        {
            Toast.makeText(this, "No puedes añadir más decimales", Toast.LENGTH_LONG).show();
        }
    }

    //Metodos
    public String getNumero()
    {
        String numero;
        TextView texto = (TextView)findViewById(R.id.txtRes);
        numero = texto.getText().toString();
        return numero;
    }
    public void añadirElementoARes(String elemento)
    {
        TextView texto = (TextView)findViewById(R.id.txtRes);
        String elementoArreglado = elemento;
        if(!elemento.equals("."))
        {
            elementoArreglado = arreglarDecimal(elemento);
        }
        texto.append(elementoArreglado);
    }
    public void añadirElementoAHist(String elemento)
    {
        TextView texto = (TextView)findViewById(R.id.txtHist);
        texto.append(elemento);
    }
    public void cambiarNumeroRes(String numero)
    {
        TextView texto = (TextView)findViewById(R.id.txtRes);
        texto.setText(numero);
    }
    public void cambiarNumeroHist(String numero)
    {
        TextView texto = (TextView)findViewById(R.id.txtHist);
        texto.setText(numero);
    }
    public void borrarLineaRes()
    {
        cambiarNumeroRes("");
    }
    public void borrarLineaHist()
    {
        cambiarNumeroHist("");
    }
    public String arreglarDecimal(String decimal)
    {
        //Separo parte entera de parte decimal
        if(!decimal.equals("sin ")&&!decimal.equals("cos ")&&!decimal.equals("tan "))
        {
            float numero = Float.parseFloat(decimal);
            int parteEntera = (int) numero;
            float parteDecimal = numero - parteEntera;
            if (parteDecimal == 0) {
                Log.d("INFO", "El numero " + decimal + " es entero. Le eliminaré el .0 y devolveré " + Integer.toString(parteEntera));
                return Integer.toString(parteEntera);
            } else {
                return decimal;
            }
        }
        else
        {
            return decimal;
        }
    }
    public float comprobarOperacion(float numeroIntroducido)
    {
        float numeroResultado = this.anteriorNumero;
        if (this.operacion.equals("+"))
        {
            numeroResultado = this.anteriorNumero + numeroIntroducido;
        }
        else if (this.operacion.equals("-"))
        {
            numeroResultado = this.anteriorNumero - numeroIntroducido;
        }
        else if (this.operacion.equals("×"))
        {
            numeroResultado = this.anteriorNumero * numeroIntroducido;
        }
        else if (this.operacion.equals("÷"))
        {
            numeroResultado = this.anteriorNumero / numeroIntroducido;
        }
        else if (this.operacion.equals("sin"))
        {
            if(angUnits.equals("rad"))
            {
                numeroResultado = (float)(Math.sin(numeroIntroducido));
            }
            else
            {
                numeroResultado = (float)(Math.sin(numeroIntroducido*Math.PI/180));
            }
        }
        else if (this.operacion.equals("cos"))
        {
            if(angUnits.equals("rad"))
            {
                numeroResultado = (float)(Math.cos(numeroIntroducido));
            }
            else
            {
                numeroResultado = (float)(Math.cos(numeroIntroducido*Math.PI/180));
            }
        }
        else if (this.operacion.equals("tan"))
        {
            if(angUnits.equals("rad"))
            {
                numeroResultado = (float)(Math.tan(numeroIntroducido));
            }
            else
            {
                numeroResultado = (float)(Math.tan(numeroIntroducido*Math.PI/180));
            }
        }
        else if (this.operacion.equals("porcentaje"))
        {
            añadirElementoARes("%×");
            numeroResultado = this.anteriorNumero * numeroIntroducido;
        }
        return numeroResultado;
    }
}