package tsi.too.bvb.gui.contabancaria;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import tsi.too.bvb.entidades.JNumberFormatField;
import tsi.too.bvb.entidades.contabancaria.ContaBancaria;
import tsi.too.bvb.eventos.contabancaria.TEActionDepositarSal;

public class IgDepositarSal extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6436257862267205473L;
		
	private JPanel contentPane = new JPanel();
	private JButton btnCancelar;
	private JButton btnDepositar;
	private JTextPane txtpnSubTitulo;
	private JTextField numContaTextField;
	private JNumberFormatField depositoTextField;
	private JButton btnBuscar;
	private JButton btnAlterar;
	
	private ContaBancaria contaBancaria = new ContaBancaria();

	/**
	 * Create the frame.
	 */
	public IgDepositarSal(Window janelaPai) {
		setModal(true);
		Color turquoise = new Color(26, 188, 156);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("BVB - Dep\u00F3sito de Sal\u00E1rio");
		setBounds(100, 100, 523, (int)(506 * 0.55));
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separatorTitulo = new JSeparator();
		separatorTitulo.setBounds(0, 69, 517, 2);
		contentPane.add(separatorTitulo);
		
		txtpnSubTitulo = new JTextPane();
		txtpnSubTitulo.setEditable(false);
		txtpnSubTitulo.setForeground(Color.WHITE);
		txtpnSubTitulo.setBackground(turquoise);
		txtpnSubTitulo.setText("Insira o n\u00FAmero da conta sal\u00E1rio na qual ser\u00E1 realizado o dep\u00F3sito.");
		txtpnSubTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnSubTitulo.setBounds(20, 36, 390, 22);
		contentPane.add(txtpnSubTitulo);
		
		JTextPane txtpnTitulo = new JTextPane();
		txtpnTitulo.setEditable(false);
		txtpnTitulo.setForeground(Color.WHITE);
		txtpnTitulo.setBackground(turquoise);
		txtpnTitulo.setText("Dep\u00F3sito de Sal\u00E1rio");
		txtpnTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnTitulo.setBounds(10, 11, 270, 22);
		contentPane.add(txtpnTitulo);
		
		JLabel lblImg = new JLabel("Label Img");
		lblImg.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		lblImg.setIcon(new ImageIcon(IgAbrirContaBancaria.class.getResource("/tsi/too/bvb/recursos/imagens/Payment-01-48.png")));
		lblImg.setBounds(459, 11, 48, 48);
		contentPane.add(lblImg);
		
		JPanel Btnpanel = new JPanel();
		Btnpanel.setBounds(0, 207, 517, 43);
		contentPane.add(Btnpanel);
		Btnpanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		btnDepositar = new JButton("Depositar");
		btnDepositar.addActionListener(new TEActionDepositarSal(this));
		btnDepositar.setEnabled(false);
		btnDepositar.setMnemonic(KeyEvent.VK_D);
		Btnpanel.add(btnDepositar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IgDepositarSal.this.dispose();
			}
		});
		btnCancelar.setMnemonic(KeyEvent.VK_C);
		Btnpanel.add(btnCancelar);
		
		JEditorPane dtrpnCampoTitulo = new JEditorPane();
		dtrpnCampoTitulo.setBackground(turquoise);
		dtrpnCampoTitulo.setEditable(false);
		dtrpnCampoTitulo.setBounds(0, 0, 517, 70);
		contentPane.add(dtrpnCampoTitulo);
		
		JSeparator separatorBtn = new JSeparator();
		separatorBtn.setBounds(0, 196, 517, 2);
		contentPane.add(separatorBtn);
		
		JLabel lblNmeroDaConta = new JLabel("N\u00FAmero da Conta:");
		lblNmeroDaConta.setDisplayedMnemonic(KeyEvent.VK_N);
		lblNmeroDaConta.setBounds(10, 95, 115, 14);
		contentPane.add(lblNmeroDaConta);
		
		numContaTextField = new JTextField();
		numContaTextField.setToolTipText("insira o n\u00FAmero da conta sal\u00E1rio na qual deseja realizar o dep\u00F3sito do sal\u00E1rio, e clique em buscar");
		lblNmeroDaConta.setLabelFor(numContaTextField);
		numContaTextField.setBounds(130, 92, 269, 20);
		contentPane.add(numContaTextField);
		numContaTextField.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new TEActionDepositarSal(this));
		btnBuscar.setMnemonic(KeyEvent.VK_B);
		btnBuscar.setBounds(418, 91, 89, 23);
		contentPane.add(btnBuscar);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setVisible(false);
		btnAlterar.addActionListener(new TEActionDepositarSal(this));
		btnAlterar.setMnemonic(KeyEvent.VK_A);
		btnAlterar.setBounds(418, 91, 89, 23);
		contentPane.add(btnAlterar);
		
		JLabel lblDeposito = new JLabel("Dep\u00F3sito:");
		lblDeposito.setDisplayedMnemonic(KeyEvent.VK_S);
		lblDeposito.setBounds(10, 125, 75, 14);
		contentPane.add(lblDeposito);
		
		depositoTextField = new JNumberFormatField(new DecimalFormat("R$0.00"));
		depositoTextField.setEnabled(false);
		lblDeposito.setLabelFor(depositoTextField);
		depositoTextField.setToolTipText("este campo \u00E9 de preenchimento obrigat\u00F3rio e deve conter apenas d\u00EDgitos decimais");
		((JNumberFormatField) depositoTextField).setLimit(17);
		depositoTextField.setColumns(10);
		depositoTextField.setBounds(130, 122, 269, 20);
		contentPane.add(depositoTextField);
		
		setLocationRelativeTo(janelaPai);
		setVisible(true);
	}
	
	public void exibeOpcoesDepositar() {
		btnDepositar.setEnabled(true);
		btnBuscar.setVisible(false);
		btnAlterar.setVisible(true);
		depositoTextField.setEnabled(true);
	}
	
	public void escondeOpcoesDepositar() {
		btnDepositar.setEnabled(false);
		btnBuscar.setVisible(true);
		btnAlterar.setVisible(false);
		depositoTextField.setEnabled(false);
		depositoTextField.setText("");
		numContaTextField.setText("");
	}

	public ContaBancaria getContaBancaria() {
		return contaBancaria;
	}

	public void setContaBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}
	
	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JButton getBtnDepositar() {
		return btnDepositar;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JButton getBtnAlterar() {
		return btnAlterar;
	}

	public void setNumContaTextField(String numConta) {
		this.numContaTextField.setText(numConta);
	}

	public JTextField getNumContaTextField() {
		return numContaTextField;
	}

	public void setDepositoTextField(String deposito) {
		this.depositoTextField.setText(deposito);
	}

	public JNumberFormatField getDepositoTextField() {
		return depositoTextField;
	}
	
} // class IgDepositarSal
