/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teleasthmaserver;

import Patient.Data;
import Patient.Patient;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sofia
 */
public class TeleAsthmaServer implements Serializable{
        static InputStream inputStream = null;
        static ObjectInputStream objectInputStream = null;
        static ServerSocket serverSocket = null;
        static Socket socket = null;
        static ObjectOutputStream oos= null;
        
        static Calendar fecha = new GregorianCalendar();

        static int año = fecha.get(Calendar.YEAR);
        static int mes = fecha.get(Calendar.MONTH)+1;
        static int dia = fecha.get(Calendar.DAY_OF_MONTH);
        static String fechaActual= dia + "-" + mes + "-" + año;
        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        
        //socketServerData();
        socketServerPatient();
        
        
    }

    private static void releaseResources(ObjectInputStream objectInputStream, ObjectOutputStream oos, Socket socket, ServerSocket serverSocket) {
        try {
            objectInputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(TeleAsthmaServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(TeleAsthmaServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(TeleAsthmaServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(TeleAsthmaServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void socketServerData(){
     try {
            serverSocket = new ServerSocket(9000);
            socket = serverSocket.accept();
            inputStream = socket.getInputStream();
            System.out.println("Connection from the direction "
                    + socket.getInetAddress());
        } catch (IOException ex) {
            System.out.println("It was not possible to start the server. Fatal error.");
            Logger.getLogger(TeleAsthmaServer.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(-1);
        }
        try {
            objectInputStream = new ObjectInputStream(inputStream);
           //File file = new File("/Users/mariapalacios/Desktop/CEUCUARTO/Telemedicina/Telemedicina"+patient.getId()+"/Data" + fechaActual +".txt");
           File file = new File("data.txt");
            oos= new ObjectOutputStream(new FileOutputStream(file));
            Object tmp;
            
            while ((tmp = objectInputStream.readObject()) != null) {
                //Patient patient = (Patient) tmp;
                //oos.writeObject(patient);
                Data data = (Data) tmp;
                oos.writeObject(data);
                //System.out.println(patient.toString());
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                Object aux = ois.readObject();
                System.out.println(aux);
            }
            
            // Mientras haya objetos
            //ois.close();
        } catch (EOFException ex) {
            System.out.println("All data have been correctly read.");
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Unable to read from the client.");
            Logger.getLogger(TeleAsthmaServer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            releaseResources(objectInputStream, oos, socket, serverSocket);
        }   
    }
    private static void socketServerPatient() throws FileNotFoundException, IOException, ClassNotFoundException{
            try{
            serverSocket = new ServerSocket(9000);
            socket = serverSocket.accept();
            inputStream = socket.getInputStream();
            objectInputStream = new ObjectInputStream(inputStream);

            
            }catch (IOException ex) {
            System.out.println("It was not possible to start the server. Fatal error.");
            Logger.getLogger(TeleAsthmaServer.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(-1);
        }

            try{
            Object tmp;
            
            while ((tmp = objectInputStream.readObject()) != null) {
            Patient patient = (Patient) tmp;
            File carpeta=new File("/Users/mariapalacios/Desktop/CEUCUARTO/Telemedicina/TelemedicinaPaciente"+patient.getId()); 
            carpeta.mkdir(); 
            File file = new File("/Users/mariapalacios/Desktop/CEUCUARTO/Telemedicina/TelemedicinaPaciente"+patient.getId()+"/pacienteInfo"+fechaActual+".txt");
            oos= new ObjectOutputStream(new FileOutputStream(file));
               oos.writeObject(patient);
                System.out.println(patient.toString());
                //ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
                //Object aux = ois.readObject();
                //System.out.println(aux);
            }
    } catch (EOFException ex) {
            System.out.println("All data have been correctly read.");
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Unable to read from the client.");
            Logger.getLogger(TeleAsthmaServer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            releaseResources(objectInputStream, oos, socket, serverSocket);
        }
}
}
