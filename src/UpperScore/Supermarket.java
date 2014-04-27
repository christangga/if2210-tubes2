package UpperScore;

import java.util.*;

public class Supermarket {
    public List<Produk> ListProduk;
    public String NamaSP;
    
    Supermarket(){
    	ListProduk = new ArrayList<Produk>();
    	NamaSP =null;
    }
    
    Supermarket(String S){
	ListProduk = new ArrayList<Produk>();
	NamaSP = new String(S);
    }
    
    public void AddProduk(Produk P){
	if (!ListProduk.contains(P))
	    ListProduk.add(P);
    }
	
    public void DelProduk(Produk P){
	ListProduk.remove(P);
    }
    
    public void DelProduk(Barcode B){
	for(Produk P : ListProduk){
	    if (P.getBarcode() == B)
		ListProduk.remove(P);
	} 
    }
    
    public boolean IsBCAvailable(Barcode B){
	boolean Available = false;
	for(Produk P : ListProduk){
	    if (P.getBarcode() == B)
		Available = true;
	}
	return Available;
    }
    
    public void PrintSupermarket(){
        
        System.out.println("Nama : "+NamaSP);
	for(Produk P : ListProduk){
                P.print();
		
	} 
    }
    
	
}
