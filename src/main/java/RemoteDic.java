import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteDic extends Remote {
    // Recebe uma palavra em português e retorna a tradução em inglês
    public String traduzir(String palavraPortugues) throws RemoteException;
}