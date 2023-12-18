package desktopApp.view.telasDesktop;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import desktopApp.core.controler.EstadiaControler;
import desktopApp.core.entity.CriancaEntity;
import desktopApp.core.entity.EstadiaEntity;
import desktopApp.core.entity.ResponsavelEntity;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaEstadia extends JFrame {

	private static final long serialVersionUID = 3L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public TelaEstadia(ResponsavelEntity responsavel, CriancaEntity crianca) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTituloTela = new JLabel("Etapa 3 de 3 - Dados da Estadia");
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
		
		JLabel lblTempo = new JLabel("Tempo (min):");
		lblTempo.setBounds(10, 110, 120, 17);
		lblTempo.setFont(new Font("Arial", Font.BOLD, 14));
		contentPane.add(lblTempo);
		
		
		JTextField txtResponsavel = new JTextField();
		txtResponsavel.setColumns(10);
		txtResponsavel.setBounds(169, 50, 263, 20);
		txtResponsavel.setText(responsavel.getNome());
		txtResponsavel.setEditable(false);
		contentPane.add(txtResponsavel);
		
		JTextField txtCrianca = new JTextField();
		txtCrianca.setColumns(10);
		txtCrianca.setBounds(169, 80, 263, 20);
		txtCrianca.setText(crianca.getNome());
		txtCrianca.setEditable(false);
		contentPane.add(txtCrianca);
		
		JTextField txtTempo= new JTextField();
		txtTempo.setColumns(10);
		txtTempo.setBounds(169, 110, 263, 20);
		contentPane.add(txtTempo);
		
		JButton btnAvanc = new JButton("Calcular e Mostrar Resumo");
		btnAvanc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAvanc.setBounds(169, 130, 263, 20);
		btnAvanc.setForeground(Color.BLACK);
		btnAvanc.setFont(new Font("Arial", Font.PLAIN, 11));
		btnAvanc.setBackground(UIManager.getColor("Button.background"));
		// Evento para o botão avançar
		btnAvanc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Instancia e preenche um objeto EstadiaEntity
				EstadiaEntity estadia = new EstadiaEntity();
				estadia.setResponsavel(responsavel);
				estadia.setCrianca(crianca);
				estadia.setTempo(Integer.parseInt(txtTempo.getText()));
				
				// Intancia o controler
				EstadiaControler estadiaControler = new EstadiaControler();
				estadiaControler.cadastrarEstadia(estadia);

				apresentarResumo(estadia);
				

			}
		});
		contentPane.add(btnAvanc);
		
	}
	
	public void apresentarResumo(EstadiaEntity estadia) {
		String menssagem = "Dados da Estadia\n";
		String[] listaCampos = {
				"Data do Registro: %s",
				"Nome Responsável: %s",
				"CPF Responsável: %s",
				"Telefone Responsável: %s",
				"Email Responsável: %s",
				"Endereço Responsável: %s",
				"Idade Responsável: %d",
				"Nome Criança: %s",
				"Idade Criança: %d",
				"Sexo Criança: %s",
				"Tempo no Brinquedo: %d",
				"Valor a pagar: %f",
		};
		
		for (int i=0; i<listaCampos.length; i++) {
			menssagem += listaCampos[i] + "\n";
		}
		
		JOptionPane.showInternalMessageDialog(null, String.format(menssagem, 
				estadia.getDataString(),
				estadia.getResponsavel().getNome(),
				estadia.getResponsavel().getCPF(),
				estadia.getResponsavel().getTelefone(),
				estadia.getResponsavel().getEmail(),
				estadia.getResponsavel().getEndereco(),
				estadia.getResponsavel().getIdade(),
				estadia.getCrianca().getNome(),
				estadia.getCrianca().getIdade(),
				estadia.getCrianca().getSexo(),
				estadia.getTempo(),
				estadia.getValor()
				));
	}
}
