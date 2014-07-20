package tsi.too.bvb.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import tsi.too.bvb.gui.cliente.IgCadCliente;
import tsi.too.bvb.gui.contabancaria.IgAbrirContaBancaria;
import tsi.too.bvb.gui.contabancaria.IgCriarAplicacao;

/** Classe que define o painel confirmação utilizado pelas janelas <code>IgCadCliente</code>, 
 * <code>IgAbrirContaBancaria</code> e <code>IgCriarAplicacao</code>
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see JPanel
 * @see IgCadCliente
 * @see IgAbrirContaBancaria
 * @see IgCriarAplicacao
 * @see TratadorDeCampos
 */
public class PainelConfCad extends JPanel implements TratadorDeCampos {
	
	/**
	 * @serial
	 */
	private static final long serialVersionUID = -402474443606626152L;
	
	private JEditorPane dadosEditorPane;

	/** Cria uma instância do painel confirmação utilizado pelas janelas <code>IgCadCliente</code>, 
	 * <code>IgAbrirContaBancaria</code> e <code>IgCriarAplicacao</code>
	 * @param tituloDaBorda <code>String</code> referênte ao título da borda do campo de texto dados
	 */
	public PainelConfCad(String tituloDaBorda) {
		setLayout(null);
		
		JPanel panelDadosCliente = new JPanel();
		panelDadosCliente.setLayout(null);
		panelDadosCliente.setBorder(new TitledBorder(null, tituloDaBorda, TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		panelDadosCliente.setBounds(10, 11, 497, 274);
		add(panelDadosCliente);
		
		JScrollPane dadosScrollPane = new JScrollPane();
		dadosScrollPane.setBorder(null);
		dadosScrollPane.setBounds(10, 20, 477, 243);
		panelDadosCliente.add(dadosScrollPane);
		
		dadosEditorPane = new JEditorPane();
		dadosEditorPane.setForeground(Color.BLACK);
		dadosEditorPane.setBackground(new Color(238, 238, 238));
		dadosScrollPane.setViewportView(dadosEditorPane);
		dadosEditorPane.setFont(new Font("Arial", Font.BOLD, 14));
		dadosEditorPane.setToolTipText("este campo exibe os dados inseridos nas janelas anteriores");
		dadosEditorPane.setEditable(false);
	}

	/* (non-Javadoc)
	 * @see TratadorDeCampos
	 */
	@Override
	public void limparCampos() {}

	/* (non-Javadoc)
	 * @see TratadorDeCampos
	 */
	@Override
	public void salvarCampos(Object cliente) {}

	/* (non-Javadoc)
	 * @see TratadorDeCampos
	 */
	@Override
	public boolean validarCampos() {
		return false;
	}

	/* (non-Javadoc)
	 * @see TratadorDeCampos
	 */
	@Override
	public void inserirBordasPadrao() {}
	
	/** Muda o campo de texto dados
	 * @param dadosDoCliente <code>String</code> com os novos dados do campo
	 */
	public void setDadosEditorPane(String dadosDoCliente) {
		this.dadosEditorPane.setText(dadosDoCliente);
	}
	
} // PainelConfCadCliente
