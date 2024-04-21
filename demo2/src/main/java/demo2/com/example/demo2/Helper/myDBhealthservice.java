package demo2.com.example.demo2.Helper;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Controller;

@Controller
public class myDBhealthservice implements HealthIndicator {

     public static final String DB_SERVICE="Database Service";
    public boolean ishealthgood(){
        return true;
    }
    @Override
    public Health health() {
        if (ishealthgood()){
            return Health.up().withDetail(DB_SERVICE,"Database is working properly and Up").build();
        }
     return Health.down().withDetail(DB_SERVICE,"Database service is running down").build();
    }
}
