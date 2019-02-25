import java.util.*;
public class recursion {
  public static void main(String[] args) {
    System.out.println(sqrt(107));
    System.out.println(fib(6));
    System.out.println(makeAllSums(3).toString());
  }
  public static double sqrt (double n, double pc) {
    return sqrtH(n, n, pc);
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
    makeAllSumsH(n, 0, output);
    return output;
  }
  public static void makeAllSumsH(int n, int sum, ArrayList<Integer> list) {
    if (n == 0) list.add(sum);
    else {
      makeAllSumsH(n - 1, sum + n, list);
      makeAllSumsH(n - 1, sum, list);
    }
  }
  //testcase must be a valid index of your input/output array
public static void testFib(int testcase){
  recursion r = new recursion();
  int[] input = {0,1,2,3,5,30};
  int[] output ={0,1,1,2,5,832040};
  int max = input.length;
  if(testcase < input.length){
    int in = input[testcase];
    try{

      int ans = r.fib(in);
      int correct = output[testcase];
      if(ans == correct){
        System.out.println("PASS test fib "+in+". "+correct);
      }
      else{
        System.out.println("FAIL test fib"+in+". "+ans+" vs "+correct);

      }
    }catch(IllegalArgumentException n){
      if(in < 0){
        System.out.println("PASS test fib"+in+" IllegalArgumentException");
      }else{
        System.out.println(" FAIL IllegalArgumentException in test case:"+in);
      }
    }catch(Exception e){
      System.out.println(" FAIL Some exception in test case:"+in);
    }
  }
}


//testcase must be a valid index of your input/output array
public static void testSqrt(int testcase){
  recursion r = new recursion();
  double[] input = {0.0,1.0, 2.0, 4.0, 7.0};
  double[] output = {0.0,1.0,1.4142135623730951,2.0,2.6457513110645907};
  int max = input.length;
  if(testcase < input.length){
    double in = input[testcase];
    try{
      double ans = r.sqrt(in,.00001);
      double correct = Math.sqrt(in);
      if(closeEnough(ans,correct)){
        System.out.println("PASS test sqrt "+in+" "+ans);
      }
      else{
        System.out.println("FAIL test sqrt "+in+" "+ans+" vs "+correct);

      }
    }catch(IllegalArgumentException n){
      if(in < 0){
        System.out.println("PASS test sqrt"+in+" IllegalArgumentException");
      }else{
        System.out.println(" FAIL IllegalArgumentException in test case:"+in);
      }
    }catch(Exception e){
      System.out.println(" FAIL Some exception in test case:"+in);
    }
  }
}
}
