package gestionefile;

import java.io.*;

/**
 *
 * @author francescobattistoni
 * @version 31/01/23
 */
public class GestioneFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //1)LETTURA
        Lettore lettore = new Lettore("user.json");
        lettore.start();
        try{
            lettore.join();
        }catch(InterruptedException ex){
            System.err.println("errore nel join");
        }
        //2)ELABORAZIONE
        String user = null;
        String pwd = null;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try{
            System.out.println("inserisci l'username");
            user = br.readLine().toUpperCase();
            System.out.println("inserisci la password");
            pwd = br.readLine().toUpperCase();
        } catch (IOException e) {
            System.err.println("Errore durante la lettura dell'input: " + e.getMessage());
        }
        
        
        //3) SCRITTURA
        Scrittore scrittore = new Scrittore("output.csv", user + ";" +pwd);
        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();
    }
    
}
