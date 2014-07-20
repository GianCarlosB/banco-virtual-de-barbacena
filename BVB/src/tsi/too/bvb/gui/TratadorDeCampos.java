package tsi.too.bvb.gui;

/** Interface com métodos básicos que algumas janelas e painéis devem implementar
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 */
public interface TratadorDeCampos {

	/** Limpa os campos do componente GUI
	 */
	public void limparCampos();
	
	/** Salva os dados inseridos no componente GUI em um objeto
	 * @param object <code>Object</code> referênte ao objeto que será salvo
	 */
	public void salvarCampos(Object object);
	
	/** Verifica se os campos do componente GUI foram preenchidos corretamente
	 *  @return <code>boolean</code> com <code>true</code> caso os campos tenham sido preenchidos corretamente, 
	 *  e <code>false</code> caso contrário
	 */
	public boolean validarCampos();
	
	/** Insere a borda padrão nos campos do componente GUI
	 */
	public void inserirBordasPadrao();
	
} // interface PainelCliente
