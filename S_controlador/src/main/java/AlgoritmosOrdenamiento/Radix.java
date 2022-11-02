/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AlgoritmosOrdenamiento;

/**
 *
 * @author https://www.geeksforgeeks.org/radix-sort/
 */
// Radix sort Java implementation
 
import java.io.*;
import java.util.*;
 /**
 * clase para poder hacer un ordenamiento con radix
 * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556, gabriel 
 */
public class Radix {
 /**
 * metodo para obtener el mayor 
 * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556, gabriel 
 */
    private static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
     /**
 * metodo para contar al ordenar 
 * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556, gabriel 
 */
    private static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; 
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }
    
     /**
 * metodo llamar los metodos de get max y count sort para realizar el radix sort
 * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556, gabriel 
 */
    public static void radixsort(int arr[], int n)
    {
        int m = getMax(arr, n);
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }
    private static void print(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

}
