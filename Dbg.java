public class Dbg {
    public static void p(String printVal){

        /* Short & searchable debug print function to ensure we 
         * remove or disable all before code goes into a 
         * 'production' environment. It is also faster to type.
        */
        System.out.println("[DBG]: " + printVal);

    }
}
