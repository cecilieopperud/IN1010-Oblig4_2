public class TestProgram{
  public static void main(String[]args){
    Legesystem l = new Legesystem("Vedlegg.txt");
    //Liste<Resepter> reseptListe = l.returnerReseptListe();
    Liste<Legemiddel> legemiddelListe = l.retunerLegemiddelListe();
    //System.out.println(reseptListe);
    System.out.println(legemiddelListe);
  }

}
