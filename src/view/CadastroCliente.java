package view;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import persistence.ConexaoSql;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroCliente extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField nomeCli;
	private JTextField CPF;
	private JTextField RG;
	private JTextField endereco;
	private JTextField numCli;
	private JTextField estado;
	private JTextField cidade;
	private JTextField dataNasc;
	private JButton CadastrarCli;
	private JPanel contentPane;

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
					CadastroCliente window = new CadastroCliente();
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
	public CadastroCliente() {
		frame = new JFrame();
		frame.setBounds(100, 100, 486, 402);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CADASTRO CLIENTE");
		lblNewLabel.setBounds(187, 0, 132, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(10, 45, 69, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("CPF");
		lblNewLabel_1_1.setBounds(10, 74, 69, 21);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("RG");
		lblNewLabel_1_2.setBounds(10, 111, 69, 21);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Endereço");
		lblNewLabel_1_3.setBounds(10, 148, 69, 21);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Num. Cliente");
		lblNewLabel_1_4.setBounds(10, 188, 69, 21);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Cidade");
		lblNewLabel_1_5.setBounds(10, 278, 88, 21);
		frame.getContentPane().add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Estado");
		lblNewLabel_1_6.setBounds(10, 233, 69, 21);
		frame.getContentPane().add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Data de Nascimento");
		lblNewLabel_1_7.setBounds(10, 317, 105, 21);
		frame.getContentPane().add(lblNewLabel_1_7);
		
		nomeCli = new JTextField();
		nomeCli.setBounds(67, 45, 86, 20);
		frame.getContentPane().add(nomeCli);
		nomeCli.setColumns(10);
		
		CPF = new JTextField();
		CPF.setBounds(67, 77, 86, 20);
		frame.getContentPane().add(CPF);
		CPF.setColumns(10);
		
		RG = new JTextField();
		RG.setBounds(67, 106, 86, 20);
		frame.getContentPane().add(RG);
		RG.setColumns(10);
		
		endereco = new JTextField();
		endereco.setBounds(67, 148, 86, 20);
		frame.getContentPane().add(endereco);
		endereco.setColumns(10);
		
		numCli = new JTextField();
		numCli.setBounds(89, 188, 86, 20);
		frame.getContentPane().add(numCli);
		numCli.setColumns(10);
		
		estado = new JTextField();
		estado.setBounds(67, 233, 86, 20);
		frame.getContentPane().add(estado);
		estado.setColumns(10);
		
		cidade = new JTextField();
		cidade.setBounds(67, 278, 86, 20);
		frame.getContentPane().add(cidade);
		cidade.setColumns(10);
		
		dataNasc = new JTextField();
		dataNasc.setBounds(125, 317, 86, 20);
		frame.getContentPane().add(dataNasc);
		dataNasc.setColumns(10);
		
		CadastrarCli = new JButton("Cadastrar");
		CadastrarCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    checkCadastroClient(nomeCli.getText(), CPF.getText(), RG.getText(), endereco.getText(), numCli.getText(), cidade.getText(), estado.getText() , dataNasc.getText());
                    JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
                } catch (NumberFormatException forMat) {
                    JOptionPane.showMessageDialog(null, "Nao foi cadastrado.");
                }
			}
		});
		CadastrarCli.setBounds(371, 329, 89, 23);
		frame.getContentPane().add(CadastrarCli);
		frame.setBounds(100, 100, 486, 402);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		frame.getContentPane().setLayout(null);
		
	}
	public void checkCadastroClient(String nomeCli, String CPF, String RG, String endereco, String numCli, String cidade, String estado, String dataNasc) {
        int num = Integer.parseInt(numCli);
        ConexaoSql novaConexao = new ConexaoSql("chale", "root", "chale123"); 
        novaConexao.conectaSql("INSERT INTO client_chale (nameClient, cpfClient, rgClient, endereco, numClient, cidade, estado, dataClient) VALUES ('"+ nomeCli + "','" + CPF + "','"+ RG + "','"+ endereco + "',"+ num + ",'"+ cidade + "','" + estado +"', " + dataNasc +")");
    }
}

