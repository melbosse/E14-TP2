import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner monObj = new Scanner(System.in);
        System.out.println("Bienvenue au jeu de Tic Tac Toe !");
        System.out.println("Entrez votre prénom :");

        String prenom = monObj.nextLine();
        System.out.println("Bienvenue " + prenom + "!");

        System.out.println("La partie va bientôt commencer.");
    }
}