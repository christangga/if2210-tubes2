package UpperScore;

import java.util.Scanner;
import java.util.Vector;

public class Notes 
{
    private Vector<String> list;
    private int budget;
    
   
    Notes()
    {
       list=new Vector<>();
       budget=0; 
    }
    
    Notes(Vector<String> _list, int _budget)
    {
       list=new Vector<>();
       list=_list;
       budget=_budget; 
    }
   
    public int GetBudget()
    {
        return budget;
    }
    
    public Vector<String> GetList()
    {
        return list;
    }
    
    public void SetBudget(int newbudget)
    {
        budget=newbudget;
    }
    
    public void AddList(String newlist)
    {
        list.add(newlist);
    }
    
   
    public void DelList(String dellist)
    {
      list.remove(dellist);
    }
    
    public void PrintNotes()
    {
        System.out.println("-----------------------------");
        System.out.println("Notes");
        System.out.println("List  : "+list);
        System.out.println("Budget: "+budget);
        System.out.println("-----------------------------");
       
    }
    
    public void MenuNotes()
    {
        
        boolean exit =false;
        while(!exit)
        {
            PrintNotes();
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
                SetBudget(budget);
            }
            else if(pilihan==2)
            {
                System.out.print("Add List: ");
                String add=in.next();
                if(!list.contains(add))
                {
                    AddList(add);
                }
                
            }
            else if(pilihan==3)
            {
                System.out.print("Delete List: ");
                String del=in.next();
                if(list.contains(del))
                {
                    DelList(del);
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
