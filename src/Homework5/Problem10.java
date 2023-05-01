package Homework5;

import java.time.LocalDateTime;

public class Problem10 {
    public static void main(String[] args){
        //문제 10번에 아이템 출력하는 형태를 Show() 함수로 구현해서 대체하였음
        Dictionary dic = new Dictionary(10);
        dic.put("Kim","Java");
        dic.put("Lee","Python");
        dic.put("Lee","C++");
        dic.show("Lee");
        dic.show("Kim");
        dic.delete("Kim");
        dic.show("Kim");

        System.out.print("201916136 Jin DeokJong "+ LocalDateTime.now());
    }
}


abstract class PairMap{
    protected String[] keyArray;
    protected String[] valueArray;

    abstract String get(String key);
    abstract void put(String key,String value);
    abstract String delete(String key);
    abstract int length();
}

class Dictionary extends PairMap{
    private int size;
    public Dictionary(int size){
        keyArray = new String[size];
        valueArray = new String[size];
        this.size=size;

        for(int i = 0 ; i<size;i++){
            keyArray[i]=null;
            valueArray[i]=null;
        }
    }

    @Override
    public String get(String key){
        for(int i =0;i<size;i++){
            if(key.equals(keyArray[i])){return valueArray[i];}
        }
        return null;
    }

    @Override
    public void put(String key,String value){
        if(!isOverlapping(key)) {
            for (int i = 0; i < size; i++) {
                if (keyArray[i] == null) {
                    keyArray[i] = key;
                    valueArray[i] = value;
                    return;
                }
            }
        }
        else {
            int loc=findLoc(key);
            if(loc==-1){
                System.out.println("ERROR!!!!!!!!!!! FIX THIS PROGRAM!");
                System.exit(0);
            }
            else{
                 valueArray[loc]=value;
            }
            return ;
        }
        System.out.printf("Fail put %s because Dictionary is Full!\n",key);
    }

    @Override
    public String delete(String key){
        for(int i =0 ; i<size;i++){
            if(key.equals(keyArray[i])){
                String tempStr= new String(valueArray[i]);
                keyArray[i]=null;
                valueArray[i]=null;
                return tempStr;
            }
        }
        return null;
    }

    public int length(){
        return size;
    }

    private boolean isOverlapping(String key){
        for(int i = 0 ;i<size;i++){
            if(keyArray[i]==null) continue;
            else if(keyArray[i].equals(key)) return true;
        }
        return false;
    }

    private int findLoc(String key){
        for(int i = 0 ;i<size;i++){
            if(keyArray[i]==null) continue;
            if(keyArray[i].equals(key)) return i;
        }
        return -1;
    }

    public void show(String key){
        System.out.printf("Value of %s is %s\n",key,get(key));
    }
}