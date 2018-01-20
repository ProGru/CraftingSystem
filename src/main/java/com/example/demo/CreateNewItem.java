package com.example.demo;


import Items.Metale;
import Items.Uzdatniacze;
//import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa implementuje topienie i uzdatnianie metali,
 * czyli dodawanie przedmiotów do kotła:
 *  - addMetal
 *  - addUzdatniacz
 *
 * topienie przedmiotów z kotła:
 * -melt
 *
 */
//@Data
public class CreateNewItem {

    List<Metale> metaleList = new ArrayList<Metale>();
    List<Uzdatniacze> uzdatniaczeList = new ArrayList<Uzdatniacze>();
    List<Metale> nieStopoione = new ArrayList<Metale>();

    int temperaturaPieca;

    private String nazwa;
    private int temperaturaTopnienia = 0;
    private int twardosc = 0;
    private int elastycznosc = 0;
    private int podatnosc = 0;
    private int kruchosc = 0;
    private int waga = 0;
    private int przewodnictwoCieplne = 0;

    public CreateNewItem(List<Metale> metaleList, int temperaturaPieca) {
        this.metaleList = metaleList;
        this.temperaturaPieca = temperaturaPieca;
    }

    public CreateNewItem(int temperaturaPieca) {
        this.temperaturaPieca = temperaturaPieca;
    }

    /**
     * Dodaje metal do listy (kotła)
     * @param item
     */
    public void addMetal(Metale item){
        metaleList.add(item);
    }

    /**
     * Dodaje uzdatniacz do listy (kotła)
     * @param item
     */
    public  void addItem(Object item){
        if (item.getClass() == Items.Metale.class){
            addMetal((Metale) item);
        }else if (item.getClass() == Items.Uzdatniacze.class){
            addUzdatniacz((Uzdatniacze) item);
        }
    }

    public void addUzdatniacz(Uzdatniacze item){
        uzdatniaczeList.add(item);
    }

    private void clean(){
        temperaturaTopnienia = 0;
        twardosc = 0;
        elastycznosc = 0;
        podatnosc = 0;
        kruchosc = 0;
        waga = 0;
        przewodnictwoCieplne = 0;
    }

    /**
     * Topi przedmioty z kotła (list) tworzac nowy metal o nowych właściwościach.
     * @return Metal o nowych własciwościach.
     */
    public Metale melt(){

        clean();

        if (metaleList.size() == 0){
            throw new Error("Niema nic do topienia");
        }

        int ile = 0;

        for (int i = 0; i< metaleList.size(); i++){
            if (metaleList.get(i).getTemperaturaTopnienia()<=temperaturaPieca){
                waga += metaleList.get(i).getWaga();
                ile += 1;
                twardosc += metaleList.get(i).getTwardosc()*( metaleList.get(i).getWaga()*1.0/waga)*1-temperaturaPieca*0.001;
                elastycznosc += metaleList.get(i).getElastycznosc()*( metaleList.get(i).getWaga()*1.0/waga)*1-temperaturaPieca*0.001;
                podatnosc += metaleList.get(i).getPodatnosc()*( metaleList.get(i).getWaga()*1.0/waga)*1-temperaturaPieca*0.001;
                kruchosc += metaleList.get(i).getKruchosc()*( metaleList.get(i).getWaga()*1.0/waga)*1-temperaturaPieca*0.001;
                przewodnictwoCieplne += metaleList.get(i).getPrzewodnictwoCieplne()*( metaleList.get(i).getWaga()*1.0/waga)*1-temperaturaPieca*0.001;
                if (metaleList.get(i).getTemperaturaTopnienia()>temperaturaTopnienia){
                    temperaturaTopnienia = metaleList.get(i).getTemperaturaTopnienia();
                }
            }else {
                nieStopoione.add(metaleList.get(i));
            }
        }
        metaleList = new ArrayList<Metale>();

        if (ile==0){
            return new Metale("syf",0,0,0,0,0,0,0);
        }

        for (int i =0; i<uzdatniaczeList.size();i++){
            double twardosc1 = twardosc * uzdatniaczeList.get(i).getTwardosc();
            double elastycznosc1 = elastycznosc * uzdatniaczeList.get(i).getElastycznosc();
            double podatnosc1 = podatnosc * uzdatniaczeList.get(i).getPodatnosc();
            double kruchosc1 = kruchosc * uzdatniaczeList.get(i).getKruchosc();
            double przewodnictwoCieplne1 = przewodnictwoCieplne * uzdatniaczeList.get(i).getPrzewodnictwoCieplne();
            double temperaturaTopnienia1 = temperaturaTopnienia * uzdatniaczeList.get(i).getTemperaturaTopnienia();
            double waga1 = waga * uzdatniaczeList.get(i).getWaga();

            twardosc = (int) twardosc1;
            elastycznosc = (int) elastycznosc1;
            podatnosc = (int) podatnosc1;
            kruchosc = (int) kruchosc1;
            przewodnictwoCieplne = (int) przewodnictwoCieplne1;
            temperaturaTopnienia = (int) temperaturaTopnienia1;
            waga = (int) waga1;
        }
        uzdatniaczeList = new ArrayList<Uzdatniacze>();
        double nowa_waga = waga * 1-(temperaturaPieca*0.009);
        if (nowa_waga<0){
            return new Metale("spalony syf", 0, 0, 0, 0, 0, 0, 0);
        }
        waga = (int) nowa_waga;

        return new Metale("NowyMetal", temperaturaTopnienia, twardosc,
                elastycznosc, podatnosc, kruchosc, waga, przewodnictwoCieplne);
    }

    public List<Metale> getNieStopoione() {
        return nieStopoione;
    }

    public void setTemperaturaPieca(int temperaturaPieca) {
        this.temperaturaPieca = temperaturaPieca;
    }
}
