package mo.spring.hibernateeventsentitylistenersexample.mo_traceability.fake_data;

import java.util.List;
import java.util.Random;

public class FakeData {

    private static List<String> ips = List.of("96.145.45.2", "156.145.100.9", "56.14.55.1", "16.1.2.33", "130.15.45.12");

    public static String randomIp(){
        return ips.get(new Random().nextInt(ips.size()));
    }
}
