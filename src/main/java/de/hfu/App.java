package de.hfu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Das ist ein ergenzender Kommentar
 *
 */
public class App 
{
    public static void main( String[] args )  {

        String s = read();
        System.out.print(s.toUpperCase());
    }

    public static String read() {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        try {
            s = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;

    }
}
