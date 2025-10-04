import java.util.Arrays;

class adi {
    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int w = 50;

        double ratio[][] = new double[val.length][2];
        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = (double) val[i] / weight[i];
        }

        // Sort by ratio in descending order
        Arrays.sort(ratio, (a, b) -> Double.compare(b[1], a[1]));

        double finalvalue = 0.0;
        for (double[] r : ratio) {
            int idx = (int) r[0];
            if (w >= weight[idx]) {
                finalvalue += val[idx];
                w -= weight[idx];
            } else {
                finalvalue += r[1] * w;
                break;
            }
        }

        System.out.println(finalvalue);
}
}
