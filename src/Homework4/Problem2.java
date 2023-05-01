package Homework4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Problem2 {

    public static void main(String[] args) {
        int arr[] = new int[3];
        boolean check=false;
        Scanner scan=new Scanner(System.in);

        while(true) {
            try {
                System.out.println("input score order by math, sci, eng");
                for(int i =0;i<3;i++) {
                    arr[i]=scan.nextInt();
                    if(arr[i]<0) {
                        System.out.println("Score is not minus, try again");
                        scan.nextLine();
                        break;
                    }
                    if(i==2) check=true;
                }
            }
            catch(InputMismatchException e){
                scan.nextLine();
                System.out.println("wrong input, try again");
            }

            if(check==true) break;
        }

        Grade me = new Grade(arr[0],arr[1],arr[2]);

        System.out.printf("average is %d",me.average());

        scan.close();
    }

}

class Grade{
    private int math,sci,eng;
    public Grade(int math,int sci, int eng){
        this.math = math;
        this.sci=sci;
        this.eng=eng;
    }

    public int average() {
        return (math+sci+eng)/3;
    }
}
