package videoDownloader;

import videoDownloader.configuration.Configuration;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alexandriann on 02/01/16.
 */
public class ConfigurationTest {

    public static final String PROPERTY = "test";

    @Test
    public void testGetProperty() throws Exception{
        final String propertyValue = Configuration.getInstance().getPropertyValue(PROPERTY);
        assertTrue(propertyValue.equals(PROPERTY));
    }
}
