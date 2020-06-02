import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

public class DailyAdviceClient {

	public void go(){
		try{
			// Cria uma conexão com o servidor ( maquina local ) na porta 4242
			Socket s = new Socket( "127.0.0.1", 4242 );

			// Lê o fluxo de dados vindo do Socket e converte em caracteres
			InputStreamReader streamReader = new InputStreamReader( s.getInputStream() );

			// Armazena o fluxo de dados no Buffer
			BufferedReader reader = new BufferedReader( streamReader );

			String advice = reader.readLine();
			System.out.println( "Today you should: " + advice );

			reader.close();

		}catch(IOException ex){
			ex.printStackTrace();
		} // fim do catch
	} // fim do método go

	public static void main( String[] args ) {

		DailyAdviceClient client = new DailyAdviceClient();
		client.go();

	} // fim do método main
} // fim da classe
