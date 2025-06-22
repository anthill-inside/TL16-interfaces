package telran.patern.controller;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternAppl {
    public static void main(String[] args) {
        String str= "Мама мыла раму!Мама мыла раму?";
        String regex = "(М|м)ама.*[!?]";
        Matcher m = Pattern.compile(regex).matcher(str);


        PrintStream sout = System.out;
        OutputStream outStream = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outStream));
        while (m.find()) {
            System.out.println(m.hasMatch());
            System.out.println(m.start());
            System.out.println(m.group());
            System.out.println(m.end());
        }
        String str2 = outStream.toString();

        System.setOut(sout);
        System.out.println(str2);

        return;




    }
}
