package NetworkAndThreads.DailyAdvice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class DailyAdviceClient {

    public static void main(String[] args) {
        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
    }

    public void go(){
        try{
            Socket socket = new Socket("127.0.0.1", 5000);
            InputStreamReader is = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(is);

            String advice = reader.readLine();
            System.out.println("Совет дня: \n" + advice);
            reader.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
