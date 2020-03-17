class Spesialist extends Lege implements Godkjenningsfritak { //Klassen Speialist arver fra Lege og implementerer grensesnittet Godkjenningsfritak.
  int kontrollID; //Deklarerer i tillegg variabelen kontrollID.

  public Spesialist(String legeNavn, int kontroll) { //To parameter.
    super(legeNavn); //Aksesserer superklassens Lege sin kontruktoer.
    kontrollID = kontroll; //Oppretter og gir verdi til kontrollID.
  }

  @Override //Overskriver grensesnittets metode ved aa returnere kontrollID.
  public int hentKontrollID() {
    return kontrollID;
  }

  @Override //Overskriver toString() metoden med aa legge til den informasjonen som trengs.
  public String toString() {
    return super.toString() + " med godkjenningsfritaket " + kontrollID;
  }
}
