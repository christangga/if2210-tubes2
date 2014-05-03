package UpperScore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Belanja
{
	//Attribute
	private List<Item> shoppingList;
        
        // Constructors
        public Belanja() //ctor
	{
            shoppingList = new ArrayList<Item>();
	}
        
	public Belanja (List<Item> _belanja) //ctorparam
	{
            shoppingList = new ArrayList<Item>(_belanja);
	}
        
        
	// Getters and Setters
        public List<Item> getshoppingList()
        {
            return shoppingList;
        }
        
        public void setshoppingList(List<Item> shoppingList) 
        {
            shoppingList = shoppingList;
	}
        
        // Methods
	public void addBelanja (Item _item)
	{
            shoppingList.add(_item);
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
                    String add=in.next();
                    
                    System.out.print("Add Quantity: ");
                    int quantity=in.nextInt();
                    
                    //AddBelanja(add, quantity);
                    
                }
                else if(pilihan==2)
                {
                    //print list belanja
                    System.out.print("Insert index: ");
                    int index=in.nextInt();
                    
                    System.out.print("Set Quantity: ");
                    int quantity=in.nextInt();
                    
                    //set quantity
                }
                else if(pilihan==3)
                {
                    //print list belanja
                    System.out.print("Delete index: ");
                    int index=in.nextInt();
                    


                }
                else if(pilihan==4)
                {
                    exit=true;
                }
                else
                {

                }
                
                in.close();
            }
            
        }
        
}