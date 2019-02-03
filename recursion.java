import java.util.*;
public class recursion {
  public static void main(String[] args) {
    System.out.println(sqrt(107));
    System.out.println(fib(6));
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
    return fibH(n, 0, 0, 1);
  }
  public static int fibH(int n, int fibCurrent, int prev, int prevprev) {
    if (n == 0) return fibCurrent;
    else {
      return fibH(n - 1, prev + prevprev, prev + prevprev, prev);
    }
  }
  public static ArrayList<Integer> makeAllSums(int n) {
    ArrayList<Integer> output = new ArrayList<Integer>();
    return makeAllSumsH(n, 0, output);
  }
  public static void makeAllSumsH(int n, int sum, ArrayList<Integer> list) {
    if (n == 0) return list;
    else {
      makeAllSumsH(n, currentSum + n, list);
      makeAllSumsH(n, currentSum, list);
    }
  }
}
