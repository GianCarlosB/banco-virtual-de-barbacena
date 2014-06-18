package tsi.too.bvb.gui.contabancaria;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import tsi.too.bvb.entidades.JNumberFormatField;
import tsi.too.bvb.entidades.Mascara;
import tsi.too.bvb.entidades.contabancaria.ContaBancaria;
import tsi.too.bvb.gui.TratadorDeCampos;
import tsi.too.bvb.validacoes.ValidarDados;

public class PainelAbContaDadosSec extends JPanel implements TratadorDeCampos {

	/**
	 * 
	 */
	private static final long serialVersionUID = -690399083609439414L;
	private JFormattedTextField dataAbFormattedTextField;
	private JCheckBox chckbxContaSalario;
	private JLabel lblSaldo;
	private JTextField saldoTextField;

	/**
	 * Create the panel.
	 */
	public PainelAbContaDadosSec() {
		setLayout(null);
		
		JLabel lblCodAgencia = new JLabel("Data de Abertura:");
		lblCodAgencia.setDisplayedMnemonic(KeyEvent.VK_D);
		lblCodAgencia.setBounds(10, 25, 80, 14);
		add(lblCodAgencia);

		dataAbFormattedTextField = new JFormattedTextField(new Mascara("##/##/####"));
		lblCodAgencia.setLabelFor(dataAbFormattedTextField);
		dataAbFormattedTextField.setToolTipText("este campo \u00E9 de preenchimento obrigat\u00F3rio, deve conter apenas d\u00EDgitos decimais e ano partir de 2001");
		dataAbFormattedTextField.setBounds(100, 22, 308, 20);
		add(dataAbFormattedTextField);
		
		lblSaldo = new JLabel("Saldo:");
		lblSaldo.setDisplayedMnemonic(KeyEvent.VK_S);
		lblSaldo.setBounds(10, 55, 60, 14);
		add(lblSaldo);
		
		chckbxContaSalario = new JCheckBox("Conta Sal\u00E1rio");
		chckbxContaSalario.setToolTipText("marque se usar esta conta para receber seu sal\u00E1rio. O dep\u00F3sito inicial deve ser de no m\u00EDnimo R$ 300,00 se esta conta n\u00E3o for utilizada como conta sal\u00E1rio");
		chckbxContaSalario.setMnemonic(KeyEvent.VK_O);
		chckbxContaSalario.setBounds(100, 109, 112, 24);
		add(chckbxContaSalario);
		
		JLabel lblContaSalario = new JLabel("Deseja utilizar esta conta para receber seu sal\u00E1rio?");
		lblContaSalario.setLabelFor(chckbxContaSalario);
		lblContaSalario.setDisplayedMnemonic(KeyEvent.VK_D);
		lblContaSalario.setBounds(10, 85, 378, 16);
		add(lblContaSalario);
		
		saldoTextField = new JNumberFormatField(new DecimalFormat("R$0.00"));
		saldoTextField.setToolTipText("este campo \u00E9 de preenchimento obrigat\u00F3rio e deve conter apenas d\u00EDgitos decimais");
		lblSaldo.setLabelFor(saldoTextField);
		saldoTextField.setBounds(100, 52, 308, 20);
		saldoTextField.setColumns(10);
		add(saldoTextField);
	}

	@Override
	public void limparCampos() {
		dataAbFormattedTextField.setText("");
		saldoTextField.setText("");
		chckbxContaSalario.setSelected(false);
	}

	@Override
	public void salvarCampos(Object contaBancaria) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		try {
			((ContaBancaria) contaBancaria).setDataAbertura(simpleDateFormat.parse(dataAbFormattedTextField.getText()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		((ContaBancaria) contaBancaria).setSaldo(Double.parseDouble(saldoTextField.getText()));
		((ContaBancaria) contaBancaria).setContaSalario(chckbxContaSalario.isSelected());
	}

	@Override
	public boolean validarCampos() {
		boolean valido = true;
		
		if(!ValidarDados.validarVazio(dataAbFormattedTextField.getText().replace("/", ""))) {
			dataAbFormattedTextField.setBorder(new LineBorder(Color.RED));
			valido = false;
		}
		else dataAbFormattedTextField.setBorder(UIManager.getBorder("FormattedTextField.border"));
		
		if(!ValidarDados.validarDoublePositivo(saldoTextField.getText().replace(",", ".").replace("R", "").replace("$", ""))) {
			saldoTextField.setBorder(new LineBorder(Color.RED));
			valido = false;
		}
		else {
			if(chckbxContaSalario.isSelected() && Double.parseDouble(saldoTextField.getText()
			   .replace(",", ".").replace("R", "").replace("$", "")) < 300) {
				saldoTextField.setBorder(new LineBorder(Color.RED));
				chckbxContaSalario.setForeground(Color.RED);
				valido = false;
			}
			else {
				saldoTextField.setBorder(UIManager.getBorder("TextField.border"));
				chckbxContaSalario.setForeground(new Color(51, 51, 51));
			}
		}
		
		return valido;
	}
} // class PainelAbContaDadosSec
