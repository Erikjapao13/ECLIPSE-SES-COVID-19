package Interface.Administrador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Modelo.Pessoa;
import Modelo.PessoaDAO;

public class TelaGerarRelatorio extends JFrame {

	private JPanel telaPanel;
	private JTextField txtDataIncial;
	private JTextField txtDataFinal;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel LabelNivel1;
	private JLabel LabelNivel2;
	private JLabel LabelNivel3;
	private JLabel LabelNivel4;
	private JLabel LabelTotal;
	private String dataInicial;
	private String dataFinal;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaGerarRelatorio frame = new TelaGerarRelatorio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaGerarRelatorio() {
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
		telaPanel.add(barraMenuPanel);
		barraMenuPanel.setLayout(null);

		JLabel logo = new JLabel("");
		logo.setBounds(388, 11, 60, 66);
		logo.setLabelFor(logo);
		logo.setIcon(
				new ImageIcon(TelaGerarRelatorio.class.getResource("/Interface/Imagens/BarraDeMenu/logoSESCOVID.png")));
		barraMenuPanel.add(logo);

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
		btnSair.setIcon(
				new ImageIcon(TelaGerarRelatorio.class.getResource("/Interface/Imagens/BarraDeMenu/iconeSair.png")));
		btnSair.setBounds(910, 28, 60, 38);
		barraMenuPanel.add(btnSair);

		JLabel barraMenu = new JLabel("");
		barraMenu.setBounds(0, 0, 1000, 89);
		barraMenuPanel.add(barraMenu);
		barraMenu.setIcon(
				new ImageIcon(TelaGerarRelatorio.class.getResource("/Interface/Imagens/BarraDeMenu/barraMenu.png")));

		JPanel corpoPanel = new JPanel();
		corpoPanel.setBounds(0, 89, 1000, 499);
		corpoPanel.setBackground(Color.WHITE);
		telaPanel.add(corpoPanel);
		corpoPanel.setLayout(null);

		JLabel dataIncial = new JLabel("Data a data incial:");
		dataIncial.setFont(new Font("Inter SemiBold", Font.PLAIN, 20));
		dataIncial.setBounds(19, 30, 182, 25);
		corpoPanel.add(dataIncial);

		LabelTotal = new JLabel();
		LabelTotal.setVisible(false);
		LabelTotal.setSize(327, 25);
		LabelTotal.setLocation(330, 460);
		LabelTotal.setFont(new java.awt.Font("Amazon Ember", 0, 20));
		LabelTotal.setForeground(new java.awt.Color(0, 0, 0));
		LabelTotal.setText("TOTAL VACINADOS NO PERÍODO: X");
		corpoPanel.add(LabelTotal);

		LabelNivel1 = new JLabel();
		LabelNivel1.setVisible(false);
		LabelNivel1.setLocation(40, 390);
		LabelNivel1.setSize(411, 25);
		LabelNivel1.setFont(new java.awt.Font("Amazon Ember", 0, 20));
		LabelNivel1.setForeground(new java.awt.Color(0, 0, 0));
		LabelNivel1.setText("NÍVEL DE PRIORIDADE 1:  X PESSOA(S) (XX%)");
		LabelNivel1.setToolTipText("Idade > 70 & Prof. Saúde");
		corpoPanel.add(LabelNivel1);

		LabelNivel2 = new JLabel();
		LabelNivel2.setVisible(false);
		LabelNivel2.setSize(411, 25);
		LabelNivel2.setLocation(530, 390);
		LabelNivel2.setFont(new java.awt.Font("Amazon Ember", 0, 20));
		LabelNivel2.setForeground(new java.awt.Color(0, 0, 0));
		LabelNivel2.setText("NÍVEL DE PRIORIDADE 2:  X PESSOA(S) (XX%)");
		LabelNivel2.setToolTipText("Idade > 70");
		corpoPanel.add(LabelNivel2);

		LabelNivel3 = new JLabel();
		LabelNivel3.setVisible(false);
		LabelNivel3.setSize(411, 25);
		LabelNivel3.setLocation(40, 420);
		LabelNivel3.setFont(new java.awt.Font("Amazon Ember", 0, 20));
		LabelNivel3.setForeground(new java.awt.Color(0, 0, 0));
		LabelNivel3.setText("NÍVEL DE PRIORIDADE 3:  X PESSOA(S) (XX%)");
		corpoPanel.add(LabelNivel3);

		LabelNivel4 = new JLabel();
		LabelNivel4.setVisible(false);
		LabelNivel4.setSize(411, 25);
		LabelNivel4.setLocation(530, 420);
		LabelNivel4.setFont(new java.awt.Font("Amazon Ember", 0, 20));
		LabelNivel4.setForeground(new java.awt.Color(0, 0, 0));
		LabelNivel4.setText("NÍVEL DE PRIORIDADE 4: X  PESSOA(S) (XX%)");
		corpoPanel.add(LabelNivel4);

		txtDataIncial = new JTextField();
		txtDataIncial.setText("/  /");
		txtDataIncial.setHorizontalAlignment(SwingConstants.CENTER);
		txtDataIncial.setBorder(null);
		txtDataIncial.setFont(new Font("Amazon Ember", Font.PLAIN, 20));
		txtDataIncial.setBounds(202, 25, 156, 38);
		corpoPanel.add(txtDataIncial);
		txtDataIncial.setColumns(10);

		JLabel caixaDeTextoDataIncial = new JLabel("");
		caixaDeTextoDataIncial.setIcon(new ImageIcon(
				TelaGerarRelatorio.class.getResource("/Interface/Imagens/Administrador/caixaDeTextoData.png")));
		caixaDeTextoDataIncial.setBounds(195, 21, 170, 53);
		corpoPanel.add(caixaDeTextoDataIncial);

		JLabel dataFinal = new JLabel("e a data final:");
		dataFinal.setFont(new Font("Inter SemiBold", Font.PLAIN, 19));
		dataFinal.setBounds(372, 30, 128, 25);
		corpoPanel.add(dataFinal);

		txtDataFinal = new JTextField();
		txtDataFinal.setText("/  /");
		txtDataFinal.setHorizontalAlignment(SwingConstants.CENTER);
		txtDataFinal.setBorder(null);
		txtDataFinal.setFont(new Font("Amazon Ember", Font.PLAIN, 20));
		txtDataFinal.setBounds(507, 25, 156, 38);
		corpoPanel.add(txtDataFinal);
		txtDataFinal.setColumns(10);

		JLabel caixaDeTextoDataFinal = new JLabel("");
		caixaDeTextoDataFinal.setIcon(new ImageIcon(
				TelaGerarRelatorio.class.getResource("/Interface/Imagens/Administrador/caixaDeTextoData.png")));
		caixaDeTextoDataFinal.setBounds(500, 21, 170, 53);
		corpoPanel.add(caixaDeTextoDataFinal);

		JLabel btnGerarRelatorio = new JLabel("");
		JLabel btnGerarRelatorioPressionado = new JLabel("");
		btnGerarRelatorio.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnGerarRelatorio.setVisible(false);
				btnGerarRelatorioPressionado.setVisible(true);
				gerarRelatorio();
				if (e != null) {
					btnGerarRelatorio.setVisible(true);
					btnGerarRelatorioPressionado.setVisible(false);
				}
			}
		});
		btnGerarRelatorio.setIcon(new ImageIcon(
				TelaGerarRelatorio.class.getResource("/Interface/Imagens/Administrador/iconeGerear.png")));
		btnGerarRelatorio.setBounds(720, 21, 267, 64);
		corpoPanel.add(btnGerarRelatorio);

		// RENDERIZAR OS TÍTULO DA TABELA:
		DefaultTableCellRenderer MyHeaderRender = new DefaultTableCellRenderer();
		MyHeaderRender.setBackground(new Color(1, 99, 27));
		MyHeaderRender.setForeground(Color.WHITE);
		MyHeaderRender.setHorizontalAlignment(JLabel.CENTER);
		MyHeaderRender.setFont(new Font("Inter", Font.BOLD, 50));
		MyHeaderRender.setPreferredSize(new Dimension(100, 35));

		// RENDERIZAR OS VALORES DA CÉLULA:
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);

		btnGerarRelatorioPressionado.setVisible(false);
		btnGerarRelatorioPressionado.setIcon(new ImageIcon(
				TelaGerarRelatorio.class.getResource("/Interface/Imagens/Administrador/iconeGerarPRessionado.png")));
		btnGerarRelatorioPressionado.setBounds(720, 21, 267, 64);
		corpoPanel.add(btnGerarRelatorioPressionado);

		JLabel linhaTabela1 = new JLabel("");
		linhaTabela1.setIcon(
				new ImageIcon(TelaGerarRelatorio.class.getResource("/Interface/Imagens/Atendente/linhaTabela.png")));
		linhaTabela1.setBounds(299, 110, 1, 35);
		corpoPanel.add(linhaTabela1);
		
		JLabel linhaTabela2 = new JLabel("");
		linhaTabela2.setIcon(new ImageIcon(TelaGerarRelatorio.class.getResource("/Interface/Imagens/Atendente/linhaTabela.png")));
		linhaTabela2.setBounds(498, 110, 1, 35);
		corpoPanel.add(linhaTabela2);
		
		JLabel linhaTabela3 = new JLabel("");
		linhaTabela3.setIcon(new ImageIcon(TelaGerarRelatorio.class.getResource("/Interface/Imagens/Atendente/linhaTabela.png")));
		linhaTabela3.setBounds(698, 110, 1, 35);
		corpoPanel.add(linhaTabela3);
		
				scrollPane = new JScrollPane();
				scrollPane.getViewport().setBackground(Color.WHITE);
				scrollPane.setBackground(Color.WHITE);
				scrollPane.setBounds(100, 110, 800, 250);
				corpoPanel.add(scrollPane);
				
						table = new JTable();
						table.setBackground(Color.WHITE);
						table.setRowHeight(30);
						table.setGridColor(Color.BLACK);
						table.setFont(new Font("Amazon Ember", Font.PLAIN, 15));
						scrollPane.setViewportView(table);
						table.setModel(new DefaultTableModel(new Object[][] {},
								new String[] { "Nome", "Idade", "\u00C1rea da Sa\u00FAde", "Data de Vacina\u00E7\u00E3o" }) {
							boolean[] columnEditables = new boolean[] { false, false, false, false };

							public boolean isCellEditable(int row, int column) {
								return columnEditables[column];
							}
						});
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table.getTableHeader().getColumnModel().getColumn(0).setHeaderRenderer(MyHeaderRender);
		table.getTableHeader().getColumnModel().getColumn(1).setHeaderRenderer(MyHeaderRender);
		table.getTableHeader().getColumnModel().getColumn(2).setHeaderRenderer(MyHeaderRender);
		table.getTableHeader().getColumnModel().getColumn(3).setHeaderRenderer(MyHeaderRender);

		setIcon();
		setLocationRelativeTo(null);
	}

	public void readLista() {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		SimpleDateFormat formatBR = new SimpleDateFormat("dd/MM/yyyy");
		modelo.setRowCount(0);

		String saude; // STRING PARA DEFINIR SE A PESSOA É OU NÃO DA ÁREA SAÚDE
		int prior1 = 0; // PESSOAS VACINADAS PRIORIDADE NIVEL 1
		int prior2 = 0; // PESSOAS VACINADAS PRIORIDADE NIVEL 2
		int prior3 = 0; // PESSOAS VACINADAS PRIORIDADE NIVEL 3
		int prior4 = 0; // PESSOAS VACINADAS PRIORIDADE NIVEL 4

		PessoaDAO vacinados = new PessoaDAO();
		for (Pessoa p : vacinados.listVacinadosFiltro(dataInicial, dataFinal)) {
			if (p.getIdade() > 70 && p.isAreasaude() == true) {
				prior1++;
				saude = "Sim";
			} else if (p.getIdade() > 70) {
				prior2++;
				saude = "Não";
			} else if (p.isAreasaude() == true) {
				prior3++;
				saude = "Sim";
			} else {
				prior4++;
				saude = "Não";
			}

			String data = formatBR.format(p.getDataVacinacao());
			modelo.addRow(new Object[] { p.getNome(), p.getIdade(), saude, data });
		}
		scrollPane.setVisible(true);
		int x = table.getRowCount(); // TOTAL DE PESSOAS VACINADAS NO PERIODO
		int porcniv1 = prior1 * 100 / x; // PORCENTAGEM DE PESSOAS PRIOR NIVEL 1
		int porcniv2 = prior2 * 100 / x; // PORCENTAGEM DE PESSOAS PRIOR NIVEL 2
		int porcniv3 = prior3 * 100 / x; // PORCENTAGEM DE PESSOAS PRIOR NIVEL 3
		int porcniv4 = prior4 * 100 / x; // PORCENTAGEM DE PESSOAS PRIOR NIVEL 4

		// TEXTOS PARA QTD PESSOAS POR NIVEL + PORCENTAGEM DO TOTAL
		LabelNivel1.setText("NÍVEL DE PRIORIDADE 1:  " + prior1 + " PESSOA(S) " + "(" + porcniv1 + "%)");
		LabelNivel2.setText("NÍVEL DE PRIORIDADE 2:  " + prior2 + " PESSOA(S) " + "(" + porcniv2 + "%)");
		LabelNivel3.setText("NÍVEL DE PRIORIDADE 3:  " + prior3 + " PESSOA(S) " + "(" + porcniv3 + "%)");
		LabelNivel4.setText("NÍVEL DE PRIORIDADE 4:  " + prior4 + " PESSOA(S) " + "(" + porcniv4 + "%)");
		// TEXTO TOTAL PESSOAS VACINADAS
		LabelTotal.setText("TOTAL VACINADOS NO PERÍODO: " + x);
		LabelNivel1.setVisible(true);
		LabelNivel2.setVisible(true);
		LabelNivel3.setVisible(true);
		LabelNivel4.setVisible(true);
		LabelTotal.setVisible(true);
	}

	public void gerarRelatorio() {
		// PADROES DE DATA BR & SQL
		SimpleDateFormat formatBR = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatSQL = new SimpleDateFormat("yyyy-MM-dd");

		try {
			// PEGANDO A STRING DIGITADA PELO USUARIO E TRANSFORMANDO EM DATE
			Date inipadBR = formatBR.parse(txtDataIncial.getText());
			Date finpadBR = formatBR.parse(txtDataFinal.getText());

			// TRANSFORMANDO A DATA ACIMA EM STRING NO PADRAO SQL
			dataInicial = formatSQL.format(inipadBR);
			dataFinal = formatSQL.format(finpadBR);

			readLista();
		} catch (ParseException ex) {
			Logger.getLogger(TelaGerarRelatorio.class.getName()).log(Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(null, "Favor digitar a data inicial e final.\nFormato: dd/MM/yyyy",
					"Campo Vazio", JOptionPane.WARNING_MESSAGE);
		}
	}

	private void setIcon() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(TelaGerarRelatorio.class.getResource("/Interface/Imagens/BarraDeMenu/iconeSESCOVID.png")));
	}
}
