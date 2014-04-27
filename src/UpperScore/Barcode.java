package UpperScore;

public class Barcode {
    String id;
    
    public Barcode()
    {
        id=null;
    }
    
    public Barcode(String _id)
    {
        id=_id;
    }
    
    public String GetId()
    {
        return id;
    }
    
    public void SetId(String _id)
    {
        id = _id;
    }
    
    public void PrintBarcode()
    {
        System.out.println(id);
    }
}
