
public class NombresAbsents {

    public static void afficherElementsManquants(int[] t, int n) {

        if (t == null || n < 0) {
            throw new IllegalArgumentException("Paramètres invalides.");
        }

        // Étape 1 : créer le tableau de marquage
        boolean[] vu = new boolean[n + 1];

        // Étape 2 : marquer les nombres présents
        for (int i = 0; i < t.length; i++) {

            int x = t[i];

            if (x >= 1 && x <= n) {
                vu[x] = true;
            }
        }

        // Étape 3 : rechercher les nombres manquants
        boolean trouve = false;

        for (int k = 1; k <= n; k++) {

            if (!vu[k]) {
                System.out.print(k + " ");
                trouve = true;
            }
        }

        // Si aucun nombre n'est manquant
        if (!trouve) {
            System.out.print("Aucun element manquant");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        System.out.println("Test 1 :");
        afficherElementsManquants(
            new int[]{1, 3, 3, 5}, 5
        );

        System.out.println("Test 2 :");
        afficherElementsManquants(
            new int[]{1, 2, 3, 4}, 4
        );

        System.out.println("Test 3 :");
        afficherElementsManquants(
            new int[]{3, 3, 3}, 3
        );

        System.out.println("Test 4 :");
        afficherElementsManquants(
            new int[]{1, 1, 1, 1}, 4
        );

        System.out.println("Test 5 :");
        afficherElementsManquants(
            new int[]{4, 2, 2, 1, 5}, 5
        );

        System.out.println("Test 6 :");
        afficherElementsManquants(
            new int[]{1}, 1
        );

        System.out.println("Test 7 :");
        afficherElementsManquants(
            new int[]{1, 2, 3, 6}, 4
        );
    }
}
