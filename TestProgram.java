class TestProgram{
  public static void main(String[] args){
    Pasient pasient = new Pasient(240999, "Cecilie");
    Lege lege = new Lege("Benjamin");
    Vanlig legemiddel = new Vanlig("Jonas", 125, 5);
    BlaaResept resept = new BlaaResept(legemiddel, lege, pasient, 3);
    Liste<Pasient> pasientListe = new Lenkeliste<Pasient>();
    Liste<Lege> legeListe = new Lenkeliste<Lege>();
    Liste<Legemiddel> legemiddelListe = new Lenkeliste<Legemiddel>();
    Liste<Resepter> reseptListe = new Lenkeliste<Resepter>();
    pasientListe.leggTil(pasient);

    System.out.println(pasient.hentNavn());
    System.out.println(pasient.hentID());
    pasient.leggTilResept(resept);
    Stabel<Resepter> denne = pasient.hentReseptene();

    System.out.println(denne.hentLegemiddel());
  }
}
