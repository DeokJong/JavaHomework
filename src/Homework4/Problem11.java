package Homework4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Problem11 {
    public static void main(String arg[]){
        Scanner scan=new Scanner(System.in);
        int a,b;
        String s;
        while(true) {
            System.out.print("Type two integer and operator");
            try{
                a= scan.nextInt();
                b=scan.nextInt();
                s=scan.next();
            }
            catch(InputMismatchException e){
                System.out.println("Input Mismatch! try again!");
                scan.nextLine();
                continue;
            }

            if(s.length()!=1){
                System.out.println("Operator is String! try again!");
                continue;
            }

            char o =s.charAt(0);
            switch(o){
                case '+':
                    Add add = new Add();
                    add.setValue(a,b);
                    System.out.println(add.calculate());
                    break;
                case '-':
                    Sub sub= new Sub();
                    sub.setValue(a,b);
                    System.out.println(sub.calculate());
                    break;
                case '*':
                    Mul mul=new Mul();
                    mul.setValue(a,b);
                    System.out.println(mul.calculate());
                    break;
                case '/':
                    Div div= new Div();
                    div.setValue(a,b);
                    if(b==0){
                        System.out.println("Not divide zero!");
                        break;
                    }
                    System.out.println(div.calculate());
                    break;
                default:
                    System.out.println("Not find operator try again");
                    continue;
            }

            break;
        }
    }
}

class Add{
    int value1,value2;
    void setValue(int v1,int v2){
        value1=v1;
        value2=v2;
    }
    int calculate(){
        return value1+value2;
    }
}

class Sub{
    int value1,value2;
    void setValue(int v1,int v2){
        value1=v1;
        value2=v2;
    }
    int calculate(){
        return value1-value2;
    }
}

class Mul{
    int value1,value2;
    void setValue(int v1,int v2){
        value1=v1;
        value2=v2;
    }
    int calculate(){
        return value1*value2;
    }
}
class Div{
    int value1,value2;
    void setValue(int v1,int v2){
        value1=v1;
        value2=v2;
    }
    int calculate(){
        return value1/value2;
    }
}
