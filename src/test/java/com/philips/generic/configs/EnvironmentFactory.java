package com.philips.generic.configs;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.PropertyConfigurator;

import com.philips.generic.AutomationConstants;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by M1038068 on 8/8/2017.
 */
public class EnvironmentFactory {

    //private static Logger log = Logger.getLogger(EnvironmentFactory.class);

    private static Map<String, Map<String, String>> configMap = new HashMap<String, Map<String, String>>();
    
    static {
    	//System.out.println(System.getProperty("user.dir")+"\\src\\config.xml");
        XMLStreamReader xsr = null;
        InputStream paramInputStream = null;
        try {
        	
            configMap.clear();
            JAXBContext jc = JAXBContext.newInstance(Environments.class);

            XMLInputFactory xif = XMLInputFactory.newInstance();
            xif.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES,
                    false);
            xif.setProperty(XMLInputFactory.SUPPORT_DTD, false);
            /*paramInputStream = EnvironmentFactory.class.getClassLoader()
                   .getResourceAsStream("config.xml");*/
            //paramInputStream = (InputStream) xif.createXMLStreamReader();
            xsr = xif.createXMLStreamReader(new FileInputStream(AutomationConstants.configpaht));

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            Environments adaptedWrapper = (Environments) unmarshaller
                    .unmarshal(xsr);
            List<Environment> envs = adaptedWrapper.getEnvironments();

            for (Environment env : envs) {

                if (env != null) {

                    Set<Parameter> keyNValues = env.getParam();

                    Map<String, String> map = Collections.emptyMap();

                    if (CollectionUtils.isNotEmpty(keyNValues)) {

                        map = new HashMap<String, String>();

                        for (Parameter parameter : keyNValues) {

                            if (parameter != null) {
                                map.put(parameter.getKey(),
                                        parameter.getValue());
                            }

                        }
                    }

                    Object obj = configMap.put(env.getName(), map);

                    if (obj != null) {
                        throw new Exception(
                                "Duplicate environment name in metadata file");
                    }

                }

            }

        } catch (Exception e) {
            //log.error("Unable to convert environemt.xml to environemnt", e);
        	System.out.println(e);
        } finally {
            if (xsr != null || paramInputStream != null) {
                try {
                    if (xsr != null) {
                        xsr.close();
                    }

                    if (paramInputStream != null) {
                        paramInputStream.close();
                    }
                } catch (XMLStreamException e) {
                    //log.error("Unable to close stream reader", e);
                } catch (IOException e) {
                }
            }
        }

    }

    public static final String getConfigValue(String key) /*throws Exception */{

    	Map<String, String> sp = configMap.get(AutomationConstants.sandbox);
        if (sp == null) 
        {
            assert false;
            return null;
        } 
        else 
        {
            return sp.get(key);
        }
    }

    public static void reinit(){
        configMap.clear();
        XMLStreamReader xsr = null;
        InputStream paramInputStream = null;
        try {
            JAXBContext jc = JAXBContext.newInstance(Environments.class);

            XMLInputFactory xif = XMLInputFactory.newInstance();
            xif.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES,
                    false);
            xif.setProperty(XMLInputFactory.SUPPORT_DTD, false);
            //paramInputStream = EnvironmentFactory.class.getClassLoader()
            //        .getResourceAsStream(System.getProperty("user.dir") + "\\src\\test\\resources\\configtmp.xml");
            paramInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\config.xml");
            xsr = xif.createXMLStreamReader(paramInputStream);

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            Environments adaptedWrapper = (Environments) unmarshaller
                    .unmarshal(xsr);
            List<Environment> envs = adaptedWrapper.getEnvironments();

            for (Environment env : envs) {

                if (env != null) {

                    Set<Parameter> keyNValues = env.getParam();

                    Map<String, String> map = Collections.emptyMap();

                    if (CollectionUtils.isNotEmpty(keyNValues)) {

                        map = new HashMap<String, String>();

                        for (Parameter parameter : keyNValues) {

                            if (parameter != null) {
                                if (parameter.getKey().contains("configSpecialistUserID")) {System.out.println("Reinit Printing===" + parameter.getKey() + "_" + parameter.getValue());}
                                map.put(parameter.getKey(),
                                        parameter.getValue());
                            }

                        }
                    }
                    Object obj = configMap.put(env.getName(), map);

                    if (obj != null) {
                        throw new Exception(
                                "Duplicate environment name in metadata file");
                    }

                }

            }

        } catch (Exception e) {
            //log.error("Unable to convert environemt.xml to environemnt", e);
        } finally {
            if (xsr != null || paramInputStream != null) {
                try {
                    if (xsr != null) {
                        xsr.close();
                    }

                    if (paramInputStream != null) {
                        paramInputStream.close();
                    }
                } catch (XMLStreamException e) {
                    //log.error("Unable to close stream reader", e);
                } catch (IOException e) {
                }
            }
        }

    }
    
    public static final String getSeeTestConfig(String key) {
		Map<String, String> sp = configMap.get(AutomationConstants.iPadTest);
		if (sp == null) {
			assert false;
			return null;
		} else {
			return sp.get(key);
		}
	}

}