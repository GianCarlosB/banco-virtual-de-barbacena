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
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class JanelaPopUpErro extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5819037031569739045L;
	
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 * @wbp.parser.constructor
	 */
	public JanelaPopUpErro(Window janelaPai, String titulo, String msgErro, Exception e) {
		setType(Type.POPUP);
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		
		setTitle(titulo);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(231, 76, 60));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(231, 76, 60));
		scrollPane.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1, true), "Stack Trace", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		scrollPane.setBounds(10, 82, 424, 133);
		contentPanel.add(scrollPane);
		
		JTextPane erroTextPane = new JTextPane();
		erroTextPane.setForeground(Color.BLACK);
		erroTextPane.setFont(new Font("Calibri", Font.PLAIN, 13));
		erroTextPane.setEditable(false);
		erroTextPane.setBackground(new Color(231, 76, 60));
		erroTextPane.setText(sw.toString());
		scrollPane.setViewportView(erroTextPane);
		
		JSeparator separatorBtn = new JSeparator();
		separatorBtn.setBounds(0, 226, 444, 2);
		contentPanel.add(separatorBtn);
		
		JLabel lblImg = new JLabel("img");
		lblImg.setIcon(new ImageIcon(JanelaPopUpErro.class.getResource("/tsi/too/bvb/recursos/imagens/bug.png")));
		lblImg.setBounds(402, 26, 32, 32);
		contentPanel.add(lblImg);
		
		JEditorPane msgEditorPane = new JEditorPane();
		msgEditorPane.setForeground(Color.BLACK);
		msgEditorPane.setFont(new Font("Calibri", Font.BOLD, 14));
		msgEditorPane.setText(msgErro);
		msgEditorPane.setEditable(false);
		msgEditorPane.setBackground(new Color(231, 76, 60));
		msgEditorPane.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1, true), "ERRO", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		msgEditorPane.setBounds(10, 11, 382, 60);
		contentPanel.add(msgEditorPane);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(231, 76, 60));
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						JanelaPopUpErro.this.dispose();
					}
				});
				okButton.setBackground(new Color(231, 76, 60));
				okButton.setMnemonic(KeyEvent.VK_O);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
		JanelaPopUpErro.this.setLocationRelativeTo(janelaPai);
		executarSomErroCritico();
		setVisible(true);
	}
	
	/**
	 * Create the dialog.
	 */
	public JanelaPopUpErro(Window janelaPai, String titulo, Exception e) {
		setType(Type.POPUP);
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		
		setTitle(titulo);
		setBounds(100, 100, 900, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(231, 76, 60));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane stackTraceScrollPane = new JScrollPane();
		stackTraceScrollPane.setBackground(new Color(231, 76, 60));
		stackTraceScrollPane.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1, true), "Stack Trace", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		stackTraceScrollPane.setBounds(10, 142, 874, 373);
		contentPanel.add(stackTraceScrollPane);
		
		JTextPane erroTextPane = new JTextPane();
		erroTextPane.setForeground(Color.BLACK);
		erroTextPane.setFont(new Font("Calibri", Font.PLAIN, 13));
		erroTextPane.setEditable(false);
		erroTextPane.setBackground(new Color(231, 76, 60));
		erroTextPane.setText(sw.toString());
		stackTraceScrollPane.setViewportView(erroTextPane);
		
		JSeparator separatorBtn = new JSeparator();
		separatorBtn.setBounds(0, 526, 894, 2);
		contentPanel.add(separatorBtn);
		
		JLabel lblImg = new JLabel("img");
		lblImg.setIcon(new ImageIcon(JanelaPopUpErro.class.getResource("/tsi/too/bvb/recursos/imagens/bug.png")));
		lblImg.setBounds(852, 55, 32, 32);
		contentPanel.add(lblImg);
		
		JScrollPane erroScrollPane = new JScrollPane();
		erroScrollPane.setBackground(new Color(231, 76, 60));
		erroScrollPane.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "ERRO", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		erroScrollPane.setBounds(10, 11, 832, 120);
		contentPanel.add(erroScrollPane);
		
		JTextPane txtpnA = new JTextPane();
		txtpnA.setFont(new Font("Calibri", Font.BOLD, 14));
		txtpnA.setForeground(Color.BLACK);
		txtpnA.setText(e.getMessage());
		txtpnA.setEditable(false);
		txtpnA.setBackground(new Color(231, 76, 60));
		erroScrollPane.setViewportView(txtpnA);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(231, 76, 60));
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						JanelaPopUpErro.this.dispose();
					}
				});
				okButton.setBackground(new Color(231, 76, 60));
				okButton.setMnemonic(KeyEvent.VK_O);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
		JanelaPopUpErro.this.setLocationRelativeTo(janelaPai);
		executarSomErroCritico();
		setVisible(true);
	}
	
	/**
	 * Create the dialog.
	 */
	public JanelaPopUpErro(Window janelaPai, String titulo, String msgErro) {
		setType(Type.POPUP);
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		
		setTitle(titulo);
		setBounds(100, 100, 450, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(231, 76, 60));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JSeparator separatorBtn = new JSeparator();
		separatorBtn.setBounds(0, 126, 444, 2);
		contentPanel.add(separatorBtn);
		
		JLabel lblImg = new JLabel("img");
		lblImg.setIcon(new ImageIcon(JanelaPopUpErro.class.getResource("/tsi/too/bvb/recursos/imagens/bug.png")));
		lblImg.setBounds(402, 26, 32, 32);
		contentPanel.add(lblImg);
		
		JEditorPane msgEditorPane = new JEditorPane();
		msgEditorPane.setEditable(false);
		msgEditorPane.setForeground(Color.BLACK);
		msgEditorPane.setFont(new Font("Calibri", Font.BOLD, 14));
		msgEditorPane.setText(msgErro);
		msgEditorPane.setBackground(new Color(231, 76, 60));
		msgEditorPane.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1, true), "ERRO", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		msgEditorPane.setBounds(10, 11, 382, 104);
		contentPanel.add(msgEditorPane);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(231, 76, 60));
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						JanelaPopUpErro.this.dispose();
					}
				});
				okButton.setBackground(new Color(231, 76, 60));
				okButton.setMnemonic(KeyEvent.VK_O);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
		JanelaPopUpErro.this.setLocationRelativeTo(janelaPai);
		executarSomErro();
		setVisible(true);
	}
	
	public void executarSomErro() {
		Applet.newAudioClip(JanelaPopUpErro.class.getResource("/tsi/too/bvb/recursos/sons/Windows Error.wav")).play();
	}
	
	public void executarSomErroCritico() {
		Applet.newAudioClip(JanelaPopUpErro.class.getResource("/tsi/too/bvb/recursos/sons/Windows Critical Stop.wav")).play();
	}
	
} // class JanelaPopUpErro
