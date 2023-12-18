package desktopApp.view.telasDesktop;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import desktopApp.core.controler.ResponsavelControler;
import desktopApp.core.entity.ResponsavelEntity;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaResponsavel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public TelaResponsavel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTituloTela = new JLabel("Etapa 1 de 3 - Dados do Responsável");
		lblTituloTela.setBounds(10, 10, 263, 18);
		contentPane.add(lblTituloTela);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(11, 50, 65, 17);
		contentPane.add(lblNome);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(11, 80, 65, 17);
		contentPane.add(lblCPF);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(11, 110, 78, 17);
		contentPane.add(lblTelefone);
		
		JLabel lblEmail= new JLabel("Email:");
		lblEmail.setBounds(10, 140, 66, 17);
		contentPane.add(lblEmail);
		
		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setBounds(10, 170, 79, 17);
		contentPane.add(lblEndereco);
		
		JLabel lblIDataNascimento = new JLabel("Data de Nascimento:");
		lblIDataNascimento.setBounds(10, 200, 160, 17);
		contentPane.add(lblIDataNascimento);
		
		JTextField txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(169, 50, 263, 20);
		//txtNome.setText("David");
		//txtNome.setEditable(false);
		contentPane.add(txtNome);
		
		JTextField txtCPF = new JTextField();
		txtCPF.setColumns(10);
		txtCPF.setBounds(169, 80, 263, 20);
		//txtCPF.setText("88484848");
		//txtCPF.setEditable(false);
		contentPane.add(txtCPF);
		
		JTextField txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(169, 110, 263, 20);
		//txtTelefone.setEditable(false);
		//txtTelefone.setText("484841514");
		contentPane.add(txtTelefone);
		
		JTextField txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(169, 140, 263, 20);
		//txtEmail.setText("david@gmail.com");
		//txtEmail.setEditable(false);
		contentPane.add(txtEmail);
		
		JTextField txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(169, 170, 263, 20);
		//txtEndereco.setText("Trav CARLA");
		//txtEndereco.setEditable(false);
		contentPane.add(txtEndereco);
		
		JTextField txtDataNascimento = new JTextField();
		txtDataNascimento.setColumns(10);
		txtDataNascimento.setBounds(169, 200, 263, 20);
		//txtDataNascimento.setText("2002-02-26");
		//txtDataNascimento.setEditable(false);
		contentPane.add(txtDataNascimento);
		
		JButton btnAvanc = new JButton("Avançar");
		btnAvanc.setBounds(344, 230, 88, 23);
		btnAvanc.setBackground(UIManager.getColor("Button.background"));
		// Evento para o botão avançar
		btnAvanc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Instancia e preenche um objeto ResponsavelEntity
				ResponsavelEntity responsavel = new ResponsavelEntity();
				responsavel.setNome(txtNome.getText());
				responsavel.setCPF(txtCPF.getText());
				responsavel.setTelefone(txtTelefone.getText());
				responsavel.setEndereco(txtEndereco.getText());
				responsavel.setEmail(txtEmail.getText());
				responsavel.setDataNascimento(txtDataNascimento.getText(), "dd/MM/yyyy");
				
				// Intancia o controler
				ResponsavelControler responsavelControler = new ResponsavelControler();
				// Tenta cadastrar, retorna uma exceção cado não consiga
				Exception respMenorDeIdade = responsavelControler.cadastrarResponsavel(responsavel);
				// Mensagem de sucesso
				String menssagem = String.format("Responsável %s cadastrado com SUCESSO!!", responsavel.getNome());
				// Verifica se foi retornada uma exceção
				if (respMenorDeIdade != null) {
					menssagem = respMenorDeIdade.getMessage();
					JOptionPane.showMessageDialog(btnAvanc, menssagem, "ERRO!", 2);
				}
				// Se não, avança para a proxima tela
				else {
					// Instancia a telaEstadia
					TelaCrianca telaCrianca = new TelaCrianca(responsavel);
					telaCrianca.setVisible(true);
					// Fecha a tela atual
					dispose();
					JOptionPane.showMessageDialog(btnAvanc, menssagem);
				}

			}
		});
		contentPane.add(btnAvanc);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(169, 230, 88, 23);
		btnListar.setBackground(UIManager.getColor("Button.background"));
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResponsavelControler respon = new ResponsavelControler();
				ArrayList<ResponsavelEntity> responsaveis;
				responsaveis = respon.listarResponsavel();
				
				for (int i=0; i<responsaveis.size(); i++) {
					System.out.println(responsaveis.get(i).getNome());
				}

			}
		});
		contentPane.add(btnListar);
	}
}
