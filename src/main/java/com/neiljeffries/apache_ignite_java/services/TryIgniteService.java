package com.neiljeffries.apache_ignite_java.services;

import org.apache.ignite.client.IgniteClient;
import org.apache.ignite.table.KeyValueView;
import org.apache.ignite.table.Tuple;
// import org.apache.ignite.IgniteCache;
import org.springframework.stereotype.Service;

@Service
public class TryIgniteService {

        public String tryIgnite() {

                try (IgniteClient client = IgniteClient.builder()
                                .addresses("127.0.0.1:10800")
                                .build()) {
                        KeyValueView<Tuple, Tuple> kvView = client.tables().table("accounts").keyValueView();
                        System.out.println("\nInserting a key-value pair into the 'accounts' table...");
                        Tuple key = Tuple.create()
                                        .set("accountNumber", 123456);
                        Tuple value = Tuple.create()
                                        .set("firstName", "Val")
                                        .set("lastName", "Kulichenko")
                                        .set("balance", 100.00d);
                        kvView.put(null, key, value);
                        System.out.println("\nRetrieving a value using KeyValueView API...");
                        value = kvView.get(null, key);
                        System.out.println("\nRetrieved value:\n" + "    Account Number: "
                                        + key.intValue("accountNumber") + '\n'
                                        + "    Owner: " + value.stringValue("firstName") + " "
                                        + value.stringValue("lastName")
                                        + '\n'
                                        + "    Balance: $" + value.doubleValue("balance"));
                }
                return null;

        }
}
