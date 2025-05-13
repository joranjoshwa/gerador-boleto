import java.util.Calendar;
import java.text.SimpleDateFormat;

public class ItauBoletoBuilder implements BoletoBuilder {

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
        this.bancoCodigo = "341";
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
        String fatorVencimento = CodigoDeBarrasUtil.getFatorVencimento(vencimento);
        String valorFormatado = CodigoDeBarrasUtil.formatarValor(valor);
        String campoLivre = String.format("%03d%08d%04d%08d0",
                Integer.parseInt(carteira),
                nossoNumero,
                Integer.parseInt(agencia),
                Integer.parseInt(conta)
        );
        String baseParaDV = bancoCodigo + "9" + fatorVencimento + valorFormatado + campoLivre;
        int digitoVerificador = CodigoDeBarrasUtil.calcularDigitoModulo11(baseParaDV);
        this.codigoDeBarras = bancoCodigo + "9" + digitoVerificador + fatorVencimento + valorFormatado + campoLivre;
    }

    @Override
    public void buildLinhaDigitavel() {
        String linha = codigoDeBarras.substring(0, 4) + "." +
                codigoDeBarras.substring(4, 9) + " " +
                codigoDeBarras.substring(9, 14) + " " +
                codigoDeBarras.substring(14, 24) + " " +
                codigoDeBarras.substring(24, 25) + " " +
                codigoDeBarras.substring(25);
        this.linhaDigitavel = linha;
    }

    @Override
    public Boleto getBoleto() {
        String bancoCodigo = "341";
        String moeda = "9";
        String numeroDocumento = String.valueOf(System.currentTimeMillis());

        String codigoDeBarras = CodigoDeBarrasUtil.gerarCodigoDeBarras(
                bancoCodigo,
                moeda,
                vencimento,
                valor,
                String.valueOf(carteira),
                String.valueOf(agencia),
                String.valueOf(conta),
                nossoNumero
        );

        String linhaDigitavel = LinhaDigitavelUtil.gerarLinhaDigitavel(codigoDeBarras);

        return new ItauBoleto(
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
                String.valueOf(agencia),
                String.valueOf(conta),
                String.valueOf(carteira),
                codigoDeBarras,
                linhaDigitavel
        );
    }
}
