package pvt.alex.optional;

import java.util.Optional;

public class OptionalMain {

    public static void main(String[] args) {

        Cat myCat = findCat("Tom");
        //System.out.println(myCat.getAge()); --> questo darebbe una NPE

        if (myCat != null) {
            System.out.println(myCat.getAge());
        } else {
            System.out.println("1- Cat not found!");
        }

        /* ---------------------------------------------------------------------------- */

        Optional<Cat> myCatOpt = findCatOptional("Tommy");
        //System.out.println(myCatOpt.get().getAge()); --> questo darebbe una NPE

        if (myCatOpt.isPresent()) {
            System.out.println(myCatOpt.get().getAge());
        } else {
            System.out.println("2- Cat not found!");
        }

        //Restituisce l'oggetto, ALTRIMENTI se l'oggetto e' "null", ritorna qualcos'altro
        /** N.B. la differenza e' puramente funzionale
         * orElse() - esegue, a prescindere che l'oggetto in Optional sia null o meno. Ritorna soltanto il parametro passato
         * orElseGet() - esegue SOLO se l'oggetto in Optional e' null. Ritorna il risultato della lambda function
         * */
        Cat myThirdCat = myCatOpt.orElse(new Cat("UNKNOWN", 0));
        Cat myFourthCat = myCatOpt.orElseGet(() -> new Cat("UNKNOWN", 0));

        /** "map" ritorna un optional quindi posso eseguire ".getAge()" senza pericolo di NPE
         * qualora il risultato di "map" fosse null, potrei chiamare ".orElse()" per impostare un valore di default
         * N.B. In questo modo non bisogno usare "if" come fatto sopra
         */
       int age = myCatOpt.map(c -> c.getAge())
                .orElse(0);

       System.out.println(age);
    }

    public static Cat findCat(String name){
        //return new Cat(name, 3);

        /* Ipotizziamo che il metodo non trovi il Cat e quindi ritorni "null" */
        return null;
    }

    /**
     * "Optional" funziona come contenitore che puo' contenere oggetti che, a loro volta, potrebbero essere "null"
     * */
    public static Optional<Cat> findCatOptional(String name){
        //Cat cat = new Cat(name, 3);
        Cat cat = null;
        return Optional.ofNullable(cat);
    }
}
