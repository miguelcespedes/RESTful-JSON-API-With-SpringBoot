package com.coolrider.pe.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.coolrider.pe.model.GenericMap;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;

/**
 * <h1>CommonUtil</h1>
 *
 * @author Miguel Céspedes
 * @version 1.0
 * @since february 2021
 */
public class CommonUtil
{
	public static GenericMap toGenericMap(Object obj)
	{

		return new ObjectMapper().convertValue(obj, GenericMap.class);
	}

	public static String getAttributeValue(String key, GenericMap map)
	{
		return new ObjectMapper().convertValue(map, JsonNode.class).findPath(key).asText();
	}

	public static String getMessageID(GenericMap map)
	{
		String messageId = getAttributeValue("messageId", map);
		String message_id = getAttributeValue("message_id", map);

		if (!strIsNull(messageId))
		{
			return messageId;
		} else if (!strIsNull(message_id))
		{
			return message_id;
		} else
		{
			return getTextCurrentDate();
		}

	}
	/*
	 * public static String getOperation(HttpServletRequest servlet) { return servlet.getRequestURI().toLowerCase().replace("/", ""); }
	 */

	public static boolean strIsNull(String str)
	{
		if (str != null && !str.isEmpty())
		{
			return false;
		} else
		{
			return true;
		}

	}

	public static GenericMap easyMap(String key, Object value)
	{
		GenericMap map = new GenericMap();
		map.put(key, value);
		return map;
	}

	/*
	 * public static GenericMap httpToMap(HttpHeaders http) { GenericMap map = new GenericMap(); Iterator<Entry<String, List<String>>> entries = http.entrySet().iterator(); while (entries.hasNext()) { Entry<String, List<String>> entry = entries.next(); String key = entry.getKey();
	 * Object value = entry.getValue().get(0); map.put(key, value); } return map; }
	 */
	public static String MapToString(GenericMap map)
	{
		try
		{
			return new ObjectMapper().writeValueAsString(map);
		} catch (JsonProcessingException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static GenericMap getNodeReference(String nodeName, GenericMap rootNode)
	{
		List<JsonNode> parents = new ObjectMapper().valueToTree(rootNode).findParents(nodeName);
		if (parents != null && !parents.isEmpty())
		{
			Iterator<JsonNode> iterator = parents.iterator();
			while (iterator.hasNext())
			{
				JsonNode parent = iterator.next();
				JsonNode campo = parent.get(nodeName);
				if (campo != null && !(campo instanceof MissingNode) && !(campo instanceof NullNode))
				{
					return new ObjectMapper().convertValue(campo, GenericMap.class);
				}
			}
		}
		return null;
	}

	public static int generateRandomIntIntRange(int min, int max)
	{
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	public static String getCurrentTimeUsingDate()
	{
		Date date = new Date();
		String strDateFormat = "dd/MM/yyyy hh:mm:ss a";
		DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		String formattedDate = dateFormat.format(date);
		return formattedDate;
	}

	public static String getTextCurrentDate()
	{
		Date date = new Date();
		String strDateFormat = "yyyyMMddHHmmss";
		DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		String formattedDate = dateFormat.format(date);
		return formattedDate;
	}

	public static String getSimpleCurrentDate()
	{
		Date date = new Date();
		String strDateFormat = "dd/MM/yyyy";
		DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		String formattedDate = dateFormat.format(date);
		return formattedDate;
	}
}
