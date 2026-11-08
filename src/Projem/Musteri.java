package Projem;

public class Musteri {
 private String ad;
 private int id; 
 private Konum konumBilgisi; // musterinin konum bilgisi
 private boolean darSokakMi; // evin olduğu sokak dar mı geniş mi kontrolü
 
 
//constructor
public Musteri(String ad, int id, Konum konumBilgisi, boolean darSokakMi) {
	this.ad = ad;
	this.id = id;
	this.konumBilgisi = konumBilgisi;
	this.darSokakMi = darSokakMi;
  }
 
 //kapsülleme
 public String getAd() {
	return ad;
}


 public void setAd(String ad) {
	this.ad = ad;
 }


 public int getId() {
	return id;
 }


 public void setId(int id) {
	this.id = id;
 }


 public Konum getKonumBilgisi() {
	return konumBilgisi;
 }


 public void setKonumBilgisi(Konum konumBilgisi) {
	this.konumBilgisi = konumBilgisi;
 }


 public boolean isDarSokakMi() {
	return darSokakMi;
 }


 public void setDarSokakMi(boolean darSokakMi) {
	this.darSokakMi = darSokakMi;
 }


 
 }
