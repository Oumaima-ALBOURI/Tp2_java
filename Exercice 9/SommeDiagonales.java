
public class SommeDiagonales {

    public static int differenceDiagonales(int[][] m) {

        // Vérifier si la matrice est valide
        if (m == null || m.length == 0) {
            throw new IllegalArgumentException("Matrice invalide.");
        }

        int n = m.length;

        // Vérifier que la matrice est carrée
        for (int i = 0; i < n; i++) {
            if (m[i] == null || m[i].length != n) {
                throw new IllegalArgumentException(
                    "La matrice doit être carrée."
                );
            }
        }

        int sommePrincipale = 0;
        int sommeSecondaire = 0;

        // Parcourir les deux diagonales
        for (int i = 0; i < n; i++) {

            sommePrincipale += m[i][i];

            sommeSecondaire += m[i][n - 1 - i];
        }

        // Calculer la différence absolue
        int diff = Math.abs(sommePrincipale - sommeSecondaire);

        // Afficher les résultats
        System.out.println("Somme diagonale principale : "
                           + sommePrincipale);

        System.out.println("Somme diagonale secondaire : "
                           + sommeSecondaire);

        System.out.println("Difference absolue : " + diff);

        return diff;
    }

    public static void main(String[] args) {

        int[][] m1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] m2 = {
            {1, 3, 5},
            {2, 4, 6},
            {7, 8, 9}
        };

        int[][] m3 = {
            {5}
        };

        int[][] m4 = {
            {-1, 2},
            {3, -4}
        };

        System.out.println("Matrice 1 :");
        differenceDiagonales(m1);

        System.out.println("\nMatrice 2 :");
        differenceDiagonales(m2);

        System.out.println("\nMatrice 3 :");
        differenceDiagonales(m3);

        System.out.println("\nMatrice 4 :");
        differenceDiagonales(m4);
    }
}
