package message;

import message.session.ConsulterTauxItf;

import javax.ejb.*;
import javax.jms.*;

@MessageDriven(mappedName = "uneBALExo6")
public class SimpleMessageBean implements MessageListener {

    public SimpleMessageBean() {
    }

    @EJB private ConsulterTauxItf consulterTauxItf;

    public void onMessage(Message inMessage) {
        TextMessage msg = null;

        try {
            if (inMessage instanceof TextMessage) {
                msg = (TextMessage) inMessage;

                System.out.println("Message recu: " + msg.getText() +
                        " Taux : "+consulterTauxItf.read("euros","bitcoin"));
            } else {
                System.out.println("Message of wrong type: " + inMessage.getClass().getName());
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (Throwable te) {
            te.printStackTrace();
        }
    }
}
