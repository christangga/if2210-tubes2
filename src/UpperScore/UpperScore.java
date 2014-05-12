package UpperScore;

import java.util.ArrayList;
import java.util.List;
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
                        System.out.println("Supermarket: ");
                        List <String> supermarket=new ArrayList<> ();
                        
                        MySQLAccess a=new MySQLAccess();
                        supermarket=a.getSupermarket();
                        int i=0;
                        for(String s: supermarket)
                        {
                            i++;
                            System.out.println(i+". "+s);
                        }
                        System.out.println("Choose Supermarket: ");
                        int index=in.nextInt();
                        
                        String sm=supermarket.get(index-1);
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
                        note.setBudget(0);
                    }
                }
                else if(pilihan==3)
                {
                    exit=true;
                }
            }
    }
}