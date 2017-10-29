package com.example.jose.id_24;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button btnFondo;
    private Button btnColorLetras;
    private TextView fondo;
    private TextView txtLongClick;
    private RatingBar ratingBar;
    private TextView txtRatingBar;
    private CheckBox checkBox;
    private TextView checkBoxTxt;
    private String colorFondo;
    private String colorLetras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorFondo = "blanco";
        colorLetras = "negro";
        btnFondo = (Button)findViewById(R.id.btnColores);
        btnColorLetras = (Button)findViewById(R.id.btnLetras);
        fondo = (TextView) findViewById(R.id.fondoColor);
        txtLongClick = (TextView) findViewById(R.id.txtLongClick);
        txtRatingBar = (TextView) findViewById(R.id.txtRatingBar);
        checkBoxTxt = (TextView) findViewById(R.id.txtMostrar);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);


        btnFondo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(colorFondo.equals("blanco")){
                    fondo.setBackgroundColor(Color.parseColor("#ffff0000"));
                    btnFondo.setText("Fondo Blanco");
                    colorFondo = "rojo";
                }else{
                    fondo.setBackgroundColor(Color.parseColor("#ffffffff"));
                    btnFondo.setText("Fondo Rojo");
                    colorFondo = "blanco";
                }

            }
        });

        btnColorLetras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(colorLetras.equals("negro")){
                    btnColorLetras.setTextColor(Color.parseColor("#ffff0000"));
                    btnFondo.setTextColor(Color.parseColor("#ffff0000"));
                    btnColorLetras.setText("Letras Negras");
                    colorLetras = "rojo";
                }else{
                    btnColorLetras.setTextColor(Color.parseColor("#FF100F10"));
                    btnFondo.setTextColor(Color.parseColor("#FF100F10"));

                    btnColorLetras.setText("Letras Rojas");
                    colorLetras = "negro";
                }
            }

            });
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()){
                    checkBoxTxt.setVisibility(View.VISIBLE);
                }else{
                    checkBoxTxt.setVisibility(View.INVISIBLE);
                }
            }
        });

        txtLongClick.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),"Muchas Gracias!",Toast.LENGTH_SHORT);
                toast.show();
                return false;
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                String ratingString = String.valueOf(rating);
                switch (ratingString){
                    case "1.0": ratingString = "1"; break;
                    case "2.0": ratingString = "2"; break;
                    case "3.0": ratingString = "3"; break;
                    case "4.0": ratingString = "4"; break;
                    case "5.0": ratingString = "5"; break;
                }

                txtRatingBar.setText("["+ratingString+"/5]");
            }
        });
    }
}
