package domain.db;


import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.List;


/**
 * Created by tiebe on 10/05/2017.
 */
public  class WoordenLezer {



    public static List<String> lees() throws IOException {


         return Files.readAllLines(Paths.get("wordlist.txt"));



    }
}
