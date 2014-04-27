package UpperScore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Belanja
{
	//Attribute
	private List<Item> ShoppingList;

	//Method
	Belanja() //ctor
	{
            ShoppingList = new ArrayList<Item>();
	}

	Belanja (List<Item> A) //ctorparam
	{
            ShoppingList = new ArrayList<Item>();
            ShoppingList = A;
	}

	public void AddBelanja (Item _item)
	{
            ShoppingList.add(_item);
	}

	public void DelBelanja (Item _item)
	{
            ShoppingList.remove(_item);
	}
        
        public void PrintBelanja ()
	{
            System.out.println("---------------------");
            if(ShoppingList.size()>0)
            {
                System.out.println("Shopping List :");
                for(Item I : ShoppingList){
                    I.PrintItem();
                }
            }
            else
            {
                System.out.println("Shopping List : -");
            }
            System.out.println("---------------------");
	}
        
        public void MenuBelanja ()
	{
            boolean exit=false;
            while(!exit)
            {
                PrintBelanja();
                System.out.println("1. Add Shopping List");
                System.out.println("2. Delete Shopping List");
                System.out.println("3. Back");
                System.out.println("Choose: ");
                Scanner in=new Scanner(System.in);
                int pilihan=in.nextInt();
                if(pilihan==1)
                {
                    System.out.print("Add Barcode: ");
                    String add=in.next();
                    
                }
                else if(pilihan==2)
                {
                    System.out.print("Delete Barcode: ");
                    String del=in.next();


                }
                else if(pilihan==3)
                {
                    exit=true;
                }
                else
                {

                }
            }
            
                   
            
        
        }
        
}