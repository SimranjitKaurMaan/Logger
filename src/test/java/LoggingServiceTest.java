import com.simran.*;
import com.simran.abstractions.ISink;
import com.simran.models.Level;
import com.simran.models.Message;
import com.simran.models.SinkType;
import com.simran.services.Configuration;
import com.simran.services.LoggingService;
import com.simran.services.SinkService;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoggingServiceTest
{

    @Test
    public void defaultTest()
    {
        Map<Level, List<SinkType>> configMap = new HashMap<>();
        configMap.put(Level.fatal, Arrays.asList(SinkType.text));
        configMap.put(Level.error, Arrays.asList(SinkType.console));
        configMap.put(Level.warn, Arrays.asList(SinkType.text));
        configMap.put(Level.info, Arrays.asList(SinkType.console));
        configMap.put(Level.debug, Arrays.asList(SinkType.text));
        Configuration configuration = new Configuration(configMap);
        SinkService sinkService = new SinkService(configuration);
        LoggingService loggingService = new LoggingService(sinkService);
        Message message1 = new Message("message1",Level.fatal,"ModalityComponent");
        loggingService.logMessage(message1);
        Message message2 = new Message("message2",Level.error,"VSAComponent");
        loggingService.logMessage(message2);
        Message message3 = new Message("message3",Level.info,"VSAAComponent");
        loggingService.logMessage(message3);
    }
}
