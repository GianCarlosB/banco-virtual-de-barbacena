package tsi.too.bvb.gui.agencia;

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
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import tsi.too.bvb.entidades.agencia.Agencia;
import tsi.too.bvb.eventos.agencia.TEActionCadastrarAgencia;
import tsi.too.bvb.gui.TratadorDeCampos;
import tsi.too.bvb.validacoes.ValidarDados;

/** Classe que define a GUI de cadastro de agência do sistema BVB
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see JDialog
 * @see TratadorDeCampos
 */
public class IgCadAgencia extends JDialog implements TratadorDeCampos {

	/**
	 * @serial
	 */
	private static final long serialVersionUID = -3879979808799859918L;
	
	private JPanel contentPane;
	private JTextField codigoTextField;
	private JButton btnFinalizar;
	private JButton btnLimpar;
	private JButton btnCancelar;
	private JLabel lblCamposErrados;
	private JTextField descricaoTextField;

	/** Cria uma instância da janela de cadastro de agência do sistema BVB
	 * @param janelaPai <code>Window</code> com a janela pai da caixa de diálogo <code>IgCadAgencia</code>
	 * @param agencia <code>Agencia</code> referênte ao objeto onde os dados serão salvos
	 * 
	 * @see Window
	 * @see Agencia
	 */	
	public IgCadAgencia(Window janelaPai, Agencia agencia) {
		setModal(true);
		Color pumpkin = new Color(211, 84, 0);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("BVB - Cadastro de Ag\u00EAncia");
		setBounds(100, 100, 523, (int)(506 * 0.55));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separatorTitulo = new JSeparator();
		separatorTitulo.setBounds(0, 69, 517, 2);
		contentPane.add(separatorTitulo);
		
		JSeparator separatorBtn = new JSeparator();
		separatorBtn.setBounds(0, 196, 517, 2);
		contentPane.add(separatorBtn);
		
		JLabel lblImg = new JLabel("Label Img");
		lblImg.setBorder(new LineBorder(Color.WHITE, 1, true));
		lblImg.setIcon(new ImageIcon(IgCadAgencia.class.getResource("/tsi/too/bvb/recursos/imagens/Building-48.png")));
		lblImg.setBounds(459, 11, 48, 48);
		contentPane.add(lblImg);
		
		JTextPane txtpnSubTitulo = new JTextPane();
		txtpnSubTitulo.setEditable(false);
		txtpnSubTitulo.setForeground(Color.WHITE);
		txtpnSubTitulo.setBackground(pumpkin);
		txtpnSubTitulo.setText("Insera a descri\u00E7\u00E3o da nova ag\u00EAncia.");
		txtpnSubTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnSubTitulo.setBounds(20, 36, 260, 22);
		contentPane.add(txtpnSubTitulo);
		
		JTextPane txtpnTitulo = new JTextPane();
		txtpnTitulo.setEditable(false);
		txtpnTitulo.setForeground(Color.WHITE);
		txtpnTitulo.setBackground(pumpkin);
		txtpnTitulo.setText("Cadastro de Ag\u00EAncia");
		txtpnTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnTitulo.setBounds(10, 11, 150, 22);
		contentPane.add(txtpnTitulo);
		
		JEditorPane dtrpnCampoTitulo = new JEditorPane();
		dtrpnCampoTitulo.setBackground(pumpkin);
		dtrpnCampoTitulo.setEditable(false);
		dtrpnCampoTitulo.setBounds(0, 0, 517, 70);
		contentPane.add(dtrpnCampoTitulo);
		
		JPanel Btnpanel = new JPanel();
		Btnpanel.setBounds(0, 207, 517, 43);
		contentPane.add(Btnpanel);
		Btnpanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new TEActionCadastrarAgencia(this, agencia));
		btnFinalizar.setMnemonic(KeyEvent.VK_F);
		Btnpanel.add(btnFinalizar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new TEActionCadastrarAgencia(this, agencia));
		btnLimpar.setMnemonic(KeyEvent.VK_L);
		Btnpanel.add(btnLimpar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IgCadAgencia.this.dispose();
			}
		});
		btnCancelar.setMnemonic(KeyEvent.VK_C);
		Btnpanel.add(btnCancelar);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setDisplayedMnemonic(KeyEvent.VK_O);
		lblCodigo.setBounds(10, 95, 60, 14);
		contentPane.add(lblCodigo);
		
		codigoTextField = new JTextField();
		codigoTextField.setEditable(false);
		codigoTextField.setToolTipText("este campo \u00E9 gerado automaticamente");
		lblCodigo.setLabelFor(codigoTextField);
		codigoTextField.setText("XXXX");
		codigoTextField.setColumns(10);
		codigoTextField.setBounds(100, 92, 308, 20);
		contentPane.add(codigoTextField);
		
		lblCamposErrados = new JLabel("* Os campos destacados de vermelho n\u00E3o foram preenchidos corretamente!");
		lblCamposErrados.setVisible(false);
		lblCamposErrados.setForeground(Color.RED);
		lblCamposErrados.setBounds(10, 171, 497, 14);
		contentPane.add(lblCamposErrados);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setBounds(10, 125, 75, 14);
		contentPane.add(lblDescricao);
		lblDescricao.setDisplayedMnemonic(KeyEvent.VK_D);
		
		descricaoTextField = new JTextField();
		descricaoTextField.setToolTipText("este campo \u00E9 de preenchimento obrigat\u00F3rio");
		lblDescricao.setLabelFor(descricaoTextField);
		descricaoTextField.setBounds(100, 123, 308, 20);
		contentPane.add(descricaoTextField);
		descricaoTextField.setColumns(10);
		
		setLocationRelativeTo(janelaPai);
		setVisible(true);
	}
	
	/** Limpa os campos da janela
	 */
	@Override
	public void limparCampos() {
		inserirBordasPadrao();
		
		descricaoTextField.setText("");
	}

	/** Salva os dados inseridos na janela em um objeto do tipo <code>Agencia</code>
	 * @param agencia <code>Object</code> referênte ao objeto que será salvo
	 */
	@Override
	public void salvarCampos(Object agencia) {
		((Agencia) agencia).setDescricao(descricaoTextField.getText());
	}

	/** Verifica se os campos da janela foram preenchidos corretamente. Os campos errados 
	 * recebem uma borda vermelha
	 *  @return <code>boolean</code> com <code>true</code> caso todos os campos tenham sido preenchidos corretamente, 
	 *  e <code>false</code> caso contrário
	 */
	@Override
	public boolean validarCampos() {
		if(!ValidarDados.validarVazio(descricaoTextField.getText())) {
			setLblCamposErrados(true);
			descricaoTextField.setBorder(new LineBorder(Color.RED));
			
			return false;
		}
		else descricaoTextField.setBorder(UIManager.getBorder("TextField.border"));
		
		return true;
	}

	/** Insere a borda padrão nos campos da janela
	 */
	@Override
	public void inserirBordasPadrao() {
		descricaoTextField.setBorder(UIManager.getBorder("TextField.border"));
	}
	
	/** Retorna um <code>JButton</code> com o botão finalizar
	 * @return <code>JButton</code> com o botão finalizar
	 */
	public JButton getBtnFinalizar() {
		return btnFinalizar;
	}

	/** Retorna um <code>JButton</code> com o botão limpar
	 * @return <code>JButton</code> com o botão limpar
	 */
	public JButton getBtnLimpar() {
		return btnLimpar;
	}

	/** Muda o campo de texto código
	 * @param codAgencia <code>String</code> com o novo código do campo
	 */
	public void setCodigoTextField(String codAgencia) {
		this.codigoTextField.setText(codAgencia);
	}

	/** Retorna um <code>JTextField</code> com o campo de texto descrição
	 * @return <code>JTextField</code> com o campo de texto descrição
	 */
	public JTextField getDescricaoTextField() {
		return descricaoTextField;
	}

	/** Muda a visibilidade do rótulo que indica que algum campo não foi corretamente preenchido
	 * @param visivel <code>boolean</code> com <code>true</code> se for visível e <code>false</code> caso contrário
	 */
	public void setLblCamposErrados(boolean visivel) {
		this.lblCamposErrados.setVisible(visivel);
	}

} // class IgCadAgencia
