package tsi.too.bvb.gui.cliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import tsi.too.bvb.entidades.cliente.Cliente;

public class PainelConfCadCliente extends JPanel implements PainelCliente {
	/**
	 * 
	 */
	private static final long serialVersionUID = -402474443606626152L;
	private JEditorPane dadosEditorPane;

	/**
	 * Create the panel.
	 */
	public PainelConfCadCliente() {
		setLayout(null);
		
		JPanel panelDadosCliente = new JPanel();
		panelDadosCliente.setLayout(null);
		panelDadosCliente.setBorder(new TitledBorder(null, "Dados do Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		panelDadosCliente.setBounds(10, 11, 497, 274);
		add(panelDadosCliente);
		
		JScrollPane dadosScrollPane = new JScrollPane();
		dadosScrollPane.setBounds(10, 20, 477, 243);
		panelDadosCliente.add(dadosScrollPane);
		
		dadosEditorPane = new JEditorPane();
		dadosEditorPane.setForeground(Color.BLACK);
		dadosEditorPane.setBackground(Color.WHITE);
		dadosScrollPane.setViewportView(dadosEditorPane);
		dadosEditorPane.setFont(new Font("Arial", Font.BOLD, 14));
		dadosEditorPane.setToolTipText("este campo exibe os dados inseridos nas janelas anteriores");
		dadosEditorPane.setEditable(false);
	}

	public void setDadosEditorPane(String dadosDoCliente) {
		this.dadosEditorPane.setText(dadosDoCliente);
	}

	@Override
	public void limpaCampos() {}

	@Override
	public void salvarCampos(Cliente cliente) {}

	@Override
	public boolean validarCampos() {
		return false;
	}
} // PainelConfCadCliente
