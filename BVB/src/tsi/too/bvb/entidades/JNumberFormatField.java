package tsi.too.bvb.entidades;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

// Créditos ao autor da classe: Dyorgio da Silva Nascimento 
/** Campo para a inserção de números com base em um formato
 * 
 * @author Dyorgio da Silva Nascimento 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 */  
public class JNumberFormatField extends JTextField {  
	
	/**
	 * @serial
	 */
    private static final long serialVersionUID = -7506506392528621022L;
    
    private static final NumberFormat MONETARY_FORMAT = new DecimalFormat("R$ #,##0.00");  
    private NumberFormat numberFormat;  
    private int limit = -1;  
    
	/** Cria uma instância do campo com o formato monetário padrão
	 */
    public JNumberFormatField() {  
        this(MONETARY_FORMAT);  
    }  
    
	/** Cria uma instância do campo com o número de casas decimais desejado
	 * @param casasDecimais <code>int</code> com o número de casas decimais desejado
	 */
    public JNumberFormatField(int casasDecimais) {  
        this(new DecimalFormat((casasDecimais == 0 ? "#,##0" : "#,##0.") + makeZeros(casasDecimais)));  
    }
    
	/** Cria uma instância do campo com um formato personalizado
	 * @param format <code>NumberFormat</code> com um formato personalizado
	 * 
	 * @see NumberFormat
	 */
    public JNumberFormatField(NumberFormat format) {
    	// Define o formato do  número  
        numberFormat = format; // Alinhamento horizontal para o texto  
        setHorizontalAlignment(LEFT); // Documento responsável pela formatação do campo  
        setDocument(new PlainDocument() {  
            private static final long serialVersionUID = 1L;  
  
            @Override  
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {  
                String text = new StringBuilder(JNumberFormatField.this.getText().replaceAll("[^0-9]", "")).append(str.replaceAll("[^0-9]", "")).toString();  
                super.remove(0, getLength());  
                if (text.isEmpty()) {  
                    text = "0";  
                } else {  
                    text = new BigInteger(text).toString();  
                }  
                super.insertString(0, numberFormat.format(new BigDecimal(getLimit() > 0 == text.length() > getLimit() ? text.substring(0, getLimit()) : text).divide(new BigDecimal(Math.pow(10, numberFormat.getMaximumFractionDigits())))), a);  
            }  
  
            @Override  
            public void remove(int offs, int len) throws BadLocationException {  
                super.remove(offs, len);  
                if (len != getLength()) {  
                    insertString(0, "", null);  
                }  
            }  
        }); // Mantém o cursor no final do campo  
        addCaretListener(new CaretListener() {  
            boolean update = false;  
  
            @Override  
            public void caretUpdate(CaretEvent e) {  
                if (!update) {  
                    update = true;  
                    setCaretPosition(getText().length());  
                    update = false;  
                }  
            }  
        }); // Limpa o campo se apertar DELETE  
        addKeyListener(new KeyAdapter() {  
            @Override  
            public void keyPressed(KeyEvent e) {  
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {  
                    setText("");  
                }  
            }  
        }); // Formato inicial  
        setText("0");  
        setCaretPosition(getText().length());  
    }  
  
    /** Define um valor <code>BigDecimal</code> ao campo
     * @param value <code>BigDecimal</code> com um valor
     * 
     * @see BigDecimal
     */  
    public void setValue(BigDecimal value) {  
        super.setText(numberFormat.format(value));  
    }  
  
    /** Recupera um valor <code>BigDecimal</code> do campo
     * @return <code>BigDecimal</code> com o valor
     */  
    public final BigDecimal getValue() {  
        return new BigDecimal(getText().replaceAll("[^0-9]", "")).divide(new BigDecimal(Math.pow(10, numberFormat.getMaximumFractionDigits())));  
    }  
  
    /** Recupera o formatador atual do campo
     * @return <code>NumberFormat</code> com o formatador
     */  
    public NumberFormat getNumberFormat() {  
        return numberFormat;  
    }  
  
    /** Define o formatador do campo
     * @param numberFormat <code>NumberFormat</code> com o formatador
     * 
     * @see NumberFormat
     */  
    public void setNumberFormat(NumberFormat numberFormat) {  
        this.numberFormat = numberFormat;  
    }  
  
    /** Preenche um <code>StringBuilder</code> com zeros
     * @param zeros <code>int</code> com o número de zeros
     * @return <code>String</code> preenchida com o número de zeros passado como parâmetro
     * @throws RuntimeException Número de casas decimais inválido
     */  
    private static final String makeZeros(int zeros) {  
        if (zeros >= 0) {  
            StringBuilder builder = new StringBuilder();  
            for (int i = 0; i < zeros; i++) {  
                builder.append('0');  
            }  
            return builder.toString();  
        } else {  
            throw new RuntimeException("Número de casas decimais inválida (" + zeros + ")");  
        }  
    }  
  
    /** Recupera o limite do campo
     * @return <code>String</code> com o limite do campo
     */  
    public int getLimit() {  
        return limit;  
    }  
  
    /** Define o limite do campo. Use limite menor que 0 para deixar livre (default). Ignora os 
     * pontos e vírgulas do formato, conta somente com os números
     * @param limit <code>int</code> com o limite do campo
     */  
    public void setLimit(int limit) {  
        this.limit = limit;  
    }
    
} // class JNumberFormatField