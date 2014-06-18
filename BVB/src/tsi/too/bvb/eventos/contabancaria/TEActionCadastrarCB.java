package tsi.too.bvb.eventos.contabancaria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tsi.too.bvb.entidades.contabancaria.ContaBancaria;
import tsi.too.bvb.gui.contabancaria.IgAbrirContaBancaria;
import tsi.too.bvb.gui.contabancaria.PainelAbContaDadosChave;

public class TEActionCadastrarCB implements ActionListener {
	
	private IgAbrirContaBancaria igAbrirContaBancaria;
	private PainelAbContaDadosChave painelAbContaDadosChave;
	private ContaBancaria contaBancaria;
	
	public TEActionCadastrarCB(PainelAbContaDadosChave painelAbContaDadosChave) {
		super();
		this.painelAbContaDadosChave = painelAbContaDadosChave;
	}

	public TEActionCadastrarCB(IgAbrirContaBancaria igAbrirContaBancaria,
			ContaBancaria contaBancaria) {
		super();
		this.painelAbContaDadosChave = null;
		this.igAbrirContaBancaria = igAbrirContaBancaria;
		this.contaBancaria = contaBancaria;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(painelAbContaDadosChave != null && e.getSource() == painelAbContaDadosChave.getBtnValidarCodAgencia())
			painelAbContaDadosChave.validarCampoCodAgencia();
		else if(painelAbContaDadosChave != null && e.getSource() == painelAbContaDadosChave.getBtnValidarCpf())
			painelAbContaDadosChave.validarCampoCpf();
	}

} // class TEActionCadastrarCB
