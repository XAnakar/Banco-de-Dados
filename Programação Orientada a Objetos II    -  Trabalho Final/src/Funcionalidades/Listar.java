package Funcionalidades;

import java.awt.BorderLayout;
import trabalho.pooii.Interfces.ClaseDAO;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import trabalho.pooii.Interfces.Variaveis;

public class Listar extends JFrame implements ActionListener{
    JPanel Painel = new JPanel();
    JScrollPane Scroll;
    DefaultTableModel Modelo = new DefaultTableModel();
    JTable Tabela = new JTable(Modelo){
    
        @Override
        public boolean isCellEditable(int row, int column) {
                return false;
        }
    };

    public Listar() throws SQLException{
        Painel.setLayout(new GridLayout());
        Scroll = new JScrollPane(Tabela);
        Tabela.setGridColor(Color.blue);
        Scroll.setEnabled(false);
        Painel.add(Scroll); 
        //Painel.add(Tabela);
        getContentPane().add(Painel);
        setSize(600,320);
        super.setEnabled(true);
        setVisible(true);
      
        criaJTable(ClaseDAO.Read()) ;
    }
    private void criaJTable(ArrayList <Variaveis> Dados) {
        Modelo.addColumn("Id");
        Modelo.addColumn("Nome");
        Modelo.addColumn("CPF");
        Modelo.addColumn("Telefone");
        Modelo.addColumn("Data");
        Modelo.setNumRows(0);
        if(Dados.isEmpty()){
            Modelo.addRow(new String[]{"Null","Null","Null","Null","Null"});
        }else{
            Dados.stream().forEach((Variaveis Dado) -> {
                Modelo.addRow(new String[]{Dado.getId(), Dado.getNome(), Dado.getCpf(), Dado.getTelefone(), Dado.getNascimento()});
            });
        }
        Tabela.setModel(Modelo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
    }
}