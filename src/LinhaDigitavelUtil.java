public class LinhaDigitavelUtil {

    private static int calcularDigitoModulo10(String numero) {
        int soma = 0;
        int peso = 2;

        for (int i = numero.length() - 1; i >= 0; i--) {
            int multiplicacao = Character.getNumericValue(numero.charAt(i)) * peso;
            if (multiplicacao > 9) multiplicacao = (multiplicacao / 10) + (multiplicacao % 10);
            soma += multiplicacao;
            peso = (peso == 2) ? 1 : 2;
        }

        int resto = soma % 10;
        return (resto == 0) ? 0 : 10 - resto;
    }

    public static String gerarLinhaDigitavel(String codigoDeBarras) {
        if (codigoDeBarras.length() != 44) {
            throw new IllegalArgumentException("Código de barras deve ter 44 dígitos.");
        }

        String banco = codigoDeBarras.substring(0, 3);
        String moeda = codigoDeBarras.substring(3, 4);
        String dvGeral = codigoDeBarras.substring(4, 5); // campo 4
        String fatorVencimento = codigoDeBarras.substring(5, 9);
        String valor = codigoDeBarras.substring(9, 19);
        String campoLivre = codigoDeBarras.substring(19, 44);

        String campo1 = banco + moeda + campoLivre.substring(0, 5);
        String dv1 = String.valueOf(calcularDigitoModulo10(campo1));
        campo1 = campo1.substring(0, 5) + "." + campo1.substring(5) + dv1;

        String campo2 = campoLivre.substring(5, 15);
        String dv2 = String.valueOf(calcularDigitoModulo10(campo2));
        campo2 = campo2.substring(0, 5) + "." + campo2.substring(5) + dv2;

        String campo3 = campoLivre.substring(15, 25);
        String dv3 = String.valueOf(calcularDigitoModulo10(campo3));
        campo3 = campo3.substring(0, 5) + "." + campo3.substring(5) + dv3;

        String campo4 = dvGeral;

        String campo5 = fatorVencimento + valor;

        return campo1 + " " + campo2 + " " + campo3 + " " + campo4 + " " + campo5;
    }
}
