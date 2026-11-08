package Projem;

public class Kamyon extends Arac {

	public Kamyon(String plaka, double yakit, double hiz, int kapasite, Konum anlikKonum) {
		super(plaka, yakit, hiz, kapasite, anlikKonum);
	}
// Arac sınıfındaki soyut metodun gövdesini yazıyoruz.
@ Override
public void teslimatYap(Musteri musteri, Paket paket) {
	System.out.println("Kamyon teslimat sureci...");
	
	// sokağın darlık genişlik durumuna göre teslimatın olup olamayacağını kontrol ediyoruz.
	if(musteri.isDarSokakMi()) {
		System.out.println("Dikkat! Sokak dar olduğu için kamyon bu noktaya teslimat yapamaz.");
		paket.setDurum("Teslim edilemedi(dar sokak kısıtı)");
		System.out.println("Paket Durumu: " + paket.getDurum());
		return;
	}
	
	//aracın anlık konumunu getAnlikKonum ile alıyoruz ve müşterinin konumuna olan uzaklığını ölçüyoruz.
	double mesafe= this.getAnlikKonum().mesafeHesapla(musteri.getKonumBilgisi());
	
	double harcananYakit= mesafe; // her araç gittiği mesafe kadar yakıt tüketir.
	
	//yakıt kontrolü yapılıyor, yakıt yetersiz ise yakitIkmal() fonksiyonu ile fulleme işlemi yapılıyor.
	if(this.getYakit()<harcananYakit) {
		System.out.println(this.getPlaka() + "plakali kamyonun yakiti yetersiz! Yakit ikmali yapiliyor...");
		yakitIkmal();
	}
	//yakıt değerini güncelliyoruz.
	double yeniYakit = this.getYakit()- harcananYakit;
	this.setYakit(yeniYakit);
	
	this.setAnlikKonum(musteri.getKonumBilgisi());//kamyon müsterinin konumunda
	paket.setDurum("Teslim Edildi");
	
	System.out.println(paket.getIcerik() + " icerikli paket, " + musteri.getAd() + " isimli musteriye kamyon ile basariyla teslim edildi.");
	System.out.println("Gidilen mesafe: "+ mesafe + "birim. Kalan yakit: " + this.getYakit()+"litre");
	
	// Teslimat bitti, kamyon bir sonraki görev için kargo merkezine (0,0) geri dönüyor
	this.setAnlikKonum(new Konum(0, 0));
	
}
 
}
