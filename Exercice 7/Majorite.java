
public class Majorite {

    public static int elementMajoritaire(int[] t) {

        // Vérifier si le tableau est null ou vide
        if (t == null || t.length == 0) {
            return -1;
        }

        int candidat = 0;
        int compteur = 0;

        // Étape 1 : trouver un candidat
        for (int i = 0; i < t.length; i++) {

            if (compteur == 0) {
                candidat = t[i];
                compteur = 1;
            }
            else if (t[i] == candidat) {
                compteur++;
            }
            else {
                compteur--;
            }
        }

        // Étape 2 : vérifier le candidat
        int occurrences = 0;

        for (int i = 0; i < t.length; i++) {

            if (t[i] == candidat) {
                occurrences++;
            }
        }

        // Vérifier la majorité absolue
        if (occurrences > t.length / 2) {
            return candidat;
        }

        return -1;
    }

    public static void main(String[] args) {

        int[][] tests = {
            {3, 3, 4, 3, 5},
            {2, 2, 1, 2, 3, 2, 2},
            {1, 1, 1, 1},
            {7},
            {1, 2, 3, 4},
            {1, 2, 2, 3},
            {1, 1, 2, 2},
            {-1, -1, -1, 2, 3},
            {-2, -2, -2, -2, 1, 3},
            {},
            {10}
        };

        for (int i = 0; i < tests.length; i++) {

            System.out.print("Tableau : ");

            for (int x : tests[i]) {
                System.out.print(x + " ");
            }

            int resultat = elementMajoritaire(tests[i]);

            System.out.println(" => Majoritaire = " + resultat);
        }
    }
}
