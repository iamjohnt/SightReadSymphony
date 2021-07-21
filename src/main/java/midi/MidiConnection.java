package midi;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Transmitter;
import java.util.ArrayList;

public class MidiConnection {

    private ArrayList<MidiDevice> connectedDevices = new ArrayList<>();

    public MidiConnection() {
        connectedDevices = getMidiDevicesWithTransmitters();
    }


    public String[] getAvailTransmitterNames() {
        String[] rtn = new String[connectedDevices.size()];
        for (int i = 0; i < connectedDevices.size(); i++) {
            rtn[i] = connectedDevices.get(i).getDeviceInfo().getName();
        }
        return rtn;
    }

    public String[] getAvailTransmitterDescriptions() {
        String[] rtn = new String[connectedDevices.size()];
        for (int i = 0; i < connectedDevices.size(); i++) {
            rtn[i] = connectedDevices.get(i).getDeviceInfo().getDescription();
        }
        return rtn;
    }

    public String[] getAvailTransmitterVendors() {
        String[] rtn = new String[connectedDevices.size()];
        for (int i = 0; i < connectedDevices.size(); i++) {
            rtn[i] = connectedDevices.get(i).getDeviceInfo().getVendor();
        }
        return rtn;
    }

    // prints the connected devices (these should all have transmitters)
    public void printAvailMidiDevicesWithTransmitters() {
        for (MidiDevice device : connectedDevices) {
            System.out.println("NAME: " + device.getDeviceInfo().getName() + ", DESCRIPTION: " + device.getDeviceInfo().getDescription() + ", VENDOR: " + device.getDeviceInfo().getVendor());
        }
    }

    // returns an arraylist of MidiDevices, that have transmitters
    private ArrayList<MidiDevice> getMidiDevicesWithTransmitters() {
        MidiDevice.Info[] allDevices = MidiSystem.getMidiDeviceInfo();
        ArrayList<MidiDevice> devicesWithTransmitters = new ArrayList<>();
        for (int i = 0; i < allDevices.length; i++) {
            MidiDevice current = null;
            try {
                current = MidiSystem.getMidiDevice(allDevices[i]);
            } catch (MidiUnavailableException e) {
                e.printStackTrace();
            }
            boolean deviceHasTransmitter = false;

            // determine if device has transmitter
            try {
                Transmitter transmitter = current.getTransmitter();
                // if no exception thrown, then return true
                deviceHasTransmitter = true;
            } catch (MidiUnavailableException e) {
                // if exception thrown, then return false
                deviceHasTransmitter = false;
            }

            if (deviceHasTransmitter) {
                devicesWithTransmitters.add(current);
            }
        }
        return devicesWithTransmitters;
    }

    public MidiDevice getDeviceByName(String name) {
        for (int i = 0; i < connectedDevices.size(); i++) {
            if (connectedDevices.get(i).getDeviceInfo().getName().equalsIgnoreCase(name)) {
                System.out.println("found device with name: " + name);
                return connectedDevices.get(i);
            }
        }
        System.out.println("Not found!");
        return null;
    }

}
