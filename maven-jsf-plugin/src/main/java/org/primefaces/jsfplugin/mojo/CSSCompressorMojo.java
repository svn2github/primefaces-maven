/*
 * Copyright 2009-2011 Prime Technology.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.primefaces.jsfplugin.mojo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;

/**
 * @goal compress-css
 */
public class CSSCompressorMojo extends AbstractMojo {

    /**
	 * @parameter expression="${project}"
	 * @required
	 * @readonly
	 */
	protected MavenProject project;

    public void execute() throws MojoExecutionException, MojoFailureException {
        String outputDirectory = project.getBuild().getOutputDirectory() + File.separator
                + "META-INF" + File.separator + "resources" + File.separator + "primefaces";
        getLog().info(outputDirectory);
        
        File resourcesFolders[] = new File(outputDirectory).listFiles();

        for(File resourceFolder : resourcesFolders) {
            File[] resources = resourceFolder.listFiles();
            for(File resource : resources) {
                if(resource.getName().endsWith("css")) {

                    try {
                        processCSS(resource);
                    }catch(IOException e) {
                        throw new MojoExecutionException("IOException in compressing CSS", e);
                    }
                }
            }
        }
    }

    private void processCSS(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = null;

        StringBuilder builder = new StringBuilder();

        while((line = reader.readLine()) != null) {
            builder.append(line.replaceAll("\n", "").replaceAll("^\\s*","").replaceAll("\\s*[{]\\s*", "{").replaceAll("\\s*[:]\\s*", ":").replaceAll("\\s*[;]\\s*", ";"));
        }

        reader.close();
        fileReader.close();

        FileWriter fileWriter = new FileWriter(file.getAbsolutePath());
        BufferedWriter writer = new BufferedWriter(fileWriter);

        writer.write(builder.toString());

        builder = null;
        writer.close();
        fileWriter.close();
    }
}