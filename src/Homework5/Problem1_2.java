package Homework5;

import java.time.LocalDateTime;

public class Problem1_2 {
    public static void main(String[] arg){
        ColorTV myTV = new ColorTV(32,1024);
        myTV.printProperty();//problem 1

        IPTV iptv = new IPTV("192.1.1.2",32,2048);
        iptv.printProperty();//problem 2

        System.out.println("201916136 Jin DeokJong "+LocalDateTime.now());
    }
}

class TV{
    private int size;
    public TV(int size){this.size = size;}

    protected int getSize(){return this.size;}

    public void printProperty(){
        System.out.printf("%d inch TV\n",size);
    }
}

class ColorTV extends TV{//problem 1
    private int color;

    public ColorTV(int size, int color){
        super(size);
        this.color = color;
    }

    public ColorTV(int size){
        super(size);
        this.color=-1;
    }

    public int getColor(){return color;}

    @Override
    public void printProperty(){
        System.out.printf("%d inch %d color TV\n",getSize(),color);
    }
}

class IPTV extends ColorTV{//problem 2
    private String ip;

    public IPTV(String ip,int size,int color){
        super(size,color);
        this.ip=ip;
    }

    public IPTV(int size,int color){
        super(size,color);
        ip=null;
    }

    @Override
    public void printProperty(){
        if(ip==null) super.printProperty();
        else System.out.printf("My IPTV is %d inch %d color of %s address\n",getSize(),getColor(),ip);
    }
}
