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

public class CadastroHospedagem extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField codHosp;
	private JTextField codChale;
	private JTextField estado;
	private JTextField dataInicio;
	private JTextField dataFim;
	private JTextField qtdePessoas;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1_6;
	private JTextField idCliente;
	private JLabel desconto;
	private JLabel valorFinal;
	private JTextField textField;
	private JTextField textField_1;

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
					CadastroHospedagem window = new CadastroHospedagem();
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
	public CadastroHospedagem() {
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
		
		JLabel lblNewLabel = new JLabel("Cadastro Hospedagem");
		lblNewLabel.setBounds(190, 11, 118, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cod Hospedagem");
		lblNewLabel_1.setBounds(10, 62, 97, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cod Chale");
		lblNewLabel_1_1.setBounds(10, 103, 65, 21);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("estado");
		lblNewLabel_1_2.setBounds(10, 135, 65, 21);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Data inicio");
		lblNewLabel_1_3.setBounds(10, 173, 65, 21);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Data fim");
		lblNewLabel_1_4.setBounds(10, 216, 86, 21);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Qtde Pessoas");
		lblNewLabel_1_5.setBounds(10, 259, 97, 21);
		frame.getContentPane().add(lblNewLabel_1_5);
		
		codHosp = new JTextField();
		codHosp.setBounds(117, 62, 86, 20);
		frame.getContentPane().add(codHosp);
		codHosp.setColumns(10);
		
		codChale = new JTextField();
		codChale.setColumns(10);
		codChale.setBounds(117, 103, 86, 20);
		frame.getContentPane().add(codChale);
		
		estado = new JTextField();
		estado.setColumns(10);
		estado.setBounds(117, 135, 86, 20);
		frame.getContentPane().add(estado);
		
		dataInicio = new JTextField();
		dataInicio.setColumns(10);
		dataInicio.setBounds(117, 173, 86, 20);
		frame.getContentPane().add(dataInicio);
		
		dataFim = new JTextField();
		dataFim.setColumns(10);
		dataFim.setBounds(117, 216, 86, 20);
		frame.getContentPane().add(dataFim);
		
		qtdePessoas = new JTextField();
		qtdePessoas.setColumns(10);
		qtdePessoas.setBounds(117, 259, 86, 20);
		frame.getContentPane().add(qtdePessoas);
		
		
		
		lblNewLabel_1_6 = new JLabel("Id Cliente");
		lblNewLabel_1_6.setBounds(10, 304, 97, 21);
		frame.getContentPane().add(lblNewLabel_1_6);
		
		idCliente = new JTextField();
		idCliente.setColumns(10);
		idCliente.setBounds(117, 304, 86, 20);
		frame.getContentPane().add(idCliente);
		
		desconto = new JLabel("Desconto");
		desconto.setBounds(242, 65, 65, 21);
		frame.getContentPane().add(desconto);
		
		valorFinal = new JLabel("Valor Final");
		valorFinal.setBounds(242, 106, 65, 21);
		frame.getContentPane().add(valorFinal);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(338, 62, 86, 20);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(338, 103, 86, 20);
		frame.getContentPane().add(textField_1);
		
		btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    checkCadastroHospedagem(codChale.getText(),idCliente.getText(), dataInicio.getText(), dataFim.getText(), qtdePessoas.getText(), desconto.getText(), valorFinal.getText());
                    JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
                } catch (NumberFormatException forMat) {
                    JOptionPane.showMessageDialog(null, "Tenha certeza que nao tem nenhum coluna em branco");
                }
			}
		});
		btnNewButton.setBounds(357, 330, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
	public void checkCadastroHospedagem(String codChale, String idCliente, String dataInicio, String dataFim, String qtdePessoas, String desconto, String valorFinal) {
        Double desc = Double.parseDouble(desconto);
        Double valorF = Double.parseDouble(valorFinal);
        Integer qntP = Integer.parseInt(qtdePessoas);
        Integer codC = Integer.parseInt(codChale);
        Integer idC = Integer.parseInt(idCliente);
        ConexaoSql novaConexao = new ConexaoSql("chaledb", "root", "chale123");
        novaConexao.conectaSql("INSERT INTO hospedagem (codChale, idClient, dataInicio, dataFim, qtdPessoas, desconto, valorFinal) VALUES ("+ codC + "," + idC + ",'"+ dataInicio + "','"+ dataFim + "',"+ qntP +","+ desc +","+ valorF +")");
    }
}
