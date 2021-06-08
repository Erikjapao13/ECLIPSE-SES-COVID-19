package Interface.Administrador;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import Modelo.Pessoa;
import Modelo.PessoaDAO;

@SuppressWarnings("serial")
public class TelaPessoas extends JFrame {

	private JPanel telaPanel;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JTextField txtEndereco;
	private JLabel profissão;
	private JComboBox CaixaSelecProfissao;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPessoas frame = new TelaPessoas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaPessoas() {
		setResizable(false);
		setTitle("SES COVID-19");
		setAutoRequestFocus(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1010, 633);
		telaPanel = new JPanel();
		telaPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaPanel.setLayout(null);
		setContentPane(telaPanel);

		JPanel barraMenuPanel = new JPanel();
		barraMenuPanel.setBounds(0, 0, 1000, 89);
		barraMenuPanel.setLayout(null);
		telaPanel.add(barraMenuPanel);

		JLabel logoSESCOVID = new JLabel("");
		logoSESCOVID.setBounds(388, 11, 60, 66);
		logoSESCOVID.setLabelFor(logoSESCOVID);
		logoSESCOVID.setIcon(
				new ImageIcon(TelaPessoas.class.getResource("/Interface/Imagens/BarraDeMenu/logoSESCOVID.png")));
		barraMenuPanel.add(logoSESCOVID);

		JLabel SES = new JLabel("SES");
		SES.setBounds(452, 6, 70, 40);
		SES.setForeground(Color.WHITE);
		SES.setFont(new Font("Faustina", Font.PLAIN, 38));
		barraMenuPanel.add(SES);

		JLabel COVID = new JLabel("COVID-19");
		COVID.setBounds(452, 38, 160, 40);
		COVID.setForeground(Color.WHITE);
		COVID.setFont(new Font("Faustina", Font.PLAIN, 38));
		SES.setForeground(Color.WHITE);
		SES.setFont(new Font("Faustina", Font.PLAIN, 38));
		barraMenuPanel.add(COVID);

		JLabel btnVoltar = new JLabel("");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HomeAdministrador ha = new HomeAdministrador();
				ha.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setToolTipText("Voltar");
		btnVoltar.setIcon(new ImageIcon(TelaPessoas.class.getResource("/Interface/Imagens/BarraDeMenu/iconeSair.png")));
		btnVoltar.setBounds(910, 28, 60, 36);
		barraMenuPanel.add(btnVoltar);

		JLabel barraMenu = new JLabel("");
		barraMenu.setBounds(0, 0, 1000, 89);
		barraMenu.setIcon(new ImageIcon(TelaPessoas.class.getResource("/Interface/Imagens/BarraDeMenu/barraMenu.png")));
		barraMenuPanel.add(barraMenu);

		JPanel corpoPanel = new JPanel();
		corpoPanel.setBounds(0, 89, 1000, 510);
		corpoPanel.setBackground(Color.WHITE);
		telaPanel.add(corpoPanel);
		corpoPanel.setLayout(null);

		JLabel pessoas = new JLabel("Pessoas");
		pessoas.setBounds(338, 60, 324, 46);
		pessoas.setHorizontalAlignment(SwingConstants.CENTER);
		pessoas.setFont(new Font("Inter SemiBold", Font.BOLD, 30));
		corpoPanel.add(pessoas);

		JLabel linha = new JLabel("");
		linha.setBounds(165, 110, 641, 1);
		linha.setIcon(
				new ImageIcon(TelaPessoas.class.getResource("/Interface/Imagens/CadastrarRemover/linhaTitulo.png")));
		corpoPanel.add(linha);

		JLabel nome = new JLabel("Nome");
		nome.setBounds(198, 140, 71, 26);
		nome.setForeground(Color.BLACK);
		nome.setFont(new Font("Inter Medium", Font.PLAIN, 20));
		corpoPanel.add(nome);

		JLabel caixaDeTextoNome = new JLabel("");
		caixaDeTextoNome.setBounds(192, 180, 265, 53);
		caixaDeTextoNome.setIcon(
				new ImageIcon(TelaPessoas.class.getResource("/Interface/Imagens/CadastrarRemover/caixaDeTexto.png")));
		corpoPanel.add(caixaDeTextoNome);

		txtNome = new JTextField();
		txtNome.setBounds(200, 183, 248, 39);
		txtNome.setForeground(Color.BLACK);
		txtNome.setBorder(null);
		txtNome.setFont(new Font("Amazon Ember", Font.PLAIN, 20));
		txtNome.setColumns(10);
		corpoPanel.add(txtNome);

		JLabel idade = new JLabel("Idade");
		idade.setBounds(534, 140, 84, 26);
		idade.setForeground(Color.BLACK);
		idade.setFont(new Font("Inter Medium", Font.PLAIN, 20));
		corpoPanel.add(idade);

		JLabel caixaDeTextoIdade = new JLabel("");
		caixaDeTextoIdade.setBounds(531, 180, 265, 53);
		caixaDeTextoIdade.setIcon(
				new ImageIcon(TelaPessoas.class.getResource("/Interface/Imagens/CadastrarRemover/caixaDeTexto.png")));
		corpoPanel.add(caixaDeTextoIdade);

		txtIdade = new JTextField();
		txtIdade.setBounds(540, 183, 248, 39);
		txtIdade.setForeground(Color.BLACK);
		txtIdade.setFont(new Font("Amazon Ember", Font.PLAIN, 20));
		txtIdade.setColumns(10);
		txtIdade.setBorder(null);
		corpoPanel.add(txtIdade);

		JLabel endereco = new JLabel("Endereço");
		endereco.setBounds(198, 260, 104, 26);
		endereco.setForeground(Color.BLACK);
		endereco.setFont(new Font("Inter Medium", Font.PLAIN, 20));
		corpoPanel.add(endereco);

		JLabel caixaDeTextoEndereco = new JLabel("");
		caixaDeTextoEndereco.setBounds(195, 300, 265, 53);
		caixaDeTextoEndereco.setIcon(
				new ImageIcon(TelaPessoas.class.getResource("/Interface/Imagens/CadastrarRemover/caixaDeTexto.png")));
		corpoPanel.add(caixaDeTextoEndereco);

		txtEndereco = new JTextField();
		txtEndereco.setBounds(204, 305, 248, 39);
		txtEndereco.setForeground(Color.BLACK);
		txtEndereco.setFont(new Font("Amazon Ember", Font.PLAIN, 20));
		txtEndereco.setColumns(10);
		txtEndereco.setBorder(null);
		corpoPanel.add(txtEndereco);

		profissão = new JLabel("Profissão está na área da saúde?");
		profissão.setBounds(534, 260, 256, 26);
		profissão.setForeground(Color.BLACK);
		profissão.setFont(new Font("Inter Medium", Font.PLAIN, 16));
		corpoPanel.add(profissão);

		CaixaSelecProfissao = new JComboBox();
		CaixaSelecProfissao.setBounds(531, 300, 261, 45);
		CaixaSelecProfissao.setBorder(new CompoundBorder());
		CaixaSelecProfissao.setFont(new Font("Amazon Ember", Font.PLAIN, 20));
		CaixaSelecProfissao.setBackground(Color.WHITE);
		CaixaSelecProfissao.setToolTipText("");
		CaixaSelecProfissao.setModel(new DefaultComboBoxModel(new String[] { "", "Sim", "Não" }));
		corpoPanel.add(CaixaSelecProfissao);

		JLabel btnCadastrar = new JLabel("");
		JLabel btnCadastrarPressionado = new JLabel("");
		btnCadastrar.setBounds(356, 390, 287, 66);
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnCadastrar.setVisible(false);
				btnCadastrarPressionado.setVisible(true);
				btnCadastrarActionPerformed();
				if (e != null) {
					btnCadastrar.setVisible(true);
					btnCadastrarPressionado.setVisible(false);
				}
			}
		});
		btnCadastrar.setHorizontalAlignment(SwingConstants.CENTER);
		btnCadastrar.setIcon(
				new ImageIcon(TelaPessoas.class.getResource("/Interface/Imagens/CadastrarRemover/iconeCadastrar.png")));
		corpoPanel.add(btnCadastrar);

		btnCadastrarPressionado.setVisible(false);
		btnCadastrarPressionado.setHorizontalAlignment(SwingConstants.CENTER);
		btnCadastrarPressionado.setIcon(new ImageIcon(
				TelaPessoas.class.getResource("/Interface/Imagens/CadastrarRemover/iconeCadastrarPressionado.png")));
		btnCadastrarPressionado.setBounds(356, 390, 287, 66);
		corpoPanel.add(btnCadastrarPressionado);

		JLabel telaPessoas = new JLabel("");
		telaPessoas.setIcon(
				new ImageIcon(TelaPessoas.class.getResource("/Interface/Imagens/Administrador/telaPessoas.png")));
		telaPessoas.setBounds(0, 0, 1000, 510);
		corpoPanel.add(telaPessoas);

		setIcon();
		setLocationRelativeTo(null);
	}

	// MÉTODO PARA CADASTRAR PESSOAS
	private void btnCadastrarActionPerformed() {
		if (txtIdade.getText().equals("")) {
			txtIdade.setText("0");
		}

		String name = txtNome.getText();
		Integer age = Integer.parseInt(txtIdade.getText());
		String adress = txtEndereco.getText();
		boolean saude;

		// TESTANDO SE TEM ALGUM CAMPO VAZIO
		if (name.equals("") || adress.equals("") || age == 0) {
			JOptionPane.showMessageDialog(null, "Favor preencher todos os campos.", "Campo vazio",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			// TESTANDO SE O CAMPO DE SELEÇÃO FOI USADO CORRETAMENTE
			if (CaixaSelecProfissao.getSelectedItem().equals("")) {
				JOptionPane.showMessageDialog(null, "Favor selecionar se a pessoa é da área da saúde.", "Seleção",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				if (CaixaSelecProfissao.getSelectedItem().equals("Sim")) {
					saude = true;
				} else {
					saude = false;
				}
				Pessoa nova = new Pessoa(name, age, adress, saude);
				PessoaDAO cria = new PessoaDAO();
				cria.createPessoa(nova);
			}
		}
		txtNome.setText("");
		txtIdade.setText("");
		txtEndereco.setText("");
		CaixaSelecProfissao.setSelectedItem("");
	}

	private void setIcon() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(TelaPessoas.class.getResource("/Interface/Imagens/BarraDeMenu/iconeSESCOVID.png")));
	}
}
