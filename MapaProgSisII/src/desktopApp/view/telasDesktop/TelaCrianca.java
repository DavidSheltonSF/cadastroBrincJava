package desktopApp.view.telasDesktop;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import desktopApp.core.controler.CriancaControler;
import desktopApp.core.entity.CriancaEntity;
import desktopApp.core.entity.ResponsavelEntity;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCrianca extends JFrame {

	private static final long serialVersionUID = 2L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public TelaCrianca(ResponsavelEntity responsavel) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTituloTela = new JLabel("Etapa 2 de 3 - Dados da Criança");
		lblTituloTela.setBounds(10, 10, 263, 18);
		lblTituloTela.setFont(new Font("Arial", Font.BOLD, 15));
		contentPane.add(lblTituloTela);
		
		JLabel lblResponsavel = new JLabel("Responsável:");
		lblResponsavel.setBounds(10, 50, 100, 17);
		lblResponsavel.setFont(new Font("Arial", Font.BOLD, 14));
		contentPane.add(lblResponsavel);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 80, 65, 17);
		lblNome.setFont(new Font("Arial", Font.BOLD, 14));
		contentPane.add(lblNome);
		
		JLabel lblDataNascimento = new JLabel("Data de Nascimento:");
		lblDataNascimento.setBounds(10, 110, 120, 17);
		lblDataNascimento.setFont(new Font("Arial", Font.BOLD, 14));
		contentPane.add(lblDataNascimento);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(10, 140, 78, 17);
		lblSexo.setFont(new Font("Arial", Font.BOLD, 14));
		contentPane.add(lblSexo);
		
		JTextField txtResponsavel = new JTextField();
		txtResponsavel.setColumns(10);
		txtResponsavel.setBounds(169, 50, 263, 20);
		txtResponsavel.setText(responsavel.getNome());
		txtResponsavel.setEditable(false);
		contentPane.add(txtResponsavel);
		
		JTextField txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(169, 80, 263, 20);
		//txtNome.setText("Carlos");
		//txtNome.setEditable(false);
		contentPane.add(txtNome);
		
		JTextField txtDataNascimento = new JTextField();
		txtDataNascimento.setColumns(10);
		txtDataNascimento.setBounds(169, 110, 263, 20);
		//txtDataNascimento.setText("26/02/2020");
		//txtDataNascimento.setEditable(false);
		contentPane.add(txtDataNascimento);
		
		JTextField txtSexo = new JTextField();
		txtSexo.setColumns(10);
		txtSexo.setBounds(169, 140, 263, 20);
		//txtSexo.setText("masculino");
		//txtSexo.setEditable(false);
		contentPane.add(txtSexo);
		
		JButton btnAvanc = new JButton("Avançar");
		btnAvanc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAvanc.setBounds(344, 230, 88, 23);
		btnAvanc.setForeground(Color.BLACK);
		btnAvanc.setFont(new Font("Arial", Font.PLAIN, 11));
		btnAvanc.setBackground(UIManager.getColor("Button.background"));
		// Evento para o botão avançar
		btnAvanc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Instancia e preenche um objeto CriancaEntity
				CriancaEntity crianca = new CriancaEntity();
				crianca.setResponsavel(responsavel);
				crianca.setNome(txtNome.getText());
				crianca.setDataNascimento(txtDataNascimento.getText(), "dd/MM/yyyy");
				crianca.setSexo(txtSexo.getText());
				
				// Intancia o controler
				CriancaControler criancaControler = new CriancaControler();
				// Tenta cadastrar, retorna uma exceção cado não consiga
				Exception criancaMuitoVelha = criancaControler.cadastrarCrianca(crianca);
				// Mensagem de sucesso
				String menssagem = String.format("Criança %s cadastrado com SUCESSO!!", crianca.getNome());
				// Verifica se foi retornada uma exceção
				if (criancaMuitoVelha != null) {
					menssagem = criancaMuitoVelha.getMessage();
					JOptionPane.showMessageDialog(btnAvanc, menssagem, "ERRO!", 2);
				}
				// Se não, avança para a proxima tela
				else {
					// Instancia a telaEstadia
					TelaEstadia telaEstadia = new TelaEstadia(responsavel, crianca);
					telaEstadia.setVisible(true);
					// Fecha a tela atual
					dispose();
					JOptionPane.showMessageDialog(btnAvanc, menssagem);
				}

			}
		});
		contentPane.add(btnAvanc);
		
	}
}
