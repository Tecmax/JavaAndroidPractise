package com.tecmax.methodExamples;

public class thread2 extends Thread {

 public void run()
 {
     try
     {
         
         System.out.println ("Thread " +
               Thread.currentThread().getId() +
               " is running");

     }
     catch (Exception e)
     {
         
         System.out.println ("Exception is caught");
     }
 }
}


public class thread3
{
 public static void main(String[] args)
 {
     int n =8;
     for (int i=0; i<8; i++)
     {
         thread2 object = new thread2();
         object.start();
     }
 }
}
