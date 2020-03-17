class Lege implements Comparable<Lege> { //Oppretter klassen Lege.
  String legeNavn; //protected variabel legeNavn slik at den er tilgjengelig for subklasser.
  Lenkeliste<Resepter> utskrevedeResepter = new Lenkeliste<Resepter>();

  public Lege(String navn) { //Konstruktoer som tar imot en String navn.
    legeNavn = navn; //settes som verdien til legeNavn.
  }

  public String hentLegeNavn() { //Metode for aa hente legeNavn.
    return legeNavn;
  }

  public String toString() { //Metode for aa returnere en string til utskrift.
    return legeNavn;
  }

  @Override
  public int compareTo(Lege lege){
    return (this.legeNavn.compareTo(lege.hentLegeNavn()));
  }

  public Lenkeliste<Resepter> hentUtResepter(){
    return this.utskrevedeResepter;
  }
}
