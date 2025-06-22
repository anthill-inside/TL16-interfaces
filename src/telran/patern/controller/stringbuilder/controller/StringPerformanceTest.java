public class StringPerformanceTest
{
    private static final String MEOW = "Meow";
    private static final int MAX_ITERATION = 100_000;

    public static void main(String[] args) {
        //Strings
        String str = "";
        long t1 = System.currentTimeMillis();
        for(int i = 0; i<MAX_ITERATION;i++){
            str+=MEOW;
        }
        long t2 = System.currentTimeMillis();
        System.out.println((t2-t1));


        StringBuilder sb = new StringBuilder();
        t1 = System.currentTimeMillis();

        for(int i = 0; i<MAX_ITERATION;i++){
            sb.append(MEOW);
        }
        t2 = System.currentTimeMillis();

        System.out.println((t2-t1));
    }

}
