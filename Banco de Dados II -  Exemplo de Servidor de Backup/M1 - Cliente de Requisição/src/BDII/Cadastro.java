package BDII;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Cadastro extends JFrame implements ActionListener{
    PrintWriter escritor;
    Socket socket;
    Scanner leitor;
    JTextField nome = new JTextField();
    JTextField cpf = new JTextField();
    JTextField matricula = new JTextField();
    JTextField ano = new JTextField();
    JTextArea textoRecebido = new JTextArea();
    JPanel Painel = new JPanel();
    
    public Cadastro(){
        ExecutarSocket();
        super.setTitle("Cadastro");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
        super.setLocationRelativeTo(null);
        super.setSize(360, 300);
        super.add(Painel);
        Painel.setLayout(null);        
        {//Caixas de texto
            JLabel XNome = new JLabel("Nome");
            XNome.setLocation(20, 50);
            XNome.setSize(80, 25);
            Painel.add(XNome);

            //TextFieldNome
            nome.setLocation(80, 50);
            nome.setSize(200, 25);
            Painel.add(nome);


            JLabel XCpf = new JLabel("Cpf");
            XCpf.setLocation(20, 80);
            XCpf.setSize(80, 25);
            Painel.add(XCpf);
            
            //TextFieldCPF
            cpf.setLocation(80, 80);
            cpf.setSize(200, 25);
            Painel.add(cpf);
            
            JLabel XMatricula = new JLabel("Matricula");
            XMatricula.setLocation(20,110);
            XMatricula.setSize(80, 25);
            Painel.add(XMatricula);
            
            //TextFieldMatricula
            matricula.setLocation(80,110);
            matricula.setSize(200, 25);
            Painel.add(matricula);
            
            JLabel XAno = new JLabel("Ano");
            XAno.setLocation(20,140);
            XAno.setSize(80, 25);
            Painel.add(XAno);
            
            //TextFieldMatricula
            ano.setLocation(80,140);
            ano.setSize(200, 25);
            Painel.add(ano);
        }
        
        {//Botão Enviar
            JButton Enviar = new JButton("Enviar");
            Enviar.setLocation(130,200);
            Enviar.setSize(80, 25);
            Enviar.addActionListener((ActionListener)this);
            Painel.add(Enviar);
        }
    }
    private class RecebeMSGServer implements Runnable{
        
//classe responsavel por receber as mensagens recebidas do outro usuario que enviou para o servidor
        @Override
        public void run(){
            String texto;
            while((texto = leitor.nextLine()) != null){
                textoRecebido.append(texto+"\n");
                System.out.println("Servidor Respondeu: "+texto);
            }
        }
    }
    private void ExecutarSocket(){
         try{
            socket = new Socket("127.0.0.1",5000);//para usar o socket é preciso usar o ip e o numero de uma porta acima de 1023
            System.out.println("conectado ao Servidor!");
            escritor = new PrintWriter(socket.getOutputStream());
            leitor = new Scanner(socket.getInputStream());
            new Thread(new RecebeMSGServer()).start();
         }catch(Exception e){
             System.out.println("Servidor não encontrado!");
         }
     }
    @Override
    public void actionPerformed(ActionEvent e) {
        if("".equals(nome.getText()) || "".equals(cpf.getText()) || "".equals(matricula.getText()) || "".equals(ano.getText()) ){
             
        }else{
            escritor.println("insert into aluno (Cod,nome,cpf,matricula,ano) values (DEFAULT,'"+nome.getText()+"','"+cpf.getText()+"','"+matricula.getText()+"','"+ano.getText()+"');");
            escritor.flush();
            nome.setText(""); nome.requestFocus();
            cpf.setText("");  cpf.requestFocus();
            matricula.setText(""); matricula.requestFocus();
            ano.setText(""); ano.requestFocus();
        }
        
    } 
}
