package com.company;
import java.io.*;
import java.util.Scanner;


public class QuickFind1 {

    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        int id[] = new int[N];
        for (int i = 0; i < N; i++)
        {
            id[i] = i;
        }

        Scanner in = new Scanner(System.in);


        while (in.hasNextInt())
        {
            int p = in.nextInt(), q = in.nextInt();
            int t = id[p];
            if (t == id[q]) continue;
            for (int i = 0; i < N; i++)
            {
                if (id[i] == t)
                {
                    id[i] = id[q];
                }
            }
            System.out.println(" " + p + " " + q);
        }


    }
}
