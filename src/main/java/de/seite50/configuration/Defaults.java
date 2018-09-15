package de.seite50.configuration;

import org.apache.meecrowave.runner.Cli;
import org.apache.meecrowave.runner.cli.CliOption;

public class Defaults implements Cli.Options {

	@CliOption(name = "seite50-name", description = "Der Name der Applikation")
	private String name = "Seite50";
	
	public String getName() {
		return name;
	}
}
