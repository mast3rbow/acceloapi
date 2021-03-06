package au.com.noojee.acceloapi.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import au.com.noojee.acceloapi.entities.types.AgainstType;

class Against extends Expression
{

	private AgainstType type;
	private List<Integer> matchIds = new ArrayList<>();

	public Against(AgainstType type)
	{
		this.type = type;
	}

	public Against(AgainstType type, Integer matchId)
	{
		this.type = type;
		this.matchIds.add(matchId);
	}

	
	public Against(AgainstType type, Integer... matches)
	{
		this.type = type;
		this.matchIds.addAll(Arrays.asList(matches));
	}

	
	@Override
	public Expression copy()
	{
		Against against = new Against(this.type);
		against.matchIds = new ArrayList<Integer>(this.matchIds);
		
		return against;
	}

	@Override
	public String toJson()
	{
		String json = "";
		
		json += "\"against\":[{";

		json += "\"" + type.getName() + "\": [";

		boolean firstOperand = true;
		for (Integer matchId : matchIds)
		{
			if (firstOperand)
				firstOperand = false;
			else
				json += ",";

			json += "\"" + matchId + "\"";
		}
		json += "]}";
		json += "]";

		return json;

	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matchIds == null) ? 0 : matchIds.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Against other = (Against) obj;
		if (matchIds == null)
		{
			if (other.matchIds != null)
				return false;
		}
		else if (!matchIds.equals(other.matchIds))
			return false;
		if (type == null)
		{
			if (other.type != null)
				return false;
		}
		else if (!type.equals(other.type))
			return false;
		return true;
	}
}