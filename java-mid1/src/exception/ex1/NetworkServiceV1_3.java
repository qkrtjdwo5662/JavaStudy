package exception.ex1;

public class NetworkServiceV1_3 {
    public void sendMessage(String data){
        String address = "http://example.com";
        NetworkClientV1 client = new NetworkClientV1(address);
        client.initError(data);

        String connectResult = client.connect();
        if(isError(connectResult)){
            System.out.println("[네트워크 오류 발생] 오류 코드 : " + connectResult);
        }else{
            String sendResult = client.send(data);
            if(isError(sendResult)){
                System.out.println("[네트워크 오류 발생] 오류 코드 : " + sendResult);
            }
        }

        // 정상 흐름과 예외 흐름이 섞여 있기 때문에 코드복잡성이 높아졌다.
        client.disconnect();
    }

    private static boolean isError(String result){
        return !result.equals("success");
    }
}
