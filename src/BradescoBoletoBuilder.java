import java.util.Calendar;

public class BradescoBoletoBuilder implements BoletoBuilder {

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

    @Override
    public void buildSacadoNome(String sacadoNome) {
        this.sacadoNome = sacadoNome;
    }

    @Override
    public void buildSacadoDocumento(String sacadoDocumento) {
        this.sacadoDocumento = sacadoDocumento;
    }

    @Override
    public void buildSacadoEndereco(String sacadoEndereco) {
        this.sacadoEndereco = sacadoEndereco;
    }

    @Override
    public void buildCedenteNome(String cedenteNome) {
        this.cedenteNome = cedenteNome;
    }

    @Override
    public void buildCedenteDocumento(String cedenteDocumento) {
        this.cedenteDocumento = cedenteDocumento;
    }

    @Override
    public void buildCedenteEndereco(String cedenteEndereco) {
        this.cedenteEndereco = cedenteEndereco;
    }

    @Override
    public void buildNossoNumero(int nossoNumero) {
        this.nossoNumero = nossoNumero;
    }

    @Override
    public void buildNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    @Override
    public void buildVencimento(Calendar vencimento) {
        this.vencimento = vencimento;
    }

    @Override
    public void buildValor(double valor) {
        this.valor = valor;
    }

    @Override
    public void buildBancoCodigo(String bancoCodigo) {
        this.bancoCodigo = "237"; //
    }

    @Override
    public void buildAgencia(String agencia) {
        this.agencia = agencia;
    }

    @Override
    public void buildConta(String conta) {
        this.conta = conta;
    }

    @Override
    public void buildCarteira(String carteira) {
        this.carteira = carteira;
    }

    @Override
    public void buildCodigoDeBarras() {
        // Ignorado: será gerado automaticamente no getBoleto()
    }

    @Override
    public void buildLinhaDigitavel() {
        // Ignorado: será gerado automaticamente no getBoleto()
    }

    @Override
    public Boleto getBoleto() {
        bancoCodigo = "237"; //
        String moeda = "9";

        String codigoDeBarras = CodigoDeBarrasUtil.gerarCodigoDeBarras(
                bancoCodigo,
                moeda,
                vencimento,
                valor,
                carteira,
                agencia,
                conta,
                nossoNumero
        );

        String linhaDigitavel = LinhaDigitavelUtil.gerarLinhaDigitavel(codigoDeBarras);

        return new BradescoBoleto(
                sacadoNome,
                sacadoDocumento,
                sacadoEndereco,
                cedenteNome,
                cedenteDocumento,
                cedenteEndereco,
                nossoNumero,
                numeroDocumento,
                vencimento,
                valor,
                bancoCodigo,
                agencia,
                conta,
                carteira,
                codigoDeBarras,
                linhaDigitavel
        );
    }
}
