package trabalho.pooii;

import Funcionalidades.Cadastrar;
import Funcionalidades.Listar;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MenuPrincipal extends JFrame implements ActionListener{
    
    JPanel Painel = new JPanel();
    JButton Cadastrar = new JButton("Cadastrar");
    JButton Exibir = new JButton("Exibir");
    JButton Excluir = new JButton("Excluir");
    JButton Editar = new JButton("Editar");
    JButton Pesquisar = new JButton("Pesquisar");
    
    public MenuPrincipal() {
        super("Menu");
        super.setSize(600,120);
        super.setVisible(true);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        super.add(Painel);
        super.setLocation(450,200);
        Painel.setLayout(new GridLayout());
        
        Cadastrar.addActionListener(this);
        Exibir.addActionListener(this);
        Editar.addActionListener(this);
        Excluir.addActionListener(this);
        Pesquisar.addActionListener(this);
        
        Painel.add(Cadastrar);
        Painel.add(Exibir);
        Painel.add(Editar);
        Painel.add(Excluir);
        Painel.add(Pesquisar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Cadastrar){
            try {
                new Cadastrar();
            } catch (ParseException ex) {}
        }
        if(e.getSource() == Excluir){
            
        }
        if(e.getSource() == Editar){
            
        }
        if(e.getSource() == Exibir){
            try {
                new Listar();
            } catch (SQLException ex) {}
        }
        if(e.getSource() == Pesquisar){
            
        }
        else{}
    }

    
    
}
