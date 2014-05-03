package UpperScore;

public class Barcode {
    // Attributes
    String id;
    
    // Constructors
    public Barcode()
    {
        id=null;
    }
    
    public Barcode(String _id)
    {
        id=_id;
    }
    
    // Getters and Setters
    public String getId()
    {
        return id;
    }
    
    public void setId(String _id)
    {
        id = _id;
    }
    
    // Methods
    public void print()
    {
        System.out.println(id);
    }
    
}
