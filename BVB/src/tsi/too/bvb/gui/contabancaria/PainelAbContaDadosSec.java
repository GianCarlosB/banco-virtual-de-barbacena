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
import tsi.too.bvb.entidades.tiposenumerados.TipoConta;
import tsi.too.bvb.gui.TratadorDeCampos;
import tsi.too.bvb.validacoes.ValidarDados;

public class PainelAbContaDadosSec extends JPanel implements TratadorDeCampos {

	/**
	 * 
	 */
	private static final long serialVersionUID = -690399083609439414L;
	
	private TipoConta tipoConta;
	private JCheckBox chckbxContaSalario;
	private JLabel lblSaldo;
	private JTextField saldoTextField;
	private UtilDateModel model;
	private JDatePanelImpl datePanel;
	private JDatePickerImpl datePicker;
	private JLabel lblContaSalario;

	/**
	 * Create the panel.
	 */
	public PainelAbContaDadosSec() {
		setLayout(null);
		
		JLabel lblCodAgencia = new JLabel("Data de Abertura:");
		lblCodAgencia.setDisplayedMnemonic(KeyEvent.VK_D);
		lblCodAgencia.setBounds(10, 25, 115, 14);
		add(lblCodAgencia);

		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel);
		datePicker.getJFormattedTextField().setToolTipText("este campo \u00E9 de preenchimento obrigat\u00F3rio, a data n\u00E3o pode ser maior que a data atual e o ano n\u00E3o pode ser menor que 2001 ");
		datePicker.setToolTipText("");
		lblCodAgencia.setLabelFor(datePicker.getJFormattedTextField());
		datePicker.setBounds(130, 11, 112, 28);
		datePanel.setBounds(100, 15, 112, 24);
		add(datePicker);
		
		lblSaldo = new JLabel("Saldo:");
		lblSaldo.setDisplayedMnemonic(KeyEvent.VK_S);
		lblSaldo.setBounds(10, 55, 60, 14);
		add(lblSaldo);
		
		chckbxContaSalario = new JCheckBox("Conta Sal\u00E1rio");
		chckbxContaSalario.setEnabled(false);
		chckbxContaSalario.setToolTipText("marque se a conta for utilizada para receber sal\u00E1rio");
		chckbxContaSalario.setMnemonic(KeyEvent.VK_O);
		chckbxContaSalario.setBounds(100, 109, 112, 24);
		add(chckbxContaSalario);
		
		lblContaSalario = new JLabel("Deseja utilizar esta conta para receber seu sal\u00E1rio?");
		lblContaSalario.setEnabled(false);
		lblContaSalario.setLabelFor(chckbxContaSalario);
		lblContaSalario.setDisplayedMnemonic(KeyEvent.VK_E);
		lblContaSalario.setBounds(10, 85, 378, 16);
		add(lblContaSalario);
		
		saldoTextField = new JNumberFormatField(new DecimalFormat("R$0.00"));
		((JNumberFormatField) saldoTextField).setLimit(17);
		saldoTextField.setToolTipText("este campo \u00E9 de preenchimento obrigat\u00F3rio e deve conter apenas d\u00EDgitos decimais");
		lblSaldo.setLabelFor(saldoTextField);
		saldoTextField.setBounds(130, 52, 269, 20);
		saldoTextField.setColumns(10);
		add(saldoTextField);
	}

	@Override
	public void limparCampos() {
		inserirBordasPadrao();
		
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
		
		if(ValidarDados.validarData((Date) datePicker.getModel().getValue()))
			datePicker.setBorder(BorderFactory.createLineBorder(getBackground (), 2));
		else {
			datePicker.setBorder(new LineBorder(Color.RED));
			valido = false;
		}
		
		if(!ValidarDados.validarDoublePositivo(saldoTextField.getText().replace(",", ".").replace("R", "").replace("$", ""))) {
			saldoTextField.setBorder(new LineBorder(Color.RED));
			valido = false;
		}
		else {
			// Conta Corrente
			if(tipoConta.getTipo() == TipoConta.CONTA_CORRENTE.getTipo()) {
				if(!chckbxContaSalario.isSelected() && Double.parseDouble(saldoTextField.getText()
				   .replace(",", ".").replace("R", "").replace("$", "")) < 300) {
					saldoTextField.setBorder(new LineBorder(Color.RED));
					valido = false;
				}
				else
					saldoTextField.setBorder(UIManager.getBorder("TextField.border"));
			}
			
			// Conta Poupança
			else if(tipoConta.getTipo() == TipoConta.CONTA_POUPANCA.getTipo()) {
				if(Double.parseDouble(saldoTextField.getText().replace(",", ".").replace("R", "").replace("$", "")) < 50) {
					saldoTextField.setBorder(new LineBorder(Color.RED));
					valido = false;
				}
				else
					saldoTextField.setBorder(UIManager.getBorder("TextField.border"));
			}
			
			// Conta FIF Prático
			else if(tipoConta.getTipo() == TipoConta.FIF_PRATICO.getTipo()) {
				if(Double.parseDouble(saldoTextField.getText().replace(",", ".").replace("R", "").replace("$", "")) < 2000) {
					saldoTextField.setBorder(new LineBorder(Color.RED));
					valido = false;
				}
				else
					saldoTextField.setBorder(UIManager.getBorder("TextField.border"));
			}
			
			// Conta FIF Executivo
			else if(tipoConta.getTipo() == TipoConta.FIF_EXECUTIVO.getTipo()) {
				if(Double.parseDouble(saldoTextField.getText().replace(",", ".").replace("R", "").replace("$", "")) < 15000) {
					saldoTextField.setBorder(new LineBorder(Color.RED));
					valido = false;
				}
				else
					saldoTextField.setBorder(UIManager.getBorder("TextField.border"));
			}
		}
		
		return valido;
	}
	
	@Override
	public void inserirBordasPadrao() {
		datePicker.setBorder(BorderFactory.createLineBorder(getBackground (), 2));
		saldoTextField.setBorder(UIManager.getBorder("TextField.border"));
	}

	public void visualizacaoOpcContaSal() {
		boolean mostrar = true;
		
		if(tipoConta.getTipo() != TipoConta.CONTA_CORRENTE.getTipo()) {
			mostrar = false;
			chckbxContaSalario.setSelected(mostrar);
		}
		
		lblContaSalario.setEnabled(mostrar);
		chckbxContaSalario.setEnabled(mostrar);
	}
	
	public void atualizaToolTipTextSaldo() {
		final String SALDO_TOOLTIPTEXT = "este campo \u00E9 de preenchimento obrigat\u00F3rio, deve conter apenas d\u00EDgitos decimais";
		
		if(tipoConta.getTipo() == TipoConta.CONTA_CORRENTE.getTipo())
			saldoTextField.setToolTipText(SALDO_TOOLTIPTEXT + " e valor de no mínimo R$ 300,00 se esta conta não for utilizada como conta salário");
		else if(tipoConta.getTipo() == TipoConta.CONTA_POUPANCA.getTipo())
			saldoTextField.setToolTipText(SALDO_TOOLTIPTEXT + " e valor de no mínimo R$ 50,00");
		else if(tipoConta.getTipo() == TipoConta.FIF_PRATICO.getTipo())
			saldoTextField.setToolTipText(SALDO_TOOLTIPTEXT + " e valor de no mínimo R$ 2.000,00");
		else if(tipoConta.getTipo() == TipoConta.FIF_EXECUTIVO.getTipo())
			saldoTextField.setToolTipText(SALDO_TOOLTIPTEXT + " e valor de no mínimo R$ 15.000,00");
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}
	
} // class PainelAbContaDadosSec
