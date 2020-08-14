package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static String action = "";
    static int key = 0;
    static String data = "";
    static String fileIn = "";
    static String fileOut = "";
    static String alg = "shift";

    public static void main(String[] args) throws IOException {
        parseArgs(args);
        String data2 = doAction(action);
        writeToFile(fileOut, data2);

    }
    public static String doAction(String action){
        String rtnStr = "";
        switch (action){
            case"enc":
                if (alg == "unicode") {
                    rtnStr = enc(data, key);
                } else {
                    rtnStr = cipher_key_OG(data, key);
                }
                break;
            case"dec":
                if (alg == "unicode") {
                    rtnStr = dec(data, key);
                } else {
                    rtnStr = key_cipher_OG(data, key);
                }
                break;
        }
        return rtnStr;
    }
    public static void parseArgs(String[] args) throws IOException {
        for (int i = 0; i < args.length; i++) {
            if (args[i].contains("-mode")) {
                action = args[i+1];
//                System.out.println("action: " + action);
            }
            if (args[i].contains("-key")){
                key = Integer.parseInt(args[i+1]);
                System.out.println("key: " + key);
            }
            if (args[i].contains("-in")){
                fileIn = args[i+1];
//                System.out.println("fileIn: " + fileIn);
            }
            if (args[i].contains("-data")){
                data = args[i+1];
//                System.out.println("data: " + data);
            }
            if (args[i].contains("-out")){
                fileOut = args[i+1];
//                System.out.println("fileOut: " + fileOut);
            }
            if (args[i].contains("-alg")){
                alg = args[i+1];
                System.out.println("alg: " + alg);
            }
        }
        if (data.length() < 1) {
            data = new Scanner(new File(fileIn)).nextLine();
//            System.out.println("data: " + data);
        }
    }
    public static void writeToFile(String fileName, String data) throws IOException {
//        System.out.println("write to: " + fileName);
//        System.out.println("data: " + data);
        File file = new File(fileName);
        FileWriter writer = new FileWriter(file);
        try {
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String enc(String str, int key){
        String cStr = "";
        for (int i = 0; i < str.length(); i++) {
            int newChar = str.charAt(i);
            newChar += key;
            cStr += (char)newChar;
        }
        System.out.println("ck: " + cStr);
        return cStr;
    }
    public static String dec(String str, int key){
        String cStr = "";
        for (int i = 0; i < str.length(); i++) {
            int newChar = str.charAt(i);
            newChar -= key;
            cStr += (char)newChar;
        }
        System.out.println("kc: " + cStr);
        return cStr;
    }

    public static String getStr(){
        Scanner strScanner = new Scanner(System.in);
        String newStr = strScanner.nextLine();
        return newStr;
    }
    public static String cipher_key_OG(String str, int key){
        String cStr = "";
        for (int i = 0; i < str.length(); i++) {
            int newChar = str.charAt(i);
            if ( newChar < 123 && newChar > 96) {
                newChar += key;
                if (newChar > 122) {
                    newChar -= 26;
                }
//                System.out.println(newChar);
                cStr += (char)newChar;
            } else {
                cStr += (char)str.charAt(i);
            }

        }
        System.out.println("cipher_key_OG: "+cStr);
        return cStr;
    }
    public static String key_cipher_OG(String str, int key){
        System.out.println(str + " | " + key);
        String cStr = "";
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + " => ");
            int newChar = str.charAt(i) - key;
            System.out.print(newChar + " ==> ");

            if (newChar < 97) {
                newChar += 26;
            } else if (newChar > 122){
                newChar -=26;
            }
            System.out.println(newChar);

            cStr += (char)newChar;

        }
        System.out.println("key_cipher_OG: "+cStr);
        return cStr;
    }
    public static String cipher(String str){
        String cStr = "";
        for (int i = 0; i < str.length(); i++) {
            int newChar = ((int) ((str.charAt(i) - 96) - 123) * -1);
            if ( newChar < 123 && newChar > 97) {
                cStr += (char)newChar;
            } else {
                cStr += (char)str.charAt(i);
            }

        }
        return cStr;
    }
}
