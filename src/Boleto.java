import java.util.Calendar;

public interface Boleto {

    String getSacadoNome();
    String getSacadoDocumento();
    String getSacadoEndereco();

    String getCedenteNome();
    String getCedenteDocumento();
    String getCedenteEndereco();

    int getNossoNumero();
    String getNumeroDocumento();
    Calendar getVencimento();
    double getValor();

    String getBancoCodigo();
    String getAgencia();
    String getConta();
    String getCarteira();


    String getCodigoDeBarras();
    String getLinhaDigitavel();


    void exportarParaPDF(String caminhoArquivo);

    @Override
    String toString();
}