/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class ptb2 extends ptb1 {

    double hs2;

    public ptb2(double m, double n, double k) {
        super(n, k);
        hs2 = m;
    }

    public double getHs2() {
        return hs2;
    }

    public void setHs2(double hs2) {
        this.hs2 = hs2;
    }

    @Override
    public String solve() {
        if (getHs2() == 0) {
            return super.solve();
        } else {
            double delta = getDelta();

            if (delta > 0) {
                double x1 = solveGetX1();
                double x2 = solveGetX2();
                return "Solution: x1 = " + x1 + ", x2 = " + x2;
            } else if (delta == 0) {
                double x = solveGetX();
                return "Phuong trinh co nghiem kep x = " + x;
            } else {
                return "Phuong trinh vo nghiem";
            }
        }
    }

    public double getDelta() {
        return getHs1() * getHs1() - 4 * getHs2() * getHs0();
    }

    public double solveGetX1() {
        return (-getHs1() + Math.sqrt(getDelta())) / (2 * getHs2());
    }

    public double solveGetX2() {
        return (-getHs1() - Math.sqrt(getDelta())) / (2 * getHs2());
    }

    @Override
    public double solveGetX() {
        return -getHs1() / (2 * getHs2());
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        boolean hasOdd = false;
        boolean hasEven = false;
        boolean hasPerfectSquare = false;

        System.out.println(hs2 + "x2" + " + " + hs1 + "x" + " + " + hs0 + " = 0\n");
        System.out.println(solve()+"\n");
        double[] temp = new double[6];
        temp[0] = hs0;
        temp[1] = hs1;
        temp[2] = hs2;
        temp[3] = solveGetX();
        temp[4] = solveGetX1();
        temp[5] = solveGetX2();

        for (int i = 0; i < temp.length; i++) {
            if (Checker.isOdd(temp[i])) {
                result.append(temp[i]).append(" ");
                hasOdd = true;
            }
            if (Checker.isEven(temp[i])) {
                result.append(temp[i]).append(" ");
                hasEven = true;
            }
            if (Checker.isPerfectSquare(temp[i])) {
                result.append(temp[i]).append(" ");
                hasPerfectSquare = true;
            }
        }

        // Kiểm tra và thêm thông điệp tương ứng nếu có số lẻ, chẵn hoặc là số chính phương
        if (hasOdd) {
            result.insert(0, "Number is Odd: ");
        }
        if (hasEven) {
            result.insert(0, "Number is Even: ");
        }
        if (hasPerfectSquare) {
            result.insert(0, "Number is Perfect Square: ");
        }

        return result.toString();
    }

    // Check if hs1, hs0, and solveGetX() are odd, even, or perfect squares before printing
//        boolean isOddHs1 = Checker.isOdd(hs1);
//        boolean isOddHs0 = Checker.isOdd(hs0);
//        boolean isOddHs2 = Checker.isOdd(hs2);
//        boolean isOddGetX1 = Checker.isOdd(solveGetX1());
//        boolean isOddGetX2 = Checker.isOdd(solveGetX2());
//        boolean isOddGetX = Checker.isOdd(solveGetX());
//
//        boolean isEvenHs1 = Checker.isEven(hs1);
//        boolean isEvenHs0 = Checker.isEven(hs0);
//        boolean isEvenHs2 = Checker.isEven(hs2);
//        boolean isEvenGetX = Checker.isEven(solveGetX());
//        boolean isEvenGetX1 = Checker.isEven(solveGetX1());
//        boolean isEvenGetX2 = Checker.isEven(solveGetX2());
//
//        boolean isPerfectSquareHs1 = Checker.isPerfectSquare(hs1);
//        boolean isPerfectSquareHs0 = Checker.isPerfectSquare(hs0);
//        boolean isPerfectSquareHs2 = Checker.isPerfectSquare(hs2);
//        boolean isPerfectSquareGetX = Checker.isPerfectSquare(solveGetX());
//        boolean isPerfectSquareGetX1 = Checker.isPerfectSquare(solveGetX1());
//        boolean isPerfectSquareGetX2 = Checker.isPerfectSquare(solveGetX2());
//        if (isOddHs1 || isOddHs0 || isOddGetX) {
//            result.append("Number is odd: ");
//            if (isOddHs1) {
//                result.append(hs1).append(" ");
//            }
//            if (isOddHs0) {
//                result.append(hs0).append(" ");
//            }
//            if (isOddGetX) {
//                result.append(solveGetX()).append(" ");
//            }
//            result.append("\n");
//        }
//
//        if (isEvenHs1 || isEvenHs0 || isEvenGetX) {
//            result.append("Number is even: ");
//            if (isEvenHs1) {
//                result.append(hs1).append(" ");
//            }
//            if (isEvenHs0) {
//                result.append(hs0).append(" ");
//            }
//            if (isEvenGetX) {
//                result.append(solveGetX()).append(" ");
//            }
//            result.append("\n");
//        }
//
//        if (isPerfectSquareHs1 || isPerfectSquareHs0 || isPerfectSquareGetX) {
//            result.append("Number is perfect square: ");
//            if (isPerfectSquareHs1) {
//                result.append(hs1).append(" ");
//            }
//            if (isPerfectSquareHs0) {
//                result.append(hs0).append(" ");
//            }
//            if (isPerfectSquareGetX) {
//                result.append(solveGetX()).append(" ");
//            }
//            result.append("\n");
//        }
//
//        return result.toString();
//    }
}
