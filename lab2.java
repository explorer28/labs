import java.util.*;
public class lab2 {
    public static void main(String[] args){
        Tasks.task1();
        Tasks.task2();
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

    public static void task2(){
        int rows, columns, currentLength = 1, maxLength = 1;
        System.out.println("Enter number of rows: ");
        rows = scan.nextInt();
        System.out.println("Enter number of columns: ");
        columns = scan.nextInt();
        if(rows*columns==0){
            System.out.println("Matrix size is ass");
            return;
        }
        int[] matrix = new int[rows*columns];
        for(int i = 0; i < rows*columns; i++){
            System.out.print(": ");
            matrix[i] = scan.nextInt(); 
        }
        printArray(matrix, rows, columns);

        for (int i = 1; i < rows*columns; i++) {
            if (matrix[i] > matrix[i - 1]) {
                currentLength++;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
            } else {
                currentLength = 1;
            }
        }
        System.out.println("number > in a row: " + maxLength);
    }

    public static void printArray(int[] arr, int rows, int columns){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                System.out.print(arr[i*columns+j] + " ");
            }
            System.out.println();
        }
    }
}
