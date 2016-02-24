package Cryptingu;

import java.util.Arrays;
import java.util.StringJoiner;


class Elem {
  public int a;
  public int rev;
  public int dec;

  public String expr;

  Elem() {
  }

  Elem(int a, int rev, int dec, String expr) {
    this.a = a;
    this.rev = rev;
    this.dec = dec;
    this.expr = expr;
  }
}

public class Curiputu {
  static Elem[] table = new Elem[16];
  static int[][] S;

  private static void tableFill(Elem[] arr) {
    arr[0] = new Elem(1, 14, 2, "x");
    arr[1] = new Elem(2, 13, 4, "x2");
    arr[2] = new Elem(3, 12, 8, "x3");
    arr[3] = new Elem(4, 11, 3, "x+1");
    arr[4] = new Elem(5, 10, 6, "x2+x");
    arr[5] = new Elem(6, 9, 12, "x3+x2");
    arr[6] = new Elem(7, 8, 11, "x3+x+1");
    arr[7] = new Elem(8, 7, 5, "x2+1");
    arr[8] = new Elem(9, 6, 10, "x3+x");
    arr[9] = new Elem(10, 5, 7, "x2+x+1");
    arr[10] = new Elem(11, 4, 14, "x3+x2+x");
    arr[11] = new Elem(12, 3, 15, "x3+x2+x+1");
    arr[12] = new Elem(13, 2, 13, "x3+x2+1");
    arr[13] = new Elem(14, 1, 9, "x3+1");
    arr[14] = new Elem(15, 15, 1, "1");
    arr[15] = new Elem(0, 0, 0, "1");

  }

  static Elem byA(int a) {


    if (a > 15) a -= 15;

    for (Elem e : table) {
      if (e.a == a) return e;
    }
    return null;
  }

  static Elem byDec(int dec) {
    if (dec > 15) dec -= 15;

    for (Elem e : table) {
      if (e.dec == dec) {
        return e;
      }
    }
    return null;
  }

  static Elem byRev(int rev) {
    if (rev > 15) rev -= 15;
    for (Elem e : table) {
      if (e.rev == rev) return e;
    }
    return null;
  }

  static void binShow(int dec) {
    String string = Integer.toString(dec, 2);
    while (string.length() < 4) string = "0" + string;
    System.out.println(string);
  }

  // flag true - get num from LEFT part of S table
  // false - vice versa
  static int[] sbMatrix(int[] matrix, boolean flag) {
    int[] result = new int[matrix.length];

    if (flag) {
      for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < S.length; j++) {
          if (S[j][2] == matrix[i]) {
            result[i] = S[j][0];
            break;
          }
        }
      }
    }
    else {
      for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < S.length; j++) {
          if (S[j][0] == matrix[i]) {
            result[i] = S[j][2];
            break;
          }
        }
      }
    }

    return result;
  }

  static int[] reverseMatrix(int[] matrix) {
    return new int[]{matrix[1], matrix[0]};
  }

  static int[] shiftMatrix(int[] matrix) {
    int[] result = new int[matrix.length];
    System.arraycopy(matrix, 0, result, 0, matrix.length);
    int tmp = result[1];
    result[1] = result[3];
    result[3] = tmp;
    return result;
  }

  static int[] divisionMatrix(int[] matrix, int divisor) {
    int[] result = new int[matrix.length];
    for (int i = 0; i < matrix.length; i++) {
      result[i] = byA(byDec(matrix[i]).a + byRev(divisor).a).dec;
    }
    return result;

  }

  static int[] concatArrays(int[] arrOne, int[] arrTwo) {
    int[] result = new int[arrOne.length + arrTwo.length];
    System.arraycopy(arrOne, 0, result, 0, arrOne.length);
    System.arraycopy(arrTwo, 0, result, arrOne.length, arrTwo.length);
    return result;
  }

  static int[] sumMatrix(int[] matr1, int[] matr2) {
    int resultMatr[] = new int[matr1.length];
    int resMatr[] = new int[matr2.length];
    int sumA = 0, sumB = 0;

    int j = 0;

    if (matr2.length < matr1.length) {
      for (int k = 0; k < matr1.length; k += 2) {

        //      System.out.println("gonna summ");
        if (matr1[k] == 0 || matr2[j] == 0) sumA = 0;
        else sumA = aSum(byDec(matr1[k]).a, byDec(matr2[j]).a);
        if (sumA > 15) sumA -= 15;
        resultMatr[k] = sumA;

//        System.out.println("gonna summ");
        if (matr1[k + 1] == 0 || matr2[j] == 0) sumB = 0;
        else sumB = aSum(byDec(matr1[k + 1]).a, byDec(matr2[j]).a);
        if (sumB > 15) sumB -= 15;
        resultMatr[k + 1] = sumB;
        j++;
      }
      resMatr[0] = byA(resultMatr[0]).dec ^ byA(resultMatr[2]).dec;
      resMatr[1] = byA(resultMatr[1]).dec ^ byA(resultMatr[3]).dec;
      resultMatr = resMatr;


    }
    else {
      for (int k = 0; k < matr1.length; k++) {
        resultMatr[k] = matr1[k] ^ matr2[k];
      }
    }
    return resultMatr;
  }

  static int[][] multMatrix(int[][] matr, int number) {
    int rows = matr.length, cols = matr[0].length;
    int[][] resultMatr = new int[rows][cols];
    for (int j = 0; j < rows; j++)
      for (int l = 0; l < cols; l++)
        resultMatr[j][l] = aSum(matr[j][l], number);

    return resultMatr;
  }

  static int[] multMatrix(int[] matr1, int[] matr2) {
    int[] resultMatr = new int[matr1.length];
    int len = resultMatr.length;

    resultMatr[0] = byA(aSum(matr1[0], matr2[0])).dec ^ byA(aSum(matr1[2], matr2[1])).dec;
    resultMatr[1] = byA(aSum(matr1[1], matr2[0])).dec ^ byA(aSum(matr1[3], matr2[1])).dec;

    resultMatr[2] = byA(aSum(matr1[0], matr2[2])).dec ^ byA(aSum(matr1[2], matr2[3])).dec;
    resultMatr[3] = byA(aSum(matr1[1], matr2[2])).dec ^ byA(aSum(matr1[3], matr2[3])).dec;

    return resultMatr;
  }

  static int[] matrixToA(int[] matrix) {
    int[] result = new int[matrix.length];
    for (int j = 0; j < matrix.length; j++) {
      result[j] = byDec(matrix[j]).a;
    }
    return result;
  }

  static int[] matrixToDec(int[] matrix) {
    int[] result = new int[matrix.length];
    for (int j = 0; j < matrix.length; j++) {
      result[j] = byA(matrix[j]).dec;
    }
    return result;
  }


  static int[][] transponMatrix(int[][] matrix) {
    int rows = matrix.length, cols = matrix[0].length;
    int[][] resultMatr = new int[rows][cols];

    for (int j = 0; j < rows; j++)
      for (int l = 0; l < cols; l++)
        resultMatr[j][l] = matrix[l][j];

    return resultMatr;
  }

  static int aSum(int a1, int a2) {
    //System.out.println(a1 + " * " + a2);
    if (a1 == 0 || a2 == 0) return 0;
    else if ((a1 + a2) > 15) return (a1 + a2) - 15;
    else return a1 + a2;
  }


  static void partTwo() {

    // turn Px to array of p0 - p3
    int p[][] = new int[4][4];
    String pString = Integer.toString(Px, 2);
    while (pString.length() < 4) pString = "0" + pString;
    int j = 3;
    for (char ch : pString.toCharArray()) {
      p[0][j--] = ch - '0';
    }

    // fill the other lines
    p[1] = new int[]{p[0][3], p[0][0], p[0][1], p[0][2]};
    p[2] = new int[]{p[0][2], p[0][3], p[0][0], p[0][1]};
    p[3] = new int[]{p[0][1], p[0][2], p[0][3], p[0][0]};

    // P
    System.out.println("P:");
    for (int l = 0; l < p.length; l++) {
      System.out.println(Arrays.toString(p[l]));
    }

    // P^-1
    System.out.println("\nP-1:");
    int[][] p_1 = transponMatrix(p);
    for (int l = 0; l < p.length; l++) {
      System.out.println(Arrays.toString(p_1[l]));
    }

    int[][] M = new int[][]{
        {byDec(Cx[0]).a, byDec(Cx[1]).a},
        {byDec(Cx[1]).a, byDec(Cx[0]).a}
    };

    //delta
    int delta = byDec(byA(M[0][0] + M[1][1]).dec ^ byA(M[0][1] + M[1][0]).dec).a;
    System.out.println("\nDelta: " + delta);

    int reverseDelta = byRev(delta).a;
    System.out.println("\nreverseDelta : " + reverseDelta);

    //M
    System.out.println("\nM-1: ");
    int[][] M_1 = multMatrix(M, reverseDelta);
    for (int l = 0; l < M_1.length; l++) {
      System.out.println(Arrays.toString(M_1[l]));
    }
    int []M_basic=new int[]{M[0][0], M[1][0], M[0][1], M[1][1]};

    // KEY EXPANSION

    //new w cuz of new formulas
    int[][] w = new int[7][2];

    w[1] = W[0];
    w[2] = W[1];
    w[3] = sumMatrix(w[1], w[2]);
    w[4] = sumMatrix(sumMatrix(w[2], sbMatrix(reverseMatrix(w[3]), true)), C[8]);
    w[5] = sumMatrix(w[3], w[4]);
    w[6] = sumMatrix(sumMatrix(w[4], sbMatrix(reverseMatrix(w[5]), true)), C[6]);
    System.out.println("\n" + Arrays.toString(w[1]));


    //show W
    System.out.println();
    for (int l = 1; l < w.length; l++) {
      System.out.println("w[" + l + "]: " + Arrays.toString(w[l]));
    }

    System.out.println();
    int k[][] = new int[3][4];
    k[0] = concatArrays(w[1], w[2]);
    k[1] = concatArrays(w[3], w[4]);
    k[2] = concatArrays(w[5], w[6]);

    System.out.println("K_0:" + Arrays.toString(k[0]));
    System.out.println("K_1:" + Arrays.toString(k[1]));
    System.out.println("K_2:" + Arrays.toString(k[2]));


    // ENCRYPTION

    //x+k
    int[] x = sumMatrix(P, k[0]);
    System.out.println("x: " + Arrays.toString(x));

    //S(X)
    x = sbMatrix(x, true);
    System.out.println("x sb: " + Arrays.toString(x));

    //R(X)
    x = shiftMatrix(x);
    System.out.println("x rev: " + Arrays.toString(x));

    //M*X
    int m[] = new int[]{M_1[0][0], M_1[1][0], M_1[0][1], M_1[1][1]};

    x = matrixToA(x);
    System.out.println("new M: " + Arrays.toString(m));
    x = multMatrix(M_basic, x);
    System.out.println("M*X: " + Arrays.toString(x));


    //x+k1
    x=sumMatrix(x,k[1]);
    System.out.println("X+k1: " + Arrays.toString(x));

    //S(X)
    x=sbMatrix(x,true);
    System.out.println("S(X): " + Arrays.toString(x));

    //R(X)
    x=shiftMatrix(x);
    System.out.println("R(X): " + Arrays.toString(x));

    //X+k2
    x=sumMatrix(x,k[2]);
    System.out.println("X+k2 and ecnrypt end: " + Arrays.toString(x)+"\n");


    //DECYPHER


    //X+K2
    x=sumMatrix(x,k[2]);
    System.out.println("X+k2: " + Arrays.toString(x));

    //R(X)
    x=shiftMatrix(x);
    System.out.println("R(X): " + Arrays.toString(x));

    //S-1(X)
    x=sbMatrix(x,false);
    System.out.println("S-1(X): " + Arrays.toString(x));

    //X+k1
    x=sumMatrix(x,k[1]);
    System.out.println("X+k1: " + Arrays.toString(x));

    //M-1 * X
    x=multMatrix(m,x);
    System.out.println("M-1 * x: " + Arrays.toString(x));

    //R(X)
    x=shiftMatrix(x);
    System.out.println("R(X): " + Arrays.toString(x));

    //S-1(x)
    x=sbMatrix(x,false);
    System.out.println("S-1(x): " + Arrays.toString(x));

    //X+K0
    x=sumMatrix(x,k[0]);
    System.out.println("X+k0 AND ALSO AN END: " + Arrays.toString(x));




    System.out.println();
    System.out.println();

  }


  public static void main(String[] args) throws NullPointerException {
    tableFill(table);
    findBasicStuff();

    //partOne();
    partTwo();
  }


  static int P[], K[], W[][], C[][];


  //int i = 7, k = 1, Px = 7, P1x = 6, Cx[] = new int[]{1, 13};              //std
  //int i = 26, k = 3, Px = 12, P1x = 3, Cx[] = new int[]{13, 4};          //mine
  //static int i = 15, k = 3, Px = 12, P1x = 4, Cx[] = new int[]{6, 11};          //nastya
  //static int i = 21, k = 3, Px = 12, P1x = 4, Cx[] = new int[]{8, 1};  //nikit
  //static int i = 5, k = 3, Px = 14, P1x = 2, Cx[] = new int[]{13, 4};    //kasya
  //int i = 25, k = 3, Px = 7, P1x = 6, Cx[] = new int[] {3, 8};          //illya
  static int i = 6, k = 1, Px = 15, P1x = 1, Cx[] = new int[]{6,2};
  //int i = 13, k = 1, Px = 12, P1x = 4 Cx[] = new int[]{8, 1};

  //int i = 17, k = 3, Px = 14, P1x = 2 Cx[] = new int[]{8, 5};

  //static int i = 15, k = 1, Px = 12, P1x = 4, Cx[] = new int[]{6, 11};  //std 2


  static void findBasicStuff() {


    K = new int[4];

    if (i > 15) i -= 15;
    //K 0
    System.out.println(i);

    K[0] = byDec(i).a + byDec(2).a + byRev(byDec(3).a).a;
    K[0] -= 15;
    if (K[0] == 0) K[0] = 1;
    K[0] = byA(K[0]).dec;


    //K 1
    K[1] = byDec(byDec(i).dec ^ byDec(k).dec).a +
        byRev(byDec(7).a).a;
    if (K[1] > 15) K[1] -= 15;
    K[1] = byA(K[1]).dec;


    //K 2
    K[2] = aSum(byDec(byA(byDec(3).a + byDec(i).a).dec ^ byDec(4).dec).a, byRev(byDec(k).a).a);
    if (K[2] > 15) K[2] -= 15;

    K[2] = byA(K[2]).dec;


    //K 3
    K[3] = i ^ 7;
    System.out.println("K");

//        K[0] = 3;
//        K[1] = 7;
//        K[2] = 10;
//        K[3] = 13;

    binShow(K[0]);
    binShow(K[1]);
    binShow(K[2]);
    binShow(K[3]);


    System.out.println();
    P = new int[4];


    P[0] = byDec(5).a + byDec(i).a + byRev(byDec(i).a).a;
    P[0] = byA(P[0]).dec;

    P[1] = byA(byDec(7).a + byDec(k).a).dec ^ byDec(9).dec;

    P[2] = byA(byDec(8).a + byDec(i).a).dec ^ byDec(14).dec;

    int gg = 6 ^ i;
    int gg1 = byA(byDec(5).a + byDec(i).a).dec ^ k;

    if (gg == 0 || gg1 == 0) P[3] = 0;
    else {
      P[3] = byDec(gg).a + byRev(byDec(gg1).a).a;
      P[3] = byA(P[3]).dec;
    }

    //retarded temp fix, remove in production
//    P[2] = 2;
//    P[3] = 7;

    System.out.println("P");
    binShow(P[0]);
    binShow(P[1]);
    binShow(P[2]);
    binShow(P[3]);

    S = new int[16][3];

    int px = byDec(Px).a;
    int p1x = byDec(P1x).a;
    //System.out.println(px + "\n" + p1x);

    //S(x)=x^(-1)*p+p1
    System.out.println();

    S[0][0] = byA(p1x).dec;
    S[0][1] = S[0][2] = 0;

    for (int j = 0; j < S.length; j++) {
      if (j > 0) {
        S[j][0] = byA(byA(j).rev + px).dec ^ byA(p1x).dec;
        S[j][1] = j;
        S[j][2] = byA(j).dec;
      }

      String strS = Integer.toString(S[j][0], 2);
      while (strS.length() < 4) strS = "0" + strS;

      String strBin = Integer.toString(S[j][2], 2);
      while (strBin.length() < 4) strBin = "0" + strBin;

      System.out.printf("S[%4s] = a^%2d = %4s\n", strS, S[j][1], strBin);
    }
    System.out.println();

    //C

    C = new int[9][2];

    C[2][0] = 2;
    C[2][1] = 0;

    C[8][0] = 8;
    C[8][1] = 0;

    C[6][0] = 6;
    C[6][1] = 0;


    // W

    W = new int[7][2];

    W[0] = new int[]{K[0], K[1]};
    W[1] = new int[]{K[2], K[3]};

    W[2] = sumMatrix(sumMatrix(W[0], sbMatrix(reverseMatrix(W[1]), true)), C[2]);

    W[3] = sumMatrix(W[2], W[1]);

    W[4] = sumMatrix(sumMatrix(sbMatrix(reverseMatrix(W[3]), true), W[2]), C[8]);

    W[5] = sumMatrix(W[3], W[4]);

    W[6] = sumMatrix(sumMatrix(W[4], sbMatrix(reverseMatrix(W[5]), true)), C[6]);


    for (int j = 0; j < W.length; j++) {
      System.out.println("W[" + j + "]" + Arrays.toString(W[j]));
    }
    System.out.println();

  }

  static void partOne() {


    // ENCRYPT


    int[] arrHelper = concatArrays(W[0], W[1]);

    int[] X = sumMatrix(P, arrHelper);
    System.out.println("Start: " + Arrays.toString(X));

    X = sbMatrix(X, true);
    System.out.println("Sub: " + Arrays.toString(X));

    X = shiftMatrix(X);
    System.out.println("Shift: " + Arrays.toString(X));

    int[] y = new int[4];

    y[0] = Cx[0];
    y[1] = Cx[1];
    y[2] = Cx[1];
    y[3] = Cx[0];
    System.out.println("Y: " + Arrays.toString(y));


    int[] mixOne = sumMatrix(y, new int[]{X[0], X[1]});
    System.out.println("Mix first: " + Arrays.toString(mixOne));

    System.out.println("X[2] :" + X[2] + "\nX[3]: " + X[3]);
    int[] mixTwo = sumMatrix(y, new int[]{X[2], X[3]});
    System.out.println("Mix second: " + Arrays.toString(mixTwo));

    X = concatArrays(mixOne, mixTwo);
    System.out.println("X mix: " + Arrays.toString(X));

    X = sumMatrix(X, concatArrays(W[2], W[3]));
    System.out.println("X round key: " + Arrays.toString(X));

    X = sbMatrix(X, true);
    System.out.println("X sub bytes: " + Arrays.toString(X));

    X = shiftMatrix(X);
    System.out.println("X shift: " + Arrays.toString(X));

    X = sumMatrix(X, concatArrays(W[4], W[5]));
    System.out.println("X add round AND cryptic end: " + Arrays.toString(X));

    System.out.println();

    // DECIPHER

    X = sumMatrix(X, concatArrays(W[4], W[5]));
    System.out.println("X 0: " + Arrays.toString(X));

    X = shiftMatrix(X);
    System.out.println("X 1.1) shift: " + Arrays.toString(X));

    X = sbMatrix(X, false);
    System.out.println("X 1.2)SB: " + Arrays.toString(X));

    X = sumMatrix(X, concatArrays(W[2], W[3]));
    System.out.println("X 1.3)add round: " + Arrays.toString(X));


    System.out.println("Y: " + Arrays.toString(y));
    int delta = byDec(byA(byDec(y[0]).a + byDec(y[3]).a).dec ^
                          byA(byDec(y[1]).a + byDec(y[2]).a).dec).a;

    System.out.println("Delta : " + delta);

    int[] M_1 = divisionMatrix(y, delta);
    System.out.println("M^(-1): " + Arrays.toString(M_1));

    mixOne = sumMatrix(M_1, new int[]{X[0], X[1]});
    System.out.println("Mix one: " + Arrays.toString(mixOne));

    mixTwo = sumMatrix(M_1, new int[]{X[2], X[3]});
    System.out.println("Mix two: " + Arrays.toString(mixTwo));

    X = concatArrays(mixOne, mixTwo);
    System.out.println("Mix : " + Arrays.toString(X));

    X = shiftMatrix(X);
    System.out.println("Shift : " + Arrays.toString(X));

    X = sbMatrix(X, false);
    System.out.println("SB : " + Arrays.toString(X));

    X = sumMatrix(X, concatArrays(W[0], W[1]));
    System.out.println("AddRound : " + Arrays.toString(X));

  }
}
