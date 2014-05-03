package UpperScore;

import java.util.Scanner;
import java.util.Vector;

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
                belanja.print();
            }
            else if(pilihan==3)
            {
                exit=true;
                
            }
        }
        
        
            
        
        /*
       Barcode bar = new Barcode();
       Barcode bar2 = new Barcode("208409328402938");
       bar.PrintBarcode();
       bar2.PrintBarcode();
       
       Vector<String> tagg = new Vector<String>();
       tagg.add("biskuit");
       tagg.add("renyah");
       tagg.add("enak");
       
       Produk pro = new Produk();
       pro.PrintProduk();
       Produk pro2 = new Produk(bar2,"tango",5000,tagg);
       pro2.PrintProduk();
       
       Item item = new Item();
       item.PrintItem();
       Item item2 = new Item(bar,"tango",5000,tagg,200);
       item2.PrintItem();
       
       Notes note = new Notes();
       note.PrintNotes();
       Notes note2 = new Notes(tagg,50000);
       note2.PrintNotes();
       
       Supermarket sm = new Supermarket();
       sm.PrintSupermarket();
       Supermarket sm2 = new Supermarket("Giant");
       sm2.AddProduk(pro);
       sm2.AddProduk(pro2);
       sm2.PrintSupermarket();
       
       
       Belanja belanja = new Belanja();
       belanja.PrintBelanja();
       Belanja belanja2 = new Belanja();
       belanja2.AddBelanja(item);
       belanja2.AddBelanja(item2);
       belanja2.PrintBelanja();
       
        /*
       
       MySQLAccess dao = new MySQLAccess();
       try{
           dao.readDataBase();
       }
       catch(Exception e)
       {System.err.println(e);} 
      
       */
    }
   
    
}
    

