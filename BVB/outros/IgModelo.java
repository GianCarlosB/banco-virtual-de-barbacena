package tsi.too.bvb.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JTextPane;
import java.awt.Font;

public class IgConfirmacao extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IgConfirmacao dialog = new IgConfirmacao();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IgConfirmacao() {
		setResizable(false);
		setTitle("Novo Cadastro de Cliente");
		setBounds(100, 100, 523, 506);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextPane txtpnSubTitulo = new JTextPane();
		txtpnSubTitulo.setText("Confirme os dados do novo cliente.");
		txtpnSubTitulo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtpnSubTitulo.setBounds(20, 37, 210, 22);
		contentPanel.add(txtpnSubTitulo);
		
		JTextPane txtpnTitulo = new JTextPane();
		txtpnTitulo.setText("Cadastro de Cliente");
		txtpnTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnTitulo.setBounds(10, 11, 150, 22);
		contentPanel.add(txtpnTitulo);
		
		JLabel lblImg = new JLabel("Label Img");
		lblImg.setIcon(new ImageIcon("src\\tsi\\too\\bvb\\recursos\\imagens\\user_add.png"));
		lblImg.setBounds(459, 11, 48, 48);
		contentPanel.add(lblImg);
		
		JEditorPane dtrpnCampoTitulo = new JEditorPane();
		dtrpnCampoTitulo.setEditable(false);
		dtrpnCampoTitulo.setBounds(0, 0, 517, 70);
		contentPanel.add(dtrpnCampoTitulo);
		
		JSeparator separatorTitulo = new JSeparator();
		separatorTitulo.setBounds(0, 71, 517, 4);
		contentPanel.add(separatorTitulo);
		
		JSeparator separatorBtn = new JSeparator();
		separatorBtn.setBounds(0, 424, 517, 4);
		contentPanel.add(separatorBtn);
		
		JLabel label = new JLabel("Progresso do Cadastro:");
		label.setBounds(20, 399, 140, 14);
		contentPanel.add(label);
		
		JProgressBar progressBar = new JProgressBar();
		label.setLabelFor(progressBar);
		progressBar.setValue(100);
		progressBar.setStringPainted(true);
		progressBar.setBounds(170, 399, 238, 14);
		contentPanel.add(progressBar);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnAnterior = new JButton("< Anterior");
			btnAnterior.setMnemonic(KeyEvent.VK_A);
			buttonPane.add(btnAnterior);
			{
				JButton btnProximo = new JButton("Pr\u00F3ximo >");
				btnProximo.setMnemonic(KeyEvent.VK_P);
				btnProximo.setActionCommand("OK");
				buttonPane.add(btnProximo);
			}
			{
				JButton btnLimpar = new JButton("Limpar");
				btnLimpar.setMnemonic(KeyEvent.VK_L);
				buttonPane.add(btnLimpar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setMnemonic(KeyEvent.VK_C);
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
}
