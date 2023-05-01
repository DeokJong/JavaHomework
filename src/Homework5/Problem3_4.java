package Homework5;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDateTime;

public class Problem3_4 {
    public static void main(String[] arg){

        //problem 3
        Won2Dollar toDollar = new Won2Dollar(1200);
        toDollar.run();

        //problem 4
        Km2Mile toMile = new Km2Mile(1.6);
        toMile.run();

        System.out.print("201916136 Jin DeokJong "+LocalDateTime.now());

        toDollar.close();
        toMile.close();
    }
}

abstract class Converter{
    abstract protected double convert(double src);
    abstract protected String getSrcString();
    abstract protected String getDestString();
    protected double ratio;
    protected Scanner scan = new Scanner(System.in);

    public void run(){
        double res;
        double val;
        while(true) {
            try {
                System.out.printf("Convert %s to %s\n", getSrcString(), getDestString());
                System.out.printf("type %s >>", getSrcString());
                val = scan.nextDouble();
                res = convert(val);
            } catch (InputMismatchException e) {
                System.out.printf("This is wrong type. try again!\n");
                scan.nextLine();
                continue;
            }
            System.out.printf("Convert result : %.2f %s\n", res, getDestString());
            break;
        }
    }

    public void close(){scan.close();}
}

class Won2Dollar extends Converter{//problem 3
    public Won2Dollar(double ratio){this.ratio=ratio;}

    @Override
    protected double convert(double src){return src/ratio;}
    @Override
    protected String getSrcString(){return "Won";}
    @Override
    protected String getDestString(){return "Dollar";}
}

class Km2Mile extends Converter{//problem 4
    public Km2Mile(double ratio){this.ratio=ratio;}

    @Override
    protected double convert(double src){return src/ratio;}
    @Override
    protected String getSrcString(){return "Km";}
    @Override
    protected String getDestString(){return "Mile";}
}