public class Joueur {
    private String prenom;
    private String symbole;

    public Joueur(String prenom){
        this.prenom = prenom;
    }
    public String getNom(){
        return prenom;
    }

    public void setSymbole(String symbole){
        this.symbole = symbole;
    }
}
