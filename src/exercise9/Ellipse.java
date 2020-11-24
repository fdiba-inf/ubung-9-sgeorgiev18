package exercise9;

public class Ellipse {

  private Point startPoint;
  private double a;
  private double b;

  public Ellipse() {
    startPoint = new Point (0, 0);
    a = 1;
    b = 1;
  }

  public Ellipse(Point startPoint, double c, double d) {
    this.startPoint = new Point(startPoint);
    a = c;
    b = d;
  }

  public Ellipse(Ellipse otherEllipse) {
    startPoint = new Point(otherEllipse.startPoint);
    a = otherEllipse.a;
    b = otherEllipse.b;
  }

  public boolean isValid() {
    return a > 0 && b > 0;
  }

  public void initilize() {
        do {
            System.out.println("Start point: ");
            startPoint.initialize();
            System.out.print("Enter height: ");
            a = Utils.INPUT.nextDouble();
            System.out.print("Enter width: ");
            b = Utils.INPUT.nextDouble();
        } while (!isValid());    
  }

  public double Perimeter() {
    double p = Math.PI * (3 * (a + b) - (Math.sqrt((3 * a + b) * (a + 3 * b))));
    return p;
  }

  public double Area() {
    double area = Math.PI * a * b;
    return area; 
  }

  public String getType() {
    if (a == b) {
      return "Cycle";
    } else {
      return "Ellipse";
    }
  }

  public String toString() {
    return String.format("%s-[%s, %s], %s, P=%s, A=%s", startPoint, a, b, getType(), Perimeter(), Area());
  }
  public boolean equals(Ellipse otherEllipse) {
    boolean A = Utils.equals(a, otherEllipse.a);
    boolean B = Utils.equals(b, otherEllipse.b);
    boolean Areversed = Utils.equals(a, otherEllipse.b);
    boolean Breversed = Utils.equals(b, otherEllipse.a);

    return (A && B || Areversed && Breversed);
  }
}
