// package Homework;

import java.io.*;

public class FileApp {

    public static void main(String[] args) {
        try {
            FileReader in = new FileReader("build.xml");
            FileWriter out = new FileWriter("output.dat");

            String varify, data = "";
            int count = 0;
            BufferedReader br = new BufferedReader(in);
            while ((varify = br.readLine()) != null) {
                if (varify != null) {
                    char[] chars = varify.toCharArray();
                    for (int i = 0; i < chars.length; i++) {
                        if (chars[i] == ';') {
                            count += 1;
                            if (count == 5) {
                                data += " \n";
                                count = 0;
                            } else
                                data += " ";
                        } else
                            data += chars[i];
                    }
                }
            }
            out.write(data);
            System.out.println(data);
            in.close();
            out.close();
            System.out.println("Read and write data to file complete.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}