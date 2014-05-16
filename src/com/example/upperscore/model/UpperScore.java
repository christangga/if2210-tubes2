package com.example.upperscore.model;

import java.util.Scanner;


public class UpperScore {
        public static Notes note;
        
        public static void main(String[] args){
        
            boolean exit=false;
            boolean finish=true;
            note=new Notes();
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
                    if(finish)
                    {
                        System.out.println("Choose Supermarket: ");
                        String sm=in.nextLine();
                        sm=in.nextLine();
                        belanja.setsupermarket(sm);
                        belanja.delShoppingList();
                    }

                    finish=belanja.menu();
                    if(finish) //delete note yang udah dibelanja (?)
                    {
                        for(Item i:belanja.getshoppingList())
                        {
                            for(String s: i.getTag())
                            {
                                if(note.getList().contains(s))
                                {
                                    note.delList(s);
                                }
                            }
                        }
                    }
                }
                else if(pilihan==3)
                {
                    exit=true;
                }
            }
    }
}