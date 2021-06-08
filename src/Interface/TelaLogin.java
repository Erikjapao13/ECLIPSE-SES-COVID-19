package Interface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BancoDeDados.FabricaConexao;
import Interface.Administrador.HomeAdministrador;
import Interface.Atendente.TelaFila;
import Modelo.Usuario;
import Modelo.UsuarioDAO;

@SuppressWarnings("serial")
public class TelaLogin extends JFrame {

	private JPanel telaPanel;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	private JLabel iconeOcultar;
	private JLabel iconeMostrar;
	private JLabel btnEntrar;
	private JLabel btnEntrarPressionado;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaLogin() {
		setResizable(false);
		setTitle("SES COVID-19");
		setAutoRequestFocus(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		telaPanel = new JPanel();
		telaPanel.setBackground(Color.WHITE);
		telaPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaPanel.setLayout(null);
		setContentPane(telaPanel);

		JPanel loginPanel = new JPanel();
		loginPanel.setBorder(null);
		loginPanel.setBackground(Color.WHITE);
		loginPanel.setBounds(580, 0, 413, 571);
		loginPanel.setLayout(null);
		telaPanel.add(loginPanel);
		
		JLabel BEMVINDO = new JLabel("BEM-VINDO!");
		BEMVINDO.setFont(new Font("Faustina", Font.BOLD, 50));
		BEMVINDO.setBounds(34, 80, 292, 54);
		loginPanel.add(BEMVINDO);

		JLabel linhaBemVindo = new JLabel("");
		linhaBemVindo.setIcon(new ImageIcon(TelaLogin.class.getResource("/Interface/Imagens/TelaLogin/linhaBemVindo.png")));
		linhaBemVindo.setBounds(13, 145, 342, 1);
		loginPanel.add(linhaBemVindo);

		JLabel usuario = new JLabel("Usuário");
		usuario.setFont(new Font("Inter Medium", Font.PLAIN, 30));
		usuario.setBounds(50, 179, 120, 33);
		loginPanel.add(usuario);

		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Amazon Ember", Font.PLAIN, 22));
		txtUsuario.setBorder(null);
		txtUsuario.setBounds(52, 211, 257, 45);
		txtUsuario.setColumns(10);
		loginPanel.add(txtUsuario);

		JLabel linhaUsuario = new JLabel("");
		linhaUsuario.setIcon(new ImageIcon(TelaLogin.class.getResource("/Interface/Imagens/TelaLogin/linhaTexto.png")));
		linhaUsuario.setBounds(52, 256, 258, 1);
		loginPanel.add(linhaUsuario);

		JLabel senha = new JLabel("Senha");
		senha.setFont(new Font("Inter Medium", Font.PLAIN, 30));
		senha.setBounds(50, 291, 100, 40);
		loginPanel.add(senha);

		txtSenha = new JPasswordField();
		txtSenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				btnEntrar.setEnabled(true);
				btnEntrarPressionado.setEnabled(true);
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnEntrar.setVisible(false);
					btnEntrarPressionado.setVisible(true);
					btnEntrarActionPerformed();
					if(e != null) {
						btnEntrar.setVisible(true);
						btnEntrarPressionado.setVisible(false);
					}
				}
			}
		});
		txtSenha.setBorder(null);
		txtSenha.setFont(new Font("Amazon Ember", Font.PLAIN, 22));
		txtSenha.setBounds(52, 322, 233, 45);
		loginPanel.add(txtSenha);

		iconeOcultar = new JLabel("New label");
		iconeOcultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				iconeOcultar.setVisible(false);
				iconeMostrar.setVisible(true);
				txtSenha.setEchoChar('\u0000');
			}
		});
		iconeOcultar.setBounds(280, 333, 35, 22);
		iconeOcultar.setIcon(new ImageIcon(TelaLogin.class.getResource("/Interface/Imagens/TelaLogin/iconeOcultar.png")));
		loginPanel.add(iconeOcultar);
		
		iconeMostrar = new JLabel("New label");
		iconeMostrar.setBounds(280, 333, 35, 22);
		iconeMostrar.setVisible(false);
		iconeMostrar.setIcon(new ImageIcon(TelaLogin.class.getResource("/Interface/Imagens/TelaLogin/iconeMostrar.png")));
		iconeMostrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				iconeOcultar.setVisible(true);
				iconeMostrar.setVisible(false);
				txtSenha.setEchoChar('\u2022');
			}
		});
		loginPanel.add(iconeMostrar);

		JLabel linhaSenha = new JLabel("");
		linhaSenha.setIcon(new ImageIcon(TelaLogin.class.getResource("/Interface/Imagens/TelaLogin/linhaTexto.png")));
		linhaSenha.setBounds(52, 367, 258, 1);
		loginPanel.add(linhaSenha);

		btnEntrar = new JLabel("");
		btnEntrar.setEnabled(false);
		btnEntrar.setIcon(new ImageIcon(TelaLogin.class.getResource("/Interface/Imagens/TelaLogin/iconeEntrar.png")));
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnEntrar.setVisible(false);
				btnEntrarPressionado.setVisible(true);
				btnEntrarActionPerformed();
				if(e != null) {
					btnEntrar.setVisible(true);
					btnEntrarPressionado.setVisible(false);
				}
			}
		});
		
		btnEntrar.setBounds(53, 401, 267, 64);
		loginPanel.add(btnEntrar);
		
		btnEntrarPressionado = new JLabel("");
		btnEntrarPressionado.setEnabled(false);
		btnEntrarPressionado.setVisible(false);
		btnEntrarPressionado.setIcon(new ImageIcon(TelaLogin.class.getResource("/Interface/Imagens/TelaLogin/iconeEntrarPressionado.png")));
		btnEntrarPressionado.setBounds(53, 401, 267, 64);
		loginPanel.add(btnEntrarPressionado);

		JLabel iconeGrandeSESCOVID = new JLabel("");
		iconeGrandeSESCOVID.setIcon(new ImageIcon(TelaLogin.class.getResource("/Interface/Imagens/TelaLogin/iconeGrandeSESCOVID.png")));
		iconeGrandeSESCOVID.setBounds(36, 159, 200, 200);
		telaPanel.add(iconeGrandeSESCOVID);

		JLabel SES = new JLabel("SES");
		SES.setFont(new Font("Faustina", Font.PLAIN, 80));
		SES.setBounds(230, 180, 131, 70);
		telaPanel.add(SES);

		JLabel COVID = new JLabel("COVID-19");
		COVID.setFont(new Font("Faustina", Font.PLAIN, 80));
		COVID.setBounds(230, 250, 340, 80);
		telaPanel.add(COVID);

		setIcon();
		setLocationRelativeTo(null);

	}

	// MÉTODO DE VALIDAÇÃO DO USUÁRIO
	private void btnEntrarActionPerformed() {
		String usuario = txtUsuario.getText();
		String senha = new String(txtSenha.getPassword());

		Usuario login = new Usuario(usuario, senha);
		UsuarioDAO valida = new UsuarioDAO();
		login.setUsuario(usuario);
		login.setSenha(senha);

		if (usuario.equals("") || senha.equals("")) {
			JOptionPane.showMessageDialog(null, "Digite o seu usuário e senha", "Campo Vazio",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			if (valida.loginUsuario(login) == true) {
				if (login.getCargo().equals("ADM")) {
					HomeAdministrador telaAdm = new HomeAdministrador();
					telaAdm.setVisible(true);
					dispose();
				} else {
					TelaFila telaAtendente = new TelaFila();
					telaAtendente.setVisible(true);
					dispose();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválidos!", "Tente novamente.",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	// MÉTODO PARA MOSTRAR ÍCONE NO JFRAME:
	private void setIcon() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(TelaLogin.class.getResource("/Interface/Imagens/BarraDeMenu/iconeSESCOVID.png")));
	}
}
