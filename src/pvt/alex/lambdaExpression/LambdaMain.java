package pvt.alex.lambdaExpression;

public class LambdaMain {

    public static void printThing(Printable thing) {
        thing.print();
    }

    public static void main(String[] args) {

        Cat myCat = new Cat();
        //myCat.print();

        /* Qui sto passando un OGGGETTO CHE IMPLEMENTA il metodo print() */
        printThing(myCat);

        /* Usando le lambda function, passo direttamente l'IMPLEMENTAZIONE STESSA */
        /** Prendo il metodo "print" dentro Cat:
         * non ho bisogno di specifcare "public", "void" e nome del metodo
         * scrivo soltanto i parametri "()", seguiti da un arrow function "->" e il corpo del metodo
         * */
        printThing( () -> {System.out.println("Lambda Meow");} );

        /** N.B. Le lambda function possono essere usate soltanto con le "FunctionalInterface"
         * Ossia le interfacce che possiedono UN SOLO METODO ASTRATTO
         * */
        /* Esempio con un parametro in ingresso */
        PrintableTwo print2 = s -> System.out.println("Lambda PrintableTwo " + s);
        print2.suffix("!");

        /* Esempio con il return */
        PrintableThree print3 = (p, s) -> {return p + " PANCAKE " + s;};
        System.out.println(print3.prefixAndSuffix("my", "!"));
    }
}
