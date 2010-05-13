package edu.utdallas.hadooprdf.query;

import edu.utdallas.hadooprdf.data.metadata.DataSet;

/**
 * An interface for an execution of a query
 * @author vaibhav
 *
 */
public interface QueryExecution 
{
	/**
	 * A method that executes a SELECT SPARQL query
	 * @return the output file that contains the results
	 */
	public String execSelect() ;
	
	/**
	 * A method that returns the DataSet object used in the current QueryExecution
	 * @return the DataSet object used by this QueryExecution object
	 */
	public DataSet getDataSet() ;
}