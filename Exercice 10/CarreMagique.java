
public class CarreMagique {

    public static boolean estCarreMagique(int[][] m) {

        // Vérifier la taille de la matrice
        if (m == null || m.length != 3) {
            return false;
        }

        for (int i = 0; i < 3; i++) {
            if (m[i] == null || m[i].length != 3) {
                return false;
            }
        }

        // Somme de référence : première ligne
        int ref = m[0][0] + m[0][1] + m[0][2];

        // Vérifier les lignes
        for (int i = 0; i < 3; i++) {
            int somme = 0;

            for (int j = 0; j < 3; j++) {
                somme += m[i][j];
            }

            if (somme != ref) {
                return false;
            }
        }

        // Vérifier les colonnes
        for (int j = 0; j < 3; j++) {
            int somme = 0;

            for (int i = 0; i < 3; i++) {
                somme += m[i][j];
            }

            if (somme != ref) {
                return false;
            }
        }

        // Vérifier la diagonale principale
        int diagonalePrincipale =
            m[0][0] + m[1][1] + m[2][2];

        if (diagonalePrincipale != ref) {
            return false;
        }

        // Vérifier la diagonale secondaire
        int diagonaleSecondaire =
            m[0][2] + m[1][1] + m[2][0];

        if (diagonaleSecondaire != ref) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {

        int[][] m1 = {
            {8, 1, 6},
            {3, 5, 7},
            {4, 9, 2}
        };

        int[][] m2 = {
            {2, 7, 6},
            {9, 5, 1},
            {4, 3, 7}
        };

        int[][] m3 = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };

        int[][] m4 = {
            {-1, 2, -1},
            {2, 0, -2},
            {-1, -2, 3}
        };

        int[][] m5 = {
            {8, 1, 6},
            {3, 5, 7},
            {4, 9, 3}
        };

        // Tester les matrices
        System.out.println("Matrice 1 :");
        afficherResultat(m1);

        System.out.println("\nMatrice 2 :");
        afficherResultat(m2);

        System.out.println("\nMatrice 3 :");
        afficherResultat(m3);

        System.out.println("\nMatrice 4 :");
        afficherResultat(m4);

        System.out.println("\nMatrice 5 :");
        afficherResultat(m5);
    }

    public static void afficherResultat(int[][] m) {

        if (estCarreMagique(m)) {
            System.out.println("Carre magique");
        } else {
            System.out.println("Pas un carre magique");
        }
    }
}
