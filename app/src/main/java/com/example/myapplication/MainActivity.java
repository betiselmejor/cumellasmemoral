package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.icu.text.DateIntervalFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.objects.Carta;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    Animation slideIn;

    ImageView carta1;
    ImageView carta2;
    ImageView carta3;
    ImageView carta4;
    ImageView carta5;
    ImageView carta6;

    int cartasGiradas=0;

    ArrayList<Carta> cartas = new ArrayList<>();
    Carta cartagirada1;
    Carta cartagirada2;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCartas();

    }


    public void girarF(Carta c,ImageView iv) throws InterruptedException {

        iv.animate().rotationYBy(90).withEndAction(new Runnable() {
            @Override
            public void run() {
                iv.animate().rotationYBy(90);
                iv.setImageResource(c.getFrontImage());
            }
        });

        c.setEnsenyaCara(true);
        cartasGiradas++;
        Toast.makeText(getApplicationContext(), String.valueOf(cartasGiradas),Toast.LENGTH_SHORT).show();
        if (cartasGiradas ==1){
            cartagirada1=c;
        }else if (cartasGiradas==2){
            cartagirada2=c;
        }

        comprobarParella();



    }

    public void girarB(Carta c,ImageView iv){

        iv.animate().rotationYBy(80).withEndAction(new Runnable() {
            @Override
            public void run() {
                iv.animate().rotationYBy(100);
                iv.setImageResource(c.getBackImg());
            }
        });


        c.setEnsenyaCara(false);
    }


    public void comprobarParella()  {
        String img1 = String.valueOf(cartagirada1.getFrontImage());

        if (cartasGiradas==2){
            String img2 = String.valueOf(cartagirada2.getFrontImage());

            if (img1.equals(img2)){
                Toast.makeText(getApplicationContext(),"parella",Toast.LENGTH_SHORT).show();
                cartagirada1.setParellaTrobada(true);
                cartagirada2.setParellaTrobada(true);

            }else{
                new Handler().postDelayed(() -> {
                    girarB(cartagirada1,cartagirada1.getIv());
                    girarB(cartagirada2,cartagirada2.getIv());

                }, 1000);




            }
            cartasGiradas=0;


        }


    }


    public void initCartas(){


        Carta carta11=  new Carta(R.drawable.charmander);
        Carta carta22=  new Carta(R.drawable.hooh);
        Carta carta33=  new Carta(R.drawable.hooh);
        Carta carta44=  new Carta(R.drawable.charmander);
        Carta carta55=  new Carta(R.drawable.executor);
        Carta carta66=  new Carta(R.drawable.executor);

        cartas.add(carta11);
        cartas.add(carta22);
        cartas.add(carta33);
        cartas.add(carta44);
        cartas.add(carta55);
        cartas.add(carta66);


        carta1 = (ImageView) findViewById(R.id.imageView);
        carta2 = (ImageView) findViewById(R.id.imageView2);
        carta3 = (ImageView) findViewById(R.id.imageView3);
        carta4 = (ImageView) findViewById(R.id.imageView4);
        carta5 = (ImageView) findViewById(R.id.imageView5);
        carta6 = (ImageView) findViewById(R.id.imageView6);

        ArrayList<ImageView> imgvs = new ArrayList<>();

        imgvs.add(carta1);
        imgvs.add(carta2);
        imgvs.add(carta3);
        imgvs.add(carta4);
        imgvs.add(carta5);
        imgvs.add(carta6);

        Collections.shuffle(cartas);

        slideIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide);


        for (int i = 0; i < cartas.size(); i++) {
            cartas.get(i).setIv(imgvs.get(i));
        }

        for (int i = 0; i < cartas.size(); i++) {
            Carta carta = cartas.get(i);

            new Handler().postDelayed(() -> {
                carta.getIv().setImageResource(carta.getBackImg());
                carta.getIv().startAnimation(slideIn);
            }, 1000);

        }

        for (int i = 0; i < cartas.size(); i++) {
            Carta cprova = cartas.get(i);

            cprova.getIv().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        girarF(cprova,cprova.getIv());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

//        carta1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                girarF(cartas.get(0),carta1);
//            }
//        });
//
//        carta2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                girarF(cartas.get(1),carta2);
//            }
//        });
//
//        carta3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                girarF(cartas.get(2),carta3);
//            }
//        });
//
//        carta4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                girarF(cartas.get(3),carta4);
//            }
//        });
    }

}