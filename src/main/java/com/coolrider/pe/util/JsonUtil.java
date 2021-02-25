package com.coolrider.pe.util;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonUtil
{
	private static final ObjectMapper objectMapper = new ObjectMapper();
	private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);
	public static final String ERROR_PARSER = "error al parsear trama: ";

	protected JsonUtil() throws IllegalAccessException
	{
		throw new IllegalAccessException("Clase estatica");
	}

	public static String getCampo(String nombre, JsonNode rootNode)
	{
		List<JsonNode> padres = rootNode.findParents(nombre);
		if (padres != null && !padres.isEmpty())
		{
			Iterator<JsonNode> iterator = padres.iterator();
			while (iterator.hasNext())
			{
				JsonNode parent = iterator.next();
				JsonNode campo = parent.get(nombre);
				if (campo != null && campo.isTextual())
				{
					return campo.textValue();
				}
			}
		}
		return StringUtils.EMPTY;
	}

	public static String getCampoTrama(String nombre, String trama)
	{
		JsonNode rootNode;
		try
		{
			rootNode = objectMapper.readTree(trama);
			return getCampo(nombre, rootNode);
		} catch (IOException e)
		{
			logger.error(ERROR_PARSER + e.getMessage(), e);
		}
		return StringUtils.EMPTY;
	}

	public static JsonNode getNodeReference(String nombre, JsonNode rootNode)
	{
		List<JsonNode> padres = rootNode.findParents(nombre);
		if (padres != null && !padres.isEmpty())
		{
			Iterator<JsonNode> iterator = padres.iterator();
			while (iterator.hasNext())
			{
				JsonNode parent = iterator.next();
				JsonNode campo = parent.get(nombre);
				if (campo != null && !(campo instanceof MissingNode) && !(campo instanceof NullNode))
				{
					return campo;
				}
			}
		}
		return null;
	}

	public static JsonNode getNode(String nombre, String trama)
	{
		JsonNode rootNode;
		try
		{
			rootNode = objectMapper.readTree(trama);
			return getNodeReference(nombre, rootNode);
		} catch (IOException e)
		{
			logger.error(ERROR_PARSER + e.getMessage(), e);
		}
		return null;
	}

	public static JsonNode getRootNode(String trama)
	{
		try
		{
			return objectMapper.readTree(trama);
		} catch (IOException e)
		{
			logger.error(ERROR_PARSER + e.getMessage(), e);
		}
		return null;
	}

	public static String getTrama(Object request)
	{
		if (request instanceof String)
		{
			return (String) request;
		} else
		{
			return getJsonStringFromObject(request);
		}
	}

	private static String getJsonStringFromObject(Object request)
	{
		try
		{
			return objectMapper.writeValueAsString(request);
		} catch (IOException e)
		{
			logger.error(ERROR_PARSER + e.getMessage(), e);
		}
		return null;
	}

	public static String getJsonString(JsonNode rootNode)
	{
		try
		{
			return objectMapper.writeValueAsString(rootNode);
		} catch (IOException e)
		{
			logger.error("error al parsear Nodo: " + e.getMessage(), e);
		}
		return StringUtils.EMPTY;
	}

	public static JsonNode getNodeReferenceFixCapitalized(String nombre, JsonNode rootNode)
	{
		JsonNode result = getNodeReference(nombre, rootNode);
		if (result == null)
		{
			result = getNodeReference(StringUtils.capitalize(nombre), rootNode);
		}
		return result;
	}

	public static void eliminarCampos(JsonNode rootNode, String... campos)
	{
		for (String campo : campos)
		{
			((ObjectNode) rootNode).remove(campo);
		}
	}

	public static JsonNode readTree(String content) throws JsonProcessingException, IOException
	{
		return objectMapper.readTree(content);
	}
}
