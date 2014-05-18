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
        
        //mengatur supermarket menjadi supemarket yang dipilih
        public void setsupermarket(String sm) 
        {
            supermarket = sm;
	}
        
        //menadapatkan barang apa saja yang sudah dibeli
        public List<Item> getshoppingList()
        {
            return shoppingList;
        }
        
        //mengatur daftar barang yang sudah dibeli
        public void setshoppingList(List<Item> shoppingList) 
        {
            shoppingList = shoppingList;
	}
        
        // Methods
	public void addBelanja (Barcode id, int quantity) throws USException
        //id pasti ada di supermarket, kalo id udah ada di shoppinglist ditambah quantitynya aja
	{
            boolean found=false;
            int i=0;
            
            //mencari apakah di shopping list ada di barcode atau tidak
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
            
            //jika barcode belum ada, tambahkan ke shopping list
            if(!found)
            {
                MySQLAccess db=new MySQLAccess();
                Produk  produk=new Produk();
                
                produk =db.getProduk(supermarket, id);
                String nama=produk.getNama();
                int harga=produk.getHarga();
                List<String> tag=produk.getTag();

                Item item=new Item(produk.getBarcode(), nama, harga, tag, quantity);
                shoppingList.add(item);   
            }
            else
                //jika barcode sudah ada di shopping list, tambahkan kuantitasnya
            {
                shoppingList.get(i).setQuantity(shoppingList.get(i).getQuantity() + quantity);
            }
	}

        //menghapus barang dari shopping list
	public void delBelanja (int index)
	{
            shoppingList.remove(index);
	}
        
        //menghapus semua isi shopping list
        public void delShoppingList()
        {
            shoppingList.clear();
        }
        
        //tampilan daftar belanja
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
        
        //menghitung total harga
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
                
                //langsung keluar dari program jika masukan tidak valid           
                assert (pilihan>=0 && pilihan<=5 ): "Invalid input" ;
                
                //memilih pilihan "Add Shopping List"
                if(pilihan==1)
                {
                    System.out.print("Add Barcode: ");
                    String barcodeid=in.next();
                    System.out.print("Add Quantity: ");
                    int quantity=in.nextInt();
                    assert (quantity>0 ): "quantity must be above 0" ;
                    Barcode bc=new Barcode(barcodeid);
                    try
                    {
                        addBelanja(bc, quantity);
                    }
                    catch(USException e)
                    {
                        e.showMessage();
                    }
                }
                //memilih pilihan "Set Quantity"
                else if(pilihan==2)
                {
                    //jika shopping list tidak kosong
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
                        assert (index >0 && index <=shoppingList.size() ): "Invalid input" ;
                        System.out.print("Set Quantity: ");
                        int quantity=in.nextInt();
                        
                        //akan langsung keluar jika masukan tidak valid
                        assert (quantity>=0 ): "quantity must be >= 0" ;
                        if(quantity >0)
                        {
                            shoppingList.get(index-1).setQuantity(quantity);
                        }
                        
                        /*jika mengeset kuantitas menjadi 0, maka akan menghapus barang
                        dari daftar belanjaan*/
                        else if(quantity==0)
                        {
                           delBelanja(index-1);
                        }
                    }
                    
                    //jika shopping list masih kosong, tidak melakukan apa-apa
                    else
                    {
                        System.out.println("Shopping List : -");
                        System.out.print("Press enter to continue: ");
                        String any=in.nextLine();
                        any=in.nextLine();
                    }
                }
                
                //memilih "Delete Shopping List"
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
                    //langsung keluar dari program jika masukan tidak valid
                    assert (index > 0 && index<=shoppingList.size() ): "Invalid input" ;
                    delBelanja (index-1);
                }
                
                //memilih "Preview"
                else if(pilihan==4)
                {
                     finish=menuReview();
                     //memilih untuk selesai belanja
                     if(finish)
                     {
                        exit=true;
                     }
                }
                
                //memilih untuk keluar dari program
                else if(pilihan==5)
                {
                    exit=true;
                }
            }
            return finish;
        }
        
        public boolean menuReview()
        {
            boolean exit=false;
            boolean finish=false; 
            
            //meng-update barang apa saja yang sudah dibeli dan belum dibeli
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
                        //barang yang sudah dibeli dan terdapat di notes
                        if(shoppingList.get(i).getTag().contains(s))
                        {
                            found=true;
                            sudahbelanja.add(s);
                        }
                        i++;
                    }
                    
                    //barang yang ada di notes yang belum dibeli
                    if(!found)
                    {
                        belumbelanja.add(s);
                    }
                }
                System.out.println("===============================");
                System.out.println("Preview:  ");
                System.out.print("Barang yang sudah dibelanja: ");
                //menampilkan barang apa saja yang sudah dibeli
                if(sudahbelanja.size()>0)
                {
                    System.out.println("");
                    for(String s:sudahbelanja)
                    {
                        System.out.println(s);
                    }
                }
                else
                {
                    System.out.println("-");
                }
                
                //menampilkan barang apa saja yang ada di notes tapi belum dibeli
                System.out.print("Barang yang belum dibelanja: ");
                if(belumbelanja.size()>0)
                {
                    System.out.println("");
                    for(String s:belumbelanja)
                    {
                        System.out.println(s);
                    }
                }
                else
                {
                    System.out.println("-");
                }

                //menampilkan total harga belanjaan
                System.out.println("Total Belanja: "+totalHarga());
                
                /*akan menampilkan barang apa saja yang tidak ada di notes tapi
                dibeli jika total belanjaan lebih dari budget*/
                if(totalHarga()> UpperScore.note.getBudget())
                {
                    List<String> belanjalebih=new ArrayList<String>();
                    for(Item I:shoppingList)
                    {
                        boolean found=false;
                        int j=0;
                        //mengecek apakah barang yang ada di daftar barang belanjaan ada di notes
                        while(!found & j<I.getTag().size())
                        {
                            if(UpperScore.note.getList().contains(I.getTag().get(j)))
                            {
                                found=true;
                            }
                            j++;
                        }
                        //jika barang yang dibeli tidak ada di notes, masukkan ke kategori belanja lebih
                        if(!found)
                        {
                            belanjalebih.add(I.getNama());
                        }
                    }
                    
                    //menampilkan barang kategori belanja lebih
                    System.out.println("Barang yang berlebih: ");
                    if(belanjalebih.size()>0)
                    {
                        for(String s:belanjalebih)
                        { 
                            System.out.println(s);
                        }
                    }
                    else
                    {
                        System.out.println("-");
                    }
                    
                }
                System.out.println("===============================");
                System.out.println("1.Finish Shopping");
                System.out.println("2.Back");
                System.out.println("Choose: ");
                Scanner in=new Scanner(System.in);
                int pilihan=in.nextInt();
                
                //akan keluar dari program jika masukan tidak valid
                assert (pilihan>0  && pilihan <=2): "Invalid input" ;
                if(pilihan==1)
                {
                    if(shoppingList.size()>0)
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
                    
                    //Belum membeli apa-apa
                    else
                    {
                        System.out.println("You don't buy anything.");
                        System.out.println("Exit shopping from "+supermarket + "? ");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        int index=in.nextInt();
                        assert (index>0  && pilihan <=2): "Invalid input" ;
                        if(index==1)
                        {
                            exit=true;
                            finish=true;
                        }
                        //kembali ke menu belanja
                        else if(index==2)
                        {
                            exit = true;
                        }
                    }
                }
                else if(pilihan==2)
                {
                    exit=true;
                }
            }
            return finish;
        }
}