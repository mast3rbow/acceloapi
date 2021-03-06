package au.com.noojee.acceloapi.progressions;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;

import au.com.noojee.acceloapi.AcceloApi;
import au.com.noojee.acceloapi.AcceloSecret;
import au.com.noojee.acceloapi.EndPoint;
import au.com.noojee.acceloapi.dao.TicketDao;
import au.com.noojee.acceloapi.entities.Ticket;
import au.com.noojee.acceloapi.entities.meta.Ticket_;
import au.com.noojee.acceloapi.filter.AcceloFilter;

public class ProgressDaoTest
{

	@Test
	public void test()
	{
		AcceloSecret secret;
		try
		{
			secret = AcceloSecret.load();
			AcceloApi.getInstance().connect(secret);
			
			
			ProgressDao daoProgression = new ProgressDao();
			
			AcceloFilter<Ticket> filter = new AcceloFilter<>();
			filter.where(filter.eq(Ticket_.id, 17755));
			
			List<Ticket> tickets = new TicketDao().getByFilter(filter);
			
			List<Progression> progressions = daoProgression.getByEndPoint(EndPoint.tickets, tickets.get(0));
			
			for (Progression progression : progressions)
			{
				System.out.println(progression);
			}
			
			daoProgression.triggerProgression(progressions.get(0), tickets.get(0));

		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
