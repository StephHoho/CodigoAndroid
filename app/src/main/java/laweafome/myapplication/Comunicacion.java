package laweafome.myapplication;

import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.Observable;

/**
 * Created by ASUS on 3/1/2017.
 */

public class Comunicacion extends Observable implements Runnable {
    private InetAddress ipDestino;
    private int puertoDestino;
    private int miPuerto;
    private DatagramSocket miBuzon;
    public String mensaje;
    private static Comunicacion ref;

    public Comunicacion(){
        try {
            ipDestino= InetAddress.getByName("172.30.163.211");
            //miPuerto= 5001;

            puertoDestino= 5000;
          //  miBuzon= new DatagramSocket();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void run() {
        while (true){
            try{
                setChanged();
                notifyObservers();
                clearChanged();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public void enviar(final String data) {
        new Thread(new Runnable() {
            public void run() {
                // while (true) {
                try {
                    miBuzon= new DatagramSocket();
                    byte[] bytes = data.getBytes();
                    DatagramPacket enviarP = new DatagramPacket(bytes, bytes.length, ipDestino, puertoDestino);
                    miBuzon.send(enviarP);
                    Log.d("enviar","mensaje enviado");
                } catch (SocketException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // }
            }
        }).start();
    }

    public static Comunicacion getInstance(){
        if(ref==null){
            ref= new Comunicacion();
            new Thread(ref).start();
        }
        return ref;
    }
}

