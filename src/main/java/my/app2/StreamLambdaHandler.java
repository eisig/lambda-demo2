package my.app2;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.model.*;
import com.amazonaws.services.lambda.runtime.*;
import io.micronaut.function.aws.proxy.MicronautLambdaContainerHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class StreamLambdaHandler implements RequestStreamHandler {
    private static final Logger log = LoggerFactory.getLogger(StreamLambdaHandler.class);
    private static MicronautLambdaContainerHandler handler; // <1>
    static {
        try {
            handler = MicronautLambdaContainerHandler.getAwsProxyHandler();
        } catch (ContainerInitializationException e) {
            // if we fail here. We re-throw the exception to force another cold start
            e.printStackTrace();
            throw new RuntimeException("Could not initialize Micronaut", e);
        }
    }

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context)
            throws IOException {
        log.info("handleRequest..");
        handler.proxyStream(inputStream, outputStream, context); // <2>
    }
}