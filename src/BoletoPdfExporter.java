import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class BoletoPdfExporter {

    public static void exportar(Boleto boleto, String caminhoArquivo) throws IOException {
        PdfWriter writer = new PdfWriter(caminhoArquivo);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        document.add(new Paragraph("=== BOLETO BANCO DO BRASIL ==="));
        document.add(new Paragraph("Sacado: " + boleto.getSacadoNome() + " - " + boleto.getSacadoDocumento()));
        document.add(new Paragraph("Endereço: " + boleto.getSacadoEndereco()));
        document.add(new Paragraph("Cedente: " + boleto.getCedenteNome() + " - " + boleto.getCedenteDocumento()));
        document.add(new Paragraph("Endereço Cedente: " + boleto.getCedenteEndereco()));
        document.add(new Paragraph("Nosso Número: " + boleto.getNossoNumero()));
        document.add(new Paragraph("Número Documento: " + boleto.getNumeroDocumento()));
        document.add(new Paragraph("Vencimento: " + sdf.format(boleto.getVencimento().getTime())));
        document.add(new Paragraph("Valor: R$ " + String.format("%.2f", boleto.getValor())));
        document.add(new Paragraph("Banco: " + boleto.getBancoCodigo() +
                " | Agência: " + boleto.getAgencia() +
                " | Conta: " + boleto.getConta() +
                " | Carteira: " + boleto.getCarteira()));
        document.add(new Paragraph("Código de Barras: " + boleto.getCodigoDeBarras()));
        document.add(new Paragraph("Linha Digitável: " + boleto.getLinhaDigitavel()));

        document.close();

        System.out.println("PDF do boleto gerado com sucesso em: " + caminhoArquivo);
    }
}
