package com.company;
import java.io.*;
import java.util.Scanner;


public class QuickFind1 {

    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        int id[] = new int[N];
        int memAccess = 0;
        for (int i = 0; i < N; i++)
        {
            memAccess++ ;
            id[i] = i;
        }

        Scanner in = new Scanner(System.in);
        DumpIdArray(id, 10);
        int M = 0;
        while (in.hasNextInt())
        {
            M++;
            int p = in.nextInt(), q = in.nextInt();

            // two more accesses coming up
            memAccess += 2;
            int t = id[p];
            if (t == id[q])
            {
                // debug code to print out the connection set we added to
                // not counting memory accesses on this one
                System.out.print("Existing connection. The connected set is  : ");
                for (int i = 0; i < N; i++)
                {
                    if (id[i] == t)
                    {
                        System.out.print(" " + i);
                    }
                }
                System.out.println("");
                DumpIdArray(id, 10);
                continue;
            }
            for (int i = 0; i < N; i++)
            {
                memAccess++;
                if (id[i] == t)
                {
                    memAccess += 2;
                    id[i] = id[q];
                }
            }
            System.out.println("New Connection " + p + " " + q);
            DumpIdArray(id, 10);
        }
        System.out.println("N = " + N + " M = " + M);
        System.out.println("No. of memory accesses = " + memAccess);


    }

    public static void DumpIdArray(int[] id, int l)
    {
        System.out.print("Id : [");
        for (int i = 0; i < l; i++)
        {
            System.out.print(id[i] + " ");
        }
        System.out.println("]");
    }
}
