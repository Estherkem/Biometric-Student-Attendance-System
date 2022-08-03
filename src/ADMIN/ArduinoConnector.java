/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADMIN;

import org.zu.ardulink.Link;
import org.zu.ardulink.RawDataListener;
import java.util.List;

/**
 *
 * @author STAR
 */
public class ArduinoConnector implements RawDataListener {

    public void blahblah() {
        try {
            // 1
            // Comment this row if you use just the default connection
            

            List<String> portList = Link.getDefaultInstance().getPortList(); // 2
            if (portList != null && portList.size() > 0) {
                String port = portList.get(0);
                System.out.println("Connecting on port: " + port);
                boolean connected = Link.getDefaultInstance().connect(port); // 3
                System.out.println("Connected:" + connected);
                Thread.sleep(2000); // 4
                
            } else {
                System.out.println("No port found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Start Listening");
        while(true){
        Link.getDefaultInstance().sendCustomMessage("YAZZZ");
        }
        //Link.getDefaultInstance().writeSerial("WHATEVER");
        //Link.getDefaultInstance().disconnect();
    }
    
    public static void main(String[] args){
        ArduinoConnector ac = new ArduinoConnector();
        ac.blahblah();
    }
    
    @Override
    public void parseInput(String id, int numBytes, int[] message) {
        // read the message
        StringBuilder build = new StringBuilder(numBytes + 1);
        for (int i = 0; i < numBytes; i++) {
            build.append((char) message[i]);
        }
         String messageString = build.toString();
         if (messageString.startsWith("WHATEVER")) {
            messageString = messageString.substring("WHATEVER".length());
            // print the value on the screen/to console
            System.out.println(messageString);
            int dataNewPoint=Integer.parseInt(messageString);
        }
    }
}
