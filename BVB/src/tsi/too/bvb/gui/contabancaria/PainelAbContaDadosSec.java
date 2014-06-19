package tsi.too.bvb.gui.contabancaria;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import tsi.too.bvb.entidades.JNumberFormatField;
import tsi.too.bvb.entidades.contabancaria.ContaBancaria;
import tsi.too.bvb.gui.TratadorDeCampos;
import tsi.too.bvb.validacoes.ValidarDados;

public class PainelAbContaDadosSec extends JPanel implements TratadorDeCampos {

	/**
	 * 
	 */
	private static final long serialVersionUID = -690399083609439414L;
	private JCheckBox chckbxContaSalario;
	private JLabel lblSaldo;
	private JTextField saldoTextField;
	private UtilDateModel model;
	private JDatePanelImpl datePanel;
	private JDatePickerImpl datePicker;

	/**
	 * Create the panel.
	 */
	public PainelAbContaDadosSec() {
		setLayout(null);
		
		JLabel lblCodAgencia = new JLabel("Data de Abertura:");
		lblCodAgencia.setDisplayedMnemonic(KeyEvent.VK_D);
		lblCodAgencia.setBounds(10, 25, 80, 14);
		add(lblCodAgencia);

		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel);
		datePicker.setToolTipText("este campo \u00E9 de preenchimento obrigat\u00F3rio e o ano n\u00E3o pode ser menor que 2001");
		lblCodAgencia.setLabelFor(datePicker.getJFormattedTextField());
		datePicker.setBounds(100, 11, 112, 28);
		datePanel.setBounds(100, 15, 112, 24);
		add(datePicker);
		
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
		lblContaSalario.setDisplayedMnemonic(KeyEvent.VK_E);
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
		datePicker.getModel().setValue(null);
		saldoTextField.setText("");
		chckbxContaSalario.setSelected(false);
	}

	@Override
	public void salvarCampos(Object contaBancaria) {
		((ContaBancaria) contaBancaria).setDataAbertura((Date) datePicker.getModel().getValue());
		((ContaBancaria) contaBancaria).setSaldo(Double.parseDouble(saldoTextField.getText().replace(",", ".").replace("R", "").replace("$", "")));
		((ContaBancaria) contaBancaria).setContaSalario(chckbxContaSalario.isSelected());
	}

	@Override
	public boolean validarCampos() {
		boolean valido = true;
		
		if(!ValidarDados.validarVazio(datePicker.getModel().getValue().toString())) {
			datePicker.setBorder(new LineBorder(Color.RED));
			valido = false;
		}
		else datePicker.setBorder(BorderFactory.createLineBorder (getBackground (), 2));
		
		if(!ValidarDados.validarDoublePositivo(saldoTextField.getText().replace(",", ".").replace("R", "").replace("$", ""))) {
			saldoTextField.setBorder(new LineBorder(Color.RED));
			valido = false;
		}
		else {
			if(!chckbxContaSalario.isSelected() && Double.parseDouble(saldoTextField.getText()
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
