public class recursion {
  public static void main(String[] args) {
    System.out.println(sqrt(107));
  }
  public static double sqrt (double n) {
    return sqrtH(n, n, .001);
  }
  public static double sqrtH(double n, double orig, double pc) {
    if (sqrtCheck(n, orig, pc)) return n;
    else {
      return sqrtH(((orig / n + n) * .5), orig, pc);
    }
  }
  public static boolean sqrtCheck(double n, double orig, double pc) {
    double check = n * n;
    if ((100 * Math.abs((check - orig) / orig)) < pc) return true;
    return false;
  }
  public static int fib(int n) {
    return fibH(n, 0);
  }
  public static int fibH(int n, int fibCurrent) {
    if (n == 0) return 0;
    else if (n == 1) return 1;
    else {
      int prev = n - 1;
      int prevprev = n - 2;
      return fibH(n - 1, fibCurrent + prev + prevprev);
    }
  }
}
