import java.util.Calendar;

public class Main {
    public static void main(String[] args) {

        // Criação do boleto via builder
        ItauBoletoBuilder builder = new ItauBoletoBuilder();

        builder.buildSacadoNome("Carlos Silva");
        builder.buildSacadoDocumento("987.654.321-00");
        builder.buildSacadoEndereco("Rua Imaginária, 999");

        builder.buildCedenteNome("Loja ABC Ltda");
        builder.buildCedenteDocumento("23.456.789/0001-01");
        builder.buildCedenteEndereco("Avenida Central, 1000");

        builder.buildNossoNumero(12345678);
        builder.buildNumeroDocumento("DOC987654");

        // Definindo a data de vencimento
        Calendar vencimento = Calendar.getInstance();
        vencimento.set(2025, Calendar.JUNE, 10);
        builder.buildVencimento(vencimento);

        builder.buildValor(2000.50);
        builder.buildBancoCodigo("341");  // Código do Banco Itaú
        builder.buildAgencia("5678");
        builder.buildConta("123456");
        builder.buildCarteira("17");

        // Gerando o boleto
        Boleto boleto = builder.getBoleto();

        // Geração do PDF
        String caminho = "boleto_itau.pdf";
        PDFUtil.exportarParaPDF(boleto, caminho);  // ou BoletoPdfExporter.exportarParaPDF(...)

        System.out.println("Boleto gerado em PDF com sucesso: " + caminho);




//        // Criação do boleto via builder
//        BBBoletoBuilder builder = new BBBoletoBuilder();
//
//        builder.buildSacadoNome("João da Silva");
//        builder.buildSacadoDocumento("123.456.789-00");
//        builder.buildSacadoEndereco("Rua Fictícia, 123");
//
//        builder.buildCedenteNome("Empresa XYZ Ltda");
//        builder.buildCedenteDocumento("12.345.678/0001-90");
//        builder.buildCedenteEndereco("Avenida Imaginária, 456");
//
//        builder.buildNossoNumero(12345678);
//        builder.buildNumeroDocumento("DOC123456");
//
//        Calendar vencimento = Calendar.getInstance();
//        vencimento.set(2025, Calendar.MAY, 15);
//        builder.buildVencimento(vencimento);
//
//        builder.buildValor(1500.75);
//        builder.buildBancoCodigo("001");
//        builder.buildAgencia("1234");
//        builder.buildConta("567890");
//        builder.buildCarteira("109");
//
//        Boleto boleto = builder.getBoleto();
//
//        // Geração do PDF
//        String caminho = "boleto_banco_do_brasil.pdf";
//        PDFUtil.exportarParaPDF(boleto, caminho);  // ou BoletoPdfExporter.exportarParaPDF(...)
//
//        System.out.println("Boleto gerado em PDF com sucesso: " + caminho);



//        // Criação do boleto via builder
//        BradescoBoletoBuilder builder = new BradescoBoletoBuilder();
//
//        builder.buildSacadoNome("Maria Oliveira");
//        builder.buildSacadoDocumento("987.654.321-00");
//        builder.buildSacadoEndereco("Rua das Flores, 789");
//
//        builder.buildCedenteNome("Loja ABC");
//        builder.buildCedenteDocumento("98.765.432/0001-00");
//        builder.buildCedenteEndereco("Avenida Brasil, 321");
//
//        builder.buildNossoNumero(12345678);
//        builder.buildNumeroDocumento("DOC998877");
//
//        Calendar vencimento = Calendar.getInstance();
//        vencimento.set(2025, Calendar.MAY, 20);
//        builder.buildVencimento(vencimento);
//
//        builder.buildValor(2450.00);
//        builder.buildBancoCodigo("237"); // Bradesco
//        builder.buildAgencia("1234");
//        builder.buildConta("567890");
//        builder.buildCarteira("06");
//
//        // Geração do boleto com código de barras e linha digitável
//        Boleto boleto = builder.getBoleto();
//
//        // Exportar para PDF
//        String caminho = "boleto_bradesco.pdf";
//        PDFUtil.exportarParaPDF(boleto, caminho);
//
//        System.out.println("Boleto do Bradesco gerado em PDF com sucesso: " + caminho);


    }
}



