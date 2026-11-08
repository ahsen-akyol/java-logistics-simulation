package Projem;

public class Paket {
 private double agirlik; // paketin ağırlığı 
 private String icerik; // paketin içinde ne var?
 private String durum; // paketin durumu ne? Hazırlanıyor/Yolda/Teslim edildi
 
 
 //constructor
 public Paket(double agirlik, String icerik, String durum) {
	this.agirlik = agirlik;
	this.icerik = icerik;
	this.durum = durum;
   }
 
 //kapsülleme
 public double getAgirlik() {
	return agirlik;
}


 public void setAgirlik(int agirlik) {
	this.agirlik = agirlik;
 }


 public String getIcerik() {
	return icerik;
 }


 public void setIcerik(String icerik) {
	this.icerik = icerik;
 }


 public String getDurum() {
	return durum;
 }


 public void setDurum(String durum) {
	this.durum = durum;
 }



 
}
