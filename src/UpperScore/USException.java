package UpperScore;

public class USException extends Exception
{
    public USException(String message)
    {
       super(message);
    }
    
    public void showMessage()
    {
        System.out.println(super.getMessage());
    }
}
