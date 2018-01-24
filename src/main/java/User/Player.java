package User;

import Items.Metale;
import Items.Uzdatniacze;

import com.example.demo.CreateNewItem;
import com.company.klientTrade.KlientTrade;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@Data
public class Player {

    List<Object> plecak = new ArrayList<Object>();
    int temperatura = 0;
    CreateNewItem createNewItem = new CreateNewItem(temperatura);
    KlientTrade klientTrade = new KlientTrade(this);

    public Player(List<Object> plecak) throws IOException {
        this.plecak = plecak;
    }

    public Player() throws IOException {}

    /**
     * Dodaje item do plecaka
     * @param item - do dodania
     */
    public void dodaj(Object item) {
        plecak.add(item);
    }

    /**
     * usuwa item z pod wspakaznego indexu
     * @param index - wkazany index
     */
    public void usun(int index){
        if (index < plecak.size()){
            plecak.remove(index);
        }else {
            throw new Error("nie ma takiego indexu");
        }

    }

    /**
     * usuwa item z plecaka
     * @param item
     */
    public void usun(Object item){
        plecak.remove(item);
    }

    /**
     * dodaje nowy item (metal) do CreateNewItem
     * @param item z plecaka
     */
    public void dodajDoKuzni(Metale item){
        createNewItem.addMetal(item);
        usun(item);
    }

    /**
     * dodaje nowy item (uzdatniacz) do CreateNewItem
     * @param item z plecaka
     */
    public void dodajDoKuzni(Uzdatniacze item){
        createNewItem.addUzdatniacz(item);
        usun(item);
    }

    /**
     * Sprawdza czy item jest w plecaku
     * @param item item o który chodzi
     * @return true - jesli jest false - jesli nie
     */
    public boolean wPlecaku(Object item){
        for (int i=0; i<plecak.size(); i++){
            if (item == plecak.get(i)){
                return true;
            }
        }
        return false;
    }

    /**
     * dodaje item do CreateNewItem
     * @param index index itemu z plecaka
     */
    public void dodajDoKuzni(int index){
        if (index < plecak.size()){
            createNewItem.addItem(plecak.get(index));
            usun(index);
        }else {
            throw new Error("nie ma takiego indexu");
        }

    }

    /**
     * dodaje item jesli jest wplecaku
     * @param item item z plecaka
     */
    public void dodajDoKuzni(Object item){
        if (wPlecaku(item)) {
            createNewItem.addItem(item);
            usun(item);
        }else {
            throw new Error("nie ma takiego itemu w plecaku");
        }
    }

    /**
     * wywołuje funkcje melt z CrateNewItem i dodaje
     * nowo utworzony item do plecaka
     */
    public void melt(){
        createNewItem.setTemperaturaPieca(temperatura);
        Metale nowy = createNewItem.melt();
        dodaj(nowy);
    }

    public void trade(Object metale,String userName) throws IOException {
        klientTrade.tradeWysylamy(metale,userName);
    }

    public void tradeOdbieramy(Object metale,String userName) throws IOException {
        klientTrade.tradeOdbieramy(metale,userName);
    }

    public void wyslij(String msg){
        klientTrade.wyslijTrade.wyslij(msg);
    }

    public void accept(String usrName){
        klientTrade.akcept(usrName);
    }

    public void cancel(String usName){
        klientTrade.cancel(usName);
    }

    public void ustawNick(String nick){
        klientTrade.ustawNick(nick);
    }

    public void sprawdzNicki(){
        klientTrade.sprawdzNicki();
    }


    @Override
    public String toString() {
        return "Player{" +
                "plecak=" + plecak.toString() +
                '}';
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }
}
