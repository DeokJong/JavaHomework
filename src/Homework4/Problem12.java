package Homework4;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Problem12 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int ch;

        Hall mainHall = new Hall();

        System.out.println("Premium Concert Hall Reservation System. Type option");
        while(true) {
            System.out.print("Reserve : 1  Display : 2  Cancel Reservation : 3  exit : 4  >>");
            try {
                ch=scan.nextInt();
            }
            catch(InputMismatchException e) {
                System.out.println("Wrong input. try again\n");
                scan.nextLine();
                continue;
            }

            if(ch<1||4<ch) {
                System.out.println("Wrong input. Option range is 1~4. Try again!\n");
                continue;
            }

            if(ch==4) {
                System.out.println("Thank you");
                break;
            }

            switch(ch) {
                case 1:
                    mainHall.reserve();
                    break;
                case 2:
                    mainHall.display();
                    break;
                case 3:
                    mainHall.cancelReservation();
                    break;
            }
        }
        scan.close();
    }

}


class Hall{
    private String seat[][] = new String[3][10];
    private Scanner scan = new Scanner(System.in);

    public Hall() {
        for(int i =0;i<3;i++) {
            for(int j =0;j<10;j++) seat[i][j]="---";
        }
    }

    public int getSeatClass() {
        int seatClass;
        while(true) {
            try {
                System.out.print("Type Seat Class : S(1)  A(2)  B(3)>>");
                seatClass=scan.nextInt();
                seatClass--;
            }
            catch(InputMismatchException e) {
                System.out.println("Wrong input. try again");
                scan.nextLine();
                continue;
            }

            if(2<seatClass||seatClass<0) {
                System.out.println("Seat class range is 1~3. try again type");
                continue;
            }

            break;
        }

        return seatClass;
    }
    private int getSeatNumber() {
        int seatNum;
        while(true) {
            try{
                System.out.print("Type Seat Number>>");
                seatNum=scan.nextInt();
                seatNum--;
            }
            catch(InputMismatchException e) {
                System.out.println("Wrong input. try again");
                scan.nextLine();
                continue;
            }

            if(9<seatNum||seatNum<0) {
                System.out.println("Seat Number range is 1~10. try again type");
                continue;
            }
            break;
        }
        return seatNum;
    }
    private String getName() {
        String name;
        System.out.print("name>>");
        name=scan.next();
        scan.nextLine();
        return name;
    }

    private void showLine(int seatClass) {
        if(seatClass==0) System.out.print("S>> ");
        else if(seatClass==1) System.out.print("A>> ");
        else System.out.print("B>> ");

        for(int i =0;i<10;i++) {
            System.out.printf("%s ",seat[seatClass][i]);
        }
        System.out.println();
    }

    private boolean isEmptySeat(int seatClass,int seatNumber) {
        if(seat[seatClass][seatNumber].equals("---")) return true;
        else return false;
    }
    private boolean isFull(int seatClass){
        for(int i =0;i<10;i++) {
            if(!seat[seatClass][i].equals("---")) continue;
            return false;
        }

        return true;
    }
    private boolean isEmpty(int seatClass) {
        for(int i = 0;i<10;i++) {
            if(seat[seatClass][i].equals("---"))continue;
            return false;
        }
        return true;
    }
    private boolean isName(int seatClass,String name) {
        for(int i =0;i<10;i++) {
            String tempName=seat[seatClass][i];
            if(tempName.equals(name)) return true;
        }
        return false;
    }
    private int findName(int seatClass,String name) {
        for(int i =0;i<10;i++) {
            if(seat[seatClass][i].equals(name)) return i;
        }
        return -1;
    }

    public void reserve() {
        int seatClass;
        if(isFull(1)&&isFull(2)&&isFull(0)) {
            System.out.println("Sorry, All seat is reserved!");
            return;
        }


        seatClass=getSeatClass();
        if(isFull(seatClass)) {
            System.out.println("All seat of this seat class is reserved!");
            return ;
        }

        System.out.println();
        showLine(seatClass);
        String name=getName();
        int seatNum=getSeatNumber();

        if(!isEmptySeat(seatClass,seatNum)) {
            System.out.println("this seat is already reserved.");
            return ;
        }
        seat[seatClass][seatNum]=name;
        System.out.println("reservation complete!");
    }
    public void display() {
        showLine(0);
        showLine(1);
        showLine(2);
    }
    public void cancelReservation() {
        int seatClass=getSeatClass();
        if(isEmpty(seatClass)) {
            System.out.println("This class is not reserved");
            return ;
        }
        showLine(seatClass);

        String name=getName();
        if(!isName(seatClass, name)) {
            System.out.println("not found this name!");
            return ;
        }

        int seatNum=findName(seatClass, name);

        seat[seatClass][seatNum]="---";
        System.out.println("Reservation cancel is complete!");
    }

}
