package Escola;

import java.util.Scanner;

import Model.GestaoEstudantes;
import Model.MenuHandler;

public class Escola {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		GestaoEstudantes gs = new GestaoEstudantes();
		MenuHandler menu = new MenuHandler(gs);
		
		do {
			menu.showMenu();
			menu.processUserInput(sc.nextInt());
		} while (true);
	}
}
