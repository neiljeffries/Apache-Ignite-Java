// package com.neiljeffries.apache_ignite_java.configs;

// import org.apache.ignite.Ignite;
// import org.apache.ignite.Ignition;
// import org.apache.ignite.configuration.CacheConfiguration;
// import org.apache.ignite.configuration.IgniteConfiguration;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import jakarta.annotation.PreDestroy;

// @Configuration
// public class IgniteConfig {


//     private Ignite ignite;

//     @Bean(destroyMethod = "close")
//     public Ignite igniteInstance() {
//         try {
//             IgniteConfiguration cfg = new IgniteConfiguration();
//             cfg.setIgniteInstanceName("springBootIgniteInstance");
//             cfg.setPeerClassLoadingEnabled(true);

//             CacheConfiguration<String, String> cacheCfg = new CacheConfiguration<>();
//             cacheCfg.setName("greetingCache");
//             cfg.setCacheConfiguration(cacheCfg);

//             ignite = Ignition.start(cfg);
//             return ignite;
//         } catch (Exception e) {
//             System.err.println("Failed to start Ignite: " + e.getMessage());
//             e.printStackTrace();
//             throw new IllegalStateException("Ignite startup failed", e);
//         }
//     }

//     @PreDestroy
//     public void shutdownIgnite() {
//         if (ignite != null) {
//             ignite.close();
//         }
//     }
// }
