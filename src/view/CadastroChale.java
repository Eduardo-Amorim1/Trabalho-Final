package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;

import persistence.ConexaoSql;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroChale extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField codChale;
	private JTextField local;
	private JTextField capacidade;
	private JTextField valorBaixa;
	private JTextField valorAlta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.err.println(ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroChale window = new CadastroChale();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastroChale() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 486, 402);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CADASTRO CHALE");
		lblNewLabel.setBounds(191, 0, 117, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cod Chale");
		lblNewLabel_1.setBounds(10, 46, 72, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Localização");
		lblNewLabel_1_1.setBounds(10, 94, 72, 22);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Capacidade");
		lblNewLabel_1_2.setBounds(10, 151, 72, 22);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Valor Alta Estação");
		lblNewLabel_1_3.setBounds(10, 269, 105, 22);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Valor Baixa Estação");
		lblNewLabel_1_4.setBounds(10, 210, 105, 22);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		codChale = new JTextField();
		codChale.setBounds(83, 47, 86, 20);
		frame.getContentPane().add(codChale);
		codChale.setColumns(10);
		
		local = new JTextField();
		local.setBounds(83, 95, 86, 20);
		frame.getContentPane().add(local);
		local.setColumns(10);
		
		capacidade = new JTextField();
		capacidade.setBounds(83, 152, 86, 20);
		frame.getContentPane().add(capacidade);
		capacidade.setColumns(10);
		
		valorBaixa = new JTextField();
		valorBaixa.setBounds(159, 211, 86, 20);
		frame.getContentPane().add(valorBaixa);
		valorBaixa.setColumns(10);
		
		valorAlta = new JTextField();
		valorAlta.setBounds(159, 270, 86, 20);
		frame.getContentPane().add(valorAlta);
		valorAlta.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    checkCadastroChale(codChale.getText(), local.getText(), capacidade.getText(), valorBaixa.getText(), valorAlta.getText());
                    JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
                } catch (NumberFormatException forMat) {
                    JOptionPane.showMessageDialog(null, "Tenha certeza que nao tem nenhum coluna em branco");
                }
			}
		});
		btnNewButton.setBounds(358, 329, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
	public void checkCadastroChale(String localizacao, String descricao, String capacidade, String valorAltaEstacao, String valorBaixaEstacao) {
        //event
        Integer capac = Integer.parseInt(capacidade);
        Double valorAlta = Double.parseDouble(valorAltaEstacao);
        Double valorBaixa = Double.parseDouble(valorBaixaEstacao); 
        ConexaoSql novaConexao = new ConexaoSql("chaledb", "root", "chale123");
        novaConexao.conectaSql("INSERT INTO chale (localizacao, description, capacidade, valorAltaEstacao, valorBaixaEstacao) VALUES ('"+ localizacao + "','" + descricao + "',"+ capac + ","+ valorAlta + ","+ valorBaixa +")");
    }

}
