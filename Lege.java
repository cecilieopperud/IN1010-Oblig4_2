class Lege implements Comparable<Lege> { //Oppretter klassen Lege.
  String legeNavn; //protected variabel legeNavn slik at den er tilgjengelig for subklasser.
  Lenkeliste<Resepter> utskrevedeResepter = new Lenkeliste<Resepter>();
  Lege denneLegen;
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
    return (legeNavn.compareTo(lege.hentNavn()));
  }

  public Lenkeliste<Resepter> hentUtResepter(){
    return utskrevedeResepter;
  }

  public HvitResept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{
    HvitResept hResept = new HvitResept(legemiddel , denneLegen , pasient, reit);
    if (hResept.hentLegemiddel() instanceof Narkotisk) {
      throw new UlovligUtskrift( denneLegen, legemiddel, pasient.hentID());
    }
    else{
      utskrevedeResepter.leggTil(hResept);
      pasient.leggTilResept(hResept);
      return hResept;
    }
  }

  public MilaeterResept skrivMillitaerResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
    MilaeterResept mResept = new MilaeterResept(legemiddel, denneLegen, pasient, reit);
    if (mResept.hentLegemiddel() instanceof Narkotisk) {
      throw new UlovligUtskrift( denneLegen, legemiddel, pasient.hentID());
    }
    else{
      utskrevedeResepter.leggTil(mResept);
      pasient.leggTilResept(mResept);
      return mResept;
    }
  }

  public PResept skrivPResept(Legemiddel legemiddel, Pasient pasient) throws UlovligUtskrift{
    PResept pResept = new PResept(legemiddel ,denneLegen, pasient);
      if (pResept.hentLegemiddel() instanceof Narkotisk){
        throw new UlovligUtskrift( denneLegen, legemiddel, pasient.hentID());
      }
      else{
        utskrevedeResepter.leggTil(pResept);
        pasient.leggTilResept(pResept);
        return pResept;
      }
    }

  public BlaaResept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {

    BlaaResept bResept = new BlaaResept(legemiddel , denneLegen, pasient, reit);

    if (bResept.hentLegemiddel() instanceof Narkotisk) {
      throw new UlovligUtskrift(denneLegen, legemiddel, pasient.hentID());
    }

    else{
      utskrevedeResepter.leggTil(bResept);
      pasient.leggTilResept(bResept);
      return bResept;
    }
  }

}

