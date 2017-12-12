
package trabalho;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Servidor {
   ServerSocket server;
   Scanner leitor;
   String texto;
   List<PrintWriter> escritores = new ArrayList<>();//é preciso arrayList porque cada cliente vai gerar os PrintWriter
       
   public Servidor(){
        try{
            server = new ServerSocket(5000);
            while(true){
                Socket s = server.accept();
                System.err.println("Cliente Conectado: "+s.getInetAddress().getHostAddress());   
                new Thread(new msgCliente(s)).start();
                PrintWriter p =new PrintWriter(s.getOutputStream());
                escritores.add(p);//a cada PrinWriter é incluido no arrayList escritores
            }
        }catch(IOException e){}
       
    }
    
    private void encaminharMsg(String texto){//metodo responsavel por encaminhar todas mensagens para os clientes
        for(PrintWriter w : escritores){//será pecorrido todos PrintWriter
            w.println(texto);
            w.flush();
        }
    }
    
    public class msgCliente implements Runnable{
        Scanner leitor;
        public msgCliente(Socket s){
            try{
                leitor = new Scanner(s.getInputStream());
            }catch(IOException e){
            
            }
        }
        
        @Override
        public void run(){
            try{
               
                while((texto = leitor.nextLine()) != null){
                    System.out.println("Recebido:"+texto);
                    InserirData.InsertInData(Conexao.getConnection(), texto);
                    encaminharMsg(texto);
                }
            }catch(Exception e){
            
            }
        }

    }
}
