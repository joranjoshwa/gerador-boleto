import java.util.Calendar;

public class GeradorDeBoleto {

    private BoletoBuilder boletoBuilder;

    public GeradorDeBoleto(BoletoBuilder boletoBuilder) {
        this.boletoBuilder = boletoBuilder;
    }

    public Boleto geraBoleto() {

        boletoBuilder.buildSacadoNome("Marcelo Martins");
        boletoBuilder.buildSacadoDocumento("123.456.789-00");
        boletoBuilder.buildSacadoEndereco("Rua A, 123 - São Paulo/SP");

        boletoBuilder.buildCedenteNome("K19 Treinamentos");
        boletoBuilder.buildCedenteDocumento("45.987.321/0001-00");
        boletoBuilder.buildCedenteEndereco("Av. Paulista, 1000 - São Paulo/SP");

        boletoBuilder.buildNossoNumero(15412);
        boletoBuilder.buildNumeroDocumento("BOLETO-2025-001");

        Calendar vencimento = Calendar.getInstance();
        vencimento.set(2025, Calendar.MAY, 31);
        boletoBuilder.buildVencimento(vencimento);

        boletoBuilder.buildValor(100.54);

        boletoBuilder.buildBancoCodigo("001"); // Banco do Brasil
        boletoBuilder.buildAgencia("1234");
        boletoBuilder.buildConta("56789-0");
        boletoBuilder.buildCarteira("18");

        boletoBuilder.buildCodigoDeBarras();
        boletoBuilder.buildLinhaDigitavel();

        return boletoBuilder.getBoleto();
    }
}
