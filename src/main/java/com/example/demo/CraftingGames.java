package com.example.demo;

import Items.Metale;
import Items.Uzdatniacze;
import User.Player;

import java.io.IOException;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class CraftingGames {

	public static void main(String[] args) throws IOException {
		//SpringApplication.run(CraftingGames.class, args);

		Metale item0 = new Metale("Adamit",100,100,
				100,100,100,10,100);


		Metale item1 = new Metale("Adamit",100,800,
				50,10,150,10,-5);

		Metale item2 = new Metale("Adamites",550,800,
				50,10,150,1,-5);

		Uzdatniacze uzdatniacz2 = new Uzdatniacze("Wegiel",1.1,1,0.5,
				1.01,1.05,1,1.0);

		CreateNewItem createNewItem = new CreateNewItem(550);

		createNewItem.addUzdatniacz(uzdatniacz2);
		createNewItem.addMetal(item1);
		createNewItem.addMetal(item0);
		createNewItem.addMetal(item2);

		Player player = new Player();
		player.dodaj(item1);
		player.dodaj(item0);
		player.dodaj(item2);
		player.dodaj(uzdatniacz2);
		System.out.println(player.toString());
		player.setTemperatura(1100);
		player.dodajDoKuzni(0);
		player.dodajDoKuzni(0);
		player.dodajDoKuzni(0);
		player.dodajDoKuzni(0);
		player.melt();
		System.out.println(player.toString());


		Metale metale2 = createNewItem.melt();

		System.out.println(metale2.toString());

	}
}
