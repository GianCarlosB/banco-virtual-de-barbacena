package tsi.too.bvb.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.LineBorder;

public class IgApresentacao extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3529660466821184952L;
	
	private String textoCarregando = "Carregando o BVB.";
	private JPanel contentPane;
	private JLabel lblCarregando = new JLabel("  Carregando o BVB.");;
	private JProgressBar progressBar = new JProgressBar();
	private JLabel lblBanner = new JLabel("Banner");
	
	private Carregamento carregamento = new Carregamento();
	private Thread threadCarregamento = new Thread(carregamento);

	/**
	 * Create the frame.
	 */
	public IgApresentacao() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(IgApresentacao.class.getResource("/tsi/too/bvb/recursos/imagens/BVB - \u00EDcone.png")));
		threadCarregamento.start();
		setUndecorated(true);
		Color concrete = new Color(127, 140, 141);
		Color belizaHole = new Color(41, 128, 185);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(463, 310);
		contentPane = new JPanel();
		contentPane.setBackground(concrete);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblBanner.setIcon(new ImageIcon(IgApresentacao.class.getResource("/tsi/too/bvb/recursos/imagens/Banner Apresenta\u00E7\u00E3o - BVB.png")));
		lblBanner.setBounds(10, 11, 432, 120);
		contentPane.add(lblBanner);
		progressBar.setIndeterminate(true);
		progressBar.setName("");
		progressBar.setForeground(belizaHole);
		
		progressBar.setBounds(10, 269, 443, 30);
		contentPane.add(progressBar);
		lblCarregando.setBorder(null);
		
		lblCarregando.setForeground(Color.WHITE);
		lblCarregando.setFont(new Font("Segoe Condensed", Font.PLAIN, 24));
		lblCarregando.setLabelFor(progressBar);
		lblCarregando.setBounds(52, 188, 230, 30);
		contentPane.add(lblCarregando);
		
		JEditorPane dtrpnCriadoPorDiego = new JEditorPane();
		dtrpnCriadoPorDiego.setEditable(false);
		dtrpnCriadoPorDiego.setFont(new Font("Tahoma", Font.PLAIN, 9));
		dtrpnCriadoPorDiego.setText("Copyright \u00A9 2001-2014, BVB vers\u00E3o 1.04. Software criado por Diego Oliveira & Gian Carlos para\r\navalia\u00E7\u00E3o na disciplina de Tecnologia de Orienta\u00E7\u00E3o a Objetos do Curso Superior de Tecnologia em\r\nSistemas para internet do Instituto Federal do Sudeste de Minas Gerais C\u00E2mpus Barbacena. Prof. M\u00E1rlon.");
		dtrpnCriadoPorDiego.setForeground(Color.WHITE);
		dtrpnCriadoPorDiego.setBackground(concrete);
		dtrpnCriadoPorDiego.setBounds(10, 229, 443, 39);
		contentPane.add(dtrpnCriadoPorDiego);
		
		JLabel lblSeta = new JLabel("seta");
		lblSeta.setIcon(new ImageIcon(IgApresentacao.class.getResource("/tsi/too/bvb/recursos/imagens/Arrowhead-Right-32 (verde).png")));
		lblSeta.setBounds(10, 186, 32, 32);
		contentPane.add(lblSeta);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private class Carregamento implements Runnable {
		private volatile boolean isRunning = true;

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i = 0, carregar = 0; isRunning; i++, carregar += 25) {
				if(carregar > 100) carregar = 0;
				if(carregar == 0) lblCarregando.setText(textoCarregando);
				else if(carregar == 25) lblCarregando.setText(textoCarregando + ".");
				else if(carregar == 50) lblCarregando.setText(textoCarregando + "..");
				else if(carregar == 75) lblCarregando.setText(textoCarregando + "...");
				else if(carregar == 100) lblCarregando.setText(textoCarregando + "....");

				if(i % 2 == 0)
					lblBanner.setIcon(new ImageIcon(IgApresentacao.class.getResource("/tsi/too/bvb/recursos/imagens/Banner " +
							                                                         "Apresenta\u00E7\u00E3o(invertido) - BVB.png")));
				else
					lblBanner.setIcon(new ImageIcon(IgApresentacao.class.getResource("/tsi/too/bvb/recursos/imagens/Banner " +
							                                                         "Apresenta\u00E7\u00E3o - BVB.png")));
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		public void setRunning(boolean isRunning) {
			this.isRunning = isRunning;
		}
	}
	
	public void finalizarThread() {
		carregamento.setRunning(false);
	}
} // class IgApresentacao
