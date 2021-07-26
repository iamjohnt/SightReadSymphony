package midi;

import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;
import java.util.ArrayList;
import java.util.List;

public class MidiReceiver implements Receiver {

    // listeners, that listen for new midi messages
    private List<MidiListener> listener = new ArrayList<>();

    @Override
    /* whenever a midi message is generated from a connected transmitter, this is called
    * here we tell all listeners to handle it*/
    public void send(MidiMessage midiMessage, long timeStamp) {
        for (int i = 0; i < listener.size(); i++) {
            if (listener.get(i) != null) {
                listener.get(i).handle(midiMessage);
            }
        }
    }

    @Override
    public void close() {

    }

    public void addListener(MidiListener newObserver) {
        listener.add(newObserver);
    }

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

    public void clearListeners() {
        listener.clear();
    }

}
