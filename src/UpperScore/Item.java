package UpperScore;

import java.util.Vector;

public class Item extends Produk{
    private int quantity;
    
    public Item()
    {
        super();
        quantity = 0;
    }
    
    public Item(Barcode _barcode, String _nama, int _harga, Vector<String> _tag, int _quantity)
    {
        super(_barcode,_nama,_harga,_tag);
        quantity = _quantity;
    }
    
    public int GetQuantity()
    {
        return quantity;
    }
    
    public void SetQuantity(int _quantity)
    {
        quantity = _quantity;
    }
    
    public void PrintItem()
    {
        super.PrintProduk();
        System.out.println("Quantity : "+quantity);
    }
}
