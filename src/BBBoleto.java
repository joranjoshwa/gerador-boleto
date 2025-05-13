import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BBBoleto implements Boleto {

    private String sacadoNome;
    private String sacadoDocumento;
    private String sacadoEndereco;

    private String cedenteNome;
    private String cedenteDocumento;
    private String cedenteEndereco;

    private int nossoNumero;
    private String numeroDocumento;
    private Calendar vencimento;
    private double valor;

    private String bancoCodigo;
    private String agencia;
    private String conta;
    private String carteira;

    private String codigoDeBarras;
    private String linhaDigitavel;

    public BBBoleto(
            String sacadoNome, String sacadoDocumento, String sacadoEndereco,
            String cedenteNome, String cedenteDocumento, String cedenteEndereco,
            int nossoNumero, String numeroDocumento, Calendar vencimento, double valor,
            String bancoCodigo, String agencia, String conta, String carteira,
            String codigoDeBarras, String linhaDigitavel
    ) {
        this.sacadoNome = sacadoNome;
        this.sacadoDocumento = sacadoDocumento;
        this.sacadoEndereco = sacadoEndereco;

        this.cedenteNome = cedenteNome;
        this.cedenteDocumento = cedenteDocumento;
        this.cedenteEndereco = cedenteEndereco;

        this.nossoNumero = nossoNumero;
        this.numeroDocumento = numeroDocumento;
        this.vencimento = vencimento;
        this.valor = valor;

        this.bancoCodigo = bancoCodigo;
        this.agencia = agencia;
        this.conta = conta;
        this.carteira = carteira;

        this.codigoDeBarras = codigoDeBarras;
        this.linhaDigitavel = linhaDigitavel;
    }

    // Sacado
    @Override
    public String getSacadoNome() {
        return sacadoNome;
    }

    @Override
    public String getSacadoDocumento() {
        return sacadoDocumento;
    }

    @Override
    public String getSacadoEndereco() {
        return sacadoEndereco;
    }

    // Cedente
    @Override
    public String getCedenteNome() {
        return cedenteNome;
    }

    @Override
    public String getCedenteDocumento() {
        return cedenteDocumento;
    }

    @Override
    public String getCedenteEndereco() {
        return cedenteEndereco;
    }

    // Título
    @Override
    public int getNossoNumero() {
        return nossoNumero;
    }

    @Override
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    @Override
    public Calendar getVencimento() {
        return vencimento;
    }

    @Override
    public double getValor() {
        return valor;
    }

    // Informações bancárias
    @Override
    public String getBancoCodigo() {
        return bancoCodigo;
    }

    @Override
    public String getAgencia() {
        return agencia;
    }

    @Override
    public String getConta() {
        return conta;
    }

    @Override
    public String getCarteira() {
        return carteira;
    }

    // Código de barras e linha digitável
    @Override
    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    @Override
    public String getLinhaDigitavel() {
        return linhaDigitavel;
    }

    @Override
    public void exportarParaPDF(String caminhoArquivo) {
        // Ignorado por enquanto
    }



    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        return "=== BOLETO BANCO DO BRASIL ===\n"
                + "Sacado: " + sacadoNome + " - " + sacadoDocumento + "\n"
                + "Endereço: " + sacadoEndereco + "\n"
                + "Cedente: " + cedenteNome + " - " + cedenteDocumento + "\n"
                + "Endereço Cedente: " + cedenteEndereco + "\n"
                + "Nosso Número: " + nossoNumero + "\n"
                + "Número Documento: " + numeroDocumento + "\n"
                + "Vencimento: " + sdf.format(vencimento.getTime()) + "\n"
                + "Valor: R$ " + String.format("%.2f", valor) + "\n"
                + "Banco: " + bancoCodigo + " | Agência: " + agencia + " | Conta: " + conta + " | Carteira: " + carteira + "\n"
                + "Código de Barras: " + codigoDeBarras + "\n"
                + "Linha Digitável: " + linhaDigitavel + "\n";
    }
}
