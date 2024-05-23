package com.micoservice.gatewayservice.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigGateway {


   /*DiscoveryClientRouteDefinitionLocator dynamicRoutes(ReactiveDiscoveryClient rdc,
                                                       DiscoveryLocatorProperties dlp){
       return new DiscoveryClientRouteDefinitionLocator(rdc,dlp);
    }*/

   /* @Bean
    RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r->r.path("/countries/**")
                        .filters(f->f
                                .addRequestHeader("x-rapidapi-host","restcountries-v1.p.rapidapi.com")
                                .addRequestHeader("x-rapidapi-key","4d0d873110msh6d167a3e3212790p1a9d7bjsn92a9b3fe4fef")
                                .rewritePath("/countries/(?<segment>.*)","/${segment}")
                                .circuitBreaker(h->h.setName("countries").setFallbackUri("forward:/defaultCountries"))
                        )
                        .uri("https://restcountries-v1.p.rapidapi.com")
                )
                .route(r->r.path("/muslimsalat/**")
                        .filters(f->f
                                .addRequestHeader("x-rapidapi-host","restcountries-v1.p.rapidapi.com")
                                .addRequestHeader("x-rapidapi-key","4d0d873110msh6d167a3e3212790p1a9d7bjsn92a9b3fe4fef")
                                .rewritePath("/muslimsalat/(?<segment>.*)","/${segment}")
                )
                        .uri("https://muslimsalat.p.rapidapi.com")
                ).build();

    }*/
}
