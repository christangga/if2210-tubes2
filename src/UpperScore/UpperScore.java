package UpperScore;

import java.util.Scanner;


public class UpperScore {
    
        public static void main(String[] args){
        
        boolean exit=false;
        Notes note=new Notes();
        Belanja belanja=new Belanja();
        
        while(!exit)
        {
            System.out.println("Menu");
            System.out.println("1.Notes");
            System.out.println("2.Shop");
            System.out.println("3.Exit");
            System.out.print("Pilih: ");

            Scanner in=new Scanner(System.in);
            int pilihan=in.nextInt();

            if(pilihan==1)
            {
                note.menu();
                
            }
            else if(pilihan==2)
            {
                System.out.println("Choose Supermarket: ");
                String sm=in.next();
                belanja.setsupermarket(sm);
                belanja.menu();
            }
            else if(pilihan==3)
            {
                exit=true;
                
            }
        }
        
        
    }
  
}