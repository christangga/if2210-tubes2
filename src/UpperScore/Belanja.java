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
            //8990057704308
            if(!found)
            {
                MySQLAccess db=new MySQLAccess();
                Produk  produk=new Produk();
                produk =db.getProduk(supermarket, id);
                
                if(produk.getNama()!=null)
                {
                    String nama=produk.getNama();
                    int harga=produk.getHarga();
                    List<String> tag=produk.getTag();

                    Item item=new Item(produk.getBarcode(), nama, harga, tag, quantity);
                    shoppingList.add(item);
                }
                else
                {
                    System.out.println(id.getId()+" not exist");
                }
                
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
        
        public void delShoppingList()
        {
            shoppingList.clear();
        }
        
        public void print ()
	{
            System.out.println("-------------------------------------");
            System.out.println("-------------------------------------");
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
            System.out.println("-------------------------------------");
            System.out.println("-------------------------------------");
	}
        
        public int totalHarga()
        {
            int total=0;
            for(Item i:shoppingList )
            {
                total=total+(i.getQuantity() *i.getHarga());
            }
            return total;
        }
        
        public boolean menu()
	{
            boolean finish=false;
            boolean exit=false;
            while(!exit)
            {
                print();
                System.out.println("1. Add Shopping List");
                System.out.println("2. Set Quantity");
                System.out.println("3. Delete Shopping List");
                System.out.println("4. Preview");
                System.out.println("5. Back");
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
                     finish=menuReview();
                     if(finish)
                     {
                        exit=true;
                     }
                         
                }
                else if(pilihan==5)
                {
                    exit=true;
                }
                else
                {
                    System.out.println("Index out of bound");
                }
                
            }
            return finish;
            
        }
        
        public boolean menuReview()
        {
            boolean exit=false;
            boolean finish=false; 
            while(!exit)
            {
                List<String> sudahbelanja=new ArrayList<String>();
                List<String> belumbelanja=new ArrayList<String>();
                for(String s:UpperScore.note.getList())
                {
                    boolean found=false;
                    int i=0;
                    while(!found && i <shoppingList.size())
                    {
                        if(shoppingList.get(i).getTag().contains(s))
                        {
                            found=true;
                            sudahbelanja.add(s);
                        }
                        i++;
                    }
                    if(!found)
                    {
                        belumbelanja.add(s);
                    }
                }
                System.out.println("===============================");
                System.out.println("Preview:  ");
                System.out.println("Barang yang sudah dibelanja: ");
                for(String s:sudahbelanja)
                {
                    System.out.println(s);
                }
                System.out.println("Barang yang belum dibelanja: ");
                for(String s:belumbelanja)
                {
                    System.out.println(s);
                }

                System.out.println("Total Belanja: "+totalHarga());
                if(totalHarga()> UpperScore.note.getBudget())
                {
                    List<String> belanjalebih=new ArrayList<String>();
                    for(Item I:shoppingList)
                    {
                        boolean found=false;
                        int j=0;
                        while(!found & j<I.getTag().size())
                        {
                            if(UpperScore.note.getList().contains(I.getTag().get(j)))
                            {
                                found=true;
                            }
                            j++;
                        }

                        if(!found)
                        {
                            belanjalebih.add(I.getNama());
                        }
                    }
                    System.out.println("Barang yang berlebih: ");
                    for(String s:belanjalebih)
                    {
                        System.out.println(s);
                    }

                }
                System.out.println("===============================");
                System.out.println("1.Finish Shopping");
                System.out.println("2.Back");
                System.out.println("Choose: ");
                Scanner in=new Scanner(System.in);
                int pilihan=in.nextInt();
                if(pilihan==1)
                {
                    System.out.println("Daftar Barcode Belanjaan: ");
                    int j=1;
                    for(Item I:shoppingList)
                    {
                        System.out.print(j+". ");
                        System.out.println(I.getBarcode().getId());
                        j++;
                    }
                    exit=true;
                    finish=true;
                }
                else if(pilihan==2)
                {
                    exit=true;
                }
                else
                {
                    System.out.println("Index out of bound");
                }
            }
            
            return finish;
        }
}