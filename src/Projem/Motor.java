package Projem;

public class Motor extends Arac {

	public Motor(String plaka, double yakit, double hiz, int kapasite, Konum anlikKonum) {
		super(plaka, yakit, hiz, kapasite, anlikKonum);
	}
	
	// Arac sınıfındaki soyut metodun gövdesini yazıyoruz.
@Override
	public void teslimatYap(Musteri musteri,Paket paket) {
		System.out.println("Motor teslimat süreci...");
		double gecerliHiz = this.getHiz();
		// paket ağırlığı 10 kg'dan fazla ise motor hızı %20 düşürülüyor.
		if(paket.getAgirlik()>10) {
			gecerliHiz = gecerliHiz*0.80;
			System.out.println("Dikkat! Paket 10 kg'dan agir, paket agirligi: " + paket.getAgirlik()+"kg");
			System.out.println("Motor hizi %20 dusuruldu! Yeni hiz: " + gecerliHiz);
		}
		//aracın anlık konumunu getAnlikKonum ile alıyoruz ve müşterinin konumuna olan uzaklığını ölçüyoruz.
		double mesafe= this.getAnlikKonum().mesafeHesapla(musteri.getKonumBilgisi());
	
		double harcananYakit = mesafe; // her araç gittiği mesafe kadar yakıt tüketir.
		
		//yakıt kontrolü yapılıyor, yakıt yetersiz ise yakitIkmal() fonksiyonu ile fulleme işlemi yapılıyor.
		if(this.getYakit()<harcananYakit) {
			System.out.println(this.getPlaka() + "plakali motorun yakiti yetersiz! Yakit ikmali yapiliyor...");
			yakitIkmal();
		}
		//yakıt değerini güncelliyoruz.
		double yeniYakit = this.getYakit()- harcananYakit;
		this.setYakit(yeniYakit);
		
		this.setAnlikKonum(musteri.getKonumBilgisi());//motor müsterinin konumunda
		paket.setDurum("Teslim Edildi");
		
		System.out.println(paket.getIcerik() + " icerikli paket, " + musteri.getAd() + " isimli musteriye motor ile basariyla teslim edildi.");
		System.out.println("Gidilen mesafe: "+ mesafe + "birim. Kalan yakit: " + this.getYakit()+"litre");
		
		// Teslimat bitti, motor bir sonraki görev için kargo merkezine (0,0) geri dönüyor
		this.setAnlikKonum(new Konum(0, 0));
		
		}
	
	}