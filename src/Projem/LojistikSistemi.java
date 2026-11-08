package Projem;
import java.util.ArrayList;

public class LojistikSistemi {
    
	
    private ArrayList<Musteri> musteriListesi;
    private ArrayList<Arac> aracListesi;
    private ArrayList<Paket> paketKuyrugu; // FIFO (ilk giren ilk çıkar) kuyruğu
    private ILogger logger; 

    //constructor
    public LojistikSistemi(ArrayList<Musteri> musteriListesi, ArrayList<Arac> aracListesi, ArrayList<Paket> paketKuyrugu, ILogger logger) {
        this.musteriListesi = musteriListesi;
        this.aracListesi = aracListesi;
        this.paketKuyrugu = paketKuyrugu;
        this.logger = logger;
    }

    //merkeze eleman ekleme metotları
    //main sınıfında ürettiklerimizi bu metotlar sayesinde listeye ekleyeceğiz

    public void musteriEkle(Musteri musteri) {
        this.musteriListesi.add(musteri);
        logger.bilgiYazdir("Yeni Müşteri Sisteme Eklendi: " + musteri.getAd());
    }

    public void aracEkle(Arac arac) {
        this.aracListesi.add(arac);
        logger.bilgiYazdir("Yeni Araç Sisteme Kaydedildi: " + arac.getPlaka());
    }

    public void paketEkle(Paket paket) {
        this.paketKuyrugu.add(paket);
        logger.bilgiYazdir("Yeni Paket Kuyruğa Alındı: " + paket.getIcerik() + " (" + paket.getAgirlik() + " kg)");
    }

   
    // simülasyon başlangıcı ve dağıtım süreci
    public void simülasyonuBaslat() {
        logger.bilgiYazdir("AKILLI SEHIR LOJISTIK SIMULASYONU BASLIYOR...");
        System.out.println("==================================================");

        int musteriEndeksi = 0;
        int aracEndeksi = 0;

        // FIFO kuyruk mantığı uyguluyoruz. Kuyrukta paket kalmayana kadar döngü döner
        while (!paketKuyrugu.isEmpty()) {
            
            // kuyruğun en başındaki (0. indeksteki) paketi çekip listeden siliyoruz (İlk giren ilk çıkar)
            Paket mevcutPaket = paketKuyrugu.remove(0); 
            
            // sıradaki müşteri ve aracı listelerden sırayla çekiyoruz
            Musteri mevcutMusteri = musteriListesi.get(musteriEndeksi);
            Arac mevcutArac = aracListesi.get(aracEndeksi);

            // teslimat durumunu ekrana yazdırıyoruz
            logger.bilgiYazdir(mevcutArac.getPlaka() + " araci, " + mevcutMusteri.getAd() + " icin " + mevcutPaket.getIcerik() + " paketini dagitima cikardi.");

            // ilgili araca (Kamyon, Motor veya Drone) teslimat emrini veriyoruz
            mevcutArac.teslimatYap(mevcutMusteri, mevcutPaket);

            //paketler bittikçe müşteri ve araç listesinin başına dönmek için 
            musteriEndeksi = (musteriEndeksi + 1) % musteriListesi.size();
            aracEndeksi = (aracEndeksi + 1) % aracListesi.size();
            
            System.out.println("--------------------------------------------------");
        }
        
        logger.bilgiYazdir("TUM PAKETLERIN DAĞITIM SURECI BASARIYLA TAMAMLANDI!");
    }

    // getter setter metodları
    
    public ILogger getLogger() {
		return logger;
	}
    
    public void setLogger(ILogger logger) {
		this.logger = logger;
	}

	public ArrayList<Musteri> getMusteriListesi() {
		return musteriListesi;
	}

	public void setMusteriListesi(ArrayList<Musteri> musteriListesi) {
		this.musteriListesi = musteriListesi;
	}

	public ArrayList<Arac> getAracListesi() {
		return aracListesi;
	}

	public void setAracListesi(ArrayList<Arac> aracListesi) {
		this.aracListesi = aracListesi;
	}

	public ArrayList<Paket> getPaketKuyrugu() {
		return paketKuyrugu;
	}

	public void setPaketKuyrugu(ArrayList<Paket> paketKuyrugu) {
		this.paketKuyrugu = paketKuyrugu;
	}

	
  }

	   

