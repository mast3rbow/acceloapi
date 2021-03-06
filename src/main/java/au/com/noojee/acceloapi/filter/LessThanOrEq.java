package au.com.noojee.acceloapi.filter;

import au.com.noojee.acceloapi.entities.AcceloEntity;
import au.com.noojee.acceloapi.entities.meta.fieldTypes.FilterField;

class LessThanOrEq<E extends AcceloEntity<E>> extends Expression
{

	private FilterField<E, Object> field;
	private Object operand;

	@SuppressWarnings("unchecked")
	public <T> LessThanOrEq(FilterField<E, T> field, Integer operand)
	{
		this.field = (FilterField<E, Object>) field;
		this.operand = operand;
	}
	
	@SuppressWarnings("unchecked")
	public <T> LessThanOrEq(FilterField<E, T> field, String operand)
	{
		this.field = (FilterField<E, Object>)field;
		this.operand = operand;
	}

	@Override
	public Expression copy()
	{
		LessThanOrEq<E> exp = new LessThanOrEq<E>(this.field, this.operand.toString());
		
		return exp;
	}


	@Override
	public String toJson()
	{
		String json = "\"" + field.getFieldName() + "_less_than_or_equal\" : ";

		json +=  "[" + operand  + "]";

		return json;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((field == null) ? 0 : field.hashCode());
		result = prime * result + ((operand == null) ? 0 : operand.hashCode());
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
		@SuppressWarnings("unchecked")
		LessThanOrEq<E> other = (LessThanOrEq<E>) obj;
		if (field == null)
		{
			if (other.field != null)
				return false;
		}
		else if (!field.equals(other.field))
			return false;
		if (operand == null)
		{
			if (other.operand != null)
				return false;
		}
		else if (!operand.equals(other.operand))
			return false;
		return true;
	}

}