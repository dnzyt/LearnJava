package medium;

// 3765. Complete Prime Number

public class Solution3765 {

    public boolean completePrime(int num) {
        String s = Integer.toString(num);
        for (int i = 0; i < s.length(); i++) {
            int x = Integer.parseInt(s.substring(0, i + 1));
            if (!isPrime(x))
                return false;
            x = Integer.parseInt(s.substring(i));
            if (!isPrime(x))
                return false;
        }
        return true;
    }

    private boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return num >= 2;
    }
}
