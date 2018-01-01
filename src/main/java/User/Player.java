package User;

import Items.Metale;
import Items.Uzdatniacze;
import com.example.demo.CreateNewItem;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Player {
    List<Object> plecak = new ArrayList<Object>();
    int temperatura = 0;
    CreateNewItem createNewItem = new CreateNewItem(temperatura);

    public Player(List<Object> plecak) {
        this.plecak = plecak;
    }
    public Player(){}


    public void dodaj(Object item) {
        plecak.add(item);
    }

    public void usun(int index){
        if (index < plecak.size()){
            plecak.remove(index);
        }else {
            throw new Error("nie ma takiego indexu");
        }

    }

    public void usun(Object item){
        plecak.remove(item);
    }

    public void dodajDoKuzni(Metale item){
        createNewItem.addMetal(item);
        usun(item);
    }

    public void dodajDoKuzni(Uzdatniacze item){
        createNewItem.addUzdatniacz(item);
        usun(item);
    }
    public void dodajDoKuzni(int index){
        if (index < plecak.size()){
            createNewItem.addItem(plecak.get(index));
            if (plecak.get(index).getClass() == Items.Metale.class){
                Metale nowy = (Metale) plecak.get(index);
                System.out.println("dodaje "+nowy.toString());
            }else if (plecak.get(index).getClass() == Items.Uzdatniacze.class){
                Uzdatniacze nowy = (Uzdatniacze) plecak.get(index);
                System.out.println("dodaje "+nowy.toString());
            }
            usun(index);
        }else {
            throw new Error("nie ma takiego indexu");
        }

    }

    public void dodajDoKuzni(Object item){
        createNewItem.addItem(item);
        usun(item);
    }

    public void melt(){
        createNewItem.setTemperaturaPieca(temperatura);
        Metale nowy = createNewItem.melt();
        dodaj(nowy);
    }

    @Override
    public String toString() {
        return "Player{" +
                "plecak=" + plecak.toString() +
                '}';
    }
}
