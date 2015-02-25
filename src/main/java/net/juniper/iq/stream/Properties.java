package net.juniper.iq.stream;

import org.apache.log4j.Logger;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;

public class Properties
{
    private static final Logger LOGGER = Logger.getLogger(Properties.class);
    private static Properties singleton;

    private Configuration config;
    private static String propertyPath;

    private Properties()
    {
        try
        {
        	String path = "/junosiq_stream_local.properties";
        	//String path = "/junosiq_stream_local_1sec.properties";
        	//String path = "/junosiq_stream_local_30sec.properties";
        	//String path = "/junosiq_stream_local_1min.properties";

        	//String path = "/junosiq_stream_aws.properties";
        	//String path = "/junosiq_stream_aws_1sec.properties";
        	//String path = "/junosiq_stream_aws_30sec.properties";
        	//String path = "/junosiq_stream_aws_1min.properties";

        	this.config = new PropertiesConfiguration(
	                this.getClass().getResource(path));
        }
        catch (Exception ex)
        {
            LOGGER.fatal("Could not load configuration", ex);
            LOGGER.trace(null, ex);
        }
    }

    private static Properties get()
    {
        if (singleton == null)
            singleton = new Properties();
        return singleton;
    }

    public static String getString(String key)
    {
        return get().config.getString(key);
    }

    public static Integer getInt(String key)
    {
        return get().config.getInt(key);
    }
    
}
