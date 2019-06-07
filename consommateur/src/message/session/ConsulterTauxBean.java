package message.session;


import message.entity.ConversionTauxEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless (mappedName="ConsulterTaux")
public class ConsulterTauxBean implements ConsulterTauxItf {

    @PersistenceContext (unitName="consulterTauxPU")
    private EntityManager em;

    @Override
    public float conversion(String mA, String mB, float montant) {
        ConversionTauxEntity conversionTauxEntity = (ConversionTauxEntity) em.createQuery("SELECT c FROM ConversionTauxEntity c WHERE c.monnaieA = :mA AND c.monnaieB = :mB")
                .setParameter("mA",mA)
                .setParameter("mB",mB)
                .getSingleResult();

        return montant * conversionTauxEntity.getTaux();
    }

    @Override
    public float read(String mA, String mB) {
        ConversionTauxEntity conversionTauxEntity = (ConversionTauxEntity) em.createQuery("SELECT c FROM ConversionTauxEntity c WHERE c.monnaieA = :mA AND c.monnaieB = :mB")
                .setParameter("mA",mA)
                .setParameter("mB",mB)
                .getSingleResult();

        return conversionTauxEntity.getTaux();
    }

}
