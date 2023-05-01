import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner monObj = new Scanner(System.in);
        System.out.println("Bienvenue au jeu de Tic Tac Toe !");

        // Premier joueur
        System.out.println("Entrez le prénom du premier joueur :");

        String prenomJoueur = monObj.nextLine();
        Joueur joueur1 = new Joueur(prenomJoueur);
        joueur1.setSymbole("X");

        // Second joueur
        System.out.println("Entrez le prénom du second joueur :");

        prenomJoueur = monObj.nextLine();
        Joueur joueur2 = new Joueur(prenomJoueur);
        joueur2.setSymbole("O");

        System.out.println("Bienvenue " + joueur1.getNom() + " et " + joueur2.getNom() + "!");

        // Début de la partie
        System.out.println("La partie va bientôt commencer...");
    }
}