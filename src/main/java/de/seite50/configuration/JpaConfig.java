package de.seite50.configuration;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.meecrowave.jpa.api.PersistenceUnitInfoBuilder;
import org.h2.Driver;

import de.seite50.models.Author;

@ApplicationScoped
public class JpaConfig {

	@Produces
	public PersistenceUnitInfoBuilder unit(final DataSource ds) {
		return new PersistenceUnitInfoBuilder()
				.setUnitName("seite50")
				.setDataSource(ds)
				.setExcludeUnlistedClasses(true)
				.addManagedClazz(Author.class)
				.addProperty("openjpa.RuntimeUnenhancedClasses", "supported")
				.addProperty("openjpa.jdbc.SynchronizeMappings", "buildSchema");
	}
	
	@Produces
	@ApplicationScoped
	public DataSource datasource() {
		final BasicDataSource source = new BasicDataSource();
		source.setDriver(new Driver());
		source.setUrl("jdbc:h2:mem:seite50");
		return source;
	}

}
