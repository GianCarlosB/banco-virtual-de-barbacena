package tsi.too.bvb.gui.tecladovirtual;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

/** Classe que define a GUI de um teclado virtual
 * 
 * @author Gian Carlos Barros HonÛrio
 * @author Diego Oliveira
 * 
 * @see JDialog
 */
public class TecladoVirtual extends JDialog {
	
	/**
	 * @serial
	 */
	private static final long serialVersionUID = -5187414103748148168L;
	
	private JTextField telcadoTextField;
	
	/** Cria uma inst‚ncia do teclado virtual
	 * @param janelaPai <code>Window</code> com a janela pai do teclado virtual
	 * 
	 * @see Window
	 */	
	public TecladoVirtual(Window janelaPai) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TecladoVirtual.class.getResource("/tsi/too/bvb/recursos/imagens/Keyboard-256.png")));
		getContentPane().setBackground(Color.LIGHT_GRAY);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				telcadoTextField.requestFocus();
			}
		});
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("BVB - Teclado Virtual");
		setBounds(100, 100, 580, 260);
		
		getContentPane().setLayout(null);
		JPanel panelTeclado = new JPanel();
		panelTeclado.setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		panelTeclado.setBounds(10, 11, 554, 140);
		getContentPane().add(panelTeclado);
		panelTeclado.setLayout(new GridLayout(0, 10, 8, 8));
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"1");
			}
		});
		btn1.setForeground(Color.WHITE);
		btn1.setFont(new Font("Dialog", Font.BOLD, 14));
		btn1.setBackground(Color.DARK_GRAY);
		panelTeclado.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"2");
			}
		});
		btn2.setForeground(Color.WHITE);
		btn2.setFont(new Font("Dialog", Font.BOLD, 14));
		btn2.setBackground(Color.DARK_GRAY);
		panelTeclado.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"3");
			}
		});
		btn3.setForeground(Color.WHITE);
		btn3.setFont(new Font("Dialog", Font.BOLD, 14));
		btn3.setBackground(Color.DARK_GRAY);
		panelTeclado.add(btn3);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"4");
			}
		});
		btn4.setForeground(Color.WHITE);
		btn4.setFont(new Font("Dialog", Font.BOLD, 14));
		btn4.setBackground(Color.DARK_GRAY);
		panelTeclado.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"5");
			}
		});
		btn5.setForeground(Color.WHITE);
		btn5.setFont(new Font("Dialog", Font.BOLD, 14));
		btn5.setBackground(Color.DARK_GRAY);
		panelTeclado.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"6");
			}
		});
		btn6.setForeground(Color.WHITE);
		btn6.setFont(new Font("Dialog", Font.BOLD, 14));
		btn6.setBackground(Color.DARK_GRAY);
		panelTeclado.add(btn6);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"7");
			}
		});
		btn7.setForeground(Color.WHITE);
		btn7.setFont(new Font("Dialog", Font.BOLD, 14));
		btn7.setBackground(Color.DARK_GRAY);
		panelTeclado.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"8");
			}
		});
		btn8.setForeground(Color.WHITE);
		btn8.setFont(new Font("Dialog", Font.BOLD, 14));
		btn8.setBackground(Color.DARK_GRAY);
		panelTeclado.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"9");
			}
		});
		btn9.setForeground(Color.WHITE);
		btn9.setFont(new Font("Dialog", Font.BOLD, 14));
		btn9.setBackground(Color.DARK_GRAY);
		panelTeclado.add(btn9);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"0");
			}
		});
		btn0.setForeground(Color.WHITE);
		btn0.setFont(new Font("Dialog", Font.BOLD, 14));
		btn0.setBackground(Color.DARK_GRAY);
		panelTeclado.add(btn0);
		
		JButton btnQ = new JButton("Q");
		btnQ.setBackground(Color.DARK_GRAY);
		btnQ.setForeground(Color.WHITE);
		panelTeclado.add(btnQ);
		btnQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"Q");
			}
		});
		btnQ.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JButton btnW = new JButton("W");
		btnW.setBackground(Color.DARK_GRAY);
		btnW.setForeground(Color.WHITE);
		panelTeclado.add(btnW);
		btnW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"W");
			}
		});
		btnW.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JButton btnE = new JButton("E");
		btnE.setBackground(Color.DARK_GRAY);
		btnE.setForeground(Color.WHITE);
		panelTeclado.add(btnE);
		btnE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"E");
			}
		});
		btnE.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JButton btnR = new JButton("R");
		btnR.setBackground(Color.DARK_GRAY);
		btnR.setForeground(Color.WHITE);
		panelTeclado.add(btnR);
		btnR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"R");
			}
		});
		btnR.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JButton btnT = new JButton("T");
		btnT.setBackground(Color.DARK_GRAY);
		btnT.setForeground(Color.WHITE);
		panelTeclado.add(btnT);
		btnT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"T");
			}
		});
		btnT.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JButton btnY = new JButton("Y");
		btnY.setBackground(Color.DARK_GRAY);
		btnY.setForeground(Color.WHITE);
		panelTeclado.add(btnY);
		btnY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"Y");
			}
		});
		btnY.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JButton btnU = new JButton("U");
		btnU.setBackground(Color.DARK_GRAY);
		btnU.setForeground(Color.WHITE);
		panelTeclado.add(btnU);
		btnU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"U");
			}
		});
		btnU.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JButton btnI = new JButton("I");
		btnI.setBackground(Color.DARK_GRAY);
		btnI.setForeground(Color.WHITE);
		panelTeclado.add(btnI);
		btnI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"I");
			}
		});
		btnI.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JButton btnO = new JButton("O");
		btnO.setBackground(Color.DARK_GRAY);
		btnO.setForeground(Color.WHITE);
		panelTeclado.add(btnO);
		btnO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"O");
			}
		});
		btnO.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JButton btnP = new JButton("P");
		btnP.setBackground(Color.DARK_GRAY);
		btnP.setForeground(Color.WHITE);
		panelTeclado.add(btnP);
		btnP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"P");
			}
		});
		btnP.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JButton btnA = new JButton("A");
		btnA.setBackground(Color.DARK_GRAY);
		btnA.setForeground(Color.WHITE);
		panelTeclado.add(btnA);
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"A");
			}
		});
		btnA.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JButton btnS = new JButton("S");
		btnS.setBackground(Color.DARK_GRAY);
		btnS.setForeground(Color.WHITE);
		panelTeclado.add(btnS);
		btnS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"S");
			}
		});
		btnS.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JButton btnD = new JButton("D");
		btnD.setBackground(Color.DARK_GRAY);
		btnD.setForeground(Color.WHITE);
		panelTeclado.add(btnD);
		btnD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"D");
			}
		});
		btnD.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JButton btnF = new JButton("F");
		btnF.setBackground(Color.DARK_GRAY);
		btnF.setForeground(Color.WHITE);
		panelTeclado.add(btnF);
		btnF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"F");
			}
		});
		btnF.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JButton btnG = new JButton("G");
		btnG.setBackground(Color.DARK_GRAY);
		btnG.setForeground(Color.WHITE);
		panelTeclado.add(btnG);
		btnG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"G");
			}
		});
		btnG.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JButton btnH = new JButton("H");
		btnH.setBackground(Color.DARK_GRAY);
		btnH.setForeground(Color.WHITE);
		panelTeclado.add(btnH);
		btnH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"H");
			}
		});
		btnH.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JButton btnJ = new JButton("J");
		btnJ.setBackground(Color.DARK_GRAY);
		btnJ.setForeground(Color.WHITE);
		panelTeclado.add(btnJ);
		btnJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"J");
			}
		});
		btnJ.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JButton btnK = new JButton("K");
		btnK.setBackground(Color.DARK_GRAY);
		btnK.setForeground(Color.WHITE);
		panelTeclado.add(btnK);
		btnK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"K");
			}
		});
		btnK.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JButton btnL = new JButton("L");
		btnL.setBackground(Color.DARK_GRAY);
		btnL.setForeground(Color.WHITE);
		panelTeclado.add(btnL);
		btnL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"L");
			}
		});
		btnL.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JButton btn« = new JButton("\u00C7");
		btn«.setBackground(Color.DARK_GRAY);
		btn«.setForeground(Color.WHITE);
		panelTeclado.add(btn«);
		btn«.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"«");
			}
		});
		btn«.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JButton btnZ = new JButton("Z");
		btnZ.setBackground(Color.DARK_GRAY);
		btnZ.setForeground(Color.WHITE);
		panelTeclado.add(btnZ);
		btnZ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"Z");
			}
		});
		btnZ.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JButton btnX = new JButton("X");
		btnX.setBackground(Color.DARK_GRAY);
		btnX.setForeground(Color.WHITE);
		panelTeclado.add(btnX);
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"X");
			}
		});
		btnX.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JButton btnC = new JButton("C");
		btnC.setBackground(Color.DARK_GRAY);
		btnC.setForeground(Color.WHITE);
		panelTeclado.add(btnC);
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"C");
			}
		});
		btnC.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JButton btnV = new JButton("V");
		btnV.setBackground(Color.DARK_GRAY);
		btnV.setForeground(Color.WHITE);
		panelTeclado.add(btnV);
		btnV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"V");
			}
		});
		btnV.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JButton btnB = new JButton("B");
		btnB.setBackground(Color.DARK_GRAY);
		btnB.setForeground(Color.WHITE);
		panelTeclado.add(btnB);
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"B");
			}
		});
		btnB.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JButton btnN = new JButton("N");
		btnN.setBackground(Color.DARK_GRAY);
		btnN.setForeground(Color.WHITE);
		panelTeclado.add(btnN);
		btnN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"N");
			}
		});
		btnN.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JButton btnM = new JButton("M");
		btnM.setBackground(Color.DARK_GRAY);
		btnM.setForeground(Color.WHITE);
		panelTeclado.add(btnM);
		btnM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telcadoTextField.setText(telcadoTextField.getText()+"M");
			}
		});
		btnM.setFont(new Font("Dialog", Font.BOLD, 14));
		
		telcadoTextField = new JTextField();
		telcadoTextField.setEditable(false);
		telcadoTextField.setFont(new Font("Dialog", Font.PLAIN, 16));
		telcadoTextField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		telcadoTextField.setBounds(60, 180, 454, 30);
		getContentPane().add(telcadoTextField);
		telcadoTextField.setColumns(10);
		btnQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
			}
		});
		
		setLocationRelativeTo(janelaPai);
		setVisible(true);
	}
	
} // class TecladoVirtual
