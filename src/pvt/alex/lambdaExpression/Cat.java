package pvt.alex.lambdaExpression;

public class Cat implements Printable {

    public String name;
    public int age;

    @Override
    public void print() {
        System.out.println("Meow!");
    }
}
