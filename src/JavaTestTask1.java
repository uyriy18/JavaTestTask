import java.util.ArrayList;

public class JavaTestTask1 {
    ArrayList<Figures> figuresList;
    public static void main(String[] args){

        JavaTestTask1 start = new JavaTestTask1();
        start.go();

    }
    void go(){
        figuresList = new ArrayList<Figures>();
        for(int i = 0; i < 20; i++){
            figuresList.add(new Square());
            figuresList.add(new Circle());
            figuresList.add(new Trapezoid());
            figuresList.add(new Triangle());
        }
        int n = (int) ((Math.random() * 5) + 3);// array length
        ArrayList<Figures> resultList = new ArrayList<Figures>();
        for(int i = 0; i < n; i++){
            int m = (int) (Math.random() * 20);// random index of element
            resultList.add(figuresList.get(m));

            System.out.println(resultList.get(i).getName());
        }
    }


}
interface FiguresInterface{
    String getName();

}
abstract class Figures implements FiguresInterface{

    int a = (int) ((Math.random() * 10) + 1);
    int b = (int) ((Math.random() * 10) + 1);
    int c = (int) ((Math.random() * 10) + 1);
    int d = (int) ((Math.random() * 10) + 1);

    String setColor(){
        String[] colors = {"red","white","blue","black"};
        int random = (int) (Math.random() * 4);
        String result = colors[random];
        return result;
    }
}
class Triangle extends Figures{
    private String name = "Triangle";
    private String color = setColor();
    private int sideA = a;
    private int sideB = b;
    private double hypotenuse =(double) (Math.sqrt(Math.pow(sideA,2) + Math.pow(sideB,2)));
    private double halfPerimeter = (sideA + sideB + hypotenuse)/2;
    private double area = Math.sqrt(halfPerimeter*(halfPerimeter - sideA)*(halfPerimeter - sideB)*(halfPerimeter - hypotenuse));
    private String parameterName = " Hypotenuse = ";

    @Override
    public String getName() {
        return "Triangle, color : " + color + ", area = " + area + ", hypotenuse = " + hypotenuse;
    }

    String getColor() { return color;}

    double getArea() {return area;};

    public double getParameter() {
        return hypotenuse;
    }

}
class Square extends Figures{
    private String name = "Square";
    private String color = setColor();
    private double side = a;
    private double area = a*a;
    private String parameterName = " Side = ";

    @Override
    public String getName() {
        return "Square, color : " + color + ", area = " + area + ", side = " + side;
    }

    String getColor() { return color;}

    double getArea() {return area;};

    public double getParameter() {
        return side;
    }
}
class Circle extends Figures{
    private String name = "Circle";
    private String color = setColor();
    private double radius = d;
    private String parameterName = " Radius = ";
    private double area = Math.pow(radius,2) * 3.14;

    String getColor() { return color;}

    double getArea() {return area;};

    @Override
    public String getName() {
        return "Circle, color : " + color + ", area = " + area + ", radius = " + radius;
    }

    public double getParameter() {
        return radius;
    }
}
class Trapezoid extends Figures{
    private String name = "Trapezoid";
    private String color = setColor();
    private double sideA = a;
    private double sideB = b;
    private double sideC = c;
    private double trapezoidHeight = (Math.sqrt(Math.pow(sideC,2) - (Math.pow(a - b, 2)/4)));
    private String parameterName = " Height = ";
    private double area = (a + b)*trapezoidHeight/2;

    String getColor() {return color;}

    double getArea() {return area;};

    public double getParameter() {return trapezoidHeight;}

    @Override
    public String getName() {
        return "Trapezoid, color : " + color + ", area = " + area + ", height = " + trapezoidHeight;
    }
}