import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static List<Bejegyzes> lista = new ArrayList<>();

    public static void main(String[] args) {
        feltoltes();
        Scanner sc = new Scanner(System.in);
        System.out.println("Kérem adjon meg egy számot.");
        int input = Integer.parseInt(sc.next());

        for (int i = 0; i < input; i++) {
            System.out.println("Kérem adon meg egy szezőt.");
            String szerzokeres = sc.next();
            System.out.println("kérem adja meg a zene tartalmát.");
            String tartalomkeres = sc.next();
            lista.add(new Bejegyzes(szerzokeres, tartalomkeres));
        }
        Random rnd = new Random();
        for (int i = 0; i < lista.size() * 20; i++) {
            lista.get(rnd.nextInt(lista.size())).like();
        }
        System.out.println("Adjon meg egy szöveget:");
        lista.get(1).setTartalom(sc.next());
        System.out.println(lista);
        int max = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getLikeok() >= max){
                max = lista.get(i).getLikeok();
            }
            System.out.println("A legnépszerűbb videó likejainak száma: "+max);
        }

        
    }
    public static void beolvasas() {
        String filename = "bejegyzesek.csv";
        try {
            beolvasas(filename);
        } catch (FileNotFoundException e) {
            System.err.printf("Nem található a(z) %s fájl\n", filename);
        } catch (IOException e) {
            System.err.println("Ismeretlen hiba történt a fájl beolvasása közben");
        }
    }

    public static void beolvasas(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String sor = br.readLine();
        while (sor != null && !sor.equals("")) {
            String[] array = sor.split(";");
            Bejegyzes bejegyzes = new Bejegyzes(array[0], array[1]);
            lista.add(bejegyzes);
            sor = br.readLine();
        }
        br.close();
        fr.close();
    }


    public static void feltoltes(){
        lista.add(new Bejegyzes("Pista","szög"));
        lista.add(new Bejegyzes("Gyula","vörös"));
    }
}