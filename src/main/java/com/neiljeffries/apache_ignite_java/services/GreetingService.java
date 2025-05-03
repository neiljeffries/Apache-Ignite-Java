// package com.neiljeffries.apache_ignite_java.services;
// import org.apache.ignite.Ignite;
// import org.apache.ignite.IgniteCache;
// import org.springframework.stereotype.Service;

// @Service
// public class GreetingService {

//     private final IgniteCache<String, String> cache;

//     public GreetingService(Ignite ignite) {
//         this.cache = ignite.getOrCreateCache("greetingCache");
//     }

//     public String getGreeting(String name) {
//         String cached = cache.get(name);
//         if (cached != null) {
//             return "[Cached] " + cached;
//         }

//         String greeting = "Hello, " + name + "!";
//         cache.put(name, greeting);
//         return greeting;
//     }
// }
