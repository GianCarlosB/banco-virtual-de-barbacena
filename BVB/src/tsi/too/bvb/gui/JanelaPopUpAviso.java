package tsi.too.bvb.gui;

import java.applet.Applet;
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

public class JanelaPopUpAviso extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8506084221384792594L;
	
	private final JPanel contentPanel = new JPanel();
	
	/**
	 * Create the dialog.
	 */
	public JanelaPopUpAviso(Window janelaPai, String titulo, String msgAviso) {
		setType(Type.POPUP);
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		
		setTitle(titulo);
		setBounds(100, 100, 450, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(241, 196, 15));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JSeparator separatorBtn = new JSeparator();
		separatorBtn.setBounds(0, 126, 444, 2);
		contentPanel.add(separatorBtn);
		
		JLabel lblImg = new JLabel("img");
		lblImg.setIcon(new ImageIcon(JanelaPopUpAviso.class.getResource("/tsi/too/bvb/recursos/imagens/pins38.png")));
		lblImg.setBounds(402, 26, 32, 32);
		contentPanel.add(lblImg);
		
		JEditorPane msgEditorPane = new JEditorPane();
		msgEditorPane.setEditable(false);
		msgEditorPane.setForeground(Color.BLACK);
		msgEditorPane.setFont(new Font("Dialog", Font.BOLD, 12));
		msgEditorPane.setText(msgAviso);
		msgEditorPane.setBackground(new Color(241, 196, 15));
		msgEditorPane.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1, true), "AVISO", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		msgEditorPane.setBounds(10, 11, 382, 104);
		contentPanel.add(msgEditorPane);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(241, 196, 15));
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						JanelaPopUpAviso.this.dispose();
					}
				});
				okButton.setBackground(new Color(241, 196, 15));
				okButton.setMnemonic(KeyEvent.VK_O);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
		JanelaPopUpAviso.this.setLocationRelativeTo(janelaPai);
		executarSomAviso();
		setVisible(true);
	}
	
	public void executarSomAviso() {
		Applet.newAudioClip(JanelaPopUpErro.class.getResource("/tsi/too/bvb/recursos/sons/Windows Exclamation.wav")).play();
	}
	
} // class JanelaPopUpAviso
