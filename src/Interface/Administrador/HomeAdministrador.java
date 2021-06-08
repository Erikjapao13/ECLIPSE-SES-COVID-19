package Interface.Administrador;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Interface.TelaLogin;

@SuppressWarnings("serial")
public class HomeAdministrador extends JFrame {

	private JPanel telaPanel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeAdministrador frame = new HomeAdministrador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HomeAdministrador() {
		setResizable(false);
		setTitle("SES COVID-19");
		setAutoRequestFocus(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		telaPanel = new JPanel();
		telaPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaPanel.setLayout(null);
		setContentPane(telaPanel);
		
		JPanel barraMenuPanel = new JPanel();
		barraMenuPanel.setBounds(0, 0, 1004, 89);
		barraMenuPanel.setLayout(null);
		telaPanel.add(barraMenuPanel);
		
		JLabel btnSair = new JLabel("");
		btnSair.setToolTipText("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaLogin th = new TelaLogin();
				th.setVisible(true);
				dispose();
			}
		});
		
		JLabel logo = new JLabel("");
		logo.setBounds(388, 11, 60, 66);
		logo.setLabelFor(logo);
		logo.setIcon(new ImageIcon(HomeAdministrador.class.getResource("/Interface/Imagens/BarraDeMenu/logoSESCOVID.png")));
		barraMenuPanel.add(logo);
		
		JLabel SES = new JLabel("SES");
		SES.setBounds(452, 8, 70, 40);
		SES.setForeground(Color.WHITE);
		SES.setFont(new Font("Faustina", Font.PLAIN, 38));
		barraMenuPanel.add(SES);
		SES.setForeground(Color.WHITE);
		SES.setFont(new Font("Faustina", Font.PLAIN, 38));
		
		JLabel COVID = new JLabel("COVID-19");
		COVID.setBounds(452, 38, 160, 40);
		COVID.setForeground(Color.WHITE);
		COVID.setFont(new Font("Faustina", Font.PLAIN, 38));
		barraMenuPanel.add(COVID);
		btnSair.setIcon(new ImageIcon(HomeAdministrador.class.getResource("/Interface/Imagens/Atendente/iconeSair.png")));
		btnSair.setBounds(910, 28, 60, 36);
		barraMenuPanel.add(btnSair);
		
		JLabel barraMenu = new JLabel("");
		barraMenu.setBounds(0, 0, 1000, 89);
		barraMenuPanel.add(barraMenu);
		barraMenu.setIcon(new ImageIcon(HomeAdministrador.class.getResource("/Interface/Imagens/BarraDeMenu/barraMenu.png")));
		
		JPanel corpoPanel = new JPanel();
		corpoPanel.setBounds(0, 89, 1004, 511);
		corpoPanel.setBackground(Color.WHITE);
		telaPanel.add(corpoPanel);
		corpoPanel.setLayout(null);
		
		JLabel btnAdmin = new JLabel("");
		btnAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaAdministrador telaAdmin = new TelaAdministrador();
				telaAdmin.setVisible(true);
				dispose();
			}
		});
		btnAdmin.setIcon(new ImageIcon(HomeAdministrador.class.getResource("/Interface/Imagens/Administrador/iconeAdmin.png")));
		btnAdmin.setBounds(34, 50, 445, 165);
		corpoPanel.add(btnAdmin);
		
		JLabel btnPessoas = new JLabel("");
		btnPessoas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaPessoas cadPessoas = new TelaPessoas();
				cadPessoas.setVisible(true);
				dispose();
			}
		});
		
		JLabel btnAtendente = new JLabel("");
		btnAtendente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaAtendente telacadaten = new TelaAtendente();
				telacadaten.setVisible(true);
				dispose();
			}
		});
		
		btnAtendente.setIcon(new ImageIcon(HomeAdministrador.class.getResource("/Interface/Imagens/Administrador/iconeAtendente.png")));
		btnAtendente.setBounds(531, 50, 445, 165);
		corpoPanel.add(btnAtendente);
		btnPessoas.setIcon(new ImageIcon(HomeAdministrador.class.getResource("/Interface/Imagens/Administrador/iconePessoas.png")));
		btnPessoas.setBounds(34, 250, 445, 176);
		corpoPanel.add(btnPessoas);
		
		JLabel btnVacinacao = new JLabel("");
		btnVacinacao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaGerarRelatorio tgr = new TelaGerarRelatorio();
				tgr.setVisible(true);
				dispose();
			}
		});
		btnVacinacao.setIcon(new ImageIcon(HomeAdministrador.class.getResource("/Interface/Imagens/Administrador/iconeVacinação.png")));
		btnVacinacao.setBounds(531, 250, 445, 176);
		corpoPanel.add(btnVacinacao);
		
		setIcon();
		setLocationRelativeTo(null);
	}
	
	private void setIcon() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(HomeAdministrador.class.getResource(
						"/Interface/Imagens/BarraDeMenu/iconeSESCOVID.png")));
	}
}
