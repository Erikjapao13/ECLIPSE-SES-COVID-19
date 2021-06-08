package Interface.Administrador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Modelo.Usuario;
import Modelo.UsuarioDAO;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class TelaAtendente extends JFrame {

	private JPanel telaPanel;
	private JTextField txtNome;
	private JTextField txtUsuario;
	private JTextField txtFone;
	private JTable table;
	private JTextField txtSenha;
	private JLabel btnCadastrar;
	private JLabel btnCadastrarPressionado;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtendente frame = new TelaAtendente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaAtendente() {
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
				new ImageIcon(TelaAtendente.class.getResource("/Interface/Imagens/BarraDeMenu/logoSESCOVID.png")));
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

		JLabel btnSair = new JLabel("");
		btnSair.setToolTipText("Voltar");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HomeAdministrador ha = new HomeAdministrador();
				ha.setVisible(true);
				dispose();
			}
		});
		btnSair.setIcon(new ImageIcon(TelaAtendente.class.getResource("/Interface/Imagens/BarraDeMenu/iconeSair.png")));
		btnSair.setBounds(910, 28, 60, 36);
		barraMenuPanel.add(btnSair);

		JLabel barraMenu = new JLabel("");
		barraMenu.setBounds(0, 0, 1000, 89);
		barraMenu.setIcon(
				new ImageIcon(TelaAtendente.class.getResource("/Interface/Imagens/BarraDeMenu/barraMenu.png")));
		barraMenuPanel.add(barraMenu);

		JPanel corpoPanel = new JPanel();
		corpoPanel.setBorder(null);
		corpoPanel.setBounds(0, 89, 1000, 511);
		corpoPanel.setBackground(Color.WHITE);
		corpoPanel.setLayout(null);
		telaPanel.add(corpoPanel);

		JPanel cadastrarPanel = new JPanel();
		cadastrarPanel.setForeground(new Color(0, 0, 0));
		cadastrarPanel.setBorder(null);
		cadastrarPanel.setBackground(Color.WHITE);
		cadastrarPanel.setBounds(30, 85, 940, 397);
		corpoPanel.add(cadastrarPanel);
		cadastrarPanel.setLayout(null);

		JLabel atendente = new JLabel("Atendente");
		atendente.setBounds(308, 10, 324, 46);
		atendente.setHorizontalAlignment(SwingConstants.CENTER);
		atendente.setFont(new Font("Inter", Font.BOLD, 25));
		cadastrarPanel.add(atendente);

		JLabel linhaTitulo = new JLabel("");
		linhaTitulo.setBounds(165, 60, 641, 1);
		linhaTitulo.setIcon(
				new ImageIcon(TelaAtendente.class.getResource("/Interface/Imagens/CadastrarRemover/linhaTitulo.png")));
		cadastrarPanel.add(linhaTitulo);

		JLabel caixaNome = new JLabel("");
		caixaNome.setBounds(192, 110, 265, 53);
		caixaNome.setIcon(
				new ImageIcon(TelaAtendente.class.getResource("/Interface/Imagens/CadastrarRemover/caixaDeTexto.png")));
		cadastrarPanel.add(caixaNome);

		JLabel caixaUsuario = new JLabel("");
		caixaUsuario.setBounds(531, 110, 265, 53);
		caixaUsuario.setIcon(
				new ImageIcon(TelaAtendente.class.getResource("/Interface/Imagens/CadastrarRemover/caixaDeTexto.png")));
		cadastrarPanel.add(caixaUsuario);

		JLabel caixaFone = new JLabel("");
		caixaFone.setBounds(195, 220, 265, 53);
		caixaFone.setIcon(
				new ImageIcon(TelaAtendente.class.getResource("/Interface/Imagens/CadastrarRemover/caixaDeTexto.png")));
		cadastrarPanel.add(caixaFone);

		JLabel caixaSenha = new JLabel("");
		caixaSenha.setBounds(531, 220, 265, 53);
		caixaSenha.setIcon(
				new ImageIcon(TelaAtendente.class.getResource("/Interface/Imagens/CadastrarRemover/caixaDeTexto.png")));
		cadastrarPanel.add(caixaSenha);

		JLabel senha = new JLabel("Senha");
		senha.setBounds(534, 190, 71, 26);
		senha.setForeground(Color.BLACK);
		senha.setFont(new Font("Amazon Ember Display Medium", Font.PLAIN, 20));
		cadastrarPanel.add(senha);

		JLabel fone = new JLabel("Fone");
		fone.setBounds(198, 190, 71, 26);
		fone.setForeground(Color.BLACK);
		fone.setFont(new Font("Amazon Ember Display Medium", Font.PLAIN, 20));
		cadastrarPanel.add(fone);

		JLabel nome = new JLabel("Nome");
		nome.setBounds(198, 80, 71, 26);
		nome.setForeground(Color.BLACK);
		nome.setFont(new Font("Amazon Ember Display Medium", Font.PLAIN, 20));
		cadastrarPanel.add(nome);

		JLabel usuario = new JLabel("Usuário");
		usuario.setBounds(534, 80, 84, 26);
		usuario.setForeground(Color.BLACK);
		usuario.setFont(new Font("Amazon Ember Display Medium", Font.PLAIN, 20));
		cadastrarPanel.add(usuario);

		txtNome = new JTextField();
		txtNome.setBounds(200, 115, 248, 36);
		txtNome.setForeground(Color.BLACK);
		txtNome.setBorder(null);
		txtNome.setFont(new Font("Amazon Ember", Font.PLAIN, 20));
		txtNome.setColumns(10);
		cadastrarPanel.add(txtNome);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(540, 115, 248, 36);
		txtUsuario.setForeground(Color.BLACK);
		txtUsuario.setFont(new Font("Amazon Ember", Font.PLAIN, 20));
		txtUsuario.setColumns(10);
		txtUsuario.setBorder(null);
		cadastrarPanel.add(txtUsuario);

		txtFone = new JTextField();
		txtFone.setBounds(204, 225, 248, 36);
		txtFone.setForeground(Color.BLACK);
		txtFone.setFont(new Font("Amazon Ember", Font.PLAIN, 20));
		txtFone.setColumns(10);
		txtFone.setBorder(null);
		cadastrarPanel.add(txtFone);

		txtSenha = new JTextField();
		txtSenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnCadastrar.setVisible(false);
					btnCadastrarPressionado.setVisible(true);
					btnCadastrarActionPerformed();
					if (e != null) {
						btnCadastrar.setVisible(true);
						btnCadastrarPressionado.setVisible(false);
					}
				}
			}
		});
		txtSenha.setFont(new Font("Amazon Ember", Font.PLAIN, 20));
		txtSenha.setBorder(null);
		txtSenha.setBounds(540, 225, 248, 36);
		cadastrarPanel.add(txtSenha);
		txtSenha.setColumns(10);

		btnCadastrar = new JLabel("");
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
		btnCadastrar.setBounds(326, 300, 287, 66);
		btnCadastrar.setHorizontalAlignment(SwingConstants.CENTER);
		btnCadastrar.setIcon(new ImageIcon(
				TelaAtendente.class.getResource("/Interface/Imagens/CadastrarRemover/iconeCadastrar.png")));
		cadastrarPanel.add(btnCadastrar);

		btnCadastrarPressionado = new JLabel("");
		btnCadastrarPressionado.setVisible(false);
		btnCadastrarPressionado.setHorizontalAlignment(SwingConstants.CENTER);
		btnCadastrarPressionado.setIcon(new ImageIcon(
				TelaAtendente.class.getResource("/Interface/Imagens/CadastrarRemover/iconeCadastrarPressionado.png")));
		btnCadastrarPressionado.setBounds(326, 300, 287, 66);
		cadastrarPanel.add(btnCadastrarPressionado);

		JPanel removerPanel = new JPanel();
		removerPanel.setLayout(null);
		removerPanel.setForeground(Color.BLACK);
		removerPanel.setBorder(null);
		removerPanel.setBackground(Color.WHITE);
		removerPanel.setBounds(30, 85, 940, 397);
		removerPanel.setVisible(false);
		corpoPanel.add(removerPanel);

		// RENDERIZAR OS TÍTULO DA TABELA:
		DefaultTableCellRenderer MyHeaderRender = new DefaultTableCellRenderer();
		MyHeaderRender.setBackground(new Color(1, 99, 27));
		MyHeaderRender.setForeground(Color.WHITE);
		MyHeaderRender.setHorizontalAlignment(JLabel.CENTER);
		MyHeaderRender.setFont(new Font("Inter", Font.BOLD, 50));
		MyHeaderRender.setPreferredSize(new Dimension(100, 30));
		MyHeaderRender.setHorizontalAlignment(JLabel.CENTER);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(168, 60, 641, 257);
		scrollPane.getViewport().setBorder(null);
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent e) {
				readFila();
			}
		});

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(381, 60, 1, 30);
		removerPanel.add(lblNewLabel);
		lblNewLabel.setIcon(
				new ImageIcon(TelaAtendente.class.getResource("/Interface/Imagens/Atendente/linhaTabela.png")));

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(
				new ImageIcon(TelaAtendente.class.getResource("/Interface/Imagens/Atendente/linhaTabela.png")));
		lblNewLabel_1.setBounds(594, 60, 1, 30);
		removerPanel.add(lblNewLabel_1);
		removerPanel.add(scrollPane);
		removerPanel.add(scrollPane);

		// RENDERIZAR OS VALORES DA CÉLULA:
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);

		table = new JTable();
		table.setRowHeight(25);
		table.setGridColor(Color.BLACK);
		table.setFont(new Font("Amazon Ember", Font.PLAIN, 15));
		table.setForeground(Color.BLACK);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Usu\u00E1rio", "Nome", "Telefone" }) {
			boolean[] canEdit = new boolean[] { false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table.getTableHeader().getColumnModel().getColumn(0).setHeaderRenderer(MyHeaderRender);
		table.getTableHeader().getColumnModel().getColumn(1).setHeaderRenderer(MyHeaderRender);
		table.getTableHeader().getColumnModel().getColumn(2).setHeaderRenderer(MyHeaderRender);

		JLabel linha2 = new JLabel("");
		linha2.setIcon(
				new ImageIcon(TelaAtendente.class.getResource("/Interface/Imagens/CadastrarRemover/linhaTitulo.png")));
		linha2.setBounds(165, 45, 641, 1);
		removerPanel.add(linha2);

		JLabel atendente2 = new JLabel("Atendente");
		atendente2.setHorizontalAlignment(SwingConstants.CENTER);
		atendente2.setFont(new Font("Inter", Font.BOLD, 25));
		atendente2.setBounds(308, 3, 324, 46);
		removerPanel.add(atendente2);

		JLabel btnDeletar = new JLabel("");
		JLabel btnDeletarPressionado = new JLabel("");
		btnDeletar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnDeletar.setVisible(false);
				btnDeletarPressionado.setVisible(true);
				btnDeletarActionPerformed();
				if (e != null) {
					btnDeletar.setVisible(true);
					btnDeletarPressionado.setVisible(false);
				}
			}
		});
		btnDeletar.setIcon(
				new ImageIcon(TelaAtendente.class.getResource("/Interface/Imagens/CadastrarRemover/iconeDeletar.png")));
		btnDeletar.setHorizontalAlignment(SwingConstants.CENTER);
		btnDeletar.setBounds(326, 330, 287, 66);
		removerPanel.add(btnDeletar);

		btnDeletarPressionado.setVisible(false);
		btnDeletarPressionado.setHorizontalAlignment(SwingConstants.CENTER);
		btnDeletarPressionado.setIcon(new ImageIcon(
				TelaAtendente.class.getResource("/Interface/Imagens/CadastrarRemover/iconeDeletarPressionado.png")));
		btnDeletarPressionado.setBounds(326, 330, 287, 66);
		removerPanel.add(btnDeletarPressionado);

		JLabel removerOFF = new JLabel("");
		removerOFF.setIcon(
				new ImageIcon(TelaAtendente.class.getResource("/Interface/Imagens/CadastrarRemover/removerOFF.png")));
		removerOFF.setBounds(0, 0, 470, 54);

		JLabel removerON = new JLabel("");
		removerON.setIcon(
				new ImageIcon(TelaAtendente.class.getResource("/Interface/Imagens/CadastrarRemover/removerON.png")));
		removerON.setBounds(0, 0, 470, 54);

		JLabel cadastrarON = new JLabel("");
		cadastrarON.setBounds(0, 0, 470, 54);
		cadastrarON.setIcon(
				new ImageIcon(TelaAtendente.class.getResource("/Interface/Imagens/CadastrarRemover/cadastrarON.png")));

		JLabel cadastrarOFF = new JLabel("");
		cadastrarOFF.setIcon(
				new ImageIcon(TelaAtendente.class.getResource("/Interface/Imagens/CadastrarRemover/cadastrarOFF.png")));
		cadastrarOFF.setBounds(0, 0, 470, 54);

		JPanel removerAba = new JPanel();
		removerAba.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cadastrarPanel.setVisible(false);
				removerPanel.setVisible(true);
				cadastrarON.setVisible(false);
				cadastrarOFF.setVisible(true);
				removerOFF.setVisible(false);
				removerON.setVisible(true);
			}
		});

		JPanel cadastrarAba = new JPanel();
		cadastrarAba.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cadastrarPanel.setVisible(true);
				removerPanel.setVisible(false);
				cadastrarON.setVisible(true);
				cadastrarOFF.setVisible(false);
				removerOFF.setVisible(true);
				removerON.setVisible(false);
			}
		});
		cadastrarAba.setBounds(30, 31, 470, 54);
		corpoPanel.add(cadastrarAba);
		cadastrarAba.setLayout(null);

		cadastrarAba.add(cadastrarON);
		cadastrarAba.add(cadastrarOFF);
		removerAba.add(removerOFF);
		removerAba.add(removerON);
		removerAba.setBounds(500, 31, 470, 54);
		corpoPanel.add(removerAba);
		removerAba.setLayout(null);

		JLabel tela = new JLabel("");
		tela.setIcon(new ImageIcon(TelaAtendente.class.getResource("/Interface/Imagens/CadastrarRemover/tela.png")));
		tela.setBounds(0, 0, 1000, 511);
		corpoPanel.add(tela);

		setIcon();
		setLocationRelativeTo(null);
	}

	public void readFila() {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setRowCount(0);

		UsuarioDAO nova = new UsuarioDAO();
		for (Usuario p : nova.listAten()) {
			modelo.addRow(new Object[] { p.getUsuario(), p.getNome(), p.getFone() });
		}
	}

	// MÉTODO PARA CADASTAR ATENDENTE
	private void btnCadastrarActionPerformed() {
		String user = txtUsuario.getText();
		String password = txtSenha.getText();
		String name = txtNome.getText();
		String phone = txtFone.getText();
		String cargo = "ATEN";

		if (user.equals("") || password.equals("") || name.equals("") || phone.equals("")) {
			JOptionPane.showMessageDialog(null, "Favor preencher todos os campos", "Campo vazio",
					JOptionPane.INFORMATION_MESSAGE);

		} else {
			Usuario adm = new Usuario(user, password, name, phone, cargo);
			adm.setUsuario(user);
			adm.setSenha(password);
			adm.setNome(name);
			adm.setFone(phone);
			adm.setCargo(cargo);

			UsuarioDAO cria = new UsuarioDAO();
			cria.createAdm(adm);
		}
		txtUsuario.setText("");
		txtSenha.setText("");
		txtNome.setText("");
		txtFone.setText("");
	}

	private void btnDeletarActionPerformed() {
		String user = table.getValueAt(table.getSelectedRow(), 0).toString();
		String name = table.getValueAt(table.getSelectedRow(), 1).toString();
		String phone = table.getValueAt(table.getSelectedRow(), 2).toString();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		String s = String.format("Você quer deletar o seguinte Atendente?\n" + "\nUsuário: %s\nNome: %s\nFone: %s",
				user, name, phone);
		int x = JOptionPane.showConfirmDialog(null, s, "Confirmação", JOptionPane.YES_NO_OPTION);

		if (x == JOptionPane.YES_OPTION) {
			int SelectedRowIndex = table.getSelectedRow();
			Usuario usuario = new Usuario();
			UsuarioDAO usuarioDAO = new UsuarioDAO();

			usuario.setUsuario((String) table.getValueAt(table.getSelectedRow(), 0));

			usuarioDAO.deleteAtendente(usuario);
			model.removeRow(SelectedRowIndex);

		} else {
			JOptionPane.showMessageDialog(null, "Operação cancelada!", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	private void setIcon() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(TelaAtendente.class.getResource("/Interface/Imagens/BarraDeMenu/iconeSESCOVID.png")));
	}
}
