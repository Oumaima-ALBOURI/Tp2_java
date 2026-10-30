
public class Spirale {

    public static int[][] construireSpirale(int n) {

        int[][] m = new int[n][n];

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        int val = 1;

        while (top <= bottom && left <= right) {

            // 1. De gauche à droite
            for (int j = left; j <= right; j++) {
                m[top][j] = val;
                val++;
            }
            top++;

            // 2. De haut en bas
            for (int i = top; i <= bottom; i++) {
                m[i][right] = val;
                val++;
            }
            right--;

            // Vérification des bornes
            if (top > bottom || left > right) {
                break;
            }

            // 3. De droite à gauche
            for (int j = right; j >= left; j--) {
                m[bottom][j] = val;
                val++;
            }
            bottom--;

            // 4. De bas en haut
            for (int i = bottom; i >= top; i--) {
                m[i][left] = val;
                val++;
            }
            left++;
        }

        return m;
    }

    public static void afficherMatrice(int[][] m) {

        for (int i = 0; i < m.length; i++) {

            for (int j = 0; j < m[i].length; j++) {

                System.out.printf("%3d", m[i][j]);

            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[] tests = {1, 2, 3, 4, 5};

        for (int n : tests) {

            System.out.println("n = " + n);

            int[][] matrice = construireSpirale(n);

            afficherMatrice(matrice);

            System.out.println();
        }
    }
}
