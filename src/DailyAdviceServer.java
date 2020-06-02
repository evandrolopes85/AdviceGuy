import java.io.PrintWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviceServer {
	String[] adviceList = { "Morda pedaços menores", "Useo jeans apertado. Não, ele NÂO faz você parecer gorda", "Só vou dizer uma palavra: inapropriado", "Pelo menos hoje, seja honesta. Diga a seu chefe o que realmente pensa", "Reconsidere esse corte e cabelo." };

	public void go() {

		try{
			// O servidor vai escutar solicitações do servidor na porte 4242
			ServerSocket serverSocket = new ServerSocket( 4242 );

			while ( true ) {
				// O metodo accept vai ficar aguardando até uma solicitação chegar
				// e enviara um objeto socket em alguma porta anonima do cliente 
				Socket socket = serverSocket.accept();

				// Envia o fluxo de dados para o socket uma String por vez
				PrintWriter writer = new PrintWriter( socket.getOutputStream() );
				String advice = getAdvice();
				writer.println( advice );
				writer.close();

				System.out.println( advice );
			} // fim do while
		}catch( IOException ex ){
			ex.printStackTrace();
		} // fim do try/catch
	} // fim do método go

	// retorna frases aleatoriamente do vetor adviceList
	private String getAdvice() {
		int random = ( int ) ( Math.random() * adviceList.length );
		return adviceList[ random ];
	} // fim do método getAdvice

	public static void main( String[] args ){
		DailyAdviceServer server = new DailyAdviceServer();
		server.go();
	} // fim do método main
} // fim da classe DailyAdviceServer