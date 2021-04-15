package Triangle;

//Написать функцию, вычисляющую площадь треугольника по трем сторонам (int a, int b, int c).
//        Разместить класс с функцией в src/main/java
//        Разместить тесты на эту функцию в классе src/test/java/.../TriangleTest.java
//        Настроить генерацию отчета и - по желанию - логирование.


public class Calculation {

    public static double triangleArea(int a, int b, int c) {
        double s = (((a + b + c) / 2) * ((a + b + c) / 2 - a) * ((a + b + c) / 2 - b) * ((a + b + c) / 2 - c));
        return Math.sqrt(s);
    }

    public static boolean checkTriangleExists(int a, int b, int c) {
        return (a + b) > c;
    }

}
