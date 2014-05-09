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
        //id pasti ada di supermarket, kalo id udah ada di shoppinglist ditambah quantitynya aja
	{
            boolean found=false;
            int i=0;
            while(!found && i<shoppingList.size())
            {
                if(shoppingList.get(i).getBarcode().getId().compareTo(id.getId()) ==0 )
                {
                    found=true;
                }
                else
                {
                    i++;
                }
                
            }
            //8990057426040
            if(!found)
            {
                MySQLAccess db=new MySQLAccess();
                Produk  produk=new Produk();
                produk =db.getProduk(supermarket, id);

                String nama=produk.getNama();
                int harga=produk.getHarga();
                List<String> tag=produk.getTag();

                Item item=new Item(id, nama, harga, tag, quantity);
                shoppingList.add(item);
            }
            else
            {
                shoppingList.get(i).setQuantity(shoppingList.get(i).getQuantity() + quantity);
            }
            
            
	}

	public void delBelanja (int index)
	{
            shoppingList.remove(index);
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
                            System.out.println(i+".");
                            I.print();
                            i++;
                        }
                        
                        System.out.print("Insert index: ");
                        int index=in.nextInt();
                        
                        
                        if(index >0 && index <=shoppingList.size())
                        {
                            System.out.print("Set Quantity: ");
                            int quantity=in.nextInt();
                            shoppingList.get(index-1).setQuantity(quantity);    
                        }
                        else
                        {
                            System.out.println("Index out of bound");
                        }
                        
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
                        System.out.println(i+".");
                        I.print();
                        i++;
                    }
                    
                    System.out.print("Delete index: ");
                    int index=in.nextInt();
                    if(index > 0 && index<=shoppingList.size())
                    {
                        delBelanja (index-1);

                    }
                    else
                    {
                        System.out.println("Index out of bound");
                    }
                    
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