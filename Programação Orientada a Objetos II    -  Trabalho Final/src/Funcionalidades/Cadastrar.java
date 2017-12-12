package Funcionalidades;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import trabalho.pooii.Interfces.ClaseDAO;
import trabalho.pooii.Interfces.Variaveis;


public class Cadastrar extends JFrame implements ActionListener{
    PrintWriter escritor;
    JButton Cadastrar = new JButton("Cadastrar");
    JButton Cancelar = new JButton("Cancelar");
    JTextField nome = new JTextField();
    JTextField cpf = new JTextField();
    JTextField telefone = new JTextField();
    JPanel Painel = new JPanel();
    JFormattedTextField DataNascimento;
    public Cadastrar() throws ParseException{
        super.setTitle("Cadastro");
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
            
            JLabel XMatricula = new JLabel("Telefone");
            XMatricula.setLocation(20,110);
            XMatricula.setSize(80, 25);
            Painel.add(XMatricula);
            
            //TextFieldMatricula
            telefone.setLocation(80,110);
            telefone.setSize(200, 25);
            Painel.add(telefone);
            
            JLabel XAno = new JLabel("Data");
            XAno.setLocation(20,140);
            XAno.setSize(80, 25);
            Painel.add(XAno);
            
            //TextFieldData
            DataNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
            DataNascimento.setLocation(80,140);
            DataNascimento.setSize(200, 25);
            DataNascimento.setValue(null);
            DataNascimento.setColumns(6);
            Painel.add(DataNascimento);
        }
        
        {//Botão Cadastrar
            
            Cadastrar.setLocation(40,200);
            Cadastrar.setSize(100, 25);
            Cadastrar.addActionListener((ActionListener)this);
            Painel.add(Cadastrar);
        }
        {//Botão Cancelar
            Cancelar.setLocation(200,200);
            Cancelar.setSize(100, 25);
            Cancelar.addActionListener((ActionListener)this);
            Painel.add(Cancelar);
        }
        
    }

    public String getNome() {
        return nome.getText();
    }

    public String getCpf() {
        return cpf.getText();
    }

    public String getTelefone() {
        return telefone.getText();
    }

    public String getDataNascimento() {
        return DataNascimento.getText();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Cadastrar){
            if("".equals(nome.getText()) || "".equals(cpf.getText()) || "".equals(telefone.getText()) || "".equals(DataNascimento.getText()) ){

            }else{
                Variaveis Var = new Variaveis(nome.getText(),cpf.getText(),telefone.getText(),DataNascimento.getText());
                try {
                    ClaseDAO.Write(Var);
                } catch (SQLException ex) { }
            }
        }else{
            this.dispose();
        }
    } 
}
