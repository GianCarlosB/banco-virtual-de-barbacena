package tsi.too.bvb.eventos.menuprincipal;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

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

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseEntered(e);
		
		if(e.getSource() == igMenuPrincipal.getLblBanner())
			igMenuPrincipal.getLblBanner().setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/" +
					                                 "Banner(invertido) - BVB.png")));
		else if(e.getSource() == igMenuPrincipal.getLblImgSeta1())
			igMenuPrincipal.getLblImgSeta1().setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/" +
					                                 "Arrowhead-Right-32 (verde).png")));
		else if(e.getSource() == igMenuPrincipal.getLblImgSeta2())
			igMenuPrincipal.getLblImgSeta2().setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/" +
					                                 "Arrowhead-Right-32 (verde).png")));
		else if(e.getSource() == igMenuPrincipal.getLblImgSeta3())
			igMenuPrincipal.getLblImgSeta3().setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/" +
					                                 "Arrowhead-Right-32 (verde).png")));
		else if(e.getSource() == igMenuPrincipal.getLblImgSeta4())
			igMenuPrincipal.getLblImgSeta4().setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/" +
					                                 "Arrowhead-Right-32 (verde).png")));
		else if(e.getSource() == igMenuPrincipal.getLblImgSeta5())
			igMenuPrincipal.getLblImgSeta5().setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/" +
					                                 "Arrowhead-Right-32 (verde).png")));
		else if(e.getSource() == igMenuPrincipal.getLblImgSeta6())
			igMenuPrincipal.getLblImgSeta6().setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/" +
					                                 "Arrowhead-Right-32 (verde).png")));
		else if(e.getSource() == igMenuPrincipal.getLblImgAjuda())
			igMenuPrincipal.getLblImgAjuda().setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/" +
					                                 "Help-24 (amarelo).png")));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseExited(e);
		
		if(e.getSource() == igMenuPrincipal.getLblBanner())
			igMenuPrincipal.getLblBanner().setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/" +
					                                 "Banner - BVB.png")));
		else if(e.getSource() == igMenuPrincipal.getLblImgSeta1())
			igMenuPrincipal.getLblImgSeta1().setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/" +
					                                 "Arrowhead-Right-32 (cinza).png")));
		else if(e.getSource() == igMenuPrincipal.getLblImgSeta2())
			igMenuPrincipal.getLblImgSeta2().setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/" +
					                                 "Arrowhead-Right-32 (cinza).png")));
		else if(e.getSource() == igMenuPrincipal.getLblImgSeta3())
			igMenuPrincipal.getLblImgSeta3().setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/" +
					                                 "Arrowhead-Right-32 (cinza).png")));
		else if(e.getSource() == igMenuPrincipal.getLblImgSeta4())
			igMenuPrincipal.getLblImgSeta4().setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/" +
					                                 "Arrowhead-Right-32 (cinza).png")));
		else if(e.getSource() == igMenuPrincipal.getLblImgSeta5())
			igMenuPrincipal.getLblImgSeta5().setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/" +
					                                 "Arrowhead-Right-32 (cinza).png")));
		else if(e.getSource() == igMenuPrincipal.getLblImgSeta6())
			igMenuPrincipal.getLblImgSeta6().setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/" +
					                                 "Arrowhead-Right-32 (cinza).png")));
		else if(e.getSource() == igMenuPrincipal.getLblImgAjuda())
			igMenuPrincipal.getLblImgAjuda().setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/" +
					                                 "Help-24 (cinza).png")));
	}

} // class TEMouseMenuPrincipal
