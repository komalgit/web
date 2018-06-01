import java.io.*;
import java.net.*;

public class MyServerSocket{

	// public static void main(String[] args){
	// 	while(true){
	// 	try{
	// 		ServerSocket serverSocket = new ServerSocket(6666);
	// 		Socket socket = serverSocket.accept();	

	// 		DataInputStream dis=new DataInputStream(socket.getInputStream());  
	// 		String  str=(String)dis.readUTF();  
	// 		System.out.println("message= "+str);  
			
	// 		dis.close();
	// 		socket.close();



	// 	}catch(Exception e){
	// 		e.printStackTrace();
	// 	}
	// 	}	

	// }

	//static ServerSocket variable
    private static ServerSocket server;
    //socket server port on which it will listen
    private static int port = 6665;
    
    public static void main(String args[]) throws IOException, ClassNotFoundException{
        //create the socket server object
        server = new ServerSocket(port);
        //keep listens indefinitely until receives 'exit' call or program terminates
        while(true){
            System.out.println("Waiting for client request");
            //creating socket and waiting for client connection
            Socket socket = server.accept();
            //read from socket to ObjectInputStream object
            DataInputStream ois = new DataInputStream(socket.getInputStream());
            //convert ObjectInputStream object to String
            String message = (String) ois.readUTF();
            System.out.println("Message Received: " + message);
            //create ObjectOutputStream object
            DataOutputStream oos = new DataOutputStream(socket.getOutputStream());
            //write object to Socket
            oos.writeUTF("Hi Client "+message);
            //close resources
            ois.close();
            oos.close();
            socket.close();
            //terminate the server if client sends exit request
            if(message.equalsIgnoreCase("exit")) break;
        }
        System.out.println("Shutting down Socket server!!");
        //close the ServerSocket object
        server.close();
    }


}