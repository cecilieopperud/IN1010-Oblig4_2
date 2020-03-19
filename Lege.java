class Lege implements Comparable<Lege> { //Oppretter klassen Lege.
  String legeNavn; //protected variabel legeNavn slik at den er tilgjengelig for subklasser.
  Lenkeliste<Resepter> utskrevedeResepter = new Lenkeliste<Resepter>();

  public Lege(String navn) { //Konstruktoer som tar imot en String navn.
    legeNavn = navn; //settes som verdien til legeNavn.
  }

  public String hentNavn() { //Metode for aa hente legeNavn.
    return legeNavn;
  }

  public String toString() { //Metode for aa returnere en string til utskrift.
    return legeNavn;
  }

  @Override
  public int compareTo(Lege lege){
    return (this.legeNavn.compareTo(lege.hentNavn()));
  }

  public Lenkeliste<Resepter> hentUtResepter(){
    return this.utskrevedeResepter;
  }

  public HvitResept skrivHvitResept(Legemiddel legemiddel, Lege lege, Pasient pasient, int reit) throws UlovligUtskrift{
    HvitResept hResept = new HvitResept(legemiddel, lege, pasient, reit);
    if (hResept.hentLegemiddel() instanceof Narkotisk) {
      throw new UlovligUtskrift(lege, legemiddel, pasient.hentID());
    }
    else{
      utskrevedeResepter.leggTil(hResept);
      pasient.leggTilResept(hResept);
      return hResept;
    }
  }

  public MilaeterResept skrivMillitaerResept(Legemiddel legemiddel, Lege lege, Pasient pasient, int reit) throws UlovligUtskrift {
    MilaeterResept mResept = new MilaeterResept(legemiddel, lege, pasient, reit);
    if (mResept.hentLegemiddel() instanceof Narkotisk) {
      throw new UlovligUtskrift(lege, legemiddel, pasient.hentID());
    }
    else{
      utskrevedeResepter.leggTil(mResept);
      pasient.leggTilResept(mResept);
      return mResept;
    }
  }

  public PResept skrivPResept(Legemiddel legemiddel, Lege lege, Pasient pasient) throws UlovligUtskrift{
    PResept pResept = new PResept(legemiddel, lege, pasient);
      if (pResept.hentLegemiddel() instanceof Narkotisk){
        throw new UlovligUtskrift(lege, legemiddel, pasient.hentID());
      }
      else{
        utskrevedeResepter.leggTil(pResept);
        pasient.leggTilResept(pResept);
        return pResept;
      }
    }

  public BlaaResept skrivBlaaResept(Legemiddel legemiddel, Lege lege, Pasient pasient, int reit) throws UlovligUtskrift {
    BlaaResept bResept = new BlaaResept(legemiddel, lege, pasient, reit);
    if (bResept.hentLegemiddel() instanceof Narkotisk) {
      throw new UlovligUtskrift(lege, legemiddel, pasient.hentID());
    }
    else{
      utskrevedeResepter.leggTil(bResept);
      pasient.leggTilResept(bResept);
      return bResept;
    }
  }
}
