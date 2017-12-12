
package CopyData;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class interfaceCliente  extends JFrame{
    
    JTextField texto =  new JTextField();
    JButton botao = new JButton("ENVIAR");
    JTextArea textoRecebido = new JTextArea();
    PrintWriter escritor;
    Socket socket;
    String nome;
    Scanner leitor;
    
    public interfaceCliente(String nome){
        
        
        super("Copia DataBase"+nome);
        this.nome =nome;
        JPanel painel =  new JPanel();
        painel.setLayout(null);
          
        texto.setSize(350,40);
        texto.setLocation(20,500);
         
        botao.setSize(200,40);
        botao.setLocation(380,500);
        botao.addActionListener(new enviar());
        
        textoRecebido.setSize(580,200);
        textoRecebido.setLocation(10,10);
          
        //painel.add(botao);
        //painel.add(texto);
        painel.add(textoRecebido);
        //painel.add(textoRecebido);
        
        add(painel);
        
        configuracao();
       
        
        //criação da JFrame
       setVisible(true);
       setResizable(false);//Para o JFrame não ter opção de maximizar 
       setSize(605,300);
       setLocationRelativeTo(null);//para o JFrame fica no meio
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }
    
    private class msgServidor implements Runnable{//classe responsavel por receber as mensagens recebidas do outro usuario que enviou para o servidor
        
        Connection Conect = Conexao.getConnection();
        @Override
        public void run(){
            String texto;
            while((texto = leitor.nextLine()) != null){
               textoRecebido.append(texto+"\n");//o texto recebido é escrito no JtextArea
                try {
                    InserirData.InsertInData(Conect,texto);
                } catch (SQLException ex) {}
            }
        }
    }
    
     private void configuracao(){
         try{
             //as portas de 0 - 1023 não podem ser usadas
            socket = new Socket("127.0.0.1",5000);//para usar o socket é preciso usar o ip e o numero de uma porta acima de 1023
            escritor = new PrintWriter(socket.getOutputStream());
            leitor = new Scanner(socket.getInputStream());
            new Thread(new msgServidor()).start();
         }catch(Exception e){}
     }
     
     private class enviar implements ActionListener{
     
         @Override
         public void actionPerformed(ActionEvent e){
             escritor.println(nome+":"+texto.getText());
             escritor.flush();
             texto.setText("");
             texto.requestFocus();
         }
     
     }
   
}
