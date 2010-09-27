/**
 * 
 */
package edu.utdallas.hadooprdf.data.preprocessing.dictionary;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.junit.Before;
import org.junit.Test;

import edu.utdallas.hadooprdf.conf.ConfigurationNotInitializedException;
import edu.utdallas.hadooprdf.data.metadata.DataFileExtensionNotSetException;
import edu.utdallas.hadooprdf.data.metadata.DataSet;

/**
 * @author Mohammad Farhan Husain
 *
 */
public class DictionaryEncoderTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Create cluster configuration
		org.apache.hadoop.conf.Configuration hadoopConfiguration = new Configuration();
		//String sConfDirectoryPath = "conf/SAIALLabCluster";
		String sConfDirectoryPath = "conf/SemanticWebLabCluster";
		hadoopConfiguration.addResource(new Path(sConfDirectoryPath + "/core-site.xml"));
		hadoopConfiguration.addResource(new Path(sConfDirectoryPath + "/hdfs-site.xml"));
		hadoopConfiguration.addResource(new Path(sConfDirectoryPath + "/mapred-site.xml"));
		// Create application configuration
		edu.utdallas.hadooprdf.conf.Configuration config =
			edu.utdallas.hadooprdf.conf.Configuration.createInstance(hadoopConfiguration, "/user/farhan/hadooprdf");
		config.setNumberOfTaskTrackersInCluster(5); // 5 for semantic web lab, 10 for SAIAL lab
	}

	/**
	 * Test method for {@link edu.utdallas.hadooprdf.data.preprocessing.dictionary.DictionaryEncoder#dictionaryEncode()}.
	 */
	@Test
	public void testDictionaryEncode() {
		try {
			DataSet ds = new DataSet("/user/farhan/hadooprdf/LUBM1");
			ds.setOriginalDataFilesExtension("owl");
			DictionaryEncoder de = new DictionaryEncoder(ds);
			de.dictionaryEncode();
		} catch (ConfigurationNotInitializedException e) {
			System.err.println("ConfigurationNotInitializedException occurred while testing DictionaryCreator.createDictionary\n" + e.getMessage());
			e.printStackTrace();
			fail(e.getMessage());
		} catch (IOException e) {
			System.err.println("IOException occurred while testing DictionaryCreator.createDictionary\n" + e.getMessage());
			e.printStackTrace();
			fail(e.getMessage());
		} catch (DataFileExtensionNotSetException e) {
			System.err.println("DataFileExtensionNotSetException occurred while testing DictionaryCreator.createDictionary\n" + e.getMessage());
			e.printStackTrace();
			fail(e.getMessage());
		} catch (DictionaryEncoderException e) {
			System.err.println("DictionaryEncoderException occurred while testing DictionaryCreator.createDictionary\n" + e.getMessage());
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}