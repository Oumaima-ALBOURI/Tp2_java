
public class PermutationCirculaire {

    public static boolean estPermutationCirculaire(int[] t) {

        // Vérifier si le tableau est null ou vide
        if (t == null || t.length == 0) {
            return false;
        }

        int n = t.length;

        // Étape 1 : vérifier les valeurs et les doublons
        boolean[] vu = new boolean[n + 1];

        for (int i = 0; i < n; i++) {

            int x = t[i];

            // Vérifier si la valeur est entre 1 et n
            if (x < 1 || x > n) {
                return false;
            }

            // Vérifier les doublons
            if (vu[x]) {
                return false;
            }

            vu[x] = true;
        }

        // Étape 2 : chercher la position de 1
        int pos = -1;

        for (int i = 0; i < n; i++) {
            if (t[i] == 1) {
                pos = i;
                break;
            }
        }

        // Si 1 n'existe pas
        if (pos == -1) {
            return false;
        }

        // Étape 3 : vérifier l'ordre circulaire
        for (int k = 0; k < n; k++) {

            int idx = (pos + k) % n;
            int valeurAttendue = k + 1;

            if (t[idx] != valeurAttendue) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[][] tests = {
            {1},
            {1, 2, 3, 4, 5},
            {2, 3, 4, 5, 1},
            {3, 4, 5, 1, 2},
            {4, 5, 1, 2, 3},
            {5, 1, 2, 3, 4},
            {3, 1, 2, 4, 5},
            {2, 1, 3, 4, 5},
            {4, 1, 2, 3, 5},
            {0, 1, 2, 3, 4},
            {1, 2, 2, 3, 4},
            {1, 2, 3, 4, 6}
        };

        for (int i = 0; i < tests.length; i++) {

            System.out.print("Tableau : ");

            for (int x : tests[i]) {
                System.out.print(x + " ");
            }

            boolean resultat =
                estPermutationCirculaire(tests[i]);

            System.out.println(" => " + resultat);
        }
    }
}
