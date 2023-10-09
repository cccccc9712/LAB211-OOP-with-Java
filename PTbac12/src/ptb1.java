/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class ptb1 {

    double hs1, hs0;

    public ptb1(double m, double n) {
        hs1 = m;
        hs0 = n;
    }

    public double getHs1() {
        return hs1;
    }

    public void setHs1(double hs1) {
        this.hs1 = hs1;
    }

    public double getHs0() {
        return hs0;
    }

    public void setHs0(double hs0) {
        this.hs0 = hs0;
    }

    public String solve() {
        if (hs1 == 0) {
            if (hs0 == 0) {
                return "phuong trinh co vo so nghiem";
            } else {
                return "phuong trinh vo nghiem";
            }
        } else {
            double x = -hs0 / hs1;
            return "Solution x= " + x;
        }

    }

    public double solveGetX() {
        return -hs0 / hs1;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        System.out.println(hs1 + "x" + " + " + hs0 + " = 0 \n");
        result.append(solve()).append("\n");

        // Check if hs1, hs0, and solveGetX() are odd, even, or perfect squares before printing
        boolean isOddHs1 = Checker.isOdd(hs1);
        boolean isOddHs0 = Checker.isOdd(hs0);
        boolean isOddGetX = Checker.isOdd(solveGetX());

        boolean isEvenHs1 = Checker.isEven(hs1);
        boolean isEvenHs0 = Checker.isEven(hs0);
        boolean isEvenGetX = Checker.isEven(solveGetX());

        boolean isPerfectSquareHs1 = Checker.isPerfectSquare(hs1);
        boolean isPerfectSquareHs0 = Checker.isPerfectSquare(hs0);
        boolean isPerfectSquareGetX = Checker.isPerfectSquare(solveGetX());

        if (isOddHs1 || isOddHs0 || isOddGetX) {
            result.append("Number is odd: ");
            if (isOddHs1) {
                result.append(hs1).append(" ");
            }
            if (isOddHs0) {
                result.append(hs0).append(" ");
            }
            if (isOddGetX) {
                result.append(solveGetX()).append(" ");
            }
            result.append("\n");
        }

        if (isEvenHs1 || isEvenHs0 || isEvenGetX) {
            result.append("Number is even: ");
            if (isEvenHs1) {
                result.append(hs1).append(" ");
            }
            if (isEvenHs0) {
                result.append(hs0).append(" ");
            }
            if (isEvenGetX) {
                result.append(solveGetX()).append(" ");
            }
            result.append("\n");
        }

        if (isPerfectSquareHs1 || isPerfectSquareHs0 || isPerfectSquareGetX) {
            result.append("Number is perfect square: ");
            if (isPerfectSquareHs1) {
                result.append(hs1).append(" ");
            }
            if (isPerfectSquareHs0) {
                result.append(hs0).append(" ");
            }
            if (isPerfectSquareGetX) {
                result.append(solveGetX()).append(" ");
            }
            result.append("\n");
        }

        return result.toString();
    }

}
