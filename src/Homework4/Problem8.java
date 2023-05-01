package Homework4;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Problem8 {
    public static void main(String arg[]){
        Scanner scan = new Scanner(System.in);
        int peopleNum;

        while(true){
            try{
                System.out.print("people number>>");
                peopleNum=scan.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("Wrong input. retry type people number");
                scan.nextLine();
                continue;
            }
            break;
        }

        PhoneBook pb = new PhoneBook(peopleNum);
        System.out.println("Phone number is storage....");
        while(true){
            System.out.print("find name>>");
            String name=scan.next();
            if(name.equals("그만")) break;
            pb.findPeople(name);
        }
    }
}

class Phone{
    Scanner scan = new Scanner(System.in);
    public String name;
    public int firstTel;
    public int secondTel;
    public Phone(){
        while(true) {
            System.out.print("name and phone number(not include blank space)>>");
            name = scan.next();
            String tempStr=scan.next();
            try{
               firstTel=Integer.parseInt(tempStr.substring(0,3));
               secondTel=Integer.parseInt(tempStr.substring(4,8));
            }
            catch(NumberFormatException e){
                System.out.println("This phone number is not able format. retry type");
                continue;
            }
            catch(IndexOutOfBoundsException e){
                System.out.println("This phone number is not able format. retry type");
                continue;
            }

            if(tempStr.charAt(3)!='-'){
                System.out.println("This phone number is not able format. retry type");
                continue;
            }
            break;
        }
    }

    public boolean isName(String name){
        return this.name.equals(name);
    }

    public void display(){
        System.out.printf("Phone number of %s is %d-%d\n",name,firstTel,secondTel);
    }
}

class PhoneBook{
    Phone list[];
    int size;
    public PhoneBook(int size){
        this.size=size;
        list = new Phone[size];
        for(int i =0;i<size;i++){
            list[i]=new Phone();
        }
    }

    public void findPeople(String name){
        for(int i =0;i<size;i++){
            if(list[i].isName(name)){
                list[i].display();
                return ;
            }
        }
        System.out.printf("%s is not exist\n",name);
    }
}
