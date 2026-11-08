# java-logistics-simulation
Nesneye Yönelik Programlama ile Akıllı Şehir Lojistik ve Dağıtım Simülasyonu

Bu proje, Nesneye Yönelik Programlama (OOP) prensipleri kullanılarak geliştirilmiş bir lojistik ve kargo dağıtım ağı simülasyonudur. Sistem; kargo araçları, müşteri profilleri, coğrafi kısıtlar ve paket özelliklerini dinamik iş kuralları çerçevesinde yöneten bir simülasyon motoru olarak tasarlanmıştır.



## Proje Amacı
Gerçek dünya lojistik problemlerini modellemek amacıyla; **Kalıtım (Inheritance)**, **Polimorfizm (Polymorphism)**, **Soyutlama (Abstraction)** ve **Kapsülleme (Encapsulation)** prensipleri temel alınarak modüler ve genişletilebilir bir mimari kurulmuştur.



## Sistem Mimarisi ve UML Diyagramı
Projenin sınıf hiyerarşisi, ilişkileri ve soyutlama yapıları UML standartlarına uygun olarak modellenmiştir.
![UML Sınıf Diyagramı](UML Diyagramı.drawio.png)



## Sınıf Yapıları ve Sorumluluklar

- **Konum**: x ve y koordinat bilgilerini tutar; noktalar arası mesafeyi hesaplayan MesafeHesapla() metodunu içerir.
- **Musteri**: Müşteri kimliği, ad, konum ve fiziki ulaşım kısıtı olan DarSokakMi (boolean) bilgisini barındırır.
- **Paket**: Paket ağırlığı, içerik bilgisi ve durum takibini (Hazırlanıyor, Yolda, Teslim Edildi) yönetir.
- **Arac: (Abstract Class)**: Plaka, kapasite, yakıt ve hız niteliklerini tutar; TeslimatYap() metodunu soyut olarak tanımlar.
  - **Kamyon**: Arac sınıfından türetilmiştir; yüksek kapasiteli taşımaları simüle eder.
  - **Motosiklet**: Arac sınıfından türetilmiştir; hızlı teslimat birimidir.
  - **Drone**: Arac sınıfından türetilmiştir; hafif gönderiler için hava dağıtım birimidir.
- **LojistikSistemi**: Müşteri listesini, araç filosunu ve sipariş dağıtım sırasını koordine eden ana yönetim birimidir.



## Simülasyon İş Kuralları ve Kısıtlar

1. **Kamyon Kısıtı:** Müşterinin DarSokakMi niteliği true ise kamyon o adrese teslimat yapamaz ve hata mesajı üretir.
2. **Drone Kısıtı (Özel İstisna):** Drone araçları yalnızca 5 kg altındaki paketleri taşır. 5 kg üzerindeki paketler için AgirPaketException fırlatılır.
3. **Motosiklet Kısıtı:** Paket ağırlığı 10 kg üzerindeyse motosikletin seyir hızı otomatik olarak %20 azalır.
4. **Yakıt Yönetimi:** Araçlar katettikleri mesafe kadar yakıt tüketir; yakıt tükendiğinde YakitIkmal() metodu işletilir.
5. **Kuyruk Mantığı (FIFO):** Paketler sisteme giriş sırasına göre kuyruk yapısında tutulur ve sırayla dağıtıma çıkarılır.



## Teknik Gereksinimler

- **Programlama Dili:** Java
- **Kütüphaneler:** Dış kütüphane kullanılmadan saf Java standart kütüphaneleriyle geliştirilmiştir.
- **Hata Yönetimi:** Beklenmeyen durumlar ve kural ihlalleri için try-catch blokları ve özel hata sınıfları kullanılmıştır.



## Çalıştırma

- Bilgisayarınızda **Java (JDK 8 veya üzeri)** kurulu olmalıdır.

### Adımlar
Proje dosyalarının bulunduğu dizinde terminal veya komut istemcisini açarak sırasıyla şu komutları çalıştırın:

- javac *.java
- java Main
