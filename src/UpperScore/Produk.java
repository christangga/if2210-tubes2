package UpperScore;

import java.util.ArrayList;
import java.util.List;


public class Produk {

    // Attributes
    private Barcode barcode;
    private String nama;
    private int harga;
    private List<String> tag; //kayaknya bagusan pake arraylist(?)
    
    // Constructors
    public Produk()
    {
        barcode = new Barcode();
        tag = new ArrayList<String>();
        nama = "";
        harga = 0;
    }
    
    public Produk(Barcode _barcode, String _nama, int _harga, List<String> _tag)
    {
        barcode = new Barcode(_barcode.id);
        nama = _nama;
        harga = _harga;
        tag = new ArrayList<String>(_tag);
    }
    
    // Getters and Setters
    public Barcode getBarcode ()
    {
        return barcode;
    }
    
    public String getNama()
    {
        return nama;
    }
    
    public int getHarga()
    {
        return harga;
    }
    
    public List<String> getTag()
    {
        return tag;
    }
    
    public void setBarcode(Barcode _barcode)
    {
        barcode.setId(_barcode.id);
    }
    
    public void setNama(String _nama)
    {
        nama = _nama;
    }
    
    public void setHarga(int _harga)
    {
        harga = _harga;
    }
    
    public void setTag(List<String> _tag)
    {
        tag = _tag;
    }
    
    public void setProduk(Produk p)
    {
        barcode =p.getBarcode();
        tag = p.getTag();
        nama = p.getNama();
        harga = p.getHarga();
        
    }
    
    // Methods
    public void print()
    {
        System.out.println("============================");
        System.out.print("Barcode  : ");
        barcode.print();
        System.out.println("Nama     : "+nama);
        System.out.println("Harga    : "+harga);
        System.out.println("Tag      : "+tag);
    }
}
