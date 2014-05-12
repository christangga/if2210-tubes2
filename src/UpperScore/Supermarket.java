package UpperScore;

import java.util.ArrayList;
import java.util.List;

public class Supermarket {

    // Attributes
    public List<Produk> listProduk;
    public String name;
    
    // Constructors
    public Supermarket(){
    	listProduk = new ArrayList<Produk>();
    	name =null;
    }
    
    public Supermarket(String S){
	listProduk = new ArrayList<Produk>();
	name = new String(S);
    }
    
    // Getters and Setters
    public List<Produk> getList() 
    {
        return listProduk;
    }

    public String getName() 
    {
        return name;
    }

    public void setList(List<Produk> list) 
    {
        listProduk = list;
    }

    public void setName(String _name) 
    {
        name = _name;
    }
        
    // Methods
    public void addProduk(Produk P){
	if (!listProduk.contains(P))
	    listProduk.add(P);
    }
	
    public void delProduk(Produk P){
	listProduk.remove(P);
    }
    
    public void delProduk(Barcode B){
	for(Produk P : listProduk){
	    if (P.getBarcode() == B)
		listProduk.remove(P);
	} 
    }
    
    public boolean isBCAvailable(Barcode B){
	boolean Available = false;
	for(Produk P : listProduk){
	    if (P.getBarcode() == B)
		Available = true;
	}
	return Available;
    }
    
    public void print(){
        
        System.out.println("Nama : "+name);
	for(Produk P : listProduk){
                P.print();
		
	} 
    }
    
	
}
