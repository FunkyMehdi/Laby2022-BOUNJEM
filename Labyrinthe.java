import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;

public class Labyrinthe {

    //Attributs
    private final static char MUR = 'X';
    private final static char PJ = 'P';
    private final static char SORTIE = 'S';
    private final static char VIDE = '.';
    private static String HAUT;
    private static String BAS;
    private static String GAUCHE;
    private static String DROITE;
    private final boolean[][] murs;
    private Personnage personnage;
    private final Sortie sortie;

    public Labyrinthe(boolean[][] m, Personnage p, Sortie s) {
        this.murs = m;
        this.personnage = p;
        this.sortie = s;
    }

    public char getChar(int x, int y) {
        if(murs[x][y]) {
            return(Labyrinthe.MUR);
        }
        else {
            if(personnage.getX() == x && personnage.getY() == y) {
                return(Labyrinthe.PJ);
            }
            else if (sortie.getX() == x && sortie.getY() == y) {
                return(Labyrinthe.SORTIE);
            }
            else {
                return(Labyrinthe.VIDE);
            }
        }
    }

    public static int[] getSuivant(int x, int y, String direction) {
        int tab[] = new int[2];
        switch(direction){

            case "HAUT":
                int tab1[] = new int[]{x-1, y};
                break;

            case "BAS":
                int tab2[] = new int[]{x+1, y};
                break;

            case "GAUCHE":
                int tab3[] = new int[]{x, y-1};
                break;

            case "DROITE":
                int tab4[] = new int[]{x, y+1};
                break;
        }
        return tab;
    }

    public void deplacerPerso(String action) {
        int[] tab = this.getSuivant(this.personnage.getX(), this.personnage.getY(), action);

        while(this.getChar(tab[0], tab[1]) != MUR) {
            if(action == this.GAUCHE) {

            }
        }

    }


    public String toString() {

        BufferedReader Reader = new BufferedReader(new FileReader(''));
        int nbLignes = Integer.parseInt(Reader.readLine());


    }


    public boolean etreFini(String action) {
        boolean fini = false;
        int[] tab = this.getSuivant(this.personnage.getX(), this.personnage.getY(), action);

        if(this.getChar(tab[0], tab[1]) == SORTIE) {
            fini = true;
        }
        return fini;
    }



}
