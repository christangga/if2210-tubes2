package UpperScore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Notes 
{
    // Attributes
    private List<String> list;
    private int budget;
    
   // Constructors
    Notes()
    {
       list=new ArrayList<>();
       budget=0; 
    }
    
    Notes(List<String> _list, int _budget)
    {
       list=new ArrayList<>();
       list=_list;
       budget=_budget; 
    }
    
    // Getters and Setters
    public int getBudget()
    {
        return budget;
    }
    
    public List<String> getList()
    {
        return list;
    }
    
    public void setBudget(int newbudget)
    {
        budget=newbudget;
    }
    
    public void setList(List<String> list) 
    {
	list = list;
    }
    
    // Methods
    public void addList(String newlist)
    {
        list.add(newlist);
    }
    
   
    public void delList(String dellist)
    {
        list.remove(dellist);
    }
    
    public void print()
    {
        System.out.println("-----------------------------");
        System.out.println("Notes");
        System.out.println("List  : "+list);
        System.out.println("Budget: "+budget);
        System.out.println("-----------------------------");
       
    }
    
    public void menu()
    {
        
        boolean exit =false;
        while(!exit)
        {
            print();
            System.out.println("1. Set Budget");
            System.out.println("2. Add List");
            System.out.println("3. Delete List");
            System.out.println("4. Back");
            System.out.println("Choose: ");
            Scanner in=new Scanner(System.in);
            int pilihan=in.nextInt();
            if(pilihan==1)
            {
                System.out.print("Set Budget: ");
                int budget=in.nextInt();
                setBudget(budget);
            }
            else if(pilihan==2)
            {
                System.out.print("Add List: ");
                String add=in.next();
                if(!list.contains(add))
                {
                    addList(add);
                }
                
            }
            else if(pilihan==3)
            {
                System.out.print("Delete List: ");
                String del=in.next();
                if(list.contains(del))
                {
                    delList(del);
                }
                
            }
            else if(pilihan==4)
            {
                exit=true;
            }
            else
            {
                
            }
                   
            
        }
    
        
        
    }
}
