package com.example.myapplication.objects;

import android.widget.ImageView;

import com.example.myapplication.R;

public class Carta {

    public int backImg = R.drawable.captura;

    public int frontImage;

    public int columna;

    public int fila;

    public int posicio;

    public boolean ensenyaCara = false;

    public ImageView iv ;

    public boolean parellaTrobada;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public Carta(int frontImage, int columna, int fila) {
        this.frontImage = frontImage;
        this.columna = columna;
        this.fila = fila;
    }

    public Carta(int frontImage, int posicio) {
        this.frontImage = frontImage;
        this.posicio = posicio;
    }

    public Carta(int frontImage) {
        this.frontImage = frontImage;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public int getBackImg() {
        return backImg;
    }

    public void setBackImg(int backImg) {
        this.backImg = backImg;
    }

    public int getFrontImage() {
        return frontImage;
    }

    public void setFrontImage(int frontImage) {
        this.frontImage = frontImage;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getPosicio() {
        return posicio;
    }

    public void setPosicio(int posicio) {
        this.posicio = posicio;
    }


    public boolean isEnsenyaCara() {
        return ensenyaCara;
    }

    public void setEnsenyaCara(boolean ensenyaCara) {
        this.ensenyaCara = ensenyaCara;
    }

    public ImageView getIv() {
        return iv;
    }

    public void setIv(ImageView iv) {
        this.iv = iv;
    }

    public boolean isParellaTrobada() {
        return parellaTrobada;
    }

    public void setParellaTrobada(boolean parellaTrobada) {
        this.parellaTrobada = parellaTrobada;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


}
