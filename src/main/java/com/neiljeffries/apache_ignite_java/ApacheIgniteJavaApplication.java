package com.neiljeffries.apache_ignite_java;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteServer;
// import org.apache.ignite.IgniteServer;
// import org.apache.ignite.IgnitionManager;
// import org.apache.ignite.IgnitionManager;
import org.apache.ignite.client.IgniteClient;
import org.apache.ignite.table.KeyValueView;
import org.apache.ignite.table.Table;
import org.apache.ignite.table.Tuple;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication(scanBasePackages = { "com.neiljeffries" })
public class ApacheIgniteJavaApplication {

    private Ignite ignite;
    private IgniteClient client;
    private Table table;

    public static void main(String[] args) {
        SpringApplication.run(ApacheIgniteJavaApplication.class, args);
    }

    @PostConstruct
    public void initIgnite() throws Exception {

        String nodeName = "node";
        String igniteConfigPath = "src/main/resources/ignite-config.conf";
        String igniteWorkPath = "src/main/resources/work";

        // Read the configuration file as a String
        // String configStr = Files.readString(Path.of(igniteConfigPath));

        // Start Ignite node with the configuration file
        IgniteServer.start(nodeName, Path.of(igniteConfigPath), Path.of(igniteWorkPath));

        // Start embedded Ignite node
        // Ignite ignite = IgnitionManager.start(nodeName, configStr,
        // Path.of(igniteWorkPath)).join();
        // Ignite ignite = node.api();

        // Start Ignite node with the configuration file
        // IgnitionManager.start(nodeName, igniteConfigPath, Path.of(igniteWorkPath)).join();

        // Wait until the node is ready
        // IgnitionManager.init(nodeName, List.of(), configStr);

        // try (IgniteClient client = IgniteClient.builder()
        //         .addresses("127.0.0.1:10800")
        //         .build()) {
        //     KeyValueView<Tuple, Tuple> kvView = client.tables().table("accounts").keyValueView();
        //     System.out.println("\nInserting a key-value pair into the 'accounts' table...");
        //     Tuple key = Tuple.create()
        //             .set("accountNumber", 123456);
        //     Tuple value = Tuple.create()
        //             .set("firstName", "Val")
        //             .set("lastName", "Kulichenko")
        //             .set("balance", 100.00d);
        //     kvView.put(null, key, value);
        //     System.out.println("\nRetrieving a value using KeyValueView API...");
        //     value = kvView.get(null, key);
        //     System.out.println("\nRetrieved value:\n" + "    Account Number: " + key.intValue("accountNumber") + '\n'
        //             + "    Owner: " + value.stringValue("firstName") + " " + value.stringValue("lastName")
        //             + '\n'
        //             + "    Balance: $" + value.doubleValue("balance"));
        // }


    }

    public void putCache(Long id, String value) {
        table.recordView().upsert(
                null, // No transaction
                Tuple.create().set("id", id).set("value", value));
    }

    public String getCache(Long id) {
        Tuple result = table.recordView().get(
                null, // No transaction
                Tuple.create().set("id", id));
        return result == null ? null : result.stringValue("value");
    }
}