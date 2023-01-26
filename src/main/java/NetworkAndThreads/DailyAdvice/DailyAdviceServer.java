package NetworkAndThreads.DailyAdvice;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviceServer {

    public static void main(String[] args) {
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }

    String[] adviceList = {"Ты сегодня стал лучше", "Ешь только правильную еду", "У тебя самый красивый пресс"};
    public void go(){
        try{
            ServerSocket serverSocket = new ServerSocket(5000);
            while (true){
                Socket socket = serverSocket.accept();
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
                String advice = getAdvice();
                printWriter.println(advice);
                printWriter.close();
                System.out.println(advice);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getAdvice(){
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }
}
