
public class LIS {

    public static int longueurLIS(int[] t) {

        int n = t.length;

        // Cas du tableau vide
        if (n == 0) {
            return 0;
        }

        // Création du tableau dp
        int[] dp = new int[n];

        // Initialisation
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // Programmation dynamique
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {

                if (t[j] < t[i]) {

                    dp[i] = Math.max(dp[i], dp[j] + 1);

                }
            }
        }

        // Recherche du maximum
        int max = 0;

        for (int i = 0; i < n; i++) {

            if (dp[i] > max) {
                max = dp[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {

        int[][] tests = {
            {},
            {5},
            {5, 4, 3, 2, 1},
            {1, 2, 3, 4, 5},
            {2, 1, 4, 2, 3, 5, 1, 7},
            {3, 3, 3, 3},
            {10, 9, 2, 5, 3, 7, 101, 18}
        };

        for (int[] t : tests) {

            System.out.println("LIS = " + longueurLIS(t));

        }
    }
}
