import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

public class RMICliente {

    public static void main(String[] args) {
        try {
            // Conecta ao servidor (localhost)
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Obtém o objeto remoto
            RemoteDic dic = (RemoteDic) registry.lookup("DicionarioService");

            while (true) {
                String palavra = JOptionPane.showInputDialog(null,
                        "Digite uma palavra em português (ou 'sair' para encerrar):",
                        "Cliente Dicionário RMI",
                        JOptionPane.QUESTION_MESSAGE);

                if (palavra == null || palavra.equalsIgnoreCase("sair")) {
                    break;
                }

                // Chama o método remoto
                String traducao = dic.traduzir(palavra);

                JOptionPane.showMessageDialog(null,
                        "Tradução de '" + palavra + "' é: " + traducao,
                        "Resultado",
                        JOptionPane.INFORMATION_MESSAGE);
            }

            JOptionPane.showMessageDialog(null, "Cliente encerrado.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no cliente RMI: " + e.getMessage());
            e.printStackTrace();
        }
    }
}