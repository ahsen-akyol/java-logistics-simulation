package Projem;

public class Drone extends Arac {

	public Drone(String plaka, double yakit, double hiz, int kapasite, Konum anlikKonum) {
		super(plaka, yakit, hiz, kapasite, anlikKonum);
	}
	
	//Arac sınıfındaki soyut metodun gövdesini yazıyoruz.
@Override
public void teslimatYap(Musteri musteri,Paket paket) {
	System.out.println("Drone teslimat süreci...");
	if(paket.getAgirlik()>5) {
		try {
			throw new AgirPaketException("HATA: Paket çok ağır (" + paket.getAgirlik() + " kg)! Drone maksimum 5 kg taşıyabilir.");
		} catch (AgirPaketException e) {
			System.out.println(e.getMessage());
			paket.setDurum("Teslim edilemedi(Drone Agirlik Kisiti)");
			System.out.println("Paket Durumu: " + paket.getDurum());
			return;
		}
	}
	//aracın anlık konumunu getAnlikKonum ile alıyoruz ve müşterinin konumuna olan uzaklığını ölçüyoruz.
	double mesafe= this.getAnlikKonum().mesafeHesapla(musteri.getKonumBilgisi());
	
	double harcananYakit = mesafe; // her araç gittiği mesafe kadar yakıt tüketir.
	
	//yakıt kontrolü yapılıyor, yakıt yetersiz ise yakitIkmal() fonksiyonu ile fulleme işlemi yapılıyor.
	if(this.getYakit()<harcananYakit) {
		System.out.println(this.getPlaka() + "plakali drone'un Sarji yetersiz! Sarj ediliyor...");
		yakitIkmal();
	}
	//yakıt değerini güncelliyoruz.
	double yeniYakit = this.getYakit()- harcananYakit;
	this.setYakit(yeniYakit);
	
	this.setAnlikKonum(musteri.getKonumBilgisi());//drone müsterinin konumunda
	paket.setDurum("Teslim Edildi");
	
	System.out.println(paket.getIcerik() + " icerikli paket, " + musteri.getAd() + " isimli musteriye drone ile basariyla teslim edildi.");
	System.out.println("Uculan mesafe: "+ mesafe + "birim. Kalan Sarj: %" + this.getYakit());
	
	// Teslimat bitti, drone bir sonraki görev için kargo merkezine (0,0) geri dönüyor
	this.setAnlikKonum(new Konum(0, 0));
  }

}
