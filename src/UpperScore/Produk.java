package UpperScore;

import java.util.Vector;

public class Produk {
    private Barcode barcode;
    private String nama;
    private int harga;
    private Vector<String> tag;
    
    public Produk()
    {
        barcode = new Barcode();
        tag = new Vector<String>();
        nama = "";
        harga = 0;
    }
    
    public Produk(Barcode _barcode, String _nama, int _harga, Vector<String> _tag)
    {
        barcode = new Barcode(_barcode.id);
        nama = _nama;
        harga = _harga;
        tag = new Vector<String>(_tag);
    }
    
    public Barcode GetBarcode ()
    {
        return barcode;
    }
    
    public String GetNama()
    {
        return nama;
    }
    
    public int GetHarga()
    {
        return harga;
    }
    
    public Vector<String> GetTag()
    {
        return tag;
    }
    
    public void SetBarcode(Barcode _barcode)
    {
        barcode.SetId(_barcode.id);
    }
    
    public void SetNama(String _nama)
    {
        nama = _nama;
    }
    
    public void SetHarga(int _harga)
    {
        harga = _harga;
    }
    
    public void SetTag(Vector<String> _tag)
    {
        tag = _tag;
    }
    
    public void PrintProduk()
    {
        System.out.println("============================");
        System.out.print("Barcode  : ");
        barcode.PrintBarcode();
        System.out.println("Nama     : "+nama);
        System.out.println("Harga    : "+harga);
        System.out.println("Tag      : "+tag);
    }
}
