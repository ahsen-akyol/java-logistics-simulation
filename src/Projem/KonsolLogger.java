package Projem;

public class KonsolLogger implements ILogger{
@Override
 public void bilgiYazdir(String mesaj) {
	System.out.println("Sistem Bilgisi: " + mesaj);
}

}
