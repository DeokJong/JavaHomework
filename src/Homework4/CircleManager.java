package Homework4;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CircleManager {
    public static void main(String[] arg) {
        Scanner scan = new Scanner(System.in);
        Circle[] cirArr = new Circle[3];
        double x=0,y=0;
        int radius=0;

        for(int i =0;i<3;i++) {
            System.out.print("x, y, radius >>");
            for(int j = 0 ; j<3;j++) {
                try {
                    switch(j) {
                        case 0:
                            x=scan.nextDouble();
                            break;
                        case 1:
                            y=scan.nextDouble();
                            break;
                        case 2:
                            radius = scan.nextInt();
                            if(radius < 0) {
                                System.out.println("radius can not minus retry this circle input");
                                j=-1;
                                break;
                            }
                            break;
                    }
                }
                catch(InputMismatchException e) {
                    System.out.println("Input mismatch error! retry this circle input");
                    scan.nextLine();
                    j=-1;
                }
            }//input
            cirArr[i]=new Circle(x,y,radius);
        }

        for(int i =0;i<3;i++) {
            cirArr[i].show();
        }
        scan.close();
    }
}


class Circle{
    private double x,y;
    private int radius;

    public Circle(double x, double y , int radius) {
        this.x=x;
        this.y=y;
        this.radius=radius;
    }

    public void show() {
        System.out.printf("(%.1f,%.1f)%d\n",x,y,radius);
    }

}