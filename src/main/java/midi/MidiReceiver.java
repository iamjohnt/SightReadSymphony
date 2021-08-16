package midi;

import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;
import java.util.ArrayList;
import java.util.List;

/** Overview - a custom reciever that recieves midi messages, which listeners can listen to, and then do something
 * Purpose - to provide a way to handle incoming midi messages in a custom way
 * UseCase - this is instantiated within game session, where a customer listener is created that holds the game's logic to handle an incoming midi message
 * that listener is then added to this reciever, and then this reciever is set as the midi devices reciever. The midi device is now connected to the program */
public class MidiReceiver implements Receiver {

    // listeners, that listen for new midi messages
    private List<MidiListener> listener = new ArrayList<>();

    /** whenever a midi message is generated from a connected transmitter, this message is always called
    * here we override it, and tell all listeners to handle the midi message, according to their own internal logic */
    @Override public void send(MidiMessage midiMessage, long timeStamp) {
        for (int i = 0; i < listener.size(); i++) {
            if (listener.get(i) != null) {
                listener.get(i).handle(midiMessage);
            }
        }
    }

    @Override
    public void close() {
        // unnecessary, so does nothing
    }

    /** adds a listener to the list, that will do something when a midi message arrives */
    public void addListener(MidiListener newObserver) {
        listener.add(newObserver);
    }

    /** removes a particular listener */
    public boolean removeListener(MidiListener observer2remove) {
        if (observer2remove == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < listener.size(); i++) {
            if (listener.get(i) == observer2remove) {
                listener.remove(i);
                return true;
            }
        }
        return false;
    }

    /** clears all the listeners */
    public void clearListeners() {
        listener.clear();
    }

}
