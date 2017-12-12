package trabalho.pooii.Interfces;

import Funcionalidades.Cadastrar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import trabalho.pooii.MenuPrincipal;

public class SystemLogin extends JFrame implements ActionListener{
    
    JTextField CaixaUsuario = new JTextField();  JLabel TextUsuario = new JLabel("Usuario");
    JTextField CaixaSenha = new JTextField();    JLabel TextSenha = new JLabel("Senha");
                                                 JLabel Fail = new JLabel("");
    JButton Comfirmar = new JButton("Comfirmar");
    JPanel Painel = new JPanel();
    
    public SystemLogin() {
        super("Login");
        super.setSize(360,300);
        super.setVisible(true);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        super.add(Painel);
        super.setLocation(450,200);
        Painel.setLayout(null);
        
        { //Componentes de tela;
            //JLabel
            TextUsuario.setLocation(20, 80);
            TextUsuario.setSize(80, 25);
            Painel.add(TextUsuario);
            //TextField
            CaixaUsuario.setLocation(80, 80);
            CaixaUsuario.setSize(200, 25);
            Painel.add(CaixaUsuario);
            //JLabel
            TextSenha.setLocation(20,110);
            TextSenha.setSize(80, 25);
            Painel.add(TextSenha);
            //TextField
            CaixaSenha.setLocation(80,110);
            CaixaSenha.setSize(200, 25);
            Painel.add(CaixaSenha);
        }
        {//Entrada Invalida
            Fail.setLocation(125,150);
            Fail.setSize(100, 25);
            Painel.add(Fail);
            
        }
        {//Botão Ok
            
            Comfirmar.setLocation(125,200);
            Comfirmar.setSize(100, 25);
            Comfirmar.addActionListener((ActionListener)this);
            Painel.add(Comfirmar);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if("".equals(CaixaUsuario.getText()) || "".equals(CaixaSenha.getText())){
            Fail.setText("Entrada Invalida!");
        }else{
            new MenuPrincipal();
            this.dispose();
        }
    }
}
