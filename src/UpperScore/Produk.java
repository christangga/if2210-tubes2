package UpperScore;

import java.util.Vector;

public class Produk {
    private Barcode barCode;
    private String nama;
    private int harga;
    private Vector<String> tag;
    
    public Produk()
    {
        barCode = new Barcode();
        tag = new Vector<String>();
        nama = "";
        harga = 0;
    }
    
    public Produk(Barcode _barCode, String _nama, int _harga, Vector<String> _tag)
    {
        barCode = new Barcode(_barCode.id);
        nama = _nama;
        harga = _harga;
        tag = new Vector<String>(_tag);
    }
    
    public Barcode getBarcode ()
    {
        return barCode;
    }
    
    public String getNama()
    {
        return nama;
    }
    
    public int getHarga()
    {
        return harga;
    }
    
    public Vector<String> getTag()
    {
        return tag;
    }
    
    public void setBarCode(Barcode _barCode)
    {
        barCode.SetId(_barCode.id);
    }
    
    public void setNama(String _nama)
    {
        nama = _nama;
    }
    
    public void setHarga(int _harga)
    {
        harga = _harga;
    }
    
    public void setTag(Vector<String> _tag)
    {
        tag = _tag;
    }
    
    public void print()
    {
        System.out.println("============================");
        System.out.print("Barcode  : ");
        barCode.PrintBarcode();
        System.out.println("Nama     : "+nama);
        System.out.println("Harga    : "+harga);
        System.out.println("Tag      : "+tag);
    }
}
