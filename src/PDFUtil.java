import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.Document;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;

import java.io.IOException;

public class PDFUtil {

    public static void exportarParaPDF(Boleto boleto, String caminhoArquivo) {
        try {
            PdfWriter writer = new PdfWriter(caminhoArquivo);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            String nomeBanco = "Banco Desconhecido";
            String codigoBanco = boleto.getBancoCodigo();
            if (codigoBanco != null) {
                switch (codigoBanco) {
                    case "001":
                        nomeBanco = "Banco do Brasil";
                        break;
                    case "341":
                        nomeBanco = "Itaú";
                        break;
                    case "237":
                        nomeBanco = "Bradesco";
                        break;
                }
            }

            document.add(new Paragraph("=== BOLETO BANCÁRIO - " + nomeBanco + " ==="));
            document.add(new Paragraph("Sacado: " + boleto.getSacadoNome()));
            document.add(new Paragraph("Documento: " + boleto.getSacadoDocumento()));
            document.add(new Paragraph("Endereço: " + boleto.getSacadoEndereco()));

            document.add(new Paragraph("Cedente: " + boleto.getCedenteNome()));
            document.add(new Paragraph("Documento Cedente: " + boleto.getCedenteDocumento()));
            document.add(new Paragraph("Endereço Cedente: " + boleto.getCedenteEndereco()));

            document.add(new Paragraph("Nosso Número: " + boleto.getNossoNumero()));
            document.add(new Paragraph("Número Documento: " + boleto.getNumeroDocumento()));
            document.add(new Paragraph("Vencimento: " + boleto.getVencimento().getTime()));
            document.add(new Paragraph("Valor: R$ " + String.format("%.2f", boleto.getValor())));

            document.add(new Paragraph("Banco: " + boleto.getBancoCodigo()));
            document.add(new Paragraph("Agência: " + boleto.getAgencia()));
            document.add(new Paragraph("Conta: " + boleto.getConta()));
            document.add(new Paragraph("Carteira: " + boleto.getCarteira()));

            document.add(new Paragraph("Código de Barras: " + boleto.getCodigoDeBarras()));
            document.add(new Paragraph("Linha Digitável: " + boleto.getLinhaDigitavel()));

            document.close();

            System.out.println("PDF gerado com sucesso em: " + caminhoArquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
