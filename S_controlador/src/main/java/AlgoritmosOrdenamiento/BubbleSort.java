/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AlgoritmosOrdenamiento;

/**
 *
 * @author Rajat Mishra
 */

/**
 * clase para poder hacer un ordenamiento con buble sort
 * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556, gabriel 
 */
public class BubbleSort {
    public static void bubbleSort(long arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    //  swap arr[j+1] and arr[j]
                    long temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }
    private void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
