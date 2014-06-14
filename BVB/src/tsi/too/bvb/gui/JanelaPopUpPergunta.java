package tsi.too.bvb.gui;

import java.awt.BorderLayout;
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
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class JanelaPopUpPergunta extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -312438604748532205L;
	
	private final JPanel contentPanel = new JPanel();
	private boolean sim;
	private JButton simButton;
	private JButton naoButton;
	
	/**
	 * Create the dialog.
	 */
	public JanelaPopUpPergunta(Window janelaPai, String titulo, String msgPergunta) {
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		
		setTitle(titulo);
		setBounds(100, 100, 450, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(39, 174, 96));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JSeparator separatorBtn = new JSeparator();
		separatorBtn.setBounds(0, 126, 444, 2);
		contentPanel.add(separatorBtn);
		
		JLabel lblImg = new JLabel("img");
		lblImg.setIcon(new ImageIcon("src\\tsi\\too\\bvb\\recursos\\imagens\\question3.png"));
		lblImg.setBounds(402, 26, 32, 32);
		contentPanel.add(lblImg);
		
		JEditorPane msgEditorPane = new JEditorPane();
		msgEditorPane.setEditable(false);
		msgEditorPane.setForeground(new Color(236, 240, 241));
		msgEditorPane.setFont(new Font("Calibri", Font.BOLD, 14));
		msgEditorPane.setText(msgPergunta);
		msgEditorPane.setBackground(new Color(39, 174, 96));
		msgEditorPane.setBorder(new TitledBorder(new LineBorder(new Color(236, 240, 241), 1, true), "PERGUNTA", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(236, 240, 241)));
		msgEditorPane.setBounds(10, 11, 382, 104);
		contentPanel.add(msgEditorPane);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(39, 174, 96));
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				simButton = new JButton("Sim");
				simButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						sim = true; JanelaPopUpPergunta.this.dispose();
					}
				});
				simButton.setBackground(new Color(39, 174, 96));
				simButton.setMnemonic(KeyEvent.VK_S);
				simButton.setActionCommand("SIM");
				buttonPane.add(simButton);
				getRootPane().setDefaultButton(simButton);
			}
			
			naoButton = new JButton("N\u00E3o");
			naoButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sim = false; JanelaPopUpPergunta.this.dispose();
				}
			});
			naoButton.setMnemonic(KeyEvent.VK_N);
			naoButton.setBackground(new Color(39, 174, 96));
			naoButton.setActionCommand("NAO");
			buttonPane.add(naoButton);
		}
		
		JanelaPopUpPergunta.this.setLocationRelativeTo(janelaPai);
		setVisible(true);
	}
	
	public boolean isSim() {
		return sim;
	}

} // class JanelaPopUpPergunta
