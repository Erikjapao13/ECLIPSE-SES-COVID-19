package Interface.Atendente;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Interface.TelaLogin;
import Modelo.Pessoa;
import Modelo.PessoaDAO;

@SuppressWarnings("serial")
public class TelaFila extends JFrame {

	private JPanel telaPanel;
	private JTable filaPraVacinarTable;
	private JTable listaConfirmadaTable;
	private JLabel btnConfirmar;
	private JLabel btnConfirmarPressionado;
	private JLabel btnSair;
	private JLabel btnSairPressionado;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFila frame = new TelaFila();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaFila() {
		setTitle("SES COVID-19");
		setAutoRequestFocus(false);

		setFont(new Font("Dialog", Font.BOLD, 12));
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
		logoSESCOVID
				.setIcon(new ImageIcon(TelaFila.class.getResource("/Interface/Imagens/BarraDeMenu/logoSESCOVID.png")));
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
		barraMenuPanel.add(COVID);

		btnSair = new JLabel("");
		btnSair.setToolTipText("Sair");
		btnSair.setIcon(new ImageIcon(TelaFila.class.getResource("/Interface/Imagens/Atendente/iconeSair.png")));
		btnSair.setBounds(910, 28, 60, 36);
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnSair.setVisible(false);
				btnSairPressionado.setVisible(true);
				if(e != null) {
					btnSair.setVisible(true);
					btnSairPressionado.setVisible(false);
				}
				TelaLogin th = new TelaLogin();
				th.setVisible(true);
				dispose();
			}
		});
		barraMenuPanel.add(btnSair);

		btnSairPressionado = new JLabel("");
		btnSairPressionado.setVisible(false);
		btnSairPressionado.setIcon(new ImageIcon(TelaFila.class.getResource("/Interface/Imagens/BarraDeMenu/iconeSairPressionado.png")));
		btnSairPressionado.setBounds(910, 28, 60, 36);
		barraMenuPanel.add(btnSairPressionado);

		JLabel barraMenu = new JLabel("");
		barraMenu.setBounds(0, 0, 1000, 89);
		barraMenu.setIcon(new ImageIcon(TelaFila.class.getResource("/Interface/Imagens/BarraDeMenu/barraMenu.png")));
		barraMenuPanel.add(barraMenu);

		JPanel corpoPanel = new JPanel();
		corpoPanel.setBounds(0, 89, 1000, 511);
		corpoPanel.setBackground(Color.WHITE);
		corpoPanel.setLayout(null);
		telaPanel.add(corpoPanel);

		JPanel filaPraVacinarPanel = new JPanel();
		filaPraVacinarPanel.setBackground(Color.WHITE);
		filaPraVacinarPanel.setBounds(30, 85, 940, 397);
		corpoPanel.add(filaPraVacinarPanel);

		// RENDERIZAR OS TÍTULO DA TABELA:
		DefaultTableCellRenderer MyHeaderRender = new DefaultTableCellRenderer();
		MyHeaderRender.setBackground(new Color(1, 99, 27));
		MyHeaderRender.setForeground(Color.WHITE);
		MyHeaderRender.setHorizontalAlignment(JLabel.CENTER);
		MyHeaderRender.setFont(new Font("Inter", Font.BOLD, 50));
		MyHeaderRender.setPreferredSize(new Dimension(100, 35));

		JScrollPane filaPraVacinarScrollPane = new JScrollPane();
		filaPraVacinarScrollPane.setBackground(Color.WHITE);
		filaPraVacinarScrollPane.getViewport().setBackground(Color.WHITE);
		filaPraVacinarScrollPane.setBorder(null);
		filaPraVacinarScrollPane.getViewport().setBorder(null);
		filaPraVacinarScrollPane.setBounds(28, 30, 880, 270);
		filaPraVacinarScrollPane.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent e) {
				readFilaVacinar();
			}
		});
		filaPraVacinarPanel.setLayout(null);

		JLabel linhaTabela1 = new JLabel("");
		linhaTabela1.setIcon(new ImageIcon(TelaFila.class.getResource("/Interface/Imagens/Atendente/linhaTabela.png")));
		linhaTabela1.setBounds(328, 30, 1, 35);
		filaPraVacinarPanel.add(linhaTabela1);

		JLabel linhaTabela2 = new JLabel("");
		linhaTabela2.setIcon(new ImageIcon(TelaFila.class.getResource("/Interface/Imagens/Atendente/linhaTabela.png")));
		linhaTabela2.setBounds(429, 30, 1, 35);
		filaPraVacinarPanel.add(linhaTabela2);

		JLabel linhaTabela3 = new JLabel("");
		linhaTabela3.setBounds(786, 30, 1, 35);
		filaPraVacinarPanel.add(linhaTabela3);
		linhaTabela3.setIcon(new ImageIcon(TelaFila.class.getResource("/Interface/Imagens/Atendente/linhaTabela.png")));
		filaPraVacinarPanel.add(filaPraVacinarScrollPane);

		// RENDERIZAR OS VALORES DA CÉLULA:
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);

		filaPraVacinarTable = new JTable();
		filaPraVacinarTable.setRowHeight(30);
		filaPraVacinarTable.setOpaque(true);
		filaPraVacinarTable.setGridColor(Color.BLACK);
		filaPraVacinarTable.setFont(new Font("Amazon Ember", Font.PLAIN, 15));
		filaPraVacinarTable.setForeground(Color.BLACK);
		filaPraVacinarTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "Idade", "Endere\u00E7o", "\u00C1rea da Sa\u00FAde" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		}

		);
		filaPraVacinarTable.getColumnModel().getColumn(0).setPreferredWidth(302);
		filaPraVacinarTable.getColumnModel().getColumn(0).setMaxWidth(302);
		filaPraVacinarTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		filaPraVacinarTable.getColumnModel().getColumn(1).setMaxWidth(100);
		filaPraVacinarTable.getColumnModel().getColumn(2).setPreferredWidth(360);
		filaPraVacinarTable.getColumnModel().getColumn(2).setMaxWidth(360);
		filaPraVacinarTable.getColumnModel().getColumn(3).setPreferredWidth(120);
		filaPraVacinarTable.getColumnModel().getColumn(3).setMaxWidth(120);
		filaPraVacinarTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		filaPraVacinarTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		filaPraVacinarTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		filaPraVacinarTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		filaPraVacinarTable.getTableHeader().getColumnModel().getColumn(0).setHeaderRenderer(MyHeaderRender);
		filaPraVacinarTable.getTableHeader().getColumnModel().getColumn(1).setHeaderRenderer(MyHeaderRender);
		filaPraVacinarTable.getTableHeader().getColumnModel().getColumn(2).setHeaderRenderer(MyHeaderRender);
		filaPraVacinarTable.getTableHeader().getColumnModel().getColumn(3).setHeaderRenderer(MyHeaderRender);
		filaPraVacinarScrollPane.setViewportView(filaPraVacinarTable);

		btnConfirmar = new JLabel("");
		btnConfirmar.setBounds(341, 320, 267, 64);
		btnConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnConfirmar.setVisible(false);
				btnConfirmarPressionado.setVisible(true);
				confirmarVacinacao();
				if(e != null) {
					btnConfirmar.setVisible(true);
					btnConfirmarPressionado.setVisible(false);
				}
			}
		});
		btnConfirmar.setIcon(new ImageIcon(TelaFila.class.getResource("/Interface/Imagens/Atendente/iconeConfirmar.png")));
		filaPraVacinarPanel.add(btnConfirmar);

		btnConfirmarPressionado = new JLabel("");
		btnConfirmarPressionado.setVisible(false);
		btnConfirmarPressionado.setIcon(new ImageIcon(
				TelaFila.class.getResource("/Interface/Imagens/CadastrarRemover/iconeConfirmarPressionado.png")));
		btnConfirmarPressionado.setBounds(341, 320, 267, 64);
		filaPraVacinarPanel.add(btnConfirmarPressionado);

		JPanel ListaConfirmada = new JPanel();
		ListaConfirmada.setBackground(Color.WHITE);
		ListaConfirmada.setSize(940, 397);
		ListaConfirmada.setLocation(30, 85);
		ListaConfirmada.setLayout(null);
		corpoPanel.add(ListaConfirmada);

		JScrollPane listaConfirmadaScrollPane = new JScrollPane();
		listaConfirmadaScrollPane.setBackground(Color.WHITE);
		listaConfirmadaScrollPane.getViewport().setBackground(Color.WHITE);
		listaConfirmadaScrollPane.setBounds(10, 29, 922, 350);
		listaConfirmadaScrollPane.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent e) {
				readFilaVacinados();
			}
		});

		JLabel linhaTabela4 = new JLabel("");
		linhaTabela4.setIcon(new ImageIcon(TelaFila.class.getResource("/Interface/Imagens/Atendente/linhaTabela.png")));
		linhaTabela4.setBackground(Color.BLACK);
		linhaTabela4.setBounds(259, 30, 1, 35);
		ListaConfirmada.add(linhaTabela4);

		JLabel linhaTabela5 = new JLabel("");
		linhaTabela5.setBounds(321, 30, 1, 35);
		linhaTabela5.setIcon(new ImageIcon(TelaFila.class.getResource("/Interface/Imagens/Atendente/linhaTabela.png")));
		ListaConfirmada.add(linhaTabela5);

		JLabel linhaTabela6 = new JLabel("");
		linhaTabela6.setIcon(new ImageIcon(TelaFila.class.getResource("/Interface/Imagens/Atendente/linhaTabela.png")));
		linhaTabela6.setBounds(630, 30, 1, 35);
		ListaConfirmada.add(linhaTabela6);

		JLabel linhaTabela7 = new JLabel("");
		linhaTabela7.setIcon(new ImageIcon(TelaFila.class.getResource("/Interface/Imagens/Atendente/linhaTabela.png")));
		linhaTabela7.setBounds(780, 30, 1, 35);
		ListaConfirmada.add(linhaTabela7);
		ListaConfirmada.add(listaConfirmadaScrollPane);

		listaConfirmadaTable = new JTable();
		listaConfirmadaTable.setRowHeight(30);
		listaConfirmadaTable.setGridColor(Color.BLACK);
		listaConfirmadaTable.setFont(new Font("Amazon Ember", Font.PLAIN, 15));
		listaConfirmadaTable.setForeground(Color.BLACK);
		listaConfirmadaTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Idade",
				"Endere\u00E7o", "\u00C1rea da Sa\u00FAde", "Data de Vacina\u00E7\u00E3o" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		}

		);
		listaConfirmadaTable.getColumnModel().getColumn(0).setPreferredWidth(250);
		listaConfirmadaTable.getColumnModel().getColumn(0).setMaxWidth(250);
		listaConfirmadaTable.getColumnModel().getColumn(1).setPreferredWidth(62);
		listaConfirmadaTable.getColumnModel().getColumn(1).setMaxWidth(62);
		listaConfirmadaTable.getColumnModel().getColumn(2).setPreferredWidth(310);
		listaConfirmadaTable.getColumnModel().getColumn(2).setMaxWidth(310);
		listaConfirmadaTable.getColumnModel().getColumn(3).setPreferredWidth(150);
		listaConfirmadaTable.getColumnModel().getColumn(3).setMaxWidth(150);
		listaConfirmadaTable.getColumnModel().getColumn(4).setPreferredWidth(150);
		listaConfirmadaTable.getColumnModel().getColumn(4).setMaxWidth(150);
		listaConfirmadaTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		listaConfirmadaTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		listaConfirmadaTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		listaConfirmadaTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		listaConfirmadaTable.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		listaConfirmadaTable.getTableHeader().getColumnModel().getColumn(0).setHeaderRenderer(MyHeaderRender);
		listaConfirmadaTable.getTableHeader().getColumnModel().getColumn(1).setHeaderRenderer(MyHeaderRender);
		listaConfirmadaTable.getTableHeader().getColumnModel().getColumn(2).setHeaderRenderer(MyHeaderRender);
		listaConfirmadaTable.getTableHeader().getColumnModel().getColumn(3).setHeaderRenderer(MyHeaderRender);
		listaConfirmadaTable.getTableHeader().getColumnModel().getColumn(4).setHeaderRenderer(MyHeaderRender);
		listaConfirmadaScrollPane.setViewportView(listaConfirmadaTable);

		JLabel vacinadosON = new JLabel("");
		JLabel vacinadosOFF = new JLabel("");
		JLabel confirmadosOFF = new JLabel("");
		JLabel confirmadosON = new JLabel("");

		JPanel abaFilaPraVacinar = new JPanel();
		abaFilaPraVacinar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				filaPraVacinarPanel.setVisible(true);
				ListaConfirmada.setVisible(false);
				confirmadosON.setVisible(false);
				confirmadosOFF.setVisible(true);
				vacinadosON.setVisible(true);
				vacinadosOFF.setVisible(false);
			}
		});
		abaFilaPraVacinar.setBounds(30, 31, 470, 54);
		corpoPanel.add(abaFilaPraVacinar);
		abaFilaPraVacinar.setLayout(null);

		vacinadosON.setBounds(0, 0, 470, 54);
		vacinadosON.setIcon(new ImageIcon(TelaFila.class.getResource("/Interface/Imagens/Atendente/vacinadosON.png")));
		abaFilaPraVacinar.add(vacinadosON);

		vacinadosOFF
				.setIcon(new ImageIcon(TelaFila.class.getResource("/Interface/Imagens/Atendente/vacinadosOFF.png")));
		vacinadosOFF.setBounds(0, 0, 470, 54);
		abaFilaPraVacinar.add(vacinadosOFF);

		JPanel abaListaConfirmada = new JPanel();
		abaListaConfirmada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				readFilaVacinados();
				filaPraVacinarPanel.setVisible(false);
				ListaConfirmada.setVisible(true);
				confirmadosON.setVisible(true);
				confirmadosOFF.setVisible(false);
				vacinadosON.setVisible(false);
				vacinadosOFF.setVisible(true);
			}
		});
		abaListaConfirmada.setBounds(500, 31, 470, 54);
		corpoPanel.add(abaListaConfirmada);
		abaListaConfirmada.setLayout(null);

		confirmadosOFF
				.setIcon(new ImageIcon(TelaFila.class.getResource("/Interface/Imagens/Atendente/confirmadosOFF.png")));
		confirmadosOFF.setBounds(0, 0, 470, 54);
		abaListaConfirmada.add(confirmadosOFF);

		confirmadosON
				.setIcon(new ImageIcon(TelaFila.class.getResource("/Interface/Imagens/Atendente/confirmadosON.png")));
		confirmadosON.setBounds(0, 0, 470, 54);
		abaListaConfirmada.add(confirmadosON);

		JLabel telaVacina = new JLabel("");
		telaVacina.setIcon(new ImageIcon(TelaFila.class.getResource("/Interface/Imagens/CadastrarRemover/tela.png")));
		telaVacina.setBounds(0, 0, 1000, 511);
		corpoPanel.add(telaVacina);

		setIcon();
		setLocationRelativeTo(null);
	}

	private void confirmarVacinacao() {
		if (filaPraVacinarTable.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Selecione a pessoa que será vacinada.", "",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			Object idade = filaPraVacinarTable.getValueAt(filaPraVacinarTable.getSelectedRow(), 1);
			String idadec = idade.toString();
			Object name = filaPraVacinarTable.getValueAt(filaPraVacinarTable.getSelectedRow(), 0);
			String nome = name.toString();
			Pessoa vacinada = new Pessoa(nome);
			vacinada.setNome(nome);

			Object confirm = filaPraVacinarTable.getSelectedRow();
			int x = JOptionPane.showConfirmDialog(null,
					"Você confirma a vacinação da seguinte pessoa?\n\n" + nome + ", " + idadec + " anos.",
					"Confirmação", JOptionPane.YES_NO_OPTION);
			if (x == JOptionPane.YES_OPTION) {
				PessoaDAO registra = new PessoaDAO();
				registra.registraVacinacao(vacinada);
				readFilaVacinar();
			} else {
				JOptionPane.showMessageDialog(null, "Operação cancelada!", "Cancelado",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public void readFilaVacinar() {
		DefaultTableModel modelo = (DefaultTableModel) filaPraVacinarTable.getModel();
		modelo.setRowCount(0);
		String saude;
		PessoaDAO nova = new PessoaDAO();
		for (Pessoa p : nova.listPessoas()) {
			if (p.isAreasaude() == true) {
				saude = "Sim";
			} else {
				saude = "Não";
			}
			modelo.addRow(new Object[] { p.getNome(), p.getIdade(), p.getEndereco(), saude });
		}
	}

	public void readFilaVacinados() {
		DefaultTableModel modelo = (DefaultTableModel) listaConfirmadaTable.getModel();
		SimpleDateFormat formatBR = new SimpleDateFormat("dd/MM/yyyy");
		modelo.setRowCount(0);
		String saude;

		PessoaDAO vacinados = new PessoaDAO();
		for (Pessoa p : vacinados.listVacinados()) {
			if (p.isAreasaude() == true) {
				saude = "Sim";
			} else {
				saude = "Não";
			}

			String data = formatBR.format(p.getDataVacinacao());
			modelo.addRow(new Object[] { p.getNome(), p.getIdade(), p.getEndereco(), saude, data });
		}
	}

	private void setIcon() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(TelaFila.class.getResource("/Interface/Imagens/BarraDeMenu/iconeSESCOVID.png")));
	}
}
