package Projem;

public class Konum {
  private int x;
  private int y;
  
  //constructor
  public Konum(int x,int y) {
	  this.x=x;
	  this.y=y;
  }
  
  //kapsülleme
  public int getX() {
	return x;
}

  public void setX(int x) {
	this.x = x;
  }

  public int getY() {
	return y;
  }

  public void setY(int y) {
	this.y = y;
  }
  
  
 /* burda matematikteki iki nokta arasındaki uzaklık formülünü kullanacağız.
 * (x1,y1)bizim konumumuz,(x2,y2)gitmek istediğimiz konum olsun. Bu iki konum arasındaki uzaklık şu şekildedir:
 * x eksenindeki konumların farkının karesini ve y ekseninde konumların farkının karesini buluyoruz.
 * daha sonra bulduğumuz sonuçları karekök içinde topluyoruz.
 * sayıların karesini alabilmek için Math.pow, karekök alabilmek için Math.sqrt kullanıyoruz.
 */
  
  public double mesafeHesapla(Konum hedefKonum) {
	  double xFarki = hedefKonum.x - this.x;
	  double yFarki = hedefKonum.y - this.y;
	 
	  double karelerToplami = Math.pow(xFarki, 2) + Math.pow(yFarki, 2); 
	  return Math.sqrt(karelerToplami);
  }
}
