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
            note.load();
            Belanja belanja=new Belanja();

            //menu utama
            while(!exit)
            {
                System.out.println("Menu");
                System.out.println("1.Notes");
                System.out.println("2.Shop");
                System.out.println("3.Exit");
                System.out.print("Pilih: ");

                //input pilihan menu
                Scanner in=new Scanner(System.in);
                int pilihan=in.nextInt();
                
                //akan keluar dari program jika pilihan tidak valid
                assert (pilihan>0  && pilihan <=3): "Invalid input" ;
                
                //masuk ke bagian note
                if(pilihan==1)
                {
                    note.menu();
                }
                //masuk ke bagian shopping
                else if(pilihan==2)
                {
                    if(finish)
                    {
                        System.out.println("Supermarket: ");
                        List <String> supermarket=new ArrayList<> ();
                        
                        //akses semua list supermarket
                        MySQLAccess a=new MySQLAccess();
                        supermarket=a.getSupermarket();
                       
                        int i=0;
                        for(String s: supermarket)
                        {
                            i++;
                            System.out.println(i+". "+s);
                        }
                        System.out.println("Choose Supermarket: ");
                         //baca masukan supermarket
                        int index=in.nextInt();
                        //akan keluar dari program jika masukan supermarket tidak valid
                        assert (index>=0 && index <= supermarket.size()): "Invalid input" ; 
                        String sm=supermarket.get(index-1);
                        belanja.setsupermarket(sm);                
                    }
                    
                    finish=belanja.menu();
                    //delete note yang telah dibelanja
                    if(finish)
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
                        belanja.delShoppingList();
                    }
                }
                //jika keluar dari program, note yang sudah ditulis tidak hilang
                else if(pilihan==3)
                {
                    note.save();
                    exit=true;
                }
            }
    }
}