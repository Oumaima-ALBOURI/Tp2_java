
public class Pivots {

    public static void afficherPivots(int[] t) {

        int n = t.length;

        // Vérifier si le tableau contient au moins 3 éléments
        if (n < 3) {
            System.out.println("Aucun pivot");
            return;
        }

        // Création des tableaux auxiliaires
        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];

        // Construction de prefixMax
        prefixMax[0] = t[0];

        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], t[i]);
        }

        // Construction de suffixMin
        suffixMin[n - 1] = t[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], t[i]);
        }

        // Recherche des pivots
        boolean trouve = false;

        System.out.print("Pivots : ");

        for (int i = 1; i < n - 1; i++) {

            if (prefixMax[i - 1] <= t[i] &&
                suffixMin[i + 1] >= t[i]) {

                System.out.print(t[i] + " ");
                trouve = true;
            }
        }

        // Aucun pivot trouvé
        if (!trouve) {
            System.out.print("Aucun pivot");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        int[] t1 = {2, 4, 3, 5, 6};
        int[] t2 = {1, 2, 3, 4, 5};
        int[] t3 = {5, 4, 3, 2, 1};
        int[] t4 = {3, 3, 3, 3};
        int[] t5 = {7, 1, 5, 2, 6, 3, 4};

        afficherPivots(t1);
        afficherPivots(t2);
        afficherPivots(t3);
        afficherPivots(t4);
        afficherPivots(t5);
    }
}
