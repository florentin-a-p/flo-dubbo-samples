package org.apache.dubbo.samples.provider;

import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;
import org.apache.dubbo.config.bootstrap.builders.ApplicationBuilder;
import org.apache.dubbo.config.bootstrap.builders.ProtocolBuilder;
import org.apache.dubbo.config.bootstrap.builders.ServiceBuilder;
import org.apache.dubbo.samples.api.GreetingsService;

public class DummyApplication {

    public static void main(String[] args) {
        DubboBootstrap.getInstance()
                .application(ApplicationBuilder.newBuilder()
                        .name("dubbo-samples-api-dummy-asdfasdfsadf")
                        .logger("slf4j")
                        .build())
                .registry(new RegistryConfig("zookeeper://127.0.0.1:2181"))
                .protocol(ProtocolBuilder.newBuilder()
                        .name("tri")
                        .port(50053)
                        .build())
                .service(ServiceBuilder.newBuilder()
                        .interfaceClass(GreetingsService.class)
                        .ref(new GreetingsServiceImpl())
                        //.group("dummy-asdfasdfsadf")
                        .tag("flo-dummy-tag")
                        .build())
                .start()
                .await();
    }
}
