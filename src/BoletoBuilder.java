import java.util.Calendar;

public interface BoletoBuilder {


    void buildSacadoNome(String nome);
    void buildSacadoDocumento(String documento);
    void buildSacadoEndereco(String endereco);


    void buildCedenteNome(String nome);
    void buildCedenteDocumento(String documento);
    void buildCedenteEndereco(String endereco);


    void buildNossoNumero(int nossoNumero);
    void buildNumeroDocumento(String numeroDocumento);
    void buildVencimento(Calendar vencimento);
    void buildValor(double valor);


    void buildBancoCodigo(String codigoBanco);
    void buildAgencia(String agencia);
    void buildConta(String conta);
    void buildCarteira(String carteira);


    void buildCodigoDeBarras();
    void buildLinhaDigitavel();


    Boleto getBoleto();
}