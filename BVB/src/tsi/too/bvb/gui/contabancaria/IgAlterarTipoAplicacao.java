package tsi.too.bvb.gui.contabancaria;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

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

import tsi.too.bvb.entidades.contabancaria.ContaBancaria;
import tsi.too.bvb.eventos.contabancaria.TEActionAlterarTipoAP;

/** Classe que define a GUI de alteração de aplicação do sistema BVB
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see JDialog
 */
public class IgAlterarTipoAplicacao extends JDialog {

	/**
	 * @serial
	 */
	private static final long serialVersionUID = 7929634524170684414L;
	
	private JPanel contentPane = new JPanel();
	private JButton btnCancelar;
	private JButton btnAtualizar;
	private JTextPane txtpnSubTitulo;
	private JTextField numContaTextField;
	private JButton btnBuscar;
	private JButton btnAlterar;
	
	private ContaBancaria contaBancaria = new ContaBancaria();
	private JTextField saldoTextField;

	/** Cria uma instância da janela de alteração de aplicação do sistema BVB
	 * @param janelaPai <code>Window</code> com a janela pai da caixa de diálogo <code>IgAlterarTipoAplicacao</code>
	 * 
	 * @see Window
	 */	
	public IgAlterarTipoAplicacao(Window janelaPai) {
		setModal(true);
		Color turquoise = new Color(26, 188, 156);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("BVB - Altera\u00E7\u00E3o do Tipo da Aplica\u00E7\u00E3o");
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
		txtpnSubTitulo.setText("Insira o n\u00FAmero da conta BVB FIF Pr\u00E1tico na qual ser\u00E1 realizada a altera\u00E7\u00E3o.");
		txtpnSubTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnSubTitulo.setBounds(20, 36, 430, 22);
		contentPane.add(txtpnSubTitulo);
		
		JTextPane txtpnTitulo = new JTextPane();
		txtpnTitulo.setEditable(false);
		txtpnTitulo.setForeground(Color.WHITE);
		txtpnTitulo.setBackground(turquoise);
		txtpnTitulo.setText("Altera\u00E7\u00E3o do Tipo da Aplica\u00E7\u00E3o");
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
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new TEActionAlterarTipoAP(this));
		btnAtualizar.setEnabled(false);
		btnAtualizar.setMnemonic(KeyEvent.VK_A);
		Btnpanel.add(btnAtualizar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IgAlterarTipoAplicacao.this.dispose();
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
		numContaTextField.setToolTipText("insira o n\u00FAmero da conta bvb fif pr\u00E1tico na qual deseja realizar a altera\u00E7\u00E3o de tipo, e clique em buscar");
		lblNmeroDaConta.setLabelFor(numContaTextField);
		numContaTextField.setBounds(130, 92, 269, 20);
		contentPane.add(numContaTextField);
		numContaTextField.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new TEActionAlterarTipoAP(this));
		btnBuscar.setMnemonic(KeyEvent.VK_B);
		btnBuscar.setBounds(418, 91, 89, 23);
		contentPane.add(btnBuscar);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new TEActionAlterarTipoAP(this));
		btnAlterar.setMnemonic(KeyEvent.VK_A);
		btnAlterar.setBounds(418, 91, 89, 23);
		contentPane.add(btnAlterar);
		
		JLabel lblSaldo = new JLabel("Saldo:");
		lblSaldo.setDisplayedMnemonic(KeyEvent.VK_S);
		lblSaldo.setBounds(10, 125, 75, 14);
		contentPane.add(lblSaldo);
		
		saldoTextField = new JTextField();
		saldoTextField.setEditable(false);
		saldoTextField.setToolTipText("o saldo da conta bvb fif pr\u00E1tico precisa ser igual ou superior a R$ 15.000,00 para poder ser atualizada para bvb fif executivo");
		saldoTextField.setText("R$");
		lblSaldo.setLabelFor(saldoTextField);
		saldoTextField.setBounds(130, 122, 269, 20);
		contentPane.add(saldoTextField);
		saldoTextField.setColumns(10);
		
		setLocationRelativeTo(janelaPai);
		setVisible(true);
	}
	
	/** Exibe as opções de atualizar tipo da aplicação da janela <code>IgAlterarTipoAplicacao</code>
	 */
	public void exibeOpcoesAtualizar() {
		btnAtualizar.setEnabled(true);
		btnBuscar.setVisible(false);
		btnAlterar.setVisible(true);
	}
	
	/** Esconde as opções de atualizar tipo da aplicação da janela <code>IgAlterarTipoAplicacao</code>
	 */
	public void escondeOpcoesAtualizar() {
		btnAtualizar.setEnabled(false);
		btnBuscar.setVisible(true);
		btnAlterar.setVisible(false);
		saldoTextField.setText("R$");
		numContaTextField.setText("");
	}

	/** Retorna uma <code>ContaBancaria</code> com os dados da conta bancária que pode ter sido alterado
	 * @return <code>ContaBancaria</code> com os dados da conta bancária que pode ter sido alterado
	 */
	public ContaBancaria getContaBancaria() {
		return contaBancaria;
	}

	/** Muda o objeto conta bancária
	 * @param contaBancaria <code>ContaBancaria</code> com o novo objeto conta bancária
	 */
	public void setContaBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	/** Retorna um <code>JButton</code> com o botão atualizar
	 * @return <code>JButton</code> com o botão atualizar
	 */
	public JButton getBtnAtualizar() {
		return btnAtualizar;
	}

	/** Retorna um <code>JButton</code> com o botão buscar
	 * @return <code>JButton</code> com o botão buscar
	 */
	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	/** Retorna um <code>JButton</code> com o botão alterar
	 * @return <code>JButton</code> com o botão alterar
	 */
	public JButton getBtnAlterar() {
		return btnAlterar;
	}

	/** Retorna um <code>JTextField</code> com o campo de texto número da conta
	 * @return <code>JTextField</code> com o campo de texto número da conta
	 */
	public JTextField getNumContaTextField() {
		return numContaTextField;
	}

	/** Retorna um <code>JTextField</code> com o campo de texto saldo
	 * @return <code>JTextField</code> com o campo de texto saldo
	 */
	public JTextField getSaldoTextField() {
		return saldoTextField;
	}

	/** Muda o campo de texto do saldo
	 * @param saldo <code>String</code> com o novo saldo do campo
	 */
	public void setSaldoTextField(String saldo) {
		this.saldoTextField.setText("R$" + saldo);
	}

} // class IgAlterarTipoAplicacao
