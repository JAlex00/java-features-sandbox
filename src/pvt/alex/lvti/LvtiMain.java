package pvt.alex.lvti;

public class LvtiMain {

    /** LVTI - Local Variable Type Inference
     * "inferenza di tipo" permette al compilatore di dedurre il tipo di una variabile
     * in base al valore assegnato senza bisogno di scriverlo in modo esplicito.
     * N.B. Si applica solo alle "Local Variable".
     * */

    public static void main(String[] args){

        /* N.B. la "var" vuole sempre un valore assegnato */
        int c;
        //var d;

        /* Esempi di utilizzo */

        //int a = 9;
        var b = 8;

        //int[] nums = new int[10];
        var nums = new int[10];

        //StringBuilder sb = new StringBuilder();
        var sb = new StringBuilder();
    }
}
