
public class Kadane {

    // Méthode 1 : calculer la somme maximale
    public static int maxSubarraySum(int[] t) {

        if (t == null || t.length == 0) {
            throw new IllegalArgumentException(
                "Le tableau ne doit pas être null ou vide."
            );
        }

        int currentSum = t[0];
        int maxSum = t[0];

        for (int i = 1; i < t.length; i++) {

            currentSum = Math.max(
                t[i],
                currentSum + t[i]
            );

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    // Méthode 2 : afficher aussi le sous-tableau optimal
    public static void afficherSousTableauMax(int[] t) {

        if (t == null || t.length == 0) {
            throw new IllegalArgumentException(
                "Le tableau ne doit pas être null ou vide."
            );
        }

        int currentSum = t[0];
        int maxSum = t[0];

        int start = 0;
        int bestStart = 0;
        int bestEnd = 0;

        for (int i = 1; i < t.length; i++) {

            if (t[i] > currentSum + t[i]) {
                currentSum = t[i];
                start = i;
            } else {
                currentSum += t[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                bestStart = start;
                bestEnd = i;
            }
        }

        System.out.println("Somme maximale = " + maxSum);

        System.out.print("Sous-tableau : [");

        for (int i = bestStart; i <= bestEnd; i++) {
            System.out.print(t[i]);

            if (i < bestEnd) {
                System.out.print(", ");
            }
        }

        System.out.println("]");

        System.out.println("Indice de début = " + bestStart);
        System.out.println("Indice de fin = " + bestEnd);
    }

    public static void main(String[] args) {

        int[][] tests = {
            {-2, 1, -3, 4, -1, 2, 1, -5, 4},
            {1, 2, 3, 4},
            {-1, -2, -3},
            {5},
            {-7},
            {-2, -1, 3, 4, -5},
            {1, -1, 1, -1, 1}
        };

        for (int i = 0; i < tests.length; i++) {

            System.out.print("Tableau : ");

            for (int x : tests[i]) {
                System.out.print(x + " ");
            }

            System.out.println();

            System.out.println(
                "Somme maximale = " + maxSubarraySum(tests[i])
            );

            afficherSousTableauMax(tests[i]);

            System.out.println("------------------------");
        }
    }
}

