import java.io.*;  
import java.net.*;  
//https://www.journaldev.com/741/java-socket-programming-server-client
public class MyClientSocket {  
// public static void main(String[] args) {  
// try{      
// Socket socket=new Socket("localhost",6665);  
// DataOutputStream dout=new DataOutputStream(socket.getOutputStream());  
// dout.writeUTF("Hello Server");  
// dout.flush();  
// dout.close();  
 

//  //read from socket to ObjectInputStream object
//  DataInputStream ois = new DataInputStream(socket.getInputStream());
//  //convert ObjectInputStream object to String
//             String message = (String) ois.readUTF();
//             System.out.println("FRom server: " + message);

// ois.close();
// }catch(Exception e){System.out.println(e);}  
// }  

	 public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
        //get the localhost IP address, if server is running on some other IP, you need to use that
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = null;
        DataOutputStream oos = null;
        DataInputStream ois = null;
        for(int i=0; i<5;i++){
            //establish socket connection to server
            socket = new Socket(host.getHostName(), 4200);
            //write to socket using ObjectOutputStream
            oos = new DataOutputStream(socket.getOutputStream());
            System.out.println("Sending request to Socket Server");
            if(i==4)oos.writeUTF("exit");
            else oos.writeUTF(""+ "komal");
            //read the server response message
            // ois = new DataInputStream(socket.getInputStream());
            // String message = (String) ois.readUTF();
            // System.out.println("Message: " + message);
            // //close resources
          //  ois.close();
            oos.close();
           Thread.sleep(100);
       }
    }


}  