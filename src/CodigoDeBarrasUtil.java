import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CodigoDeBarrasUtil {

    public static String getFatorVencimento(Calendar vencimento) {
        Calendar base = Calendar.getInstance();
        base.set(1997, Calendar.OCTOBER, 7);
        long diff = (vencimento.getTimeInMillis() - base.getTimeInMillis()) / (1000 * 60 * 60 * 24);
        return String.format("%04d", diff);
    }

    public static String formatarValor(double valor) {
        DecimalFormat df = new DecimalFormat("0000000000");
        return df.format(Math.round(valor * 100));
    }

    public static int calcularDigitoModulo11(String numero) {
        int soma = 0;
        int peso = 2;

        for (int i = numero.length() - 1; i >= 0; i--) {
            soma += Character.getNumericValue(numero.charAt(i)) * peso;
            peso = (peso == 9) ? 2 : peso + 1;
        }

        int resto = soma % 11;
        int digito = 11 - resto;

        if (digito == 0 || digito == 10 || digito == 11) return 1;
        return digito;
    }

    public static String gerarCodigoDeBarras(String banco, String moeda, Calendar vencimento, double valor,
                                             String carteira, String agencia, String conta, int nossoNumero) {
        String fatorVencimento = getFatorVencimento(vencimento);
        String valorFormatado = formatarValor(valor);

        String campoLivre = String.format("%03d%08d%04d%08d0",
                Integer.parseInt(carteira),
                nossoNumero,
                Integer.parseInt(agencia),
                Integer.parseInt(conta)
        );

        String semDV = banco + moeda + fatorVencimento + valorFormatado + campoLivre;

        String baseParaDV = banco + moeda + fatorVencimento + valorFormatado + campoLivre;
        int dv = calcularDigitoModulo11(baseParaDV);

        String codigoDeBarras = banco + moeda + dv + fatorVencimento + valorFormatado + campoLivre;
        return codigoDeBarras;
    }
}
