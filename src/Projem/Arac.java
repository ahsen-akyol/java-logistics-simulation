package Projem;

abstract class Arac {
private String plaka;
private double yakit;
private double hiz;
private int kapasite;
private Konum anlikKonum;

//constructor
public Arac(String plaka, double yakit, double hiz, int kapasite, Konum anlikKonum) {
	this.plaka = plaka;
	this.yakit = yakit;
	this.hiz = hiz;
	this.kapasite = kapasite;
	this.anlikKonum = anlikKonum;
	}

// kapsülleme
public String getPlaka() {
	return plaka;
}
public void setPlaka(String plaka) {
	this.plaka = plaka;
}
public double getYakit() {
	return yakit;
}
public void setYakit(double yakit) {
	this.yakit = yakit;
}
public double getHiz() {
	return hiz;
}
public void setHiz(double hiz) {
	this.hiz = hiz;
}
public int getKapasite() {
	return kapasite;
}
public void setKapasite(int kapasite) {
	this.kapasite = kapasite;
}
public Konum getAnlikKonum() {
	return anlikKonum;
}
public void setAnlikKonum(Konum anlikKonum) {
	this.anlikKonum = anlikKonum;
}

// yakıt bittiğinde yakıtı fuller.
public void yakitIkmal() {
	this.yakit=100.0;
	System.out.println(this.plaka + "plakali aracin yakiti fullendi");
}

// soyut metottur.Her aracın teslimat şekli farklı olduğu için alt sınıflarda içi doldurulacak.
public abstract void teslimatYap(Musteri musteri, Paket paket) ;


	
}
