import java.util.*;
public class lab2 {
    public static void main(String[] args){
        Tasks.task1();

    }
}
public class Tasks{
    static Scanner scan = new Scanner(System.in);

    public static void task1(){
        int[] array = new int[6];
        for(int i = 0; i < array.length; i++){
            array[i] = scan.nextInt();
        }
        float arrayAvg = 0;
        for(int elem : array){
            arrayAvg += elem;
        }
        arrayAvg /= array.length;
        for(int num : array){
            if(Math.abs(num)>arrayAvg){
                System.out.println(num + ">" + arrayAvg);
            }
        }
    }

    public void task2(){

    }
}
