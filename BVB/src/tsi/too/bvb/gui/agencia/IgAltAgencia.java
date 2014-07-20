package tsi.too.bvb.gui.agencia;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
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
import tsi.too.bvb.eventos.agencia.TEActionAlterarAgencia;
import tsi.too.bvb.validacoes.ValidarDados;

/** Classe que define a GUI de alteração de agência do sistema BVB
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see JDialog
 */
public class IgAltAgencia extends JDialog {

	/**
	 * @serial
	 */
	private static final long serialVersionUID = 6695376766095791027L;
	
	private Agencia agencia;
	
	private JPanel contentPane;
	private JButton btnFinalizar;
	private JTextField descricaoTextField;
	private JButton btnEditarDescricao;
	private JLabel lblCamposErrados;
	private JTextField codigoTextField;

	/** Cria uma instância da janela de alteração de agência do sistema BVB
	 * @param agencia <code>Agencia</code> com os dados da agência que será alterada
	 * @param point <code>Point</code> com as coordenadas de onde a caixa de diálogo <code>IgAltAgencia</code> se localizará
	 * 
	 * @see Agencia
	 * @see Point
	 */	
	public IgAltAgencia(Agencia agencia, Point point) {
		this.agencia = agencia;
		setModal(true);
		Color pumpkin = new Color(211, 84, 0);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("BVB - Altera\u00E7\u00E3o de Ag\u00EAncia");
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
		txtpnSubTitulo.setText("Insira a nova descri\u00E7\u00E3o da ag\u00EAncia");
		txtpnSubTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnSubTitulo.setBounds(20, 36, 200, 22);
		contentPane.add(txtpnSubTitulo);
		
		JTextPane txtpnTitulo = new JTextPane();
		txtpnTitulo.setEditable(false);
		txtpnTitulo.setForeground(Color.WHITE);
		txtpnTitulo.setBackground(pumpkin);
		txtpnTitulo.setText("Altera\u00E7\u00E3o de Ag\u00EAncia");
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
		btnFinalizar.addActionListener(new TEActionAlterarAgencia(this));
		btnFinalizar.setMnemonic(KeyEvent.VK_F);
		Btnpanel.add(btnFinalizar);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setBounds(10, 125, 75, 14);
		contentPane.add(lblDescricao);
		lblDescricao.setDisplayedMnemonic(KeyEvent.VK_D);
		
		descricaoTextField = new JTextField();
		lblDescricao.setLabelFor(descricaoTextField);
		descricaoTextField.setToolTipText("este campo n\u00E3o pode ficar vazio");
		descricaoTextField.setBounds(100, 123, 308, 20);
		contentPane.add(descricaoTextField);
		descricaoTextField.setColumns(10);
		
		descricaoTextField.setText(agencia.getDescricao());
		btnEditarDescricao = new JButton("Editar");
		btnEditarDescricao.setMnemonic(KeyEvent.VK_E);
		btnEditarDescricao.addActionListener(new TEActionAlterarAgencia(this));
		btnEditarDescricao.setBounds(418, 121, 89, 23);
		contentPane.add(btnEditarDescricao);
		
		lblCamposErrados = new JLabel("* O campo destacado de vermelho n\u00E3o foi preenchido corretamente!");
		lblCamposErrados.setVisible(false);
		lblCamposErrados.setForeground(Color.RED);
		lblCamposErrados.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCamposErrados.setBounds(10, 171, 497, 14);
		contentPane.add(lblCamposErrados);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setDisplayedMnemonic(KeyEvent.VK_C);
		lblCodigo.setBounds(10, 95, 60, 14);
		contentPane.add(lblCodigo);
		
		codigoTextField = new JTextField();
		codigoTextField.setEditable(false);
		codigoTextField.setText(Integer.toString(agencia.getCodAgencia()));
		lblCodigo.setLabelFor(codigoTextField);
		codigoTextField.setToolTipText("este campo n\u00E3o pode ser alterado");
		codigoTextField.setColumns(10);
		codigoTextField.setBounds(100, 92, 308, 20);
		contentPane.add(codigoTextField);
		
		Point localPoint = new Point(point);
		localPoint.x += 275;
		
		setLocation(localPoint);
		setVisible(true);
	}
	
	/** Verifica se o campo descrição da janela <code>IgAltAgencia</code> foi preenchido corretamente. Se o campo 
	 * estiver errado, receberá uma borda vermelha
	 *  @return <code>boolean</code> com <code>true</code> caso o campo descrição tenha sido preenchido corretamente, 
	 *  e <code>false</code> caso contrário
	 */
	public boolean validarDescricao() {
		if(!ValidarDados.validarVazio(descricaoTextField.getText())) {
			descricaoTextField.setBorder(new LineBorder(Color.RED));
			
			return false;
		}
		else descricaoTextField.setBorder(UIManager.getBorder("TextField.border"));
		
		return true;
	}
	
	/** Insere a borda padrão do campo descrição da janela <code>IgAltAgencia</code>
	 */
	public void inserirBordaPadrao() {
		descricaoTextField.setBorder(UIManager.getBorder("TextField.border"));
	}
	
	/** Retorna um <code>JButton</code> com o botão finalizar
	 * @return <code>JButton</code> com o botão finalizar
	 */
	public JButton getBtnFinalizar() {
		return btnFinalizar;
	}
	
	/** Retorna um <code>JTextField</code> com o campo de texto descrição
	 * @return <code>JTextField</code> com o campo de texto descrição
	 */
	public JTextField getDescricaoTextField() {
		return descricaoTextField;
	}
	
	/** Retorna um <code>JButton</code> com o botão editar descrição
	 * @return <code>JButton</code> com o botão editar descrição
	 */
	public JButton getBtnEditarDescricao() {
		return btnEditarDescricao;
	}
	
	/** Retorna uma <code>Agencia</code> com os dados da agência que pode ter sido alterada
	 * @return <code>Agencia</code> com os dados da agência que pode ter sido alterada
	 */
	public Agencia getAgencia() {
		return agencia;
	}
	
	/** Muda a visibilidade do rótulo que indica que algum campo não foi corretamente preenchido
	 * @param visivel <code>boolean</code> com <code>true</code> se for visível e <code>false</code> caso contrário
	 */
	public void setLblCamposErrados(boolean visivel) {
		this.lblCamposErrados.setVisible(visivel);
	}
	
} // class IgCadAgencia
