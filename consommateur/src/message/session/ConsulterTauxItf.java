package message.session;


import javax.ejb.Local;

@Local
public interface ConsulterTauxItf {

    public float conversion(String mA, String mB, float montant);
    public float read(String mA, String mB);
}
