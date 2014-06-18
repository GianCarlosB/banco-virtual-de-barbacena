package tsi.too.bvb.eventos.menuprincipal;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import tsi.too.bvb.gui.menuprincipal.IgMenuPrincipal;

public class TEMouseMenuPrincipal extends MouseAdapter {
	
	private IgMenuPrincipal igMenuPrincipal;

	public TEMouseMenuPrincipal(IgMenuPrincipal igMenuPrincipal) {
		super();
		this.igMenuPrincipal = igMenuPrincipal;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseClicked(e);
		
		if(e.getButton() == MouseEvent.BUTTON1) { //botão esquerdo do mouse
			if(e.getSource() == igMenuPrincipal.getLblBanner())
				igMenuPrincipal.getTabbedPane().setSelectedIndex(0);
			else if(e.getSource() == igMenuPrincipal.getLblImgSeta1())
				igMenuPrincipal.getTabbedPane().setSelectedIndex(1);
			else if(e.getSource() == igMenuPrincipal.getLblImgSeta2())
				igMenuPrincipal.getTabbedPane().setSelectedIndex(2);
			else if(e.getSource() == igMenuPrincipal.getLblImgSeta3())
				igMenuPrincipal.getTabbedPane().setSelectedIndex(3);
			else if(e.getSource() == igMenuPrincipal.getLblImgSeta4())
				igMenuPrincipal.getTabbedPane().setSelectedIndex(4);
			else if((e.getSource() == igMenuPrincipal.getLblImgSeta5()) ||
					(e.getSource() == igMenuPrincipal.getLblImgSeta6()) ||
					(e.getSource() == igMenuPrincipal.getLblImgAjuda()))
				igMenuPrincipal.getTabbedPane().setSelectedIndex(5);
		}
	}

} // class TEMouseMenuPrincipal
