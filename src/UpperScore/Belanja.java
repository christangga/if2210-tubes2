package UpperScore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Belanja
{
	//Attribute
	private List<Item> shoppingList;
        private String supermarket;
        
        // Constructors
        public Belanja() //ctor
	{
            supermarket=null;
            shoppingList = new ArrayList<Item>();
	}
        
	public Belanja (String sm,List<Item> _belanja) //ctorparam
	{
            supermarket=sm;
            shoppingList = new ArrayList<Item>(_belanja);
	}
        
        
	// Getters and Setters
        public String getsupermarket()
        {
            return supermarket;
        }
        
        public void setsupermarket(String sm) 
        {
            supermarket = sm;
	}
        
        
        public List<Item> getshoppingList()
        {
            return shoppingList;
        }
        
        public void setshoppingList(List<Item> shoppingList) 
        {
            shoppingList = shoppingList;
	}
        
        // Methods
	public void addBelanja (Barcode id, int quantity)
        //id pasti ada di supermarket
	{
            MySQLAccess db=new MySQLAccess();
            List<Produk> listproduk =db.getAllProduk(supermarket);
            int i=0;
            boolean found=false;
            
            while(!found)
            {
                if(listproduk.get(i).getBarcode()==id)
                {
                    found=true;
                    String nama=listproduk.get(i).getNama();
                    int harga=listproduk.get(i).getHarga();
                    List<String> tag=listproduk.get(i).getTag();
                    
                    Item item=new Item(id, nama, harga, tag, quantity);
                    shoppingList.add(item);
                }
                i++;
            }
               
	}

	public void delBelanja (Item _item)
	{
            shoppingList.remove(_item);
	}
        
        public void print ()
	{
            System.out.println("---------------------");
            if(shoppingList.size()>0)
            {
                System.out.println("Shopping List :");
                for(Item I : shoppingList){
                    I.print();
                }
            }
            else
            {
                System.out.println("Shopping List : -");
            }
            System.out.println("---------------------");
	}
        
        public void menu()
	{
            boolean exit=false;
            while(!exit)
            {
                print();
                System.out.println("1. Add Shopping List");
                System.out.println("2. Set Quantity");
                System.out.println("3. Delete Shopping List");
                System.out.println("4. Back");
                System.out.println("Choose: ");
                Scanner in=new Scanner(System.in);
                int pilihan=in.nextInt();
                if(pilihan==1)
                {
                    System.out.print("Add Barcode: ");
                    String barcodeid=in.next();
                    System.out.print("Add Quantity: ");
                    int quantity=in.nextInt();
                    
                    Barcode bc=new Barcode(barcodeid);
                    addBelanja(bc, quantity);
                }
                else if(pilihan==2)
                {
                    if(shoppingList.size()>0)
                    {
                        //print list belanjaan
                        System.out.println("Shopping List :");
                        int i=1;
                        for(Item I : shoppingList)
                        {
                            System.out.println("Shopping List :");
                            System.out.println(i+".");
                            I.print();
                            i++;
                        }
                        
                        System.out.print("Insert index: ");
                        int index=in.nextInt();
                        System.out.print("Set Quantity: ");
                        int quantity=in.nextInt();
                        
                        shoppingList.get(index-1).setQuantity(quantity);
                        
                    }
                    else
                    {
                        System.out.println("Shopping List : -");
                        System.out.print("Press any key to continue: ");
                        String any=in.next();
                    }
                    
                }
                else if(pilihan==3)
                {
                    //print list belanjaan
                    System.out.println("Shopping List :");
                    int i=1;
                    for(Item I : shoppingList)
                    {
                        System.out.println("Shopping List :");
                        System.out.println(i+".");
                        I.print();
                        i++;
                    }
                    
                    System.out.print("Delete index: ");
                    int index=in.nextInt();
                    Item item=new Item(shoppingList.get(index-1).getBarcode(),shoppingList.get(index-1).getNama() , shoppingList.get(index-1).getHarga(), shoppingList.get(index-1).getTag(), shoppingList.get(index-1).getQuantity() );
                    delBelanja (item);

                }
                else if(pilihan==4)
                {
                    exit=true;
                }
                else
                {
                    System.out.println("input error.");
                }
                
            }
            
        }
        
}