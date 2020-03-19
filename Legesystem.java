import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Legesystem{
    private static Liste<Pasient> pasientListe = new Lenkeliste<Pasient>();
    private static Liste<Lege> legeListe = new Lenkeliste<Lege>();
    private static Liste<Legemiddel> legemiddelListe = new Lenkeliste<Legemiddel>();
    private static Liste<Resepter> reseptListe = new Lenkeliste<Resepter>();
    private String fil;

    Legesystem(String f){
      fil = f;
    }
    public void gaaGjennom() throws FileNotFoundException{
      File filen = new File("Vedlegg.txt");
      Scanner innlesing = null;

      try { //try og catch uttalelse for aa sjekke input til innlesing.
        innlesing = new Scanner(filen);
        System.out.println("Fant fil og henter data");
      }

      catch (FileNotFoundException e) { //Dersom det blir error blir stringen under skrevet ut.
        System.out.println("Fant desverre ikke filen");
        throw new FileNotFoundException();
      }

      int teller = 0;

      while(innlesing.hasNextLine()){

        if(innlesing.next().startsWith("#")){
          innlesing.nextLine();
          teller++;
        }

        if(teller == 1){
            String [] biter = innlesing.nextLine().split(",");
            String navn = biter[0];
            int fnr = Integer.parseInt(biter[1]);
            Pasient pasient = new Pasient(navn, fnr);
          }

        if(teller == 2){
          String [] biter = innlesing.nextLine().split(",");
          String navn = biter[0];
          String type = biter[1];
          Double pris = Double.parseDouble(biter[2]);
          Double virkestoff = Double.parseDouble(biter[3]);
          int styrke = Integer.parseInt(biter[4]);

          if(type.equals("narkotisk")){
            Narkotisk narkotisk = new Narkotisk(navn, pris, virkestoff, styrke);
            legemiddelListe.leggTil(narkotisk);
          }

          else if(type.equals("vanedannende")){
            Vanedannende vanedannende = new Vanedannende(navn, pris, virkestoff, styrke);
            legemiddelListe.leggTil(vanedannende);
          }

          else if(type.equals("vanlig")){
            Vanlig vanlig = new Vanlig(navn, pris, virkestoff);
              legemiddelListe.leggTil(vanlig);
          }
        }

        if(teller == 3){
          String [] biter = innlesing.nextLine().split(",");
          String navn = biter[0];
          int kontrollid = Integer.parseInt(biter[1]);
          Pasient pasient = new Pasient(navn, kontrollid);


          if(kontrollid == 0){
            Lege lege = new Lege(navn);
            legeListe.leggTil(lege);
          }
          else{
            Spesialist spesialist = new Spesialist(navn, kontrollid);
            legeListe.leggTil(spesialist);
          }
        }

        if(teller == 4){
          String [] biter = innlesing.nextLine().split(",");
          int legemiddelNummer = Integer.parseInt(biter[0]);
          String legeNavn = biter[1];
          int pasientID = Integer.parseInt(biter[2]);
          String type = biter[3];
          int reit = Integer.parseInt(biter[4]);

          Legemiddel legemiddelet = legemiddelListe.hent(legemiddelNummer);

          Lege rettLege = null;
          for (int i = 0; i < legeListe.stoerrelse(); i++){
            Lege legen = legeListe.hent(i);
            if(legen.hentNavn() == legeNavn){
              rettLege = legen;
            }
          }

          Pasient riktigPasient = null;
          for(int i = 0; i < pasientListe.stoerrelse(); i++){
            if(pasientListe.hent(i).hentID() == pasientID){
              riktigPasient = pasientListe.hent(i);
            }
          }

          if(type.equals("blaa")){
            rettLege.skrivBlaaResept(legemiddelet, rettLege, riktigPasient, reit);
          }
          if(type.equals("hvit")){
            rettLege.skrivHvitResept(legemiddelet, rettLege, riktigPasient, reit);
          }
          if(type.equals("militaer")){
            rettLege.skrivMillitaerResept(legemiddelet, rettLege, riktigPasient, reit);
          }
          if(type.equals("p")){
            rettLege.skrivPResept(legemiddelet, rettLege, riktigPasient);
          }
        }
      }
    }
  }
