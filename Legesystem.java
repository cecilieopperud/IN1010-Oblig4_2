import java.util.Scanner;

public class Legesystem{
    static Liste<Pasient> pasientListe = new Lenkeliste<Pasient>();
    static Liste<Lege> legeListe = new Lenkeliste<Lege>();
    static Liste<Legemiddel> legemiddelListe = new Lenkeliste<Legemiddel>();
    static Liste<Resepter> reseptListe = new Lenkeliste<Resepter>();
    public String fil;
    Legesystem(String f){
      fil = f;
    }
    public void gaaGjennom(){
      File filen = new File(fil);
      Scanner les = null;

      try { //try og catch uttalelse for aa sjekke input til innlesing.
        innlesing = new Scanner(filen);
        System.out.println("Fant fil og henter data");
      }

      catch (Exception e) { //Dersom det blir error blir stringen under skrevet ut.
        System.out.println("Fant desverre ikke filen");
      }
      String linje = innlesing.hasNextLine();
      while(innlesing.hasNextLine()){
        if(linje.startsWith("#")){

        }
      }

}


    public static void main(String[] args){

    }
}
