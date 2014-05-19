package com.example.upperscore.model;

import java.util.List;
import java.util.Vector;

public class Item extends Produk{
    // Attributes
    private int quantity;
    
    // Constructors
    public Item()
    {
        super();
        quantity = 0;
    }
    
    public Item(Barcode _barcode, String _nama, int _harga, List<String> _tag, int _quantity)
    {
        super(_barcode,_nama,_harga,_tag);
        quantity = _quantity;
    }
    
    public Item(Produk p, int quantity) {
    	super(p.getBarcode(), p.getNama(), p.getHarga(), p.getTag());
    	this.quantity = quantity;
    }
    
    // Getters and Setters
    public int getQuantity()
    {
        return quantity;
    }
    
    public void setQuantity(int _quantity)
    {
        quantity = _quantity;
    }
    
    // Methods
    @Override
    public void print()
    {
        super.print();
        System.out.println("Quantity : "+quantity);
    }
    
}
