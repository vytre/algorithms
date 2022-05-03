package org.pg4200.ex08.vegardLambdaTest;

public class Lambdas {
    public static void main(String[] args) {
        Printable lambda = (p,s) -> {
            System.out.println(p+ "Meow" + s);
            return p;
        };

        printThing(lambda);
    }

    static void printThing(Printable thing){
        String s = thing.print("The cat Charlie said ",", !");
        System.out.println(s);
    }
}
