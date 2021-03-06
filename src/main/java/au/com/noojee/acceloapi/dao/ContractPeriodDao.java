package au.com.noojee.acceloapi.dao;

import java.io.IOException;
import java.util.List;

import au.com.noojee.acceloapi.AcceloAbstractResponseList;
import au.com.noojee.acceloapi.AcceloApi;
import au.com.noojee.acceloapi.AcceloException;
import au.com.noojee.acceloapi.AcceloFieldList;
import au.com.noojee.acceloapi.AcceloResponse;
import au.com.noojee.acceloapi.EndPoint;
import au.com.noojee.acceloapi.entities.Contract;
import au.com.noojee.acceloapi.entities.ContractPeriod;
import au.com.noojee.acceloapi.filter.AcceloFilter;

public class ContractPeriodDao extends AcceloDao<ContractPeriod>
{

	public List<ContractPeriod> getByContract(Contract contract) throws AcceloException
	{

		List<ContractPeriod> periods;
		try
		{
			periods = AcceloApi.getInstance().getAll(EndPoint.contracts.getURL(contract.getId(), "/periods"),
					new AcceloFilter<ContractPeriod>(), getFieldList(),
					ResponseList.class);
		}
		catch (IOException e)
		{
			throw new AcceloException(e);
		}

		return periods;

	}

	@Override
	protected AcceloFieldList getFieldList()
	{
		return AcceloFieldList.ALL;
	}

	@Override
	protected EndPoint getEndPoint()
	{
		return EndPoint.contractPeriods;
	}

	@Override
	protected Class<ContractPeriod> getEntityClass()
	{
		return ContractPeriod.class;
	}

	public class Response extends AcceloResponse<ContractPeriod>
	{
		List<ContractPeriod> periods;

		public List<ContractPeriod> getList()
		{
			return periods;
		}

	}

	@Override
	protected Class<ContractPeriodDao.ResponseList> getResponseListClass()
	{
		return ContractPeriodDao.ResponseList.class;
	}

	public class ResponseList extends AcceloAbstractResponseList<ContractPeriod>
	{
		Response response;

		@Override
		public List<ContractPeriod> getList()
		{
			return response.getList();
		}

	}

	@Override
	protected Class<? extends AcceloResponse<ContractPeriod>> getResponseClass()
	{
		return Response.class;
	}

}
