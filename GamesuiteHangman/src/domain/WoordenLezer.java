package domain;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


/**
 * Created by tiebe on 10/05/2017.
 */
public class WoordenLezer {


    public static ArrayList<String> lees() throws IOException {

        ArrayList<String> list = new ArrayList<>();

        list.addAll(Files.readAllLines(Paths.get("wordlist.txt")));


        return list;


    }
}