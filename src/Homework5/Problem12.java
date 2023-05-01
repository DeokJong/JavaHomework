package Homework5;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Problem12 {
    public static void main(String[] args){
        new GraphicEditor();
    }
}

abstract class Shape{
    private Shape next;

    public Shape(){this.next=null;}

    public void setNext(Shape obj){this.next=obj;}
    public Shape getNext(){return next;}
    public abstract void draw();
}
class Line extends Shape{
    public void draw(){
        System.out.print("Line\n");
    }
}
class Rect extends Shape{
    public void draw(){
        System.out.print("Rect\n");
    }
}
class Circle extends Shape{
    public void draw(){
        System.out.print("Circle\n");
    }
}

class GraphicEditor{
    Shape head,tail;
    Scanner scan = new Scanner(System.in);

    public GraphicEditor(){
        this.head=null;
        this.tail=null;
        showMenu();
    }

    public void insert(Shape obj){
        if(head==null){
            this.head=obj;
            this.tail=obj;
        }
        else{
            this.tail.setNext(obj);
            this.tail=this.tail.getNext();
        }
    }
    public void delete(int location){
        Shape prevP=null;
        Shape currP = head;

        if(isEmpty()){
            System.out.print("Can't delete!");
            return ;
        }
        for(int i =0;i<location;i++){
            if(currP==null){
                System.out.println("Can't delete!");
                return ;
            }
            else if(location==1){
                this.head=this.head.getNext();
            }
            else if(i==location-1){
                if(currP.getNext()==null){
                    this.tail=prevP;
                    prevP.setNext(currP.getNext());
                }
                else prevP.setNext(currP.getNext());
            }
            else{
                prevP=currP;
                currP=currP.getNext();
            }
        }
    }
    public void display(){
        if(isEmpty()){
            System.out.print("Editor is Empty!\n");
            return ;
        }
        Shape tempP=head;
        while(tempP!=null){
            tempP.draw();
            tempP=tempP.getNext();
        }
    }
    public void done(){
        System.out.println("Graphic Editor is Done!");
        System.out.print("201916136 Jin DeokJong "+LocalDateTime.now());
    }

    private int getOption(){
        int temp;
        while(true){
            try{
                System.out.print("Line(1),  Rect(2),  Circle(3)>>");
                temp=scan.nextInt();
                if(temp<0||3<temp) throw new IllegalAccessException();
            }
            catch(InputMismatchException e){
                scan.nextLine();
                System.out.print("Input Mismatch! try again!\n");
                continue;
            }
            catch(IllegalAccessException e){
                System.out.print("This is not able range! try again!\n");
                continue;
            }
            break;
        }
        return temp;
    }
    private int getLocation(){
        int temp;
        while(true){
            try{
                System.out.print("Delete Shape Location>>");
                temp=scan.nextInt();
                if(temp<0) throw new IllegalAccessException();
            }
            catch(InputMismatchException e){
                scan.nextLine();
                System.out.print("Input Mismatch! try again!\n");
                continue;
            }
            catch(IllegalAccessException e){
                System.out.print("This is not able range! try again!\n");
                continue;
            }
            break;
        }
        return temp;
    }
    private int getMenuOption(){
        int temp;
        while(true){
            try{
                System.out.print("Insert(1),  Delete(2),  Display(3),  Done(4)>>");
                temp=scan.nextInt();
                if(temp<0||4<temp) throw new IllegalAccessException();
            }
            catch(InputMismatchException e){
                scan.nextLine();
                System.out.print("Input Mismatch! try again!\n");
                continue;
            }
            catch(IllegalAccessException e){
                System.out.print("This is not able range! try again!\n");
                continue;
            }
            break;
        }
        return temp;
    }

    private void showMenu(){
        int option;
        boolean out=false;
        System.out.println("Graphic Editor is Running!");
        while(!out){
            option=getMenuOption();

            switch (option) {
                case 1 -> {
                    switch (getOption()) {
                        case 1 -> insert(new Line());
                        case 2 -> insert(new Rect());
                        case 3 -> insert(new Circle());
                    }
                }
                case 2 -> delete(getLocation());
                case 3 -> display();
                case 4 -> {
                    done();
                    out=true;
                }
            }
        }
    }

    public boolean isEmpty(){return head==null;}
}