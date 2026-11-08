package Projem;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        
        try {
           
        	
        	ILogger logger = new KonsolLogger();
            ArrayList<Musteri> musteriler = new ArrayList<>();
        	ArrayList<Arac> araclar = new ArrayList<>();
        	ArrayList<Paket> paketler = new ArrayList<>();

        	
        	LojistikSistemi lojistikSistemi = new LojistikSistemi(musteriler, araclar, paketler, logger);
        	
        	Konum k1 = new Konum(3,4);
        	Konum k2 = new Konum(6,8);
        	Konum k3 = new Konum (7,24);
        	Konum k4 = new Konum (5,12);
        	
            System.out.println("\n=== MUSTERILER SISTEME GIRILIYOR ===");
            //müşteriler oluşturuluyor
            Musteri m1 = new Musteri("Ahmet", 101, k1, false); 
            Musteri m2 = new Musteri("Ayşe", 102, k2, true);   
            Musteri m3 = new Musteri("Mehmet", 103, k3, false);
            Musteri m4 = new Musteri("Ahsen" , 104, k4,true);
           
            lojistikSistemi.musteriEkle(m1);
            lojistikSistemi.musteriEkle(m2);
            lojistikSistemi.musteriEkle(m3);
            lojistikSistemi.musteriEkle(m4);

            System.out.println("\n=== ARACLAR KAPIDA HAZIRLANIYOR ===");
            // Araçlar oluşturuluyor
            Konum merkezKonumu = new Konum(0, 0); // Tüm araçlar kargo merkezinden başlıyor
            
            Arac kamyon = new Kamyon("16 BTU 01", 25.0, 60.0, 500, merkezKonumu); 
            Arac motor = new Motor("16 NYP 16", 100.0, 80.0, 30, merkezKonumu);
            Arac drone = new Drone("DRN-99", 100.0, 40.0, 5, merkezKonumu);

            lojistikSistemi.aracEkle(kamyon);
            lojistikSistemi.aracEkle(motor);
            lojistikSistemi.aracEkle(drone);

            System.out.println("\n=== PAKETLER KUYRUGA ALINIYOR ===");
            // Paketler oluşturuluyor 
            Paket p1 = new Paket(55, "Buzdolabı","Hazirlaniyor");      // bunu sırayla kamyon alacak
            Paket p2 = new Paket(12, "Bilgisayar Kasasi","Hazirlaniyor"); // bunu motor alacak (12 kg olduğu için hızı düşecek)
            Paket p3 = new Paket(8, "Laptop","Hazirlaniyor");         // bunu drone alacak (8 kg > 5 kg olduğu için hata fırlatacak)
            Paket p4 = new Paket(63, "Camasir Makinesi","Hazirlaniyor");  // sıra başa dönecek kamyon alacak
            Paket p5 = new Paket(2, "Zurna durum menu", "Hazirlaniyor"); // motor alacak
            Paket p6 = new Paket(4, "Laptop bataryası", "Hazirlaniyor"); // drone alacak
            Paket p7 = new Paket(7.5 ,"Utu masasi" , "Hazirlaniyor"); // sıra yine başa döndü kamyon alacak

            lojistikSistemi.paketEkle(p1);
            lojistikSistemi.paketEkle(p2);
            lojistikSistemi.paketEkle(p3);
            lojistikSistemi.paketEkle(p4);
            lojistikSistemi.paketEkle(p5);
            lojistikSistemi.paketEkle(p6);
            lojistikSistemi.paketEkle(p7);

            System.out.println("\n=== DAGITIM SIMULASYONU BASLIYOR ===");
            lojistikSistemi.simülasyonuBaslat();

        } catch (Exception e) {
            // eğer sistemde beklenmedik bir hata olursa burası yakalayacak
            System.out.println("Sistemde genel bir hata oluştu: " + e.getMessage());
        }
    }
}
