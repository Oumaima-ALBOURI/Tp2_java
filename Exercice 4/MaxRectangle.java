
import java.util.Stack;

public class MaxRectangle {

    // Classe pour stocker le résultat
    static class Rectangle {
        int top;
        int left;
        int bottom;
        int right;
        int area;

        Rectangle(int top, int left, int bottom,
                  int right, int area) {
            this.top = top;
            this.left = left;
            this.bottom = bottom;
            this.right = right;
            this.area = area;
        }
    }

    public static Rectangle trouverMaxRectangle(int[][] m) {

        if (m == null || m.length == 0 || m[0].length == 0) {
            return new Rectangle(-1, -1, -1, -1, 0);
        }

        int R = m.length;
        int C = m[0].length;

        int[] h = new int[C];

        Rectangle meilleur =
            new Rectangle(-1, -1, -1, -1, 0);

        // Parcourir chaque ligne
        for (int i = 0; i < R; i++) {

            // Construire l'histogramme
            for (int j = 0; j < C; j++) {

                if (m[i][j] == 1) {
                    h[j]++;
                } else {
                    h[j] = 0;
                }
            }

            // Recherche du plus grand rectangle
            // dans l'histogramme actuel
            Stack<Integer> pile = new Stack<>();

            for (int j = 0; j <= C; j++) {

                int hauteurActuelle =
                    (j == C) ? 0 : h[j];

                while (!pile.isEmpty() &&
                       h[pile.peek()] > hauteurActuelle) {

                    int index = pile.pop();

                    int hauteur = h[index];

                    int left = pile.isEmpty()
                        ? 0 : pile.peek() + 1;

                    int right = j - 1;

                    int largeur = right - left + 1;

                    int aire = hauteur * largeur;

                    if (aire > meilleur.area) {

                        int bottom = i;
                        int top = i - hauteur + 1;

                        meilleur = new Rectangle(
                            top, left, bottom, right, aire
                        );
                    }
                }

                if (j < C) {
                    pile.push(j);
                }
            }
        }

        return meilleur;
    }

    // Affichage du résultat
    public static void afficherResultat(int[][] m) {

        Rectangle r = trouverMaxRectangle(m);

        System.out.println("Aire maximale = " + r.area);

        if (r.area > 0) {
            System.out.println("Coordonnées :");
            System.out.println("top = " + r.top);
            System.out.println("left = " + r.left);
            System.out.println("bottom = " + r.bottom);
            System.out.println("right = " + r.right);
        } else {
            System.out.println("Aucun rectangle de 1");
        }
    }

    public static void main(String[] args) {

        int[][] m1 = {
            {0}
        };

        int[][] m2 = {
            {1}
        };

        int[][] m3 = {
            {0, 0, 0, 0},
            {0, 1, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0}
        };

        int[][] m4 = {
            {1, 1, 0, 1},
            {1, 1, 0, 1},
            {0, 0, 1, 1}
        };

        int[][] m5 = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };

        int[][] m6 = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };

        int[][][] tests = {m1, m2, m3, m4, m5, m6};

        for (int i = 0; i < tests.length; i++) {

            System.out.println("Test " + (i + 1));

            afficherResultat(tests[i]);

            System.out.println();
        }
    }
}
