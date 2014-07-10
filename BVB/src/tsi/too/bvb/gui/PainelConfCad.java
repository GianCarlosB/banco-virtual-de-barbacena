package tsi.too.bvb.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

public class PainelConfCad extends JPanel implements TratadorDeCampos {
	/**
	 * 
	 */
	private static final long serialVersionUID = -402474443606626152L;
	private JEditorPane dadosEditorPane;

	/**
	 * Create the panel.
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

	public void setDadosEditorPane(String dadosDoCliente) {
		this.dadosEditorPane.setText(dadosDoCliente);
	}

	@Override
	public void limparCampos() {}

	@Override
	public void salvarCampos(Object cliente) {}

	@Override
	public boolean validarCampos() {
		return false;
	}

	@Override
	public void inserirBordasPadrao() {}
} // PainelConfCadCliente
