package de.seite50.configuration;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.apache.meecrowave.Meecrowave;

@Dependent
public class DefaultsProducer {
    @Inject
    private Meecrowave.Builder builder;

    @Produces
    @ApplicationScoped
    public Defaults defaults() {
        return builder.getExtension(Defaults.class);
    }
}