public class NumberCheckerUtility5 {
    public static int sumOfDivisors(int n) {
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) if (n % i == 0) sum += i;
        return sum;
    }

    public static boolean isPerfect(int n) {
        return sumOfDivisors(n) == n;
    }

    public static boolean isAbundant(int n) {
        return sumOfDivisors(n) > n;
    }

    public static boolean isDeficient(int n) {
        return sumOfDivisors(n) < n;
    }

    public static int factorial(int n) {
        int f = 1;
        for (int i = 2; i <= n; i++) f *= i;
        return f;
    }

    public static boolean isStrong(int n) {
        int sum = 0, t = n;
        while (t > 0) { sum += factorial(t % 10); t /= 10; }
        return sum == n;
    }

    public static void main(String[] args) {
        int n = 145;
        System.out.println("Number: " + n);
        System.out.println("Perfect: " + isPerfect(n));
        System.out.println("Abundant: " + isAbundant(n));
        System.out.println("Deficient: " + isDeficient(n));
        System.out.println("Strong: " + isStrong(n));
    }
}
